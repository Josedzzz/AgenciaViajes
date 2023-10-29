package co.edu.uniquindio.agencia.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class InfoDestinoController {

    @FXML
    private ImageView ImageViewImagenDestino;

    @FXML
    private Button btnImagenAnterior;

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnSiguienteImagen;

    @FXML
    private TableColumn<?, ?> columnCalificacion;

    @FXML
    private TableColumn<?, ?> columnComentario;

    @FXML
    private TableColumn<?, ?> columnNombreCliente;

    @FXML
    private TableView<?> tableViewCalificaciones;

    @FXML
    private TextArea textAreaDescripcion;

    @FXML
    private TextField txtCiudad;

    @FXML
    private TextField txtClima;

    @FXML
    private TextField txtNombreDestino;

    @FXML
    void imagenAnterior(ActionEvent event) {

    }

    @FXML
    void regresar(ActionEvent event) {

    }

    @FXML
    void siguienteImagen(ActionEvent event) {

    }

}
