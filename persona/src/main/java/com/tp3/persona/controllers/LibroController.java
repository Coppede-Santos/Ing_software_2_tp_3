package com.tp3.persona.controllers;

import com.tp3.persona.entities.Libro;
import com.tp3.persona.servicies.LibroServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("api/v1/libro")
public class LibroController extends BaseControllerImpl<Libro, LibroServiceImpl> {
    public LibroController(LibroServiceImpl service) {super(service);}
}
