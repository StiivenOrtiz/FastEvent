package com.fastevent.fastevent.Controladores.PantallaInicial.SesionNoIniciada;

import com.fastevent.fastevent.Controladores.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class IniciarSesion extends Controlador {

    @FXML
    private TextField usuario;

    @FXML
    private PasswordField contrasena;

    @FXML
    private void iniciarSesion() {
        String nombreUsuario = usuario.getText();
        String password = contrasena.getText();
        // Aquí puedes agregar la lógica para autenticar el usuario y contraseña
        System.out.println("Iniciar sesión con el usuario: " + nombreUsuario + " y la contraseña: " + password);
    }

    @FXML
    private void cancelar() {
        // Aquí puedes agregar la lógica para cerrar la ventana
        System.out.println("Cerrar la ventana");
    }

    public void AccionarIniciarSesion(ActionEvent actionEvent) {
        System.out.println("Iniciar sesión con el usuario: " + usuario.getText() + " y la contraseña: " + contrasena.getText());
    }

    public void AccionarRegistrarse(ActionEvent actionEvent) {
        System.out.println("Registrarse");
    }
}