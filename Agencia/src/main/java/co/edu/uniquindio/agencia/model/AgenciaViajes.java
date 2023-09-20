package co.edu.uniquindio.agencia.model;

import co.edu.uniquindio.agencia.exceptions.*;
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

    //FUNCIONES --------------------------------------------------------------------------------------

    //CRUD DESTINO -------------------------------------------------------------------------------

    /**
     * Llama a la funcion actualizarDestino del administrador
     * @param agenciaViajes clase principal
     * @param adminActual admin que inicio sesion
     * @param nombre nombre del destino
     * @param ciudad ciudad del destino
     * @param descripcion descripcion del destino
     * @param tipoClima clima del destino
     * @throws DestinoNoRegistradoException
     */
    public void actualizarDestino(AgenciaViajes agenciaViajes, Administrador adminActual, String nombre, String ciudad, String descripcion, TipoClima tipoClima) throws DestinoNoRegistradoException {
        adminActual.actualizarDestino(agenciaViajes, nombre, ciudad, descripcion, tipoClima);
    }

    /**
     * Llama a la funcion eliminarDestino del administrador
     * @param agenciaViajes clase principal
     * @param adminActual admin que inicio sesion
     * @param nombre nombre del destino
     * @param ciudad ciudad del destino
     * @throws DestinoNoRegistradoException
     */
    public void eliminarDestino(AgenciaViajes agenciaViajes, Administrador adminActual, String nombre, String ciudad) throws DestinoNoRegistradoException {
        adminActual.eliminarDestino(agenciaViajes, nombre, ciudad);
    }

    /**
     * Llama a la funcion crear destino del administrador
     * @param agenciaViajes clase principal
     * @param adminActual admin que inicio sesion
     * @param nombre nombre del destino
     * @param ciudad ciudad del destino
     * @param descripcion descipcion del destino
     * @param listaImagenes lista de imagenes del destino
     * @param tipoClima clima del destino
     * @throws CampoObligatorioDestinoException
     * @throws DestinoYaExistenteException
     */
    public void crearDestino(AgenciaViajes agenciaViajes, Administrador adminActual, String nombre, String ciudad, String descripcion, ArrayList<String> listaImagenes, TipoClima tipoClima) throws CampoObligatorioDestinoException, DestinoYaExistenteException {
        adminActual.crearDestino(agenciaViajes, nombre, ciudad, descripcion, listaImagenes, tipoClima);
    }

    //CRUD PAQUETE TURISTICO -----------------------------------------------------------------------

    /**
     * Llama a la funcion actualizarPaqueteTuristico del administrador
     * @param agenciaViajes clase principal
     * @param adminiActual admin que inicio sesion
     * @param nombre nombre del paquete turistico
     * @param fechaInicial fecha inicial del paquete turistico
     * @param fechaFinal fecha final del paquete turistico
     * @param precio precio del paquete turistico
     * @param cupoMaximo cupo maximo del paquete turistico
     * @throws PaqueteTutisticoNoRegistradoException
     */
    public void actualizarPaqueteTuristico(AgenciaViajes agenciaViajes, Administrador adminiActual, String nombre, String fechaInicial, String fechaFinal, double precio, int cupoMaximo) throws PaqueteTutisticoNoRegistradoException {
        adminiActual.actualizarPaqueteTuristico(agenciaViajes, nombre, fechaInicial, fechaFinal, precio, cupoMaximo);
    }

    /**
     * Llama a la funcion eliminarPaqueteTuristico del administrador
     * @param agenciaViajes clase principal
     * @param adminActual admin que inicio sesion
     * @param nombre nombre del paquete turistico
     * @param fechaInicial fecha inicial del paquete turistico
     * @param fechaFinal fecha final del paquete turistico
     * @throws PaqueteTutisticoNoRegistradoException
     */
    public void eliminarPaqueteTuristico(AgenciaViajes agenciaViajes, Administrador adminActual, String nombre, String fechaInicial, String fechaFinal) throws PaqueteTutisticoNoRegistradoException {
        adminActual.eliminarPaqueteTuristico(agenciaViajes, nombre, fechaInicial, fechaFinal);
    }

    /**
     * Llama a la funcion crearPaqueteTuristico de administrador
     * @param agenciaViajes clase principal
     * @param adminActual administrador que inicio sesion
     * @param nombre nombre del paquete turistico
     * @param fechaInicial fecha inicial del paquete turistico
     * @param fechaFinal fechia final del paquete turistico
     * @param precio precio del paquete turistico
     * @param cupoMaximo cupo maximo del paquete turistico
     * @param listaServiciosAdicionales servicios adicionales del paquete turistico
     * @param listaDestinos destinos del paquete turistico
     * @throws PaqueteTuristicoYaExistenteException
     * @throws CampoObligatorioPaqueteTuristicoException
     */
    public void crearPaqueteTuristico(AgenciaViajes agenciaViajes, Administrador adminActual, String nombre, String fechaInicial, String fechaFinal, double precio, int cupoMaximo, ArrayList<ServicioAdicional> listaServiciosAdicionales, ArrayList<Destino> listaDestinos) throws PaqueteTuristicoYaExistenteException, CampoObligatorioPaqueteTuristicoException {
        adminActual.crearPaqueteTuristico(agenciaViajes, nombre, fechaInicial, fechaFinal, precio, cupoMaximo, listaServiciosAdicionales, listaDestinos);
    }


}
