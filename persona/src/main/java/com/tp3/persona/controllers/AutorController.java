package com.tp3.persona.controllers;


import com.tp3.persona.entities.Autor;
import com.tp3.persona.repositories.AutorRepository;
import com.tp3.persona.servicies.AutorServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/autores")
public class AutorController extends BaseControllerImpl<Autor, AutorServiceImpl> {

    public AutorController(AutorServiceImpl service) {
        super(service);
    }
}
