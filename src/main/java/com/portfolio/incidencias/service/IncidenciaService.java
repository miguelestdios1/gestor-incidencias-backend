package com.portfolio.incidencias.service;

import com.portfolio.incidencias.model.Incidencia;
import com.portfolio.incidencias.repository.IncidenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IncidenciaService {

    private final IncidenciaRepository repo;

    public IncidenciaService(IncidenciaRepository repo) {
        this.repo = repo;
    }

    public List<Incidencia> listar() {
        return repo.findAll();
    }

    public Incidencia obtener(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Incidencia crear(Incidencia incidencia) {
        return repo.save(incidencia);
    }
}
