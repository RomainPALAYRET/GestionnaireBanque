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

    private String nom;
    private Type type;

    private double montant;


    /**
     * @param nom de la transaction
     * @param type (Type.CREDIT ou Type.DEBIT) de la transaction
     * @param montant de la transaction
     */
    public Transaction(String nom, Type type, double montant) {
        if(nom == null) {
            throw new IllegalArgumentException("le nom de la transaction ne doit pas être null");
        }

        if(nom.isEmpty()) {
            throw new IllegalArgumentException("le nom de la transaction ne doit pas être vide");
        }

        this.nom = nom;
        this.type = type;
        this.montant = montant;

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

    /**
     * @return le montant de la transaction
     */
    public double getMontant() {
        return montant;
    }

    /**
     * @param montant le nouveau montant
     */
    public void setMontant(double montant) {
        this.montant = montant;
    }


    @Override
    public String toString() {
        String operateur = "";
        if(this.getType() == Type.DEBIT) {
            operateur = "-";
        }
        return this.nom + " " + operateur + String.format("%.2f", this.montant);
    }

}
