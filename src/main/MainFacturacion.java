
package main;

import controllers.ControllerFacturacion;
import models.ModelFacturacion;
import views.ViewFacturacion;

/**
 *
 * @author ERKA Software
 */
public class MainFacturacion {
    
    public static void main(String [] args) {
        
        ModelFacturacion modelFacturacion = new ModelFacturacion();
        ViewFacturacion viewFacturacion = new ViewFacturacion();
        ControllerFacturacion controllerFacturacion = new ControllerFacturacion(modelFacturacion, viewFacturacion);
        
    }
    
}
