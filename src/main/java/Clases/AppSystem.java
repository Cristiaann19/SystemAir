package Clases;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AppSystem extends Application {
    private double x = 0;
    private double y = 0;

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Formularios/Principales/Login.fxml"));

        Scene scene = new Scene(root);
        root.setOnMousePressed((MouseEvent event) -> {
           x = event.getSceneX();
           y = event.getSceneY();
        });

        root.setOnMousePressed((MouseEvent event)->{
            primaryStage.setX(event.getSceneX()-x);
            primaryStage.setX(event.getSceneY()-y);
            primaryStage.setOpacity(0.8);
        });

        root.setOnMousePressed((MouseEvent event)->{
            primaryStage.setOpacity(1);
        });

        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.show();

    }



}
