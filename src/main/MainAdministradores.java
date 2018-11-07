
package main;

import models.ModelAdministradores;
import views.ViewAdministradores;
import controllers.ControllerAdministradores;

/**
 *
 * @author ERKA Software
 */
public class MainAdministradores {
    
    public static void main(String [] args) {
        
        ModelAdministradores modelAdministradores = new ModelAdministradores();
        ViewAdministradores viewAdministradores = new ViewAdministradores();
        ControllerAdministradores controllerAdministradores = new ControllerAdministradores(modelAdministradores, viewAdministradores);
        
    }
    
}
