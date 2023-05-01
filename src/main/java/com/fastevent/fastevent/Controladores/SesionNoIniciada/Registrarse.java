package com.fastevent.fastevent.Controladores.SesionNoIniciada;

import com.fastevent.fastevent.Controladores.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Registrarse extends Controlador {

    @FXML
    public TextField correoElectronico;

    @FXML
    private PasswordField contrasena;

    @FXML
    public TextField nombres;

    @FXML
    public TextField apellidos;

    @FXML
    public TextField repetirCorreoElectronico;

    @FXML
    public PasswordField repetirContrasena;

    @FXML
    public CheckBox checkBoxAceptarTerminos;

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

    public void accionBotonTwitter(ActionEvent actionEvent) {
        System.out.println("Twitter");
    }

    public void accionBotonLinkedin(ActionEvent actionEvent) {
        System.out.println("Linkedin");
    }

    public void accionBotonPreguntasFrecuentes(ActionEvent actionEvent) {
        System.out.println("Preguntas frecuentes");
    }

    public void registrarseConFacebook(ActionEvent actionEvent) {
        System.out.println("Registrarse con Facebook");
    }

    public void registrarseConTwitter(ActionEvent actionEvent) {
        System.out.println("Registrarse con Twitter");
    }

    public void registrarseConGoogle(ActionEvent actionEvent) {
        System.out.println("Registrarse con Google");
    }

    public void botonIniciarSesion(ActionEvent actionEvent) {
        System.out.println("Boton iniciar sesion");
    }

    public void botonRegistrarse(ActionEvent actionEvent) {
        System.out.println("Boton registrarse");
    }
}