package com.fastevent.fastevent.Persistencia;

import com.fastevent.fastevent.Modelo.Usuario;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EscrituraUsuarios {
    public boolean registrarUsuario(String nombres, String apellidos, String correo, String contrasena) {
        try {
            Usuario usuario = new Usuario(nombres, apellidos, correo, contrasena);

            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;

            if (Files.exists(Paths.get("usuario.dat"))) {
                fileOutputStream = new FileOutputStream("usuario.dat", true);
                objectOutputStream = new ObjectOutputStream(fileOutputStream) {
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            } else {
                fileOutputStream = new FileOutputStream("usuario.dat");
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }

            objectOutputStream.writeObject(usuario);

            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
