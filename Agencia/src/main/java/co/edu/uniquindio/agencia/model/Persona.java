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

}