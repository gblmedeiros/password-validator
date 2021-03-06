package br.com.passval.business.validators

import br.com.passval.domain.validation.PasswordValidation
import br.com.passval.domain.validation.PasswordValidationType

class LengthPasswordValidator: PasswordValidator {
    private companion object {
        const val MIN_LENGTH = 9
    }

    override fun validate(password: String): PasswordValidation {
        val isValid = password.length >= MIN_LENGTH
        return PasswordValidation(PasswordValidationType.LENGTH_VALIDATION, isValid)
    }
}