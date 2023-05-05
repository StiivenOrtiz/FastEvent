package com.fastevent.fastevent.Controladores.SesionIniciada;

import com.fastevent.fastevent.Controladores.Controlador;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.ListView;
import javafx.stage.Popup;

public class InicioSI extends Controlador {

    /*
        Variables
     */

    // Métodos de la barra de navegación

    public void botonLogoRectangularPresionado(ActionEvent actionEvent) {
        System.out.println("Logo rectangular presionado");
    }

    public void accionBotonInicio(ActionEvent actionEvent) {
        System.out.println("Inicio");
    }

    public void accionBotonPrecios(ActionEvent actionEvent) {
        System.out.println("Precios");
    }

    public void accionBotonNosotros(ActionEvent actionEvent) {
        System.out.println("Nosotros");
    }

    public void accionBotonContactenos(ActionEvent actionEvent) {
        System.out.println("Contactenos");
    }

    public void accionBotonBoleteria(ActionEvent actionEvent) {
        System.out.println("Boleteria");
    }

    public void botonIniciarSesion(ActionEvent actionEvent) {
        System.out.println("Iniciar sesion");
    }

    public void botonRegistrarse(ActionEvent actionEvent) {
        System.out.println("Registrarse");
    }

    // Métodos del footer

    public void accionBotonTwitter(ActionEvent actionEvent) {
        System.out.println("Twitter");
    }

    public void accionBotonLinkedin(ActionEvent actionEvent) {
        System.out.println("Linkedin");
    }

    public void botonTerminos(ActionEvent actionEvent) {
        System.out.println("Terminos");
    }

    public void botonPrivacidad(ActionEvent actionEvent) {
        System.out.println("Privacidad");
    }

    public void accionBotonFacebook(ActionEvent actionEvent) {
        System.out.println("Facebook");
    }

    public void accionBotonInstagram(ActionEvent actionEvent) {
        System.out.println("Instagram");
    }

    public void accionBotonPreguntasFrecuentes(ActionEvent actionEvent) {
        System.out.println("Preguntas frecuentes");
    }

    public void accionBotonUsuarios(ActionEvent actionEvent) {
        System.out.println("Usuarios");
    }

    public void accionBotonMercado(ActionEvent actionEvent) {
        System.out.println("Mercado");
    }

    public void accionBotonMisBoletas(ActionEvent actionEvent) {
        System.out.println("Mis boletas");
    }

    public void accionBotonMisEventos(ActionEvent actionEvent) {
        System.out.println("Mis eventos");

        notifStatus.set(true);
        String nuevaNotif = "Se ha recibido una nueva notificación";
        notifList.getItems().add(nuevaNotif);
    }

    /*
        Metodos de la interfaz
     */

    @FXML
    private Button notifButton;
    @FXML
    private ListView<String> notifList;
    @FXML
    ContextMenu notifMenu;

    private BooleanProperty notifStatus = new SimpleBooleanProperty(false);

    public void initialize() {
        // Agregar el ChangeListener al estado de la notificación
        notifStatus.addListener((obs, oldVal, newVal) -> {
            if (newVal) {
                notifButton.getStyleClass().add("notification");
            } else {
                notifButton.getStyleClass().remove("notification");
            }
        });

        // Crear el ContextMenu
        notifMenu.setAutoHide(true);
        notifMenu.getItems().add(new CustomMenuItem(notifList));

        // Configurar el menú contextual para mostrar el ListView cuando se abre


        // Configurar el botón de notificación para mostrar el menú contextual
        notifButton.setContextMenu(notifMenu);
    }

    public void showNotifContextMenu(ActionEvent actionEvent) {
        // Mostrar el menú contextual cuando se hace clic en el botón de notificación
        notifButton.getContextMenu().show(notifButton, Side.BOTTOM, 0, 0);
    }
}