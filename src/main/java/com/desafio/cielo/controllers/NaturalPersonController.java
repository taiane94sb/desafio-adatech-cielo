package com.desafio.cielo.controllers;

import com.desafio.cielo.dtos.NaturalPersonDto;
import com.desafio.cielo.models.NaturalPerson;
import com.desafio.cielo.repositories.NaturalPersonRepository;
import com.desafio.cielo.services.NaturalPersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/naturalPerson")
public class NaturalPersonController {

    @Autowired
    private NaturalPersonService naturalPersonService;
    private NaturalPersonRepository naturalPersonRepository;

    // Cadastrar
    @PostMapping
    public ResponseEntity<NaturalPerson> createNaturalPerson(@Valid @RequestBody NaturalPersonDto naturalPerson) {
        NaturalPerson newNaturalPerson = naturalPersonService.createNaturalPerson(naturalPerson);
        return new ResponseEntity<>(newNaturalPerson, HttpStatus.CREATED);
    }

    // Consultar todos
    @GetMapping
    public ResponseEntity<List<NaturalPerson>> getAllNaturalPersons() {
        List<NaturalPerson> naturalPersons = this.naturalPersonService.getAllNaturalPersons();
        return new ResponseEntity<>(naturalPersons, HttpStatus.OK);
    }

    // Consultar um
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneNaturalPerson(@PathVariable(value = "id") Long id) {
        Optional<NaturalPerson> naturalPerson = this.naturalPersonService.getOneNaturalPerson(id);

        if (naturalPerson.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Natural Person was not found.");
        } else {
            return new ResponseEntity<>(naturalPerson, HttpStatus.OK);
        }
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteNaturalPerson(@PathVariable(value = "id") Long id) {
        naturalPersonService.deleteNaturalPerson(id);
        return ResponseEntity.status(HttpStatus.OK).body("Natural Person deleted.");
    }
}
