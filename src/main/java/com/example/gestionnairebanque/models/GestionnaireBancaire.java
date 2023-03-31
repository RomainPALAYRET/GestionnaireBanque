/*
 * Application Gestionnaire d'un compte bancaire                                                              31/03/2023
 * TP Java Avancé : TP noté Gestion d'un compte bancaire
 * 3il Ingenieur Rodez
 */
package com.example.gestionnairebanque.models;

import java.io.*;
import java.util.ArrayList;
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

    private List<Transaction> transactions;



    List<Taux> listTaux;
    double solde;

    /**
     * Récupère une liste des transactions depuis un fichier binaire
     * Récupère la liste des taux depuis le fichier taux.txt
     * A la création du compte, le solde est de 0.00€
     */
    public GestionnaireBancaire() throws Exception {
        if(!(new File("src/main/resources/Data/taux.txt").exists())) {
            throw new Exception("Fichier taux.txt introuvable");
        }
        this.solde = 0.00;
        this.listTaux = lireFichierTaux("src/main/resources/Data/taux.txt");
        this.transactions = recupererTransactions("src/main/resources/Data/SaveList.bin");

        for(Transaction transaction: transactions) {
            if(transaction.getType() == Type.CREDIT) {
                solde += transaction.getMontant();
            } else {
                solde -= transaction.getMontant();
            }
        }

    }

    /**
     * Convertis les taux du fichier pris en argument en une liste de Taux
     * @param cheminFichier le chemin du fichier txt contenant les différents taux;
     * @return
     */
    public static List<Taux> lireFichierTaux(String cheminFichier) {

        List<Taux> tauxList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(cheminFichier))) {

            String line;
            while ((line = br.readLine()) != null) {
                String[] tauxInfos = line.split(" ");
                String nomTaux = tauxInfos[0];
                double borneMin = Double.parseDouble(tauxInfos[1]);
                double borneMax = Double.parseDouble(tauxInfos[2]);
                double taux = Double.parseDouble(tauxInfos[3]);
                Taux t = new Taux(nomTaux, borneMin, borneMax, taux);
                tauxList.add(t);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return tauxList;
    }

    /**
     * Sauvegarde les transactions éffectuées dans le fichier Data/SaveList.bin
     */
    public void sauvegarderTransactions() {

        try (FileOutputStream fos = new FileOutputStream("src/main/resources/Data/SaveList.bin");
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            oos.writeObject(this.transactions);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Récupère une liste de Transactions depuis un fichier binaire
     * @param cheminFichier le chemin du fichier où sont sauvegardées les transactions
     * @return
     */
    public List<Transaction> recupererTransactions(String cheminFichier) {

        try (FileInputStream fis = new FileInputStream(cheminFichier);
             ObjectInputStream ois = new ObjectInputStream(fis)) {

            List<Transaction> transactions = (List<Transaction>) ois.readObject();

            return transactions;

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * @return le solde du compte
     */
    public double getSolde() {
        return solde;
    }

    /**
     * @return les transactions éffectuées
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }

    /**
     * ajoute une nouvelle transaction à la liste transactions
     */
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        if(transaction.getType() == Type.CREDIT) {
            solde += transaction.getMontant();
        } else {
            solde -= transaction.getMontant();
        }
    }

    /**
     * @return la liste des taux
     */
    public List<Taux> getListTaux() {
        return listTaux;
    }

}
