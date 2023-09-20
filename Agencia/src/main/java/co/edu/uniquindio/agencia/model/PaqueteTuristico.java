package co.edu.uniquindio.agencia.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode(of = {"nombre", "fechaInicial", "fechaFinal"})
public class PaqueteTuristico {

    private String nombre;
    private String fechaInicial;
    private String fechaFinal;
    private double precio;
    private int cupoMaximo;
    private ArrayList<ServicioAdicional> listaServiciosAdicionales;
    private ArrayList<Destino> listaDestinos;

    public PaqueteTuristico(String nombre, String fechaInicial, String fechaFinal, double precio, int cupoMaximo, ArrayList<ServicioAdicional> listaServiciosAdicionales, ArrayList<Destino> listaDestinos) {
        this.nombre = nombre;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
        this.precio = precio;
        this.cupoMaximo = cupoMaximo;
        this.listaServiciosAdicionales = listaServiciosAdicionales;
        this.listaDestinos = listaDestinos;
    }

    public PaqueteTuristico() {

    }
}
