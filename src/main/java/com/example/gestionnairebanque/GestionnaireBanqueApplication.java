package com.example.gestionnairebanque;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class GestionnaireBanqueApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GestionnaireBanqueApplication.class.getResource("IHM.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 200);
        stage.setResizable(false);
        stage.setTitle("Gestion Bancaire");
        stage.getIcons().add(new Image("file:../../src/main/resources/images/3il-icon.png"));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}