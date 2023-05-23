package com.fastevent.fastevent.Interfaces;

import com.fastevent.fastevent.Modelo.Boleta;
import com.fastevent.fastevent.Modelo.Evento;

import java.util.List;

public interface IPersistenciaEventos {
    boolean registrarEvento(Evento evento);
    List<Evento> obtenerEventosUsuario();
    List<Evento> obtenerEventosBoletas(List<Boleta> boletas);
}
