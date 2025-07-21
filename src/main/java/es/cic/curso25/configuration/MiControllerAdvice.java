package es.cic.curso25.configuration;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import es.cic.curso25.IntentoModificacionSecurityException;

@RestControllerAdvice
public class MiControllerAdvice {

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(exception = IntentoModificacionSecurityException.class)
    public void controloModificacion(){

    }
}
