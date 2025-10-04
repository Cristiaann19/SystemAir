package FormsLogic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class formLogin {

    @FXML
    private Button CloseWindow;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button btnLogin;

    //PARA CERRAR LA VENTANA
    @FXML
    private void CloserWindow(ActionEvent event){
        Stage stage = (Stage) CloseWindow.getScene().getWindow();
        stage.close();
    }

    //PARA CAMBIAR DE GUI (LOGIN A LA PRINCIPAL)
    @FXML
    private void Login(ActionEvent event) {
        Stage stageAactual = (Stage) btnLogin.getScene().getWindow();
        stageAactual.close();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Forms/MainFiles/MainMenu.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stageAactual.setScene(scene);
            stageAactual.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
