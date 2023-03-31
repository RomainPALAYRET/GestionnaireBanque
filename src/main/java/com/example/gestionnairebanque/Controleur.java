package com.example.gestionnairebanque;

import com.example.gestionnairebanque.models.GestionnaireBancaire;
import com.example.gestionnairebanque.models.Transaction;
import com.example.gestionnairebanque.models.Type;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;

import java.io.File;
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
    @FXML
    private ListView<Transaction> transactionListView;

    @FXML
    private ChoiceBox<Type> DebCredChoiceBox;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            gest = new GestionnaireBancaire();

            actualiser();

            DebCredChoiceBox.getItems().setAll(Type.values());
            DebCredChoiceBox.setValue(Type.CREDIT);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @FXML
    private void EnregistrerButtonClick() {

        boolean erreurSaisie = false;
        double montant = 0;
        String nom;
        Type type;

        // on récupère les valeurs, en vérifiant que les saisies soient corrects
        type = DebCredChoiceBox.getValue();
        nom = nomField.getText();
        if(nom == null|| nom.isEmpty()) {erreurSaisie = true;}
        try {
            montant = Double.parseDouble(montantField.getText());
            if(montant < 0) {
                erreurSaisie = true;
            }
        } catch (Exception e) {
            erreurSaisie = true;
        }

        if(!erreurSaisie) {

            // on ajoute la transaction
            gest.addTransaction(new Transaction(nom, type,montant));

            // on actualise l'affichage
            actualiser();
        }

        // on vide les TextField
        nomField.setText("");
        montantField.setText("");

    }

    private void actualiser() {
        soldeLabel.setText(String.format("%.2f", gest.getSolde()));
        if(gest.getSolde() < 0) {
            soldeLabel.setStyle("-fx-text-fill: red;");
        } else {
            soldeLabel.setStyle("-fx-text-fill: green;");
        }
        ObservableList<Transaction> observableTransaction = FXCollections.observableArrayList(gest.getTransactions());
        transactionListView.setItems(observableTransaction);
    }
}