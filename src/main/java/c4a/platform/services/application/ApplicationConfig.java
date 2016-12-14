/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package c4a.platform.services.application;
import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author EMantziou
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application{
     @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<Class<?>>();
        // following code can be used to customize Jersey 1.x JSON provider:
        try {
            Class jacksonProvider = Class.forName("org.codehaus.jackson.jaxrs.JacksonJsonProvider");
            resources.add(jacksonProvider);
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        addRestResourceClasses(resources);
        return resources;
    }
    
     private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(c4a.platform.services.wsServices.class);
         
     }

}
