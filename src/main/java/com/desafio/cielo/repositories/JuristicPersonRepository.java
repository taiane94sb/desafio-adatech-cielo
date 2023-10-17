package com.desafio.cielo.repositories;

import com.desafio.cielo.models.JuristicPerson;
import com.desafio.cielo.models.NaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JuristicPersonRepository extends JpaRepository<JuristicPerson, Long> {
    Optional<JuristicPerson> findJuristicPersonByCnpj(String cnpj);
    Optional<JuristicPerson> findJuristicPersonById(Long id);
}
