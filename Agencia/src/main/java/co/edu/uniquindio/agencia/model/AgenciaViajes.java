package co.edu.uniquindio.agencia.model;

import co.edu.uniquindio.agencia.exceptions.*;
import co.edu.uniquindio.agencia.utilities.ArchivoUtils;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.LookupOp;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Locale;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Getter
@Setter
public class AgenciaViajes {
    private String nombre;
    private ArrayList<Destino> listaDestinos;
    private ArrayList<PaqueteTuristico> listaPaquetesTuristicos;
    private ArrayList<Reserva> listaReservas;
    private ArrayList<Guia> listaGuiasTuristicos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Administrador> listaAdministradores;

    //Variables que tendran la instancia de esta clase
    private static final Logger LOGGER = Logger.getLogger(AgenciaViajes.class.getName());
    private static AgenciaViajes agenciaViajes;

    /**
     * Constructor que debe de ser privado para que ninguna otra clase pueda crear instancias de esta clase
     */
    private AgenciaViajes() {
        try {
            FileHandler fh = new FileHandler("logs.log", true);
            fh.setFormatter( new SimpleFormatter());
            LOGGER.addHandler(fh);
        } catch (IOException e) {
            LOGGER.log( Level.SEVERE, e.getMessage() );
        }
        LOGGER.log(Level.INFO, "Se crea una nueva instancia de la empresa");

        this.listaDestinos = new ArrayList<Destino>();
        this.listaPaquetesTuristicos = new ArrayList<PaqueteTuristico>();
        this.listaReservas = new ArrayList<Reserva>();
        this.listaGuiasTuristicos = new ArrayList<Guia>();
        this.listaClientes = new ArrayList<Cliente>();
        this.listaAdministradores = new ArrayList<Administrador>();
        //Se lee el archivo de texto plano para los clientes
        try {
            listaClientes = convertirStringACliente(ArchivoUtils.leerArchivoBufferedReader("src/main/resources/info/clientesData.txt"));
            LOGGER.log(Level.INFO, "Se carga la lista de clientes leyendo un texto plano");
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "No se pudo cargar la lista de clientes leyendo un texto plano: " + e.getMessage());
        }
    }

    //METODOS PARA PERSISTENCIA DE LOS CLIENTES

    /**
     * Para escribir clientes en texto plano
     * @param clientes
     * @return
     */
    private static ArrayList<String> convertirClienteAString(ArrayList<Cliente> clientes) {
        ArrayList<String> clientesEnString = new ArrayList<>();
        convertirClienteAString(clientes, 0, clientesEnString);
        return clientesEnString;
    }

    private static void convertirClienteAString(ArrayList<Cliente> clientes, int i, ArrayList<String> clientesEnString) {

        if (i >= clientes.size()) {
            return;
        }
        Cliente cliente = clientes.get(i);
        String clienteString = cliente.getId() + ";" + cliente.getNombre() + ";" + cliente.getCorreo() + ";" + cliente.getTelefono() + ";" + cliente.getResidencia() + ";" + cliente.getContrasenia();
        clientesEnString.add(clienteString);
        convertirClienteAString(clientes, i + 1, clientesEnString);
    }

    /**
     * Convierte la lista de String de clientes a objetos cliente
     * @param clientesString
     * @return
     */
    public ArrayList<Cliente> convertirStringACliente(ArrayList<String> clientesString) {
        ArrayList<Cliente> clientes = new ArrayList<>();
        convertirStringACliente(clientesString, 0, clientes);
        return clientes;
    }

    private void convertirStringACliente(ArrayList<String> clientesString, int i, ArrayList<Cliente> clientes) {

        if (i >= clientesString.size()) {
            return;
        }
        String clienteSt = clientesString.get(i);
        String[] partesCliente = clienteSt.split(";");
        Cliente cliente = Cliente.builder()
                .id(partesCliente[0])
                .nombre(partesCliente[1])
                .correo(partesCliente[2])
                .telefono(partesCliente[3])
                .residencia(partesCliente[4])
                .contrasenia(partesCliente[5])
                .build();

        clientes.add(cliente);
        convertirStringACliente(clientesString, i + 1, clientes);
    }


    /**
     * Metodo que se usara en otras clases que requieran la instancia de empresa
     * @return Instancia de la empresa
     */
    public static AgenciaViajes getInstance() {
        if (agenciaViajes == null) {
            agenciaViajes = new AgenciaViajes();
        }
        return agenciaViajes;
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



    //CRUD DE GUIAS --------------------------------------------------------------------------------------

    /**
     * LLama la funcion actualizarGuia del administrador
     * @param agenciaViajes clase principal
     * @param adminActual admin que inicio sesion
     * @param id id del guia
     * @param nombre nombre del guia
     * @param correo correo del guia
     * @param telefono telefono del guia
     * @param residencia residencia del guia
     * @param contrasenia contrasenia del guia
     * @param aniosExperiencia experiencia del guia
     * @param listaLenguajes lenguajes del guia
     * @throws GuiaNoRegistradoException
     */
    public void actulizarGuia(AgenciaViajes agenciaViajes, Administrador adminActual, String id, String nombre, String correo, String telefono, String residencia, String contrasenia, int aniosExperiencia, ArrayList<Lenguajes> listaLenguajes) throws GuiaNoRegistradoException {
        adminActual.actualizarGuia(agenciaViajes, id, nombre, correo, telefono, residencia, contrasenia, aniosExperiencia, listaLenguajes);
    }

    /**
     * Llama la función eliminarGuia del administrador
     * @param agenciaViajes clase principal
     * @param adminActual admin que inicio sesion
     * @param id id del guia
     * @throws GuiaNoRegistradoException
     */
    public void eliminarGuia(AgenciaViajes agenciaViajes, Administrador adminActual, String id) throws GuiaNoRegistradoException {
        adminActual.eliminarGuia(agenciaViajes, id);
    }

    /**
     * Llama la funcion crearGuia del administrador
     * @param agenciaViajes clase principal
     * @param adminActual admin que inicio sesion
     * @param id id del guia
     * @param nombre nombre del guia
     * @param correo correo del guia
     * @param telefono telefono del guia
     * @param residencia residencia del guia
     * @param contrasenia contrasenia del guia
     * @param aniosExperiencia experiencia del guia
     * @param listaLenguajes lenguajes del guia
     * @throws GuiaYaExistenteException
     * @throws CampoObligatorioGuiaException
     */
    public void crearGuia(AgenciaViajes agenciaViajes, Administrador adminActual, String id, String nombre, String correo, String telefono, String residencia, String contrasenia, int aniosExperiencia, ArrayList<Lenguajes> listaLenguajes) throws GuiaYaExistenteException, CampoObligatorioGuiaException {
        adminActual.crearGuia(agenciaViajes, id, nombre, correo, telefono, residencia, contrasenia, aniosExperiencia, listaLenguajes);
    }



    //CRUD DE RESERVAS --------------------------------------------------------------------------------------

    /**
     * Obtiene la reserva dado el id de el cliente involucrado
     * @param listaReservas lista de reservas de la agencia de viajes
     * @param id id del cliente involucrado
     * @param i index que inicia en 0
     * @return
     */
    public Reserva obtenerReserva(ArrayList<Reserva> listaReservas, Cliente clienteInvolucrado, int i) {
        if (i >= listaReservas.size()) {
            return null;
        } else {
            Reserva reserva = listaReservas.get(i);
            if (reserva.getClienteInvolucrado().equals(clienteInvolucrado)) {
                return reserva;
            } else {
                return obtenerReserva(listaReservas, clienteInvolucrado, i + 1);
            }
        }
    }

    /**
     * Retorna una reserva creada por un cliente
     * @param fechaSolicitud
     * @param fechaReserva
     * @param cantidadPersonas
     * @param estadoReserva
     * @param clienteInvolucrado
     * @param paqueteTuristicoSeleccionado
     * @param guiaTuristico
     * @return
     * @throws AtributosVaciosException
     * @throws ReservaYaExistenteException
     */

    public Reserva crearReserva(LocalDate fechaSolicitud, LocalDate fechaReserva, int cantidadPersonas, EstadoReserva estadoReserva, Cliente clienteInvolucrado, PaqueteTuristico paqueteTuristicoSeleccionado, Guia guiaTuristico) throws AtributosVaciosException,ReservaYaExistenteException,FechaNoPermitidaException,AtributoIncorrectoException {

        Reserva reservaEncontrada = obtenerReserva(listaReservas,clienteInvolucrado,0);

        if(fechaSolicitud == null){
            LOGGER.log(Level.WARNING, "La fecha de solicitud es un campo obligatorio");
            throw new AtributosVaciosException("La fecha de solicitud es obligatoria");
        }

        if(fechaReserva == null){
            LOGGER.log(Level.WARNING, "La fecha de reserva es un campo obligatorio");
            throw new AtributosVaciosException("La fecha de reserva es obligatoria");
        }

        if(fechaReserva.isBefore(LocalDate.now())){
            LOGGER.log(Level.WARNING,"La fecha esta antes de la fecha actual");
            throw new FechaNoPermitidaException("La fecha es invalida");
        }

        if(fechaSolicitud.isBefore(LocalDate.now())){
            LOGGER.log(Level.WARNING,"La fecha esta antes de la fecha actual");
            throw new FechaNoPermitidaException("La fecha es invalida");
        }

        if(cantidadPersonas == 0 || cantidadPersonas < 0){
            LOGGER.log(Level.WARNING, "La cantidad de personas es incorrecta");
            throw new AtributoIncorrectoException("La cantidad de personas es invalida");
        }

        if(paqueteTuristicoSeleccionado == null || paqueteTuristicoSeleccionado.equals("")){
            LOGGER.log(Level.WARNING,"No se selecciono un paquete turistico");
            throw new AtributosVaciosException("Debe seleccionar un paquete turisico");
        }

        //Al crear una reserva por defecto esta entra como estado pendiente
        estadoReserva = EstadoReserva.PENDIENTE;

        Reserva reservaNueva = Reserva.builder()
                .fechaSolicitud(fechaSolicitud)
                .fechaReserva(fechaReserva)
                .cantidadPersonas(cantidadPersonas)
                .estadoReserva(estadoReserva)
                .paqueteTuristicoSeleccionado(paqueteTuristicoSeleccionado)
                .guia(guiaTuristico)
                .build();

        listaReservas.add(reservaNueva);
        LOGGER.log(Level.INFO,"El cliente" + clienteInvolucrado + " ha creado una reserva");

        return reservaNueva;
    }


    /**
     * Metodo que cancela la reserva
     * @param reserva
     * @param estadoReserva
     */
    public void cancelarReserva(EstadoReserva estadoReserva)throws EstadoReservaException {
        // Verifica si la reserva está pendiente o confirmada antes de cancelar
        if (estadoReserva == EstadoReserva.PENDIENTE || estadoReserva == EstadoReserva.CONFIRMADA) {
            estadoReserva = EstadoReserva.CANCELADA;
            LOGGER.log(Level.INFO,"Se cancala una reserva correctamente");
            throw new EstadoReservaException("La reserva ha sido cancelada correctamente");
        } else {
            LOGGER.log(Level.WARNING,"La reserva no se pudo cancelar");
            throw new EstadoReservaException("No ha sido posible cancelar la reserva");
        }
    }

    /**
     * Metodo que confirma la reserva
     * @param estadoReserva
     * @throws EstadoReservaException
     */
    public void confirmarReserva(EstadoReserva estadoReserva)throws EstadoReservaException {
        if (estadoReserva == EstadoReserva.PENDIENTE) {
            estadoReserva = EstadoReserva.CONFIRMADA;
            LOGGER.log(Level.INFO,"Se confirma una reserva correctamente");
            throw new EstadoReservaException("La reserva ha sido confirmada correctamente");
        } else {
            LOGGER.log(Level.WARNING,"La reserva no se pudo confirmar");
            throw new EstadoReservaException("No ha sido posible confirmar la reserva");
        }
    }

    /**
     * Metodo que lista las reservas de un cliente
     * @param cliente
     * @param listaReservas
     * @param i
     */
    public static void listarTodasLasReservas(Cliente cliente, ArrayList<Reserva> listaReservas, int i) {
        if (i < listaReservas.size()) {
            Reserva reserva = listaReservas.get(i);
            if (reserva.getClienteInvolucrado().equals(cliente)) {
                LOGGER.log(Level.INFO,"Se muestra la lista de reservas del cliente");
            }
            listarTodasLasReservas(cliente, listaReservas, i + 1);
        }
    }

    //CRUD DE CLIENTE --------------------------------------------------------------------------------------

    /**
     * Obtiene el cliente dado el id de este
     * @param listaClientes lista de clientes de la agencia de viajes
     * @param id id del cliente
     * @param i index que inicia en 0
     * @return
     */
    public Cliente obtenerCliente(ArrayList<Cliente> listaClientes, String id, int i) {
        if (i >= listaClientes.size()) {
            return null;
        } else {
            Cliente cliente = listaClientes.get(i);
            if (cliente.getId().equals(id)) {
                return cliente;
            } else {
                return obtenerCliente(listaClientes, id, i + 1);
            }
        }
    }

    /**
     * Retorna un cliente nuevo
     * @param id
     * @param nombre
     * @param correo
     * @param telefono
     * @param residencia
     * @param contrasenia
     * @return
     * @throws ClienteYaExistenteException
     * @throws AtributosVaciosException
     */

    public Cliente crearCliente(String id, String nombre, String correo, String telefono, String residencia, String contrasenia) throws AtributosVaciosException, ClienteYaExistenteException {

        Cliente clienteEncontrado = obtenerCliente(listaClientes,id,0);

        if(id == null || id.isBlank()){
            LOGGER.log(Level.WARNING, "El id es obligatoria para el registro" );
            throw new AtributosVaciosException("El id es obligatoria");
        }

        if(nombre == null || nombre.isBlank()){
            LOGGER.log(Level.WARNING, "El nombre es obligatorio para el registro" );
            throw new AtributosVaciosException("El nombre es obligatorio");
        }

        if(correo == null || correo.isBlank()){
            LOGGER.log(Level.WARNING, "El correo es obligatorio para el registro" );
            throw new AtributosVaciosException("El correo es obligatorio");
        }

        if(telefono == null || telefono.isBlank()){
            LOGGER.log(Level.WARNING, "El telefono es obligatorio para el registro" );
            throw new AtributosVaciosException("El telefono es obligatorio");
        }

        if(residencia == null || residencia.isBlank()){
            LOGGER.log(Level.WARNING, "La direccion es obligatoria para el registro" );
            throw new AtributosVaciosException("La direccion es obligatoria");
        }

        if(contrasenia == null || contrasenia.isBlank()){
            LOGGER.log(Level.WARNING, "La contrasenia es obligatoria para el registro" );
            throw new AtributosVaciosException("La contrasenia es obligatoria");
        }

        if(clienteEncontrado != null){
            LOGGER.log(Level.SEVERE, "El id " + id + " ya esta registrado" );
            throw new ClienteYaExistenteException("El cliente no se encuentra registrado");
        }

        Cliente clienteNuevo = Cliente.builder()
                .id(id)
                .nombre(nombre)
                .correo(correo)
                .telefono(telefono)
                .residencia(residencia)
                .contrasenia(contrasenia)
                .build();


        listaClientes.add(clienteNuevo);
        LOGGER.log(Level.INFO, "Se ha registrado un nuevo cliente con cedula: " + id + "");

        //Guardo el objeto cliente con texto plano
        try {
            ArchivoUtils.escribirArchivoBufferedWriter("src/main/resources/info/clientesData.txt", convertirClienteAString(listaClientes), false);
            LOGGER.log(Level.INFO, "Se guarda el nuevo cliente");
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "No se pudo guardar el nuevo cliente: " + e.getMessage());
        }
        return clienteNuevo;
    }

    /**
     * Actualiza los datos del cliente
     * @param id
     * @param nombre
     * @param correo
     * @param telefono
     * @param residencia
     * @param contrasenia
     * @throws ClienteNoRegistradoException
     * @throws AtributosVaciosException
     */
    public void actualizarCliente(String id, String nombre, String correo, String telefono, String residencia, String contrasenia)throws ClienteNoRegistradoException , AtributosVaciosException{

        Cliente clienteEncontrado = obtenerCliente(listaClientes,id,0);

        if(id == null || id.isBlank()){
            LOGGER.log(Level.WARNING, "el id es obligatorio para el registro" );
            throw new AtributosVaciosException("El id es obligatorio");
        }

        if(nombre == null || nombre.isBlank()){
            LOGGER.log(Level.WARNING, "El nombre es obligatorio para el registro" );
            throw new AtributosVaciosException("El nombre es obligatorio");
        }

        if(correo == null || correo.isBlank()){
            LOGGER.log(Level.WARNING, "El correo es obligatorio para el registro" );
            throw new AtributosVaciosException("El correo es obligatorio");
        }

        if(telefono == null || telefono.isBlank()){
            LOGGER.log(Level.WARNING, "El telefono es obligatorio para el registro" );
            throw new AtributosVaciosException("El telefono es obligatorio");
        }

        if(residencia == null || residencia.isBlank()){
            LOGGER.log(Level.WARNING, "La residencia es obligatoria para el registro" );
            throw new AtributosVaciosException("La residencia es obligatoria");
        }

        if(contrasenia == null || contrasenia.isBlank()){
            LOGGER.log(Level.WARNING, "La contrasenia es obligatoria para el registro" );
            throw new AtributosVaciosException("La contrasenia es obligatoria");
        }

        if(clienteEncontrado == null){
            LOGGER.log(Level.SEVERE, "El id " + id + " no esta registrado" );
            throw new ClienteNoRegistradoException("EL cliente no está registrado");
        }
        clienteEncontrado.setNombre(nombre);
        clienteEncontrado.setCorreo(correo);
        clienteEncontrado.setTelefono(telefono);
        clienteEncontrado.setResidencia(residencia);
        LOGGER.log(Level.INFO, "Se actualizaron los datos del cliente: " + id);
        //Guardo el objeto cliente con texto plano
        try {
            ArchivoUtils.escribirArchivoBufferedWriter("src/main/resources/info/clientesPlanos.txt", convertirClienteAString(listaClientes), false);
            LOGGER.log(Level.INFO, "Se guardo el cliente con sus datos actualizados");
        } catch (IOException e) {
            LOGGER.log(Level.WARNING, "No se pudo guardar el cliente actualizado: " + e.getMessage());
        }
    }

    /**
     * Elimina un cliente dado su cedula
     * @param id
     * @throws ClienteNoRegistradoException
     */

    public void eliminarCliente(String id)throws ClienteNoRegistradoException {
        Cliente clientePorEliminar = obtenerCliente(listaClientes,id,0);
        if(clientePorEliminar != null){
            listaClientes.remove(clientePorEliminar);
            LOGGER.log(Level.INFO, "Se elimino el cliente");
            //Guardo el objeto cliente con texto plano
            try {
                ArchivoUtils.escribirArchivoBufferedWriter("src/main/resources/info/clientesPlanos.txt", convertirClienteAString(listaClientes), false);
                LOGGER.log(Level.INFO, "Se guardo el cliente eliminado");
            } catch (IOException e) {
                LOGGER.log(Level.WARNING, "No se pudo guardar el cliente eliminado: " + e.getMessage());
            }
        }else{
            LOGGER.log(Level.SEVERE, "El id " + id + " no esta registrado" );
            throw new ClienteNoRegistradoException("El cliente no se encuentra registrado");
        }
    }

}