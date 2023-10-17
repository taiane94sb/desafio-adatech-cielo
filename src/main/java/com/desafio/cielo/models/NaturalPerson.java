package com.desafio.cielo.models;

import com.desafio.cielo.dtos.NaturalPersonDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
    @Size(min = 11, max = 11)
    private String cpf;

    @Size(min = 0, max = 4)
    private String mcc;

    @Size(min = 0, max = 50)
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
