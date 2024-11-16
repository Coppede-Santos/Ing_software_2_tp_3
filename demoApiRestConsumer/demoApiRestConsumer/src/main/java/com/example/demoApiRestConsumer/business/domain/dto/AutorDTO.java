package com.example.demoApiRestConsumer.business.domain.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String descripcion;
}
