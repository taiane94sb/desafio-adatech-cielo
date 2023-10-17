package com.desafio.cielo.repositories;

import com.desafio.cielo.models.NaturalPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, Long> {
    Optional<NaturalPerson> findNaturalPersonByCpf(String cfp);
    Optional<NaturalPerson> findNaturalPersonById(Long id);
}
