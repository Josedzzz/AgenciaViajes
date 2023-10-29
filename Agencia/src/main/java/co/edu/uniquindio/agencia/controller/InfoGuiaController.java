package co.edu.uniquindio.agencia.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class InfoGuiaController {

    @FXML
    private Button btnRegresar;

    @FXML
    private TableColumn<?, ?> columnCalificacion;

    @FXML
    private TableColumn<?, ?> columnComentario;

    @FXML
    private TableColumn<?, ?> columnNombreCliente;

    @FXML
    private TableView<?> tableViewCalificaciones;

    @FXML
    private TextField txtAniosExperiencia;

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtTelefono;

    @FXML
    void regresar(ActionEvent event) {

    }

}

