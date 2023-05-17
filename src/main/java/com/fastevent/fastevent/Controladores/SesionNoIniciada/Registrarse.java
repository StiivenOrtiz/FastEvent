package com.fastevent.fastevent.Controladores.SesionNoIniciada;

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Interfaces.IAutenticacion;
import com.fastevent.fastevent.Logica.Autenticacion;
import com.fastevent.fastevent.Utilidades.Constantes;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Registrarse extends Controlador {

    @FXML
    public TextField nombres, apellidos, correoElectronico, repetirCorreoElectronico;

    @FXML
    public PasswordField repetirContrasena, contrasena;

    @FXML
    public CheckBox checkBoxAceptarTerminos;

    public void botonLogoRectangularPresionado(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Inicio");
    }

    public void accionBotonInicio(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Inicio");
    }

    public void accionBotonPrecios(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Precios");
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

    public void accionBotonTwitter(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Twitter");
    }

    public void accionBotonLinkedin(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Linkedin");
    }

    public void accionBotonPreguntasFrecuentes(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Preguntas frecuentes");
    }

    public void registrarseConFacebook(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor registrarse por otro medio.", "Registrarse con Facebook");
    }

    public void registrarseConTwitter(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor registrarse por otro medio.", "Registrarse con Twitter");
    }

    public void registrarseConGoogle(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor registrarse por otro medio.", "Registrarse con Google");
    }

    public void botonIniciarSesion(ActionEvent actionEvent) {
        System.out.println("Boton iniciar sesion");
        cargarPantalla("IniciarSesion", Constantes.obtenerFXML("IniciarSesion"));
    }

    public void botonRegistrarse(ActionEvent actionEvent) {
        boolean error = false;
        String mensajeError = "";
        String instrucciones = "";

        if (nombres.getText().isEmpty() || apellidos.getText().isEmpty() || correoElectronico.getText().isEmpty() || repetirCorreoElectronico.getText().isEmpty() || contrasena.getText().isEmpty() || repetirContrasena.getText().isEmpty()) {
            // Le mandamos una ventana indicando el error
            mensajeError = "Los campos no pueden estar vacios";
            instrucciones = "Por favor, ingrese todos los datos solicitados";
            error = true;
        } else
            //Verificar que los correos y contraseñas sean iguales
            if (!correoElectronico.getText().equals(repetirCorreoElectronico.getText())) {
                mensajeError = "Los correos no coinciden";
                instrucciones = "Por favor, ingrese los correos nuevamente";
                error = true;
            } else if (!contrasena.getText().equals(repetirContrasena.getText())) {
                mensajeError = "Las contraseñas no coinciden";
                instrucciones = "Por favor, ingrese las contraseñas nuevamente";
                error = true;
            } else if (!checkBoxAceptarTerminos.isSelected()) {
                mensajeError = "Debe aceptar los terminos y condiciones";
                instrucciones = "Por favor, acepte los terminos y condiciones";
                error = true;
            } else {
                IAutenticacion autenticacion = new Autenticacion();
                if (autenticacion.registrarse(nombres.getText(), apellidos.getText(), correoElectronico.getText(), contrasena.getText()))
                    mostrarMensajeInformativo("Se ha registrado correctamente", "Se ha registrado correctamente", "Registro exitoso");
                else
                    mostrarMensajeError("No se ha podido registrar", "Intente nuevamente con otro correo");
            }

        if (error)
            mostrarMensajeError(mensajeError, instrucciones);
    }
}