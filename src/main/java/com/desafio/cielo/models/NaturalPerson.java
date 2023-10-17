package com.desafio.cielo.models;

import com.desafio.cielo.dtos.NaturalPersonDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "naturalperson")
@Table(name = "naturalperson")
@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class NaturalPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String mcc;

    private String name;

    private String email;

    public NaturalPerson(NaturalPersonDto data) {
        this.cpf = data.cpf();
        this.mcc = data.mcc();
        this.name = data.name();
        this.email = data.email();
    }

    public NaturalPerson() {

    }
}
