package com.fastevent.fastevent.Controladores.SesionNoIniciada;

import com.fastevent.fastevent.Controladores.CargadorPantallas;
import com.fastevent.fastevent.Controladores.Controlador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Registrarse extends Controlador implements CargadorPantallas {

    //DATOS
    @FXML
    public TextField nombres;
    @FXML
    public TextField apellidos;
    @FXML
    public TextField correoElectronico;
    @FXML
    public TextField repetirCorreoElectronico;
    @FXML
    public PasswordField repetirContrasena;
    @FXML
    public PasswordField contrasena;

    /* MANEJO DE DATOS
    String name = nombres.getText();
    String lastname = apellidos.getText();
    String email = correoElectronico.getText();
    String correoRepetido = repetirCorreoElectronico.getText();
    String password = contrasena.getText();
    String contrasenaRepetida = repetirContrasena.getText();
    */


    //CONFIRMACION
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


    //REDES SOCIALES
    public void accionBotonFacebook(ActionEvent actionEvent) {
        System.out.println("Facebook");
    }

    public void accionBotonInstagram(ActionEvent actionEvent) {System.out.println("Instagram");} //NO HAY BOTON INSTAGRAM

    public void accionBotonTwitter(ActionEvent actionEvent) {
        System.out.println("Twitter");
    }

    public void accionBotonLinkedin(ActionEvent actionEvent) {
        System.out.println("Linkedin");
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

    public void accionBotonPreguntasFrecuentes(ActionEvent actionEvent) {
        System.out.println("Preguntas frecuentes");
    }



    public void botonIniciarSesion(ActionEvent actionEvent) {
        System.out.println("Boton iniciar sesion");
    }

    public void botonRegistrarse(ActionEvent actionEvent) {System.out.println("Boton registrarse");}



    //GUARDAR TXT
    /*
    public void botonRegistrarse(ActionEvent actionEvent) {
        // Verificar que todos los campos estén llenos
        if (nombres.getText().isEmpty() || apellidos.getText().isEmpty() || correoElectronico.getText().isEmpty() || repetirCorreoElectronico.getText().isEmpty() || contrasena.getText().isEmpty() || repetirContrasena.getText().isEmpty()) {
            System.out.println("Por favor, llene todos los campos.");
        } else {
            // Verificar que los términos y condiciones estén aceptados
            if (checkBoxAceptarTerminos.isSelected()) {
                //DUARDAR DATOS EN TXT
                System.out.println("Datos guardados correctamente.");
            } else {
                // Si no están aceptados, mostrar mensaje de error
                System.out.println("Por favor, acepte los términos y condiciones.");
            }
        }
    }
    */

    //LUEGO DE HACER LAS VERIFICACIONES
    //CAMBIAR A PANTALLA SESIONINICIADA.INICIO


    //CAMBIAR A PANTALLA INICIO SESION PARA LOS DOS BOTONES
}