package br.com.passval.business.validators

import br.com.passval.domain.validation.PasswordValidation

interface PasswordValidator {
    fun validate(password: String): PasswordValidation
}