package co.edu.uniquindio.agencia.exceptions;

import co.edu.uniquindio.agencia.model.Reserva;

public class ReservaYaExistenteException extends Exception{
    public ReservaYaExistenteException(String mensaje){
        super(mensaje);
    }
}
