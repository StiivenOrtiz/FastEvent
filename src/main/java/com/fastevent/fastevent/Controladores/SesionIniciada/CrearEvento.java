package com.fastevent.fastevent.Controladores.SesionIniciada;

// imports de FastEvent

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Modelo.Notificacion;
import com.fastevent.fastevent.Modelo.Publicacion;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTimePicker;
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
import javafx.scene.layout.VBox;
import org.controlsfx.control.SearchableComboBox;

import java.time.LocalDate;


public class CrearEvento extends Controlador {

    /*
        Variables
     */

    private final BooleanProperty estadoDeNotifaciones = new SimpleBooleanProperty(false);
    @FXML
    public Button botonBorrarNotificaciones;
    @FXML
    public SearchableComboBox<String> barraDeBusqueda;
    @FXML
    public TextField nombreEvento;
    @FXML
    public ImageView imageViewEvento;
    @FXML
    public JFXButton botonSubirImagen;
    @FXML
    public TextField precioEvento;
    @FXML
    public TextArea descripcionEvento;
    @FXML
    public ListView<Publicacion> listaProveedores;
    @FXML
    public JFXButton botonCrearEvento;
    @FXML
    public CheckBox eventoPublico;
    @FXML
    public VBox vBoxAgregarPrecio;
    @FXML
    public JFXComboBox<String> tipoEvento;
    @FXML
    public DatePicker fechaInicio;
    @FXML
    public DatePicker fechaFinalizacion;
    @FXML
    public Spinner<Integer> horaFin;
    @FXML
    public Spinner<Integer> minutoFin;
    @FXML
    public Spinner<Integer> horaInicio;

    @FXML
    public Spinner<Integer> minutoInicio;
    @FXML
    ContextMenu notificaciones = new ContextMenu();
    @FXML
    public Button botonDeNotificacion;
    @FXML
    public ListView<Notificacion> listaDeNotificaciones;

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

        // si el boton checkbox de evento publico es activado, el VBOX será visible. lo hacemos con un observador.
        eventoPublico.selectedProperty().addListener((observable, oldValue, newValue) -> {
            vBoxAgregarPrecio.setVisible(newValue);
            precioEvento.setVisible(newValue);
            precioEvento.setDisable(!newValue);
        });


        SpinnerValueFactory<Integer> hourValueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        SpinnerValueFactory<Integer> hourValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 23, 0);
        horaInicio.setValueFactory(hourValueFactory1);
        horaFin.setValueFactory(hourValueFactory2);

        SpinnerValueFactory<Integer> minuteValueFactory1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
        SpinnerValueFactory<Integer> minuteValueFactory2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 59, 0);
        minutoInicio.setValueFactory(minuteValueFactory1);
        minutoFin.setValueFactory(minuteValueFactory2);

        // Formato personalizado para las horas
        horaInicio.getEditor().setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*") && newText.length() <= 2) {
                return change;
            }
            return null;
        }));

        // Formato personalizado para los minutos
        minutoInicio.getEditor().setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*") && newText.length() <= 2) {
                return change;
            }
            return null;
        }));

        // Formato personalizado para las horas
        horaFin.getEditor().setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*") && newText.length() <= 2) {
                return change;
            }
            return null;
        }));

        // Formato personalizado para los minutos
        minutoFin.getEditor().setTextFormatter(new TextFormatter<>(change -> {
            String newText = change.getControlNewText();
            if (newText.matches("\\d*") && newText.length() <= 2) {
                return change;
            }
            return null;
        }));

        botonCrearEvento.setOnAction(event -> {
            validarFechas();
        });


    }

    public void validarFechas() {
        LocalDate fechaInicial = fechaInicio.getValue();
        LocalDate fechaFinal = fechaFinalizacion.getValue();

        if (fechaFinal.isBefore(fechaInicial)) {
            // Mostrar un mensaje de error si la fecha final es anterior a la fecha inicial
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("La fecha final no puede ser anterior a la fecha inicial.");
            alert.showAndWait();
        }
    }


    public void accionBotonVolver(ActionEvent actionEvent) {
    }

    public void accionBotonSubirImagen(ActionEvent actionEvent) {
    }

    public void accionSeleccionarProveedor(MouseEvent mouseEvent) {
    }
}