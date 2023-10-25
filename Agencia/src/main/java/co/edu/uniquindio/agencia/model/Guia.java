package co.edu.uniquindio.agencia.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Builder(builderMethodName = "guiaBuilder")
public class Guia extends Persona {

    private int aniosExperiencia;
    private ArrayList<Lenguajes> listaLenguajes;
    private ArrayList<CalificacionGuia> calificaciones;

}