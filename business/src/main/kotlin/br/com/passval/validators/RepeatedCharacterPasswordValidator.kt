package br.com.passval.validators

import br.com.passval.validation.PasswordValidation
import br.com.passval.validation.PasswordValidationType


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