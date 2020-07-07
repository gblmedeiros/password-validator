package br.com.passval.service

import br.com.passval.dto.PasswordValidationDto
import br.com.passval.validators.PasswordValidator
import org.springframework.stereotype.Component

@Component
class PasswordValidatorService(
        private val validators: List<PasswordValidator>
) {

    fun validate(password: String) : PasswordValidationDto {
        val validationNotValid = validators
                .map { it.validate(password) }
                .firstOrNull { !it.isValid }

        val isValid = validationNotValid?.isValid ?: true
        return PasswordValidationDto(isValid, validationNotValid?.error?.msg)
    }
}