package es.cic.curso25;

public class TareaException extends RuntimeException{

    public TareaException(){

    }

    public TareaException(String message){
        super(message);
    }

    public TareaException (String message, Throwable throwable){
        super(message,throwable);
    }
}
