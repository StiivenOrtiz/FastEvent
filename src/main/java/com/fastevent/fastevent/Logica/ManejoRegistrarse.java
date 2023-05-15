package com.fastevent.fastevent.Logica;

import com.fastevent.fastevent.Modelo.Usuario;
import com.fastevent.fastevent.Utilidades.Sesion;

public class ManejoRegistrarse {

    public boolean registrarse(String nombres, String apellidos, String correo, String contrasena){
        System.out.println("Datos guardados: " + nombres + " " + apellidos + " " + correo + " " + contrasena);
        LecturaUsuarios lecturaUsuarios = new LecturaUsuarios();

        if(lecturaUsuarios.verificarExistencia(correo)){
            EscrituraUsuarios escrituraUsuarios = new EscrituraUsuarios();
            escrituraUsuarios.registrarUsuario(nombres, apellidos, correo, contrasena);
            //Sesion.setUsuarioActual(new Usuario(nombres, apellidos, correo, contrasena));
            Sesion.setUsuarioActual(lecturaUsuarios.buscarUsuario(correo));
            return true;
        }
        return false;
    }

}
