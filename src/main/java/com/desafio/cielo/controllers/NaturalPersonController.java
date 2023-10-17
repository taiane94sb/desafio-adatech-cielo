package com.desafio.cielo.controllers;

import com.desafio.cielo.repositories.NaturalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NaturalPersonController {

    @Autowired
    private NaturalPersonRepository repository;
}
