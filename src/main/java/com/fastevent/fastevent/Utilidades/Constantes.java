package com.fastevent.fastevent.Utilidades;

public interface Constantes {
    String iniciarSesion = "SesionNoIniciada/IniciarSesion/IniciarSesion.fxml";
    String registrarse = "SesionNoIniciada/Registrarse/Registrarse.fxml";
    String inicioSNI = "SesionNoIniciada/Inicio/Inicio.fxml";
    String inicioSI = "SesionIniciada/Inicio/Inicio.fxml";
    String boleteriaSNI = "SesionNoIniciada/Boleteria/Boleteria.fxml";
    String boleteriaSI = "SesionIniciada/Boleteria/Boleteria.fxml";
    String perfilDeUsuario = "SesionIniciada/PerfilDeUsuario/PerfilDeUsuario.fxml";
    String precios = "SesionIniciada/Precios/Precios.fxml";
    String icono = "icono.png";

    static String obtenerFXML(String nombrePantalla) {
        switch (nombrePantalla) {
            case "IniciarSesion" -> {
                return iniciarSesion;
            }
            case "Registrarse" -> {
                return registrarse;
            }
            case "InicioSNI" -> {
                return inicioSNI;
            }
            case "InicioSI" -> {
                return inicioSI;
            }
            case "BoleteriaSNI" -> {
                return boleteriaSNI;
            }
            case "BoleteriaSI" -> {
                return boleteriaSI;
            }
            case "PerfilDeUsuario" -> {
                return perfilDeUsuario;
            }
            case "Precios" -> {
                return precios;
            }
            default -> {
                return null;
            }
        }
    }
}
