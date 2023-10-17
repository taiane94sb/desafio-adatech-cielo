package com.desafio.cielo.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_NATURAL_PERSON")
public class NaturalPersonModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idNaturalPerson;

    @Column(unique = true)
    private String cpf;

    private String mcc;

    private String name;

    private String email;

    public UUID getIdNaturalPerson() {
        return idNaturalPerson;
    }

    public void setIdNaturalPerson(UUID idNaturalPerson) {
        this.idNaturalPerson = idNaturalPerson;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMcc() {
        return mcc;
    }

    public void setMcc(String mcc) {
        this.mcc = mcc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
