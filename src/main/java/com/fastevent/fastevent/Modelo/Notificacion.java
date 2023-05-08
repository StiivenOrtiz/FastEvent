package com.fastevent.fastevent.Modelo;

public class Notificacion {
    private String descipcion;
    private String accion;

    public Notificacion(String descipcion, String accion) {
        this.descipcion = descipcion;
        this.accion = accion;
    }

    public String getDescipcion() {
        return descipcion;
    }

    public String getAccion() {
        return accion;
    }

    public void setDescipcion(String descipcion) {
        this.descipcion = descipcion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }
}
