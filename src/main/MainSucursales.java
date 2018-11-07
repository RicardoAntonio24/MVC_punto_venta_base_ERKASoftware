
package main;

import models.ModelSucursales;
import views.ViewSucursales;
import controllers.ControllerSucursales;

/**
 *
 * @author ERKA Software
 */
public class MainSucursales {
    
    public static void main(String [] args) {
        
        ModelSucursales modelSucursales = new ModelSucursales();
        ViewSucursales viewSucursales = new ViewSucursales();
        ControllerSucursales controllerSucursales = new ControllerSucursales(modelSucursales, viewSucursales);
        
    }
    
}
