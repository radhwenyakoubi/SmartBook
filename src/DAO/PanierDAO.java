/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MyConnection;
import Entities.Lecteur;
import Entities.Libraire;
import Entities.Panier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Logger;

/**
 *
 * @author Radhwen
 */
public class PanierDAO {
    
    
    private static PanierDAO instance;
      
      
      
      public static PanierDAO getInstance(){
        if (instance==null) instance=new PanierDAO();
        return instance;
      }

    Connection cnx;
    LibraireDAO libraireDAO = new LibraireDAO();
    Libraire lib = new Libraire();
    LecteurDAO lecteurDAO = new LecteurDAO();
    Lecteur lecteur = new Lecteur();

    public PanierDAO() {

        cnx = MyConnection.getInstance();
        

    }

    public void creatPanier(Panier p) {

        String requete = "INSERT INTO panier "
                + "(ID_LECTEUR,TOTALE_PANIER)"
                + " VALUES (?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            int x = p.getLecteur().getId();
            st.setInt(1, x);
            st.setDouble(2, p.getTotale());
            st.executeUpdate();

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }
      public void update(Panier p) {
     String requete = "update panier set TOTALE_PANIER=?  where ID_LECTEUR="+p.getLecteur().getId();
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            ps.setDouble(1, p.getTotale());
           
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
      
      
      }

      
      
      
       public void delete(Panier p) {
       String sqlQuery = "DELETE FROM panier WHERE ID_LECTEUR= ?";
           try {
            PreparedStatement   pstmt = cnx.prepareStatement(sqlQuery);
            pstmt.setInt(1, p.getLecteur().getId());
            pstmt.execute();
        } catch (SQLException ex) {
               System.err.println(ex);
        }
    }
    
   public Panier findPanier(Integer idPanier) {
       Panier p= new Panier();
        String requete = "select * from panier WHERE ID_PANIER=" + idPanier;
       try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setLecteur(LecteurDAO.getInstance().findLecteurById(rs.getInt(2)));
                p.setTotale(rs.getDouble(3));
            }

            return p;
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Panier " + ex.getMessage());
            return null;
        }
    }
    
     public Panier findByLecteurId(Integer idlecteur) {
       Panier p= new Panier();
        String requete = "select * from panier WHERE ID_LECTEUR=" + idlecteur;
       try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                p.setId(rs.getInt(1));
                p.setLecteur(LecteurDAO.getInstance().findLecteurById(idlecteur));
                p.setTotale(rs.getDouble(3));
            }

            return p;
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Panier " + ex.getMessage());
            return null;
        }
    }
       
       
}
