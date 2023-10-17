package com.desafio.cielo.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record JuristicPersonDto(@NotBlank(message = "CNPJ is mandatory") String cnpj, @NotBlank(message = "Company name is mandatory") String company_name, @NotBlank(message = "MCC is mandatory") String mcc, @NotBlank(message = "Company contact name is mandatory") String company_contact_cpf, @NotBlank(message = "Company contact name is mandatory") String company_contact_name, @Email String company_contact_email) {
}
