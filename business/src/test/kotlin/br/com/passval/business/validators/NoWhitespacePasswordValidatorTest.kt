package br.com.passval.business.validators

import br.com.passval.domain.validation.PasswordValidationType
import br.com.passval.business.validators.NoWhitespacePasswordValidator
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class NoWhitespacePasswordValidatorTest {

    companion object {
        @JvmStatic
        fun passwords(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of("%",  true),
                    Arguments.of("qqww2233#", true),
                    Arguments.of("AbTp9fok      ", false),
                    Arguments.of("*AbTp9 fok", false),
                    Arguments.of("AbTp9fok* ", false),
                    Arguments.of(" AbTp9fok", false)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("passwords")
    fun `validate passwords with whitespace`(password: String, expected: Boolean) {
        val validation = NoWhitespacePasswordValidator().validate(password)
        assertEquals(expected, validation.valid)
        assertEquals(PasswordValidationType.NO_WHITESPACE_VALIDATION, validation.type)
    }

}