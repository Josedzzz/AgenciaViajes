package co.edu.uniquindio.agencia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Destino {

    private String nombre;
    private String ciudad;
    private String descripcion;
    private TipoClima tipoClima;

    public Destino(String nombre, String ciudad, String descripcion, TipoClima tipoClima) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.tipoClima = tipoClima;
    }

    public Destino() {

    }
}
