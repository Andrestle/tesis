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
public class data {
  
  public String id="";
  public String cedula=""; 
  public String nombre= "";
  public String cargo="";
  public String telefono="";
            
    public data(String a , String b, String c, String d)
    {
        id=a;
        cedula=b;
        nombre =c; 
        telefono=d;   
    }

    public data(String a, String b, String c) {
        id=a;
        nombre=b;
        cargo=c;
    }
    
}
