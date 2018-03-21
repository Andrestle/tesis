/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

/**
 *
 * @author Andrés Togni
 */

	


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class sql {
    private static Connection Conexion;
    
    
  
     Connection conexion = null;
    Statement comando = null;
    ResultSet registro;
 
    public Connection MySQLConnect() {
 
        try {
            //Driver JDBC
            Class.forName("com.mysql.jdbc.Driver");
            //Nombre del servidor. localhost:3306 es la ruta y el puerto de la conexión MySQL
            //panamahitek_text es el nombre que le dimos a la base de datos
            String servidor = "jdbc:mysql://localhost:3306/tesis";
            //El root es el nombre de usuario por default. No hay contraseña
            String usuario = "root";
            String pass = "";
            //Se inicia la conexión
            conexion = DriverManager.getConnection(servidor, usuario, pass);
 
        } catch (ClassNotFoundException ex) {
           
            conexion = null;
        } catch (SQLException ex) {
    
            conexion = null;
        } catch (Exception ex) {
          
            conexion = null;
        } finally {
           
            return conexion;
        }
    }
    
    public ResultSet getValues(String querry) {
           data data;
        String resultado ="";
      ResultSet resultSet = null;
            try {
            String Query  = querry;
            conexion = MySQLConnect();
            Statement st = conexion.createStatement();
       
            resultSet = st.executeQuery(Query);
            
           
        } catch (SQLException ex) {
          
        }
        return resultSet;
    }
    

     
    
}
