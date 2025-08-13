package com.portfolio.incidencias.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.portfolio.incidencias.model.Incidencia;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = com.portfolio.incidencias.GestorIncidenciasApplication.class)
@org.springframework.test.context.ActiveProfiles("test")
@org.springframework.test.context.TestPropertySource(locations = "classpath:application-test.properties")
@AutoConfigureMockMvc
class IncidenciaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testCrearIncidencia() throws Exception {
        Incidencia inc = new Incidencia("Prueba API", "Descripción de prueba");

        mockMvc.perform(post("/api/incidencias")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(inc)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.titulo").value("Prueba API"));
    }

    @Test
    void testListarIncidencias() throws Exception {
        mockMvc.perform(get("/api/incidencias"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
