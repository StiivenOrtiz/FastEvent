package com.fastevent.fastevent.Utilidades;

public interface Constantes {
    String iniciarSesion = "SesionNoIniciada/IniciarSesion/IniciarSesion.fxml";
    String registrarse = "SesionNoIniciada/Registrarse/Registrarse.fxml";
    String inicioSNI = "SesionNoIniciada/Inicio/InicioSNI.fxml";
    String inicioSI = "SesionIniciada/Inicio/InicioSI.fxml";
    String boleteriaSNI = "SesionNoIniciada/Boleteria/BoleteriaSNI.fxml";
    String boleteriaSI = "SesionIniciada/Boleteria/BoleteriaSI.fxml";
    String perfilDeUsuario = "SesionIniciada/PerfilDeUsuario/PerfilDeUsuario.fxml";
    String precios = "SesionIniciada/Precios/Precios.fxml";
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
