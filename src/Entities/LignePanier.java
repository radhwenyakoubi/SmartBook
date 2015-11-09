/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author Radhwen
 */
public class LignePanier {
    private Panier panier;
    private Livre livre;
    private int quantitelp;
    private double prixlp;

    public LignePanier() {
    }

    public LignePanier(Panier panier, Livre livre, int quantitelp, float prixlp) {
        this.panier = panier;
        this.livre = livre;
        this.quantitelp = quantitelp;
        this.prixlp = prixlp;
    }

    public Panier getPanier() {
        return panier;
    }

    public void setPanier(Panier panier) {
        this.panier = panier;
    }

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }

    public int getQuantitelp() {
        return quantitelp;
    }

    public void setQuantitelp(int quantitelp) {
        this.quantitelp = quantitelp;
    }

    public double getPrixlp() {
        return prixlp;
    }

    public void setPrixlp(double prixlp) {
        this.prixlp = prixlp;
    }


   
   
    
}
