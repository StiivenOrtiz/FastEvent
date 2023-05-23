package com.fastevent.fastevent.Persistencia.Eventos;

import com.fastevent.fastevent.Modelo.Boleta;
import com.fastevent.fastevent.Modelo.Evento;
import com.fastevent.fastevent.Utilidades.DIRECCIONESEXTRA;
import com.fastevent.fastevent.Utilidades.Sesion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LecturaEventos {
    public List<Evento> obtenerEventosUsuario() {
        List<Evento> eventos = new ArrayList<>();
        try {
            if (Files.exists(Paths.get(DIRECCIONESEXTRA.BASEDEDATOSEVENTOS))) {
                FileInputStream fileInputStream = new FileInputStream(DIRECCIONESEXTRA.BASEDEDATOSEVENTOS);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (true) {
                    try {
                        Evento evento = (Evento) objectInputStream.readObject();
                        if (evento.getCreadorCorreo().equals(Sesion.getUsuarioActual().getCorreo()))
                            eventos.add(evento);
                    } catch (EOFException e) {
                        break;
                    }
                }

                objectInputStream.close();
                fileInputStream.close();
                return eventos;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return eventos;
    }

    public List<Evento> obtenerEventosBoletas(List<Boleta> boletas) {
        List<Evento> eventos = new ArrayList<>();

        try {
            if (Files.exists(Paths.get(DIRECCIONESEXTRA.BASEDEDATOSEVENTOS))) {
                FileInputStream fileInputStream = new FileInputStream(DIRECCIONESEXTRA.BASEDEDATOSEVENTOS);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (true) {
                    try {
                        Evento evento = (Evento) objectInputStream.readObject();
                        if (boletas.stream().anyMatch(boleta -> boleta.getIdEvento() == evento.getId() && boleta.getCreadorCorreo().equals(evento.getCreadorCorreo())))
                            eventos.add(evento);
                    } catch (EOFException e) {
                        break;
                    }
                }

                objectInputStream.close();
                fileInputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return eventos;
    }
}
