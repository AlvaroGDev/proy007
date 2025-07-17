package es.cic.curso25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import es.cic.curso25.model.Tarea;
import es.cic.curso25.repository.TareaRepository;

@Component
public class CargaDeDatos implements CommandLineRunner {
//CommandLineRunner es una interfaz de spring que ejecuta codigo automático al iniciar la aplicación

@Autowired
private TareaRepository tareaRepository;

    @Override
    public void run(String...datos){
        //Es necesario que se llame run
        //Los "..." indican que puede recibir 0, 1 o varios parámetros
        tareaRepository.save(new Tarea(
            "Desplegar servidor",
            "Desplegar el servidor mediante springboot",
            "SpringBoot",
            "Javier",
            "Media"
        ));
        tareaRepository.save(new Tarea(
            "Contactar con cliente",
            "Contactar con el cliente para discutir los plazos de la aplicacion",
            "Planificación",
            "Manuel",
            "Alta"
        ));
    }

}
