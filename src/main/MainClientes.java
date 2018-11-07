
package main;

import models.ModelClientes;
import views.ViewClientes;
import controllers.ControllerClientes;

/**
 *
 * @author ERKA Software
 */
public class MainClientes {
    
    public static void main(String [] args) {
        
        ModelClientes modelClientes = new ModelClientes();
        ViewClientes viewClientes = new ViewClientes();
        ControllerClientes controllerClientes = new ControllerClientes(modelClientes, viewClientes);
        
    }
    
}
