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
import utility.datos4;
import utility.datos5;
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
    ArrayList<datos4> f = new ArrayList<>();
    ArrayList<datos5> g = new ArrayList<>();
    
    public String reporteUsuarios (int iddep, int marca, String fecha, String hora, String tipo,
                            String fecha2, String hora2, String tipo2) throws ClassNotFoundException
    {
     
         
        try {
            
            String query="SELECT * FROM Record, Department, User WHERE Department.IdDepartment = User.IdDepartment "
                   + "and IdDepartment = "+iddep+" and User.IdUser = Record.IdUser "
                   + "and RecordType = "+marca+" and RecordTime > #"+fecha+" "+hora+" "+tipo+"# and RecordTime < #"+fecha2+" "+hora2+" "+tipo2+"#";
            
            
            ResultSet da = sql.getValues(query);
            
            while (da.next()) {
                
                a.add(  new reporte1 (da.getString("IdUser"), da.getString("Name"), da.getString("Description"), da.getString("Position"), da.getString("RecordType"), da.getString("RecordTime")));
                
            }
              
           return gson.toJson(a);
        } catch (SQLException ex) {
           
        }
        return null;
    }
    
        public String reporteUsuarios1 (int marca, String fecha, String hora, String tipo,
                            String fecha2, String hora2, String tipo2) throws ClassNotFoundException
    {
     
         
        try {
            
            String query="SELECT * FROM Record, User, Department WHERE User.IdUser = Record.IdUser and Department.IdDepartment = User.IdDepartment "
                   + "and RecordType = "+marca+" and RecordTime > #"+fecha+" "+hora+" "+tipo+"# and RecordTime < #"+fecha2+" "+hora2+" "+tipo2+"#";
            
            
            ResultSet da = sql.getValues(query);
            
            while (da.next()) {
                
                a.add(  new reporte1 (da.getString("IdUser"),da.getString("Name"), da.getString("Description"), da.getString("Position"), da.getString("RecordType"), da.getString("RecordTime")));
                
            }
              
           return gson.toJson(a);
        } catch (SQLException ex) {           
           
        }
        return null;
    }
        
        public String reporteUsuarios2 (String fecha, String hora, String tipo,
                            String fecha2, String hora2, String tipo2) throws ClassNotFoundException
    {
     
         
        try {
            
            String query="SELECT * FROM Record, User, Department WHERE User.IdUser = Record.IdUser and Department.IdDepartment = User.IdDepartment "
                   + "and RecordTime > #"+fecha+" "+hora+" "+tipo+"# and RecordTime < #"+fecha2+" "+hora2+" "+tipo2+"#";
            
            
            ResultSet da = sql.getValues(query);
            
            while (da.next()) {
                
                a.add(  new reporte1 (da.getString("IdUser"), da.getString("Name"), da.getString("Description"), da.getString("Position"), da.getString("RecordType"), da.getString("RecordTime")));
                
            }
              
           return gson.toJson(a);
        } catch (SQLException ex) {           
           
        }
        return null;
    }
        
         public String reporteUsuarios3(int iddep, String fecha, String hora, String tipo,
                            String fecha2, String hora2, String tipo2) throws ClassNotFoundException
    {
     
         
        try {
            
            String query="SELECT * FROM Record, User, Department WHERE User.IdUser = Record.IdUser and Department.IdDepartment = User.IdDepartment and IdDepartment = "+iddep+" "
                   + "and RecordTime > #"+fecha+" "+hora+" "+tipo+"# and RecordTime < #"+fecha2+" "+hora2+" "+tipo2+"#";
            
            
            ResultSet da = sql.getValues(query);
            
            while (da.next()) {
                
                a.add(  new reporte1 (da.getString("IdUser"), da.getString("Name"), da.getString("Description"), da.getString("Position"), da.getString("RecordType"), da.getString("RecordTime")));
                
            }
              
           return gson.toJson(a);
        } catch (SQLException ex) {           
           
        }
        return null;
    }
         
      public String insertarUsuario (int cod, String cedula ,String nombre
            , int sexo, String fecha,  String telefono
            , String celular, String direc , int dept
            ,  String puesto,  String email)
    {
     
        
            
            String query="insert into User (IdUser, IdentificationNumber, Name, Gender, Birthday, PhoneNumber,"
                    + "MobileNumber, Address, IdDepartment, Position, Email, Active, Privilege, HourSalary, CreatedBy, CreatedDateTime, ModifiedBy, ModifiedDateTime) "
                    + "values ("+cod+", '"+cedula+"', '"+nombre+"', "+sexo+", #"+fecha+" 12:00:00 AM#, '"+telefono+"',"
                    + "'"+celular+"','"+direc+"',"+dept+",'"+puesto+"','"+email+"', 1, 0, 100, 0, #4/4/2018 11:00:00 AM#, 0, #4/26/2018 11:00:00 AM#)";
            
            
            String da = sql.setValues(query);
            
            
            //?cod=4&cedula=22916315&nombre=Luisana Delgado&sexo=1&titulo=Lcda.&fecha=27/7/2018&hora=11:00:00&tipo=AM&celular=04142665559&telefono=02122560160&email=luisana@gmail.com&puesto=Jefa&dept=2&direc=Caracas
            
       
        return "ok";
    }
      
      public String insertarDepartamento (String description, String supervisor, String superemail){
          
          String query="insert into Department (IdParent, Description, SupervisorName, SupervisorEmail) values(1 ,'"+description+"', '"+supervisor+"', '"+superemail+"')";
          
          String da = sql.setValues(query);
          
        return "ok";
      
      }
      
      public String buscarUsuario (int cod) throws ClassNotFoundException, SQLException{
        
        try {
          String query="Select * FROM User, Department WHERE Department.IdDepartment = User.IdDepartment and IdUser="+cod+";";
        
          ResultSet da = sql.getValues(query);
          
          while(da.next()){
              
             c.add(  new datos (da.getString("IdUser"), da.getString ("Name"), da.getString("IdentificationNumber"), da.getString("Gender"), 
                     da.getString("PhoneNumber"), da.getString("MobileNumber"), da.getString("Email"), da.getString("Description"), da.getString("Address"), da.getString("Position")));  
              
          }
          
            return gson.toJson(c);
          } catch (SQLException ex) {
           
        }
        return null;
      
      }
      
      public String actualizarUsuario (String cedula, String celular, String telefono, String direc, int iddep, String puesto){
        
          String query="update User "
                  + "SET MobileNumber='"+celular+"' ,PhoneNumber='"+telefono+"' ,Address='"+direc+"', IdDepartment='"+iddep+"', Position='"+puesto+"' "
                  + "WHERE IdentificationNumber = '"+cedula+"' ";
          
          String da = sql.setValues(query);
          
          return "ok";
      
      }
    
      public String buscarDepartamento () throws ClassNotFoundException, SQLException{
        
        try {
          String query="Select * FROM Department WHERE IdDepartment > 1 ;";
        
          ResultSet da = sql.getValues(query);
          
          while(da.next()){
              
             d.add(  new datos2 (da.getString("IdDepartment"), da.getString("Description")));  
              
          }
          
            return gson.toJson(d);
          } catch (SQLException ex) {
           
        }
        return null;
      
      }
      
      public String actualizarDepartamento (String description, String supervisor, String superemail, int iddep){
        
          String query="update Department "
                  + "SET Description='"+description+"', SupervisorName='"+supervisor+"', SupervisorEmail='"+superemail+"' "
                  + "WHERE IdDepartment="+iddep+"";
          
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
          //String query="delete * from User, Department, Record WHERE Department.IdDepartment=User.IdDepartment and Record.IdUser = User.IdUser and Description='"+description+"'";
          //String query3="delete * from Record WHERE ";
        
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
              
             a.add(  new reporte1 (da.getString("IdUser"),da.getString("Name"), da.getString("Description"), da.getString("Position"), da.getString("RecordType"), da.getString("RecordTime")));
              
          }
          
            return gson.toJson(a);
          } catch (SQLException ex) {
           
        }
        return null;
          
        
        
        }
      
       public String reporteZona1 (int zona) throws ClassNotFoundException, SQLException{
          
          
          try{
          String query="SELECT * FROM Record, Department, User, Device WHERE Department.IdDepartment = User.IdDepartment "
                   + "and User.IdUser = Record.IdUser and Record.MachineNumber=Device.IdDevice ";
                  
          
          ResultSet da = sql.getValues(query);
          
          while(da.next()){
              
             a.add(  new reporte1 (da.getString("IdUser"),da.getString("Name"), da.getString("Description"), da.getString("Position"), da.getString("RecordType"), da.getString("RecordTime")));
              
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
       
       public String listadoEmpleados(int iddep) throws ClassNotFoundException, SQLException{
           
           
           try{
           String query="SELECT * FROM User, Department WHERE Department.IdDepartment=User.IdDepartment and IdDepartment="+iddep+" ;";
           ResultSet da = sql.getValues(query);
            
            while (da.next()) {
                
                f.add(  new datos4 (da.getString("IdUser"), da.getString("IdentificationNumber"),da.getString("Name"), da.getString("Position"), da.getString("Description")));
                
            }
              
           return gson.toJson(f);
        }catch (SQLException ex) {
           
        }
        return null;
       
       
       }
       
       public String listadoEmpleados1() throws ClassNotFoundException{
       
            try{
           String query="SELECT * FROM User, Department WHERE Department.IdDepartment=User.IdDepartment;";
           ResultSet da = sql.getValues(query);
            
            while (da.next()) {
                
                f.add(  new datos4 (da.getString("IdUser"), da.getString("IdentificationNumber"),da.getString("Name"), da.getString("Position"), da.getString("Description")));
                
            }
              
           return gson.toJson(f);
        }catch (SQLException ex) {
           
        }
        return null;
       
       
       }
       
       public String buscarDispositivos() throws ClassNotFoundException, SQLException {
        try{
           String query="SELECT * FROM Device;";
           ResultSet da = sql.getValues(query);
            
            while (da.next()) {
                
                g.add(  new datos5 (da.getString("IdDevice"), da.getString("Description")));
                
            }
              
           return gson.toJson(g);
        }catch (SQLException ex) {
           
        }
        return null;
       }
       
       public String ultimosCinco() throws ClassNotFoundException, SQLException{
       
        try{
           String query="SELECT TOP 5 * FROM Record, Department, User WHERE Department.IdDepartment = User.IdDepartment "
                   + "and User.IdUser = Record.IdUser "
                   + "ORDER BY Record.RecordTime DESC";
           ResultSet da = sql.getValues(query);
            
            while (da.next()) {
                
                a.add(  new reporte1 (da.getString("IdUser"), da.getString("Name"), da.getString("Description"), da.getString("Position"), da.getString("RecordType"), da.getString("RecordTime")));
                
            }
              
           return gson.toJson(a);
        }catch (SQLException ex) {
           
        }
        return null;   
           
       }
       
 
      
   
}

 