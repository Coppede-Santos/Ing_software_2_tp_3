package com.tp3.persona.controllers;

import com.tp3.persona.entities.Domicilio;
import com.tp3.persona.servicies.DomicilioServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/domicilio")

public class DomicilioController extends BaseControllerImpl<Domicilio, DomicilioServiceImpl>{

    public DomicilioController(DomicilioServiceImpl service) {super(service);}
}
