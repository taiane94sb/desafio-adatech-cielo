package com.desafio.cielo.models;

import com.desafio.cielo.dtos.JuristicPersonDto;
import com.desafio.cielo.dtos.NaturalPersonDto;
import jakarta.persistence.*;
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
    private String cnpj;

    private String company_name;

    private String mcc;

    private String company_contact_cpf;

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
