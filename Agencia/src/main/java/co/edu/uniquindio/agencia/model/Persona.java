package co.edu.uniquindio.agencia.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Persona {
    protected String id;
    protected String nombre;
    protected String correo;
    protected String telefono;
    protected String residencia;
    protected String contrasenia;

   /* public Persona(String id, String nombre, String correo, String telefono, String residencia, String contrasenia) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.residencia = residencia;
        this.contrasenia = contrasenia;
    } */

    /*public Persona() {

    } */

}
