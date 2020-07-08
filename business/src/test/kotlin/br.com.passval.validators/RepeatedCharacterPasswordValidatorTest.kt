package br.com.passval.validators

import br.com.passval.validation.PasswordValidationType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RepeatedCharacterPasswordValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = ["ab", "abCd", "ab%c#", "AbTp9!fok"])
    fun `when password does not contain repeated character then return true`(password: String) {
        val validation = RepeatedCharacterPasswordValidator().validate(password)
        assertTrue(validation.valid)
        assertEquals(PasswordValidationType.REPEATED_CHARACTER_VALIDATION, validation.type)
    }

    @ParameterizedTest
    @ValueSource(strings = ["aa", "abAA", "ab#c#", "AbTp9!foA"])
    fun `when password contains repeated character then return false`(password: String) {
        val validation = RepeatedCharacterPasswordValidator().validate(password)
        assertFalse(validation.valid, "Password should not have repeated characters")
        assertEquals(PasswordValidationType.REPEATED_CHARACTER_VALIDATION, validation.type)
    }

}