package com.example.demoApiRestConsumer.business.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LibroDTO {
    private String titulo;

    private int fecha;

    private String genero;

    private int paginas;
}
