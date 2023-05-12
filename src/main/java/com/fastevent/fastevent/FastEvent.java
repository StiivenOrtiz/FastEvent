package com.fastevent.fastevent;

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Utilidades.Constantes;
import com.jfoenix.controls.JFXDecorator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

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

        /*
        String nombrePantalla = "Registrarse";
        try {
            CargadorPantallas.cargarPantalla(stage, nombrePantalla);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No se pudo cargar la pantalla: " + nombrePantalla);
            alert.setHeaderText("ERROR DE CARGADOR DE PANTALLAS");
            alert.show();
        }
         */

        /*
         ****************************************************************************************
         ************          Datos de entrada para probar archivos .fxml           ************
         ****************************************************************************************
         */

        String nombrePantalla = "Categoria Publicaciones";
        String direccionFXML = "SesionIniciada/Inicio/Inicio.fxml";

        /*
         ****************************************************************************************
         ************                          ¡¡NO TOCAR!!                          ************
         ****************************************************************************************
         */

        // Obtener el nombre del archivo FXML

        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(FastEvent.class.getResource(direccionFXML));
        // Crear la escena
        Scene scene = new Scene(loader.load(), 1280, 720);

        // Obtener el controlador
        Controlador controller = loader.getController();

        // Crear la ventana
        Stage nStage = new Stage();

        // Establecer el título de la ventana
        nStage.setTitle(nombrePantalla);

        // Establecer la escena
        nStage.setScene(scene);

        // Agregar el logo a la ventana
        nStage.getIcons().add(new Image(Objects.requireNonNull(FastEvent.class.getResourceAsStream(Constantes.icono))));

        // Establecer la ventana en el controlador
        controller.setStage(nStage);

        // Crear el decorador y agregar la escena
        // Permite mover la ventana, maximizarla y cerrarla
        JFXDecorator decorator = new JFXDecorator(nStage, scene.getRoot(), false, true, true);

        // Agregar el botón de maximizar
        decorator.setCustomMaximize(true);

        // Agregar el botón de cerrar
        decorator.setOnCloseButtonAction(nStage::close);

        // Agregar el decorador a la ventana
        Scene decoratedScene = new Scene(decorator, 1280, 720);

        // Establecer la escena decorada
        nStage.setScene(decoratedScene);

        // Estilo transparente sin botones de maximizar/minimizar
        //nStage.initStyle(StageStyle.TRANSPARENT);

        // Establecer de que la ventana sea redimensionable
        nStage.setResizable(true);

        // Mostrar la ventana
        nStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}