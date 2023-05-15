package com.fastevent.fastevent.Logica;

import com.fastevent.fastevent.Interfaces.IPersistenciaUsuarios;
import com.fastevent.fastevent.Persistencia.PersistenciaUsuarios;
import com.fastevent.fastevent.Utilidades.Sesion;

public class ManejoRegistrarse {

    public boolean registrarse(String nombres, String apellidos, String correo, String contrasena){
        IPersistenciaUsuarios persistenciaUsuarios = new PersistenciaUsuarios();

        if(!persistenciaUsuarios.verificarExistencia(correo)){
            if(persistenciaUsuarios.registrarUsuario(nombres, apellidos, correo, contrasena)) {
                Sesion.setUsuarioActual(persistenciaUsuarios.buscarUsuario(correo));
                System.out.println("Datos guardados: " + nombres + " " + apellidos + " " + correo + " " + contrasena);
                return true;
            }
        }
        return false;
    }

}
