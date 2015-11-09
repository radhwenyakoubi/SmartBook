/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MyConnection;
import Entities.Libraire;
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
public class LibraireDAO {
     Connection cnx;

    public LibraireDAO() {
        cnx = MyConnection.getInstance();
    }

 

    public List<Libraire> Display() {
       List<Libraire> listelibraires= new ArrayList<Libraire>();
String requete = "select * from libraire";
try {
Statement statement = MyConnection.getInstance()
.createStatement();
ResultSet resultat = statement.executeQuery(requete);
while(resultat.next()){
Libraire libraire = new Libraire();
libraire.setNom_librairie(resultat.getString(3));

listelibraires.add(libraire);
}
return listelibraires;
} catch (SQLException ex) {
//Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
System.out.println("erreur lors du chargement des libraires "+ex.getMessage());
return null;
    }
}
   
     public Libraire findLibraireByNom(String nom) {
         
         Libraire li=new Libraire();
        String requete = "SELECT * FROM  `libraire` WHERE NON_LIBRAIRIE =?"; 
      
        try {
             PreparedStatement st = cnx.prepareStatement(requete);
             st.setString(1,nom );
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                li.setId_lib(rs.getInt(1));
                li.setNom_librairie(rs.getString(3));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return li;
    }


}