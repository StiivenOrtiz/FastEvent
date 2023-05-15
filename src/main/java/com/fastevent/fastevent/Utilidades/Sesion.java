package com.fastevent.fastevent.Utilidades;

import com.fastevent.fastevent.Modelo.Usuario;

public class Sesion {
    private static Usuario usuarioActual;

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario user) {
        usuarioActual = user;
    }
}
