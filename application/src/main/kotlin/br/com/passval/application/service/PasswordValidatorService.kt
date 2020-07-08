package br.com.passval.application.service

import br.com.passval.business.dto.PasswordValidationDto
import br.com.passval.business.validators.PasswordValidator
import org.apache.coyote.http11.Constants.a
import org.springframework.stereotype.Component

@Component
class PasswordValidatorService(
        private val passwordValidators: List<PasswordValidator>
) {

    fun validate(password: String) : PasswordValidationDto {
        passwordValidators.forEach {
            val validation = it.validate(password)
            if (!validation.valid) {
                return PasswordValidationDto(validation.valid, validation.type.msg)
            }
        }
        return PasswordValidationDto(true, null)

    }
}