package rest;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import modelo.reportes;

/**
 *
 * @author Andrés Togni
 */

@Path("/rest")
public class rest {
    reportes reporte = new reportes();
    @GET
    @Path("/listadot")
    @Produces("application/json")
    public   String rest1 ()
            
    {   
        
     
        return reporte.reporte1() ;
    }
    
      @GET
    @Path("/rmes")
    @Produces("application/json")
    public   String rest2 ()
            
    {
        return "aa";
    }
    
      @GET
    @Path("/rfecha")
    @Produces("application/json")
    public   String rest3 ()
            
    {
        return "aa";
    }
    
    @GET
    @Path("/rtrabajador")
    @Produces("application/json")
    public   String rest4 ()
            
    {
        return "aa";
    }
    
       @GET
    @Path("/rint")
    @Produces("application/json")
    public   String rest5 ()
            
    {
        return "aa";
    }
}
