/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MyConnection;
import Entities.Livre;
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
public class LivreDAO {
  Connection cnx;
  private static LivreDAO instance;
      
      
      
      public static LivreDAO getInstance(){
        if (instance==null) instance=new LivreDAO();
        return instance;
      }

    public LivreDAO() {
        cnx = MyConnection.getInstance();
       
    }

    public void insertLivre(Livre l) {
        String requete = "INSERT INTO LIVRE "
        + "(TITRE_LIVRE,NOM_AUTEUR,DATE_EDITION,NOM_MAISON_EDITION,THEME,PRIX,DESCRIPTION_LIVRE,QUANTITE)"
        + " VALUES (?,?,?,?,?,?,?,?)";
       
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            //st.setInt(0, l.getId());
            st.setString(1, l.getTitre());
            st.setString(2, l.getNom_auteur());
           java.sql.Date sqlDate = new java.sql.Date(l.getDate_edition().getTime());
            st.setDate(3,sqlDate );
            st.setString(4, l.getMaison_edition());
            st.setString(5, l.getTheme());
            st.setDouble(6, l.getPrix());
            st.setString(7, l.getDescription());
            st.setInt(8, l.getQuantitie());
            
            st.executeUpdate();
            
        } catch (SQLException ex) {
            //System.err.println("Erreur d'ajout");
            ex.printStackTrace();
        }
    }

    public void updateLivre(Livre l, int id) {
        String requete = "UPDATE LIVRE set TITRE_LIVRE=?,NOM_AUTEUR=?,DATE_EDITION=?,NOM_MAISON_EDITION=?"
                + ",THEME=?,PRIX=?,DESCRIPTION_LIVRE=?,QUANTITE=? WHERE id=" + id;
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
             st.setString(1, l.getTitre());
            st.setString(2, l.getNom_auteur());
            st.setDate(3,(java.sql.Date) l.getDate_edition());
            st.setString(4, l.getMaison_edition());
            st.setString(5, l.getTheme());
            st.setDouble(6, l.getPrix());
            st.setString(7, l.getDescription());
            st.setInt(8, l.getQuantitie());
            st.executeUpdate();
            System.out.println("Modification effectué");
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }

    public void deleteLivre(Livre l) {
        String requete = "DELETE FROM livre WHERE id="+l.getId();
        try {
           
            
          PreparedStatement st = cnx.prepareStatement(requete);
            int x=l.getId();
            st.setInt(1,x);
            
            st.executeUpdate();
            System.out.println("Suppression effectué");
        } catch (SQLException ex) {
            System.err.println("Erreur de la suppression");
        }
    }

    public Livre findLivreById(int id) {
        String requete = "SELECT * FROM personne WHERE id=" + id;
        Livre l = null;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            l = new Livre();
            while (rs.next()) {
                //put what u want
                l.setId(rs.getInt(1));
                l.setTitre(rs.getString(2));
                l.setTheme(rs.getString(3));
            }
        } catch (SQLException ex) {
           // System.err.println("Erreur recherche");
        }
        return l;
    }

    public List<Livre> afficherLivres(String tit,String t) {
        List<Livre> maListe = new ArrayList<>();
        String requete;
        if (tit.equals("")&&t.equals(""))
        requete = "SELECT * FROM LIVRE";
        else if((!tit.equals(""))&&!(t.equals("")))
            requete = "SELECT * FROM LIVRE WHERE TITRE_LIVRE='"+tit+"'and NOM_AUTEUR='"+t+"'";
        else if((!tit.equals(""))&&(t.equals("")))
            requete = "SELECT * FROM LIVRE WHERE TITRE_LIVRE='"+tit+"'";
        else 
            requete = "SELECT * FROM LIVRE WHERE NOM_AUTEUR='"+t+"'";
        
        Statement st;
        try {
            st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Livre l = new Livre();
                l.setId(rs.getInt(1));
                l.setTitre(rs.getString(2));
                l.setNom_auteur(rs.getString(3));
                l.setDate_edition((java.util.Date)rs.getDate(4));
                l.setMaison_edition(rs.getString(5));
                l.setTheme(rs.getString(6));
                l.setPrix(rs.getDouble(7));
                l.setDescription(rs.getString(8));
                l.setQuantitie(rs.getInt(9));
                maListe.add(l);
            }
            return maListe;
            }catch (SQLException ex) {
           ex.printStackTrace();
        }
        return null;
        }     
}
