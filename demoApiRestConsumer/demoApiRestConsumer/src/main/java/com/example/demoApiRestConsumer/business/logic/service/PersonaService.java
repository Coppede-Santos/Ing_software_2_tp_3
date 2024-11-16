package com.example.demoApiRestConsumer.business.logic.service;

import com.example.demoApiRestConsumer.business.domain.dto.CategoriaDTO;
import com.example.demoApiRestConsumer.business.domain.dto.PersonaDTO;
import com.example.demoApiRestConsumer.business.logic.error.ErrorServiceException;
import com.example.demoApiRestConsumer.business.persistence.rest.PersonaDAORest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService {

    @Autowired
    private PersonaDAORest dao;

    public void validar(String nombre,String apellido, int dni)throws ErrorServiceException {

        try{

            if (nombre == null || nombre.isEmpty()) {
                throw new ErrorServiceException("Debe indicar el nombre");
            }
            if (apellido == null || apellido.isEmpty()) {
                throw new ErrorServiceException("Debe indicar el apellido");
            }
            if (dni == 0) {
                throw new ErrorServiceException("Debe indicar el apellido");
            }

        } catch (ErrorServiceException e) {
            throw e;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new ErrorServiceException("Error de Sistemas");
        }
    }

    public void crearPersona(String nombre, String apellido, int dni) throws ErrorServiceException {

        try {

            validar(nombre, apellido, dni);

            PersonaDTO personaDTO = new PersonaDTO();

            personaDTO.setNombre(nombre);
            personaDTO.setApellido(apellido);
            personaDTO.setDni(dni);
            personaDTO.setEliminado(false);

            dao.crear(personaDTO);

        } catch (ErrorServiceException e) {
            throw e;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new ErrorServiceException("Error de Sistemas");
        }
    }

    public void modificarPersona(Long idPersona, String nombre, String apellido, int dni) throws ErrorServiceException {

        try {

            validar(nombre, apellido, dni);

            PersonaDTO personaDTO = new PersonaDTO();
            personaDTO.setId(idPersona);
            personaDTO.setNombre(nombre);
            personaDTO.setApellido(apellido);
            personaDTO.setDni(dni);
            personaDTO.setEliminado(false);

            dao.actualizar(personaDTO);

        } catch (ErrorServiceException e) {
            throw e;
        } catch (Exception ex){
            ex.printStackTrace();
            throw new ErrorServiceException("Error de Sistemas");
        }
    }

    public PersonaDTO buscarPersona(Long id) throws ErrorServiceException {

        try {

            if (id < 0) {
                throw new ErrorServiceException("El número no puede ser negativo");
            }

            PersonaDTO personaDTO = dao.buscar(id);

            return personaDTO;

        } catch (ErrorServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ErrorServiceException("Error de sistema");
        }
    }

    public void eliminarPersona(Long id) throws ErrorServiceException {

        try {

            if (id == null || id < 0) {
                throw new ErrorServiceException("Debe indicar la persona");
            }

            dao.eliminar(id);

        } catch (ErrorServiceException ex) {
            throw ex;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ErrorServiceException("Error de sistema");
        }

    }

    public List<PersonaDTO> listar() throws ErrorServiceException {
        try {

            return dao.listarPersona();

        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ErrorServiceException("Error de sistema");
        }
    }
}
