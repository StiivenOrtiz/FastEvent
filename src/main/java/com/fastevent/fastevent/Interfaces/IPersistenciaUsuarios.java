package com.fastevent.fastevent.Interfaces;

import com.fastevent.fastevent.Modelo.Usuario;

public interface IPersistenciaUsuarios {
    boolean registrarUsuario(String nombres, String apellidos, String correo, String contrasena);

    boolean verificarExistencia(String correo);

    Usuario buscarUsuario(String correo);
}
