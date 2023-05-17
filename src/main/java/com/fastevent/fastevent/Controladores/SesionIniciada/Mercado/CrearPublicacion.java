package com.fastevent.fastevent.Controladores.SesionIniciada.Mercado;

// imports de FastEvent

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Modelo.Notificacion;
import com.fastevent.fastevent.Modelo.Publicacion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.SearchableComboBox;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;


public class CrearPublicacion extends Controlador {

    /*
        Variables
     */

    private final BooleanProperty estadoDeNotifaciones = new SimpleBooleanProperty(false);
    @FXML
    public Button botonBorrarNotificaciones;
    @FXML
    public SearchableComboBox<String> barraDeBusqueda;
    @FXML
    public TextField tituloPublicacion;
    @FXML
    public TextArea descripcionPublicacion;
    @FXML
    public TextField precioPublicacion;
    @FXML
    public JFXComboBox<String> categoriaPublicacion;
    @FXML
    public JFXButton botonCrearPublicacion, botonSubirImagen;
    @FXML
    ContextMenu notificaciones = new ContextMenu();
    @FXML
    ImageView imageViewPublicacion;
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


    /*
        Metodos de la interfaz
     */

    public void accionBotonSubirImagen(ActionEvent actionEvent) {
        System.out.println("Subir imagen");

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.jpeg"));

        Stage stage = (Stage) botonSubirImagen.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            try {
                String nuevaCarpeta = "Base De Datos/" + "Test" + "/"; // Ruta de la nueva carpeta donde se guardará la imagen
                Path origen = selectedFile.toPath();

                String nuevoNombre = "imagen_publicacion" + ".png"; // Generar un nuevo nombre de archivo
                Path destino = Path.of(nuevaCarpeta, nuevoNombre);

                Files.createDirectories(Path.of(nuevaCarpeta));
                Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);

                String rutaRelativa = "Base De Datos/" + "Test" + "/" + "imagen_publicacion" + ".png";
                Path rutaAbsoluta = Path.of(System.getProperty("user.dir")).resolve(rutaRelativa);
                String direccion = rutaAbsoluta.toUri().toURL().toString();

                System.out.println("Imagen copiada y guardada como: " + direccion);

                crearImagenPublicacion(direccion);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    public void accionBotonVolver(ActionEvent actionEvent) {
        System.out.println("Volver");
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

        String direccionImagen = "com/fastevent/fastevent/SesionIniciada/Mercado/nav-bar/icono_borrar-notificaciones.png";
        Publicacion publicacionEJ = new Publicacion("Publicacion a", "Descripcion a", 0.0, direccionImagen, "Categoria a", "Proveedor a", 0.0);
        categoriaPublicacion.getItems().addAll("Categoria a", "Categoria b", "Categoria c", "Categoria d", "Categoria e");
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

    private void crearImagenPublicacion(String direccionImagen) {
        imageViewPublicacion.setImage(new Image(direccionImagen));

        imageViewPublicacion.setFitWidth(400);
        imageViewPublicacion.setFitHeight(280);

        imageViewPublicacion.minWidth(400);
        imageViewPublicacion.minHeight(280);

        imageViewPublicacion.maxWidth(400);
        imageViewPublicacion.maxHeight(280);
    }

    private boolean validarPublicacion() {
        boolean mostrarError = false;
        String mensajeError = "";
        String instrucciones = "";

        if (tituloPublicacion.getText().isEmpty()) {
            mensajeError += "No se ha ingresado un título para la publicación\n";
            instrucciones += "Por favor, ingrese un título para la publicación\n";
            mostrarError = true;
        }

        if (precioPublicacion.getText().isEmpty()) {
            mensajeError += "No se ha ingresado un precio para la publicación\n";
            instrucciones += "Por favor, ingrese un precio para la publicación\n";
            mostrarError = true;
        } else {
            try {
                Double.parseDouble(precioPublicacion.getText());
            } catch (NumberFormatException e) {
                mensajeError += "El precio ingresado no es númerico\n";
                instrucciones += "Por favor, ingrese un precio númerico para la publicación\n";
                mostrarError = true;
            }

            if (Double.parseDouble(precioPublicacion.getText()) < 0) {
                mensajeError += "El precio ingresado no puede ser negativo\n";
                instrucciones += "Por favor, ingrese un precio positivo para la publicación\n";
                mostrarError = true;
            } else if (Double.parseDouble(precioPublicacion.getText()) < 5000) {
                mensajeError += "El precio ingresado no puede ser menor a 5000\n";
                instrucciones += "Por favor, ingrese un precio mayor o igual a 5000 para la publicación\n";
                mostrarError = true;
            }
        }

        if (descripcionPublicacion.getText().isEmpty()) {
            mensajeError += "No se ha ingresado una descripción para la publicación\n";
            instrucciones += "Por favor, ingrese una descripción para la publicación\n";
            mostrarError = true;
        }

        if (categoriaPublicacion.getSelectionModel().getSelectedItem() == null) {
            mensajeError += "No se ha seleccionado una categoría para la publicación\n";
            instrucciones += "Por favor, seleccione una categoría para la publicación\n";
            mostrarError = true;
        }

        if (imageViewPublicacion.getImage() == null) {
            mensajeError += "No se ha cargado una imagen para la publicación\n";
            instrucciones += "Por favor, cargue una imagen para la publicación\n";
            mostrarError = true;
        }

        if (mostrarError) {
            // Mostramos un mensaje de error
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText(mensajeError);
            alerta.setContentText(instrucciones);
            alerta.showAndWait();
            return false;
        }
        return true;
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

        botonCrearPublicacion.setText("Crear Publicación");
        botonCrearPublicacion.setOnAction(e -> {
            if (validarPublicacion()) {
                System.out.println("Guardar");
                // mostramos un mensaje de exito
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Éxito");
                alerta.setHeaderText("Publicación se ha creado con éxito");
                alerta.showAndWait();
            }
        });

    }
}