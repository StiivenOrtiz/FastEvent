package com.fastevent.fastevent.Controladores;

import com.fastevent.fastevent.Modelo.Publicacion;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Controlador {
    public Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    protected void cargarPantalla(String nombrePantalla, String direccionFXML) {
        try {
            CargadorPantallas.cargarPantalla(nombrePantalla, direccionFXML, this.stage, false);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No se pudo cargar la pantalla: " + nombrePantalla);
            alert.setHeaderText("ERROR DE CARGADOR DE PANTALLAS");
            alert.show();
        }
    }

    protected void cargarPublicacionesCategoria(String categoria) {
        try {
            CargadorPantallas.cargarCategoria(this.stage, categoria);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No se pudo cargar la pantalla: " + categoria);
            alert.setHeaderText("ERROR DE CARGADOR DE PANTALLAS");
            alert.show();
        }
    }

    protected void cargarPublicacion(Publicacion publicacion) {
        try {
            CargadorPantallas.cargarPublicacion(this.stage, publicacion);
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("No se pudo cargar la pantalla: " + publicacion);
            alert.setHeaderText("ERROR DE CARGADOR DE PANTALLAS");
            alert.show();
        }
    }

    protected void mostrarMensajeError(String mensajeError, String instrucciones) {
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setTitle("Error");
        alerta.setHeaderText(mensajeError);
        alerta.setContentText(instrucciones);
        alerta.showAndWait();
    }

    protected void mostrarMensajeInformativo(String mensaje, String instrucciones, String titulo) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(mensaje);
        alerta.setContentText(instrucciones);
        alerta.showAndWait();
    }
}
