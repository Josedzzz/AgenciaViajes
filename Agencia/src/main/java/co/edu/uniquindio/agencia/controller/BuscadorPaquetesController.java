package co.edu.uniquindio.agencia.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    @FXML
    void realizarFiltroRecomendaciones(ActionEvent event) {

    }

    @FXML
    void realizarFiltroUsuario(ActionEvent event) {

    }

    @FXML
    void regresar(ActionEvent event) {

    }

    @FXML
    void verPaquete(ActionEvent event) {

    }

}
