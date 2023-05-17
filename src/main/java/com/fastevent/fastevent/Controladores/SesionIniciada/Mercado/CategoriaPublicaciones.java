package com.fastevent.fastevent.Controladores.SesionIniciada.Mercado;

// imports de FastEvent

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Modelo.Notificacion;
import com.fastevent.fastevent.Modelo.Publicacion;
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

import java.util.ArrayList;
import java.util.Comparator;


public class CategoriaPublicaciones extends Controlador {

    /*
        Variables
     */

    private final BooleanProperty estadoDeNotifaciones = new SimpleBooleanProperty(false);
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

        // Ejemplo
        String direccionImagen = "com/fastevent/fastevent/SesionIniciada/Mercado/nav-bar/icono_borrar-notificaciones.png";

        // Ejemplo
        publicaciones.add(new Publicacion("Publicacion a", "Descripcion a", 0.0, direccionImagen, "Categoria a", "Proveedor a", 0.0));
        publicaciones.add(new Publicacion("Publicacion b", "Descripcion b", 1.0, direccionImagen, "Categoria b", "Proveedor b", 1.0));
        publicaciones.add(new Publicacion("Publicacion c", "Descripcion c", 2.0, direccionImagen, "Categoria c", "Proveedor c", 2.0));
        publicaciones.add(new Publicacion("Publicacion d", "Descripcion d", 3.0, direccionImagen, "Categoria d", "Proveedor d", 3.0));
        publicaciones.add(new Publicacion("Publicacion e", "Descripcion e", 4.0, direccionImagen, "Categoria e", "Proveedor e", 4.0));
        publicaciones.add(new Publicacion("Publicacion f", "Descripcion f", 5.0, direccionImagen, "Categoria f", "Proveedor f", 5.0));
        publicaciones.add(new Publicacion("Publicacion g", "Descripcion g", 6.0, direccionImagen, "Categoria g", "Proveedor g", 0.0));
        publicaciones.add(new Publicacion("Publicacion h", "Descripcion h", 7.0, direccionImagen, "Categoria h", "Proveedor h", 1.0));
        publicaciones.add(new Publicacion("Publicacion i", "Descripcion i", 8.0, direccionImagen, "Categoria i", "Proveedor i", 2.0));
        publicaciones.add(new Publicacion("Publicacion j", "Descripcion j", 9.0, direccionImagen, "Categoria j", "Proveedor j", 3.0));
        publicaciones.add(new Publicacion("Publicacion k", "Descripcion k", 10.0, direccionImagen, "Categoria k", "Proveedor k", 4.0));
        publicaciones.add(new Publicacion("Publicacion l", "Descripcion l", 11.0, direccionImagen, "Categoria l", "Proveedor l", 5.0));
        publicaciones.add(new Publicacion("Publicacion n", "Descripcion m", 12.0, direccionImagen, "Categoria m", "Proveedor m", 0.0));
        publicaciones.add(new Publicacion("Publicacion m", "Descripcion n", 13.0, direccionImagen, "Categoria n", "Proveedor n", 1.0));
        publicaciones.add(new Publicacion("Publicacion o", "Descripcion o", 14.0, direccionImagen, "Categoria o", "Proveedor o", 2.0));
        publicaciones.add(new Publicacion("Publicacion p", "Descripcion p", 15.0, direccionImagen, "Categoria p", "Proveedor p", 3.0));
        publicaciones.add(new Publicacion("Publicacion q", "Descripcion q", 16.0, direccionImagen, "Categoria q", "Proveedor q", 4.0));
        publicaciones.add(new Publicacion("Publicacion r", "Descripcion r", 17.0, direccionImagen, "Categoria r", "Proveedor r", 5.0));
        publicaciones.add(new Publicacion("Publicacion s", "Descripcion s", 18.0, direccionImagen, "Categoria s", "Proveedor s", 0.0));
        publicaciones.add(new Publicacion("Publicacion t", "Descripcion t", 19.0, direccionImagen, "Categoria t", "Proveedor t", 1.0));
        publicaciones.add(new Publicacion("Publicacion u", "Descripcion u", 20.0, direccionImagen, "Categoria u", "Proveedor u", 2.0));
        publicaciones.add(new Publicacion("Publicacion v", "Descripcion v", 21.0, direccionImagen, "Categoria v", "Proveedor v", 3.0));
        publicaciones.add(new Publicacion("Publicacion w", "Descripcion w", 22.0, direccionImagen, "Categoria w", "Proveedor w", 4.0));
        publicaciones.add(new Publicacion("Publicacion x", "Descripcion x", 23.0, direccionImagen, "Categoria x", "Proveedor x", 5.0));
        publicaciones.add(new Publicacion("Publicacion y", "Descripcion y", 24.0, direccionImagen, "Categoria y", "Proveedor y", 0.0));
        publicaciones.add(new Publicacion("Publicacion z", "Descripcion z", 25.0, direccionImagen, "Categoria z", "Proveedor z", 1.0));

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
        titulo.setText(categoria);
        paginaActual.setText("1");
        paginaActualCopia.setText("1");

        // le colocamos un observador que si cambia el valor de la pagina actual, se actualice en la copia
        paginaActual.textProperty().addListener((observable, oldValue, newValue) -> {
            paginaActualCopia.setText(newValue);
        });

        int paginas = (int) Math.ceil(publicaciones.size() / 12.0);

        paginaMax.setText(String.valueOf(paginas));
        paginaMaxCopia.setText(String.valueOf(paginas));
        resultados.setText(String.valueOf(publicaciones.size()));
        estiloBotonesPublicaciones();
    }
}