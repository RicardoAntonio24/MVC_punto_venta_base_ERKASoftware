
package main;

import controllers.ControllerEmpleadosVentas;
import models.ModelEmpleadosVentas;
import views.ViewEmpleadosVentas;

/**
 *
 * @author ERKA Software
 */
public class MainEmpleadosVentas {
    
    public static void main(String [] args) {
        
        ModelEmpleadosVentas modelEmpleadosVentas = new ModelEmpleadosVentas();
        ViewEmpleadosVentas viewEmpleadosVentas = new ViewEmpleadosVentas();
        ControllerEmpleadosVentas controllerEmpleadosVentas = new ControllerEmpleadosVentas(modelEmpleadosVentas, viewEmpleadosVentas);
        
    }
    
}
