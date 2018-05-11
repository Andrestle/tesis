package modelo;


import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import utility.data;
import utility.datos;
import utility.datos2;
import utility.reporte1;
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
    String b;
 
    sql sql = new sql();
    ArrayList<reporte1> a = new ArrayList<reporte1>();
    ArrayList<datos> c = new ArrayList<>();
    ArrayList<datos2> d = new ArrayList<>();
    
    
    public String reporteUsuarios (int iddep, int marca, String fecha, String hora, String tipo,
                            String fecha2, String hora2, String tipo2) throws ClassNotFoundException
    {
     
         
        try {
            
            String query="SELECT * FROM Record, Department, User WHERE Department.IdDepartment = User.IdDepartment "
                   + "and IdDepartment = "+iddep+" and User.IdUser = Record.IdUser "
                   + "and RecordType="+marca+" RecordTime > #"+fecha+" "+hora+" "+tipo+"# and RecordTime < #"+fecha2+" "+hora2+" "+tipo2+"";
            
            
            ResultSet da = sql.getValues(query);
            
            while (da.next()) {
                
                a.add(  new reporte1 (da.getString("IdUser"),da.getString("Title"), da.getString("Name"), da.getString("Description"), da.getString("Position"), da.getString("RecordType"), da.getString("RecordTime")));
                
            }
              
           return gson.toJson(a);
        } catch (SQLException ex) {
           
        }
        return null;
    }
    
         public String insertReporte (String a)
    {
     
         
        
        String query = "update  Department SET Description='togni es pargo' where IdDepartment = 11";
        
            
            
            String da = sql.setValues(query);
            
       
        return "ok";
    }
         
      public String insertarUsuario ( int cod , String cedula ,String nombre
            , int sexo, String titulo, String fecha ,  String celular
            , String telefono, String email , String puesto
            ,  int dept,  String direc)
    {
     
            String query="insert into User (IdUser , IdentificationNumber, Name, Gender, Title, Birthday, PhoneNumber,"
                    + "MobileNumber, Address, IdDepartment, Position, Email) values ("+cod+", '"+cedula+"','"+nombre+"',"+sexo+", '"+titulo+"','"+fecha+"','"+celular+"',"
                    + "'"+telefono+"','"+email+"','"+puesto+"',"+dept+",'"+direc+"') ;";
            
            
            String da = sql.setValues(query);
            
       
        return "ok";
    }
      
      public String insertarDepartamento (int idparent ,String description, String supervisor, String superemail){
          
          String query="insert into Department (IdParent, Description, SupervisorName, SupervisorEmail) values("+idparent+" ,'"+description+"', '"+supervisor+"', '"+superemail+"')";
          
          String da = sql.setValues(query);
          
        return "ok";
      
      }
      
      public String buscarUsuario (String cedula) throws ClassNotFoundException, SQLException{
        
        try {
          String query="Select * FROM User WHERE IdentificationNumber='"+cedula+"';";
        
          ResultSet da = sql.getValues(query);
          
          while(da.next()){
              
             c.add(  new datos (da.getString("IdUser"),da.getString("Title"), da.getString("Name"), da.getString("Position")));  
              
          }
          
            return gson.toJson(c);
          } catch (SQLException ex) {
           
        }
        return null;
      
      }
      
      public String actualizarUsuario (String celular, String telefono, String direc, int iddep, String puesto){
        
          String query="update User SET MobileNumber='"+celular+"', SET PhoneNumber='"+telefono+"', SET Address='"+direc+"', SET IdDepartment='"+iddep+"', SET Position='"+puesto+"' ";
          
          String da = sql.setValues(query);
          
          return "ok";
      
      }
    
      public String buscarDepartamento (String descripcion) throws ClassNotFoundException, SQLException{
        
        try {
          String query="Select * FROM Department WHERE Description='"+descripcion+"';";
        
          ResultSet da = sql.getValues(query);
          
          while(da.next()){
              
             d.add(  new datos2 (da.getString("IdDepartment"),da.getString("IdParent"), da.getString("Description"), da.getString("SupervisorName"), da.getString("SupervisorEmail")));  
              
          }
          
            return gson.toJson(d);
          } catch (SQLException ex) {
           
        }
        return null;
      
      }
      
      public String actualizarDepartamento (String descripcion, String supervisor, String superemail){
        
          String query="update Department SET Description='"+descripcion+"', SET SupervisorName='"+supervisor+"', SET SupervisorEmail='"+superemail+"' ";
          
          String da = sql.setValues(query);
          
          return "ok";
      
      }
      
      public String borrarUsuario (String cedula){
          
          String query="delete * from User WHERE IdentificationNumber='"+cedula+"'";
        
          String da = sql.setValues(query);
          
          return "ok";
      
      
      }
      
      public String borrarDepartamento (String descripcion){
          
          String query="delete * from Department WHERE Description='"+descripcion+"'";
        
          String da = sql.setValues(query);
          
          return "ok";
      
      
      }
      
      public String reporteZona (int zona) throws ClassNotFoundException, SQLException{
          
          
          try{
          String query="SELECT * FROM Record, Department, User, Device WHERE Department.IdDepartment = User.IdDepartment "
                   + "and User.IdUser = Record.IdUser and Record.MachineNumber=Device.IdDevice "
                   + "and MachineNumber="+zona+"";
          
          ResultSet da = sql.getValues(query);
          
          while(da.next()){
              
             a.add(  new reporte1 (da.getString("IdUser"),da.getString("Title"), da.getString("Name"), da.getString("Description"), da.getString("Position"), da.getString("RecordType"), da.getString("RecordTime")));
              
          }
          
            return gson.toJson(a);
          } catch (SQLException ex) {
           
        }
        return null;
          
          
      
      
      }
   
}

 