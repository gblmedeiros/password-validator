package br.com.passval.business.dto

data class PasswordValidationDto(
        val valid: Boolean,
        val msg: String?
)