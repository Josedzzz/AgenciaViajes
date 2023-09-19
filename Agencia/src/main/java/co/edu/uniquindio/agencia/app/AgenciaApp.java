package co.edu.uniquindio.agencia.app;

import co.edu.uniquindio.agencia.model.Persona;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AgenciaApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        FXMLLoader loader = new FXMLLoader( AgenciaApp.class.getResource("/VentanaPrincipalView.fxml") );
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Mi agencia");
        stage.show();

    }

    public static void main(String[] args) {
        launch( AgenciaApp.class, args );
    }
}
