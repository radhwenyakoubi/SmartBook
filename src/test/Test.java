/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Radhwen
 */
import DAO.LecteurDAO;
import Entities.Lecteur;
import Entities.Libraire;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hedi
 */
public class Test {

    public static void main(String arg[]) throws ParseException {
        LecteurDAO ledao = new LecteurDAO();
        Lecteur l1 = new Lecteur();
        Date myDate;
       //Date d = new Date(2000,2,15);

        l1.setNom("radhwen");
        l1.setPrenom("yakoubi");
        l1.setCin(790);
        l1.setSexe("homme");
        l1.setAdresse("tunisariana");
        l1.setMail("radhwen.yak@gmail.com");

        //
//        try {
//            l1.setDateNaissance(sd.parse(date));
//        } catch (ParseException ex) {
//            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
//
//        }st.setDate(7,(java.sql.Date) l.getDate_naissance());
        
        String date2 = "2016-12-31";
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        myDate = formatter.parse(date2);

        l1.setDate_naissance(myDate);
        l1.setLogin("jiko");
        l1.setMot_de_passe("jiko");
        l1.setTelephone(20652759);
        l1.setStatus("etudiant");
        

        ledao.insertLecteur(l1);
        System.out.print("lecteur ajoutee avec succées");

        
        System.err.println("----------------------------");
        Lecteur l2=new Lecteur();
         l2 = ledao.findLecteurById(2);
        
        
    }

}
