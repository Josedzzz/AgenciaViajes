package co.edu.uniquindio.agencia.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CalificarDestinosController {

    @FXML
    private Button btnEnviarCalificacion;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnVerDestino;

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
    void verDestino(ActionEvent event) {

    }

}