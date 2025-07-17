package es.cic.curso25;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Repository;

@Repository
public class TareaRepository {

    private Map<Long, Tarea> tareas = new HashMap<>();

    public long create (Tarea tarea){
        long mayor = getSiguienteId();
        tarea.setId(mayor);
        tareas.put(tarea.getId(), tarea);
        return tarea.getId();
    }

    private long getSiguienteId(){
        long mayor = 0;

        Set<Long> ids = tareas.keySet();
        Iterator<Long> iteratorId = ids.iterator();

        while(iteratorId.hasNext()){
            Long siguiente = iteratorId.next();
            if(siguiente.longValue()> mayor){
                mayor = siguiente;
            }
        }
        mayor++;
        return mayor;
    }

    public Tarea getTarea(long id){

      Tarea miTarea = new Tarea();
        miTarea.setDescTarea("todo esto debería cogerlo");
        miTarea.setEntornoTarea("de las tareas del Map");
        return miTarea;
    }
}
    /*
    getSiguienteId() lo que hace es crear un Set (una coleccion de elementos unicos sin permitir repeticion)
    Iterator es una interfaz que permite recorrer una coleccion o lista. En ese momento, iteratorId tiene el primer valor y ha generado una variable que se puede recorrer
    Revisa el while y si tiene otra posición, entra
    iteratorId.next() devuelve el valor actual de la posición en la que está y pasa a la siguiente, en ese caso la variable "siguiente" recibe el valor y después salta al siguiente
    si el valor actual es mayor que el que tenemos guardado, lo sobreescribe

    Al final, lo que hace es revisar todos los IDS, quedarse con el mayor actual, sumarle uno y devolverlo, así se irían generando los ids en orden sumando de 1 en 1


    */
