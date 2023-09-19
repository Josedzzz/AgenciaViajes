package co.edu.uniquindio.agencia.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class AgenciaViajes {
    private String nombre;
    private ArrayList<Destino> listaDestinos;
    private ArrayList<PaqueteTuristico> listaPaquetesTuristicos;
    private ArrayList<Reserva> listaReservas;
    private ArrayList<GuiaTuristico> listaGuiasTuristicos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Administrador> listaAdministradores;

    public AgenciaViajes(String nombre) {
        this.nombre = nombre;
        this.listaDestinos = new ArrayList<Destino>();
        this.listaPaquetesTuristicos = new ArrayList<PaqueteTuristico>();
        this.listaReservas = new ArrayList<Reserva>();
        this.listaGuiasTuristicos = new ArrayList<GuiaTuristico>();
        this.listaClientes = new ArrayList<Cliente>();
        this.listaAdministradores = new ArrayList<Administrador>();
    }

    public AgenciaViajes() {

    }
}
