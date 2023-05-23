package com.fastevent.fastevent.Persistencia.Eventos;

import com.fastevent.fastevent.Modelo.Evento;
import com.fastevent.fastevent.Utilidades.DIRECCIONESEXTRA;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EscrituraEventos {
    public boolean registrarEvento(Evento evento) {
        try {
            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;

            if (Files.exists(Paths.get(DIRECCIONESEXTRA.BASEDEDATOSEVENTOS))) {
                fileOutputStream = new FileOutputStream(DIRECCIONESEXTRA.BASEDEDATOSEVENTOS, true);
                objectOutputStream = new ObjectOutputStream(fileOutputStream) {
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            } else {
                fileOutputStream = new FileOutputStream(DIRECCIONESEXTRA.BASEDEDATOSEVENTOS);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }

            objectOutputStream.writeObject(evento);

            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (FileNotFoundException e) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(DIRECCIONESEXTRA.BASEDEDATOSEVENTOS);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(evento);
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
