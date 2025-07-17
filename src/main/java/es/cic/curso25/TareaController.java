package es.cic.curso25;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tareas")

public class TareaController {

    @Autowired
    private TareaService tareaService;

    List<Tarea> listadoTareas = new ArrayList<>();

    @PostMapping
    public long create(Tarea tarea) {
        if (tarea.getId() != null) { // Es importante que sea Long (objeto) y no la primitiva, porque si no, no deja
                                     // compararlo con null
            throw new RuntimeException("No me puedes pasar un ID al crear la tarea");
        }
        return tareaService.create(tarea);
    }

    @DeleteMapping
    public void delete(long id) {
        // TODO: recibir un id, buscarlo en el repositorio, borrarlo
    }

    @PutMapping
    public void update(Tarea tarea) {
        // TODO: metodo para actualizar un objeto
        // Put se manda la tarea entera y se cambian luego los datos
        // Patch, por el contrario, se le envían los campos que cambian, pero es más complicado de hacer

    }

    @GetMapping()
    public String getTareas() {
       Map<Long, Tarea> misTareas = tareaService.getTareas();

        return misTareas.toString();
        }
        //Esto es una prueba para ver que me devuelve cosas
    }


