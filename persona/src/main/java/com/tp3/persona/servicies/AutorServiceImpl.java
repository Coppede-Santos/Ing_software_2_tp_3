package com.tp3.persona.servicies;

import com.tp3.persona.entities.Autor;
import com.tp3.persona.repositories.AutorRepository;
import org.springframework.stereotype.Service;


@Service
public class AutorServiceImpl extends BaseServiceImpl<Autor,Long> implements AutorService{

    public AutorServiceImpl(AutorRepository repository) {super(repository);}
}
