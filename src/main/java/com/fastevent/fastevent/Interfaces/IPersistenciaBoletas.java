package com.fastevent.fastevent.Interfaces;

import com.fastevent.fastevent.Modelo.Boleta;

import java.util.List;

public interface IPersistenciaBoletas {
    boolean registrarBoleta(long idEvento, String creadorCorreo, long idBoleta, String creadorNombre);
    List<Boleta> obtenerBoletasUsuario();
}
