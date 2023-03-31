/*
 * Application Gestionnaire d'un compte bancaire                                                              31/03/2023
 * TP Java Avancé : TP noté Gestion d'un compte bancaire
 * 3il Ingenieur Rodez
 */
package com.example.gestionnairebanque.models;

import java.util.List;

/**
 * Classe principale du modèle, possédant :
 *                                   - un solde
 *                                   - une liste des transactions effectuées
 *                                   - une liste des taux à appliquer
 * Cette classe a été développée en TDD
 * @author Romain PALAYRET
 * @version 1.0.0
 */
public class GestionnaireBancaire {

    List<Transaction> transactions;
    List<Taux> listTaux;
    double solde;

    /**
     * Récupère une liste des transactions depuis un fichier binaire
     * Récupère la liste des taux depuis le fichier taux.txt
     * A la création du compte, le solde est de 0.00€
     */
    public GestionnaireBancaire() {
        this.solde = 0.00;
    }

    /**
     * @return le solde du compte
     */
    public double getSolde() {
        return solde;
    }

}
