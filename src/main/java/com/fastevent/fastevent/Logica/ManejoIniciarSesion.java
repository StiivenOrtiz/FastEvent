package com.fastevent.fastevent.Logica;

import com.fastevent.fastevent.Modelo.Usuario;
import com.fastevent.fastevent.Utilidades.Sesion;

import java.util.Objects;

public class ManejoIniciarSesion {

    public boolean iniciarSesion(String correo, String contrasena){
        //VERIFICAR QUE EL CORREO ELECTRONICO Y CONTRASEÑA SEAN VALIDOS
         Usuario usuario = lecturaUsuarios.buscarUsuario(correo);

        if (Objects.equals(usuario.getCorreo(), correo) && Objects.equals(usuario.getContrasena(), contrasena)) {
            System.out.println("Iniciar sesión con el usuario: " + correo + " y la contraseña: " + contrasena);
            Sesion.setUsuarioActual(usuario);
            return true;
        }

        System.out.println("El usuario o la contraseña son incorrectos");
        return false;
    }
}


