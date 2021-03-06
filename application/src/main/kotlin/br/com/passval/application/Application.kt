package br.com.passval.application

import br.com.passval.business.validators.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration

@SpringBootApplication
@Configuration
@ComponentScan
class Application {

    @Bean
    fun passwordValidators(): List<PasswordValidator> {
        return listOf(
                LengthPasswordValidator(),
                DigitPasswordValidator(),
                LowerCasePasswordValidator(),
                UpperCasePasswordValidator(),
                SpecialCharacterPasswordValidator(),
                NoWhitespacePasswordValidator(),
                RepeatedCharacterPasswordValidator()
        )
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}