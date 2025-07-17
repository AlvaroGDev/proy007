package es.cic.curso25;

public class Tarea {

    private Long id;
    private String nombreTarea;
    private String descTarea;
    private String entornoTarea;
    private String personaTarea;
    private String prioridadTarea;

 
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
