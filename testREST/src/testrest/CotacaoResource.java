/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testrest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author fabio
 */
@Path("cotacao")
public class CotacaoResource {
    @Path("{moeda1}/{moeda2}")
    @GET
    @Produces
    public String retornarCotacao(@PathParam("moeda1") String m1,@PathParam("moeda2") String m2){
        String det = "deve retornar a cotacao de "+m1+" para "+m2;
        return det;
    }
}
