
package main;

import models.ModelCotizaciones;
import views.ViewCotizaciones;
import controllers.ControllerCotizaciones;

/**
 *
 * @author ERKA Software
 */
public class MainCotizaciones {
    
    public static void main(String [] args) {
        
        ModelCotizaciones modelCotizaciones = new ModelCotizaciones();
        ViewCotizaciones viewCotizaciones = new ViewCotizaciones();
        ControllerCotizaciones controllerCotizaciones = new ControllerCotizaciones(modelCotizaciones, viewCotizaciones);
        
    }
    
}
