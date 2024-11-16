package com.tp3.persona.repositories;

import com.tp3.persona.entities.Persona;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepository extends BaseRepository<Persona, Long> {


    List<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido);

    //Page<Persona> findByNombreContainingOrApellidoContaining(String nombre, String apellido, Pageable pageable);

    //boolean existsByDni(int dni);

    //JPQL
    //%?1% indica el parametro numero 1
    //@Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    //Page<Persona> search(String filtro);

    @Query(value = "SELECT p FROM Persona p WHERE p.nombre LIKE %?1% OR p.apellido LIKE %?1%")
    List<Persona> search(String filtro, Pageable pageable);

    @Query(
            value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
            nativeQuery = true
    )
    List<Persona> searchNativo(@Param("filtro")String filtro);

    //@Query(
    //        value = "SELECT * FROM persona WHERE persona.nombre LIKE %:filtro% OR persona.apellido LIKE %:filtro%",
    //        countQuery = "SELECT count(*) FROM persona",
    //        nativeQuery = true
    //)
    //Page<Persona> searchNativo(@Param("filtro")String filtro, Pageable pageable);
}
