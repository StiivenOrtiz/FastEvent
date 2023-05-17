package com.fastevent.fastevent.Interfaces;

import com.fastevent.fastevent.Modelo.Usuario;

public interface IPersistenciaUsuarios {
    public boolean registrarUsuario(String nombres, String apellidos, String correo, String contrasena);
    public boolean verificarExistencia(String correo);
    public Usuario buscarUsuario(String correo);
}
