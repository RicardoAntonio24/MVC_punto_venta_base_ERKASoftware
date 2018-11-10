
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelSucursales;
import views.ViewSucursales;


/**
 *
 * @author ERKA Software
 */
public class ControllerSucursales {
     ModelSucursales modelSucursales;
    ViewSucursales viewSucursales;
/**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewSucursales.jb_primero) {
                jb_primero_actionPerformed();
            }
            else if (e.getSource() == viewSucursales.jb_anterior) {
                jb_anterior_actionPerformed();
            }
            else if (e.getSource() == viewSucursales.jb_siguiente) {
                jb_siguiente_actionPerformed();
            }
            else if (e.getSource() == viewSucursales.jb_ultimo) {
                jb_ultimo_actionPerformed();
            }
            else if (e.getSource() == viewSucursales.jb_nuevo) {
                jb_nuevo_actionPerformed();
            }
            else if (e.getSource() == viewSucursales.jb_insertar) {
                jb_insertar_actionPerformed();
            }
            else if (e.getSource() == viewSucursales.jb_modificar) {
                jb_modificar_actionPerformed();
            }
            else if (e.getSource() == viewSucursales.jb_eliminar) {
//                jb_eliminar_actionPerformed();
            }
        }
    };
    
    
    
    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelSucursales
     * @param viewSucursales 
     */
    public ControllerSucursales(ModelSucursales modelSucursales, ViewSucursales viewSucursales) {
        this.modelSucursales = modelSucursales;
        this.viewSucursales = viewSucursales;
        setActionListener();
        initDB();
        initComponents();
    }
    
    
     /**
     * Método que llama al método conectarBD del modelo y muestra los datos
     * del primer registro en las cajas de texto de ViewSucursales.
     */
    private void initDB() {
                modelSucursales.conectarDB();
        String id_sucursal = Integer.toString(modelSucursales.getId_sucursal());
        viewSucursales.jtf_idsucursal.setText(id_sucursal);
        
        viewSucursales.jtf_nombre.setText(modelSucursales.getNombre());
        viewSucursales.jtf_telefono.setText(modelSucursales.getTelefono());
        viewSucursales.jtf_calle.setText(modelSucursales.getCalle());
        viewSucursales.jtf_colonia.setText(modelSucursales.getColonia());
        viewSucursales.jtf_codigopostal.setText(modelSucursales.getCod_postal());
        viewSucursales.jcb_estado.setSelectedItem(modelSucursales.getEstado());
        viewSucursales.jtf_ciudad.setText(modelSucursales.getCiudad());      
            }
        

            private void jb_primero_actionPerformed() {
                 modelSucursales.moverPrimerRegistro();
        setValues();
            }

            private void jb_anterior_actionPerformed() {
               modelSucursales.moverAnteriorRegistro();
        setValues();
            }

            private void jb_siguiente_actionPerformed() {
                modelSucursales.moverSiguienteRegistro();
        setValues();
            }

            private void jb_ultimo_actionPerformed() {
                modelSucursales.moverUltimoRegistro();
        setValues();
            }

            private void jb_nuevo_actionPerformed() {
                
        viewSucursales.jtf_idsucursal.setText("");
        viewSucursales.jtf_nombre.setText("");
        viewSucursales.jtf_telefono.setText("");
        viewSucursales.jtf_calle.setText("");
        viewSucursales.jtf_colonia.setText("");
        viewSucursales.jtf_codigopostal.setText("");
        viewSucursales.jtf_ciudad.setText("");
        viewSucursales.jcb_estado.setSelectedIndex(0);
            }

            private void jb_insertar_actionPerformed() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            private void jb_modificar_actionPerformed() {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            private void setActionListener() {
               viewSucursales.jb_primero.addActionListener(actionListener);
        viewSucursales.jb_anterior.addActionListener(actionListener);
        viewSucursales.jb_siguiente.addActionListener(actionListener);
        viewSucursales.jb_ultimo.addActionListener(actionListener);
        
        viewSucursales.jb_nuevo.addActionListener(actionListener);
        viewSucursales.jb_insertar.addActionListener(actionListener);
        viewSucursales.jb_modificar.addActionListener(actionListener);
        viewSucursales.jb_eliminar.addActionListener(actionListener);
            }

            

            private void initComponents() {
                viewSucursales.setLocationRelativeTo(null);
        viewSucursales.setTitle("Sucursales ACME");
        viewSucursales.setVisible(true);
            }

    private void setValues() {
         String id_sucursal = Integer.toString(modelSucursales.getId_sucursal());
        viewSucursales.jtf_idsucursal.setText(id_sucursal);
        
        viewSucursales.jtf_nombre.setText(modelSucursales.getNombre());
        viewSucursales.jtf_telefono.setText(modelSucursales.getTelefono());
        viewSucursales.jtf_calle.setText(modelSucursales.getCalle());
        viewSucursales.jtf_colonia.setText(modelSucursales.getColonia());
        viewSucursales.jtf_codigopostal.setText(modelSucursales.getCod_postal());
        viewSucursales.jcb_estado.setSelectedItem(modelSucursales.getEstado());
        viewSucursales.jtf_ciudad.setText(modelSucursales.getCiudad()); 
    }
        

}    
