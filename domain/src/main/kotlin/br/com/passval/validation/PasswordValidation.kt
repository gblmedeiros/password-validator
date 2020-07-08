package br.com.passval.validation

data class PasswordValidation(
        val type: PasswordValidationType,
        val valid: Boolean
)