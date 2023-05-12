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

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public String getDireccionImagen() {
        return direccionimagen;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getProveedor() {
        return proveedor;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public String getDireccionimagen() {
        return direccionimagen;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    void setPrecio(double precio) {
        this.precio = precio;
    }

    void setDireccionimagen(String direccionimagen) {
        this.direccionimagen = direccionimagen;
    }

    void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

}