package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.Administrador;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class GestionarGuiaController {

    @FXML
    private Button btnActualizarGuia;

    @FXML
    private Button btnCrearGuia;

    @FXML
    private Button btnEliminarGuia;

    @FXML
    private Button btnNuevoGuia;

    @FXML
    private Button btnRegresar;

    @FXML
    private CheckBox checkBoxEspaniol;

    @FXML
    private CheckBox checkBoxFrances;

    @FXML
    private CheckBox checkBoxIngles;

    @FXML
    private TableColumn<?, ?> columnAniosExperiencia;

    @FXML
    private TableColumn<?, ?> columnCorreo;

    @FXML
    private TableColumn<?, ?> columnNmbre;

    @FXML
    private TableColumn<?, ?> columnTelefono;

    @FXML
    private TableView<?> tableViewGuia;

    @FXML
    private TextField txtAñosExperiencia;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtContraseña;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtResidencia;

    @FXML
    private TextField txtTelefono;

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
    void actualizarGuia(ActionEvent event) {

    }

    @FXML
    void crearGuia(ActionEvent event) {

    }

    @FXML
    void eliminarGuia(ActionEvent event) {

    }

    @FXML
    void nuevoGuia(ActionEvent event) {

    }

    /**
     * Regresa a la ventana de gestionar agencia
     * @param event
     */
    @FXML
    void regresar(ActionEvent event) {
        this.stage.close();
        gestionarAgenciaController.show();
    }

}
