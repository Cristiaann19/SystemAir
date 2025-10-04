package FormsLogic;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import javafx.util.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class formSystemAirP {
    @FXML private Button CloseWindow;
    @FXML private Button MinimizeWindow;
    @FXML private Button btnLogout;
    @FXML private AnchorPane anchorPaneMain;
    @FXML private Label LblReloj;

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
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Forms/MainFiles/Login.fxml"));
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
        iniciarReloj();
    }

    //METODO PARA EL RELOJ
    private void iniciarReloj(){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), e -> {
                    String hora = LocalTime.now().format(formato);
                    LblReloj.setText(hora);
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }


    //CARGA DE LOS FORMULARIOS
    @FXML
    private void formularioBienvenida() throws IOException{
        cargarFormulario("/Forms/MainFiles/Welcome.fxml");
    }

    //METODOS PARA CARGAR LOS PANELES DE GESTION
    @FXML
    private void CPassenger() throws IOException{
        cargarFormulario("/Forms/Management/MPassenger.fxml");
    }
    @FXML
    private void CPilots() throws IOException{
        cargarFormulario("/Forms/Management/MPilots.fxml");
    }

    @FXML
    private void CReports() throws IOException{
        cargarFormulario("/Forms/Reports/Report.fxml");
    }

    @FXML
    private void CEmployee()throws IOException{
        cargarFormulario("/Forms/Management/MEmployee.fxml");
    }

}