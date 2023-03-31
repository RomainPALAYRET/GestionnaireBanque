/*
 * Application Gestionnaire d'un compte bancaire                                                              31/03/2023
 * TP Java Avancé : TP noté Gestion d'un compte bancaire
 * 3il Ingenieur Rodez
 */
package com.example.gestionnairebanque.models;

import java.io.Serializable;

/**
 * Une transaction se caractérise par son nom, son type (crédit ou débit) et son montant
 * Cette classe a été développé en TDD
 * @author Romain PALAYRET
 * @version 1.0.0
 */
public class Transaction implements Serializable {



    String nom;

    Type type;

    /**
     *
     * @param nom de la transaction
     * @param type (Type.CREDIT ou Type.DEBIT) de la transaction
     * @param montant de la transaction
     */
    public Transaction(String nom, Type type, double montant) {
        if(nom == null) {
            throw new IllegalArgumentException("le nom de la transaction ne doit pas être null");
        }

        if(nom.isEmpty()) {
            throw new IllegalArgumentException("le nom de la transaction ne doit pas être null");
        }

        this.nom = nom;
        this.type = type;

    }

    /**
     * @return le nom de la transaction
     */
    public String getNom() {
        return nom;
    }

    /**
     * @return le type de la transaction (Credit ou Debit)
     */
    public Type getType() {
        return type;
    }

}
