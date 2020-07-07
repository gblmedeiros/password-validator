package br.com.passval.validators

import br.com.passval.validation.PasswordValidation

class RegexPasswordValidator : PasswordValidator {

    override fun validate(password: String): PasswordValidation {
        return PasswordValidation(true, null)
    }
}