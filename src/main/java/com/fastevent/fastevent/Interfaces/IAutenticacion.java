package com.fastevent.fastevent.Interfaces;

public interface IAutenticacion {
    Boolean iniciarSesion(String correo, String contrasena);
    Boolean registrarse(String nombre, String apellido, String correo, String contrasena);
}