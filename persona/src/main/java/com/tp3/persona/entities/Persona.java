package com.tp3.persona.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "persona")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Persona extends Base {

    @Column(name="nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "dni", unique = true)
    private int dni;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private Domicilio domicilio;

    //Si eliminamos una persona eliminamos todos los libros que le pertenecen
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinTable(
            name = "persona_libro"
            , joinColumns = @JoinColumn(name = "persona_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")

    )
    private List<Libro> libros = new ArrayList<Libro>();

}
