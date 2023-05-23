package com.fastevent.fastevent.Utilidades;

import com.fastevent.fastevent.Modelo.Categoria;

import java.util.ArrayList;
import java.util.List;

public class DatosSistema {
    private final static List<Categoria> categorias = new ArrayList<>();
    private final static List<String> categoriasString = new ArrayList<>();
    private static DatosSistema datosSistema;

    private DatosSistema(){
        inicializar();
    }

    public static DatosSistema getInstance(){
        if(datosSistema == null){
            datosSistema = new DatosSistema();
        }
        return datosSistema;
    }

    private void inicializar(){
        String direccionImagen = "com/fastevent/fastevent/SesionIniciada/Mercado/nav-bar/icono_borrar-notificaciones.png";
        String direccionImagenHover = "com/fastevent/fastevent/SesionIniciada/Mercado/nav-bar/icono_borrar-notificaciones_seleccionado.png";

        categorias.add(new Categoria("Categoria 1", "Texto de la categoria 1", direccionImagen, direccionImagenHover));
        categorias.add(new Categoria("Categoria 2", "Texto de la categoria 2", direccionImagen, direccionImagenHover));
        categorias.add(new Categoria("Categoria 3", "Texto de la categoria 3", direccionImagen, direccionImagenHover));
        categorias.add(new Categoria("Categoria 4", "Texto de la categoria 4", direccionImagen, direccionImagenHover));
        categorias.add(new Categoria("Categoria 5", "Texto de la categoria 5", direccionImagen, direccionImagenHover));
        categorias.add(new Categoria("Categoria 6", "Texto de la categoria 6", direccionImagen, direccionImagenHover));

        categorias.forEach(categoria -> categoriasString.add(categoria.getTitulo()));
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<String> getCategoriasString() {
        return categoriasString;
    }
}
