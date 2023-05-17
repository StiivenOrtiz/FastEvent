package com.fastevent.fastevent.Controladores;

// Controladores

import com.fastevent.fastevent.FastEvent;
import com.fastevent.fastevent.Utilidades.Constantes;
import com.jfoenix.controls.JFXDecorator;
import javafx.animation.ScaleTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;


public interface CargadorPantallas {
    /**
     * Carga una pantalla
     *
     * @param stage          Ventana
     * @param nombrePantalla Nombre de la pantalla
     * @throws IOException Excepción de entrada y salida
     */
    static void cargarPantalla(String nombrePantalla, String direccionFXML, Stage stage, boolean primeraVentana) throws IOException {
        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(FastEvent.class.getResource(direccionFXML));

        // Crear la escena
        Scene scene = new Scene(loader.load(), 1280, 720);

        // Obtener el controlador
        Controlador controller = loader.getController();

        // Crear la ventana
        Stage nstage = new Stage();

        // Establecer el título de la ventana
        nstage.setTitle(nombrePantalla);

        // Establecer la escena
        nstage.setScene(scene);

        // Agregar el logo a la ventana
        nstage.getIcons().add(new Image(Objects.requireNonNull(FastEvent.class.getResourceAsStream(Constantes.icono))));

        // Crear el decorador y agregar la escena permite mover la ventana, maximizarla y cerrarla
        JFXDecorator decorator = new JFXDecorator(nstage, scene.getRoot(), false, true, true);

        // Agregar el botón de maximizar
        decorator.setCustomMaximize(true);

        // Agregar el botón de cerrar
        decorator.setOnCloseButtonAction(nstage::close);

        // Agregar el decorador a la ventana
        Scene decoratedScene = new Scene(decorator, 1280, 720);

        // Establecer la escena decorada
        nstage.setScene(decoratedScene);

        // Establecer de que la ventana sea redimensionable
        nstage.setResizable(true);

        // Establecer la posición y el tamaño de la ventana
        if (!primeraVentana) {
            nstage.setX(stage.getX());
            nstage.setY(stage.getY());
            nstage.setWidth(stage.getWidth());
            nstage.setHeight(stage.getHeight());
        }

        // Establecer la ventana en el controlador
        controller.setStage(nstage);

        // Mostrar la ventana
        nstage.show();

        // Animación de fundido
        if (!primeraVentana) {
            ScaleTransition scaleTransition2 = new ScaleTransition(Duration.seconds(0.2), stage.getScene().getRoot());
            scaleTransition2.setOnFinished(event -> {
                try {
                    // Mostrar la siguiente ventana después de que finalice la transición de fundido
                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            scaleTransition2.play();
        }
    }
}
