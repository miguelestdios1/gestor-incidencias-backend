package com.portfolio.incidencias.controller;

import com.portfolio.incidencias.model.Incidencia;
import com.portfolio.incidencias.repository.IncidenciaRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incidencias")
@CrossOrigin(origins = "*")
public class IncidenciaController {

    private final IncidenciaRepository repo;

    public IncidenciaController(IncidenciaRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Incidencia> listar() {
        return repo.findAll();
    }

    @PostMapping
    public Incidencia crear(@RequestBody Incidencia incidencia) {
        return repo.save(incidencia);
    }

    @GetMapping("/{id}")
    public Incidencia obtener(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Incidencia actualizar(@PathVariable Long id, @RequestBody Incidencia datos) {
        Incidencia inc = repo.findById(id).orElseThrow();
        inc.setTitulo(datos.getTitulo());
        inc.setDescripcion(datos.getDescripcion());
        inc.setEstado(datos.getEstado());
        return repo.save(inc);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
