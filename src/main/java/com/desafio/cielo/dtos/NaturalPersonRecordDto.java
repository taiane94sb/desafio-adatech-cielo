package com.desafio.cielo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record NaturalPersonRecordDto(@NotBlank String cpf, @NotNull String mcc, @NotNull String name, @NotNull String email) {
}
