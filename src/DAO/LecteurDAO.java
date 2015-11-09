/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Lecteur;
import Connection.MyConnection;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Hedi
 */
public class LecteurDAO {

    Connection cnx;
 private static LecteurDAO instance;
      
      
      
      public static LecteurDAO getInstance(){
        if (instance==null) instance=new LecteurDAO();
        return instance;
      }

    public LecteurDAO() {
        cnx = MyConnection.getInstance();
        
    }

    public void insertLecteur(Lecteur l) {

        String requete = "INSERT INTO lecteur "
                + "(NOM,PRENOM,CIN,SEXE,ADRESSE_LECTEUR,MAIL_LECTEUR,DATE_NAISSANCE,TELEPHONE_LECTEUR,STATUT,LOGIN_LECTEUR,MOT_DE_PASSE_LECTEUR	)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            //st.setInt(1, l.getId());
            st.setString(1, l.getNom());
            st.setString(2, l.getPrenom());
            st.setInt(3, l.getCin());
            st.setString(4, l.getSexe());
            st.setString(5, l.getAdresse());
            st.setString(6, l.getMail());

            java.sql.Date sqlDate = new java.sql.Date(l.getDate_naissance().getTime());
            st.setDate(7, sqlDate);
            st.setInt(8, l.getTelephone());
            st.setString(9, l.getStatus());
            st.setString(10, l.getLogin());
            st.setString(11, l.getMot_de_passe());

            st.executeUpdate();

        } catch (SQLException ex) {
            //System.err.println("Erreur d'ajout");
            ex.printStackTrace();
        }
    }

    public void updateLecteur(Lecteur l, int id) {
        String requete = "UPDATE lecteur set NOM=?,PRENOM=?,CIN=?,SEXE=?,ADRESSE_LECTEUR=?,MAIL_LECTEUR=?,DATE_NAISSANCE=?,TELEPHONE_LECTEUR=?,STATUT=?,LOGIN_LECTEUR=?,MOT_DE_PASSE_LECTEUR=?	WHERE ID_LECTEUR=" + id;
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setString(1, l.getNom());
            st.setString(2, l.getPrenom());
            st.setInt(3, l.getCin());
            st.setString(4, l.getSexe());
            st.setString(5, l.getAdresse());
            st.setString(6, l.getMail());
            java.sql.Date sqlDate = new java.sql.Date(l.getDate_naissance().getTime());
            st.setDate(7, sqlDate);
            st.setInt(8, l.getTelephone());
            st.setString(9, l.getStatus());
            st.setString(10, l.getLogin());
            st.setString(11, l.getMot_de_passe());
            
            st.executeUpdate();
            System.out.println("Modification effectué");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deletePersonne(Lecteur l) {
        String requete = "DELETE FROM lecteur WHERE ID_LECTEUR=?";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1, l.getId());
            st.executeUpdate();
            System.out.println("Suppression effectué");
        } catch (SQLException ex) {
            System.err.println("Erreur de la suppression");
        }
    }

    public Lecteur findLecteurById(int id) {
        String requete = "SELECT * FROM lecteur WHERE ID_LECTEUR =?";
        Lecteur l = null;
        try {
             
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1, id);
            ResultSet rs = st.executeQuery();
            l = new Lecteur();
            
            while (rs.next()) {
                System.out.println("aaaaaaaa");
                // l.setId(rs.getInt(1));
                l.setNom(rs.getString(4));
                l.setPrenom(rs.getString(5));
                l.setCin(rs.getInt(6));
                l.setSexe(rs.getString(7));
                l.setAdresse(rs.getString(8));
                l.setMail(rs.getString(9));
                // l.setDate_naissance((java.util.Date)rs.getDate(7));
                l.setDate_naissance(rs.getDate(10));
                l.setTelephone(rs.getInt(11));
                l.setStatus(rs.getString(12));
                l.setLogin(rs.getString(13));
                l.setMot_de_passe(rs.getString(14));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return l;
    }

    public List<Lecteur> afficherLecteur() {
        List<Lecteur> maListe = new ArrayList<>();
        String requete = "SELECT * FROM lecteur";
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Lecteur l = new Lecteur();
                l.setId(rs.getInt(1));
                l.setNom(rs.getString(2));
                l.setPrenom(rs.getString(3));
                l.setCin(rs.getInt(4));
                l.setSexe(rs.getString(5));
                l.setAdresse(rs.getString(6));
                l.setMail(rs.getString(7));
                l.setDate_naissance(rs.getDate(8));
                l.setLogin(rs.getString(9));
                l.setMot_de_passe(rs.getString(10));
                l.setStatus(rs.getString(11));
                maListe.add(l);
            }
            return maListe;
        } catch (SQLException ex) {
            System.err.println("Erreur d'affichage de la liste");
        }
        return null;
    }
}
