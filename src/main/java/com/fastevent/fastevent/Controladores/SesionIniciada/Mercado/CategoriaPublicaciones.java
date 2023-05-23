package com.fastevent.fastevent.Controladores.SesionIniciada.Mercado;

// imports de FastEvent

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Interfaces.IPersistenciaPublicaciones;
import com.fastevent.fastevent.Modelo.Notificacion;
import com.fastevent.fastevent.Modelo.Publicacion;
import com.fastevent.fastevent.Persistencia.Publicaciones.PersistenciaPublicaciones;
import com.fastevent.fastevent.Utilidades.DIRECCIONESFXML;
import com.fastevent.fastevent.Utilidades.NOMBRESPANTALLAS;
import com.fastevent.fastevent.Utilidades.Sesion;
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
import org.controlsfx.control.Rating;
import org.controlsfx.control.SearchableComboBox;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;


public class CategoriaPublicaciones extends Controlador {

    /*
        Variables
     */

    private final BooleanProperty estadoDeNotifaciones = new SimpleBooleanProperty(false);
    ArrayList<JFXButton> botones = new ArrayList<>();
    @FXML
    public Button botonBorrarNotificaciones;
    @FXML
    public SearchableComboBox<String> barraDeBusqueda;
    @FXML
    public Label resultados;
    @FXML
    public Label titulo;
    @FXML
    public JFXButton botonOrdenarAlf, botonMenorPrecio, botonMayorPrecio, botonMenorCalificacion, botonMayorCalificacion;
    @FXML
    ContextMenu notificaciones = new ContextMenu();
    @FXML
    Label paginaActual;
    @FXML
    Label paginaMax;
    @FXML
    Label paginaActualCopia;
    @FXML
    Label paginaMaxCopia;
    @FXML
    JFXButton botonPublicacion1, botonPublicacion2, botonPublicacion3, botonPublicacion4, botonPublicacion5,
            botonPublicacion6, botonPublicacion7, botonPublicacion8, botonPublicacion9, botonPublicacion10,
            botonPublicacion11, botonPublicacion12;
    ArrayList<Publicacion> publicaciones = new ArrayList<>();
    boolean ordenarAlfabeticamente = false;
    int orden = 0; // 0 = Sin ordenar, 1 = Menor precio, 2 = Mayor precio, 3 = Menor calificacion, 4 = Mayor calificacion
    @FXML
    private Button botonDeNotificacion;
    @FXML
    private ListView<Notificacion> listaDeNotificaciones;
    private String categoria;

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
        cargarPantalla(NOMBRESPANTALLAS.CREAREVENTO, DIRECCIONESFXML.CREARPUBLICACION);
    }

    public void botonPublicacion1(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion2(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(1 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion3(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(2 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion4(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(3 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion5(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(4 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion6(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(5 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion7(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(6 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion8(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(7 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion9(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(8 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion10(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(9 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion11(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(10 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void botonPublicacion12(ActionEvent actionEvent) {
        cargarPublicacion(publicaciones.get(11 + ((Integer.parseInt(paginaActual.getText()) - 1) * botones.size())));
    }

    public void accionBotonVolver(ActionEvent actionEvent) {
        cargarPantalla(NOMBRESPANTALLAS.INICIOMERCADO, DIRECCIONESFXML.INICIOMERCADO);
    }

    public void accionBotonAnterior(ActionEvent actionEvent) {
        System.out.println("Anterior");

        int intPaginaActual = Integer.parseInt(paginaActual.getText());

        if (intPaginaActual > 1) {
            intPaginaActual--;
            paginaActual.setText(String.valueOf(intPaginaActual));
            estiloBotonesPublicaciones();
        }
    }

    public void accionBotonSiguiente(ActionEvent actionEvent) {
        System.out.println("Siguiente");

        int intPaginaActual = Integer.parseInt(paginaActual.getText());
        int intPaginaMax = Integer.parseInt(paginaMax.getText());

        if (intPaginaActual < intPaginaMax) {
            intPaginaActual++;
            paginaActual.setText(String.valueOf(intPaginaActual));
            estiloBotonesPublicaciones();
        }
    }

    public void botonOrdenarAlfabeticamente(ActionEvent actionEvent) {
        botonOrdenarAlf.getStyleClass().remove("AZ");
        botonOrdenarAlf.getStyleClass().remove("ZA");

        if (!ordenarAlfabeticamente) {
            publicaciones.sort(Comparator.comparing(Publicacion::getTitulo).reversed());
            ordenarAlfabeticamente = true;
            botonOrdenarAlf.getStyleClass().add("ZA");
        } else {
            publicaciones.sort(Comparator.comparing(Publicacion::getTitulo));
            ordenarAlfabeticamente = false;
            botonOrdenarAlf.getStyleClass().add("AZ");
        }

        switch (orden) {
            case 1 -> ordenarPrecioMenorMayor();
            case 2 -> ordenarPrecioMayorMenor();
            case 3 -> ordenarCalifiacionMenorMayor();
            case 4 -> ordenarCalifiacionMayorMenor();
        }

        estiloBotonesPublicaciones();
    }

    public void botonOrdenarPrecioMenorMayor(ActionEvent actionEvent) {
        ordenarPrecioMenorMayor();
        orden = 1;
    }

    public void botonOrdenarPrecioMayorMenor(ActionEvent actionEvent) {
        ordenarPrecioMayorMenor();
        orden = 2;
    }

    public void botonOrdenarCalifiacionMenorMayor(ActionEvent actionEvent) {
        ordenarCalifiacionMenorMayor();
        orden = 3;
    }

    public void botonOrdenarCalifiacionMayorMenor(ActionEvent actionEvent) {
        ordenarCalifiacionMayorMenor();
        orden = 4;
    }

    public void botonRetirarFiltros(ActionEvent actionEvent) {
        retirarFiltros();
        orden = 0;
        estiloBotonesPublicaciones();
    }

    /*
        Metodos de la interfaz
     */

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    private void ordenarPrecioMenorMayor() {
        retirarFiltros();
        publicaciones.sort(Comparator.comparingDouble(Publicacion::getPrecio));
        botonMenorPrecio.getStyleClass().add("aplicado");
        estiloBotonesPublicaciones();
    }

    private void ordenarPrecioMayorMenor() {
        retirarFiltros();
        publicaciones.sort(Comparator.comparingDouble(Publicacion::getPrecio).reversed());
        botonMayorPrecio.getStyleClass().add("aplicado");
        estiloBotonesPublicaciones();
    }

    private void ordenarCalifiacionMenorMayor() {
        retirarFiltros();
        publicaciones.sort(Comparator.comparingDouble(Publicacion::getCalificacion));
        botonMenorCalificacion.getStyleClass().add("aplicado");
        estiloBotonesPublicaciones();
    }

    private void ordenarCalifiacionMayorMenor() {
        retirarFiltros();
        // Ordenar publicaciones por calificacion de mayor a menor
        publicaciones.sort(Comparator.comparingDouble(Publicacion::getCalificacion).reversed());
        botonMayorCalificacion.getStyleClass().add("aplicado");
        estiloBotonesPublicaciones();
    }

    private void retirarFiltros() {
        botonMenorPrecio.getStyleClass().remove("aplicado");
        botonMayorPrecio.getStyleClass().remove("aplicado");
        botonMenorCalificacion.getStyleClass().remove("aplicado");
        botonMayorCalificacion.getStyleClass().remove("aplicado");

        if (!ordenarAlfabeticamente) {
            publicaciones.sort(Comparator.comparing(Publicacion::getTitulo));
        } else {
            publicaciones.sort(Comparator.comparing(Publicacion::getTitulo).reversed());
        }
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

    public void cargarPublicaciones() {
        // Agregar elementos a la lista de busqueda
        barraDeBusqueda.getItems().addAll("Manzana", "Banana", "Cereza", "Durazno", "Uva");

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

        IPersistenciaPublicaciones persistenciaPublicaciones = new PersistenciaPublicaciones();
        publicaciones.addAll(persistenciaPublicaciones.obtenerPublicacionesCategoria(categoria));

        // Genera un ejemplo de la generación de listas y barra de búsqueda

        // añadido
        titulo.setText(categoria);
        paginaActual.setText("1");
        paginaActualCopia.setText("1");

        // le colocamos un observador que si cambia el valor de la pagina actual, se actualice en la copia
        paginaActual.textProperty().addListener((observable, oldValue, newValue) -> {
            paginaActualCopia.setText(newValue);
        });

        int paginas = (int) Math.ceil((double) publicaciones.size() / (double) botones.size());

        paginaMax.setText(String.valueOf(paginas));
        paginaMaxCopia.setText(String.valueOf(paginas));
        resultados.setText(String.valueOf(publicaciones.size()));
        estiloBotonesPublicaciones();
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

    private void estiloBotonesPublicaciones() {
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
        });
    }

    private void estiloBotonPublicacion(JFXButton boton, String direccionImagen, String titulo, String descripcion, double precio, double calificacion) throws MalformedURLException {
        Path rutaAbsoluta = Path.of(System.getProperty("user.dir")).resolve(direccionImagen);
        String direccion = rutaAbsoluta.toUri().toURL().toString();

        HBox hbox = crearContenedorHBox(direccion, titulo, descripcion, precio, calificacion);

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
    }
}