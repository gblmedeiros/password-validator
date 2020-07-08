package br.com.passval.application.controller

import br.com.passval.business.dto.PasswordValidationDto
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.print
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status


@WebMvcTest(PasswordValidationController::class)
class PasswordValidationControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Test
    fun `when password is valid than return true`() {
        val password = "Abc123%th"
        val response = mockMvc.perform(post("/password/validate", password).param("password", password))
                .andDo(print())
                .andExpect(status().isOk)
                .andReturn()
                .response

        val passwordValidationDto = objectMapper.readValue<PasswordValidationDto>(response.contentAsString, PasswordValidationDto::class.java)
        assertTrue(passwordValidationDto.valid)
        assertNull(passwordValidationDto.msg)

    }

    @Test
    fun `when password is not valid than return false`() {
        val password = "bbb"
        val response = mockMvc.perform(post("/password/validate", password).param("password", password))
                .andDo(print())
                .andExpect(status().isOk)
                .andReturn()
                .response

        val passwordValidationDto = objectMapper.readValue<PasswordValidationDto>(response.contentAsString, PasswordValidationDto::class.java)
        assertFalse(passwordValidationDto.valid)
        assertNotNull(passwordValidationDto.msg)

    }
}