/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.inria.smilk.ws.smilknel.rest.exception;

import fr.inria.smilk.ws.smilknel.rest.model.ErrorMessage;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
 

/**
 *
 * @author fnoorala
 */
@Provider
public class DataNotFoundExceptionMapper implements ExceptionMapper<DataNotFoundException>{

    @Override
    public Response toResponse(DataNotFoundException e) {
        
        ErrorMessage errorMessage=new ErrorMessage(e.getMessage(), 404, "");
        return Response.status(Status.NOT_FOUND).entity(errorMessage.toJson()).build();
    }
    
}
