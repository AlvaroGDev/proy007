package es.cic.curso25.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.cic.curso25.model.Tarea;
import es.cic.curso25.repository.TareaRepository;

@SpringBootTest
@AutoConfigureMockMvc
public class TareaControllerIntegrationTests {

    @Autowired
    MockMvc mockMvc; // MockMVC es una herramienta de testing para simular peticiones http a los
                     // controladores sin servidor real

    @Autowired
    ObjectMapper objectMapper; // Permite pasar de clase java a JSON y de JSON a clase java

    @Autowired
    TareaRepository tareaRepository;

    @Test
    void testCreate() throws Exception {

        Tarea tarea = new Tarea();
        tarea.setNombreTarea("Testing_1_create");
        tarea.setDescTarea("Este es un test para ver si creamos tareas correctamente");
        tarea.setEntornoTarea("Ninguno");
        tarea.setPersonaTarea("Manolo");
        tarea.setPrioridadTarea("Alta");

        String tareaJson = objectMapper.writeValueAsString(tarea); // Me pasa la tarea a JSON

        mockMvc.perform(post("/tareas") // Envia una peticion, de tipo: post
                .contentType("application/json") // Con el contenido en formato JSON
                .content(tareaJson)) // En el que el contenido sea: la tarea que hemos creado
                .andExpect(status().isOk()) // Espera que el código sea 200, internamente si no es 200 sale con
                                            // excepción
                .andExpect(result -> {
                    String respuesta = result.getResponse().getContentAsString();
                    Tarea tareaCreada = objectMapper.readValue(respuesta, Tarea.class);
                    assertTrue(tareaCreada.getId() > 0, "El valor debe ser mayor que 0");

                    Optional<Tarea> asegurarTareaCreada = tareaRepository.findById(tareaCreada.getId());
                    assertTrue(asegurarTareaCreada.isPresent());
                });

        /*
         * El último expect lo que hace es crea una respuesta que recibe como string,
         * crea una tarea y le pasa los valores que hemos recibido
         * y los serializa con el objectMapper, pasandole la respuesta y el formato
         * necesario (Tarea)
         * por ultimo utiliza un assertTrue para revisar que el ID sea mayor que 0,
         * porque si lo es significa que ha creado la tarea y asignado un id
         * 
         * Por ultimo crea un optional de tarea (una lista que puede o no tener datos),
         * en asegurarTareaCreada tendriamos la tarea entera si existe, o un
         * optional#empty() si no
         */
    }

    @Test
    void testGet() throws Exception {

        Tarea tarea = new Tarea();
        tarea.setNombreTarea("Testing_1_get");
        tarea.setDescTarea("Este es un test para ver si pedimos tareas correctamente");
        tarea.setEntornoTarea("Ninguno");
        tarea.setPersonaTarea("Manolo");
        tarea.setPrioridadTarea("Alta");

        String tareaJson = objectMapper.writeValueAsString(tarea);

        mockMvc.perform(post("/tareas")
                .contentType("application/json")
                .content(tareaJson))
                .andExpect(status().isOk());

        // Primero metemos datos para poder pedirselos

        mockMvc.perform(get("/tareas/1"))
                .andExpect(status().isOk());
        // Luego comprobamos que al hacer un get a la tarea con id 1 (el que deberia
        // tener lo que le hemos mandado) está bien y lo encuentra (devuelve 200)

    }

    @Test
    void testDelete() throws Exception {

        Tarea tarea = new Tarea();
        tarea.setNombreTarea("Testing_1_get");
        tarea.setDescTarea("Este es un test para ver si pedimos tareas correctamente");
        tarea.setEntornoTarea("Ninguno");
        tarea.setPersonaTarea("Manolo");
        tarea.setPrioridadTarea("Alta");

        String tareaJson = objectMapper.writeValueAsString(tarea);

        mockMvc.perform(post("/tareas")
                .contentType("application/json")
                .content(tareaJson))
                .andExpect(status().isOk());

        // Creamos tarea

        mockMvc.perform(get("/tareas/1"))
                .andExpect(status().isOk());

        // Revisamos que está creada, por si peta podemos ver que igual el problema
        // viene de otro sitio

        mockMvc.perform(delete("/tareas/1"))
                .andExpect(status().isOk())
                .andReturn();

        // La borramos
    }

    @Test
    void testPut() throws Exception {

        Tarea tarea = new Tarea();
        tarea.setNombreTarea("Testing_1_get");
        tarea.setDescTarea("Este es un test para ver si pedimos tareas correctamente");
        tarea.setEntornoTarea("Ninguno");
        tarea.setPersonaTarea("Manolo");
        tarea.setPrioridadTarea("Alta");

        String tareaJson = objectMapper.writeValueAsString(tarea);

         mockMvc.perform(post("/tareas")
                .contentType("application/json")
                .content(tareaJson))
                .andExpect(status().isOk());

        // Creamos tarea

        mockMvc.perform(get("/tareas/1"))
                .andExpect(status().isOk());

        // Revisamos que está creada, por si peta podemos ver que igual el problema
        // viene de otro sitio

        Tarea tareaNueva = new Tarea();
        tareaNueva.setNombreTarea("Testing_2_patch");
        tareaNueva.setDescTarea("Este es un test para ver si modificamos tareas");
        tareaNueva.setEntornoTarea("Todos");
        tareaNueva.setPersonaTarea("Antonio");
        tareaNueva.setPrioridadTarea("media");

        String tareaNuevaJson = objectMapper.writeValueAsString(tareaNueva);


       mockMvc.perform(put("/tareas")
                .contentType("application/json")
                .content(tareaNuevaJson))
                .andExpect(result -> {
                    String respuesta = result.getResponse().getContentAsString();
                    Tarea tareaCreada = objectMapper.readValue(respuesta, Tarea.class);
                    assertEquals(tareaCreada.getDescTarea(), "Este es un test para ver si modificamos tareas");
                });
                

    }

}
