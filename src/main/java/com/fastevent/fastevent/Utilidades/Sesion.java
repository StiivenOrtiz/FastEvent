package com.fastevent.fastevent.Utilidades;

import com.fastevent.fastevent.Modelo.Usuario;

public class Sesion {
    private static Usuario usuarioActual;

    public static Usuario getCurrentUser() {
        return usuarioActual;
    }

    public static void setCurrentUser(Usuario user) {
        usuarioActual = user;
    }
}
