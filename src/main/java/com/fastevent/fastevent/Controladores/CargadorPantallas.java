package com.fastevent.fastevent.Controladores;

import com.fastevent.fastevent.Controladores.PantallaInicial.SesionNoIniciada.IniciarSesion;
import com.fastevent.fastevent.FastEvent;
import com.fastevent.fastevent.Utilidades.Constantes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public interface  CargadorPantallas {
    static void cargarPantalla(Stage stage, String nombrePantalla) throws IOException {
        Controlador controller;

        switch (nombrePantalla) {
            case "IniciarSesion" -> {
                controller = new IniciarSesion();
            }
            default -> {
                controller = null;
            }
        }
        //assert controller != null;

        String nombreFXML = Constantes.obtenerFXML(nombrePantalla);
        assert nombreFXML != null;

        FXMLLoader loader = new FXMLLoader(FastEvent.class.getResource(nombreFXML));
        Scene scene = new Scene(loader.load(), 1280, 720);
        controller = loader.getController();
        Stage nStage = new Stage();
        nStage.setTitle(nombrePantalla);
        nStage.setScene(scene);
        // nStage.getIcons().add(new Image(Objects.requireNonNull(FastU.class.getResourceAsStream(Constantes.logo))));
        controller.setStage(nStage);

        nStage.show();
    }
}
