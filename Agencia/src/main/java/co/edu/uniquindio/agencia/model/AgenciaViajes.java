package co.edu.uniquindio.agencia.model;

import co.edu.uniquindio.agencia.exceptions.CampoObligatorioDestinoException;
import co.edu.uniquindio.agencia.exceptions.DestinoNoRegistradoException;
import co.edu.uniquindio.agencia.exceptions.DestinoYaExistenteException;
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

    //CRUD DESTIONOS ---------------------------------------------------------------------------------

    /**
     * Obtiene el destiono al que le corresponde el nombre y la ciudad
     * @param nombre nombre del destino
     * @param ciudad cuidad destino
     * @param i index que debe inciar en 0
     * @return
     */
    public Destino obtenerDestino(String nombre, String ciudad, int i) {
        if (i >= listaDestinos.size()) {
            return null;
        } else {
            Destino destino = listaDestinos.get(i);
            if (destino.getNombre().equals(nombre) && destino.getCiudad().equals(ciudad)) {
                return destino;
            } else {
                return obtenerDestino(nombre, ciudad, i + 1);
            }
        }
    }

    /**
     * Actualiza los datos de un destino
     * @param nombre nombre del destino
     * @param ciudad ciudad destino
     * @param descripcion descripcion del destino
     * @param tipoClima clima del destino
     * @throws DestinoNoRegistradoException
     */
    public void actualizarDestino(String nombre, String ciudad, String descripcion, TipoClima tipoClima) throws DestinoNoRegistradoException {
        Destino destinoEncontrado = obtenerDestino(nombre, ciudad, 0);
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
     * Elimina un destino de la lista de destinos
     * @param nombre nombre del destino
     * @param ciudad ciudad del destino
     * @throws DestinoNoRegistradoException
     */
    public void eliminarDestino(String nombre, String ciudad) throws DestinoNoRegistradoException {
        Destino destinoEncontrado = obtenerDestino(nombre, ciudad, 0);
        if (destinoEncontrado == null) {
            throw  new DestinoNoRegistradoException("El destino que buscas eliminar no está registrado");
        } else {
            listaDestinos.remove(destinoEncontrado);
        }
    }

    /**
     * Crea un destino y lo agrega a la lista de destinos
     * @param nombre nombre del destino
     * @param ciudad ciudad del destino
     * @param descripcion descripcion del destino
     * @param listaImagenes lista de imagenes del destino
     * @param tipoClima clima del destino
     * @throws DestinoYaExistenteException
     * @throws CampoObligatorioDestinoException
     */
    public void crearDestino(String nombre, String ciudad, String descripcion, ArrayList<String> listaImagenes, TipoClima tipoClima) throws DestinoYaExistenteException, CampoObligatorioDestinoException {
        Destino destinoEncontrado = obtenerDestino(nombre, ciudad, 0);
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
            listaDestinos.add(destino);
        }
    }

}
