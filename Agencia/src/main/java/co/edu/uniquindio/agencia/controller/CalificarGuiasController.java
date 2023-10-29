package co.edu.uniquindio.agencia.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

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

    @FXML
    void enviarCalificacion(ActionEvent event) {

    }

    @FXML
    void regresar(ActionEvent event) {

    }

    @FXML
    void verGuia(ActionEvent event) {

    }

}
