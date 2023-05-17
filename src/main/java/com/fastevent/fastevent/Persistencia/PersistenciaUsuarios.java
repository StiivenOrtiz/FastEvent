package com.fastevent.fastevent.Persistencia;

import com.fastevent.fastevent.Interfaces.IPersistenciaUsuarios;
import com.fastevent.fastevent.Modelo.Usuario;

public class PersistenciaUsuarios implements IPersistenciaUsuarios {
    private final EscrituraUsuarios escrituraUsuarios = new EscrituraUsuarios();
    private final LecturaUsuarios lecturaUsuarios = new LecturaUsuarios();

    @Override
    public boolean registrarUsuario(String nombres, String apellidos, String correo, String contrasena) {
        return escrituraUsuarios.registrarUsuario(nombres, apellidos, correo, contrasena);
    }

    @Override
    public boolean verificarExistencia(String correo) {
        return lecturaUsuarios.verificarExistencia(correo);
    }

    @Override
    public Usuario buscarUsuario(String correo) {
        return lecturaUsuarios.buscarUsuario(correo);
    }
}
