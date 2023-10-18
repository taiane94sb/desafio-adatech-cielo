package com.desafio.cielo.repositories;

import com.desafio.cielo.dtos.NaturalPersonDto;
import com.desafio.cielo.models.NaturalPerson;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

import java.util.Optional;


@DataJpaTest
@ActiveProfiles("test")
class NaturalPersonRepositoryTest {

    @Autowired
    NaturalPersonRepository naturalPersonRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get Natural Person successfully from database - findNaturalPersonByCpf")
    void findNaturalPersonByCpfCase1() {
        String cpf = "12345678912";
        NaturalPersonDto data = new NaturalPersonDto(cpf, "1234", "Taylor", "taylor@email.com");
        this.createNaturalPerson(data);

        Optional<NaturalPerson> resultNaturalPerson = this.naturalPersonRepository.findNaturalPersonByCpf(cpf);

        assertThat(resultNaturalPerson.isPresent()).isTrue();
    }

    @Test
    @DisplayName("Should not get Natural Person successfully from database - findNaturalPersonByCpf")
    void findNaturalPersonByCpfCase2() {
        String cpf = "12345678912";
        NaturalPersonDto data = new NaturalPersonDto(cpf, "1234", "Taylor", "taylor@email.com");

        Optional<NaturalPerson> resultNaturalPerson = this.naturalPersonRepository.findNaturalPersonByCpf(cpf);

        assertThat(resultNaturalPerson.isEmpty()).isTrue();
    }

    @Test
    @DisplayName("Should get Natural Person successfully from database - findNaturalPersonById")
    void findNaturalPersonByIdCase1() {
        String cpf = "12345678912";
        NaturalPersonDto data = new NaturalPersonDto(cpf, "1234", "Taylor", "taylor@email.com");
        this.createNaturalPerson(data);

        Optional<NaturalPerson> resultNaturalPerson = this.naturalPersonRepository.findNaturalPersonById(any());

        assertThat(data.cpf()).isEqualTo(cpf);
    }

    private NaturalPerson createNaturalPerson(NaturalPersonDto data) {
        NaturalPerson newNaturalPerson = new NaturalPerson(data);
        this.entityManager.persist(newNaturalPerson);
        return newNaturalPerson;
    }
}