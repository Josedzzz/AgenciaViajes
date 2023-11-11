package co.edu.uniquindio.agencia.model;

import co.edu.uniquindio.agencia.exceptions.*;
import javafx.scene.control.DatePicker;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@Getter
@Setter
@Builder(builderMethodName = "administradorBuilder")
public class Administrador extends Persona {

    private String id;
    private String nombre;
    private String correo;
    private String telefono;
    private String residencia;
    private String contrasenia;

}
