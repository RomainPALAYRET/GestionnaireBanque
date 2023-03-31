package com.example.gestionnairebanque.models.tests;

import com.example.gestionnairebanque.models.Transaction;
import com.example.gestionnairebanque.models.Type;
import org.junit.Test;
import static org.junit.Assert.*;

public class TransactionTest {

    @Test
    public void testConstructeur() {
        Transaction t = new Transaction("T1", Type.CREDIT, 17.00);
    }

}
