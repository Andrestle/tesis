package modelo;


import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.data;
import utility.sql;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Andrés Togni
 */
public class reportes {

    Gson gson = new Gson();
 
    sql sql = new sql();
     ArrayList<data> a = new ArrayList<data>();
    public String reporte1 ()
    {
     
         
        try {
            String query="SELECT * FROM prueba";
            
            
            ResultSet da = sql.getValues(query);
            
            while (da.next()) {
                
                a.add(  new data (da.getString("nombre"), da.getString("apellido")));
            }
 
            return  gson.toJson( a);
        } catch (SQLException ex) {
           
        }
        return null;
    }
    
    
}
