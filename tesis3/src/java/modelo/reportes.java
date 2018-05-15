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
import utility.datos3;
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
    ArrayList<datos3> e = new ArrayList<>();
    
    public String reporteUsuarios (int iddep, int marca, String fecha, String hora, String tipo,
                            String fecha2, String hora2, String tipo2) throws ClassNotFoundException
    {
     
         
        try {
            
            String query="SELECT * FROM Record, Department, User WHERE Department.IdDepartment = User.IdDepartment "
                   + "and IdDepartment = "+iddep+" and User.IdUser = Record.IdUser "
                   + "and RecordType = "+marca+" and RecordTime > #"+fecha+" "+hora+" "+tipo+"# and RecordTime < #"+fecha2+" "+hora2+" "+tipo2+"#";
            
            
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
            , int sexo, String titulo, String fecha, String hora, String tipo ,  String telefono
            , String celular, String direc , int dept
            ,  String puesto,  String email)
    {
     
            String query="insert into User (IdUser , IdentificationNumber, Name, Gender, Title, Birthday, PhoneNumber ,"
                    + "MobileNumber, Address, IdDepartment, Position, Email ) values ("+cod+", '"+cedula+"','"+nombre+"',"+sexo+",'"+titulo+"',#"+fecha+" "+hora+" "+tipo+"#, '"+telefono+"',"
                    + "'"+celular+"','"+direc+"',"+dept+",'"+puesto+"','"+email+"')";
            
            
            String da = sql.setValues(query);
            
            //?cod=4&cedula=22916315&nombre=Luisana Delgado&sexo=1&titulo=Lcda.&fecha=27/7/2018&hora=11:00:00&tipo=AM&celular=04142665559&telefono=02122560160&email=luisana@gmail.com&puesto=Jefa&dept=2&direc=caracas
            
       
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
    
      public String buscarDepartamento (String description) throws ClassNotFoundException, SQLException{
        
        try {
          String query="Select * FROM Department WHERE Description='"+description+"';";
        
          ResultSet da = sql.getValues(query);
          
          while(da.next()){
              
             d.add(  new datos2 (da.getString("IdDepartment"),da.getString("IdParent"), da.getString("Description"), da.getString("SupervisorName"), da.getString("SupervisorEmail")));  
              
          }
          
            return gson.toJson(d);
          } catch (SQLException ex) {
           
        }
        return null;
      
      }
      
      public String actualizarDepartamento (String description, String supervisor, String superemail){
        
          String query="update Department SET Description='"+description+"', SET SupervisorName='"+supervisor+"', SET SupervisorEmail='"+superemail+"' ";
          
          String da = sql.setValues(query);
          
          return "ok";
      
      }
      
      public String borrarUsuario (int iduser){
          
          String query1="delete * FROM Record WHERE IdUser="+iduser+"";
          String query2="delete * FROM UserFingerprint WHERE IdUser="+iduser+"";
          String query3="delete * FROM User WHERE IdUser="+iduser+"";
        
          
          String da = sql.setValues(query1);
          String db = sql.setValues(query2);
          String dc = sql.setValues(query3);
          
          return "ok";
      
      
      }
      
      public String borrarDepartamento (String description){
          
          String query="delete * from Department WHERE Description='"+description+"'";
        
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
      
      
       public String buscarHora (String fecha, String hora, String tipo) throws ClassNotFoundException{
           
           try{
           String query="Select * FROM Record WHERE RecordTime > #"+fecha+" "+hora+" "+tipo+"#";
           
           ResultSet da = sql.getValues(query);
           
           while(da.next()){
              
             e.add(  new datos3 (da.getString("IdUser")));
              
          }
          
            return gson.toJson(e);
          } catch (SQLException ex) {
           
        }
        return null;
        
       }
       
 
      
   
}

 