
package main;

import models.ModelReportes;
import views.ViewReportes;
import controllers.ControllerReportes;

/**
 *
 * @author ERKA Software
 */
public class MainReportes {
    
    public static void main(String [] args) {
        
        ModelReportes modelReportes = new ModelReportes();
        ViewReportes viewReportes = new ViewReportes();
        ControllerReportes controllerReportes = new ControllerReportes(modelReportes, viewReportes);
        
    }
    
}
