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
public class Utilisateur {
    protected int id;
    protected int cin;
    protected String nom;
    protected String prenom;
    protected String sexe;
    protected String adresse;
    protected String mail;
    protected Date dateNaissance;
    protected String login;
    protected String mot_de_passe;
    
    public Utilisateur()
    {}

    public Utilisateur(int id, int cin, String nom, String prenom, String sexe, String adresse, String mail, Date date_naissance, String login, String mot_de_passe) {
        this.id = id;
        this.cin = cin;
        this.nom = nom;
        this.prenom = prenom;
        this.sexe = sexe;
        this.adresse = adresse;
        this.mail = mail;
        this.dateNaissance = date_naissance;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getDate_naissance() {
        return dateNaissance;
    }

    public void getDate_naissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", sexe=" + sexe + ", adresse=" + adresse + ", mail=" + mail + ", dateNaissance=" + dateNaissance + ", login=" + login + ", mot_de_passe=" + mot_de_passe + '}';
    }
    
    
}
