package com.fastevent.fastevent.Utilidades;

import com.fastevent.fastevent.Modelo.Evento;
import com.fastevent.fastevent.Modelo.Usuario;

public class Sesion {
    private static Usuario usuarioActual;
    private static Evento eventoEnDesarrollo;
    private static String FXMLPantallaAnterior, nombrePantallaAnterior;

    public static Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public static void setUsuarioActual(Usuario user) {
        usuarioActual = user;
    }

    public static Evento getEventoEnDesarrollo() {
        return eventoEnDesarrollo;
    }

    public static void setEventoEnDesarrollo(Evento evento) {
        eventoEnDesarrollo = evento;
    }

    public static String getFXMLPantallaAnterior() {
        return FXMLPantallaAnterior;
    }

    public static void setFXMLPantallaAnterior(String FXMLPantallaAnterior) {
        Sesion.FXMLPantallaAnterior = FXMLPantallaAnterior;
    }

    public static String getNombrePantallaAnterior() {
        return nombrePantallaAnterior;
    }

    public static void setNombrePantallaAnterior(String nombrePantallaAnterior) {
        Sesion.nombrePantallaAnterior = nombrePantallaAnterior;
    }
}
