package com.tp3.persona.servicies;

import com.tp3.persona.entities.Localidad;
import com.tp3.persona.repositories.BaseRepository;
import com.tp3.persona.repositories.LocalidadRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocalidadServiceImpl extends BaseServiceImpl<Localidad, Long> implements LocalidadService {
    public LocalidadServiceImpl(LocalidadRepository repository) {super(repository);}

}
