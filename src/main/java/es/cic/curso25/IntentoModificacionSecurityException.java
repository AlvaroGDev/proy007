package es.cic.curso25;

public class IntentoModificacionSecurityException extends RuntimeException {

    public IntentoModificacionSecurityException() {
        super("Has tratado de modificar mediante creación");
        // Como nos obliga a tener un constructor vacio, podemos obligarle a poner lo que nosotros queramos
        // si no le pasamos ningún valor al llamarlo
    }

    public IntentoModificacionSecurityException(String mensage) {
        super(mensage);

    }

    public IntentoModificacionSecurityException(String mensage, Throwable throwable) {
        super(mensage, throwable);

    }
}
