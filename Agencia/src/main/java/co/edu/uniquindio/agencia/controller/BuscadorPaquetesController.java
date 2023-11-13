package co.edu.uniquindio.agencia.controller;

import co.edu.uniquindio.agencia.app.AgenciaApp;
import co.edu.uniquindio.agencia.model.AgenciaViajes;
import co.edu.uniquindio.agencia.model.Cliente;
import co.edu.uniquindio.agencia.model.PaqueteTuristico;
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

import javax.imageio.stream.ImageOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BuscadorPaquetesController implements Initializable {

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
    private TableView<PaqueteTuristico> tableViewPaquetes;

    @FXML
    private TableColumn<PaqueteTuristico, String> columnCuposDisponibles;

    @FXML
    private TableColumn<PaqueteTuristico, String> columnFechaFinal;

    @FXML
    private TableColumn<PaqueteTuristico, String> columnFechaInicial;

    @FXML
    private TableColumn<PaqueteTuristico, String> columnNombre;

    @FXML
    private TableColumn<PaqueteTuristico, String> columnPrecio;

    @FXML
    private DatePicker dpFechaFinal;

    @FXML
    private DatePicker dpFechaInicial;

    @FXML
    private TextField txtCupos;

    @FXML
    private TextField txtPrecioMaximo;

    //Variables auxiliares
    private Stage stage;
    private AgenciaApp agenciaApp;
    private InicioController inicioController;
    private Cliente clienteSesion;
    private ObservableList<PaqueteTuristico> listadoPaquetes = FXCollections.observableArrayList();
    private PaqueteTuristico paqueteSeleccion;

    //Uso de singleton
    private final AgenciaViajes agenciaViajes = AgenciaViajes.getInstance();

    public void setAgenciaApp(AgenciaApp agenciaApp) {
        this.agenciaApp = agenciaApp;
        //Lista de paquetes a mostrar
        tableViewPaquetes.getItems().clear();
        tableViewPaquetes.setItems(getListaPaquetes());
    }

    /**
     * Obtiene la lista de paquetes
     * @return lista de paquetes como un ObservableList para la tableView
     */
    private ObservableList<PaqueteTuristico> getListaPaquetes() {
        listadoPaquetes.clear();
        listadoPaquetes.addAll(agenciaViajes.getListaPaquetesTuristicos());
        return listadoPaquetes;
    }

    public void init(Stage stage, InicioController inicioController, Cliente clienteSesion) {
        this.stage = stage;
        this.inicioController = inicioController;
        this.clienteSesion = clienteSesion;
    }

    /**
     * Muestra la ventana de buscador de paquetes
     */
    public void show() {
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Datos en la tableView de paquetes
        this.columnNombre.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getNombre()));
        this.columnFechaInicial.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getFechaInicial().toString()));
        this.columnFechaFinal.setCellValueFactory(e -> new ReadOnlyStringWrapper(e.getValue().getFechaFinal().toString()));
        this.columnPrecio.setCellValueFactory(e -> {
            double precio = e.getValue().getPrecio();
            String precioString = String.valueOf(precio);
            return new ReadOnlyStringWrapper(precioString);
        });
        this.columnCuposDisponibles.setCellValueFactory(e -> {
            int cuposDisponibles = e.getValue().getCupoDisponible();
            String cuposString = String.valueOf(cuposDisponibles);
            return new ReadOnlyStringWrapper(cuposString);
        });
        //Seleccion de paquetes turisticos en la tabla
        tableViewPaquetes.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                paqueteSeleccion = newSelection;
                paqueteSeleccion = tableViewPaquetes.getSelectionModel().getSelectedItem();
            }
        });
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
     * Muestra el paquete seleccionado en la ventana de infoPaquete
     * @param event
     * @throws IOException
     */
    @FXML
    void verPaquete(ActionEvent event) throws IOException {
        if (paqueteSeleccion != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AgenciaApp.class.getResource("/views/InfoPaqueteView.fxml"));
            BorderPane borderPane = (BorderPane) loader.load();
            InfoPaqueteController controller = loader.getController();
            controller.setAgenciaApp(agenciaApp);
            Scene scene = new Scene(borderPane);
            Stage stage = new Stage();
            stage.setTitle("Información del Paquete Turístico");
            stage.setScene(scene);
            controller.init(stage, this, clienteSesion, paqueteSeleccion);
            stage.show();
            this.stage.close();
        } else {
            mostrarMensaje("Agencia", "Buscador de Paquetes", "Por favor seleccione un paquete", Alert.AlertType.WARNING);
        }
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
