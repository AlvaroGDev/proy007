package es.cic.curso25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public long create (Tarea tarea){

        return tareaRepository.create(tarea);
    }

}
