package com.fastevent.fastevent;

import com.fastevent.fastevent.Controladores.CargadorPantallas;
import com.fastevent.fastevent.Utilidades.DIRECCIONESFXML;
import com.fastevent.fastevent.Utilidades.NOMBRESPANTALLAS;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class FastEvent extends Application {
    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {

        /*
         ****************************************************************************************
         ************                        INICIO DEL SISTEMA                      ************
         ****************************************************************************************
         */

        CargadorPantallas.cargarPantalla(NOMBRESPANTALLAS.INICIOSNI, DIRECCIONESFXML.INICIOSNI, stage, true);

        /*
         ****************************************************************************************
         ************                          ¡¡NO TOCAR!!                          ************
         ****************************************************************************************
         */
    }
}