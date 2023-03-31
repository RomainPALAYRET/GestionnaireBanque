package com.example.gestionnairebanque;

import com.example.gestionnairebanque.models.GestionnaireBancaire;
import com.example.gestionnairebanque.models.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
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
    @FXML
    private ListView<Transaction> transactionListView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            gest = new GestionnaireBancaire();

            // créer une liste observable à partir de la liste d'objets
            ObservableList<Transaction> observableTransaction = FXCollections.observableArrayList(gest.getTransactions());
            // affecter la liste observable à la propriété items du ListView
            transactionListView.setItems(observableTransaction);

            soldeLabel.setText(String.format("%.2f", gest.getSolde()));

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}