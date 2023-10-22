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

}