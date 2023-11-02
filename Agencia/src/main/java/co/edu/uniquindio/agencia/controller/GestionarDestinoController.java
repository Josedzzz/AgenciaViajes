package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.Administrador;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class GestionarDestinoController {

    @FXML
    private Button btnActualizarDestino;

    @FXML
    private Button btnCrearDestino;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnNuevoDestino;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnSuberImagen;

    @FXML
    private ComboBox<?> cbClima;

    @FXML
    private TableColumn<?, ?> columnCiudad;

    @FXML
    private TableColumn<?, ?> columnClima;

    @FXML
    private TableColumn<?, ?> columnDescripcion;

    @FXML
    private TableColumn<?, ?> columnNombre;

    @FXML
    private TableView<?> tableViewDestinos;

    @FXML
    private ImageView imageViewDestino;

    @FXML
    private TextArea textAreaDescripcion;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtImagen;

    @FXML
    private TextField txtNombre;

    //Declaro variables auxiliares
    private Stage stage;
    private AgenciaApp agenciaApp;
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
    void actualizarDestino(ActionEvent event) {

    }

    @FXML
    void crearDestino(ActionEvent event) {

    }

    @FXML
    void eliminarDestino(ActionEvent event) {

    }

    @FXML
    void nuevoDestino(ActionEvent event) {

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

    @FXML
    void subirImagen(ActionEvent event) {

    }

}

