package com.fastevent.fastevent.Controladores.SesionIniciada.Mercado;

// imports de FastEvent

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Modelo.Notificacion;
import com.jfoenix.controls.JFXButton;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.Rating;
import org.controlsfx.control.SearchableComboBox;

import java.util.ArrayList;


public class CategoriaPublicaciones extends Controlador {

    /*
        Variables
     */

    @FXML
    private Button botonDeNotificacion;
    @FXML
    private ListView<Notificacion> listaDeNotificaciones;
    @FXML
    ContextMenu notificaciones = new ContextMenu();
    @FXML
    public Button botonBorrarNotificaciones;
    @FXML
    public SearchableComboBox<String> barraDeBusqueda;
    private final BooleanProperty estadoDeNotifaciones = new SimpleBooleanProperty(false);

    private String categoria;

    @FXML
    Label paginaActual;

    @FXML
    Label paginaMax;

    @FXML
    Label paginaActualCopia;

    @FXML
    Label paginaMaxCopia;

    @FXML
    public Label titulo;

    @FXML
    JFXButton botonPublicacion1, botonPublicacion2, botonPublicacion3, botonPublicacion4, botonPublicacion5,
            botonPublicacion6, botonPublicacion7, botonPublicacion8, botonPublicacion9, botonPublicacion10,
            botonPublicacion11, botonPublicacion12;

    // Métodos de la barra de navegación

    public void botonLogoRectangularPresionado(ActionEvent actionEvent) {
        System.out.println("Logo rectangular presionado");
    }

    public void accionBotonInicio(ActionEvent actionEvent) {
        System.out.println("Inicio");
    }

    public void accionBotonPrecios(ActionEvent actionEvent) {
        System.out.println("Precios");
    }

    public void accionBotonNosotros(ActionEvent actionEvent) {
        System.out.println("Nosotros");
    }

    public void accionBotonContactenos(ActionEvent actionEvent) {
        System.out.println("Contactenos");
    }

    public void accionBotonBoleteria(ActionEvent actionEvent) {
        System.out.println("Boleteria");
    }

    public void accionPerfilDeUsuario(ActionEvent actionEvent) {
        System.out.println("Perfil de usuario");
    }

    // Métodos del footer

    public void accionBotonTwitter(ActionEvent actionEvent) {
        System.out.println("Twitter");
    }

    public void accionBotonLinkedin(ActionEvent actionEvent) {
        System.out.println("Linkedin");
    }

    public void botonTerminos(ActionEvent actionEvent) {
        System.out.println("Terminos");
    }

    public void botonPrivacidad(ActionEvent actionEvent) {
        System.out.println("Privacidad");
    }

    public void accionBotonFacebook(ActionEvent actionEvent) {
        System.out.println("Facebook");
    }

    public void accionBotonInstagram(ActionEvent actionEvent) {
        System.out.println("Instagram");
    }

    public void accionBotonPreguntasFrecuentes(ActionEvent actionEvent) {
        System.out.println("Preguntas frecuentes");
    }

    // Métodos de la barra de navegación vertical

    public void accionBotonUsuarios(ActionEvent actionEvent) {
        System.out.println("Usuarios");
    }

    public void accionBotonMercado(ActionEvent actionEvent) {
        System.out.println("Mercado");
    }

    public void accionBotonMisBoletas(ActionEvent actionEvent) {
        System.out.println("Mis boletas");
    }

    public void accionBotonMisEventos(ActionEvent actionEvent) {
        System.out.println("Mis eventos");

        /* Ejemplo de notificacioón */
        listaDeNotificaciones.getItems().add(new Notificacion("Se ha recibido una nueva notificación", "https://www.google.com/"));
        estadoDeNotifaciones.set(true);
    }

    public void accionBotonMisFinanzas(ActionEvent actionEvent) {
        System.out.println("Mis finanzas");
    }

