package com.fastevent.fastevent.Modelo;

import java.io.Serializable;

public class Publicacion implements Serializable {
    private String titulo;
    private String descripcion;
    private double precio;
    private String direccionimagen;
    private String categoria;
    private String proveedorCorreo;
    private String proveedorNombre;
    private double calificacion;
    private long idPublicacion;


    public Publicacion(String titulo, String descripcion, double precio, String direccionimagen, String categoria, String proveedorCorreo, String proveedorNombre, double calificacion, long idPublicacion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.direccionimagen = direccionimagen;
        this.categoria = categoria;
        this.proveedorCorreo = proveedorCorreo;
        this.proveedorNombre = proveedorNombre;
        this.calificacion = calificacion;
        this.idPublicacion = idPublicacion;
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

    public String getProveedorCorreo() {
        return proveedorCorreo;
    }

    void setProveedorCorreo(String proveedorCorreo) {
        this.proveedorCorreo = proveedorCorreo;
    }

    public String getProveedorNombre() {
        return proveedorNombre;
    }

    void setProveedorNombre(String proveedorNombre) {
        this.proveedorNombre = proveedorNombre;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public long getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(long idPublicacion) {
        this.idPublicacion = idPublicacion;
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