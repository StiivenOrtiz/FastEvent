package com.fastevent.fastevent.Persistencia.Publicaciones;

import com.fastevent.fastevent.Modelo.Publicacion;
import com.fastevent.fastevent.Utilidades.DIRECCIONESEXTRA;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EscrituraPublicaciones {
    public boolean registrarPublicacion(Publicacion publicacion) {
        try {
            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;

            if (Files.exists(Paths.get(DIRECCIONESEXTRA.BASEDEDATOSPUBLICACIONES))) {
                fileOutputStream = new FileOutputStream(DIRECCIONESEXTRA.BASEDEDATOSPUBLICACIONES, true);
                objectOutputStream = new ObjectOutputStream(fileOutputStream) {
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            } else {
                fileOutputStream = new FileOutputStream(DIRECCIONESEXTRA.BASEDEDATOSPUBLICACIONES);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }

            objectOutputStream.writeObject(publicacion);

            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (FileNotFoundException e) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(DIRECCIONESEXTRA.BASEDEDATOSPUBLICACIONES);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(publicacion);
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
