package com.fastevent.fastevent.Persistencia.Boletas;

import com.fastevent.fastevent.Modelo.Boleta;
import com.fastevent.fastevent.Utilidades.DIRECCIONESEXTRA;
import com.fastevent.fastevent.Utilidades.Sesion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class LecturaBoletas {
    public List<Boleta> obtenerBoletasUsuario() {
        String direccion = DIRECCIONESEXTRA.BASEDEDATOS + Sesion.getUsuarioActual().getCorreo() + DIRECCIONESEXTRA.BASEDEDATOSBOLETAS;
        List<Boleta> boletas = new ArrayList<>();
        try {
            if (Files.exists(Paths.get(direccion))) {
                FileInputStream fileInputStream = new FileInputStream(direccion);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (true) {
                    try {
                        Boleta boleta = (Boleta) objectInputStream.readObject();
                        if (boleta.getComprador().equals(Sesion.getUsuarioActual().getCorreo()))
                            boletas.add(boleta);
                    } catch (EOFException e) {
                        break;
                    }
                }

                objectInputStream.close();
                fileInputStream.close();
                return boletas;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return boletas;
    }
}
