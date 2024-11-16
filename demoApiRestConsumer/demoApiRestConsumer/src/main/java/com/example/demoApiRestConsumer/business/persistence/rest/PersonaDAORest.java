package com.example.demoApiRestConsumer.business.persistence.rest;

import com.example.demoApiRestConsumer.business.domain.dto.CategoriaDTO;
import com.example.demoApiRestConsumer.business.domain.dto.PersonaDTO;
import com.example.demoApiRestConsumer.business.logic.error.ErrorServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class PersonaDAORest {

    @Autowired
    private RestTemplate restTemplate;

    public void crear(PersonaDTO personaDTO)throws ErrorServiceException {

        try {

            String uri = "http://localhost:9000/api/v1/persona";
            restTemplate.postForEntity(uri, personaDTO, PersonaDTO.class);

        } catch (Exception ex){
            ex.printStackTrace();
            throw new ErrorServiceException("Error de Sistemas");
        }
    }

    public void actualizar(PersonaDTO personaDTO) throws ErrorServiceException {

        try {

            String uri = "http://localhost:9000/api/v1/persona/"+ personaDTO.getId();
            restTemplate.put(uri, personaDTO);

        } catch (Exception ex){
            ex.printStackTrace();
            throw new ErrorServiceException("Error de Sistemas");
        }
    }

    public void eliminar(Long id)  throws ErrorServiceException {

        try {

            String uri = "http://localhost:9000/api/v1/persona/" + id;
            restTemplate.delete(uri);

        } catch (Exception ex){
            ex.printStackTrace();
            throw new ErrorServiceException("Error de Sistemas");
        }
    }

    public PersonaDTO buscar(Long id)  throws ErrorServiceException {

        try {

            String uri = "http://localhost:9000/api/v1/persona/" + id;

            ResponseEntity<PersonaDTO> response = restTemplate.getForEntity(uri,PersonaDTO.class);
            PersonaDTO personaDTO = response.getBody();

            return  personaDTO;

        } catch (Exception ex){
            ex.printStackTrace();
            throw new ErrorServiceException("Error de Sistemas");
        }
    }

    public List<PersonaDTO> listarPersona() throws ErrorServiceException {

        try {

            String uri="http://localhost:9000/api/v1/personas";

            ResponseEntity<PersonaDTO[]> response = restTemplate.getForEntity(uri,PersonaDTO[].class);
            PersonaDTO[] personaDTOS = response.getBody();
            List<PersonaDTO> m = Arrays.asList(personaDTOS);

            return  m;

        } catch (Exception ex){
            ex.printStackTrace();
            throw new ErrorServiceException("Error de Sistemas");
        }
    }
}
