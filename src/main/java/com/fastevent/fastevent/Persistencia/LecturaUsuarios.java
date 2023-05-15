package com.fastevent.fastevent.Persistencia;

import com.fastevent.fastevent.Modelo.Usuario;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LecturaUsuarios {
    public Usuario buscarUsuario(String correo) {
        try {
            FileInputStream fileInputStream = new FileInputStream("usuario.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            Usuario usuario;

            while (true) {
                try {
                    usuario = (Usuario) objectInputStream.readObject();
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
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean verificarExistencia(String correo){
        return buscarUsuario(correo) != null;
    }
}
