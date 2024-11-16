package com.tp3.persona.controllers;


import com.tp3.persona.entities.Persona;
import com.tp3.persona.servicies.PersonaServiceImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(path = "api/v1/personas")
public class PersonaController extends BaseControllerImpl<Persona, PersonaServiceImpl> {

    public PersonaController(PersonaServiceImpl service) {
        super(service);
    }

    @GetMapping("/search")
    public ResponseEntity<?> searchPersona(@RequestParam String filtro) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.search(filtro));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+e.getMessage()+"\"}");
        }
    }

    //@GetMapping("/searchPaged")
    //public ResponseEntity<?> searchPersona(@RequestParam String filtro, Pageable pageable) {
    //    try {
    //        return ResponseEntity.status(HttpStatus.OK).body(service.search(filtro, pageable));
    //    }catch (Exception e) {
    //        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"error\":\""+e.getMessage()+"\"}");
    //    }
    //}
}
