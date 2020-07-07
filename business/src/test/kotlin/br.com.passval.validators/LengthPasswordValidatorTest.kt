package br.com.passval.validators

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class LengthPasswordValidatorTest {

    @Test
    fun `when length greater or equals than min length then return true`() {
        val password = "123456789"
        val validation = LengthPasswordValidator().validate(password)
        assertTrue(validation.isValid)
    }

    @Test
    fun `when length less than min length then return false`() {
        val password = "12345678"
        val validation = LengthPasswordValidator().validate(password)
        assertFalse(validation.isValid, "Password should have more than 9 characters")
        assertNotNull(validation.error)
    }

}