package br.com.passval.validators

import br.com.passval.validation.PasswordValidation
import br.com.passval.validation.PasswordValidationType
import java.util.regex.Pattern

class DigitPasswordValidator: PasswordValidator {

    private companion object {
        val pattern: Pattern = Pattern.compile(".*\\d.*")
    }
    override fun validate(password: String): PasswordValidation {
        val isValid = pattern.matcher(password).matches()
        return PasswordValidation(PasswordValidationType.DIGIT_VALIDATION, isValid)
    }
}