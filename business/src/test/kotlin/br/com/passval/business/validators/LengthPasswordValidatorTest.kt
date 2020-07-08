package br.com.passval.business.validators

import br.com.passval.domain.validation.PasswordValidationType
import br.com.passval.business.validators.LengthPasswordValidator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LengthPasswordValidatorTest {

    @Test
    fun `when length greater or equals than min length then return true`() {
        val password = "123456789"
        val validation = LengthPasswordValidator().validate(password)
        assertTrue(validation.valid)
        assertEquals(PasswordValidationType.LENGTH_VALIDATION, validation.type)
    }

    @Test
    fun `when length less than min length then return false`() {
        val password = "12345678"
        val validation = LengthPasswordValidator().validate(password)
        assertFalse(validation.valid, "Password should have more than 9 characters")
        assertEquals(PasswordValidationType.LENGTH_VALIDATION, validation.type)
    }

}