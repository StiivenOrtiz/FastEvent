package com.fastevent.fastevent.Modelo;

import java.io.Serializable;

public class Boleta implements Serializable {
    private final String comprador;
    private final long idEvento;
    private final String creadorCorreo;
    private final long idBoleta;
    private final String creadorNombre;

    public Boleta(String comprador, long idEvento, String creadorCorreo, long idBoleta , String creadorNombre) {
        this.comprador = comprador;
        this.idEvento = idEvento;
        this.creadorCorreo = creadorCorreo;
        this.idBoleta = idBoleta;
        this.creadorNombre = creadorNombre;
    }

    public String getComprador() {
        return comprador;
    }

    public long getIdEvento() {
        return idEvento;
    }

    public String getCreadorCorreo() {
        return creadorCorreo;
    }

    public long getIdBoleta() {
        return idBoleta;
    }

    public String getCreadorNombre() {
        return creadorNombre;
    }
}
