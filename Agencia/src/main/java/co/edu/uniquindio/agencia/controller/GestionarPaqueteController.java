package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.Administrador;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GestionarPaqueteController {

    @FXML
    private Button btnActualizarPaquete;

    @FXML
    private Button btnAgregarDestino;

    @FXML
    private Button btnCrearPaquete;

    @FXML
    private Button btnEliminarPaquete;

    @FXML
    private Button btnNuevoPaquete;

    @FXML
    private Button btnRegresar;

    @FXML
    private CheckBox checkBoxAlimentos;

    @FXML
    private CheckBox checkBoxBar;

    @FXML
    private CheckBox checkBoxRecreacion;

    @FXML
    private CheckBox checkBoxSeguros;

    @FXML
    private CheckBox checkBoxTransporte;

    @FXML
    private TableColumn<?, ?> columnCiudadDestino;

    @FXML
    private TableColumn<?, ?> columnClimaDestino;

    @FXML
    private TableColumn<?, ?> columnCupoPaquete;

    @FXML
    private TableColumn<?, ?> columnDescripcionDestino;

    @FXML
    private TableColumn<?, ?> columnFechaFinalPaquete;

    @FXML
    private TableColumn<?, ?> columnFechaInicialPaquete;

    @FXML
    private TableColumn<?, ?> columnNombreDestino;

    @FXML
    private TableColumn<?, ?> columnNombrePaquete;

    @FXML
    private TableColumn<?, ?> columnPrecioPaquete;

    @FXML
    private DatePicker dtFechaFinal;

    @FXML
    private DatePicker dtFechaInicial;

    @FXML
    private TableView<?> tableViewDestinos;

    @FXML
    private TableView<?> tableViewPaquetes;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtCupoMaximo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    //Variables auxiliares
    private AgenciaApp agenciaApp;
    private Stage stage;
    private GestionarAgenciaController gestionarAgenciaController;
    private Administrador administradorSesion;

    //Uso de singleton
    private final AgenciaViajes agenciaViajes = AgenciaViajes.getInstance();

    public void setAgenciaApp(AgenciaApp agenciaApp) {
        this.agenciaApp = agenciaApp;
    }

    public void init(Stage stage, GestionarAgenciaController gestionarAgenciaController, Administrador administradorSesion) {
        this.stage = stage;
        this.gestionarAgenciaController = gestionarAgenciaController;
        this.administradorSesion = administradorSesion;
    }

    @FXML
    void actualizarPaquete(ActionEvent event) {

    }

    @FXML
    void agregarDestino(ActionEvent event) {

    }

    @FXML
    void crearPaquete(ActionEvent event) {

    }

    @FXML
    void eliminarPaquete(ActionEvent event) {

    }

    @FXML
    void nuevoPaquete(ActionEvent event) {

    }

    /**
     * Regresa a la ventana gestionar agencia
     * @param event
     */
    @FXML
    void regresar(ActionEvent event) {
        this.stage.close();
        gestionarAgenciaController.show();
    }

}
