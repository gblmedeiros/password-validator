package br.com.passval.business.validators

import br.com.passval.domain.validation.PasswordValidation
import br.com.passval.domain.validation.PasswordValidationType
import java.util.regex.Pattern

class SpecialCharacterPasswordValidator: PasswordValidator {

    private companion object {
        val pattern: Pattern = Pattern.compile(".*[*!@#$%^&(){}\\[\\]:;<>,.?/~_+\\-=|\\\\].*")
    }
    override fun validate(password: String): PasswordValidation {
        val isValid = pattern.matcher(password).matches()
        return PasswordValidation(PasswordValidationType.SPECIAL_CHARACTER_VALIDATION, isValid)
    }
}