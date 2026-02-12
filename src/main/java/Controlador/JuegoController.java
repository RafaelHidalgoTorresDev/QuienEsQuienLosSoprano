package Controlador;

import Modelo.Personaje;
import Modelo.Pregunta;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JuegoController implements Initializable {

    @FXML
    private GridPane tableroGrid;
    @FXML
    private ComboBox<Pregunta> comboPregunta;
    @FXML
    private Button botonPreguntar;
    @FXML
    private Label lblRespuesta;
    @FXML
    private Label lblPreguntas;
    @FXML
    private Label lblRestantes;
    @FXML
    private Button botonNuevaPartida;
    @FXML
    private Button botonAyuda;

    @FXML
    private StackPane rootPane;
    @FXML
    private StackPane overlayCelebracion;
    @FXML
    private ImageView imgCelebracion;
    @FXML
    private Label lblNombreCelebracion;
    @FXML
    private Label lblMensajeCelebracion;

    @FXML
    private StackPane overlayDerrota;
    @FXML
    private ImageView imgDerrota;
    @FXML
    private Label lblNombreDerrota;
    @FXML
    private Label lblMensajeDerrota;

    private MotorJuego motor;
    private List<StackPane> tarjetas;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        motor = new MotorJuego();
        tarjetas = new ArrayList<>();
        cargarPreguntas();
        crearTablero();
        actualizarContadores();
    }

    private void cargarPreguntas() {
        comboPregunta.getItems().clear();
        List<Pregunta> preguntas = motor.getPreguntas();
        for (Pregunta p : preguntas) {
            comboPregunta.getItems().add(p);
        }
        comboPregunta.setPromptText("Selecciona una pista...");
    }

    private void crearTablero() {
        tableroGrid.getChildren().clear();
        tarjetas.clear();
        tableroGrid.setHgap(10);
        tableroGrid.setVgap(10);
        tableroGrid.setPadding(new Insets(10));
        tableroGrid.setAlignment(Pos.CENTER);

        List<Personaje> personajes = motor.getPersonajes();

        for (int i = 0; i < personajes.size(); i++) {
            Personaje personaje = personajes.get(i);
            int fila = i / 6;
            int columna = i % 6;

            StackPane tarjeta = crearTarjeta(personaje);
            tarjetas.add(tarjeta);
            tableroGrid.add(tarjeta, columna, fila);
        }
    }

    private StackPane crearTarjeta(Personaje personaje) {
        StackPane tarjeta = new StackPane();
        tarjeta.setPrefSize(140, 180);
        tarjeta.setMaxSize(140, 180);
        tarjeta.getStyleClass().add("tarjeta-personaje");

        VBox contenido = new VBox(5);
        contenido.setAlignment(Pos.CENTER);
        contenido.setPadding(new Insets(8));

        StackPane contenedorImagen = new StackPane();
        contenedorImagen.setPrefSize(110, 110);
        contenedorImagen.setMaxSize(110, 110);

        boolean imagenCargada = false;
        try {
            String ruta = "/imagenes/" + personaje.getRutaImagen();
            if (getClass().getResource(ruta) != null) {
                Image img = new Image(getClass().getResourceAsStream(ruta));
                ImageView view = new ImageView(img);
                view.setFitWidth(100);
                view.setFitHeight(100);
                view.setPreserveRatio(true);
                view.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.3), 5, 0, 0, 0);");
                contenedorImagen.getChildren().add(view);
                imagenCargada = true;
            }
        } catch (Exception e) {
            imagenCargada = false;
        }

        if (!imagenCargada) {
            Rectangle fondo = new Rectangle(100, 100);
            String colorHex = obtenerColor(personaje.getNombre());
            fondo.setFill(Color.web(colorHex));
            fondo.setArcWidth(2);
            fondo.setArcHeight(2);

            String iniciales = obtenerIniciales(personaje.getNombre());
            Text txt = new Text(iniciales);
            txt.setFont(Font.font("Courier New", FontWeight.BOLD, 28));
            txt.setFill(Color.WHITE);

            contenedorImagen.getChildren().addAll(fondo, txt);
        }

        Label lblNombre = new Label(personaje.getNombre());
        lblNombre.getStyleClass().add("nombre-personaje");
        lblNombre.setWrapText(true);
        lblNombre.setAlignment(Pos.CENTER);
        lblNombre.setMaxWidth(135);

        contenido.getChildren().addAll(contenedorImagen, lblNombre);
        tarjeta.getChildren().add(contenido);

        tarjeta.setOnMouseClicked(e -> clickPersonaje(personaje));

        return tarjeta;
    }

    private String obtenerIniciales(String nombre) {
        String[] partes = nombre.split(" ");
        String iniciales = "";
        for (int i = 0; i < partes.length && i < 2; i++) {
            if (partes[i].length() > 0) {
                iniciales = iniciales + partes[i].charAt(0);
            }
        }
        return iniciales.toUpperCase();
    }

    private String obtenerColor(String nombre) {
        String[] colores = {
                "#3e2723", "#4e342e", "#5d4037", "#6d4c41",
                "#795548", "#8d6e63", "#a1887f", "#bcaaa4"
        };
        int indice = Math.abs(nombre.hashCode()) % colores.length;
        return colores[indice];
    }

    @FXML
    private void preguntar(MouseEvent event) {
        if (motor.isPartidaTerminada()) {
            mostrarAlerta("CASO CERRADO. Inicia una nueva investigación.");
            return;
        }

        Pregunta seleccionada = comboPregunta.getValue();
        if (seleccionada == null) {
            mostrarAlerta("Selecciona una pista del expediente antes de investigar.");
            return;
        }

        boolean respuesta = motor.hacerPregunta(seleccionada);

        if (respuesta) {
            lblRespuesta.setText("✅ CONFIRMADO - " + seleccionada.getTexto());
            lblRespuesta.setStyle("-fx-text-fill: #2e7d32; -fx-font-weight: bold; -fx-font-family: 'Courier New';");
        } else {
            lblRespuesta.setText("❌ NEGATIVO - " + seleccionada.getTexto());
            lblRespuesta.setStyle("-fx-text-fill: #c62828; -fx-font-weight: bold; -fx-font-family: 'Courier New';");
        }

        actualizarTablero();
        actualizarContadores();
        comboPregunta.setValue(null);
        comboPregunta.setPromptText("Selecciona otra pista...");
    }

    private void actualizarTablero() {
        List<Personaje> personajes = motor.getPersonajes();
        for (int i = 0; i < personajes.size(); i++) {
            Personaje p = personajes.get(i);
            StackPane tarjeta = tarjetas.get(i);

            if (p.isEliminado()) {
                if (!tarjeta.getStyleClass().contains("tarjeta-eliminada")) {
                    tarjeta.getStyleClass().add("tarjeta-eliminada");
                }
            } else {
                tarjeta.getStyleClass().remove("tarjeta-eliminada");
            }
        }
    }

    private void actualizarContadores() {
        lblPreguntas.setText("Pistas usadas: " + motor.getNumeroPreguntasHechas());
        lblRestantes.setText("Sospechosos: " + motor.contarPersonajesRestantes());
    }

    private void clickPersonaje(Personaje personaje) {
        if (motor.isPartidaTerminada()) {
            mostrarAlerta("CASO CERRADO. Inicia una nueva investigación.");
            return;
        }

        if (personaje.isEliminado()) {
            mostrarAlerta("Este sospechoso ya ha sido descartado.");
            return;
        }

        Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacion.setTitle("ACUSACIÓN FINAL");
        confirmacion.setHeaderText("¿Estás seguro de que quieres acusar a...");
        confirmacion.setContentText(personaje.getNombre() + "?");
        confirmacion.showAndWait();

        if (confirmacion.getResult() == ButtonType.OK) {
            boolean acierto = motor.adivinar(personaje);
            if (acierto) {
                mostrarCelebracion(personaje);
            } else {
                mostrarResultado(false, personaje);
            }
        }
    }

    private void mostrarCelebracion(Personaje personaje) {
        overlayCelebracion.setVisible(true);
        lblNombreCelebracion.setText(personaje.getNombre().toUpperCase());

        try {
            String ruta = "/imagenes/" + personaje.getRutaImagen();
            if (getClass().getResource(ruta) != null) {
                imgCelebracion.setImage(new Image(getClass().getResourceAsStream(ruta)));
            }
        } catch (Exception e) {
            // Ignorar si no carga
        }

        String msg = "¡Has atrapado al culpable!\n\n"
                + "Pistas usadas: " + motor.getNumeroPreguntasHechas() + "\n";

        lblMensajeCelebracion.setText(msg);
    }

    @FXML
    private void cerrarCelebracion(MouseEvent event) {
        overlayCelebracion.setVisible(false);
        btnNuevaPartida(null);
    }

    @FXML
    private void cerrarDerrota(MouseEvent event) {
        overlayDerrota.setVisible(false);
        btnNuevaPartida(null);
    }

    private void btnNuevaPartida(MouseEvent event) {
        nuevaPartida(event);
    }

    private void mostrarResultado(boolean victoria, Personaje elegido) {
        Personaje culpable = motor.getPersonajeSecreto();
        overlayDerrota.setVisible(true);
        lblNombreDerrota.setText(culpable.getNombre().toUpperCase());

        try {
            String ruta = "/imagenes/" + culpable.getRutaImagen();
            if (getClass().getResource(ruta) != null) {
                imgDerrota.setImage(new Image(getClass().getResourceAsStream(ruta)));
            }
        } catch (Exception e) {
            // Ignorar si no carga
        }

        String msg = "Has acusado a: " + elegido.getNombre() + "\n"
                + "El verdadero culpable era: " + culpable.getNombre() + "\n\n"
                + "Pistas usadas: " + motor.getNumeroPreguntasHechas() + "\n"
                + "¡El criminal ha escapado!";
        lblMensajeDerrota.setText(msg);
    }

    @FXML
    private void nuevaPartida(MouseEvent event) {
        motor.iniciarNuevaPartida();
        overlayCelebracion.setVisible(false);
        overlayDerrota.setVisible(false);
        lblRespuesta.setText("Interroga a un sospechoso o selecciona una pista...");
        lblRespuesta.setStyle("-fx-text-fill: #3e2723; -fx-font-family: 'Courier New';");
        cargarPreguntas();
        crearTablero();
        actualizarContadores();
    }

    @FXML
    private void abrirAyuda(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Vista/Ayuda.fxml"));
            Parent root = loader.load();

            Stage ventana = new Stage();
            ventana.setTitle("Expediente de Ayuda");
            ventana.initModality(Modality.APPLICATION_MODAL);

            Scene scene = new Scene(root, 650, 550);
            scene.getStylesheets().add(getClass().getResource("/Vista/estiloJuego.css").toExternalForm());

            ventana.setScene(scene);
            ventana.setResizable(false);
            ventana.showAndWait();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Información del Caso");
        alert.setContentText(msg);
        alert.show();
    }
}
