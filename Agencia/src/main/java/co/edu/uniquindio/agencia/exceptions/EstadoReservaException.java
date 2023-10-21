package co.edu.uniquindio.agencia.exceptions;

import co.edu.uniquindio.agencia.model.EstadoReserva;

public class EstadoReservaException extends Exception{
    public EstadoReservaException(String mensaje){
        super(mensaje);
    }
}
