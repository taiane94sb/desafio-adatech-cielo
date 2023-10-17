package com.desafio.cielo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

    public record NaturalPersonDto(@NotBlank(message = "CPF is mandatory") String cpf, @NotBlank(message = "MCC is mandatory") String mcc, @NotBlank(message = "Name is mandatory") String name, @Email String email) {
}
