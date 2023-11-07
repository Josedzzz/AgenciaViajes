package co.edu.uniquindio.agencia.model;

import co.edu.uniquindio.agencia.exceptions.*;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
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
        //Quemo los datos de los administradores
        Administrador administrador = Administrador.administradorBuilder()
                .id("123")
                .nombre("Jose")
                .correo("Jose@")
                .telefono("123")
                .residencia("Quimbaya")
                .contrasenia("123")
                .build();
        listaAdministradores.add(administrador);

        //Quemo datos de los guias
        ArrayList<Lenguaje> lenguajesGuia = new ArrayList<>();
        lenguajesGuia.add(Lenguaje.ESPANIOL);
        lenguajesGuia.add(Lenguaje.INGLES);
        Guia guia = Guia.guiaBuilder()
                .id("333")
                .nombre("Camilo")
                .correo("Camilo@")
                .telefono("123")
                .residencia("Quimbaya")
                .contrasenia("333")
                .aniosExperiencia(2)
                .listaLenguajes(lenguajesGuia)
                .build();
        listaGuiasTuristicos.add(guia);

        //Quemo datos de los destinos
        ArrayList<String> rutaImagenesDestino = new ArrayList<>();
        rutaImagenesDestino.add("src/main/resources/Images/ParqueDelCafe.jpg");
        rutaImagenesDestino.add("src/main/resources/Images/ParqueDelCafe2.jpg");
        Destino destino = Destino.builder()
                .nombre("Parque del café")
                .ciudad("Montenegro")
                .descripcion("El Parque del Café es un parque temático colombiano situado en el corregimiento de Pueblo Tapao, del municipio de Montenegro en Quindío, Colombia.")
                .listaImagenes(rutaImagenesDestino)
                .tipoClima(TipoClima.CALIDO)
                .build();
        listaDestinos.add(destino);
        Destino destino1 = Destino.builder()
                .nombre("Panaca")
                .ciudad("Quimbaya")
                .descripcion("Algogooooo")
                .listaImagenes(rutaImagenesDestino)
                .tipoClima(TipoClima.CALIDO)
                .build();
        listaDestinos.add(destino1);

        //Quemo datos de los paquetes
        ArrayList<ServicioAdicional> serviciosAdicionalesPaquete = new ArrayList<>();
        serviciosAdicionalesPaquete.add(ServicioAdicional.ALIMENTOS);
        serviciosAdicionalesPaquete.add(ServicioAdicional.SEGUROS);
        ArrayList<Destino> destinosPaquete = new ArrayList<>();
        destinosPaquete.add(destino);
        LocalDate fechaInicial = LocalDate.of(2023, 12, 1);
        LocalDate fechaFinal = LocalDate.of(2023, 12, 2);
        PaqueteTuristico paqueteTuristico = PaqueteTuristico.builder()
                .nombre("Quindio Tour")
                .fechaInicial(fechaInicial)
                .fechaFinal(fechaFinal)
                .precio(100000.0)
                .cupoMaximo(20)
                .listaServiciosAdicionales(serviciosAdicionalesPaquete)
                .listaDestinos(destinosPaquete)
                .build();
        listaPaquetesTuristicos.add(paqueteTuristico);
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
    public void actualizarDestino(AgenciaViajes agenciaViajes, Administrador adminActual, String nombre, String ciudad, String descripcion, TipoClima tipoClima) throws DestinoNoRegistradoException, CampoObligatorioDestinoException {
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
    public void crearDestino(AgenciaViajes agenciaViajes, Administrador adminActual, String nombre, String ciudad, String descripcion, ArrayList<String> listaImagenes, TipoClima tipoClima, ArrayList<CalificacionDestino> listaCalificaciones) throws CampoObligatorioDestinoException, DestinoYaExistenteException {
        adminActual.crearDestino(agenciaViajes, nombre, ciudad, descripcion, listaImagenes, tipoClima, listaCalificaciones);
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
    public void actualizarPaqueteTuristico(AgenciaViajes agenciaViajes, Administrador adminiActual, String nombre, LocalDate fechaInicial, LocalDate fechaFinal, double precio, int cupoMaximo, ArrayList<ServicioAdicional> listaServiciosAdicionales) throws PaqueteTutisticoNoRegistradoException, CampoObligatorioPaqueteTuristicoException, FechaNoPermitidaException {
        adminiActual.actualizarPaqueteTuristico(agenciaViajes, nombre, fechaInicial, fechaFinal, precio, cupoMaximo, listaServiciosAdicionales);
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
    public void eliminarPaqueteTuristico(AgenciaViajes agenciaViajes, Administrador adminActual, String nombre, LocalDate fechaInicial, LocalDate fechaFinal) throws PaqueteTutisticoNoRegistradoException {
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
    public void crearPaqueteTuristico(AgenciaViajes agenciaViajes, Administrador adminActual, String nombre, LocalDate fechaInicial, LocalDate fechaFinal, double precio, int cupoMaximo, ArrayList<ServicioAdicional> listaServiciosAdicionales, ArrayList<Destino> listaDestinos) throws PaqueteTuristicoYaExistenteException, CampoObligatorioPaqueteTuristicoException, FechaNoPermitidaException {
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
    public void actulizarGuia(AgenciaViajes agenciaViajes, Administrador adminActual, String id, String nombre, String correo, String telefono, String residencia, String contrasenia, int aniosExperiencia, ArrayList<Lenguaje> listaLenguajes) throws GuiaNoRegistradoException, CampoObligatorioGuiaException {
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
    public void crearGuia(AgenciaViajes agenciaViajes, Administrador adminActual, String id, String nombre, String correo, String telefono, String residencia, String contrasenia, int aniosExperiencia, ArrayList<Lenguaje> listaLenguajes, ArrayList<CalificacionGuia> listaCalificaciones) throws GuiaYaExistenteException, CampoObligatorioGuiaException {
        adminActual.crearGuia(agenciaViajes, id, nombre, correo, telefono, residencia, contrasenia, aniosExperiencia, listaLenguajes, listaCalificaciones);
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

        Cliente clienteNuevo = Cliente.clienteBuilder()
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

        }else{
            LOGGER.log(Level.SEVERE, "El id " + id + " no esta registrado" );
            throw new ClienteNoRegistradoException("El cliente no se encuentra registrado");
        }
    }

    //FUNCIONES APARTE AL CRUD PARA EL MANEJO DE LA AGENCIA ----------------------------------

    //FUNCIONES PARA EL INICIO DE SESION ----------------------------------------------------
    /**
     * Valida que los campos no esten vacios
     * @param cedula del cliente o del administrador
     * @param contrasenia del cliente o del administrador
     * @param admin radioButton de admin
     * @param cliente radioButton de cliente
     * @throws AtributosVaciosException
     */
    public void validarDatosInicioSesion(String cedula, String contrasenia, boolean admin, boolean cliente) throws AtributosVaciosException {
        if (cedula == null || cedula.isBlank()) {
            throw new AtributosVaciosException("Por favor ingrese la cédula");
        }
        if (contrasenia == null || contrasenia.isBlank()) {
            throw new AtributosVaciosException("Por favor ingrese la contraseña");
        }
        if (admin == false && cliente == false) {
            throw new AtributosVaciosException("Por favor seleccione con que tipo de usuario desea ingresar");
        }
    }

    /**
     * Busca el administrador al que le corresponde la cedula y la contrasenia
     * @param cedula del administrador
     * @param contrasenia del administrador
     * @param i index en el cual se empieza a buscar el admin
     * @return Administrador al que le corresponden los datos
     * @throws AdminNoEncontradoException
     */
    public Administrador iniciarSesionAdmin(String cedula, String contrasenia, int i) throws AdminNoEncontradoException {
        if (i >= listaAdministradores.size()) {
            throw new AdminNoEncontradoException("Los datos ingresados no pertenecen a ningún administrador");
        }
        Administrador administrador = listaAdministradores.get(i);
        if (administrador.getId().equals(cedula) && administrador.getContrasenia().equals(contrasenia)) {
            return administrador;
        } else {
            return iniciarSesionAdmin(cedula, contrasenia, i + 1);
        }
    }

    //FUNCIONES PARA LA VIEW DE GESTIONAR GUIAS ------------------------------------------------------

    /**
     * Verifica si un guia habla el idioma buscado
     * @param guia
     * @param lenguajeBuscado
     * @param i indice que va a iterar sobre la lista de idiomas que habla el guia
     * @return
     */
    public boolean hablaIdiomaGuia(Guia guia, Lenguaje lenguajeBuscado, int i) {
        if (i >= guia.getListaLenguajes().size()) {
            return false;
        }
        Lenguaje lenguaje = guia.getListaLenguajes().get(i);
        if (lenguaje.equals(lenguajeBuscado)) {
            return true;
        } else {
            return hablaIdiomaGuia(guia, lenguajeBuscado, i + 1);
        }
    }

    /**
     * Crea el arraylist de los lenguajes que habla un guia
     * @param espaniol valor booleano de si habla espaniol o no
     * @param ingles valor booleano de si habla ingles o no
     * @param frances valor booleano de si habla frances o no
     * @return
     */
    public ArrayList<Lenguaje> obtenerArrayIdiomasGuia(boolean espaniol, boolean ingles, boolean frances) {
        ArrayList<Lenguaje> lenguajes = new ArrayList<>();
        if (espaniol) {
            lenguajes.add(Lenguaje.ESPANIOL);
        }
        if (ingles) {
            lenguajes.add(Lenguaje.INGLES);
        }
        if (frances) {
            lenguajes.add(Lenguaje.FRANCES);
        }
        return lenguajes;
    }

    //FUNCIONES PARA LA VIEW DE GESTIONAR DESTINOS ------------------------------------------------

    /**
     * Obtiene la primera imagen de la lista de imagenes de un destino
     * @param listaImagenes
     * @return
     * @throws AtributosVaciosException cuando el arrayList esta vacio
     */
    public String obtenerImagenDestino(ArrayList<String> listaImagenes) throws AtributosVaciosException {
        if (listaImagenes == null || listaImagenes.isEmpty()) {
            throw new AtributosVaciosException("Por el momento no hay imágenes disponibles para este destino. Por favor ingresale una imagen");
        } else {
            return listaImagenes.get(0);
        }
    }

    /**
     * Guarda una imagen en la lista de imagenes de un destino especifico
     * @param destino
     * @param rutaImagen
     */
    public void subirImagenDestino(Destino destino, String rutaImagen) throws DestinoNoRegistradoException {
        if (destino == null) {
            throw new DestinoNoRegistradoException("Por favor selecciona un destino en la tabla");
        }
        destino.getListaImagenes().add(rutaImagen);
    }

    /**
     * Elimina una imagen de la lista de imagenes de un destino en especifico
     * @param destino
     * @param rutaImagen
     * @throws DestinoNoRegistradoException
     * @throws AtributosVaciosException
     */
    public void eliminarImagenDestino(Destino destino, String rutaImagen) throws DestinoNoRegistradoException, AtributosVaciosException {
        if (destino == null) {
            throw new DestinoNoRegistradoException("Por favor seleccione un destino en la tabla");
        }
        if (rutaImagen == null || rutaImagen.isBlank()) {
            throw new AtributosVaciosException("El destino no tiene ninguna imagen para eliminarla");
        }
        destino.getListaImagenes().remove(rutaImagen);
    }

    /**
     * Indice de la siguiente imagen en el array de las imagenes del destino
     * Si el indice es el ultimo, se vuelve a 0
     * @param destino
     * @param indiceActual
     * @return
     * @throws DestinoNoRegistradoException
     * @throws AtributosVaciosException
     */
    public int siguienteImagenDestino(Destino destino, int indiceActual) throws DestinoNoRegistradoException, AtributosVaciosException {
        if (destino == null) {
            throw new DestinoNoRegistradoException("Por favor seleccione un destino en la tabla");
        }
        if (destino.getListaImagenes() == null || destino.getListaImagenes().isEmpty()) {
            throw new AtributosVaciosException("Por el momento no hay imágenes disponibles para este destino. Por favor ingresale una imagen");
        }
        int siguienteIndice = (indiceActual + 1) % destino.getListaImagenes().size();
        return siguienteIndice;
    }

    /**
     * Indice de la imagen anterior en el array de las imagenes del destino
     * Si el indice es el 0, se va al ultimo
     * @param destino
     * @param indiceActual
     * @return
     * @throws DestinoNoRegistradoException
     * @throws AtributosVaciosException
     */
    public int anteriorImagenDestino(Destino destino, int indiceActual) throws DestinoNoRegistradoException, AtributosVaciosException {
        if (destino == null) {
            throw new DestinoNoRegistradoException("Por favor seleccione un destino en la tabla");
        }
        if (destino.getListaImagenes() == null || destino.getListaImagenes().isEmpty()) {
            throw new AtributosVaciosException("Por el momento no hay imágenes disponibles para este destino. Por favor ingresale una imagen");
        }
        int indiceAnterior = (indiceActual - 1 + destino.getListaImagenes().size()) % destino.getListaImagenes().size();
        return indiceAnterior;
    }

    //FUNCIONES PARA LA VIEW DE GESTIONAR PAQUETES ----------------------------------------------------

    /**
     * Obtiene la lista de destinos de un paquete en especifico para validar si esta vacio o no
     * @param paqueteTuristico
     * @return
     * @throws AtributosVaciosException
     */
    public ArrayList<Destino> obtenerDestinosPaquete(PaqueteTuristico paqueteTuristico) throws AtributosVaciosException, PaqueteTutisticoNoRegistradoException {
        if (paqueteTuristico == null) {
            throw new PaqueteTutisticoNoRegistradoException("Seleccione un paquete turistico en la tabla para poder ver los destinos de este paquete");
        }
        if (paqueteTuristico.getListaDestinos() == null || paqueteTuristico.getListaDestinos().isEmpty()) {
            throw new AtributosVaciosException("Por el momento no hay destinos disponibles para este paquete. Por favor seleccione uno de los destinos desponibles y agregelo al paquete.");
        } else {
            return paqueteTuristico.getListaDestinos();
        }
    }

    /**
     * Verifica si un paqueteTuristico tiene el servicio adicional buscado
     * @param paqueteTuristico
     * @param servicioAdicionalBuscado
     * @param i indice que va a iterar sobre la lista de serviciosAdicionales del paquete
     * @return
     */
    public boolean tieneServicioAdicionalPaquete(PaqueteTuristico paqueteTuristico, ServicioAdicional servicioAdicionalBuscado, int i) {
        if (i >= paqueteTuristico.getListaServiciosAdicionales().size()) {
            return false;
        }
        ServicioAdicional servicioAdicional = paqueteTuristico.getListaServiciosAdicionales().get(i);
        if (servicioAdicional.equals(servicioAdicionalBuscado)) {
            return true;
        } else {
            return tieneServicioAdicionalPaquete(paqueteTuristico, servicioAdicionalBuscado, i + 1);
        }
    }

    /**
     * Crea un arrayList con los servicios adicionales del paquete
     * @param transporte
     * @param alimentos
     * @param seguros
     * @param recreacion
     * @param bar
     * @return
     */
    public ArrayList<ServicioAdicional> obtenerServiciosAdicionalesPaquete(boolean transporte, boolean alimentos, boolean seguros, boolean recreacion, boolean bar) {
        ArrayList<ServicioAdicional> serviciosAdicionales = new ArrayList<>();
        if (transporte) {
            serviciosAdicionales.add(ServicioAdicional.TRANSPORTE);
        }
        if (alimentos) {
            serviciosAdicionales.add(ServicioAdicional.ALIMENTOS);
        }
        if (seguros) {
            serviciosAdicionales.add(ServicioAdicional.SEGUROS);
        }
        if (recreacion) {
            serviciosAdicionales.add(ServicioAdicional.RECREACION);
        }
        if (bar) {
            serviciosAdicionales.add(ServicioAdicional.BAR);
        }
        return serviciosAdicionales;
    }

    /**
     * Guarda el destino en la lista de destinos del paquete turistico especifico
     * @param paqueteTuristico
     * @param destino
     * @throws PaqueteTutisticoNoRegistradoException
     */
    public void agregarDestinoPaquete(PaqueteTuristico paqueteTuristico, Destino destino) throws PaqueteTutisticoNoRegistradoException, DestinoNoRegistradoException, DestinoYaExistenteException {
        if (paqueteTuristico == null) {
            throw new PaqueteTutisticoNoRegistradoException("Por favor seleccione un paquete en la tabla");
        }
        if (destino == null) {
            throw new DestinoNoRegistradoException("Por favor seleccione un destino en la tabla");
        }
        if (!verificarDestinoEnPaquete(paqueteTuristico, destino, 0)) {
            paqueteTuristico.getListaDestinos().add(destino);
        } else {
            throw new DestinoYaExistenteException("El destino ya se encuentra en el paquete");
        }
    }

    /**
     * Funcion auxiliar que verifica si un destino esta en la lista de destinos de un paquete
     * @param paqueteTuristico
     * @param destino
     * @param indice
     * @return
     */
    private boolean verificarDestinoEnPaquete(PaqueteTuristico paqueteTuristico, Destino destino, int indice) {
        if (indice >= paqueteTuristico.getListaDestinos().size()) {
            return false;
        }
        if (paqueteTuristico.getListaDestinos().get(indice).getNombre().equals(destino.getNombre()) && paqueteTuristico.getListaDestinos().get(indice).getCiudad().equals(destino.getCiudad())) {
            return true;
        } else {
            return verificarDestinoEnPaquete(paqueteTuristico, destino, indice + 1);
        }
    }

}