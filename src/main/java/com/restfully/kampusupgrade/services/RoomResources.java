/*
 * HvA licences apply
 */
package com.restfully.kampusupgrade.services;

/**
 *
 * @author Mathijs
 */
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;

/**
 *
 * @author boofk
 */
@Path("/room")
public interface RoomResources {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public StreamingOutput getRoom();
    
    
    
}
