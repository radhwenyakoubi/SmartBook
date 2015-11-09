/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author Radhwen
 */
public class ReclamationLib {
    private String description;
    private Date datereclamation;
    private Lecteur lecteur;
    private Libraire libraire;
    public ReclamationLib() {
    }
   
    public ReclamationLib(String description, Date datereclamation) {
        this.description = description;
        this.datereclamation = datereclamation;
    }

    public ReclamationLib(String description, Date datereclamation, Lecteur lecteur, Libraire libraire) {
        this.description = description;
        this.datereclamation = datereclamation;
        this.lecteur = lecteur;
        this.libraire = libraire;
    }

    public String getDescription() {
        return description;
    }

    public Date getDatereclamation() {
        return datereclamation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatereclamation(Date datereclamation) {
        this.datereclamation = datereclamation;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public Libraire getLibraire() {
        return libraire;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }

    public void setLibraire(Libraire libraire) {
        this.libraire = libraire;
    }
    
    
    
}
