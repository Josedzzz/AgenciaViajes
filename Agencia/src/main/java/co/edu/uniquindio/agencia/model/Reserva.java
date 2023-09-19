package co.edu.uniquindio.agencia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Reserva {

    private String fechaSolicitud;
    private int cantidadPersonas;
    private EstadoReserva estadoReserva;
    private Cliente clienteInvolucrado;
    private PaqueteTuristico paqueteTuristicoSeleccionado;
    private GuiaTuristico guiaTuristico;

    public Reserva(String fechaSolicitud, int cantidadPersonas, EstadoReserva estadoReserva, Cliente clienteInvolucrado, PaqueteTuristico paqueteTuristicoSeleccionado, GuiaTuristico guiaTuristico) {
        this.fechaSolicitud = fechaSolicitud;
        this.cantidadPersonas = cantidadPersonas;
        this.estadoReserva = estadoReserva;
        this.clienteInvolucrado = clienteInvolucrado;
        this.paqueteTuristicoSeleccionado = paqueteTuristicoSeleccionado;
        this.guiaTuristico = guiaTuristico;
    }

    public Reserva() {

    }
}
