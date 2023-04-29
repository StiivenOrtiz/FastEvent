package com.fastevent.fastevent.Utilidades;

public interface Constantes {
    String SesionNoIniciada = "PantallaInicial/SesionNoIniciada/IniciarSesion/IniciarSesion.fxml";
    String logo = "logo.png";

    public static String obtenerFXML(String nombrePantalla) {
        switch (nombrePantalla) {
            case "IniciarSesion" -> {
                return SesionNoIniciada;
            }
            default -> {
                return null;
            }
        }
    }
}
