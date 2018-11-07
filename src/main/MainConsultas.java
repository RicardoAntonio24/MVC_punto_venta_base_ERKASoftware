
package main;

import models.ModelConsultas;
import views.ViewConsultas;
import controllers.ControllerConsultas;

/**
 *
 * @author ERKA Software
 */
public class MainConsultas {
    
    public static void main(String [] args) {
        
        ModelConsultas modelConsultas = new ModelConsultas();
        ViewConsultas viewConsultas = new ViewConsultas();
        ControllerConsultas controllerConsultas = new ControllerConsultas(modelConsultas, viewConsultas);
        
    }
    
}
