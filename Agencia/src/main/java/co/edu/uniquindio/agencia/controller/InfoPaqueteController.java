package co.edu.uniquindio.agencia.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InfoPaqueteController {

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnReservarPaquete;

    @FXML
    private Button btnVerDestino;

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
    private TableColumn<?, ?> columnCiudad;

    @FXML
    private TableColumn<?, ?> columnClima;

    @FXML
    private TableColumn<?, ?> columnDescripcion;

    @FXML
    private TableColumn<?, ?> columnNombre;

    @FXML
    private DatePicker dpFechaFinal;

    @FXML
    private DatePicker dpFechaInicial;

    @FXML
    private TableView<?> tableViewDestinos;

    @FXML
    private TextField txtCupos;

    @FXML
    private TextField txtNombrePaquete;

    @FXML
    private TextField txtPrecio;

    @FXML
    void regresar(ActionEvent event) {

    }

    @FXML
    void reservarPaquete(ActionEvent event) {

    }

    @FXML
    void verDestino(ActionEvent event) {

    }

}
