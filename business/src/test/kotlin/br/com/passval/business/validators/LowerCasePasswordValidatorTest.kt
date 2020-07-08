package br.com.passval.business.validators

import br.com.passval.domain.validation.PasswordValidationType
import br.com.passval.business.validators.LowerCasePasswordValidator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LowerCasePasswordValidatorTest {

    @Test
    fun `when password contains just one lower case letter then return true`() {
        val password = "a"
        val validation = LowerCasePasswordValidator().validate(password)
        assertTrue(validation.valid)
        assertEquals(PasswordValidationType.LOWER_CASE_VALIDATION, validation.type)
    }

    @Test
    fun `when password contains a lower case letter then return true`() {
        val password = "AAcA"
        val validation = LowerCasePasswordValidator().validate(password)
        assertTrue(validation.valid)
        assertEquals(PasswordValidationType.LOWER_CASE_VALIDATION, validation.type)
    }

    @Test
    fun `when password does not contain a lower case letter then return false`() {
        val password = "A"
        val validation = LowerCasePasswordValidator().validate(password)
        assertFalse(validation.valid, "Password should have a lower case letter")
        assertEquals(PasswordValidationType.LOWER_CASE_VALIDATION, validation.type)
    }

}