package com.tp3.persona.servicies;

import com.tp3.persona.entities.Domicilio;
import com.tp3.persona.repositories.BaseRepository;
import com.tp3.persona.repositories.DomicilioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DomicilioServiceImpl extends BaseServiceImpl<Domicilio, Long> implements DomicilioService {
    public DomicilioServiceImpl(DomicilioRepository repository){ super(repository);}
}
