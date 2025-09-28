package Forms;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class formSystemAirP {
    @FXML
    private Button CloseWindow;
    @FXML
    private Button MinimizeWindow;
    @FXML
    private Button btnLogout;

    //PARA CERRAR LA VENTANA
    @FXML
    private void CloserWindow(ActionEvent event){
        Stage stage = (Stage) CloseWindow.getScene().getWindow();
        stage.close();
    }

    //PARA MINIMI LA VENTANA
    @FXML
    private void Minimizer(ActionEvent event){
        Stage stage = (Stage) MinimizeWindow.getScene().getWindow();
        stage.close();
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

    //PARA ALTENAR LOS CAMBIOS DE PANTALLA POR BOTON()
    //public void
}