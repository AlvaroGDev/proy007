package es.cic.curso25.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Tarea {

    @Id // Cuidado, hay dos opciones: uno de Jakarta y otro de Spring. SIEMPRE el de
        // Jakarta
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // Este va autogenerando, idealmente usariamos UUID (UniversalUnitID) para que
    // sea menos evidente (autoincrementado...)
    /*
     * Esto sería un objeto de tipo Long, no una variable primitiva de tipo Long
     * A la hora de crear un registro, debería ser null, ya que aún no existe en la
     * base de datos
     * Por el contrario, si queremos actualizarlo, debería tener un valor distinto
     * de null
     */
    private String nombreTarea;
    private String descTarea;
    private String entornoTarea;
    private String personaTarea;
    private String prioridadTarea;

    public Tarea() {

    }

    public Tarea(String nombreTarea, String descTarea, String entornoTarea, String personaTarea,
            String prioridadTarea) {
        this.nombreTarea = nombreTarea;
        this.descTarea = descTarea;
        this.entornoTarea = entornoTarea;
        this.personaTarea = personaTarea;
        this.prioridadTarea = prioridadTarea;
    }

    // Al no tener ningún constructor, usa el de por defecto, que es el vacío
    // Al haber creado un constructor con parámetros para generarlos al iniciar el
    // programa, te obliga a hacerle uno vacío para sus create()

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

    @Override
    public String toString() {
        return "Tarea [id=" + id + ", descTarea=" + descTarea + ", entornoTarea=" + entornoTarea + ", personaTarea="
                + personaTarea + ", prioridadTarea=" + prioridadTarea + "]";
    }
    // Es importante NO poner información confidencial aquí
    // Si le concatenas un objeto, por defecto hará su toString tambien

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        // De base, el primer objeto no debe ser null, porque si no explota y no
        // entraria aqui
        if (this == obj)
            // Si es el mismo, no hace falta que siga, asi que sale
            return true;
        if (obj == null)
            // Si nos han pasado por parámetro un null, sale y devuelve falso directamente
            return false;
        if (getClass() != obj.getClass())
            // Si no son de la misma clase, sale y devuelve falso también
            return false;

        // Aqui ya hemos revisado que es la misma clase
        Tarea other = (Tarea) obj;
        // El casting funciona porque sólo llega aqui si obj es de la misma clase
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
        //Tienen distinto id, devuelve false, lo invierte y entra, devuelve false
            return false;
        return true;
    }

}
