package com.fastevent.fastevent.Persistencia.Publicaciones;

import com.fastevent.fastevent.Interfaces.IPersistenciaPublicaciones;
import com.fastevent.fastevent.Modelo.Publicacion;
import com.fastevent.fastevent.Modelo.PublicacionDeEvento;

import java.util.List;

public class PersistenciaPublicaciones implements IPersistenciaPublicaciones {
    private final LecturaPublicaciones lecturaPublicaciones = new LecturaPublicaciones();
    private final EscrituraPublicaciones escrituraPublicaciones = new EscrituraPublicaciones();

    @Override
    public boolean registrarPublicacion(Publicacion publicacion) {
        return escrituraPublicaciones.registrarPublicacion(publicacion);
    }

    @Override
    public List<Publicacion> obtenerPublicacionesUsuario() {
        return lecturaPublicaciones.obtenerPublicacionesUsuario();
    }

    @Override
    public List<Publicacion> obtenerPublicacionesCategoria(String categoria) {
        return lecturaPublicaciones.obtenerPublicacionesCategoria(categoria);
    }

    @Override
    public List<Publicacion> obtenerPublicacionesDeEvento(List<PublicacionDeEvento> publicacionDeEventos) {
        return lecturaPublicaciones.obtenerPublicacionesDeEvento(publicacionDeEventos);
    }
}
