package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import co.edu.uniquindio.agencia.model.Cliente;
import co.edu.uniquindio.agencia.model.Destino;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class BuscadorDestinosController implements Initializable {

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
    private TableColumn<Destino, String> columnCiudad;

    @FXML
    private TableColumn<Destino, String> columnClima;

    @FXML
    private TableColumn<Destino, String> columnDescripcion;

    @FXML
    private TableColumn<Destino, String> columnNombre;

    @FXML
    private TableView<Destino> tableViewDestinos;

    //Variables auxiliares
    private Stage stage;
    private AgenciaApp agenciaApp;
    private InicioController inicioController;
    private Cliente clienteSesion;
    private ObservableList<Destino> listadoDestinos = FXCollections.observableArrayList();
    private Destino destinoSeleccion;

    //Uso de singleton
    private final AgenciaViajes agenciaViajes = AgenciaViajes.getInstance();

    public void setAgenciaApp(AgenciaApp agenciaApp) {
        this.agenciaApp = agenciaApp;
        //Lista de destinos a mostrar
        tableViewDestinos.getItems().clear();
        tableViewDestinos.setItems(getListaDestinos());
    }

    /**
     * Obtiene la lista de destinos
     * @return la lista de destinos como una observableList para la tableView
     */
    private ObservableList<Destino> getListaDestinos() {
        listadoDestinos.clear();
        listadoDestinos.addAll(agenciaViajes.getListaDestinos());
        return listadoDestinos;
    }

    public void init(Stage stage, InicioController inicioController, Cliente clienteSesion) {
        this.stage = stage;
        this.inicioController = inicioController;
        this.clienteSesion = clienteSesion;
    }

    /**
     * Muestra la ventana de buscador de destinos
     */
    public void show() {
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Datos en la tableView de destinos
        this.columnNombre.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
        this.columnCiudad.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getCiudad()));
        this.columnClima.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getTipoClima().toString()));
        this.columnDescripcion.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getDescripcion()));
        //Seleccion de destinos en la tableView
        tableViewDestinos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                destinoSeleccion = newSelection;
                destinoSeleccion = tableViewDestinos.getSelectionModel().getSelectedItem();
            }
        });
    }

    /**
     * Muestra el destino seleccionado en la ventana de infoDestinos
     * @param event
     * @throws IOException
     */
    @FXML
    void verDestino(ActionEvent event) throws IOException {
        if (destinoSeleccion != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AgenciaApp.class.getResource("/views/InfoDestinoView.fxml"));
            BorderPane borderPane = (BorderPane) loader.load();
            InfoDestinoController controller = loader.getController();
            controller.setAgenciaApp(agenciaApp);
            Scene scene = new Scene(borderPane);
            Stage stage = new Stage();
            stage.setTitle("Información del destino");
            stage.setScene(scene);
            controller.init(stage, this, clienteSesion, destinoSeleccion);
            stage.show();
            this.stage.close();
        } else {
            mostrarMensaje("Agencia", "Buscador de Destinos", "Por favor seleccione un destino", Alert.AlertType.WARNING);
        }
    }

    @FXML
    void realizarFiltroRecomendaciones(ActionEvent event) {

    }

    @FXML
    void realizarFiltroUsuario(ActionEvent event) {

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
