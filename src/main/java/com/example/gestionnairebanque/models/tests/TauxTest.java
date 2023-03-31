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

    @Test
    public void testConstructeur2() {
        assertThrows(IllegalArgumentException.class, () -> {
            Taux t = new Taux("TVA", 20, 30, -0.5);
        });
    }

    @Test
    public void testConstructeur3() {
        assertThrows(IllegalArgumentException.class, () -> {
            Taux t = new Taux("TVA", 20, 30, 1.2);
        });
    }

    @Test
    public void testConstructeur4() {
        assertThrows(IllegalArgumentException.class, () -> {
            Taux t = new Taux("", 20, 30, 0.05);
        });
    }

    @Test
    public void testConstructeur5() {
        assertThrows(IllegalArgumentException.class, () -> {
            Taux t = new Taux(null, 20, 30, 0.05);
        });
    }
}
