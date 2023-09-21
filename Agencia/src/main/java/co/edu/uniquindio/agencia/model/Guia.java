package co.edu.uniquindio.agencia.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class Guia extends Persona {

    private int aniosExperiencia;
    private ArrayList<Lenguajes> listaLenguajes;

    public Guia(String id, String nombre, String correo, String telefono, String residencia, String contrasenia, int aniosExperiencia, ArrayList<Lenguajes> listaLenguajes) {
        super(id, nombre, correo, telefono, residencia, contrasenia);
        this.aniosExperiencia = aniosExperiencia;
        this.listaLenguajes = listaLenguajes;
    }

    public Guia() {

    }
}
