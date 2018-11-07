
package main;

import models.ModelInicioSesion;
import views.ViewInicioSesion;
import controllers.ControllerInicioSesion;

/**
 *
 * @author ERKA Software
 */
public class MainInicioSesion {
    
    public static void main(String [] args) {
        
        ModelInicioSesion modelInicioSesion = new ModelInicioSesion();
        ViewInicioSesion viewInicioSesion = new ViewInicioSesion();
        ControllerInicioSesion controllerInicioSesion = new ControllerInicioSesion(modelInicioSesion, viewInicioSesion);
        
    }
    
}
