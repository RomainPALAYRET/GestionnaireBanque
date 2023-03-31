/*
 * Application Gestionnaire d'un compte bancaire                                                              31/03/2023
 * TP Java Avancé : TP noté Gestion d'un compte bancaire
 * 3il Ingenieur Rodez
 */
package com.example.gestionnairebanque.models.tests;


import com.example.gestionnairebanque.models.GestionnaireBancaire;
import org.junit.Test;

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
}
