package com.desafio.cielo.models;

import com.desafio.cielo.dtos.JuristicPersonDto;
import com.desafio.cielo.dtos.NaturalPersonDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "juridicperson")
@Table(name = "juristicPerson")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class JuristicPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @Size(min = 14, max = 14)
    private String cnpj;

    @Size(min = 0, max = 50)
    private String company_name;

    @Size(min = 0, max = 4)
    private String mcc;

    @Size(min = 11, max = 11)
    private String company_contact_cpf;

    @Size(min = 0, max = 50)
    private String company_contact_name;

    private String company_contact_email;

    public JuristicPerson(JuristicPersonDto data) {
        this.cnpj = data.cnpj();
        this.company_name = data.company_name();
        this.mcc = data.mcc();
        this.company_contact_cpf = data.company_contact_cpf();
        this.company_contact_name = data.company_contact_name();
        this.company_contact_email = data.company_contact_email();
    }

    public JuristicPerson() {

    }
}
