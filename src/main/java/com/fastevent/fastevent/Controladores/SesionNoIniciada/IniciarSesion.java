package com.fastevent.fastevent.Controladores.SesionNoIniciada;

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Utilidades.BuscadorRegistros;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class IniciarSesion extends Controlador {

    @FXML
    private TextField correoElectronico;

    @FXML
    private PasswordField contrasena;

    //MANEJO DE DATOS
/*
    String email = correoElectronico.getText();
    String password = contrasena.getText();
*/

    public void botonLogoRectangularPresionado(ActionEvent actionEvent) {
        System.out.println("Logo rectangular presionado");
    }

    //ADD
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


    //REDES
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


    //ADD
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
       System.out.println("Iniciar sesión con el usuario: " + correoElectronico.getText() + " y la contraseña: " + contrasena.getText());
   }

    /*
    BuscadorRegistros buscadorRegistros = new BuscadorRegistros(email, password);

    public void botonIniciarSesion(ActionEvent actionEvent) {
        //VERIFICAR QUE LOS CAMPOS ESTEN LLENOS
        if(email.isEmpty() || password.isEmpty()){
            System.out.println("Por favor ingrese todos los datos");
        }else {
            //VERIFICAR QUE EL CORREO ELECTRONICO Y CONTRASEÑA SEAN VALIDOS
            if (buscadorRegistros.verificarCredenciales(email, password)) {
                System.out.println("Iniciar sesión con el usuario: " + correoElectronico.getText() + " y la contraseña: " + contrasena.getText());
                //CAMBIAR A LA PANTALLA DE SESION INICIADA
            } else {
                System.out.println("El usuario o la contraseña son incorrectos");
            }
        }
    }
    */

    public void botonRegistrarse(ActionEvent actionEvent) {
        System.out.println("Registrarse");
    }


}

/*
* CAMBIAR A PÀNTALLAS DE SESION INICIADA: BOTON INICIAR SESION
* CAMBIAR A PANTALLA DE REGISTRO: BOTON REGISTRARSE Y "REGISTRARSE"
* */