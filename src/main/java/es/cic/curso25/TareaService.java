package es.cic.curso25;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// Aquí iría la lógica de negocio, es decir, cosas que dependen de cómo funciona la empresa:
// por ejemplo, si el cliente hace una compra por encima de X importe, le podriamos añadir envío gratis o algún regalo
@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public long create (Tarea tarea){

        return tareaRepository.create(tarea);
    }

    public Map<Long, Tarea> getTareas(){

        return tareaRepository.getAllTareas();
    } //Esto deberia devolver una tarea que habria buscado en el repositorio utilizando el id

}
