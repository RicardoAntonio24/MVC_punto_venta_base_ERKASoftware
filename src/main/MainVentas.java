
package main;

import models.ModelVentas;
import views.ViewVentas;
import controllers.ControllerVentas;

/**
 *
 * @author ERKA Software
 */
public class MainVentas {
    
    public static void main(String [] args) {
        
        ModelVentas modelVentas = new ModelVentas();
        ViewVentas viewVentas = new ViewVentas();
        ControllerVentas controllerVentas = new ControllerVentas(modelVentas, viewVentas);
        
    }
    
}
