package com.fastevent.fastevent.Logica;

import com.fastevent.fastevent.Interfaces.IAutenticacion;

 public class Autenticacion implements IAutenticacion {
     @Override
     public Boolean iniciarSesion(String correo, String contrasena) {
         return null;
     }

     @Override
     public Boolean registrarse(String nombre, String apellido, String correo, String contrasena) {
         return null;
     }
   /* private final ManejoIniciarSesion manejoIniciarSesion = new ManejoIniciarSesion();
   private final ManejoRegistrarse manejoRegistrarse  = new ManejoRegistrarse();

   @Override
    public Boolean iniciarSesion(String correo, String contrasena){
        return manejoIniciarSesion.iniciarSesion(correo, contrasena);
    }

    @Override
    public Boolean registrarse(String nombre, String apellido, String correo, String contrasena){
        return manejoRegistrarse.registrarse(nombre, apellido, correo, contrasena);
    }*/

}
