package com.desafio.cielo.services;

import com.desafio.cielo.repositories.NaturalPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NaturalPersonService {

    @Autowired
    private NaturalPersonRepository repository;
}
