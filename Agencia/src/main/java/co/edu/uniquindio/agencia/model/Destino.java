package co.edu.uniquindio.agencia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Destino {

    private String nombre;
    private String ciudad;
    private String descripcion;
    private ArrayList<String> listaImagenes;
    private TipoClima tipoClima;

    public Destino(String nombre, String ciudad, String descripcion, TipoClima tipoClima) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.listaImagenes = new ArrayList<String>();
        this.tipoClima = tipoClima;
    }

    public Destino() {

    }
}
