package com.fastevent.fastevent.Controladores;

// Controladores
import com.fastevent.fastevent.Controladores.PantallaInicial.SesionNoIniciada.IniciarSesion;
import com.fastevent.fastevent.FastEvent;

// Constantes dentro del proyecto que contienen direcciones a archivos FXML, imágenes, etc.
import com.fastevent.fastevent.Utilidades.Constantes;

// Librerías de JavaFX
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

// Librerías de JFoenix
import com.jfoenix.controls.JFXDecorator;

// Librerías de Java
import java.io.IOException;
import java.util.Objects;


public interface CargadorPantallas {
    /**
     * Carga una pantalla
     * @param stage Ventana
     * @param nombrePantalla Nombre de la pantalla
     * @throws IOException Excepción de entrada y salida
     */
    static void cargarPantalla(Stage stage, String nombrePantalla) throws IOException {
        // Crear el controlador
        Controlador controller;

        // Obtener el controlador
        switch (nombrePantalla) {
            case "IniciarSesion" -> { // Pantalla de inicio de sesión
                controller = new IniciarSesion();
            }
            default -> { // Pantalla no encontrada
                controller = null;
            }
        }

        // Verificar que el controlador no sea nulo
        assert controller != null;

        // Crear la escena

        // Obtener el nombre del archivo FXML
        String nombreFXML = Constantes.obtenerFXML(nombrePantalla);
        // verificar que el nombre no sea nulo
        assert nombreFXML != null;

        // Cargar el archivo FXML
        FXMLLoader loader = new FXMLLoader(FastEvent.class.getResource(nombreFXML));
        // Crear la escena
        Scene scene = new Scene(loader.load(), 1280, 720);

        // Obtener el controlador
        controller = loader.getController();

        // Crear la ventana
        Stage nStage = new Stage();

        // Establecer el título de la ventana
        nStage.setTitle(nombrePantalla);

        // Establecer la escena
        nStage.setScene(scene);

        // Agregar el logo a la ventana
        nStage.getIcons().add(new Image(Objects.requireNonNull(FastEvent.class.getResourceAsStream(Constantes.logo))));

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
}
