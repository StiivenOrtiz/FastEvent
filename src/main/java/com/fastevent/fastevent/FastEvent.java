package com.fastevent.fastevent;

import com.fastevent.fastevent.Controladores.CargadorPantallas;
import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class FastEvent extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        /*
        FXMLLoader fxmlLoader = new FXMLLoader(FastEvent.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
         */

        /*
        FXMLLoader loader = new FXMLLoader(FastEvent.class.getResource("Test.fxml"));
        Scene scene = new Scene(loader.load(), 1280, 720);
        Test testController = loader.getController();
        Stage nStage = new Stage();
        nStage.setTitle("Test");
        nStage.setScene(scene);
        // nStage.getIcons().add(new Image(Objects.requireNonNull(FastU.class.getResourceAsStream(Constantes.logo))));
        testController.setStage(nStage);
        nStage.show();
         */

        String nombrePantalla = "IniciarSesion";
        try {
            CargadorPantallas.cargarPantalla(stage, nombrePantalla);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No se pudo cargar la pantalla: " + nombrePantalla);
            alert.setHeaderText("ERROR DE CARGADOR DE PANTALLAS");
            alert.show();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}