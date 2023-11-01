package co.edu.uniquindio.agencia.model;

import co.edu.uniquindio.agencia.exceptions.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
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

    //FUNCIONES DEL ADMINISTRADOR

    //CRUD DESTINOS ---------------------------------------------------------------------------------

    /**
     * Obtiene el destino dado el nombre y la ciudad
     * @param listaDestinos lista de destinos de la agencia de viajes
     * @param nombre nombre del destino
     * @param ciudad ciudad del destino
     * @param i index que inicia en 0
     * @return
     */
    public Destino obtenerDestino(ArrayList<Destino> listaDestinos, String nombre, String ciudad, int i) {
        if (i >= listaDestinos.size()) {
            return null;
        } else {
            Destino destino = listaDestinos.get(i);
            if (destino.getNombre().equals(nombre) && destino.getCiudad().equals(ciudad)) {
                return destino;
            } else {
                return obtenerDestino(listaDestinos, nombre, ciudad, i + 1);
            }
        }
    }

    /**
     * Actualiza un destino
     * @param agenciaViajes clase principal
     * @param nombre nombre del destino
     * @param ciudad ciudad del destino
     * @param descripcion descipcion del destino
     * @param tipoClima clima del destino
     * @throws DestinoNoRegistradoException
     */
    public void actualizarDestino(AgenciaViajes agenciaViajes, String nombre, String ciudad, String descripcion, TipoClima tipoClima) throws DestinoNoRegistradoException {
        Destino destinoEncontrado = obtenerDestino(agenciaViajes.getListaDestinos(), nombre, ciudad, 0);
        if (destinoEncontrado == null) {
            throw new DestinoNoRegistradoException("El destino que buscas actualizar no está registrado");
        } else {
            destinoEncontrado.setNombre(nombre);
            destinoEncontrado.setCiudad(ciudad);
            destinoEncontrado.setDescripcion(descripcion);
            destinoEncontrado.setTipoClima(tipoClima);
        }
    }

    /**
     * Elimina un destino de la lista de destinos propia de la agencia de viajes
     * @param agenciaViajes clase principal
     * @param nombre nombre del destino
     * @param ciudad ciudad del destino
     * @throws DestinoNoRegistradoException
     */
    public void eliminarDestino(AgenciaViajes agenciaViajes, String nombre, String ciudad) throws DestinoNoRegistradoException {
        Destino destinoEncontrado = obtenerDestino(agenciaViajes.getListaDestinos(), nombre, ciudad, 0);
        if (destinoEncontrado == null) {
            throw  new DestinoNoRegistradoException("El destino que buscas eliminar no está registrado");
        } else {
            agenciaViajes.getListaDestinos().remove(destinoEncontrado);
        }
    }

    /**
     * Crea un destino y lo agrega a la lista de destinos de la agencia
     * @param agenciaViajes clase principal
     * @param nombre nombre del destino
     * @param ciudad ciudad del destino
     * @param descripcion descripcion del destino
     * @param listaImagenes lista de imagenes del destino
     * @param tipoClima clima del destino
     * @throws DestinoYaExistenteException
     * @throws CampoObligatorioDestinoException
     */
    public void crearDestino(AgenciaViajes agenciaViajes, String nombre, String ciudad, String descripcion, ArrayList<String> listaImagenes, TipoClima tipoClima) throws DestinoYaExistenteException, CampoObligatorioDestinoException {
        Destino destinoEncontrado = obtenerDestino(agenciaViajes.getListaDestinos(), nombre, ciudad, 0);
        if (destinoEncontrado != null) {
            throw new DestinoYaExistenteException("El destino que deseas registrar ya existe");
        } else {
            if (nombre == null || nombre.isEmpty()) {
                throw new CampoObligatorioDestinoException("El nombre del destino es obligatorio");
            }
            if (ciudad == null || ciudad.isEmpty()) {
                throw new CampoObligatorioDestinoException("La ciudad del destino es obligatoria");
            }
            if (descripcion == null || descripcion.isEmpty()) {
                throw new CampoObligatorioDestinoException("La descripción del destino es obligatoria");
            }
            if (listaImagenes == null || listaImagenes.isEmpty()) {
                throw new CampoObligatorioDestinoException("Ingrese por lo menos una imagén del destino");
            }
            if (tipoClima == null) {
                throw new CampoObligatorioDestinoException("El clima del destino es obligatorio");
            }
            //Destino destino = new Destino(nombre, ciudad, descripcion, listaImagenes, tipoClima);
            //agenciaViajes.getListaDestinos().add(destino);
        }
    }

    //CRUD PAQUETE TURISTICO -----------------------------------------------------------------------------

    /**
     * Obtine el paquete turistico dado el nombre, su fecha inicial y su fecha final
     * @param listaPaquetesTuristicos lista de paquetes turisticos de la agencia de viajes
     * @param nombre nombre del paquete turistico
     * @param fechaInicial fecha incial del paquete turistico
     * @param fechaFinal fecha final del paquete turistico
     * @param i index que inicia en 0
     * @return
     */
    public PaqueteTuristico obtenerPaqueteTuristico(ArrayList<PaqueteTuristico> listaPaquetesTuristicos, String nombre, String fechaInicial, String fechaFinal, int i) {
        if (i >= listaPaquetesTuristicos.size()) {
            return null;
        } else {
            PaqueteTuristico paqueteTuristico = listaPaquetesTuristicos.get(i);
            if (paqueteTuristico.getNombre().equals(nombre) && paqueteTuristico.getFechaInicial().equals(fechaInicial) && paqueteTuristico.getFechaFinal().equals(fechaFinal)) {
                return paqueteTuristico;
            } else {
                return obtenerPaqueteTuristico(listaPaquetesTuristicos, nombre, fechaInicial, fechaFinal, i + 1);
            }
        }
    }

    /**
     * Actualiza un paquete turistico
     * @param agenciaViajes clase principal
     * @param nombre nombre del paquete turistico
     * @param fechaInicial fecha inicial del paquete turistico
     * @param fechaFinal fecha final del paquete turistico
     * @param precio precio del paquete turistico
     * @param cupoMaximo cupo maximo del paquete turistico
     * @throws PaqueteTutisticoNoRegistradoException
     */
    public void actualizarPaqueteTuristico(AgenciaViajes agenciaViajes, String nombre, String fechaInicial, String fechaFinal, double precio, int cupoMaximo) throws PaqueteTutisticoNoRegistradoException {
        PaqueteTuristico paqueteTuristicoEncontrado = obtenerPaqueteTuristico(agenciaViajes.getListaPaquetesTuristicos(), nombre, fechaInicial, fechaFinal, 0);
        if (paqueteTuristicoEncontrado == null) {
            throw new PaqueteTutisticoNoRegistradoException("El paquete turístico no está registrado");
        } else {
            paqueteTuristicoEncontrado.setNombre(nombre);
            paqueteTuristicoEncontrado.setFechaInicial(fechaInicial);
            paqueteTuristicoEncontrado.setFechaFinal(fechaFinal);
            paqueteTuristicoEncontrado.setPrecio(precio);
            paqueteTuristicoEncontrado.setCupoMaximo(cupoMaximo);
        }
    }

    /**
     * Elimina un paquete turistico de la lista de paquetes turisticos propia de la agencia de viajes
     * @param agenciaViajes clase principal
     * @param nombre nombre del paque turistico
     * @param fechaInicial fecha inicial del paquete turistico
     * @param fechaFinal fecha final del paquete turistico
     * @throws PaqueteTutisticoNoRegistradoException
     */
    public void eliminarPaqueteTuristico(AgenciaViajes agenciaViajes, String nombre, String fechaInicial, String fechaFinal) throws PaqueteTutisticoNoRegistradoException {
        PaqueteTuristico paqueteTuristicoEncontrado = obtenerPaqueteTuristico(agenciaViajes.getListaPaquetesTuristicos(), nombre, fechaInicial, fechaFinal, 0);
        if (paqueteTuristicoEncontrado == null) {
            throw new PaqueteTutisticoNoRegistradoException("El paquete turístico no está registrado");
        } else {
            agenciaViajes.getListaPaquetesTuristicos().remove(paqueteTuristicoEncontrado);
        }
    }

    /**
     * Crea un paquete turistico y lo agrega a la lista de paquetes de la agencia
     * @param agenciaViajes clase principal
     * @param nombre nombre del paquete turistico
     * @param fechaInicial fecha inicial del paquete turistico}
     * @param fechaFinal fecha final del paquete turistico
     * @param precio precio del paquete turistico
     * @param cupoMaximo cupo maximo del paquete turistico
     * @param listaServiciosAdicionales servicios adicionales del paquete turistico
     * @param listaDestinos destinos del paquete turistico
     * @throws PaqueteTuristicoYaExistenteException
     * @throws CampoObligatorioPaqueteTuristicoException
     */
    public void crearPaqueteTuristico(AgenciaViajes agenciaViajes, String nombre, String fechaInicial, String fechaFinal, double precio, int cupoMaximo, ArrayList<ServicioAdicional> listaServiciosAdicionales, ArrayList<Destino> listaDestinos) throws PaqueteTuristicoYaExistenteException, CampoObligatorioPaqueteTuristicoException {
        PaqueteTuristico paqueteTuristicoEncontrado = obtenerPaqueteTuristico(agenciaViajes.getListaPaquetesTuristicos(), nombre, fechaInicial, fechaFinal, 0);
        if (paqueteTuristicoEncontrado != null) {
            throw new PaqueteTuristicoYaExistenteException("El paquete turístico ya existe");
        } else {
            if (nombre == null || nombre.isEmpty()) {
                throw new CampoObligatorioPaqueteTuristicoException("El nombre del paquete turístico es obligatorio");
            }
            if (fechaInicial == null || fechaInicial.isEmpty()) {
                throw new CampoObligatorioPaqueteTuristicoException("La fecha inicial del paquete turístico es obligatoria");
            }
            if (fechaFinal == null || fechaFinal.isEmpty()) {
                throw new CampoObligatorioPaqueteTuristicoException("La fecha final del paquete turístico es obligatoria");
            }
            if (Double.isNaN(precio) || precio == 0.0) {
                throw new CampoObligatorioPaqueteTuristicoException("El precio del paquete turístico es obligatorio");
            }
            if (cupoMaximo == 0) {
                throw new CampoObligatorioPaqueteTuristicoException("El cupo máximo del paquete turístico es obligatorio");
            }
            if (listaDestinos == null || listaDestinos.isEmpty()) {
                throw new CampoObligatorioPaqueteTuristicoException("Los destinos del paquete turístico son obligatorios");
            }
            //PaqueteTuristico paqueteTuristico = new PaqueteTuristico(nombre, fechaInicial, fechaFinal, precio, cupoMaximo, listaServiciosAdicionales, listaDestinos);
            //agenciaViajes.getListaPaquetesTuristicos().add(paqueteTuristico);
        }
    }

    //CRUD DE GUIAS -------------------------------------------------------------------------------------

    /**
     * Obtiene el guia dado el id de este
     * @param listaGuias lista de guias de la agencia de viajes
     * @param id id del guia
     * @param i index que inicia en 0
     * @return
     */
    public Guia obtenerGuia(ArrayList<Guia> listaGuias, String id, int i) {
        if (i >= listaGuias.size()) {
            return null;
        } else {
            Guia guia = listaGuias.get(i);
            if (guia.getId().equals(id)) {
                return guia;
            } else {
                return obtenerGuia(listaGuias, id, i + 1);
            }
        }
    }

    /**
     * Actualiza un guia
     * @param agenciaViajes clase principal
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
    public void actualizarGuia(AgenciaViajes agenciaViajes, String id, String nombre, String correo, String telefono, String residencia, String contrasenia, int aniosExperiencia, ArrayList<Lenguajes> listaLenguajes) throws GuiaNoRegistradoException {
        Guia guiaEcontrado = obtenerGuia(agenciaViajes.getListaGuiasTuristicos(), id, 0);
        if (guiaEcontrado == null) {
            throw new GuiaNoRegistradoException("El guía que buscas actualizar no está registrado");
        } else {
            guiaEcontrado.setNombre(nombre);
            guiaEcontrado.setCorreo(correo);
            guiaEcontrado.setTelefono(telefono);
            guiaEcontrado.setResidencia(residencia);
            guiaEcontrado.setContrasenia(contrasenia);
            guiaEcontrado.setAniosExperiencia(aniosExperiencia);
            guiaEcontrado.setListaLenguajes(listaLenguajes);
        }
    }

    /**
     * Elimina el guia de la lista de guias turisticos propia de la agencia de viajes
     * @param agenciaViajes clase principal
     * @param id id del guia
     * @throws GuiaNoRegistradoException
     */
    public void eliminarGuia(AgenciaViajes agenciaViajes, String id) throws GuiaNoRegistradoException {
        Guia guiaEncontrado = obtenerGuia(agenciaViajes.getListaGuiasTuristicos(), id, 0);
        if (guiaEncontrado == null) {
            throw new GuiaNoRegistradoException("El guía turistico no está registrado");
        } else {
            agenciaViajes.getListaGuiasTuristicos().remove(guiaEncontrado);
        }
    }

    /**
     * Crea un guia y lo agrega a la lista de guias de la agencia
     * @param agenciaViajes clase principal
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
    public void crearGuia(AgenciaViajes agenciaViajes, String id, String nombre, String correo, String telefono, String residencia, String contrasenia, int aniosExperiencia, ArrayList<Lenguajes> listaLenguajes) throws GuiaYaExistenteException, CampoObligatorioGuiaException {
        Guia guiaEncontrado = obtenerGuia(agenciaViajes.getListaGuiasTuristicos(), id, 0);
        if (guiaEncontrado != null) {
            throw new GuiaYaExistenteException("El guía que seas registrar ya existe");
        } else {
            if (id == null || id.isEmpty()) {
                throw new CampoObligatorioGuiaException("El id del guía es obligatorio");
            }
            if (nombre == null || nombre.isEmpty()) {
                throw new CampoObligatorioGuiaException("El nombre del guía es obligatorio");
            }
            if (correo == null || correo.isEmpty()) {
                throw new CampoObligatorioGuiaException("El correo del guía es obligatorio");
            }
            if (telefono == null || telefono.isEmpty()) {
                throw new CampoObligatorioGuiaException("El teléfono del guía es obligatorio");
            }
            if (residencia == null || residencia.isEmpty()) {
                throw new CampoObligatorioGuiaException("La residencia del guía es obligatoria");
            }
            if (contrasenia == null || contrasenia.isEmpty()) {
                throw new CampoObligatorioGuiaException("La contraseña del guía es obligatoria");
            }
            if (listaLenguajes == null || listaLenguajes.isEmpty()) {
                throw new CampoObligatorioGuiaException("El / los lenguajes del guía son obligatorios");
            }
            //Guia guia = new Guia(id, nombre, correo, telefono, residencia, contrasenia, aniosExperiencia, listaLenguajes);
            //agenciaViajes.getListaGuiasTuristicos().add(guia);
        }
    }

}
