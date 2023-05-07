package com.fastevent.fastevent.Controladores.SesionIniciada;

import com.fastevent.fastevent.Controladores.Controlador;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;


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

        String nuevaNotif = "Se ha recibido una nueva notificación";
        listaDeNotificaciones.getItems().add(new xd(nuevaNotif, "https://www.google.com/"));
        estadoDeNotifaciones.set(true);
    }

    public void accionBotonMisFinanzas(ActionEvent actionEvent) {
        System.out.println("Mis finanzas");
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

    @FXML
    private ListView<Usuario> listaMisEventos;

    public void imprimirMiEventoSeleccionado(MouseEvent mouseEvent) {
        // Obtener el índice del elemento seleccionado
        int indice = listaMisEventos.getSelectionModel().getSelectedIndex();
        // Imprimir el número del índice del elemento seleccionado
        System.out.println("Elemento seleccionado en el índice: " + listaMisEventos.getItems().get(indice).getNombre());
    }

    public void imprimirNotificacionSeleccionada(MouseEvent mouseEvent) {
        // Obtener el índice del elemento seleccionado
        int indice = listaDeNotificaciones.getSelectionModel().getSelectedIndex();
        // Imprimir el número del índice del elemento seleccionado
        System.out.println("Elemento seleccionado en el índice: " + listaDeNotificaciones.getItems().get(indice).getDireccion());
    }

    public static class Usuario {
        private Image imagen;
        private String nombre;

        public Usuario(Image imagen, String nombre) {
            this.imagen = imagen;
            this.nombre = nombre;
        }

        public Image getImagen() {
            return imagen;
        }

        public String getNombre() {
            return nombre;
        }
    }

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

        listaMisEventos.setCellFactory(param -> new ListCell<Usuario>() {
            private final ImageView imageView = new ImageView();
            private final Label label = new Label();

            @Override
            protected void updateItem(Usuario usuario, boolean empty) {
                super.updateItem(usuario, empty);
                if (empty || usuario == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    imageView.setImage(usuario.getImagen());
                    // indicamos que la imagen es de 75x75
                    imageView.setFitWidth(75);
                    imageView.setFitHeight(75);

                    VBox contenedorDeImagen = new VBox(imageView);
                    contenedorDeImagen.setStyle("-fx-border-color: black; -fx-border-width: 2; -fx-padding: 5; -fx-alignment: center; -fx-background-color: grey;");

                    // le colocamos un grosor a la imagen
                    label.setText(usuario.getNombre());
                    label.setFont(new Font("Arial", 18));
                    label.setStyle("-fx-text-fill: black;");

                    HBox hbox = new HBox(contenedorDeImagen, label);
                    hbox.setSpacing(15);
                    hbox.setAlignment(Pos.CENTER_LEFT);
                    hbox.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 0 0 1 0; -fx-padding: 5 0 5 0;");
                    setGraphic(hbox);
                }
            }
        });

        // Crear objetos Usuario y agregarlos a la lista
        List<Usuario> usuarios = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            usuarios.add(new Usuario(new Image("icono_finanzas.png"), "Usuario " + i));
        }

        // Agregar la lista de usuarios al ListView
        listaMisEventos.getItems().addAll(usuarios);

    }

    public void mostrarNotificaciones(ActionEvent actionEvent) {
        // Mostrar el menú contextual cuando se hace clic en el botón de notificación
        botonDeNotificacion.getContextMenu().show(botonDeNotificacion, Side.BOTTOM, 0, 0);
        estadoDeNotifaciones.set(false);
    }

    public void borrarNotificaciones(ActionEvent actionEvent) {
        listaDeNotificaciones.getItems().clear();
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

