package br.com.passval.domain.validation

data class PasswordValidation(
        val type: PasswordValidationType,
        val valid: Boolean
)