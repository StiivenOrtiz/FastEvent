package com.fastevent.fastevent.Persistencia.Publicaciones;

import com.fastevent.fastevent.Modelo.Publicacion;
import com.fastevent.fastevent.Modelo.PublicacionDeEvento;
import com.fastevent.fastevent.Utilidades.DIRECCIONESEXTRA;
import com.fastevent.fastevent.Utilidades.Sesion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class LecturaPublicaciones {
    public List<Publicacion> obtenerPublicacionesUsuario() {
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            if (Files.exists(Paths.get(DIRECCIONESEXTRA.BASEDEDATOSPUBLICACIONES))) {
                FileInputStream fileInputStream = new FileInputStream(DIRECCIONESEXTRA.BASEDEDATOSPUBLICACIONES);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (true) {
                    try {
                        Publicacion publicacion = (Publicacion) objectInputStream.readObject();
                        if (publicacion.getProveedorCorreo().equals(Sesion.getUsuarioActual().getCorreo()))
                            publicaciones.add(publicacion);
                    } catch (EOFException e) {
                        break;
                    }
                }

                objectInputStream.close();
                fileInputStream.close();
                return publicaciones;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicaciones;
    }

    public List<Publicacion> obtenerPublicacionesCategoria(String categoria) {
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            if (Files.exists(Paths.get(DIRECCIONESEXTRA.BASEDEDATOSPUBLICACIONES))) {
                FileInputStream fileInputStream = new FileInputStream(DIRECCIONESEXTRA.BASEDEDATOSPUBLICACIONES);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (true) {
                    try {
                        Publicacion publicacion = (Publicacion) objectInputStream.readObject();
                        if (publicacion.getCategoria().equals(categoria))
                            publicaciones.add(publicacion);
                    } catch (EOFException e) {
                        break;
                    }
                }

                objectInputStream.close();
                fileInputStream.close();
                return publicaciones;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicaciones;
    }

    public List<Publicacion> obtenerPublicacionesDeEvento(List<PublicacionDeEvento> publicacionDeEventos) {
        List<Publicacion> publicaciones = new ArrayList<>();
        try {
            if (Files.exists(Paths.get(DIRECCIONESEXTRA.BASEDEDATOSPUBLICACIONES))) {
                FileInputStream fileInputStream = new FileInputStream(DIRECCIONESEXTRA.BASEDEDATOSPUBLICACIONES);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (true) {
                    try {
                        Publicacion publicacion = (Publicacion) objectInputStream.readObject();
                        if (publicacionDeEventos.stream()
                                .anyMatch(p -> p.getIdPublicacion() == publicacion.getIdPublicacion() &&
                                        Objects.equals(p.getProveedorCorreo(), publicacion.getProveedorCorreo())))
                            publicaciones.add(publicacion);
                    } catch (EOFException e) {
                        break;
                    }
                }

                objectInputStream.close();
                fileInputStream.close();
                return publicaciones;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return publicaciones;
    }
}
