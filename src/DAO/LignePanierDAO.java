/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Entities.Livre;
import Entities.Panier;
import Entities.LignePanier;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Radhwen
 */
public class LignePanierDAO {
    Connection cnx;
    LivreDAO livreDAO = new LivreDAO();
    Livre livre = new Livre();
    PanierDAO panierDAO = new PanierDAO();
    Panier panier = new Panier();
   
    
    public void creatLignePanier(LignePanier lp) {
        String requete = "INSERT INTO panier "
        + "(ID_PANIER,ID_LIVRE,QUANTITE_LIGNEPANIER,PRIX_LINGEPANIER)"
        + " VALUES (?,?,?,?)";
       
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            int z=panier.getId();
            ps.setInt(1,z);
            int x=livre.getId();
            ps.setInt(2,x);
            ps.setInt(3,lp.getQuantitelp());
            ps.setDouble(4,lp.getPrixlp());
            
           
            
            ps.executeUpdate();
            
        } catch (SQLException ex) {
            //System.err.println("Erreur d'ajout");
            ex.printStackTrace();
        }
    }
    public void update(LignePanier lp) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String requete = "update ligne_panier set quantite=? , montant=? where idproduit=? and idpanier=?";
        try {
            PreparedStatement ps = cnx.prepareStatement(requete);
            int z=panier.getId();
            ps.setInt(1,z);
            int x=livre.getId();
            ps.setInt(2,x);
            ps.setInt(3,lp.getQuantitelp());
            ps.setDouble(4,lp.getPrixlp());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
            //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour " + ex.getMessage());
        }
    }
     public void delete(LignePanier lp) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String sqlQuery = "DELETE FROM ligne_panier WHERE ID_PANIER= ?"+" and ID_LIVRE=?";
           try {
            PreparedStatement   ps = cnx.prepareStatement(sqlQuery);
            int z=panier.getId();
            int x=livre.getId();
            ps.setInt(1,z);
            ps.setInt(2,x);
            ps.execute();
        } catch (SQLException ex) {
               System.err.println(ex);
        }
          
    }
     public LignePanier findPanier(Integer idPanier, Integer idLivre) {
     //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           String requete = "select * from ligne_panier where ID_PANIER=? and ID_LIVRE=?";
       LignePanier lp = null;
           try {
             PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1,idPanier);
            st.setInt(2,idLivre);
            ResultSet rs = st.executeQuery();
          
            
            while (rs.next()) {
              lp= new LignePanier();  
                
               lp.setPanier(PanierDAO.getInstance().findPanier(rs.getInt(1)));
                lp.setLivre(LivreDAO.getInstance().findLivreById(rs.getInt(2)));
                lp.setQuantitelp(rs.getInt(3));
                lp.setPrixlp(rs.getDouble(4));
               return lp;
            }
            
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des lignes des panier" + ex.getMessage());
            
        }
          return null; 
    }
    
    public List<LignePanier> findAll(int idPanier) {
         List<LignePanier> LignesPanier = new ArrayList<>();
        String requete = "select * from ligne_panier where ID_PANIER="+idPanier;
        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                LignePanier lignePanier = new LignePanier();
               lignePanier.setLivre(livreDAO.getInstance().findLivreById(rs.getInt(1)));
                lignePanier.setPanier(PanierDAO.getInstance().findPanier(rs.getInt(2)));
                lignePanier.setQuantitelp(rs.getInt(3));
                lignePanier.setPrixlp(rs.getDouble(4));
                LignesPanier.add(lignePanier);
            }
            return LignesPanier;
        } catch (SQLException ex) {
           // Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des Lignes des paniers" + ex.getMessage());
            return null;
                  } 
     }
}