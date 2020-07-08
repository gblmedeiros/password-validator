package br.com.passval.service

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.stream.Stream
import kotlin.test.assertEquals

@SpringBootTest
class PasswordValidatorServiceTest {

    @Autowired
    private lateinit var passwordValidatorService: PasswordValidatorService

    companion object {
        @JvmStatic
        fun passwords(): Stream<Arguments> {
            return Stream.of(
                    Arguments.of("", false),
                    Arguments.of("aa", false),
                    Arguments.of("ab", false),
                    Arguments.of("AAAbbbCc", false),
                    Arguments.of("AbTp9!foo", false),
                    Arguments.of("AbTp9!foA", false),
                    Arguments.of("AbTp9 fok", false),
                    Arguments.of("AbTp9!fok", true)
            )
        }
    }

    @ParameterizedTest
    @MethodSource("passwords")
    fun `should validate password`(password: String, expected: Boolean) {
        assertEquals(expected, passwordValidatorService.validate(password).valid)
    }
}