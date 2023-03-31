/*
 * Application Gestionnaire d'un compte bancaire                                                              31/03/2023
 * TP Java Avancé : TP noté Gestion d'un compte bancaire
 * 3il Ingenieur Rodez
 */
package com.example.gestionnairebanque.models.tests;


import com.example.gestionnairebanque.models.GestionnaireBancaire;
import com.example.gestionnairebanque.models.Transaction;
import com.example.gestionnairebanque.models.Type;
import org.junit.Test;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Test Junit de la classe GestionnaireBancaire
 * @author Romain PALAYRET
 * @version 1.0.0
 */
public class GestionnaireBancaireTest {
    @Test
    public void testConstructeur() {
        GestionnaireBancaire gest = new GestionnaireBancaire();
        assertEquals(gest.getSolde(), 0.00, 0.01);
    }

    @Test
    public void testConstructeur2() {
        GestionnaireBancaire gest = new GestionnaireBancaire();
        assertEquals(gest.getListTaux().get(0).getNom(), "niveau1");
    }

    @Test
    public void testConstructeur3() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        transactions.add(new Transaction("salaire", Type.CREDIT, 680.00));
        transactions.add(new Transaction("Paypal", Type.DEBIT, 35.56));

        try (FileOutputStream fos = new FileOutputStream("src/main/resources/Data/SaveList.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(transactions);

        } catch (IOException e) {
            e.printStackTrace();
        }

        GestionnaireBancaire gest = new GestionnaireBancaire();
        assertEquals(gest.getTransactions().get(0).getNom(), "salaire");
    }
}
