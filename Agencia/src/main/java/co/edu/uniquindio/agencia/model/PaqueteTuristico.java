package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode(of = {"nombre", "fechaInicial", "fechaFinal"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaqueteTuristico {

    private String nombre;
    private String fechaInicial;
    private String fechaFinal;
    private double precio;
    private int cupoMaximo;
    private ArrayList<ServicioAdicional> listaServiciosAdicionales;
    private ArrayList<Destino> listaDestinos;

}