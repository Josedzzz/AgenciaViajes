package co.edu.uniquindio.agencia.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente extends Persona {

    private String id;
    private String nombre;
    private String correo;
    private String telefono;
    private String residencia;
    private String contrasenia;

    /*public Cliente(String id, String nombre, String correo, String telefono, String residencia, String contrasenia) {
        super(id, nombre, correo, telefono, residencia, contrasenia);
    }*/

}
