package com.desafio.cielo.services;

import com.desafio.cielo.dtos.NaturalPersonDto;
import com.desafio.cielo.models.NaturalPerson;
import com.desafio.cielo.repositories.NaturalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NaturalPersonService {

    @Autowired
    private NaturalPersonRepository repository;

    public NaturalPerson createNaturalPerson(NaturalPersonDto data) {
        NaturalPerson newNaturalPerson = new NaturalPerson(data);
        this.saveNaturalPerson(newNaturalPerson);
        return newNaturalPerson;
    }

    public List<NaturalPerson> getAllNaturalPersons() {
        return this.repository.findAll();
    }

    public Optional<NaturalPerson> getOneNaturalPerson(Long id) {
        return this.repository.findNaturalPersonById(id);
    }

    public void deleteNaturalPerson(Long id) {

        NaturalPerson naturalPersonBy = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid natural person Id:" + id));
        repository.delete(naturalPersonBy);
    }

    public void saveNaturalPerson(NaturalPerson naturalPerson) {
        this.repository.save(naturalPerson);
    }
}
