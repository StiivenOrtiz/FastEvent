package com.fastevent.fastevent.Controladores.SesionIniciada;

// imports de FastEvent

import com.fastevent.fastevent.Controladores.Controlador;
import com.fastevent.fastevent.Interfaces.IPersistenciaEventos;
import com.fastevent.fastevent.Interfaces.IPersistenciaPublicaciones;
import com.fastevent.fastevent.Interfaces.IPersistenciaUsuarios;
import com.fastevent.fastevent.Modelo.Evento;
import com.fastevent.fastevent.Modelo.Notificacion;
import com.fastevent.fastevent.Modelo.Publicacion;
import com.fastevent.fastevent.Modelo.PublicacionDeEvento;
import com.fastevent.fastevent.Persistencia.Eventos.PersistenciaEventos;
import com.fastevent.fastevent.Persistencia.Publicaciones.PersistenciaPublicaciones;
import com.fastevent.fastevent.Persistencia.Usuarios.PersistenciaUsuarios;
import com.fastevent.fastevent.Utilidades.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.controlsfx.control.SearchableComboBox;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class CrearEvento extends Controlador {

    /*
        Variables
     */

    private final BooleanProperty estadoDeNotifaciones = new SimpleBooleanProperty(false);
    String direccionImagen = "";
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
    private List<PublicacionDeEvento> publicacionesDeEvento = new ArrayList<>();

    private Evento eventoEnDesarrollo;

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
        ImageView originalImageView = new ImageView(new Image("com/fastevent/fastevent/SesionIniciada/CrearEvento/nav-bar/icono_borrar-notificaciones.png"));

        // Configurar el tamaño de la imagen
        originalImageView.setFitHeight(26);
        originalImageView.setFitWidth(26);

        // Configurar el botón con la imagen original
        botonBorrarNotificaciones.setGraphic(originalImageView);

        // Cargar la imagen de hover
        ImageView hoverImageView = new ImageView(new Image("com/fastevent/fastevent/SesionIniciada/CrearEvento/nav-bar/icono_borrar-notificaciones_seleccionado.png"));

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

        botonCrearEvento.setText("Crear evento");

        botonCrearEvento.setOnAction(event -> {
            if (validarDatos())
                crearEvento();
        });


    }

    private void crearEvento() {
        Evento evento = new Evento();

        LocalDateTime horaInicioLocalTime = LocalDateTime.of(fechaInicio.getValue(), LocalTime.of(horaInicio.getValue(), minutoInicio.getValue()));
        LocalDateTime horaFinLocalTime = LocalDateTime.of(fechaFinalizacion.getValue(), LocalTime.of(horaFin.getValue(), minutoFin.getValue()));

        evento.setNombre(nombreEvento.getText());
        evento.setDescripcion(descripcionEvento.getText());
        evento.setFechaInicio(fechaInicio.getValue());
        evento.setFechaFin(fechaFinalizacion.getValue());
        evento.setHoraInicio(horaInicioLocalTime);
        evento.setHoraFin(horaFinLocalTime);
        evento.setEsPublico(eventoPublico.isSelected());
        evento.setCreadorNombre(Sesion.getUsuarioActual().getNombres() + " " + Sesion.getUsuarioActual().getApellidos());
        evento.setCreadorCorreo(Sesion.getUsuarioActual().getCorreo());
        evento.setEstado("Activo");
        evento.setDireccionImagen(direccionImagen);
        evento.setPublicacionesDeEvento(publicacionesDeEvento);
        evento.setId(Sesion.getUsuarioActual().getEventosCreados());

        if (eventoPublico.isSelected())
            evento.setPrecioEntrada(Double.parseDouble(precioEvento.getText()));
        else
            evento.setPrecioEntrada(0.0);


        Sesion.getUsuarioActual().setEventosCreados(Sesion.getUsuarioActual().getPublicacionesCreadas() + 1);
        IPersistenciaUsuarios persistenciaUsuarios = new PersistenciaUsuarios();
        if (!persistenciaUsuarios.actualizarUsuario()) {
            // Mensaje de error
            mostrarMensajeError("No se pudo actualizar el usuario", "Vuelvalo a intentar más tarde");
            Sesion.getUsuarioActual().setEventosCreados(Sesion.getUsuarioActual().getPublicacionesCreadas() - 1);
        } else {
            IPersistenciaEventos persistenciaEventos = new PersistenciaEventos();
            if (!persistenciaEventos.registrarEvento(evento)) {
                mostrarMensajeError("No se pudo registrar evento", "Vuelvalo a intentar por favor");
                Sesion.getUsuarioActual().setEventosCreados(Sesion.getUsuarioActual().getPublicacionesCreadas() - 1);
            } else {
                mostrarMensajeInformativo("Evento se ha creado con éxito", "Podrá ver sus eventos en la sección de mis eventos", "Éxito");
                cargarPantalla(NOMBRESPANTALLAS.INICIOSI, DIRECCIONESFXML.INICIOSI);
                Sesion.setEventoEnDesarrollo(null);
            }
        }
    }

    private boolean validarDatos() {
        // validamos que los campos no estén vacíos
        String error = "";
        String instrucciones = "";
        boolean valido = true;

        if (nombreEvento.getText().isEmpty()) {
            error += "El nombre del evento no puede estar vacío.\n";
            instrucciones += "Ingrese un nombre para el evento.\n";
            valido = false;
        }
        if (descripcionEvento.getText().isEmpty()) {
            error += "La descripción del evento no puede estar vacía.\n";
            instrucciones += "Ingrese una descripción para el evento.\n";
            valido = false;
        }
        if (fechaInicio.getValue() == null) {
            error += "La fecha de inicio del evento no puede estar vacía.\n";
            instrucciones += "Ingrese una fecha de inicio para el evento.\n";
            valido = false;
        }
        if (fechaFinalizacion.getValue() == null) {
            error += "La fecha de finalización del evento no puede estar vacía.\n";
            instrucciones += "Ingrese una fecha de finalización para el evento.\n";
            valido = false;
        }
        if (horaInicio.getValue() == null) {
            error += "La hora de inicio del evento no puede estar vacía.\n";
            instrucciones += "Ingrese una hora de inicio para el evento.\n";
            valido = false;
        }
        if (horaFin.getValue() == null) {
            error += "La hora de finalización del evento no puede estar vacía.\n";
            instrucciones += "Ingrese una hora de finalización para el evento.\n";
            valido = false;
        }
        if (minutoInicio.getValue() == null) {
            error += "Los minutos de inicio del evento no pueden estar vacíos.\n";
            instrucciones += "Ingrese los minutos de inicio para el evento.\n";
            valido = false;
        }
        if (minutoFin.getValue() == null) {
            error += "Los minutos de finalización del evento no pueden estar vacíos.\n";
            instrucciones += "Ingrese los minutos de finalización para el evento.\n";
            valido = false;
        }
        if (eventoPublico.isSelected() && precioEvento.getText().isEmpty()) {
            error += "El precio del evento no puede estar vacío.\n";
            instrucciones += "Ingrese un precio para el evento.\n";
            valido = false;
        }
        if (eventoPublico.isSelected() && !precioEvento.getText().isEmpty()) {
            try {
                Double.parseDouble(precioEvento.getText());
            } catch (NumberFormatException e) {
                error += "El precio del evento debe ser un número.\n";
                instrucciones += "Ingrese un precio válido para el evento.\n";
                valido = false;
            }
        }
        if (fechaFinalizacion.getValue().isBefore(fechaInicio.getValue())) {
            error += "La fecha de finalización no puede ser anterior a la fecha de inicio.\n";
            instrucciones += "Ingrese una fecha de finalización posterior a la fecha de inicio.\n";
            valido = false;
        }
        if (fechaFinalizacion.getValue().isEqual(fechaInicio.getValue())) {
            if (horaFin.getValue() < horaInicio.getValue()) {
                error += "La hora de finalización no puede ser anterior a la hora de inicio.\n";
                instrucciones += "Ingrese una hora de finalización posterior a la hora de inicio.\n";
                valido = false;
            }
            if (Objects.equals(horaFin.getValue(), horaInicio.getValue()) && minutoFin.getValue() <= minutoInicio.getValue()) {
                error += "La hora de finalización no puede ser anterior a la hora de inicio.\n";
                instrucciones += "Ingrese una hora de finalización posterior a la hora de inicio.\n";
                valido = false;
            }
        }

        if (!valido)
            mostrarMensajeError(error, instrucciones);

        return valido;
    }


    public void accionBotonVolver(ActionEvent actionEvent) {
        Sesion.setEventoEnDesarrollo(null);

        if ((Sesion.getNombrePantallaAnterior() != null && Sesion.getFXMLPantallaAnterior() != null) &&
                (!Objects.equals(Sesion.getNombrePantallaAnterior(), "") && !Objects.equals(Sesion.getFXMLPantallaAnterior(), "")))
            cargarPantalla(Sesion.getNombrePantallaAnterior(), Sesion.getFXMLPantallaAnterior());
        else
            cargarPantalla(NOMBRESPANTALLAS.INICIOSI, DIRECCIONESFXML.INICIOSI);
    }

    public void accionBotonSubirImagen(ActionEvent actionEvent) {
        System.out.println("Subir imagen");

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.jpeg"));

        Stage stage = (Stage) botonSubirImagen.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            try {
                String nuevaCarpeta = DIRECCIONESEXTRA.BASEDEDATOS + Sesion.getUsuarioActual().getCorreo() + CONSTANTES.SLASH; // Ruta de la nueva carpeta donde se guardará la imagen
                Path origen = selectedFile.toPath();

                String nuevoNombre = CONSTANTES.NOMBREIMAGENEVENTO + Sesion.getUsuarioActual().getEventosCreados() + CONSTANTES.PUNTOPNG; // Generar un nuevo nombre de archivo
                Path destino = Path.of(nuevaCarpeta, nuevoNombre);

                Files.createDirectories(Path.of(nuevaCarpeta));
                Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);

                direccionImagen = DIRECCIONESEXTRA.BASEDEDATOS + Sesion.getUsuarioActual().getCorreo() +
                        CONSTANTES.SLASH + CONSTANTES.NOMBREIMAGENEVENTO +
                        Sesion.getUsuarioActual().getEventosCreados() + CONSTANTES.PUNTOPNG;

                Path rutaAbsoluta = Path.of(System.getProperty("user.dir")).resolve(direccionImagen);
                String direccion = rutaAbsoluta.toUri().toURL().toString();

                System.out.println("Imagen copiada y guardada como: " + direccion);

                crearImagenPublicacion(direccion);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void crearImagenPublicacion(String direccionImagen) {
        imageViewEvento.setImage(new Image(direccionImagen));

        imageViewEvento.setFitWidth(400);
        imageViewEvento.setFitHeight(280);

        imageViewEvento.minWidth(400);
        imageViewEvento.minHeight(280);

        imageViewEvento.maxWidth(400);
        imageViewEvento.maxHeight(280);
    }

    public void accionSeleccionarProveedor(MouseEvent mouseEvent) {
    }

    public void setEventoEnDesarrollo(Evento evento) {
        this.eventoEnDesarrollo = evento;
    }

    private void estiloElementosListaPublicaciones() {
        IPersistenciaPublicaciones persistenciaPublicaciones = new PersistenciaPublicaciones();
        listaProveedores.getItems().clear();
        listaProveedores.getItems().addAll(persistenciaPublicaciones.obtenerPublicacionesDeEvento(publicacionesDeEvento));
        listaProveedores.setCellFactory(param -> new ListCell<>() {
            @Override
            protected void updateItem(Publicacion publicacion, boolean vacio) {
                super.updateItem(publicacion, vacio);
                if (vacio || publicacion == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setGraphic(generarContenedorHboxImpresion(publicacion));
                }
            }
        });
    }

    private HBox generarContenedorHboxImpresion(Publicacion publicacion) {
        Path rutaAbsoluta = Path.of(System.getProperty("user.dir")).resolve(publicacion.getDireccionImagen());
        String direccion = "";
        try {
            direccion = rutaAbsoluta.toUri().toURL().toString();
        } catch (MalformedURLException ignored) {
        }

        // añadimos los elementos al contenedor HBox
        HBox hbox = new HBox(generarContenedorDeImagen(new Image(direccion)), generarLabel(publicacion.getTitulo()));
        // le damos un espaciado de 15 entre los elementos
        hbox.setSpacing(15);
        // alineamos los elementos a la izquierda
        hbox.setAlignment(Pos.CENTER_LEFT);
        // le damos un estilo al contenedor
        hbox.setStyle("-fx-background-color: transparent; -fx-border-color: black; -fx-border-width: 0 0 1 0; -fx-padding: 5 0 5 0; -fx-cursor: hand;");

        return hbox;
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

    public void cargarEventoEnDesarrollo() {
        // Cargar los datos del evento en desarrollo
        if (eventoEnDesarrollo.getNombre() != null && !eventoEnDesarrollo.getNombre().isEmpty() && !Objects.equals(eventoEnDesarrollo.getNombre(), ""))
            nombreEvento.setText(eventoEnDesarrollo.getNombre());
        if (eventoEnDesarrollo.getDescripcion() != null && !eventoEnDesarrollo.getDescripcion().isEmpty() && !Objects.equals(eventoEnDesarrollo.getDescripcion(), ""))
            descripcionEvento.setText(eventoEnDesarrollo.getDescripcion());
        if (eventoEnDesarrollo.getFechaInicio() != null)
            fechaInicio.setValue(eventoEnDesarrollo.getFechaInicio());
        if (eventoEnDesarrollo.getFechaFin() != null)
            fechaFinalizacion.setValue(eventoEnDesarrollo.getFechaFin());
        if (eventoEnDesarrollo.getHoraInicio() != null)
            horaInicio.getValueFactory().setValue(eventoEnDesarrollo.getHoraInicio().getHour());
        if (eventoEnDesarrollo.getHoraFin() != null)
            minutoInicio.getValueFactory().setValue(eventoEnDesarrollo.getHoraInicio().getMinute());
        if (eventoEnDesarrollo.getHoraFin() != null)
            horaFin.getValueFactory().setValue(eventoEnDesarrollo.getHoraFin().getHour());
        if (eventoEnDesarrollo.getHoraFin() != null)
            minutoFin.getValueFactory().setValue(eventoEnDesarrollo.getHoraFin().getMinute());
        eventoPublico.setSelected(eventoEnDesarrollo.getEsPublico());
        precioEvento.setText(String.valueOf(eventoEnDesarrollo.getPrecioEntrada()));
        if (eventoEnDesarrollo.getDireccionImagen() != null && !eventoEnDesarrollo.getDireccionImagen().isEmpty() && !Objects.equals(eventoEnDesarrollo.getDireccionImagen(), ""))
            direccionImagen = eventoEnDesarrollo.getDireccionImagen();
        if (eventoEnDesarrollo.getPublicacionesDeEvento() != null)
            publicacionesDeEvento = eventoEnDesarrollo.getPublicacionesDeEvento();

        Path rutaAbsoluta = Path.of(System.getProperty("user.dir")).resolve(direccionImagen);
        String direccion = "";
        try {
            direccion = rutaAbsoluta.toUri().toURL().toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        crearImagenPublicacion(direccion);
        estiloElementosListaPublicaciones();
    }

    public void agregarProveedor(ActionEvent actionEvent) {
        eventoEnDesarrollo = new Evento();

        if (!nombreEvento.getText().isEmpty())
            eventoEnDesarrollo.setNombre(nombreEvento.getText());
        if (!descripcionEvento.getText().isEmpty())
            eventoEnDesarrollo.setDescripcion(descripcionEvento.getText());
        if (fechaInicio.getValue() != null)
            eventoEnDesarrollo.setFechaInicio(fechaInicio.getValue());
        if (fechaFinalizacion.getValue() != null)
            eventoEnDesarrollo.setFechaFin(fechaFinalizacion.getValue());
        if (horaInicio.getValue() != null && minutoInicio.getValue() != null && fechaInicio.getValue() != null)
            eventoEnDesarrollo.setHoraInicio(LocalDateTime.of(fechaInicio.getValue(), LocalTime.of(horaInicio.getValue(), minutoInicio.getValue())));
        if (horaFin.getValue() != null && minutoFin.getValue() != null && fechaFinalizacion.getValue() != null)
            eventoEnDesarrollo.setHoraFin(LocalDateTime.of(fechaFinalizacion.getValue(), LocalTime.of(horaFin.getValue(), minutoFin.getValue())));
        eventoEnDesarrollo.setEsPublico(eventoPublico.isSelected());
        if (!precioEvento.getText().isEmpty())
            eventoEnDesarrollo.setPrecioEntrada(Double.parseDouble(precioEvento.getText()));
        if (!direccionImagen.isEmpty())
            eventoEnDesarrollo.setDireccionImagen(direccionImagen);
        if (publicacionesDeEvento.size() > 0)
            eventoEnDesarrollo.setPublicacionesDeEvento(publicacionesDeEvento);

        eventoEnDesarrollo.setEstado("En desarrollo");
        Sesion.setEventoEnDesarrollo(eventoEnDesarrollo);
        cargarPantalla(NOMBRESPANTALLAS.INICIOMERCADO, DIRECCIONESFXML.INICIOMERCADO);
    }
}