/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrest;

import static javax.swing.text.html.FormSubmitEvent.MethodType.GET;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author fabio
 */
@Path("hello")
public class HelloResource {

    /**
     *
     * @return
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get(){
        return "Hello World";
    }
    
    @GET
    @Path("pt-br")
    public String getEmPortugues(){
        return "Ola Mundo!";
    }
    
    @GET
    @Path("de")
    public String getEmAlemao(){
        return "Hallo Welt!";
    }
    
    @GET
    @Path("es")
    public String getEmEspanhol(){
        return "Hola Mundo!";
    }
}
