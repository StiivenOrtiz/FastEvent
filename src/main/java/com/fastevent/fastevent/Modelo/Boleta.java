package com.fastevent.fastevent.Modelo;

import javafx.scene.image.Image;

public class Boleta {
    private String nombre;
    private String fecha;
    private Image imagen;


    public Boleta(String nombre, String fecha, Image imagen) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Image getImagen() {
        return this.imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
}
