package com.tp3.persona.repositories;


import com.tp3.persona.entities.Libro;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends BaseRepository<Libro, Long> {
}
