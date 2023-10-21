package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva {

    private LocalDate fechaSolicitud;
    private LocalDate fechaReserva;
    private int cantidadPersonas;
    private EstadoReserva estadoReserva;
    private Cliente clienteInvolucrado;
    private PaqueteTuristico paqueteTuristicoSeleccionado;
    private Guia guia;

   /* public Reserva(String fechaSolicitud, int cantidadPersonas, EstadoReserva estadoReserva, Cliente clienteInvolucrado, PaqueteTuristico paqueteTuristicoSeleccionado, Guia guiaTuristico) {
        this.fechaSolicitud = fechaSolicitud;
        this.cantidadPersonas = cantidadPersonas;
        this.estadoReserva = estadoReserva;
        this.clienteInvolucrado = clienteInvolucrado;
        this.paqueteTuristicoSeleccionado = paqueteTuristicoSeleccionado;
        this.guia = guia;
    } */

    /*public Reserva() {

    } */
}
