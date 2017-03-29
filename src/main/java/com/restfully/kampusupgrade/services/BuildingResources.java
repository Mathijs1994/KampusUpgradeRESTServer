package com.restfully.kampusupgrade.services;

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
 * @author Mathijs
 */
@Path("/building")
public interface BuildingResources {
    
    @GET
    @Produces(MediaType.APPLICATION_XML)
    public StreamingOutput getBuilding();
    
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_XML)
    public StreamingOutput getBuilding(@PathParam("id") int id);
    
    @GET
    @Path("/city/{city}")
    @Produces(MediaType.APPLICATION_XML)
    public StreamingOutput getBuilding(@PathParam("city") String city);
    
    @GET
    @Path("/street/{street}")
    @Produces(MediaType.APPLICATION_XML)
    public StreamingOutput getBuildingByStreet(@PathParam("street") String street);
    
    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_XML)
    public StreamingOutput getBuildingByName(@PathParam("name") String name);
    
    
    
  /*  @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createCustomer(InputStream is);
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_XML)
    public void updateCustomer(@PathParam("id") int id, InputStream is);
    
    */
}
