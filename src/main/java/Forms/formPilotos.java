package Forms;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class formPilotos {

    @FXML
    private AnchorPane anchorPaneMain;

    public void CargarFormulario(String rutaFXML) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(rutaFXML));
        loader.setController(this); // Solo si lo instancias manualmente
        Parent root = loader.load();
        anchorPaneMain.getChildren().setAll(root);
        anchorPaneMain.setTopAnchor(root, 0.0);
        anchorPaneMain.setBottomAnchor(root, 0.0);
        anchorPaneMain.setLeftAnchor(root, 0.0);
        anchorPaneMain.setRightAnchor(root, 0.0);
    }

    @FXML
    private void MGestionPasajeros() throws  IOException{
        CargarFormulario("/Formularios/Gestion/GestionPasajeros.fxml");
    }
    @FXML
    private void MGestionPilotos() throws  IOException{
        CargarFormulario("/Formularios/Gestion/GestionPilotos.fxml");
    }



}
