package br.com.passval.validators

import br.com.passval.validation.PasswordValidation
import br.com.passval.validation.PasswordValidationType

class NoWhitespacePasswordValidator: PasswordValidator {

    override fun validate(password: String): PasswordValidation {
        val containsWhitespace = password.contains(" ")
        return PasswordValidation(PasswordValidationType.NO_WHITESPACE_VALIDATION, !containsWhitespace)
    }
}