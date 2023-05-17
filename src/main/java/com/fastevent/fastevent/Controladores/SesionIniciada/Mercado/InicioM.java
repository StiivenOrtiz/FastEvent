package com.fastevent.fastevent.Controladores.SesionIniciada.Mercado;

// imports de FastEvent

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Modelo.Categoria;
import com.fastevent.fastevent.Modelo.Notificacion;
import com.jfoenix.controls.JFXButton;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import org.controlsfx.control.SearchableComboBox;

import java.util.ArrayList;


public class InicioM extends Controlador {

    /*
        Variables
     */

    private final BooleanProperty estadoDeNotifaciones = new SimpleBooleanProperty(false);
    @FXML
    public Button botonBorrarNotificaciones;
    @FXML
    public SearchableComboBox<String> barraDeBusqueda;
    @FXML
    ContextMenu notificaciones = new ContextMenu();
    @FXML
    JFXButton botonCategoria1;
    @FXML
    JFXButton botonCategoria2;
    @FXML
    JFXButton botonCategoria3;
    @FXML
    JFXButton botonCategoria4;
    @FXML
    JFXButton botonCategoria5;
    @FXML
    JFXButton botonCategoria6;
    @FXML
    private Button botonDeNotificacion;
    @FXML
    private ListView<Notificacion> listaDeNotificaciones;

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

    public void botonCategoria1(ActionEvent actionEvent) {
        System.out.println("Categoria 1");
    }

    public void botonCategoria2(ActionEvent actionEvent) {
        System.out.println("Categoria 2");
    }


    public void botonCategoria3(ActionEvent actionEvent) {
        System.out.println("Categoria 3");
    }


    public void botonCategoria4(ActionEvent actionEvent) {
        System.out.println("Categoria 4");
    }


    public void botonCategoria5(ActionEvent actionEvent) {
        System.out.println("Categoria 5");
    }

    public void botonCategoria6(ActionEvent actionEvent) {
        System.out.println("Categoria 6");
    }


    /*
        Metodos de la interfaz
     */

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
        botones.add(botonCategoria1);
        botones.add(botonCategoria2);
        botones.add(botonCategoria3);
        botones.add(botonCategoria4);
        botones.add(botonCategoria5);
        botones.add(botonCategoria6);

        // Ejemplo
        String direccionImagen = "com/fastevent/fastevent/SesionIniciada/Mercado/nav-bar/icono_borrar-notificaciones.png";
        String direccionImagenHover = "com/fastevent/fastevent/SesionIniciada/Mercado/nav-bar/icono_borrar-notificaciones_seleccionado.png";

        // Ejemplo
        ArrayList<Categoria> categorias = new ArrayList<>();
        categorias.add(new Categoria("Categoria 1", "Texto de la categoria 1", direccionImagen, direccionImagenHover));
        categorias.add(new Categoria("Categoria 2", "Texto de la categoria 2", direccionImagen, direccionImagenHover));
        categorias.add(new Categoria("Categoria 3", "Texto de la categoria 3", direccionImagen, direccionImagenHover));
        categorias.add(new Categoria("Categoria 4", "Texto de la categoria 4", direccionImagen, direccionImagenHover));
        categorias.add(new Categoria("Categoria 5", "Texto de la categoria 5", direccionImagen, direccionImagenHover));
        categorias.add(new Categoria("Categoria 6", "Texto de la categoria 6", direccionImagen, direccionImagenHover));


        botones.forEach(boton -> {
            Categoria categoria;
            try {
                categoria = categorias.get(botones.indexOf(boton));
                estiloBotonCategoria(boton, categoria.getDireccionImagen(), categoria.getDireccionImagenHover(), categoria.getTitulo(), categoria.getTexto());
            } catch (Exception e) {
                System.out.println("No hay mas categorias");
            }
        });
    }

    private void estiloBotonCategoria(JFXButton boton, String direccionImagen, String direccionImagenHover, String titulo, String texto) {
        HBox hbox = crearContenedorHBox(direccionImagen, titulo, texto, false);
        HBox hboxHover = crearContenedorHBox(direccionImagenHover, titulo, texto, true);

        boton.setGraphic(hbox);

        // Agregar el listener para cambiar la imagen cuando el mouse entra y sale del botón
        boton.hoverProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue) {
                boton.setGraphic(hboxHover);
            } else {
                boton.setGraphic(hbox);
            }
        });
    }

    private ImageView crearImagenCategoria(String direccionImagen) {
        ImageView imagenCategoria = new ImageView(new Image(direccionImagen));

        imagenCategoria.setFitWidth(200);
        imagenCategoria.setFitHeight(140);

        imagenCategoria.minWidth(200);
        imagenCategoria.minHeight(140);

        imagenCategoria.maxWidth(200);
        imagenCategoria.maxHeight(140);


        return imagenCategoria;
    }

    private Label crearTituloCategoria(String titulo, boolean hover) {
        Label tituloCategoria = new Label(titulo);

        if (hover)
            tituloCategoria.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: #CFB14F;");
        else
            tituloCategoria.setStyle("-fx-font-size: 26px; -fx-font-weight: bold; -fx-text-fill: white;");

        return tituloCategoria;
    }

    private Label crearTextoCategoria(String texto) {
        Label textoCategoria = new Label(texto);

        textoCategoria.setStyle("-fx-font-size: 14px; -fx-text-fill: white;");

        return textoCategoria;
    }

    private VBox crearContenedorVBox(String titulo, String texto, boolean hover) {
        VBox contenedorVbox = new VBox(crearTituloCategoria(titulo, hover), crearTextoCategoria(texto));
        contenedorVbox.setAlignment(Pos.CENTER_LEFT);

        return contenedorVbox;
    }

    private HBox crearContenedorHBox(String direccionImagen, String titulo, String texto, boolean hover) {
        HBox hHbox = new HBox(crearImagenCategoria(direccionImagen), crearContenedorVBox(titulo, texto, hover));
        hHbox.setSpacing(20);
        hHbox.setAlignment(Pos.CENTER_LEFT);
        hHbox.setPadding(new Insets(5, 5, 5, 5));
        hHbox.setMinWidth(450);
        hHbox.maxWidth(450);

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

        estiloBotonesCategoria();

    }

}