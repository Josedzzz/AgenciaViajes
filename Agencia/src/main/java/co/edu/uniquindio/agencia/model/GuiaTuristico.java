package co.edu.uniquindio.agencia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class GuiaTuristico extends Persona {

    private int aniosExperiencia;
    private ArrayList<Lenguajes> listaLenguajes;

    public GuiaTuristico(String id, String nombre, String correo, String telefono, String residencia, String contrasenia, int aniosExperiencia) {
        super(id, nombre, correo, telefono, residencia, contrasenia);
        this.aniosExperiencia = aniosExperiencia;
        this.listaLenguajes = new ArrayList<Lenguajes>();
    }

    public GuiaTuristico(int aniosExperiencia) {
        this.aniosExperiencia = aniosExperiencia;
    }
}
