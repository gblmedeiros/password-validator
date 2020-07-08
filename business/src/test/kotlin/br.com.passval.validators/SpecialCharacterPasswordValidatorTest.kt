package br.com.passval.validators

import br.com.passval.validation.PasswordValidationType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SpecialCharacterPasswordValidatorTest {

    companion object {
        @JvmStatic
        fun passwords(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of("%",  true),
                    Arguments.of("qqww2233#", true),
                    Arguments.of("qqww2233\\", true),
                    Arguments.of("AbTp9 fok", false),
                    Arguments.of(" AbTp9fok", false),
                    Arguments.of("AbTp9fok      ", false),
                    Arguments.of("AbTp9fok      G", false),
                    Arguments.of("AbTp9fok      G*", false)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("passwords")
    fun `validate passwords with special characters`(password: String, expected: Boolean) {
        val validation = SpecialCharacterPasswordValidator().validate(password)
        assertEquals(expected, validation.valid)
        assertEquals(PasswordValidationType.SPECIAL_CHARACTER_VALIDATION, validation.type)
    }

}