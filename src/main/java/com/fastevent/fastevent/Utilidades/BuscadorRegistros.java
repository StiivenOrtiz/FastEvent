package com.fastevent.fastevent.Utilidades;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BuscadorRegistros {
    private final String password;
    private final String correo;

    public BuscadorRegistros(String correoElectronico, String contrasena) {
        this.password = contrasena;
        this.correo = correoElectronico;
    }

    public boolean verificarCredenciales(String email, String contrasena) {
        String archivo = "archivoRegistros.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.contains(correo) && linea.contains(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }

        return false;
    }
}
