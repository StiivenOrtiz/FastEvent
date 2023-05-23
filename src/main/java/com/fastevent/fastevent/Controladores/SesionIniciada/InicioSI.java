package com.fastevent.fastevent.Controladores.SesionIniciada;

// imports de FastEvent

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Interfaces.IPersistenciaBoletas;
import com.fastevent.fastevent.Interfaces.IPersistenciaEventos;
import com.fastevent.fastevent.Modelo.Boleta;
import com.fastevent.fastevent.Modelo.Evento;
import com.fastevent.fastevent.Modelo.Notificacion;
import com.fastevent.fastevent.Persistencia.Boletas.PersistenciaBoletas;
import com.fastevent.fastevent.Persistencia.Eventos.PersistenciaEventos;
import com.fastevent.fastevent.Utilidades.DIRECCIONESFXML;
import com.fastevent.fastevent.Utilidades.NOMBRESPANTALLAS;
import com.fastevent.fastevent.Utilidades.Sesion;
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

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


public class InicioSI extends Controlador {

    /*
        Variables
     */

    private final BooleanProperty estadoDeNotifaciones = new SimpleBooleanProperty(false);
    private List<Evento> eventosBoletas;
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
        cargarPantalla(NOMBRESPANTALLAS.INICIOSI, DIRECCIONESFXML.INICIOSI);
    }

    public void accionBotonInicio(ActionEvent actionEvent) {
        cargarPantalla(NOMBRESPANTALLAS.INICIOSI, DIRECCIONESFXML.INICIOSI);
    }

    public void accionBotonPrecios(ActionEvent actionEvent) {
        cargarPantalla(NOMBRESPANTALLAS.PRECIOS, DIRECCIONESFXML.PRECIOS);
    }

    public void accionBotonNosotros(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Nosotros");
    }

    public void accionBotonContactenos(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Contactenos");
    }

    public void accionBotonBoleteria(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Boleteria");
    }

    public void accionPerfilDeUsuario(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Perfil de usuario");
    }

    // Métodos del footer

    public void accionBotonTwitter(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Twitter");
    }

    public void accionBotonLinkedin(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Linkedin");
    }

    public void botonTerminos(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Terminos y condiciones");
    }

    public void botonPrivacidad(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Privacidad");
    }

    public void accionBotonFacebook(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Facebook");
    }

    public void accionBotonInstagram(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Instagram");
    }

    public void accionBotonPreguntasFrecuentes(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Preguntas frecuentes");
    }

    // Métodos de la barra de navegación vertical

    public void accionBotonUsuarios(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Usuarios");
    }

    public void accionBotonMercado(ActionEvent actionEvent) {
        cargarPantalla(NOMBRESPANTALLAS.INICIOMERCADO, DIRECCIONESFXML.INICIOMERCADO);
    }

    public void accionBotonMisBoletas(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Comprar boletas");
    }

    public void accionBotonMisEventos(ActionEvent actionEvent) {
        cargarPantalla(NOMBRESPANTALLAS.CREAREVENTO, DIRECCIONESFXML.CREAREVENTO);
    }

    public void accionBotonMisFinanzas(ActionEvent actionEvent) {
        mostrarMensajeInformativo("Esta funcionalidad no está disponible aún.", "Por favor intente en futuras actualizaciones.", "Mis finanzas");

        /* Ejemplo de notificacioón */
        listaDeNotificaciones.getItems().add(new Notificacion("Se ha recibido una nueva notificación", "https://www.google.com/"));
        estadoDeNotifaciones.set(true);
    }

    public void accionSeleccionarMiEventos(MouseEvent mouseEvent) {
        try {
            // Obtener el índice del elemento seleccionado
            int indice = listaMisEventos.getSelectionModel().getSelectedIndex();
            // Imprimir el número del índice del elemento seleccionado
            System.out.println("Elemento seleccionado: " + listaMisEventos.getItems().get(indice).getNombre());
        } catch (Exception ignored) {
        }
    }

    public void accionSeleccionarMiBoletas(MouseEvent mouseEvent) {
        try {
            // Obtener el índice del elemento seleccionado
            int indice = listaMisBoletas.getSelectionModel().getSelectedIndex();
            // Imprimir el número del índice del elemento seleccionado
            System.out.println("Elemento seleccionado: " + listaMisBoletas.getItems().get(indice).getIdEvento() + " " + listaMisBoletas.getItems().get(indice).getCreadorNombre());
        } catch (Exception ignored) {
        }
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
        IPersistenciaEventos persistenciaEventos = new PersistenciaEventos();
        IPersistenciaBoletas persistenciaBoletas = new PersistenciaBoletas();

        List<Boleta> boletas = persistenciaBoletas.obtenerBoletasUsuario();

        // Agregar la lista de usuarios al ListView
        listaMisEventos.getItems().addAll(persistenciaEventos.obtenerEventosUsuario());
        listaMisBoletas.getItems().addAll(boletas);

        eventosBoletas = persistenciaEventos.obtenerEventosBoletas(boletas);

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
                    Optional<Evento> eventoCorrespondiente = eventosBoletas.stream()
                            .filter(evento ->
                                    boleta.getIdEvento() == evento.getId() && boleta.getCreadorCorreo().equals(evento.getCreadorCorreo()))
                            .findFirst();
                    if (eventoCorrespondiente.isPresent()) {
                        HBox contenedor = generarContenedorHboxImpresion(boleta, eventoCorrespondiente.get());
                        setGraphic(contenedor);
                    }
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

    private HBox generarContenedorHboxImpresion(Boleta boleta, Evento evento) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String label = evento.getFechaInicio().format(formatter) + " - " + evento.getFechaFin().format(formatter) + " - " + boleta.getIdBoleta() + " - " + boleta.getCreadorNombre();
        // añadimos los elementos al contenedor HBox

        Path rutaAbsoluta = Path.of(System.getProperty("user.dir")).resolve(evento.getDireccionImagen());
        String direccion = "";
        try {
            direccion = rutaAbsoluta.toUri().toURL().toString();
        } catch (MalformedURLException ignored) {}

        HBox hbox = new HBox(generarContenedorDeImagen(new Image(direccion)), generarLabel(evento.getNombre()), generarLabel(label));
        // le damos un espaciado de 15 entre los elementos
        hbox.setSpacing(15);
        // alineamos los elementos a la izquierda
        hbox.setAlignment(Pos.CENTER_LEFT);
        // le damos un estilo al contenedor
        hbox.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 0 0 1 0; -fx-padding: 5 0 5 0; -fx-cursor: hand;");

        return hbox;
    }

    private HBox generarContenedorHboxImpresion(Evento evento) {
        Path rutaAbsoluta = Path.of(System.getProperty("user.dir")).resolve(evento.getDireccionImagen());
        String direccion = "";
        try {
            direccion = rutaAbsoluta.toUri().toURL().toString();
        } catch (MalformedURLException ignored) {}
        // añadimos los elementos al contenedor HBox
        HBox hbox = new HBox(generarContenedorDeImagen(new Image(direccion)), generarLabel(evento.getNombre()));
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