package br.com.passval.validators

import br.com.passval.validation.PasswordValidation
import br.com.passval.validation.exception.PasswordValidationException
import org.springframework.stereotype.Component

@Component
class LengthPasswordValidator: PasswordValidator {
    private companion object {
        const val MIN_LENGTH = 9
    }

    override fun validate(password: String): PasswordValidation {
        val isValid = password.length >= MIN_LENGTH
        val exception = if (!isValid) PasswordValidationException("Password should have more than 9 characters") else null
        return PasswordValidation(isValid, exception)
    }
}