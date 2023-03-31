/*
 * Application Gestionnaire d'un compte bancaire                                                              31/03/2023
 * TP Java Avancé : TP noté Gestion d'un compte bancaire
 * 3il Ingenieur Rodez
 */
package com.example.gestionnairebanque.models.tests;

import com.example.gestionnairebanque.models.Taux;
import com.example.gestionnairebanque.models.Transaction;
import com.example.gestionnairebanque.models.Type;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Junit de la classe Taux
 * @author Romain PALAYRET
 * @version 1.0.0
 */
public class TauxTest {

    @Test
    public void testConstructeur() {
        assertThrows(IllegalArgumentException.class, () -> {
            Taux t = new Taux("TVA", 30, 20, 0.60);
        });
    }
}