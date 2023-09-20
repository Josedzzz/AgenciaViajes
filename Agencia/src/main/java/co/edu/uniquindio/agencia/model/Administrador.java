package co.edu.uniquindio.agencia.model;

import co.edu.uniquindio.agencia.exceptions.CampoObligatorioDestinoException;
import co.edu.uniquindio.agencia.exceptions.DestinoNoRegistradoException;
import co.edu.uniquindio.agencia.exceptions.DestinoYaExistenteException;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class Administrador extends Persona {

    public Administrador(String id, String nombre, String correo, String telefono, String residencia, String contrasenia) {
        super(id, nombre, correo, telefono, residencia, contrasenia);
    }

    public Administrador() {

    }

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
            Destino destino = new Destino(nombre, ciudad, descripcion, listaImagenes, tipoClima);
            agenciaViajes.getListaDestinos().add(destino);
        }
    }

}
