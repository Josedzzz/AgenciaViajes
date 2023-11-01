package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.exceptions.AdminNoEncontradoException;
import co.edu.uniquindio.agencia.exceptions.AtributosVaciosException;
import co.edu.uniquindio.agencia.model.Administrador;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import co.edu.uniquindio.agencia.model.Cliente;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class IniciarSesionController implements Initializable {

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegresar;

    @FXML
    private RadioButton radioButtonAdministrador;

    @FXML
    private RadioButton radioButtonCliente;

    @FXML
    private TextField txtCedula;

    @FXML
    private TextField txtContrasenia;

    //Variables auxiliares
    private AgenciaApp agenciaApp;
    private Stage stage;
    private InicioController inicioController;
    private Cliente clienteSesion;
    private Administrador administradorSesion;

    //Uso de singleton
    private final AgenciaViajes agenciaViajes = AgenciaViajes.getInstance();

    public void setAgenciaApp(AgenciaApp agenciaApp) {
        this.agenciaApp = agenciaApp;
    }

    public void init(Stage stage, InicioController inicioController) {
        this.stage = stage;
        this.inicioController = inicioController;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Agrego a un mismo grupo los radioButtoms
        ToggleGroup group = new ToggleGroup();
        radioButtonCliente.setToggleGroup(group);
        radioButtonAdministrador.setToggleGroup(group);
    }

    /**
     * Muestra la ventana para iniciar sesion
     */
    public void show() {
        stage.show();
        //Limpio los campos de la ventana
        txtCedula.setText("");
        txtContrasenia.setText("");
        radioButtonCliente.setSelected(false);
        radioButtonAdministrador.setSelected(false);
    }

    /**
     * Login de la aplicacion dependiendo del radioButtom.
     * Puede loggear clientes y admins
     * @param event
     */
    @FXML
    void iniciarSesion(ActionEvent event) {
        String cedula = txtCedula.getText();
        String contrasenia = txtContrasenia.getText();
        boolean admin = radioButtonAdministrador.isSelected();
        boolean cliente = radioButtonCliente.isSelected();
        try {
            agenciaViajes.validarDatosInicioSesion(cedula, contrasenia, admin, cliente);
            if (radioButtonAdministrador.isSelected()) {
                iniciarSesionAdmin(cedula, contrasenia);
            } else {
                iniciarSesionCliente(cedula, contrasenia);
            }
        } catch (AtributosVaciosException e) {
            mostrarMensaje("Agencia", "Iniciar Sesión", e.getMessage(), Alert.AlertType.WARNING);
        }
    }

    /**
     * Ingresa sesion como administrador
     * @param cedula del administrador
     * @param contrasenia del administrador
     */
    private void iniciarSesionAdmin(String cedula, String contrasenia) {
        try {
            administradorSesion = agenciaViajes.iniciarSesionAdmin(cedula, contrasenia, 0);
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AgenciaApp.class.getResource("/views/GestionarAgenciaView.fxml"));
            BorderPane borderPane = (BorderPane) loader.load();
            GestionarAgenciaController controller = loader.getController();
            controller.setAgenciaApp(agenciaApp);
            Scene scene = new Scene(borderPane);
            Stage stage = new Stage();
            stage.setTitle("Gestionar Agencia");
            stage.setScene(scene);
            controller.init(stage, this, administradorSesion);
            stage.show();
            this.stage.close();
        } catch (AdminNoEncontradoException e) {
            mostrarMensaje("Agencia", "Iniciar Sesión", e.getMessage(), Alert.AlertType.WARNING);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Ingresa la sesion como cliente
     * @param cedula del cliente
     * @param contrasenia del cliente
     */
    private void iniciarSesionCliente(String cedula, String contrasenia) {
        mostrarMensaje("Agencia", "Iniciar Sesión", "Se está trabajando en esto", Alert.AlertType.WARNING);
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

    /**
     * Muestra un mensaje dependiendo el tipo de alerta seleccionado
     * @param title
     * @param header
     * @param content
     * @param alertType
     */
    private void mostrarMensaje(String title, String header, String content, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.showAndWait();
    }

}