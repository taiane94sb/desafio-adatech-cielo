package com.desafio.cielo.repositories;

import com.desafio.cielo.dtos.JuristicPersonDto;
import com.desafio.cielo.models.JuristicPerson;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@DataJpaTest
@ActiveProfiles("test")
class JuristicPersonRepositoryTest {

    @Autowired
    JuristicPersonRepository juristicPersonRepository;

    @Autowired
    EntityManager entityManager;

    @Test
    @DisplayName("Should get Juristic Person successfully from database - findJuristicPersonById")
    void findJuristicPersonByIdCase1() {
        JuristicPersonDto data = new JuristicPersonDto("12345678912345", "Begin Again", "1234", "12345678912","Taylor", "taylor@email.com");
        this.createJuristicPerson(data);

        Optional<JuristicPerson> resultJuristicPerson = this.juristicPersonRepository.findJuristicPersonById(any());

        assertThat(data.cnpj()).isEqualTo("12345678912345");
    }

    private JuristicPerson createJuristicPerson(JuristicPersonDto data) {
        JuristicPerson newJuristicPerson = new JuristicPerson(data);
        this.entityManager.persist(newJuristicPerson);
        return newJuristicPerson;
    }
}