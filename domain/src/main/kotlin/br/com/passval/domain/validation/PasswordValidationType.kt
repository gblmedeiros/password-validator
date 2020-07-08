package br.com.passval.domain.validation

enum class PasswordValidationType(val msg: String) {

    LENGTH_VALIDATION("Nove ou mais caracteres"),
    DIGIT_VALIDATION("Ao menos 1 dígito"),
    LOWER_CASE_VALIDATION("Ao menos 1 letra minúscula"),
    UPPER_CASE_VALIDATION("Ao menos 1 letra maiúscula"),
    SPECIAL_CHARACTER_VALIDATION("Ao menos 1 caractere especial"),
    REPEATED_CHARACTER_VALIDATION("Não possuir caracteres repetidos dentro do conjunto"),
    NO_WHITESPACE_VALIDATION("Não possuir espaços em branco")

}