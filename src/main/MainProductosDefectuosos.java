package main;

import models.ModelProductosDefectuosos;
import views.ViewProductosDefectuosos;
import controllers.ControllerProductosDefectuosos;

/**
 *
 * @author ERKA Software
 */
public class MainProductosDefectuosos {

    public static void main(String[] args) {

        ModelProductosDefectuosos modelProductosDefectuosos = new ModelProductosDefectuosos();
        ViewProductosDefectuosos viewProductosDefectuosos = new ViewProductosDefectuosos();
        ControllerProductosDefectuosos controllerProductosDefectuosos = new ControllerProductosDefectuosos(modelProductosDefectuosos, viewProductosDefectuosos);

    }

}
