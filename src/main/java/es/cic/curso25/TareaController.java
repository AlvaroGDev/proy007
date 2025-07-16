package es.cic.curso25;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tareas")

public class TareaController {

    @Autowired
    private TareaService tareaService;

    List<Tarea> listadoTareas = new ArrayList<>();

    // @PostMapping
    // public long create

}
