package com.fastevent.fastevent.Modelo;

import java.io.Serializable;

public class Usuario implements Serializable {
    private final String contrasena;
    private String nombres;
    private String apellidos;
    private String correo;
    private long eventosCreados;
    private long publicacionesCreadas;

    public Usuario(String nombres, String apellidos, String correo, String contrasena, int eventosCreados, int publicacionesCreadas) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.correo = correo;
        this.contrasena = contrasena;
        this.eventosCreados = eventosCreados;
        this.publicacionesCreadas = publicacionesCreadas;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.correo = contrasena;
    }

    public long getEventosCreados() {
        return eventosCreados;
    }

    public void setEventosCreados(long eventosCreados) {
        this.eventosCreados = eventosCreados;
    }

    public long getPublicacionesCreadas() {
        return publicacionesCreadas;
    }

    public void setPublicacionesCreadas(long publicacionesCreadas) {
        this.publicacionesCreadas = publicacionesCreadas;
    }

}
