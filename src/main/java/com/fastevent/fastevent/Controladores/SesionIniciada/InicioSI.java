package com.fastevent.fastevent.Controladores.SesionIniciada;

import com.fastevent.fastevent.Controladores.Controlador;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;


public class InicioSI extends Controlador {

    /*
        Variables
     */

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

    public void botonIniciarSesion(ActionEvent actionEvent) {
        System.out.println("Iniciar sesion");
    }

    public void botonRegistrarse(ActionEvent actionEvent) {
        System.out.println("Registrarse");
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

        String nuevaNotif = "Se ha recibido una nueva notificación";
        listaDeNotificaciones.getItems().add(new xd(nuevaNotif, "https://www.google.com/"));
        estadoDeNotifaciones.set(true);
    }

    /*
        Metodos de la interfaz
     */

    @FXML
    private Button botonDeNotificacion;
    @FXML
    private ListView<xd> listaDeNotificaciones;
    @FXML
    ContextMenu notificaciones = new ContextMenu();
    @FXML
    public Button botonBorrarNotificaciones;

    private final BooleanProperty estadoDeNotifaciones = new SimpleBooleanProperty(false);

    public void initialize() {
        // Agregar el ChangeListener al estado de la notificación
        estadoDeNotifaciones.addListener((obs, oldVal, newVal) -> {
            if (newVal)
                botonDeNotificacion.getStyleClass().add("notification");
            else
                botonDeNotificacion.getStyleClass().remove("notification");
        });

        // Configurar el estilo de los elementos del ListView
        estiloElementosListView();

        // Configurar el botón de notificación para mostrar el menú contextual
        botonDeNotificacion.setContextMenu(notificaciones);

        // Agregar imagen al boton de borrar notificaciones
        agregarImagenBotonBorrarNotificaciones();

    }

    public void mostrarNotificaciones(ActionEvent actionEvent) {
        // Mostrar el menú contextual cuando se hace clic en el botón de notificación
        botonDeNotificacion.getContextMenu().show(botonDeNotificacion, Side.BOTTOM, 0, 0);
        estadoDeNotifaciones.set(false);
    }

    public void borrarNotificaciones(ActionEvent actionEvent) {
        listaDeNotificaciones.getItems().clear();
    }

    public void imprimirNumeroDeElementoSeleccionado(MouseEvent mouseEvent) {
        // Obtener el índice del elemento seleccionado
        int indice = listaDeNotificaciones.getSelectionModel().getSelectedIndex();
        // Imprimir el número del índice del elemento seleccionado
        System.out.println("Elemento seleccionado en el índice: " + listaDeNotificaciones.getItems().get(indice).getDireccion());
    }

    protected void agregarImagenBotonBorrarNotificaciones() {
        // Cargar la imagen original
        Image originalImage = new Image("com/fastevent/fastevent/SesionIniciada/Inicio/nav-bar/icono_borrar-notificaciones.png");
        ImageView originalImageView = new ImageView(originalImage);

        // Cargar la imagen de hover
        Image hoverImage = new Image("com/fastevent/fastevent/SesionIniciada/Inicio/nav-bar/icono_borrar-notificaciones_seleccionado.png");
        ImageView hoverImageView = new ImageView(hoverImage);

        originalImageView.setFitHeight(26);
        originalImageView.setFitWidth(26);

        // Configurar el botón con la imagen original
        botonBorrarNotificaciones.setGraphic(originalImageView);

        hoverImageView.setFitHeight(26);
        hoverImageView.setFitWidth(26);

        // Cambiar la imagen al pasar el mouse por encima
        botonBorrarNotificaciones.setOnMouseEntered(event -> {
            botonBorrarNotificaciones.setGraphic(hoverImageView);
        });

        // Volver a la imagen original al sacar el mouse
        botonBorrarNotificaciones.setOnMouseExited(event -> {
            botonBorrarNotificaciones.setGraphic(originalImageView);
        });
    }

    protected void estiloElementosListView() {
        listaDeNotificaciones.setCellFactory(list -> {
            ListCell<xd> cell = new ListCell<xd>() {
                @Override
                protected void updateItem(xd item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty || item == null) {
                        setText(null);
                    } else {
                        setText(item.getNombre());
                    }
                }
            };
            cell.setStyle("-fx-control-inner-background: black; -fx-text-fill: white; -fx-background-color: black;");
            cell.setOnMouseEntered(e -> cell.setStyle("-fx-control-inner-background: #CFB14F; -fx-text-fill: black; -fx-background-color: #CFB14F;"));
            cell.setOnMouseExited(e -> cell.setStyle("-fx-control-inner-background: black; -fx-text-fill: white; -fx-background-color: black;"));
            cell.setOnMouseClicked(e -> cell.setStyle("-fx-control-inner-background: black; -fx-text-fill: white; -fx-background-color: black;"));
            cell.selectedProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal) {
                    cell.setStyle("-fx-control-inner-background: black; -fx-text-fill: white; -fx-background-color: black;");
                } else {
                    cell.setStyle("-fx-control-inner-background: black; -fx-text-fill: white; -fx-background-color: black;");
                }
            });
            return cell;
        });
    }

    public static class xd {
        private String nombre;
        private String direccion;

        public xd(String nombre, String direccion) {
            this.nombre = nombre;
            this.direccion = direccion;
        }

        public String getNombre() {
            return nombre;
        }

        public String getDireccion() {
            return direccion;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setDireccion(String direccion) {
            this.direccion = direccion;
        }
    }
}

