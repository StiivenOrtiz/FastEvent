package com.fastevent.fastevent.Controladores.SesionIniciada;

// imports de FastEvent

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Modelo.Boleta;
import com.fastevent.fastevent.Modelo.Evento;
import com.fastevent.fastevent.Modelo.Notificacion;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import org.controlsfx.control.SearchableComboBox;

import java.util.ArrayList;
import java.util.List;


public class InicioSI extends Controlador {

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
    private Button botonDeNotificacion;
    @FXML
    private ListView<Notificacion> listaDeNotificaciones;
    @FXML
    private ListView<Evento> listaMisEventos;
    @FXML
    private ListView<Boleta> listaMisBoletas;

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

    public void accionSeleccionarMiEventos(MouseEvent mouseEvent) {
        // Obtener el índice del elemento seleccionado
        int indice = listaMisEventos.getSelectionModel().getSelectedIndex();
        // Imprimir el número del índice del elemento seleccionado
        System.out.println("Elemento seleccionado: " + listaMisEventos.getItems().get(indice).getNombre());
    }

    public void accionSeleccionarMiBoletas(MouseEvent mouseEvent) {
        // Obtener el índice del elemento seleccionado
        int indice = listaMisBoletas.getSelectionModel().getSelectedIndex();
        // Imprimir el número del índice del elemento seleccionado
        System.out.println("Elemento seleccionado: " + listaMisBoletas.getItems().get(indice).getNombre() + " " + listaMisBoletas.getItems().get(indice).getFecha());
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
        // Crear objetos de ejemplo
        List<Boleta> boletas = new ArrayList<>();
        List<Evento> eventos = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            boletas.add(new Boleta("Boleta " + i, "23/12/2003", new Image("Ejemplo.png")));
            eventos.add(new Evento("Evento " + i, new Image("Ejemplo.png")));
        }

        // Agregar la lista de usuarios al ListView
        listaMisEventos.getItems().addAll(eventos);
        listaMisBoletas.getItems().addAll(boletas);

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
        ImageView originalImageView = new ImageView(new Image("com/fastevent/fastevent/SesionIniciada/Inicio/nav-bar/icono_borrar-notificaciones.png"));

        // Configurar el tamaño de la imagen
        originalImageView.setFitHeight(26);
        originalImageView.setFitWidth(26);

        // Configurar el botón con la imagen original
        botonBorrarNotificaciones.setGraphic(originalImageView);

        // Cargar la imagen de hover
        ImageView hoverImageView = new ImageView(new Image("com/fastevent/fastevent/SesionIniciada/Inicio/nav-bar/icono_borrar-notificaciones_seleccionado.png"));

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

    private void estiloElementosListaMisEventos() {
        listaMisEventos.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Evento evento, boolean vacio) {
                super.updateItem(evento, vacio);
                if (vacio || evento == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setGraphic(generarContenedorHboxImpresion(evento));
                }
            }
        });
    }

    private void estiloElementosListaMisBoletas() {
        listaMisBoletas.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Boleta boleta, boolean vacio) {
                super.updateItem(boleta, vacio);
                if (vacio || boleta == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    // graficamos el contenedor
                    HBox contenedor = generarContenedorHboxImpresion(boleta);
                    setGraphic(contenedor);
                }
            }
        });
    }

    private VBox generarContenedorDeImagen(Image imagen) {
        ImageView imageView = new ImageView();
        imageView.setImage(imagen);
        imageView.setFitWidth(75);
        imageView.setFitHeight(75);

        VBox contenedorDeImagen = new VBox(imageView);
        contenedorDeImagen.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 5; -fx-alignment: center; -fx-background-color: grey;");

        return contenedorDeImagen;
    }

    private Label generarLabel(String texto) {
        Label label = new Label(texto);
        label.setFont(new Font("Arial", 18));
        label.setStyle("-fx-text-fill: black;");

        return label;
    }

    private HBox generarContenedorHboxImpresion(Boleta boleta) {
        // añadimos los elementos al contenedor HBox
        HBox hbox = new HBox(generarContenedorDeImagen(boleta.getImagen()), generarLabel(boleta.getNombre()), generarLabel(boleta.getFecha()));
        // le damos un espaciado de 15 entre los elementos
        hbox.setSpacing(15);
        // alineamos los elementos a la izquierda
        hbox.setAlignment(Pos.CENTER_LEFT);
        // le damos un estilo al contenedor
        hbox.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 0 0 1 0; -fx-padding: 5 0 5 0; -fx-cursor: hand;");

        return hbox;
    }

    private HBox generarContenedorHboxImpresion(Evento evento) {
        // añadimos los elementos al contenedor HBox
        HBox hbox = new HBox(generarContenedorDeImagen(evento.getImagen()), generarLabel(evento.getNombre()));
        // le damos un espaciado de 15 entre los elementos
        hbox.setSpacing(15);
        // alineamos los elementos a la izquierda
        hbox.setAlignment(Pos.CENTER_LEFT);
        // le damos un estilo al contenedor
        hbox.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 0 0 1 0; -fx-padding: 5 0 5 0; -fx-cursor: hand;");

        return hbox;
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

        /* Listas */
        // Configurar el estilo de los elementos de la lista de eventos
        estiloElementosListaMisEventos();
        // Configurar el estilo de los elementos de la lista de boletas
        estiloElementosListaMisBoletas();

        /* Barra de búsqueda */
        // Configurar el estilo de la barra de búsqueda
        configurarAccionEnterParaBarraDeBusqueda();

        /* Ejemplo */
        // Genera un ejemplo de la generación de listas y barra de búsqueda
        generarEjemplo();
    }

}