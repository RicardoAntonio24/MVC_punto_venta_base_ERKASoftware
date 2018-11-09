
package controllers;

import models.ModelAdministradores;
import views.ViewAdministradores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import models.ModelEmpleadosVentas;
import views.ViewEmpleadosVentas;

/**
 *
 * @author ERKA Software
 */
public class ControllerAdministradores {
    
    ModelAdministradores modelAdministradores;
    ViewAdministradores viewAdministradores;
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewAdministradores.jb_primero) {
                 jb_primero_actionPerformed();
            }
            else if (e.getSource() == viewAdministradores.jb_anterior) {
               jb_anterior_actionPerformed();
            }
            else if (e.getSource() == viewAdministradores.jb_siguiente) {
                jb_siguiente_actionPerformed();
            }
            else if (e.getSource() == viewAdministradores.jb_ultimo) {
               jb_ultimo_actionPerformed();
            }
            else if (e.getSource() == viewAdministradores.jb_nuevo) {
               jb_nuevo_actionPerformed();
            }
            else if (e.getSource() == viewAdministradores.jb_insertar) {
              jb_insertar_actionPerformed();
            }
            else if (e.getSource() == viewAdministradores.jb_modificar) {
                jb_modificar_actionPerformed();
            }
            else if (e.getSource() == viewAdministradores.jb_eliminar) {
//                jb_eliminar_actionPerformed();
            }
        }
    };
    
    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelAdministradores
     * @param viewAdministradores 
     */
    public ControllerAdministradores(ModelAdministradores modelAdministradores, ViewAdministradores viewAdministradores) {
            this.modelAdministradores = modelAdministradores;
            this.viewAdministradores = viewAdministradores;
            setActionListener();
            initDB();
            initComponents();
    }
    
    private void initDB() {
        modelAdministradores.conectarDB();
        String id_ad = Integer.toString(modelAdministradores.getId_admin());
        viewAdministradores.jtf_idadmin.setText(id_ad);
        
        viewAdministradores.jtf_rfc.setText(modelAdministradores.getRfc_admin());
        viewAdministradores.jtf_nombre.setText(modelAdministradores.getNombre_admin());
        viewAdministradores.jtf_apellidopat.setText(modelAdministradores.getApellido_pat_admin());
        viewAdministradores.jtf_apellidomate.setText(modelAdministradores.getApellido_mat_admin());
        
        //fecha ingreso fecha nacimiento
      
       viewAdministradores.jtf_telefono.setText(modelAdministradores.getTelefono_admin());
        viewAdministradores.jtf_calle.setText(modelAdministradores.getCalle_numero_admin());
        viewAdministradores.jtf_colonia.setText(modelAdministradores.getColonia_admin());
        viewAdministradores.jtf_codigopostal.setText(modelAdministradores.getCod_postal_admin());
        viewAdministradores.jtf_ciudad.setText(modelAdministradores.getCiudad_admin());
        viewAdministradores.jtf_estado.setText(modelAdministradores.getEstado_admin());
        viewAdministradores.jpf_passwd.setText(modelAdministradores.getContrasena_admin());
      
    }
    
    public void initComponents() {
        viewAdministradores.setLocationRelativeTo(null);
        viewAdministradores.setTitle("Administradores ACME");
        viewAdministradores.setVisible(true);
    }
    
    
    private void setActionListener() {
        viewAdministradores.jb_primero.addActionListener(actionListener);
        viewAdministradores.jb_anterior.addActionListener(actionListener);
        viewAdministradores.jb_siguiente.addActionListener(actionListener);
        viewAdministradores.jb_ultimo.addActionListener(actionListener);
        
        viewAdministradores.jb_nuevo.addActionListener(actionListener);
        viewAdministradores.jb_insertar.addActionListener(actionListener);
        viewAdministradores.jb_modificar.addActionListener(actionListener);
        viewAdministradores.jb_eliminar.addActionListener(actionListener);
    }
    
     private void setValues() {
        String id_ad = Integer.toString(modelAdministradores.getId_admin());
        viewAdministradores.jtf_idadmin.setText(id_ad);
        
        viewAdministradores.jtf_rfc.setText(modelAdministradores.getRfc_admin());
        viewAdministradores.jtf_nombre.setText(modelAdministradores.getNombre_admin());
        viewAdministradores.jtf_apellidopat.setText(modelAdministradores.getApellido_pat_admin());
        viewAdministradores.jtf_apellidomate.setText(modelAdministradores.getApellido_mat_admin());
        
        Date fecha_nac = modelAdministradores.getFecha_nac_admin();
        //viewEmpleadosVentas.jtf_apellidomaterno.setText(modelClientes.getApellido_mat());
        //viewEmpleadosVentas.jtf_telefono.setText(modelClientes.getTelefono());
        
         viewAdministradores.jtf_telefono.setText(modelAdministradores.getTelefono_admin());
         viewAdministradores.jtf_calle.setText(modelAdministradores.getCalle_numero_admin());
         viewAdministradores.jtf_colonia.setText(modelAdministradores.getColonia_admin());
         viewAdministradores.jtf_codigopostal.setText(modelAdministradores.getCod_postal_admin());
         viewAdministradores.jtf_ciudad.setText(modelAdministradores.getCiudad_admin());
         viewAdministradores.jtf_estado.setText(modelAdministradores.getEstado_admin());
         viewAdministradores.jpf_passwd.setText(modelAdministradores.getContrasena_admin());
      
    }
 
     
      private void jb_primero_actionPerformed() {
       modelAdministradores.moverPrimerRegistro();
        setValues();
    }
    
    private void jb_anterior_actionPerformed() {
        modelAdministradores.moverAnteriorRegistro();
        setValues();
    }
     
    private void jb_siguiente_actionPerformed() {
         modelAdministradores.moverSiguienteRegistro();
        setValues();
    }
     
    private void jb_ultimo_actionPerformed() {
        modelAdministradores.moverUltimoRegistro();
        setValues();
    }
    
    
     private void jb_nuevo_actionPerformed() {
         
        viewAdministradores.jtf_rfc.setText("");
        viewAdministradores.jtf_nombre.setText("");
        viewAdministradores.jtf_apellidopat.setText("");
        viewAdministradores.jtf_apellidomate.setText("");
       //fecha nacimiento
        viewAdministradores.jcb_dia.setSelectedIndex(0);
        viewAdministradores.jcb_mes.setSelectedIndex(0);
      
       //fecha ingreso
        viewAdministradores.jcb_diain.setSelectedIndex(0);
        viewAdministradores.jcb_mesin.setSelectedIndex(0);
       
       
       viewAdministradores.jtf_telefono.setText("");
        viewAdministradores.jtf_calle.setText("");
        viewAdministradores.jtf_colonia.setText("");
        viewAdministradores.jtf_codigopostal.setText("");
        viewAdministradores.jtf_ciudad.setText("");
        viewAdministradores.jtf_estado.setText("");
        viewAdministradores.jpf_passwd.setText("");
       
    }
    
     private void jb_insertar_actionPerformed() {
         modelAdministradores.setRfc_admin(viewAdministradores.jtf_rfc.getText());
        modelAdministradores.setNombre_admin(viewAdministradores.jtf_nombre.getText());
         modelAdministradores.setApellido_pat_admin(viewAdministradores.jtf_apellidopat.getText());
         modelAdministradores.setApellido_mat_admin(viewAdministradores.jtf_apellidomate.getText());
        
        //fecha nacimiento y empleado
     
        modelAdministradores.setTelefono_admin(viewAdministradores.jtf_telefono.getText());
        modelAdministradores.setCalle_numero_admin(viewAdministradores.jtf_colonia.getText());
        modelAdministradores.setCod_postal_admin(viewAdministradores.jtf_codigopostal.getText());
        modelAdministradores.setCiudad_admin(viewAdministradores.jtf_ciudad.getText());
        modelAdministradores.setEstado_admin(viewAdministradores.jtf_estado.getText());
        
        
        modelAdministradores.insertarRegistro(); 
    } 
     
     
     private void jb_modificar_actionPerformed() {
       modelAdministradores.setRfc_admin(viewAdministradores.jtf_rfc.getText());
       modelAdministradores.setNombre_admin(viewAdministradores.jtf_nombre.getText());
        modelAdministradores.setApellido_pat_admin(viewAdministradores.jtf_apellidopat.getText());
        modelAdministradores.setApellido_mat_admin(viewAdministradores.jtf_apellidomate.getText());
        
   //fecha nacimiento emplmodelAdministradoreseado
     
        modelAdministradores.setTelefono_admin(viewAdministradores.jtf_telefono.getText());
        modelAdministradores.setCalle_numero_admin(viewAdministradores.jtf_colonia.getText());
        modelAdministradores.setCod_postal_admin(viewAdministradores.jtf_codigopostal.getText());
        modelAdministradores.setCiudad_admin(viewAdministradores.jtf_ciudad.getText());
        modelAdministradores.setEstado_admin(viewAdministradores.jtf_estado.getText());
        
        modelAdministradores.modificarRegistro(); 
    }
}
