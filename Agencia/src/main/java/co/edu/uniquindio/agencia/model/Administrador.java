package co.edu.uniquindio.agencia.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Administrador extends Persona {

    public Administrador(String id, String nombre, String correo, String telefono, String residencia, String contrasenia) {
        super(id, nombre, correo, telefono, residencia, contrasenia);
    }

    public Administrador() {

    }

}
