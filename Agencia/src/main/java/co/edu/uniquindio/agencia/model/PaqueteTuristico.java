package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode(of = {"nombre", "fechaInicial", "fechaFinal"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaqueteTuristico implements Serializable {

    private String nombre;
    private LocalDate fechaInicial;
    private LocalDate fechaFinal;
    private double precio;
    private int cupoMaximo;
    private int cupoDisponible;
    private ArrayList<ServicioAdicional> listaServiciosAdicionales;
    private ArrayList<Destino> listaDestinos;

}