package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import co.edu.uniquindio.agencia.model.Cliente;
import co.edu.uniquindio.agencia.model.PaqueteTuristico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HacerReservaController {

    @FXML
    private Button btnHacerReserva;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnVerGuiaSeleccionado;

    @FXML
    private Button btnVerPrecio;

    @FXML
    private CheckBox checkBoxGguia;

    @FXML
    private TableView<?> tableViewGuia;

    @FXML
    private TableColumn<?, ?> columnAniosExperiencia;

    @FXML
    private TableColumn<?, ?> columnCorreoGuia;

    @FXML
    private TableColumn<?, ?> columnNombreGuia;

    @FXML
    private TableColumn<?, ?> columnTelefonoGuia;

    @FXML
    private TextField txtCantidadPersonas;

    @FXML
    private TextField txtPrecio;

    //Variables auxiliares
    private Stage stage;
    private AgenciaApp agenciaApp;
    private InfoPaqueteController infoPaqueteController;
    private Cliente clienteSesion;
    private PaqueteTuristico paqueteSeleccion;

    //Uso de singleton
    private final AgenciaViajes agenciaViajes = AgenciaViajes.getInstance();

    public void setAgenciaApp(AgenciaApp agenciaApp) {
        this.agenciaApp = agenciaApp;
    }

    public void init(Stage stage, InfoPaqueteController infoPaqueteController, Cliente clienteSesion, PaqueteTuristico paqueteSeleccion) {
        this.stage = stage;
        this.infoPaqueteController = infoPaqueteController;
        this.clienteSesion = clienteSesion;
        this.paqueteSeleccion = paqueteSeleccion;
    }

    @FXML
    void hacerReserva(ActionEvent event) {

    }

    /**
     * Regresa a la ventana de buscador de paquetes
     * @param event
     */
    @FXML
    void regresar(ActionEvent event) {
        this.stage.close();
        infoPaqueteController.show();
    }

    @FXML
    void verGuiaSeleccionado(ActionEvent event) {

    }

    @FXML
    void verPrecio(ActionEvent event) {

    }

}
