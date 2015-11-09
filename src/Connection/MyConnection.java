/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Hedi
 */
public class MyConnection {
   final     String url="jdbc:mysql://localhost:3306/smartboook";
   final     String login="root";
   final     String pwd="";
    static Connection cnx=null;
    
    private MyConnection()
    {
        try{
        cnx =DriverManager.getConnection(url,login,pwd);
        System.out.println("connexion etablie");
        }
        catch(SQLException ex)
        {
        System.out.println("connection non etablie");
        }
        
        
    }
    
    public static Connection getInstance(){
    if (cnx==null)
        new MyConnection();
                 return cnx;
        
    
    }
    
}
