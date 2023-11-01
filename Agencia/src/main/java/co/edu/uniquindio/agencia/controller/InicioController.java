package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class InicioController {

    @FXML
    private Button btnCalificarDestinos;

    @FXML
    private Button btnCalificarGuias;

    @FXML
    private Button btnChatConAsesor;

    @FXML
    private Button btnConocerDestinos;

    @FXML
    private Button btnConocerPaquetes;

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnModificarPerfil;

    @FXML
    private Button btnRegistrarse;

    @FXML
    private Button btnVerMisReservas;

    //Variables auxiliares
    private AgenciaApp agenciaApp;
    private Stage stage;

    //Uso de singleton
    private final AgenciaViajes agenciaViajes = AgenciaViajes.getInstance();

    public void setAgenciaApp(AgenciaApp agenciaApp) {
        this.agenciaApp = agenciaApp;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void calificarDestinos(ActionEvent event) {

    }

    @FXML
    void calificarGuias(ActionEvent event) {

    }

    @FXML
    void chatConAsesor(ActionEvent event) {

    }

    @FXML
    void conocerDestinos(ActionEvent event) {

    }

    @FXML
    void conocerPaquetes(ActionEvent event) {

    }

    /**
     * Lleva a la ventana iniciarSesion
     * @param event
     */
    @FXML
    void iniciarSesion(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AgenciaApp.class.getResource("/views/IniciarSesionView.fxml"));
        BorderPane borderPane = (BorderPane) loader.load();
        IniciarSesionController controller = loader.getController();
        controller.setAgenciaApp(agenciaApp);
        Scene scene = new Scene(borderPane);
        Stage stage = new Stage();
        stage.setTitle("Iniciar sesión");
        stage.setScene(scene);
        controller.init(stage, this);
        stage.show();
        this.stage.close();
    }

    @FXML
    void modificarPerfil(ActionEvent event) {

    }

    @FXML
    void registrarse(ActionEvent event) {

    }

    @FXML
    void verReservas(ActionEvent event) {

    }

}
