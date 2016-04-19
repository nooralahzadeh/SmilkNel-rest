/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.inria.smilk.ws.smilknel.rest.exception;

import fr.inria.smilk.ws.smilknel.rest.model.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
 
/**
 *
 * @author fnoorala
 */
//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable>{
    
    
      @Override
    public Response toResponse(Throwable e) {
        
        ErrorMessage errorMessage=new ErrorMessage(e.getMessage(), 500, "http://javabrains.koushik.org");
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(errorMessage).build();
    }
}
