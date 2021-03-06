package com.restfully.kampusupgrade.services;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Mathijs
 */
@javax.ws.rs.ApplicationPath("/services") 
public class ApplicationConfig extends Application {
    
    private Set<Object> singletons = new HashSet<Object>();
    private Set<Class<?>> resources = new java.util.HashSet<>();

    public ApplicationConfig() {
        singletons.add(new BuildingResourceService());
        singletons.add(new RoomResourceService());
        singletons.add(new ScreenResourceService());
        
    }
    
    @Override
    public Set<Class<?>> getClasses() {
        //addRestResourceClasses(resources);
        return resources;
    }
    
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
    }
    
}
