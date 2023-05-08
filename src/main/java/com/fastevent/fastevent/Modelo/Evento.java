package com.fastevent.fastevent.Modelo;

import javafx.scene.image.Image;

public class Evento {
    private String nombre;
    private Image imagen;

    public Evento(String nombre, Image imagen) {
        this.imagen = imagen;
        this.nombre = nombre;
    }

    public Image getImagen() {
        return imagen;
    }

    public String getNombre() {
        return nombre;
    }
}
