package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

public class BuscadorDestinosController {

    @FXML
    private Button btnRealizarFIltro;

    @FXML
    private Button btnRecomendaciones;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnVerDestino;

    @FXML
    private ComboBox<?> cbCalificacion;

    @FXML
    private ComboBox<?> cbCiudad;

    @FXML
    private ComboBox<?> cbClima;

    @FXML
    private ComboBox<?> cbNombreDestino;

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
    void verDestino(ActionEvent event) {

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
}
