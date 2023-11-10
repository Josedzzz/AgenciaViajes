package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class ReservasController {

    @FXML
    private Button btnCancelarReserva;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnVerGuia;

    @FXML
    private Button btnVerPaqueteTuristico;

    @FXML
    private TableColumn<?, ?> columnCedula;

    @FXML
    private TableColumn<?, ?> columnCupos;

    @FXML
    private TableColumn<?, ?> columnEstadoReserva;

    @FXML
    private TableColumn<?, ?> columnFechaSolicitud;

    @FXML
    private TableColumn<?, ?> columnGuia;

    @FXML
    private TableColumn<?, ?> columnPaqueteTuristico;

    @FXML
    private TableView<?> tableViewReservas;


    //Variables auxiliares
    private Stage stage;
    private AgenciaApp agenciaApp;
    private InicioController inicioController;
    private Cliente clienteSesion;

    public void setAgenciaApp(AgenciaApp agenciaApp) {
        this.agenciaApp = agenciaApp;
    }

    public void init(Stage stage, InicioController inicioController, Cliente clienteSesion) {
        this.stage = stage;
        this.inicioController = inicioController;
        this.clienteSesion = clienteSesion;
    }

    @FXML
    void cancelarReserva(ActionEvent event) {

    }

    /**
     * Regresa a la ventana de inicio
     * @param event
     */
    @FXML
    void regresar(ActionEvent event) {
        this.stage.close();
        inicioController.show();
    }

    @FXML
    void verGuia(ActionEvent event) {

    }

    @FXML
    void verPaqueteTuristico(ActionEvent event) {

    }

}