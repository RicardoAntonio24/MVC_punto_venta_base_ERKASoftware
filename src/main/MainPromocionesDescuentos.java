package main;

import models.ModelPromocionesDescuentos;
import views.ViewPromocionesDescuentos;
import controllers.ControllerPromocionesDescuentos;

/**
 *
 * @author ERKA Software
 */
public class MainPromocionesDescuentos {

    public static void main(String[] args) {

        ModelPromocionesDescuentos modelPromocionesDescuentos = new ModelPromocionesDescuentos();
        ViewPromocionesDescuentos viewPromocionesDescuentos = new ViewPromocionesDescuentos();
        ControllerPromocionesDescuentos controllerPromocionesDescuentos = new ControllerPromocionesDescuentos(modelPromocionesDescuentos, viewPromocionesDescuentos);

    }

}
