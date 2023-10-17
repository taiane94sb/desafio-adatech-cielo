package com.desafio.cielo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NaturalPersonDto(String cpf, String mcc, String name, String email) {
}