    public void imprimirNotificacionSeleccionada(MouseEvent mouseEvent) {
        // Obtener el índice del elemento seleccionado
        int indice = listaDeNotificaciones.getSelectionModel().getSelectedIndex();
        // Imprimir el número del índice del elemento seleccionado
        System.out.println("Elemento seleccionado: " + listaDeNotificaciones.getItems().get(indice).getAccion());
    }

    public void accionBuscarBarraDeBusqueda(ActionEvent actionEvent) {
        buscarBarraDeBusqueda();
    }

    public void mostrarNotificaciones(ActionEvent actionEvent) {
        // Mostrar el menú contextual cuando se hace clic en el botón de notificación
        botonDeNotificacion.getContextMenu().show(botonDeNotificacion, Side.BOTTOM, 0, 0);
        estadoDeNotifaciones.set(false);
    }

    public void borrarNotificaciones(ActionEvent actionEvent) {
        listaDeNotificaciones.getItems().clear();
    }

    public void accionBotonSerProveedor(ActionEvent actionEvent) {
        System.out.println("Ser proveedor");
    }

    public void botonPublicacion1(ActionEvent actionEvent) {
        System.out.println("Publicación 1");
    }

    public void botonPublicacion2(ActionEvent actionEvent) {
        System.out.println("Publicación 2");
    }

    public void botonPublicacion3(ActionEvent actionEvent) {
        System.out.println("Publicación 3");
    }

    public void botonPublicacion4(ActionEvent actionEvent) {
        System.out.println("Publicación 4");
    }

    public void botonPublicacion5(ActionEvent actionEvent) {
        System.out.println("Publicación 5");
    }

    public void botonPublicacion6(ActionEvent actionEvent) {
        System.out.println("Publicación 6");
    }

    public void botonPublicacion7(ActionEvent actionEvent) {
        System.out.println("Publicación 7");
    }

    public void botonPublicacion8(ActionEvent actionEvent) {
        System.out.println("Publicación 8");
    }

    public void botonPublicacion9(ActionEvent actionEvent) {
        System.out.println("Publicación 9");
    }

    public void botonPublicacion10(ActionEvent actionEvent) {
        System.out.println("Publicación 10");
    }

    public void botonPublicacion11(ActionEvent actionEvent) {
        System.out.println("Publicación 11");
    }

    public void botonPublicacion12(ActionEvent actionEvent) {
        System.out.println("Publicación 12");
    }

    public void accionBotonAnterior(ActionEvent actionEvent) {
        System.out.println("Anterior");

        int intPaginaActual = Integer.parseInt(paginaActual.getText());

        if (intPaginaActual > 1) {
            intPaginaActual--;
            paginaActual.setText(String.valueOf(intPaginaActual));
            estiloBotonesCategoria();
        }
    }

    public void accionBotonSiguiente(ActionEvent actionEvent) {
        System.out.println("Siguiente");

        int intPaginaActual = Integer.parseInt(paginaActual.getText());
        int intPaginaMax = Integer.parseInt(paginaMax.getText());

        if (intPaginaActual < intPaginaMax) {
            intPaginaActual++;
            paginaActual.setText(String.valueOf(intPaginaActual));
            estiloBotonesCategoria();
        }
    }

    /*
        Metodos de la interfaz
     */

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private void buscarBarraDeBusqueda() {
        System.out.println("Busqueda de: " + barraDeBusqueda.getSelectionModel().getSelectedItem());
    }

