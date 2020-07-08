package br.com.passval.business.validators

import br.com.passval.domain.validation.PasswordValidation
import br.com.passval.domain.validation.PasswordValidationType


class RepeatedCharacterPasswordValidator : PasswordValidator {

    override fun validate(password: String): PasswordValidation {
        val containsRepeatedCharacters = password
                .groupingBy { character -> character }
                .eachCountTo(mutableMapOf())
                .values
                .any { count -> count > 1 }

        return PasswordValidation(PasswordValidationType.REPEATED_CHARACTER_VALIDATION, !containsRepeatedCharacters)
    }
}