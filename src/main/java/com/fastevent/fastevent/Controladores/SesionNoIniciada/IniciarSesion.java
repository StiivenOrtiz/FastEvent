package com.fastevent.fastevent.Controladores.SesionNoIniciada;

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Interfaces.IAutenticacion;
import com.fastevent.fastevent.Logica.Autenticacion;
import com.fastevent.fastevent.Utilidades.Constantes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class IniciarSesion extends Controlador {

    @FXML
    private TextField correoElectronico;

    @FXML
    private PasswordField contrasena;

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

    public void accionBotonTwitter(ActionEvent actionEvent) {
        System.out.println("Twitter");
    }

    public void accionBotonLinkedin(ActionEvent actionEvent) {
        System.out.println("Linkedin");
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

    public void accionBotonPreguntasFrecuentes(ActionEvent actionEvent) {
        System.out.println("Preguntas frecuentes");
    }

    public void botonIniciarSesion(ActionEvent actionEvent) {
        boolean error = false;
        String mensajeError = "";
        String instrucciones = "";

        if (!correoElectronico.getText().isEmpty() && !contrasena.getText().isEmpty()) {
            IAutenticacion autenticacion = new Autenticacion();
            if (autenticacion.iniciarSesion(correoElectronico.getText(), contrasena.getText())) {
                mostrarMensajeInformativo("Bienvenido", "Bienvenido a FastEvent", "Inicio de sesión exitoso");
                // Cuando cierre el mensaje informativo cambia de pantalla
                cargarPantalla("Inicio", Constantes.obtenerFXML("InicioSI"));
            } else {
                error = true;
                mensajeError = "Credenciales incorrectas";
                instrucciones = "Por favor, ingrese sus credenciales nuevamente";
            }
        } else {
            error = true;
            mensajeError = "Campos vacíos";
            instrucciones = "Por favor, ingrese su correo electrónico y contraseña";
        }

        if (error)
            mostrarMensajeError(mensajeError, instrucciones);
    }

    public void botonRegistrarse(ActionEvent actionEvent) {
        cargarPantalla("Registrarse", Constantes.obtenerFXML("Registrarse"));
    }
}