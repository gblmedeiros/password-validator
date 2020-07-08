package br.com.passval.validators

import br.com.passval.validation.PasswordValidationType
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class UpperCasePasswordValidatorTest {

    @Test
    fun `when password contains just one upper case letter then return true`() {
        val password = "A"
        val validation = UpperCasePasswordValidator().validate(password)
        assertTrue(validation.valid)
        assertEquals(PasswordValidationType.UPPER_CASE_VALIDATION, validation.type)
    }

    @Test
    fun `when password contains a lower case letter then return true`() {
        val password = "aaCa"
        val validation = UpperCasePasswordValidator().validate(password)
        assertTrue(validation.valid)
        assertEquals(PasswordValidationType.UPPER_CASE_VALIDATION, validation.type)
    }

    @Test
    fun `when password does not contain a lower case letter then return false`() {
        val password = "a"
        val validation = UpperCasePasswordValidator().validate(password)
        assertFalse(validation.valid, "Password should have a upper case letter")
        assertEquals(PasswordValidationType.UPPER_CASE_VALIDATION, validation.type)
    }

}