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
public class Annonce {
   private int id;
   private String description;
   private String type;
   private Date date_annonce;

    public Annonce() {
    }

    public Annonce(int id, String description, String type, Date date_annonce) {
        this.id = id;
        this.description = description;
        this.type = type;
        this.date_annonce = date_annonce;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate_annonce() {
        return date_annonce;
    }

    public void setDate_annonce(Date date_annonce) {
        this.date_annonce = date_annonce;
    }
   
   
   
}
