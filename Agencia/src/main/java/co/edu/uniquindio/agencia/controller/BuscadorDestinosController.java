package co.edu.uniquindio.agencia.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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

    @FXML
    void regresar(ActionEvent event) {

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

}
