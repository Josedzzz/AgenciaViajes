package co.edu.uniquindio.agencia.model;

import lombok.*;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Guia extends Persona {

    private int aniosExperiencia;
    private ArrayList<Lenguajes> listaLenguajes;
    private ArrayList<CalificacionGuia> calificaciones;

    public Guia(String id, String nombre, String correo, String telefono, String residencia, String contrasenia, int aniosExperiencia, ArrayList<Lenguajes> listaLenguajes) {
        super(id, nombre, correo, telefono, residencia, contrasenia);
        this.aniosExperiencia = aniosExperiencia;
        this.listaLenguajes = listaLenguajes;
    }

    public Guia() {

    }
}
