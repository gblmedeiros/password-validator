package br.com.passval.business.validators

import br.com.passval.domain.validation.PasswordValidation
import br.com.passval.domain.validation.PasswordValidationType

class NoWhitespacePasswordValidator: PasswordValidator {

    override fun validate(password: String): PasswordValidation {
        val containsWhitespace = password.contains(" ")
        return PasswordValidation(PasswordValidationType.NO_WHITESPACE_VALIDATION, !containsWhitespace)
    }
}