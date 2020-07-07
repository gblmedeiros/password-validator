package br.com.passval.validators

import br.com.passval.validation.PasswordValidation

interface PasswordValidator {
    fun validate(password: String): PasswordValidation
}