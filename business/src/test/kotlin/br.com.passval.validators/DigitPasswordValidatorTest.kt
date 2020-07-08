package br.com.passval.validators

import br.com.passval.validation.PasswordValidationType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DigitPasswordValidatorTest {

    @Test
    fun `when password contains just one digit then return true`() {
        val password = "1"
        val validation = DigitPasswordValidator().validate(password)
        assertTrue(validation.valid)
        assertEquals(PasswordValidationType.DIGIT_VALIDATION, validation.type)
    }

    @Test
    fun `when password contains a digit then return true`() {
        val password = "arfv2ast"
        val validation = DigitPasswordValidator().validate(password)
        assertTrue(validation.valid)
        assertEquals(PasswordValidationType.DIGIT_VALIDATION, validation.type)
    }

    @Test
    fun `when password does not contain a digit then return false`() {
        val password = "a"
        val validation = DigitPasswordValidator().validate(password)
        assertFalse(validation.valid, "Password should have a digit")
        assertEquals(PasswordValidationType.DIGIT_VALIDATION, validation.type)
    }

}