package com.fastevent.fastevent.Interfaces;

import com.fastevent.fastevent.Modelo.Publicacion;
import com.fastevent.fastevent.Modelo.PublicacionDeEvento;

import java.util.List;

public interface IPersistenciaPublicaciones {
    boolean registrarPublicacion(Publicacion publicacion);
    List<Publicacion> obtenerPublicacionesUsuario();
    List<Publicacion> obtenerPublicacionesCategoria(String categoria);
    List<Publicacion> obtenerPublicacionesDeEvento(List<PublicacionDeEvento> publicacionDeEventos);
}
