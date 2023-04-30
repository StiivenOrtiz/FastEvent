package com.fastevent.fastevent.Utilidades;

public interface Constantes {
    String iniciarSesion = "PantallaInicial/SesionNoIniciada/IniciarSesion/IniciarSesion.fxml";
    String registrarse = "PantallaInicial/SesionNoIniciada/Registrarse/Registrarse.fxml";
    String icono = "icono.png";

    public static String obtenerFXML(String nombrePantalla) {
        switch (nombrePantalla) {
            case "IniciarSesion" -> {
                return iniciarSesion;
            }
            case "Registrarse" -> {
                return registrarse;
            }
            default -> {
                return null;
            }
        }
    }
}
