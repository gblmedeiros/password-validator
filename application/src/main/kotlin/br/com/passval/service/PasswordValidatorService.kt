package br.com.passval.service

import br.com.passval.dto.PasswordValidationDto
import br.com.passval.validators.PasswordValidator
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