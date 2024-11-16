package com.tp3.persona.servicies;

import com.tp3.persona.entities.Persona;
import com.tp3.persona.repositories.BaseRepository;
import com.tp3.persona.repositories.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PersonaServiceImpl extends BaseServiceImpl<Persona,Long> implements PersonaService {

    private final PersonaRepository personaRepository;

    public PersonaServiceImpl(PersonaRepository baserepository, PersonaRepository personaRepository) {super(baserepository);
        this.personaRepository = personaRepository;
    }


    @Override
    public List<Persona> search(String filtro) throws Exception {
        try {
            ///List<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro);
            //List<Persona> personas = personaRepository.search(filtro);
            List<Persona> personas = personaRepository.searchNativo(filtro);
            return personas;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

   // @Override
    //public Page<Persona> search(String filtro, Pageable pageable) throws Exception {
   //     try {
   //         ///Page<Persona> personas = personaRepository.findByNombreContainingOrApellidoContaining(filtro, filtro, pageable);
   //         //Page<Persona> personas = personaRepository.search(filtro, pageable);
   //         Page<Persona> personas = personaRepository.searchNativo(filtro, pageable);
   //         return personas;
   //     }catch (Exception e){
   //         throw new Exception(e.getMessage());
   //     }
   // }
}
