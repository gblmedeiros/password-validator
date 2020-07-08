package br.com.passval.business.validators

import br.com.passval.domain.validation.PasswordValidation
import br.com.passval.domain.validation.PasswordValidationType
import java.util.regex.Pattern

class LowerCasePasswordValidator: PasswordValidator {

    private companion object {
        val pattern: Pattern = Pattern.compile(".*[a-z].*")
    }
    override fun validate(password: String): PasswordValidation {
        val isValid = pattern.matcher(password).matches()
        return PasswordValidation(PasswordValidationType.LOWER_CASE_VALIDATION, isValid)
    }
}