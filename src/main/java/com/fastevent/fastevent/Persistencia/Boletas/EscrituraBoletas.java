package com.fastevent.fastevent.Persistencia.Boletas;

import com.fastevent.fastevent.Modelo.Boleta;
import com.fastevent.fastevent.Utilidades.DIRECCIONESEXTRA;
import com.fastevent.fastevent.Utilidades.Sesion;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EscrituraBoletas {
    public boolean registrarBoleta(long idEvento, String creadorCorreo, long idBoleta, String creadorNombre) {
        String direccion = DIRECCIONESEXTRA.BASEDEDATOS + Sesion.getUsuarioActual().getCorreo() + DIRECCIONESEXTRA.BASEDEDATOSBOLETAS;
        try {
            Boleta boleta = new Boleta(Sesion.getUsuarioActual().getCorreo(), idEvento, creadorCorreo, idBoleta, creadorNombre);

            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;

            if (Files.exists(Paths.get(direccion))) {
                fileOutputStream = new FileOutputStream(direccion, true);
                objectOutputStream = new ObjectOutputStream(fileOutputStream) {
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            } else {
                fileOutputStream = new FileOutputStream(direccion);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }

            objectOutputStream.writeObject(boleta);

            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (FileNotFoundException e) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(direccion);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                Boleta boleta = new Boleta(Sesion.getUsuarioActual().getCorreo(), idEvento, creadorCorreo, idBoleta, creadorNombre);
                objectOutputStream.writeObject(boleta);
                objectOutputStream.close();
                fileOutputStream.close();
                return true;
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
