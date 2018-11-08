
package controllers;

import models.ModelEmpleadosVentas;
import views.ViewEmpleadosVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

public class ControllerEmpleadosVentas {
    ModelEmpleadosVentas modelEmpleadosVentas;
    ViewEmpleadosVentas viewEmpleadosVentas;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewEmpleadosVentas.jb_primero1) {
                jb_primero1_actionPerformed();
            }
            else if (e.getSource() == viewEmpleadosVentas.jb_anterior1) {
                jb_anterior1_actionPerformed();
            }
            else if (e.getSource() == viewEmpleadosVentas.jb_siguiente1) {
                jb_siguiente1_actionPerformed();
            }
            else if (e.getSource() == viewEmpleadosVentas.jb_ultimo1) {
                jb_ultimo1_actionPerformed();
            }
            else if (e.getSource() == viewEmpleadosVentas.jb_nuevo1) {
                jb_nuevo1_actionPerformed();
            }
            else if (e.getSource() == viewEmpleadosVentas.jb_insertar1) {
                jb_insertar1_actionPerformed();
            }
            else if (e.getSource() == viewEmpleadosVentas.jb_modificar1) {
                jb_modificar1_actionPerformed();
            }
            else if (e.getSource() == viewEmpleadosVentas.jb_eliminar) {
//                jb_eliminar_actionPerformed();
            }
        }
    };
   
    
    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelEmpleadosVentas
     * @param viewEmpleadosVentas 
     */
    public ControllerEmpleadosVentas(ModelEmpleadosVentas modelEmpleadosVentas, ViewEmpleadosVentas viewEmpleadosVentas) {
            this.modelEmpleadosVentas = modelEmpleadosVentas;
            this.viewEmpleadosVentas = viewEmpleadosVentas;
            setActionListener();
            initDB();
            initComponents();
    }
    
    private void initDB() {
        modelEmpleadosVentas.conectarDB();
        String id_c = Integer.toString(modelEmpleadosVentas.getId_empleado());
        viewEmpleadosVentas.jtf_idempleados.setText(id_c);
        
        viewEmpleadosVentas.jtf_rfc1.setText(modelEmpleadosVentas.getRfc_empleado());
        viewEmpleadosVentas.jtf_nombre1.setText(modelEmpleadosVentas.getNombre_empleado());
        viewEmpleadosVentas.jtf_apellidopat1.setText(modelEmpleadosVentas.getApellido_pat_empleado());
        viewEmpleadosVentas.jtf_apellidomate1.setText(modelEmpleadosVentas.getApellido_mat_empleado());
        
        //fecha ingreso fecha nacimiento
      
        viewEmpleadosVentas.jtf_telefono1.setText(modelEmpleadosVentas.getTelefono_empleado());
        viewEmpleadosVentas.jtf_calle1.setText(modelEmpleadosVentas.getCalle_numero_empleado());
        viewEmpleadosVentas.jtf_colonia1.setText(modelEmpleadosVentas.getColonia_empleado());
        viewEmpleadosVentas.jtf_codigopostal1.setText(modelEmpleadosVentas.getCod_postal_empleado());
        viewEmpleadosVentas.jtf_ciudad1.setText(modelEmpleadosVentas.getCiudad_empleado());
        viewEmpleadosVentas.jtf_estado1.setText(modelEmpleadosVentas.getEstado_empleado());
        viewEmpleadosVentas.jpf_passwd1.setText(modelEmpleadosVentas.getContrasena_empleado());
      
    }
    
    public void initComponents() {
        viewEmpleadosVentas.setLocationRelativeTo(null);
        viewEmpleadosVentas.setTitle("Empleados Ventas ACME");
        viewEmpleadosVentas.setVisible(true);
    }


     private void setActionListener() {
        viewEmpleadosVentas.jb_primero1.addActionListener(actionListener);
        viewEmpleadosVentas.jb_anterior1.addActionListener(actionListener);
        viewEmpleadosVentas.jb_siguiente1.addActionListener(actionListener);
        viewEmpleadosVentas.jb_ultimo1.addActionListener(actionListener);
        
        viewEmpleadosVentas.jb_nuevo1.addActionListener(actionListener);
        viewEmpleadosVentas.jb_insertar1.addActionListener(actionListener);
        viewEmpleadosVentas.jb_modificar1.addActionListener(actionListener);
        viewEmpleadosVentas.jb_eliminar1.addActionListener(actionListener);
    }

     private void setValues() {
        String id_em = Integer.toString(modelEmpleadosVentas.getId_empleado());
        viewEmpleadosVentas.jtf_idempleados.setText(id_em);
        
        viewEmpleadosVentas.jtf_rfc1.setText(modelEmpleadosVentas.getRfc_empleado());
        viewEmpleadosVentas.jtf_nombre1.setText(modelEmpleadosVentas.getNombre_empleado());
        viewEmpleadosVentas.jtf_apellidopat1.setText(modelEmpleadosVentas.getApellido_pat_empleado());
        viewEmpleadosVentas.jtf_apellidomate1.setText(modelEmpleadosVentas.getApellido_mat_empleado());
        
        Date fecha_nac = modelEmpleadosVentas.getFecha_nac_empleado();
        //viewEmpleadosVentas.jtf_apellidomaterno.setText(modelClientes.getApellido_mat());
        //viewEmpleadosVentas.jtf_telefono.setText(modelClientes.getTelefono());
        
        viewEmpleadosVentas.jtf_telefono1.setText(modelEmpleadosVentas.getTelefono_empleado());
        viewEmpleadosVentas.jtf_calle1.setText(modelEmpleadosVentas.getCalle_numero_empleado());
        viewEmpleadosVentas.jtf_colonia1.setText(modelEmpleadosVentas.getColonia_empleado());
        viewEmpleadosVentas.jtf_codigopostal1.setText(modelEmpleadosVentas.getCod_postal_empleado());
        viewEmpleadosVentas.jtf_ciudad1.setText(modelEmpleadosVentas.getCiudad_empleado());
        viewEmpleadosVentas.jtf_estado1.setText(modelEmpleadosVentas.getEstado_empleado());
        viewEmpleadosVentas.jpf_passwd1.setText(modelEmpleadosVentas.getContrasena_empleado());
      
    }
     
     
     private void jb_primero1_actionPerformed() {
       modelEmpleadosVentas.moverPrimerRegistro();
        setValues();
    }
    
    private void jb_anterior1_actionPerformed() {
        modelEmpleadosVentas.moverAnteriorRegistro();
        setValues();
    }
     
    private void jb_siguiente1_actionPerformed() {
         modelEmpleadosVentas.moverSiguienteRegistro();
        setValues();
    }
     
    private void jb_ultimo1_actionPerformed() {
        modelEmpleadosVentas.moverUltimoRegistro();
        setValues();
    }
    
     private void jb_nuevo1_actionPerformed() {
         
        viewEmpleadosVentas.jtf_rfc1.setText("");
        viewEmpleadosVentas.jtf_nombre1.setText("");
        viewEmpleadosVentas.jtf_apellidopat1.setText("");
        viewEmpleadosVentas.jtf_apellidomate1.setText("");
       //fecha nacimiento
        viewEmpleadosVentas.jcb_dia1.setSelectedIndex(0);
        viewEmpleadosVentas.jcb_mes1.setSelectedIndex(0);
      
       //fecha ingreso
        viewEmpleadosVentas.jcb_diain1.setSelectedIndex(0);
        viewEmpleadosVentas.jcb_mesin1.setSelectedIndex(0);
       
       
        viewEmpleadosVentas.jtf_telefono1.setText("");
        viewEmpleadosVentas.jtf_calle1.setText("");
        viewEmpleadosVentas.jtf_colonia1.setText("");
        viewEmpleadosVentas.jtf_codigopostal1.setText("");
        viewEmpleadosVentas.jtf_ciudad1.setText("");
        viewEmpleadosVentas.jtf_estado1.setText("");
        viewEmpleadosVentas.jpf_passwd1.setText("");
       
    }
     
    private void jb_insertar1_actionPerformed() {
        modelEmpleadosVentas.setRfc_empleado(viewEmpleadosVentas.jtf_rfc1.getText());
       modelEmpleadosVentas.setNombre_empleado(viewEmpleadosVentas.jtf_nombre1.getText());
        modelEmpleadosVentas.setApellido_pat_empleado(viewEmpleadosVentas.jtf_apellidopat1.getText());
        modelEmpleadosVentas.setApellido_mat_empleado(viewEmpleadosVentas.jtf_apellidomate1.getText());
        
        //fecha nacimiento y empleado
     
        modelEmpleadosVentas.setTelefono_empleado(viewEmpleadosVentas.jtf_telefono1.getText());
        modelEmpleadosVentas.setCalle_numero_empleado(viewEmpleadosVentas.jtf_colonia1.getText());
        modelEmpleadosVentas.setCod_postal_empleado(viewEmpleadosVentas.jtf_codigopostal1.getText());
        modelEmpleadosVentas.setCiudad_empleado(viewEmpleadosVentas.jtf_ciudad1.getText());
        modelEmpleadosVentas.setEstado_empleado(viewEmpleadosVentas.jtf_estado1.getText());
        
        
        modelEmpleadosVentas.insertarRegistro(); 
    } 
    
    private void jb_modificar1_actionPerformed() {
       modelEmpleadosVentas.setRfc_empleado(viewEmpleadosVentas.jtf_rfc1.getText());
       modelEmpleadosVentas.setNombre_empleado(viewEmpleadosVentas.jtf_nombre1.getText());
        modelEmpleadosVentas.setApellido_pat_empleado(viewEmpleadosVentas.jtf_apellidopat1.getText());
        modelEmpleadosVentas.setApellido_mat_empleado(viewEmpleadosVentas.jtf_apellidomate1.getText());
        
   //fecha nacimiento empleado
     
        modelEmpleadosVentas.setTelefono_empleado(viewEmpleadosVentas.jtf_telefono1.getText());
        modelEmpleadosVentas.setCalle_numero_empleado(viewEmpleadosVentas.jtf_colonia1.getText());
        modelEmpleadosVentas.setCod_postal_empleado(viewEmpleadosVentas.jtf_codigopostal1.getText());
        modelEmpleadosVentas.setCiudad_empleado(viewEmpleadosVentas.jtf_ciudad1.getText());
        modelEmpleadosVentas.setEstado_empleado(viewEmpleadosVentas.jtf_estado1.getText());
        
        modelEmpleadosVentas.modificarRegistro(); 
    }
     
     
}
