package br.com.passval.application.controller

import br.com.passval.business.dto.PasswordValidationDto
import br.com.passval.application.service.PasswordValidatorService
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/password")
class PasswordValidationController(val passwordValidatorService: PasswordValidatorService) {

    @PostMapping("validate", consumes = [MediaType.APPLICATION_FORM_URLENCODED_VALUE],
            produces = [MediaType.APPLICATION_JSON_VALUE])
    fun validate(password: Password) : ResponseEntity<PasswordValidationDto> {
        val isValid = passwordValidatorService.validate(password.password)
        return ResponseEntity.ok(isValid)
    }
}

data class Password(val password: String)