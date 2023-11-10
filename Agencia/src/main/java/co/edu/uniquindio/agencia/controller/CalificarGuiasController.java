package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CalificarGuiasController {

    @FXML
    private Button btnEnviarCalificacion;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnVerGuia;

    @FXML
    private TableColumn<?, ?> columnAniosExperiencia;

    @FXML
    private TableColumn<?, ?> columnCorreo;

    @FXML
    private TableColumn<?, ?> columnNombre;

    @FXML
    private TableColumn<?, ?> columnTelefono;

    @FXML
    private TableView<?> tableViewGuias;

    @FXML
    private TextArea textAreaComentario;

    @FXML
    private TextField txtCalificacion;

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
    void enviarCalificacion(ActionEvent event) {

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

}
