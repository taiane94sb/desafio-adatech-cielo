package com.desafio.cielo.repositories;

import com.desafio.cielo.models.NaturalPersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface NaturalPersonRepository extends JpaRepository<NaturalPersonModel, UUID> {
}
