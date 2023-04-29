package com.fastevent.fastevent.Controladores.PantallaInicial.SesionNoIniciada;

import com.fastevent.fastevent.Controladores.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class IniciarSesion extends Controlador {

    @FXML
    private TextField correoElectronico;

    @FXML
    private PasswordField contrasena;

    @FXML
    private void iniciarSesion() {
        String nombreUsuario = correoElectronico.getText();
        String password = contrasena.getText();
        // Aquí puedes agregar la lógica para autenticar el usuario y contraseña
        System.out.println("Iniciar sesión con el usuario: " + nombreUsuario + " y la contraseña: " + password);
    }

    public void botonIniciarSesion(ActionEvent actionEvent) {
        System.out.println("Iniciar sesión con el usuario: " + correoElectronico.getText() + " y la contraseña: " + contrasena.getText());
    }

    public void botonRegistrarse(ActionEvent actionEvent) {
        System.out.println("Registrarse");
    }

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

    public void accionBotonRegistrarseNav(ActionEvent actionEvent) {
        System.out.println("Registrarse Nav");
    }

    public void iniciarSesionConFacebook(ActionEvent actionEvent) {
        System.out.println("Iniciar sesión con Facebook");
    }

    public void iniciarSesionConTwitter(ActionEvent actionEvent) {
        System.out.println("Iniciar sesión con Twitter");
    }

    public void iniciarSesionConGoogle(ActionEvent actionEvent) {
        System.out.println("Iniciar sesión con Google");
    }

    public void botonNecesitasAyuda(ActionEvent actionEvent) {
        System.out.println("Necesitas ayuda");
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
}