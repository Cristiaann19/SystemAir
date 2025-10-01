package Forms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class formSystemAirP {
    @FXML private Button CloseWindow;
    @FXML private Button MinimizeWindow;
    @FXML private Button btnLogout;
    @FXML private AnchorPane anchorPaneMain;


    //PARA CERRAR LA VENTANA
    @FXML
    private void CloserWindow(ActionEvent event){
        Stage stage = (Stage) CloseWindow.getScene().getWindow();
        stage.close();
    }

    //PARA MINIMIZAR LA VENTANA
    @FXML
    private void Minimizer(ActionEvent event){
        Stage stage = (Stage) MinimizeWindow.getScene().getWindow();
        stage.setIconified(true);
    }

    //PARA CERRAR LA SESION
    @FXML
    private void Logout(){
        Stage stageAactual = (Stage) btnLogout.getScene().getWindow();
        stageAactual.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Formularios/Principales/Login.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stageAactual.setScene(scene);
            stageAactual.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //PARA INICIAR EL FORMULARIO
    private void cargarFormulario(String rutaFXML) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
        Parent root = loader.load();
        anchorPaneMain.getChildren().setAll(root);
        anchorPaneMain.setTopAnchor(root, 0.0);
        anchorPaneMain.setBottomAnchor(root, 0.0);
        anchorPaneMain.setLeftAnchor(root, 0.0);
        anchorPaneMain.setRightAnchor(root, 0.0);
    }

    @FXML
    private void initialize() throws IOException{
        formularioBienvenida();
    }

    //CARGA DE LOS FORMULARIOS
    @FXML
    private void formularioBienvenida() throws IOException{
        cargarFormulario("/Formularios/Principales/Welcome.fxml");
    }

    //METODOS PARA CARGAR LOS PANELES DE GESTION
    @FXML
    private void CGestionPasajeros() throws IOException{
        cargarFormulario("/Formularios/Gestion/GestionPasajeros.fxml");
    }
    @FXML
    private void CGestionPilotos() throws IOException{
        cargarFormulario("/Formularios/Gestion/GestionPilotos.fxml");
    }

}