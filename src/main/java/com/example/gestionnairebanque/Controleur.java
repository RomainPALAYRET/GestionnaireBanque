package com.example.gestionnairebanque;

import com.example.gestionnairebanque.models.GestionnaireBancaire;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {

    private GestionnaireBancaire gest;

    @FXML
    private TextField nomField;

    @FXML
    private TextField montantField;

    @FXML
    private Label soldeLabel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            gest = new GestionnaireBancaire();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}