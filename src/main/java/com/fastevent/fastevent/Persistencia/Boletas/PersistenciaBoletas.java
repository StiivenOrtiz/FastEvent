package com.fastevent.fastevent.Persistencia.Boletas;

import com.fastevent.fastevent.Interfaces.IPersistenciaBoletas;
import com.fastevent.fastevent.Modelo.Boleta;

import java.util.List;

public class PersistenciaBoletas implements IPersistenciaBoletas {
    private final LecturaBoletas lecturaBoletas = new LecturaBoletas();
    private final EscrituraBoletas escrituraBoletas = new EscrituraBoletas();

    @Override
    public boolean registrarBoleta(long idEvento, String creadorCorreo, long idBoleta, String creadorNombre) {
        return escrituraBoletas.registrarBoleta(idEvento, creadorCorreo, idBoleta, creadorNombre);
    }

    @Override
    public List<Boleta> obtenerBoletasUsuario() {
        return lecturaBoletas.obtenerBoletasUsuario();
    }
}
