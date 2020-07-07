package br.com.passval.validation

import br.com.passval.validation.exception.PasswordValidationException

data class PasswordValidation(
        val isValid: Boolean,
        val error: PasswordValidationException? = null
)