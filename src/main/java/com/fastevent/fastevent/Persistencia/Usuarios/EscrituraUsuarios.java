package com.fastevent.fastevent.Persistencia.Usuarios;

import com.fastevent.fastevent.Modelo.Usuario;
import com.fastevent.fastevent.Utilidades.DIRECCIONESEXTRA;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class EscrituraUsuarios {
    public boolean registrarUsuario(String nombres, String apellidos, String correo, String contrasena) {
        try {
            Usuario usuario = new Usuario(nombres, apellidos, correo, contrasena, 0, 0);

            FileOutputStream fileOutputStream;
            ObjectOutputStream objectOutputStream;

            if (Files.exists(Paths.get(DIRECCIONESEXTRA.BASEDEDATOSUSUARIOS))) {
                fileOutputStream = new FileOutputStream(DIRECCIONESEXTRA.BASEDEDATOSUSUARIOS, true);
                objectOutputStream = new ObjectOutputStream(fileOutputStream) {
                    protected void writeStreamHeader() throws IOException {
                        reset();
                    }
                };
            } else {
                fileOutputStream = new FileOutputStream(DIRECCIONESEXTRA.BASEDEDATOSUSUARIOS);
                objectOutputStream = new ObjectOutputStream(fileOutputStream);
            }

            objectOutputStream.writeObject(usuario);

            objectOutputStream.close();
            fileOutputStream.close();

            File carpetaUsuario = new File(DIRECCIONESEXTRA.BASEDEDATOS + correo);

            try {
                carpetaUsuario.mkdir();
            } catch (SecurityException e) {
                e.printStackTrace();
            }


            return true;
        } catch (FileNotFoundException e) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(DIRECCIONESEXTRA.BASEDEDATOSUSUARIOS);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                Usuario usuario = new Usuario(nombres, apellidos, correo, contrasena, 0, 0);
                objectOutputStream.writeObject(usuario);
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
