package main;

import models.ModelProveedores;
import views.ViewProveedores;
import controllers.ControllerProveedores;

/**
 *
 * @author ERKA Software
 */
public class MainProveedores {

    public static void main(String[] args) {

        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        ControllerProveedores controllerProveedores = new ControllerProveedores(modelProveedores, viewProveedores);

    }

}
