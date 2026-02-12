package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AyudaController implements Initializable {

    @FXML
    private Button botonCerrar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void cerrarAyuda(MouseEvent event) {
        Stage ventana = (Stage) botonCerrar.getScene().getWindow();
        ventana.close();
    }
}
