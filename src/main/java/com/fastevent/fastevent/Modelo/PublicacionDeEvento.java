package com.fastevent.fastevent.Modelo;

import java.io.Serializable;

public class PublicacionDeEvento implements Serializable {
    private String proveedorCorreo;
    private long idPublicacion;

    public PublicacionDeEvento(String proveedorCorreo, String proveedorNombre, long idPublicacion) {
        this.proveedorCorreo = proveedorCorreo;
        this.idPublicacion = idPublicacion;
    }

    public PublicacionDeEvento(Publicacion publicacion){
        this.proveedorCorreo = publicacion.getProveedorCorreo();
        this.idPublicacion = publicacion.getIdPublicacion();
    }

    public String getProveedorCorreo() {
        return proveedorCorreo;
    }

    public long getIdPublicacion() {
        return idPublicacion;
    }

    public void setProveedorCorreo(String proveedorCorreo) {
        this.proveedorCorreo = proveedorCorreo;
    }

    public void setIdPublicacion(long idPublicacion) {
        this.idPublicacion = idPublicacion;
    }
}
