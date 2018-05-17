package rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import modelo.reportes;

/**
 *
 * @author Andrés Togni
 */

@Path("/rest")
public class rest {
    reportes reporte = new reportes();
    
    @GET
    @Path("/reporteUsuarios")
    @Produces("application/json")
    public   String reporteUsu (@QueryParam("iddep") int iddep, @QueryParam("marca") int marca,
                           @QueryParam("fecha") String fecha, @QueryParam("hora") String hora,
                           @QueryParam("tipo") String tipo, @QueryParam("fecha2") String fecha2, @QueryParam("hora2") String hora2,
                           @QueryParam("tipo2") String tipo2) throws ClassNotFoundException
            
    {   
        
        if(iddep==0){
            
            if(marca==2){
                
                return reporte.reporteUsuarios2(fecha, hora, tipo, fecha2, hora2, tipo2);
                
                //Busca reportes de todos los departamentos sin importar el tipo de marca
            
            }
            
            else{
            
            return reporte.reporteUsuarios1(marca, fecha, hora, tipo, fecha2, hora2, tipo2);
            
            // Busca reportes de todos los departamentos todmando en cuenta la marca
            }
        }
        
        else{
            
            if(marca==2){
                
                return reporte.reporteUsuarios3(iddep, fecha, hora, tipo, fecha2, hora2, tipo2);
                
                // Busca reportes de un departamento sin importar el tipo de marca
            
            }
            
            else{
            
            return reporte.reporteUsuarios(iddep, marca, fecha, hora, tipo, fecha2, hora2, tipo2);
            
            // Busca reportes de un departamento tomando en cuenta la marca
            }
            
        
        
        //http://localhost:8080/tesis3/rest/reporteUsuarios?iddep=2&marca=0&fecha=4/4/2018&hora=11:00:00&tipo=AM&fecha2=4/4/2018&hora2=12:00:00&tipo2=AM
        
    }
      
    }
    
      
    @GET
    @Path("/reporteZonas")
    @Produces("application/json")
    public   String reporteZon (@QueryParam("zona") int zona) throws ClassNotFoundException, SQLException
            
    {   
        
        return reporte.reporteZona(zona);
        
        
       // http://localhost:8080/tesis3/rest/reporteZonas?zona=2
        
    }
    
    
    @GET
    @Path("/insertarUsuario")
    @Produces("application/json")
    public   String insertarUsu (@QueryParam("cod") int cod , @QueryParam("nombre") String nombre, @QueryParam("cedula") String cedula 
            , @QueryParam("sexo") int sexo, @QueryParam("fecha") String fecha , @QueryParam("celular") String celular
            , @QueryParam("telefono") String telefono,@QueryParam("email") String email , @QueryParam("puesto") String puesto
            , @QueryParam("dept") int dept, @QueryParam("direc") String direc) throws ClassNotFoundException
            
    {   
        
        return reporte.insertarUsuario(cod,cedula,nombre,sexo,fecha,telefono,celular,direc,dept,puesto,email); 
        
               // http://localhost:8080/tesis3/rest/insertarUsuario?cod=4&cedula=22916315&nombre=Luisana Delgado&sexo=1&titulo=Lcda.&fecha=27/07/2018&hora=11:00:00&tipo=AM&celular=04142665559&telefono=02122560160&email=luisana@gmail.com&puesto=Jefa&dept=2&direc=caracas    
    }
    
    @GET
    @Path("/insertarDepartamento")
    @Produces("application/json")
    public   String insertarDep (@QueryParam("description") String description,
            @QueryParam("supervisor") String supervisor, @QueryParam("superemail") String superemail) throws ClassNotFoundException
            
    {
        return reporte.insertarDepartamento(description, supervisor, superemail); 
        
        //http://localhost:8080/tesis3/rest/insertarDepartamento?idparent=1&description=Administracion&supervisor=Jose&superemail=jose@gmail.com
    }
    
    @GET
    @Path("/borrarUsuario")
    @Produces("application/json")
    public   String borrarUsu (@QueryParam("iduser")int iduser)
            
    {
        return reporte.borrarUsuario(iduser);
        
        //http://localhost:8080/tesis3/rest/borrarUsuario?iduser=6
    }
    
    @GET
    @Path("/borrarDepartamento")
    @Produces("application/json")
    public   String borrarDep (@QueryParam("description")String description)
            
    {
        return reporte.borrarDepartamento(description);
        
        //http://localhost:8080/tesis3/rest/borrarDepartamento?description=Administracion
    }
    
    @GET
    @Path("/buscarUsuario")
    @Produces("application/json")
    public   String buscarUsu (@QueryParam("cod") int cod) throws ClassNotFoundException, SQLException
            
    {   
        return reporte.buscarUsuario(cod); 
        
        //http://localhost:8080/tesis3/rest/buscarUsuario
          
    }
    
    @GET
    @Path("/actualizarUsuario")
    @Produces("application/json")
    public   String actualizarUsu (@QueryParam("cedula") String cedula,@QueryParam("celular")String celular, @QueryParam("telefono") String telefono, @QueryParam("direc") String direc, 
             @QueryParam("iddep") int iddep, @QueryParam("puesto") String puesto)
            
    {
        return reporte.actualizarUsuario(cedula, celular, telefono, direc, iddep, puesto);
        
        //http://localhost:8080/tesis3/rest/actualizarUsuario?cedula=23693417&celular=04122563328&telefono=02125569987&direc=La Guaira&iddep=2&puesto=Jefe Supremo
    }
    
    @GET
    @Path("/buscarDepartamento")
    @Produces("application/json")
    public   String buscarDep () throws ClassNotFoundException, SQLException
            
    {
        return reporte.buscarDepartamento();
        
        //http://localhost:8080/tesis3/rest/buscarDepartamento
    }
    
    @GET
    @Path("/actualizarDepartamento")
    @Produces("application/json")
    public   String actualizarDep (@QueryParam("description")String description, @QueryParam("supervisor") String supervisor, @QueryParam("superemail") String superemail, @QueryParam("iddep") int iddep)
            
    {
        return reporte.actualizarDepartamento(description, supervisor, superemail, iddep);
        
         //http://localhost:8080/tesis3/rest/actualizarDepartamento?iddep=2&description=TECNOLOGIA&supervisor=Juan&superemail=juan@gmail.com
    }
    
    @GET
    @Path("/buscarHora")
    @Produces("application/json")
    public   String buscarHor (@QueryParam("fecha") String fecha, @QueryParam("hora") String hora, @QueryParam("tipo") String tipo) throws ClassNotFoundException
            
    {
        return reporte.buscarHora(fecha, hora, tipo);
        
        //http://localhost:8080/tesis3/rest/buscarHora?fecha=5/13/2018&hora=11:00:00&tipo=AM
    }
    
    @GET
    @Path("/listadoT")
    @Produces("application/json")
    public String listadoEmp () throws ClassNotFoundException, SQLException{
        
        return reporte.listadoEmpleados();
        //http://localhost:8080/tesis3/rest/listadoT
    
    }
    
    @GET
    @Path("/buscarDispositivo")
    @Produces("application/json")
    public String buscarDis () throws ClassNotFoundException, SQLException{
    
        return reporte.buscarDispositivos();
        
        //http://localhost:8080/tesis3/rest/buscarDispositivos
    
    }
    
    @GET
    @Path("/ultimosCinco")
    @Produces("application/json")
    public String ultimosCin () throws ClassNotFoundException, SQLException{
    
        return reporte.ultimosCinco();
        
        //http://localhost:8080/tesis3/rest/ultimosCinco
    
    }
  
}
