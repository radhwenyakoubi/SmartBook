/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connection.MyConnection;
import Entities.Libraire;
import Entities.ReclamationLib;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Radhwen
 */
public class ReclamationDAO {

    Connection cnx;
    LibraireDAO libraireDAO = new LibraireDAO();
    Libraire lib = new Libraire();

    public ReclamationDAO() {
        cnx = MyConnection.getInstance();
    }

    public void insertReclamation(ReclamationLib r) {

        String requete = "INSERT INTO reclamation "
                + "(ID_LECTEUR,ID_LIBRAIRIE,DESCRIPTION,DATE_RECLAMATION)"
                + " VALUES (?,?,?,?)";
        try {
            PreparedStatement st = cnx.prepareStatement(requete);
            st.setInt(1,r.getLecteur().getId());
            st.setInt(2, r.getLibraire().getId_lib());
            st.setString(3, r.getDescription());
            java.sql.Date sDate = new java.sql.Date(System.currentTimeMillis());
            java.util.Date uDate = new java.util.Date();
            sDate = new java.sql.Date(uDate.getTime());

            st.setDate(4,sDate );
            st.executeUpdate();

        } catch (SQLException ex) {

            ex.printStackTrace();
        }
    }

}
