package com.example.demoApiRestConsumer.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demoApiRestConsumer.business.domain.dto.PersonaDTO;
import com.example.demoApiRestConsumer.business.logic.error.ErrorServiceException;
import com.example.demoApiRestConsumer.business.logic.service.PersonaService;


@Controller
@RequestMapping("/persona")
public class PersonaController {

    @Autowired
    private PersonaService PersonaService;

    private String viewList= "view/persona/lPersona.html";
    private String redirectList= "redirect:/persona/listPersona";
    private String viewEdit= "view/persona/ePersona.html";


    /////////////////////////////////////////////
    /////////////////////////////////////////////
    ///////////// VIEW: lPersona //////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////

    @GetMapping("/listPersona")
    public String listarPersona(Model model) {
        try {

            List<PersonaDTO> listaPersona = PersonaService.listar();
            model.addAttribute("listaPersona", listaPersona);

        }catch(ErrorServiceException e) {
            model.addAttribute("msgError", e.getMessage());
        }catch(Exception e) {
            e.printStackTrace();
            model.addAttribute("msgError", "Error de Sistema");
        }
        return viewList;
    }

    @GetMapping("/altaPersona")
    public String alta(PersonaDTO Persona, Model model) {

        Persona = new PersonaDTO();
        Persona.setNombre("");
        Persona.setEliminado(false);

        model.addAttribute("Persona", Persona);
        model.addAttribute("isDisabled", false);

        return viewEdit;
    }

    @GetMapping("/consultar")
    public String consultar(@RequestParam(value="id") Long idPersona, Model model) {

        try {

            PersonaDTO Persona = PersonaService.buscarPersona(idPersona);
            model.addAttribute("Persona", Persona);
            model.addAttribute("isDisabled", true);

            return viewEdit;

        }catch(ErrorServiceException e) {
            model.addAttribute("msgError", e.getMessage());
            return viewList;
        }
    }

    @GetMapping("/modificar")
    public String modificar(@RequestParam(value="id") Long idPersona, Model model) {

        try {

            PersonaDTO Persona = PersonaService.buscarPersona(idPersona);
            model.addAttribute("Persona", Persona);
            model.addAttribute("isDisabled", false);

            return viewEdit;

        }catch(ErrorServiceException e) {
            model.addAttribute("msgError", e.getMessage());
            return viewList;
        }
    }

    @GetMapping("/baja")
    public String baja(@RequestParam(value="id") Long idPersona, RedirectAttributes attributes, Model model) {

        try {

            PersonaService.eliminarPersona(idPersona);
            attributes.addFlashAttribute("msgExito", "La acción fue realizada correctamente.");
            return redirectList;

        }catch(ErrorServiceException e) {
            model.addAttribute("msgError", e.getMessage());
            return redirectList;
        }
    }

    /////////////////////////////////////////////
    /////////////////////////////////////////////
    ///////////// VIEW: ePersona //////////////
    /////////////////////////////////////////////
    /////////////////////////////////////////////

    @PostMapping("/aceptarEditPersona")
    public String aceptarEdit(@RequestParam(value="id") Long idPersona, @RequestParam(value="nombre") String nombrePersona, @RequestParam(value="apellido") String apellido, @RequestParam(value = "dni") int dni, RedirectAttributes attributes, Model model){

        try {

            if (idPersona == null )
                PersonaService.crearPersona(nombrePersona,apellido,dni);
            else
                PersonaService.modificarPersona(idPersona, nombrePersona, apellido,dni);

            attributes.addFlashAttribute("msgExito", "La acción fue realizada correctamente.");
            return redirectList;

        }catch(ErrorServiceException e) {
            return error (e.getMessage(), model, Long.valueOf(String.valueOf(idPersona)), nombrePersona);
        }catch(Exception e) {
            return error ("Error de Sistema", model, Long.valueOf(String.valueOf(idPersona)), nombrePersona);
        }

    }

    private String error (String mensaje, Model model, Long id, String nombre) {
        try {

            model.addAttribute("msgError", mensaje);
            if (id != null ) {
                model.addAttribute("Persona", PersonaService.buscarPersona(id));
            }else {
                PersonaDTO Persona = new PersonaDTO();

                Persona.setNombre(nombre);
                model.addAttribute("Persona",Persona);
            }

        }catch(Exception e) {}
        return viewEdit;
    }

    @GetMapping("/cancelarEditNacionalidad")
    public String cancelarEdit() {
        return redirectList;
    }


}

