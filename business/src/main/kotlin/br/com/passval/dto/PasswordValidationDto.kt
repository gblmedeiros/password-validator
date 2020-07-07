package br.com.passval.dto

data class PasswordValidationDto(
        val valid: Boolean,
        val msg: String?
)