package com.fastevent.fastevent.Modelo;

public class Categoria {
    private String titulo;
    private String texto;
    private String direccionImagen;
    private String direccionImagenHover;

    public Categoria(String titulo, String texto, String direccionImagen, String direccionImagenHover) {
        this.titulo = titulo;
        this.texto = texto;
        this.direccionImagen = direccionImagen;
        this.direccionImagenHover = direccionImagenHover;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }

    public String getDireccionImagenHover() {
        return direccionImagenHover;
    }

    public void setDireccionImagenHover(String direccionImagenHover) {
        this.direccionImagenHover = direccionImagenHover;
    }
}