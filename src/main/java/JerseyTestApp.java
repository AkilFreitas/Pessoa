/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Val
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *
 * @author pronatec
 */
@ApplicationPath("/") 

public class JerseyTestApp extends Application {     

@Override     

public Set<Class<?>> getClasses()     {         

final Set<Class<?>> classes = new HashSet<>();         

classes.add(MyApplicationController.class);         

return classes;     

}

 }
