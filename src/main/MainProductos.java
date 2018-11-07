package main;

import models.ModelProductos;
import views.ViewProductos;
import controllers.ControllerProductos;

/**
 *
 * @author ERKA Software
 */
public class MainProductos {

    public static void main(String[] args) {
        
        ModelProductos modelProductos = new ModelProductos();
        ViewProductos viewProductos = new ViewProductos();
        ControllerProductos controllerProductos = new ControllerProductos(modelProductos, viewProductos);
        
    }

}
