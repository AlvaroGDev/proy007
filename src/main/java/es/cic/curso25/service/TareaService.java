package es.cic.curso25.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.cic.curso25.model.Tarea;
import es.cic.curso25.repository.TareaRepository;

// Aquí iría la lógica de negocio, es decir, cosas que dependen de cómo funciona la empresa:
// por ejemplo, si el cliente hace una compra por encima de X importe, le podriamos añadir envío gratis o algún regalo

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public long create(Tarea tarea) {

        tareaRepository.save(tarea);

        return tarea.getId();
    }

    public Tarea getTarea(long id){
        
        Optional<Tarea> resultado = tareaRepository.findById(id);
        return resultado.orElse(null); //Devuelve resultado, en caso de que no exista, devuelve null y no explota
    }

    public List<Tarea> get(){
        return tareaRepository.findAll();
    }

    public void update(Tarea tarea){
        tareaRepository.save(tarea); //El sabrá cuando lo llamen si ese save es un guardar o un modificar
    }
    
    public void delete(long id){
        tareaRepository.deleteById(id);
    }

}
