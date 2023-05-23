package com.fastevent.fastevent.Persistencia.Eventos;

import com.fastevent.fastevent.Interfaces.IPersistenciaEventos;
import com.fastevent.fastevent.Modelo.Boleta;
import com.fastevent.fastevent.Modelo.Evento;

import java.util.List;

public class PersistenciaEventos implements IPersistenciaEventos {
    private final EscrituraEventos escrituraEventos = new EscrituraEventos();
    private final LecturaEventos lecturaEventos = new LecturaEventos();

    @Override
    public boolean registrarEvento(Evento evento) {
        return escrituraEventos.registrarEvento(evento);
    }

    @Override
    public List<Evento> obtenerEventosUsuario() {
        return lecturaEventos.obtenerEventosUsuario();
    }

    @Override
    public List<Evento> obtenerEventosBoletas(List<Boleta> boletas) {
        return lecturaEventos.obtenerEventosBoletas(boletas);
    }
}
