package com.example.demoApiRestConsumer.business.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private int dni;


    private boolean eliminado;
}
