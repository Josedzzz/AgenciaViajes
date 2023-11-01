package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.Administrador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GestionarAgenciaController {

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnDestinos;

    @FXML
    private Button btnGuias;

    @FXML
    private Button btnPaquetes;

    @FXML
    private Button btnVerEstadisticas;

    //Declaro variables auxiliares
    private Stage stage;
    private AgenciaApp agenciaApp;
    private IniciarSesionController iniciarSesionController;
    private Administrador administradorSesion;

    public void setAgenciaApp(AgenciaApp agenciaApp) {
        this.agenciaApp = agenciaApp;
    }

    public void init(Stage stage, IniciarSesionController iniciarSesionController, Administrador administradorSesion) {
        this.stage = stage;
        this.iniciarSesionController = iniciarSesionController;
        this.administradorSesion = administradorSesion;
    }

    @FXML
    void cerrarSesion(ActionEvent event) {

    }

    @FXML
    void gestionarDestinos(ActionEvent event) {

    }

    @FXML
    void gestionarGuias(ActionEvent event) {

    }

    @FXML
    void gestionarPaquetes(ActionEvent event) {

    }

    @FXML
    void verEstadisticas(ActionEvent event) {

    }

}
