/*
 * Application Gestionnaire d'un compte bancaire                                                              31/03/2023
 * TP Java Avancé : TP noté Gestion d'un compte bancaire
 * 3il Ingenieur Rodez
 */
package com.example.gestionnairebanque.models;

/**
 * Un taux est caratérisé par 2 seuils (inf et sup), un taux à appliquer et un nom;
 * Cette classe a été développée en TDD
 * @author Romain PALAYRET
 * @version 1.0.0
 */
public class Taux {
    private double seuilInf;
    private double seuilSup;
    private double taux;
    private String nom;

    /**
     * @param nom du taux
     * @param seuilInf seuil inférieur de l'application du taux
     * @param seuilSup seuil supérieur de l'application du taux
     * @param taux à appliquer entre les bornes
     */
    public Taux(String nom, double seuilInf, double seuilSup, double taux ) {

        if(seuilInf > seuilSup) {
            throw new IllegalArgumentException("Le seuilInf doit être plus petit que le seuilSup");
        }

        if(taux < 0.00) {
            throw new IllegalArgumentException("un taux ne peut pas être négatif");
        }

        if(taux > 1.00) {
            throw new IllegalArgumentException("un taux ne peut pas être supérieur à 100%");
        }

        if(nom == null) {
            throw new IllegalArgumentException("le nom du taux ne doit pas être null");
        }

        if(nom.isEmpty()) {
            throw new IllegalArgumentException("le nom du taux ne doit pas être vide");
        }

        this.seuilInf = seuilInf;
        this.seuilSup = seuilSup;
        this.taux = taux;
        this.nom = nom;
    }

    /**
     * @return le seuil inférieur de l'applicaion du taux
     */
    public double getSeuilInf() {
        return seuilInf;
    }

    /**
     * @return le seuil supérieur de l'applicaion du taux
     */
    public double getSeuilSup() {
        return seuilSup;
    }

    /**
     * @return le taux à appliquer entre les bornes
     */
    public double getTaux() {
        return taux;
    }

    /**
     * @return le nom du taux
     */
    public String getNom() {
        return nom;
    }
}
