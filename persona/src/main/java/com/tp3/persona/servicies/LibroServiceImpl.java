package com.tp3.persona.servicies;

import com.tp3.persona.entities.Libro;
import com.tp3.persona.repositories.BaseRepository;
import com.tp3.persona.repositories.LibroRepository;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl extends BaseServiceImpl<Libro, Long> implements LibroService {
   public LibroServiceImpl(LibroRepository repository) {super(repository);}
}
