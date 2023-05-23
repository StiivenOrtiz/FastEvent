package com.fastevent.fastevent.Persistencia.Usuarios;

import com.fastevent.fastevent.Modelo.Usuario;
import com.fastevent.fastevent.Utilidades.DIRECCIONESEXTRA;
import com.fastevent.fastevent.Utilidades.Sesion;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ActualizarDatosUsuarios {
    public boolean actualizarDatosUsuario() {
        try {
            // Leer la base de datos y buscar al usuario por su correo
            FileInputStream fileInputStream = new FileInputStream(DIRECCIONESEXTRA.BASEDEDATOSUSUARIOS);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            List<Usuario> usuarios = new ArrayList<>();
            Usuario usuario;
            String correo = Sesion.getUsuarioActual().getCorreo();

            while (fileInputStream.available() > 0) {
                usuario = (Usuario) objectInputStream.readObject();

                // Verificar si el correo coincide con el del usuario que se quiere actualizar
                if (usuario.getCorreo().equals(correo))
                    usuario = Sesion.getUsuarioActual();

                usuarios.add(usuario);
            }

            objectInputStream.close();
            fileInputStream.close();

            // Guardar los cambios en la base de datos
            FileOutputStream fileOutputStream = new FileOutputStream(DIRECCIONESEXTRA.BASEDEDATOSUSUARIOS);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            for (Usuario u : usuarios) {
                objectOutputStream.writeObject(u);
            }

            objectOutputStream.close();
            fileOutputStream.close();

            return true;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}
