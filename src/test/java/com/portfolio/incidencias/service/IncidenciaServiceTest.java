package com.portfolio.incidencias.service;

import com.portfolio.incidencias.model.Incidencia;
import com.portfolio.incidencias.repository.IncidenciaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class IncidenciaServiceTest {

    private IncidenciaRepository repo;
    private IncidenciaService service;

    @BeforeEach
    void setUp() {
        repo = Mockito.mock(IncidenciaRepository.class);
        service = new IncidenciaService(repo);
    }

    @Test
    void testListarIncidencias() {
        when(repo.findAll()).thenReturn(Arrays.asList(
                new Incidencia("Error en login", "No funciona login"),
                new Incidencia("Bug en dashboard", "Gráficos rotos")
        ));

        List<Incidencia> incidencias = service.listar();

        assertEquals(2, incidencias.size());
        verify(repo, times(1)).findAll();
    }

    @Test
    void testObtenerIncidencia() {
        Incidencia inc = new Incidencia("Error API", "Falla conexión");
        when(repo.findById(1L)).thenReturn(Optional.of(inc));

        Incidencia result = service.obtener(1L);

        assertEquals("Error API", result.getTitulo());
        verify(repo, times(1)).findById(1L);
    }
}
