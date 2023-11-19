package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reserva implements Serializable {

    private LocalDate fechaSolicitud;
    private LocalDate fechaReserva;
    private int cantidadPersonas;
    private EstadoReserva estadoReserva;
    private Cliente clienteInvolucrado;
    private PaqueteTuristico paqueteTuristicoSeleccionado;
    private Guia guia;

}
