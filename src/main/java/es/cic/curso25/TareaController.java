package es.cic.curso25;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private final static Logger LOGGER = LoggerFactory.getLogger(TareaController.class);

    @Autowired
    private TareaService tareaService;

    List<Tarea> listadoTareas = new ArrayList<>();

    @PostMapping
    public long create(Tarea tarea) {
        try {
            if (tarea.getId() != null) { // Si NO es null, entrará y dará error, ya que NO debemos pasarle id
                throw new RuntimeException("al crear no me puedes pasar un id");
            }

        } catch (RuntimeException re) {

            re.printStackTrace();
            LOGGER.error(re.getMessage());
            throw new TareaException("Ha fallado la tarea al crear: " + re.getMessage(), re);

        }
        return tareaService.create(tarea);
    }

    @DeleteMapping
    public void delete(Long id) {
        tareaService.delete(id);
    }

    @PutMapping
    public void update(Tarea tarea) {
        // TODO: metodo para actualizar un objeto
        // Put se manda la tarea entera y se cambian luego los datos
        // Patch, por el contrario, se le envían los campos que cambian, pero es más
        // complicado de hacer

    }

    @GetMapping("/{id}")
    public Tarea getTarea(@PathVariable Long id){
       return tareaService.getTarea(id);
    }

    @GetMapping()
    public List<Tarea> getTareas() {
        return tareaService.get();

    }
    
}
