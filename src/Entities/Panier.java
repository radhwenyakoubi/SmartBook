/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author Hedi
 */
public class Panier {
    private int id;
    private double totale;
    private Lecteur lecteur;

    public Panier() {
    }

    public Panier(int id, double totale, Lecteur lecteur) {
        this.id = id;
        this.totale = totale;
        this.lecteur = lecteur;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public Lecteur getLecteur() {
        return lecteur;
    }

    public void setLecteur(Lecteur lecteur) {
        this.lecteur = lecteur;
    }
   
    
    
    
    
    
}
