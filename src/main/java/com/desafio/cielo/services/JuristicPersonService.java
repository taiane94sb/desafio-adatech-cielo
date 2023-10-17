package com.desafio.cielo.services;

import com.desafio.cielo.dtos.JuristicPersonDto;
import com.desafio.cielo.dtos.NaturalPersonDto;
import com.desafio.cielo.models.JuristicPerson;
import com.desafio.cielo.models.NaturalPerson;
import com.desafio.cielo.repositories.JuristicPersonRepository;
import com.desafio.cielo.repositories.NaturalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JuristicPersonService {

    @Autowired
    private JuristicPersonRepository repository;

    public JuristicPerson findJuristicPersonById(Long id) throws Exception {
        return this.repository.findJuristicPersonById(id).orElseThrow(() -> new Exception("Juristic person was not found!"));
    }

    public JuristicPerson createJuristicPerson(JuristicPersonDto data) {
        JuristicPerson newJuristicPerson = new JuristicPerson(data);
        this.saveJuristicPerson(newJuristicPerson);
        return newJuristicPerson;
    }

    public List<JuristicPerson> getAllJuristicPersons() {
        return this.repository.findAll();
    }

    public Optional<JuristicPerson> getOneJuristicPerson(Long id) {
        return this.repository.findJuristicPersonById(id);
    }

    public void deleteJuristicPerson(Long id) {

        JuristicPerson juristicPerson = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid juristic person Id:" + id));
        repository.delete(juristicPerson);
    }

    public void saveJuristicPerson(JuristicPerson juristicPerson) {
        this.repository.save(juristicPerson);
    }
}
