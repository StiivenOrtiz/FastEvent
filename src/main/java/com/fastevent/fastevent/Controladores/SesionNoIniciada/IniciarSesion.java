package com.fastevent.fastevent.Controladores.SesionNoIniciada;


import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Interfaces.IAutenticacion;
import com.fastevent.fastevent.Logica.Autenticacion;
import com.fastevent.fastevent.Utilidades.DIRECCIONESFXML;
import com.fastevent.fastevent.Utilidades.NOMBRESPANTALLAS;
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
        cargarPantalla(NOMBRESPANTALLAS.INICIOSNI, DIRECCIONESFXML.INICIOSNI);
    }

    public void accionBotonInicio(ActionEvent actionEvent) {
        cargarPantalla(NOMBRESPANTALLAS.INICIOSNI, DIRECCIONESFXML.INICIOSNI);
    }

    public void accionBotonPrecios(ActionEvent actionEvent) {
        cargarPantalla(NOMBRESPANTALLAS.PRECIOS, DIRECCIONESFXML.PRECIOS);
    }

    public void accionBotonNosotros(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Nosotros");

    }

    public void accionBotonContactenos(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Contactenos");
    }

    public void accionBotonBoleteria(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Boleteria");
    }

    public void accionBotonTwitter(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Twitter");
    }

    public void accionBotonLinkedin(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Linkedin");
    }

    public void iniciarSesionConFacebook(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Iniciar sesión con Facebook");
    }

    public void iniciarSesionConTwitter(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Iniciar sesión con Twitter");
    }

    public void iniciarSesionConGoogle(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Iniciar sesión con Google");
    }

    public void botonNecesitasAyuda(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Necesitas ayuda");
    }

    public void botonTerminos(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Terminos y condiciones");
    }

    public void botonPrivacidad(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Privacidad");
    }

    public void accionBotonFacebook(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Facebook");
    }

    public void accionBotonInstagram(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Instagram");
    }

    public void accionBotonPreguntasFrecuentes(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Preguntas frecuentes");
    }

    public void botonRegistrarse(ActionEvent actionEvent) {
        cargarPantalla("Registrarse", DIRECCIONESFXML.REGISTRARSE);
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
                cargarPantalla("Inicio", DIRECCIONESFXML.INICIOSI);
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
}