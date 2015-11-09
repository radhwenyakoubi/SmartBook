/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;

/**
 *
 * @author Hedi
 */
public class Livre {
 private int id;
 private String titre;
 private String nom_auteur;
 private Date date_edition;
 private String maison_edition;
 private String theme;
 private double prix;
 private String description;
 private int quantitie;

    public Livre() {
    }

    public Livre(int id, String titre, String nom_auteur, Date date_edition, String maison_edition, String theme, double prix, String description, int quantitie) {
        this.id = id;
        this.titre = titre;
        this.nom_auteur = nom_auteur;
        this.date_edition = date_edition;
        this.maison_edition = maison_edition;
        this.theme = theme;
        this.prix = prix;
        this.description = description;
        this.quantitie = quantitie;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getNom_auteur() {
        return nom_auteur;
    }

    public void setNom_auteur(String nom_auteur) {
        this.nom_auteur = nom_auteur;
    }

    public Date getDate_edition() {
        return date_edition;
    }

    public void setDate_edition(Date date_edition) {
        this.date_edition = date_edition;
    }

    public String getMaison_edition() {
        return maison_edition;
    }

    public void setMaison_edition(String maison_edition) {
        this.maison_edition = maison_edition;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQuantitie() {
        return quantitie;
    }

    public void setQuantitie(int quantitie) {
        this.quantitie = quantitie;
    }
 
 
 
 
 
}
