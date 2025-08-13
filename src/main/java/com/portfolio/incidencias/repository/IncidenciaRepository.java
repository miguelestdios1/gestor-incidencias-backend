package com.portfolio.incidencias.repository;

import com.portfolio.incidencias.model.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidenciaRepository extends JpaRepository<Incidencia, Long> {
}
