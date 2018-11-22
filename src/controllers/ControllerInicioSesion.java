
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelInicioSesion;
import views.ViewInicioSesion;

/**
 *
 * @author ERKA Software
 */
public class ControllerInicioSesion {

    ModelInicioSesion modelInicioSesion;
    ViewInicioSesion viewInicioSesion;
    
    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelInicioSesion
     * @param viewInicioSesion 
     */
    public ControllerInicioSesion(ModelInicioSesion modelInicioSesion, ViewInicioSesion viewInicioSesion) {
        this.modelInicioSesion = modelInicioSesion;
        this.viewInicioSesion = viewInicioSesion;
        setActionListener();
//        initDB();
        initComponents();
    }
    
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewInicioSesion.jb_iniciar) {
                jb_iniciar_actionPerformed();
            }
        }
    };
    
    
    /**
     * Metodo para inicializar la ViewInicioSesion
     */
    public void initComponents() {
        viewInicioSesion.setLocationRelativeTo(null);
        viewInicioSesion.setTitle("Login - Sistema Ferretería ACME");
        viewInicioSesion.setVisible(true);
    }
    
    /**
     * Método para agregar el actionListener al boton de Inicio de Sesión de la vista
     */
    private void setActionListener() {
        viewInicioSesion.jb_iniciar.addActionListener(actionListener);
    }
    
    
    /**
     * Traslada los valores introducidos en la vista (viewInicioSesion) a las variables del modelo (modelInicioSesion).
     */
    private void valoresIngreso() {
        modelInicioSesion.setNom_usuario(viewInicioSesion.jtf_usuario.getText());
        modelInicioSesion.setContrasena(viewInicioSesion.jpf_passwd.getText());
        modelInicioSesion.setRol((String) viewInicioSesion.jcb_tipousuario.getSelectedItem());
    }
    
    /**
     * Llama al método encargado de asignar valores y posteriormente al método para combrobar si los valores existen en la BD (verificación en el model).
     */
    private void jb_iniciar_actionPerformed() {
        valoresIngreso();
//          System.out.println("  Valores asignados !!");
        modelInicioSesion.iniciarSesion();
//          System.out.println("  Método llamado !!");
        // Código para acceder al menú principal (en caso de ingreso permitido)...
        
    }
    
    
    
} // Cierre de la clase ControllerInicioSesion.
