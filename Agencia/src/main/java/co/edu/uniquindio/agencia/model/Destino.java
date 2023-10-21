package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode(of = {"nombre", "ciudad"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Destino {

    private String nombre;
    private String ciudad;
    private String descripcion;
    private ArrayList<String> listaImagenes;
    private TipoClima tipoClima;
    private ArrayList<CalificacionDestino> calificaciones;

    public Destino(String nombre, String ciudad, String descripcion, ArrayList<String> listaImagenes, TipoClima tipoClima) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.listaImagenes = listaImagenes;
        this.tipoClima = tipoClima;
    }

    public Destino() {

    }
}
