package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class BuscadorPaquetesController {

    @FXML
    private Button btnRealizarFiltro;

    @FXML
    private Button btnRecomendaciones;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnVerPaquete;

    @FXML
    private ComboBox<?> cbNombrePaquete;

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
    private TableColumn<?, ?> columnCuposDisponibles;

    @FXML
    private TableColumn<?, ?> columnFechaFinal;

    @FXML
    private TableColumn<?, ?> columnFechaInicial;

    @FXML
    private TableColumn<?, ?> columnNombre;

    @FXML
    private TableColumn<?, ?> columnPrecio;

    @FXML
    private DatePicker dpFechaFinal;

    @FXML
    private DatePicker dpFechaInicial;

    @FXML
    private TableView<?> tableViewPaquetes;

    @FXML
    private TextField txtCupos;

    @FXML
    private TextField txtPrecioMaximo;

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
    void realizarFiltroRecomendaciones(ActionEvent event) {

    }

    @FXML
    void realizarFiltroUsuario(ActionEvent event) {

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
    void verPaquete(ActionEvent event) {

    }

}
