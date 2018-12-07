
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelMain;
import views.ViewMain;

/**
 *
 * @author ERKA Software
 */
public class ControllerMain {
    
    ModelMain modelMain;
    ViewMain viewMain;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewMain.jb_respaldo) {
                jb_respaldo_actionPerformed();
            }
//            else if (e.getSource() == viewAdministradores.jb_anterior) {
//               jb_anterior_actionPerformed();
//            }
//            else if (e.getSource() == viewAdministradores.jb_siguiente) {
//                jb_siguiente_actionPerformed();
//            }
//            else if (e.getSource() == viewAdministradores.jb_ultimo) {
//               jb_ultimo_actionPerformed();
//            }
//            else if (e.getSource() == viewAdministradores.jb_nuevo) {
//               jb_nuevo_actionPerformed();
//            }
//            else if (e.getSource() == viewAdministradores.jb_insertar) {
//                jb_insertar_actionPerformed();
//            }
//            else if (e.getSource() == viewAdministradores.jb_modificar) {
//                jb_modificar_actionPerformed();
//            }
//            else if (e.getSource() == viewAdministradores.jb_eliminar) {
////                jb_eliminar_actionPerformed();
//            }
        }
    };
    

    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelMain
     * @param viewMain 
     */
    public ControllerMain(ModelMain modelMain, ViewMain viewMain) {
        this.modelMain = modelMain;
        this.viewMain = viewMain;
        setActionListener();
        initDB();
        initComponents();
    }
    
    private void initDB() {
        
    }
    
    public void initComponents() {
        viewMain.setLocationRelativeTo(null);
        viewMain.setTitle("Menú Principal");
        viewMain.setVisible(true);
    }
    
    
    private void setActionListener() {
        viewMain.jb_respaldo.addActionListener(actionListener);
        
//        viewAdministradores.jb_anterior.addActionListener(actionListener);
//        viewAdministradores.jb_siguiente.addActionListener(actionListener);
//        viewAdministradores.jb_ultimo.addActionListener(actionListener);
//        viewAdministradores.jb_nuevo.addActionListener(actionListener);
//        viewAdministradores.jb_insertar.addActionListener(actionListener);
//        viewAdministradores.jb_modificar.addActionListener(actionListener);
//        viewAdministradores.jb_eliminar.addActionListener(actionListener);
    }
    
     private void setValues() {
         
     }
     
     
     /**
      * 
      */
     private void jb_respaldo_actionPerformed() {
        modelMain.generarRespaldo(); // Llama al método para generar el respaldo (backup) de la BD.
     }
     
     
     
} // Cierre de la clase ControllerMain
