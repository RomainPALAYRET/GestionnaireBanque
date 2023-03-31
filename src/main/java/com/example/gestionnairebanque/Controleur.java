package com.example.gestionnairebanque;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controleur {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}