package com.fastevent.fastevent.Modelo;

public class Publicacion {
    String titulo;
    String descripcion;
    double precio;
    String direccionimagen;
    String categoria;
    String proveedor;
    double calificacion;

    public Publicacion(String titulo, String descripcion, double precio, String direccionimagen, String categoria, String proveedor, double calificacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.direccionimagen = direccionimagen;
        this.categoria = categoria;
        this.proveedor = proveedor;
        this.calificacion = calificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDireccionImagen() {
        return direccionimagen;
    }

    public String getCategoria() {
        return categoria;
    }

    void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getProveedor() {
        return proveedor;
    }

    void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public double getCalificacion() {
        return calificacion;
    }

    void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public String getDireccionimagen() {
        return direccionimagen;
    }

    void setDireccionimagen(String direccionimagen) {
        this.direccionimagen = direccionimagen;
    }

}