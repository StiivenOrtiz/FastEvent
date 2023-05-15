package com.fastevent.fastevent.Persistencia;

import com.fastevent.fastevent.Modelo.Usuario;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LecturaUsuarios {

    public Usuario buscarUsuario(String correo) {
        try {
            if (Files.exists(Paths.get("Base de Datos/Usuarios.dat"))) {
                FileInputStream fileInputStream = new FileInputStream("Base de Datos/Usuarios.dat");
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

                while (true) {
                    try {
                        Usuario usuario = (Usuario) objectInputStream.readObject();
                        if (usuario.getCorreo().equals(correo)) {
                            objectInputStream.close();
                            fileInputStream.close();
                            return usuario;
                        }
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
        return null;
    }


    public boolean verificarExistencia(String correo){
        return buscarUsuario(correo) != null;
    }
}
