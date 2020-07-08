package br.com.passval.application.service

import br.com.passval.business.dto.PasswordValidationDto
import br.com.passval.business.validators.PasswordValidator
import org.springframework.stereotype.Component

@Component
class PasswordValidatorService(
        private val passwordValidators: List<PasswordValidator>
) {

    fun validate(password: String) : PasswordValidationDto {
        val validationNotValid = passwordValidators
                .map { it.validate(password) }
                .firstOrNull { !it.valid }

        val isValid = validationNotValid?.valid?: true
        val validation = validationNotValid?.type?.msg
        return PasswordValidationDto(isValid, validation)
    }
}