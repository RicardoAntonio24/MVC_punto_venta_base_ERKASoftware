
package main;

import models.ModelMain;
import views.ViewMain;
import controllers.ControllerMain;

/**
 *
 * @author ERKA Software
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ModelMain modelMain = new ModelMain();
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(modelMain, viewMain);
        
    } // Cierre del método main.
    
} // Cierre de la clase Main.
