package es.cic.curso25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarea {

    @Id //Cuidado, hay dos opciones: uno de Jakarta y otro de Spring. SIEMPRE el de Jakarta
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // Este va autogenerando, idealmente usariamos UUID (UniversalUnitID) para que sea menos evidente (autoincrementado...)
     /*Esto sería un objeto de tipo Long, no una variable primitiva de tipo Long
    A la hora de crear un registro, debería ser null, ya que aún no existe en la base de datos
    Por el contrario, si queremos actualizarlo, debería tener un valor distinto de null
    */
    private String nombreTarea;
    private String descTarea;
    private String entornoTarea;
    private String personaTarea;
    private String prioridadTarea;

    public Tarea(){

    }

    public Tarea(String nombreTarea, String descTarea, String entornoTarea, String personaTarea,
            String prioridadTarea) {
        this.nombreTarea = nombreTarea;
        this.descTarea = descTarea;
        this.entornoTarea = entornoTarea;
        this.personaTarea = personaTarea;
        this.prioridadTarea = prioridadTarea;
    }

    //Al no tener ningún constructor, usa el de por defecto, que es el vacío
    //Al haber creado un constructor con parámetros para generarlos al iniciar el programa, te obliga a hacerle uno vacío para sus create()

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public void setNombreTarea(String nombreTarea) {
        this.nombreTarea = nombreTarea;
    }

    public String getDescTarea() {
        return descTarea;
    }

    public void setDescTarea(String descTarea) {
        this.descTarea = descTarea;
    }

    public String getPersonaTarea() {
        return personaTarea;
    }

    public void setPersonaTarea(String personaTarea) {
        this.personaTarea = personaTarea;
    }

    public String getPrioridadTarea() {
        return prioridadTarea;
    }

    public void setPrioridadTarea(String prioridadTarea) {
        this.prioridadTarea = prioridadTarea;
    }

    public String getEntornoTarea() {
        return entornoTarea;
    }

    public void setEntornoTarea(String entornoTarea) {
        this.entornoTarea = entornoTarea;
    }

   
}
