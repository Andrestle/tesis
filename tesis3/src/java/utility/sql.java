/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Andrés Togni
 */


/**
 *
 * @author Andrés Togni
 */
public class sql {
    static Connection con;
    static Statement st;
    static PreparedStatement pst;
    static ResultSet rs;
 

public ResultSet getValues(String query) throws ClassNotFoundException
{
        try{
           
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String dbURL = "jdbc:ucanaccess://D:/DB/BDBioAdmin.mdb;showSchema=true";
            String username = "";
            String password = "";
            
            con = DriverManager.getConnection(dbURL, username, password);
          
            pst = con.prepareStatement(query);
            rs = null;
            
            try{
                rs = pst.executeQuery();
                System.out.println("consulta");
              
            }catch(SQLException sql){
             System.out.println("exploto");
            }
            pst.close();
            con.close();
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
      }
        return rs;
            }

public String setValues(String query)
{
 try{
           
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            String dbURL = "jdbc:ucanaccess://D:/DB/BDBioAdmin.mdb;showSchema=true";
            String username = "";
            String password = "";
            
            con = DriverManager.getConnection(dbURL, username, password);
          
            
        
            st=  con.createStatement(); 


       
           
            rs = null;
            
            try{
              st.executeUpdate(query);
                System.out.println("consulta");
              
            }catch(SQLException sql){
             System.out.println("exploto");
            }
            st.close();
            con.close();
            
        }
        catch(SQLException e)
        {
            e.printStackTrace();
      } catch (ClassNotFoundException ex) {
            Logger.getLogger(sql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "ok";
}




    
    }
    
