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
public class Lecteur{
    private int id;
 private   String nom;
  private  String prenom;
   private int cin;
   private String sexe;
   private String adresse;
   private String mail;
   private Date Date_naissance;
   private int telephone;
   private String login;
   private String mot_de_passe;
  private String status;

    public Lecteur(int id, String nom, String prenom, int cin, String sexe, String adresse, String mail, Date getDate_naissance, int telephone, String login, String mot_de_passe, String status) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.sexe = sexe;
        this.adresse = adresse;
        this.mail = mail;
        this.Date_naissance = getDate_naissance;
        this.telephone = telephone;
        this.login = login;
        this.mot_de_passe = mot_de_passe;
        this.status = status;
    }

    

    public Lecteur() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getCin() {
        return cin;
    }

    public String getSexe() {
        return sexe;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public Date getDate_naissance() {
        return Date_naissance;
    }

    public int getTelephone() {
        return telephone;
    }

    public String getLogin() {
        return login;
    }

    public String getMot_de_passe() {
        return mot_de_passe;
    }

    public String getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setDate_naissance(Date Date_naissance) {
        this.Date_naissance = Date_naissance;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Lecteur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", sexe=" + sexe + ", adresse=" + adresse + ", mail=" + mail + ", getDate_naissance=" + Date_naissance + ", telephone=" + telephone + ", login=" + login + ", mot_de_passe=" + mot_de_passe + ", status=" + status + '}';
    }
    

   
  
}
