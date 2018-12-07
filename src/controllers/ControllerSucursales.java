
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelMain;
import models.ModelSucursales;
import views.ViewMain;
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
            else if (e.getSource() == viewSucursales.jb_menuprincipal) {
                jb_menuprincipal_actionPerformed();
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
     private void initComponents() {
                viewSucursales.setLocationRelativeTo(null);
        viewSucursales.setTitle("Sucursales ACME");
        viewSucursales.setVisible(true);
            }
        private void setActionListener() {
               viewSucursales.jb_primero.addActionListener(actionListener);
        viewSucursales.jb_anterior.addActionListener(actionListener);
        viewSucursales.jb_siguiente.addActionListener(actionListener);
        viewSucursales.jb_ultimo.addActionListener(actionListener);
        
        viewSucursales.jb_nuevo.addActionListener(actionListener);
        viewSucursales.jb_insertar.addActionListener(actionListener);
        viewSucursales.jb_modificar.addActionListener(actionListener);
        viewSucursales.jb_menuprincipal.addActionListener(actionListener);
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
        viewSucursales.jtf_nombre.setText("");
        viewSucursales.jtf_telefono.setText("");
        viewSucursales.jtf_calle.setText("");
        viewSucursales.jtf_colonia.setText("");
        viewSucursales.jtf_codigopostal.setText("");
        viewSucursales.jtf_ciudad.setText("");
        viewSucursales.jcb_estado.setSelectedIndex(0);
            }

            private void jb_insertar_actionPerformed() {
         // Asigna los valores introducidos en la vista a las variables del modelo. (13)
        modelSucursales.setNombre(viewSucursales.jtf_nombre.getText());
        modelSucursales.setTelefono(viewSucursales.jtf_telefono.getText());
        modelSucursales.setCalle(viewSucursales.jtf_calle.getText());
        modelSucursales.setColonia(viewSucursales.jtf_colonia.getText());
        modelSucursales.setCod_postal(viewSucursales.jtf_codigopostal.getText());
        modelSucursales.setCiudad(viewSucursales.jtf_ciudad.getText());
        modelSucursales.setEstado((String) viewSucursales.jcb_estado.getSelectedItem());
        modelSucursales.insertarRegistro(); // Invoca al método para Guardar o Insertar un nuevo registro en la tabla proveedores.
            }

            private void jb_modificar_actionPerformed() {
        modelSucursales.setNombre(viewSucursales.jtf_nombre.getText());
        modelSucursales.setTelefono(viewSucursales.jtf_telefono.getText());
        modelSucursales.setCalle(viewSucursales.jtf_calle.getText());
        modelSucursales.setColonia(viewSucursales.jtf_colonia.getText());
        modelSucursales.setCod_postal(viewSucursales.jtf_codigopostal.getText());
        modelSucursales.setCiudad(viewSucursales.jtf_ciudad.getText());
        modelSucursales.setEstado((String) viewSucursales.jcb_estado.getSelectedItem());
        modelSucursales.modificarRegistro(); // Invoca al método para Modificar (actualizar) un registro.
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
    
    
    
    private void jb_menuprincipal_actionPerformed() {
        ModelMain modelMain = new ModelMain();
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(modelMain, viewMain);
        viewSucursales.setVisible(false);
    }
        

}    
