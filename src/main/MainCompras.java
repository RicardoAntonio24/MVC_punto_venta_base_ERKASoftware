
package main;

import models.ModelCompras;
import views.ViewCompras;
import controllers.ControllerCompras;

/**
 *
 * @author ERKA Software
 */
public class MainCompras {
    
    public static void main(String [] args) {
        
        ModelCompras modelCompras = new ModelCompras();
        ViewCompras viewCompras = new ViewCompras();
        ControllerCompras controllerCompras = new ControllerCompras(modelCompras, viewCompras);
        
    }
    
}
