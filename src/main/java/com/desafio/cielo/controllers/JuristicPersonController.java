package com.desafio.cielo.controllers;

import com.desafio.cielo.dtos.JuristicPersonDto;
import com.desafio.cielo.models.JuristicPerson;
import com.desafio.cielo.repositories.JuristicPersonRepository;
import com.desafio.cielo.services.JuristicPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("v1/juristicPerson")
public class JuristicPersonController {

    @Autowired
    private JuristicPersonService juristicPersonService;
    private JuristicPersonRepository juristicPersonRepository;

    // Cadastrar
    @PostMapping
    public ResponseEntity<JuristicPerson> createJuristicPerson(@RequestBody JuristicPersonDto juristicPerson) {
        JuristicPerson newJuristicPerson = juristicPersonService.createJuristicPerson(juristicPerson);
        return new ResponseEntity<>(newJuristicPerson, HttpStatus.CREATED);
    }

    // Consultar todos
    @GetMapping
    public ResponseEntity<List<JuristicPerson>> getAllJuristicPersons() {
        List<JuristicPerson> juristicPersons = this.juristicPersonService.getAllJuristicPersons();
        return new ResponseEntity<>(juristicPersons, HttpStatus.OK);
    }

    // Consultar um
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneJuristicPerson(@PathVariable(value = "id") Long id) {
        Optional<JuristicPerson> juristicPerson = this.juristicPersonService.getOneJuristicPerson(id);

        if (juristicPerson.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Juristic Person was not found.");
        } else {
            return new ResponseEntity<>(juristicPerson, HttpStatus.OK);
        }
    }

    // Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteJuristicPerson(@PathVariable(value = "id") Long id) {
        juristicPersonService.deleteJuristicPerson(id);
        return ResponseEntity.status(HttpStatus.OK).body("Juristic Person deleted.");
    }
}