    private void configurarAccionEnterParaBarraDeBusqueda() {
        barraDeBusqueda.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER)
                buscarBarraDeBusqueda();
        });
    }

    private void generarEjemplo() {
        // Agregar elementos a la lista de busqueda
        barraDeBusqueda.getItems().addAll("Manzana", "Banana", "Cereza", "Durazno", "Uva");
    }

    private void configurarEstadoNotificaciones() {
        estadoDeNotifaciones.addListener((obs, oldVal, newVal) -> {
            if (newVal)
                botonDeNotificacion.getStyleClass().add("notification");
            else
                botonDeNotificacion.getStyleClass().remove("notification");
        });
    }

    private void agregarImagenBotonBorrarNotificaciones() {
        // Cargar la imagen original
        ImageView originalImageView = new ImageView(new Image("com/fastevent/fastevent/SesionIniciada/Mercado/nav-bar/icono_borrar-notificaciones.png"));

        // Configurar el tamaño de la imagen
        originalImageView.setFitHeight(26);
        originalImageView.setFitWidth(26);

        // Configurar el botón con la imagen original
        botonBorrarNotificaciones.setGraphic(originalImageView);

        // Cargar la imagen de hover
        ImageView hoverImageView = new ImageView(new Image("com/fastevent/fastevent/SesionIniciada/Mercado/nav-bar/icono_borrar-notificaciones_seleccionado.png"));

        // Configurar el tamaño de la imagen de hover
        hoverImageView.setFitHeight(26);
        hoverImageView.setFitWidth(26);

        // Agregar el listener para cambiar la imagen cuando el mouse entra y sale del botón
        botonBorrarNotificaciones.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                botonBorrarNotificaciones.setGraphic(hoverImageView);
            } else {
                botonBorrarNotificaciones.setGraphic(originalImageView);
            }
        });
    }

    private void estiloElementosListaDeNotificaciones() {
        listaDeNotificaciones.setCellFactory(list -> {
            ListCell<Notificacion> celda = new ListCell<>() {
                @Override
                protected void updateItem(Notificacion notificacion, boolean vacio) {
                    super.updateItem(notificacion, vacio);
                    if (vacio || notificacion == null) {
                        setText(null);
                    } else {
                        setText(notificacion.getDescipcion());
                    }
                }
            };
            celda.setStyle("-fx-control-inner-background: black; -fx-text-fill: white; -fx-background-color: black;");
            celda.setOnMouseEntered(e -> celda.setStyle("-fx-control-inner-background: #CFB14F; -fx-text-fill: black; -fx-background-color: #CFB14F; -fx-cursor: hand;"));
            celda.setOnMouseExited(e -> celda.setStyle("-fx-control-inner-background: black; -fx-text-fill: white; -fx-background-color: black;"));
            celda.setOnMouseClicked(e -> celda.setStyle("-fx-control-inner-background: black; -fx-text-fill: white; -fx-background-color: black;"));
            celda.selectedProperty().addListener((propiedadSeleccionadaObs, oldVal, valornNuevo) -> {
                if (valornNuevo) {
                    celda.setStyle("-fx-control-inner-background: black; -fx-text-fill: white; -fx-background-color: black;");
                } else {
                    celda.setStyle("-fx-control-inner-background: black; -fx-text-fill: white; -fx-background-color: black;");
                }
            });
            return celda;
        });
    }

    private void estiloBotonesCategoria() {
        ArrayList<JFXButton> botones = new ArrayList<>();
        botones.add(botonPublicacion1);
        botones.add(botonPublicacion2);
        botones.add(botonPublicacion3);
        botones.add(botonPublicacion4);
        botones.add(botonPublicacion5);
        botones.add(botonPublicacion6);
        botones.add(botonPublicacion7);
        botones.add(botonPublicacion8);
        botones.add(botonPublicacion9);
        botones.add(botonPublicacion10);
        botones.add(botonPublicacion11);
        botones.add(botonPublicacion12);

        // Ejemplo
        String direccionImagen = "com/fastevent/fastevent/SesionIniciada/Mercado/nav-bar/icono_borrar-notificaciones.png";

        // Ejemplo
        ArrayList<Publicacion> publicaciones = new ArrayList<>();
        publicaciones.add(new Publicacion("Publicacion 1", "Descripcion 1", 5.0, direccionImagen, "Categoria 1", "Proveedor 1", 5.0));
        publicaciones.add(new Publicacion("Publicacion 2", "Descripcion 2", 5.0, direccionImagen, "Categoria 2", "Proveedor 2", 2.0));
        publicaciones.add(new Publicacion("Publicacion 3", "Descripcion 3", 5.0, direccionImagen, "Categoria 3", "Proveedor 3", 3.0));
        publicaciones.add(new Publicacion("Publicacion 4", "Descripcion 4", 3.0, direccionImagen, "Categoria 4", "Proveedor 4", 5.0));
        publicaciones.add(new Publicacion("Publicacion 5", "Descripcion 5", 5.0, direccionImagen, "Categoria 5", "Proveedor 5", 5.0));
        publicaciones.add(new Publicacion("Publicacion 6", "Descripcion 6", 5.0, direccionImagen, "Categoria 6", "Proveedor 6", 5.0));
        publicaciones.add(new Publicacion("Publicacion 7", "Descripcion 7", 5.0, direccionImagen, "Categoria 7", "Proveedor 7", 5.0));
        publicaciones.add(new Publicacion("Publicacion 8", "Descripcion 8", 5.0, direccionImagen, "Categoria 8", "Proveedor 8", 5.0));
        publicaciones.add(new Publicacion("Publicacion 9", "Descripcion 9", 5.0, direccionImagen, "Categoria 9", "Proveedor 9", 5.0));
        publicaciones.add(new Publicacion("Publicacion 10", "Descripcion 10", 5.0, direccionImagen, "Categoria 10", "Proveedor 10", 5.0));
        publicaciones.add(new Publicacion("Publicacion 11", "Descripcion 11", 5.0, direccionImagen, "Categoria 11", "Proveedor 11", 5.0));
        publicaciones.add(new Publicacion("Publicacion 12", "Descripcion 12", 5.0, direccionImagen, "Categoria 12", "Proveedor 12", 5.0));
        publicaciones.add(new Publicacion("Publicacion 13", "Descripcion 12", 5.0, direccionImagen, "Categoria 12", "Proveedor 12", 5.0));
        publicaciones.add(new Publicacion("Publicacion 14", "Descripcion 12", 5.0, direccionImagen, "Categoria 12", "Proveedor 12", 5.0));
        publicaciones.add(new Publicacion("Publicacion 15", "Descripcion 12", 5.0, direccionImagen, "Categoria 12", "Proveedor 12", 5.0));
        publicaciones.add(new Publicacion("Publicacion 16", "Descripcion 12", 5.0, direccionImagen, "Categoria 12", "Proveedor 12", 5.0));
        publicaciones.add(new Publicacion("Publicacion 17", "Descripcion 12", 5.0, direccionImagen, "Categoria 12", "Proveedor 12", 5.0));
        publicaciones.add(new Publicacion("Publicacion 18", "Descripcion 12", 5.0, direccionImagen, "Categoria 12", "Proveedor 12", 5.0));

        botones.forEach(boton -> {
            boton.setGraphic(null);
            boton.setDisable(true);

            boton.setMaxWidth(0);
            boton.setMinWidth(0);
            boton.setMaxHeight(0);
            boton.setMinHeight(0);
        });

        botones.forEach(boton -> {
            Publicacion publicacion;

            try {
                publicacion = publicaciones.get(botones.indexOf(boton) + (botones.size() * (Integer.parseInt(paginaActual.getText()) - 1)));
                estiloBotonPublicacion(boton, publicacion.getDireccionImagen(), publicacion.getTitulo(), publicacion.getDescripcion(), publicacion.getPrecio(), publicacion.getCalificacion());
            } catch (Exception e) {
                System.out.println("No hay mas categorias");
            }
            ;
        });
    }

    private void estiloBotonPublicacion(JFXButton boton, String direccionImagen, String titulo, String descripcion, double precio, double calificacion) {
        HBox hbox = crearContenedorHBox(direccionImagen, titulo, descripcion, precio, calificacion);

        boton.setGraphic(hbox);
        boton.setDisable(false);

        boton.setMaxWidth(600);
        boton.setMinWidth(600);
        boton.setMaxHeight(250);
        boton.setMinHeight(250);
    }

    private ImageView crearImagenPublicacion(String direccionImagen) {
        ImageView imagenPublicacion = new ImageView(new Image(direccionImagen));

        imagenPublicacion.setFitWidth(200);
        imagenPublicacion.setFitHeight(140);

        imagenPublicacion.minWidth(200);
        imagenPublicacion.minHeight(140);

        imagenPublicacion.maxWidth(200);
        imagenPublicacion.maxHeight(140);


        return imagenPublicacion;
    }

    private Label crearTituloPublicacion(String titulo) {
        Label tituloPublicacion = new Label(titulo);

        tituloPublicacion.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white;");

        return tituloPublicacion;
    }

    private Label crearTextoPublicacion(String texto) {
        Label textoPublicacion = new Label(texto);

        textoPublicacion.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

        return textoPublicacion;
    }

    private Rating crearCalificacionPublicacion(double calificacion) {
        Rating calificacionPublicacion = new Rating();

        calificacionPublicacion.setRating(calificacion);
        // Hacemos que sea solo lectura
        calificacionPublicacion.setMouseTransparent(true);

        //Hacemos que sea más pequeño
        calificacionPublicacion.setMaxSize(25, 5);
        calificacionPublicacion.setPrefSize(25, 5);

        calificacionPublicacion.setStyle("-fx-padding: 0 0 0 0; -fx-background-color: transparent;");


        return calificacionPublicacion;
    }

    private VBox crearContenedorVBox(String titulo, String descripcion, double precio, double calificacion) {
        VBox contenedorVbox = new VBox(crearTituloPublicacion(titulo), crearTextoPublicacion(descripcion), crearTextoPublicacion("$" + precio), crearCalificacionPublicacion(calificacion));
        contenedorVbox.setAlignment(Pos.CENTER_LEFT);
        contenedorVbox.setSpacing(10);

        return contenedorVbox;
    }

    private HBox crearContenedorHBox(String direccionImagen, String titulo, String descripcion, double precio, double calificacion) {
        HBox hHbox = new HBox(crearImagenPublicacion(direccionImagen), crearContenedorVBox(titulo, descripcion, precio, calificacion));
        hHbox.setSpacing(20);
        hHbox.setAlignment(Pos.CENTER_LEFT);
        hHbox.setPadding(new Insets(5, 5, 5, 5));

        hHbox.setMinWidth(600);
        hHbox.maxWidth(600);

        hHbox.setMinHeight(250);
        hHbox.maxHeight(250);

        return hHbox;
    }

    public void initialize() {
        /* Notificaciones */
        // Agregar el ChangeListener al estado de la notificación
        configurarEstadoNotificaciones();
        // Configurar el estilo de los elementos de notificaciones
        estiloElementosListaDeNotificaciones();
        // Configurar el botón de notificación para mostrar el menú contextual
        botonDeNotificacion.setContextMenu(notificaciones);
        // Agregar imagen al boton de borrar notificaciones
        agregarImagenBotonBorrarNotificaciones();

        /* Barra de búsqueda */
        // Configurar el estilo de la barra de búsqueda
        configurarAccionEnterParaBarraDeBusqueda();

        /* Ejemplo */
        // Genera un ejemplo de la generación de listas y barra de búsqueda
        generarEjemplo();

        // añadido

        setCategoria("Categoria 1");
        titulo.setText("Publicaciones de " + categoria);
        paginaActual.setText("1");
        paginaActualCopia.setText("1");

        // le colocamos un observador que si cambia el valor de la pagina actual, se actualice en la copia
        paginaActual.textProperty().addListener((observable, oldValue, newValue) -> {
            paginaActualCopia.setText(newValue);
        });

        paginaMax.setText("2");
        paginaMaxCopia.setText("2");
        estiloBotonesCategoria();
    }
}