package com.fastevent.fastevent.Modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento implements Serializable {
    private String nombre;
    private String direccionImagen;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private LocalDateTime horaInicio;
    private LocalDateTime horaFin;
    private boolean esPublico;
    private String estado;
    private String creadorCorreo;
    private String creadorNombre;
    private long id;
    private List<PublicacionDeEvento> publicacionesDeEvento;
    private double precioEntrada;

    public Evento(String nombre, String direccionImagen, String descripcion, LocalDate fechaInicio, LocalDate fechaFin, boolean esPublico, String estado, String creadorCorreo, String creadorNombre, long id, LocalDateTime horaInicio, LocalDateTime horaFin, double precioEntrada) {
        this.direccionImagen = direccionImagen;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.esPublico = esPublico;
        this.estado = estado;
        this.creadorCorreo = creadorCorreo;
        this.creadorNombre = creadorNombre;
        this.id = id;
        this.publicacionesDeEvento = new ArrayList<>();
    }

    public Evento(){
        this.nombre = "";
        this.direccionImagen = "";
        this.descripcion = "";
        this.fechaInicio = LocalDate.now();
        this.fechaFin = LocalDate.now();
        this.horaInicio = LocalDateTime.now();
        this.horaFin = LocalDateTime.now();
        this.esPublico = false;
        this.estado = "";
        this.creadorCorreo = "";
        this.creadorNombre = "";
        this.id = 0;
        this.precioEntrada = 0;
        this.publicacionesDeEvento = new ArrayList<>();
    }

    public String getDireccionImagen() {
        return direccionImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setDireccionImagen(String direccionImagen) {
        this.direccionImagen = direccionImagen;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setEsPublico(boolean esPublico) {
        this.esPublico = esPublico;
    }

    public boolean getEsPublico() {
        return esPublico;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setCreadorCorreo(String creadorCorreo) {
        this.creadorCorreo = creadorCorreo;
    }

    public String getCreadorCorreo() {
        return creadorCorreo;
    }

    public void setCreadorNombre(String creadorNombre) {
        this.creadorNombre = creadorNombre;
    }

    public String getCreadorNombre() {
        return creadorNombre;
    }

    public long getId() {
        return id;
    }

    public LocalDateTime getHoraInicio() {
        return horaInicio;
    }

    public LocalDateTime getHoraFin() {
        return horaFin;
    }

    public void setHoraInicio(LocalDateTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(LocalDateTime horaFin) {
        this.horaFin = horaFin;
    }

    public List<PublicacionDeEvento> getPublicacionesDeEvento() {
        return publicacionesDeEvento;
    }

    public double getPrecioEntrada() {
        return precioEntrada;
    }

    public void setPrecioEntrada(double precioEntrada) {
        this.precioEntrada = precioEntrada;
    }

    public void setPublicacionesDeEvento(List<PublicacionDeEvento> publicacionesDeEvento) {
        this.publicacionesDeEvento = publicacionesDeEvento;
    }

    public void setId(long id) {
        this.id = id;
    }
}
