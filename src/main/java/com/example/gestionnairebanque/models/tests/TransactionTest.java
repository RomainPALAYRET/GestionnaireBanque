/*
 * Application Gestionnaire d'un compte bancaire                                                              31/03/2023
 * TP Java Avancé : TP noté Gestion d'un compte bancaire
 * 3il Ingenieur Rodez
 */
package com.example.gestionnairebanque.models.tests;

import com.example.gestionnairebanque.models.Transaction;
import com.example.gestionnairebanque.models.Type;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Test Junit de la classe Transaction
 * @author Romain PALAYRET
 * @version 1.0.0
 */
public class TransactionTest {

    @Test
    public void testConstructeur() {
        Transaction t = new Transaction("T1", Type.CREDIT, 17.00);
    }

    @Test
    public void testConstructeur2() {
        assertThrows(IllegalArgumentException.class, () -> {
            Transaction t = new Transaction(null, Type.CREDIT, 17.00);
        });
    }

    @Test
    public void testConstructeur3() {
        assertThrows(IllegalArgumentException.class, () -> {
            Transaction t = new Transaction("", Type.CREDIT, 17.00);
        });
    }

    @Test
    public void testConstructeur4() {
        Transaction t = new Transaction("T1", Type.CREDIT, 17.00);
        assertEquals(t.getNom(), "T1");
    }

    @Test
    public void testConstructeur5() {
        Transaction t = new Transaction("T1", Type.CREDIT, 17.00);
        assertEquals(t.getType(), Type.CREDIT);
    }

    @Test
    public void testConstructeur6() {
        Transaction t = new Transaction("T1", Type.CREDIT, 17.00);
        assertEquals(t.getMontant(), 17.00, 0.01);
    }


}
