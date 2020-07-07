package br.com.passval.controller

import br.com.passval.dto.PasswordValidationDto
import br.com.passval.service.PasswordValidatorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/password")
class PasswordValidationController(val passwordValidatorService: PasswordValidatorService) {

    @PostMapping("validate")
    fun validate(password: String) : ResponseEntity<PasswordValidationDto> {
        val isValid = passwordValidatorService.validate(password)
        return ResponseEntity.ok(isValid)
    }
}