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
public class Libraire {
    private int id_lib;
   private String nom_librairie;
   private String cite;

    public Libraire() {
    }

    public Libraire(int id_lib, String nom_librairie, String cite) {
        this.id_lib = id_lib;
        this.nom_librairie = nom_librairie;
        this.cite = cite;
    }

    public void setId_lib(int id_lib) {
        this.id_lib = id_lib;
    }

    public void setNom_librairie(String nom_librairie) {
        this.nom_librairie = nom_librairie;
    }

    public void setCite(String cite) {
        this.cite = cite;
    }

    public int getId_lib() {
        return id_lib;
    }

    public String getNom_librairie() {
        return nom_librairie;
    }

    public String getCite() {
        return cite;
    }

  

    
   
   
}
