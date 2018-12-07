
package controllers;

import models.ModelAdministradores;
import views.ViewAdministradores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ModelEmpleadosVentas;
import models.ModelMain;
import views.ViewEmpleadosVentas;
import views.ViewMain;

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
            else if (e.getSource() == viewAdministradores.jb_menuprincipal) {
                jb_menuprincipal_actionPerformed();
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
        
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_nac = modelAdministradores.getFecha_nac_admin();
        String fecha_nac_cad = fecha.format(fecha_nac); // Convierte la fecha correspondiente a String
        String [] afecha1 = fecha_nac_cad.split("-"); // Separa los componentes de la fecha (año-mes-día)
        String anio_nac = afecha1[0];
        String mes_nac = afecha1[1];
        String dia_nac = afecha1[2];
        viewAdministradores.jcb_dia.setSelectedItem(dia_nac);
        viewAdministradores.jcb_mes.setSelectedItem(mes_nac);
        viewAdministradores.jtf_anio.setText(anio_nac);
        
        
        Date fecha_in = modelAdministradores.getFecha_ingreso_admin();
        String fecha_in_cad = fecha.format(fecha_in); // Convierte la fecha correspondiente a String
        String [] afecha2 = fecha_in_cad.split("-"); // Separa los componentes de la fecha (año-mes-día)
        String anio_in = afecha2[0];
        String mes_in = afecha2[1];
        String dia_in  = afecha2[2];
        viewAdministradores.jcb_diain.setSelectedItem(dia_in);
        viewAdministradores.jcb_mesin.setSelectedItem(mes_in);
        viewAdministradores.jtf_anioin.setText(anio_in);
        
        
        viewAdministradores.jtf_telefono.setText(modelAdministradores.getTelefono_admin());
        viewAdministradores.jtf_correoelectronico.setText(modelAdministradores.getCorreo_admin());
        viewAdministradores.jtf_calle.setText(modelAdministradores.getCalle_numero_admin());
        viewAdministradores.jtf_colonia.setText(modelAdministradores.getColonia_admin());
        viewAdministradores.jtf_codigopostal.setText(modelAdministradores.getCod_postal_admin());
        viewAdministradores.jtf_ciudad.setText(modelAdministradores.getCiudad_admin());
        viewAdministradores.jtf_estado.setText(modelAdministradores.getEstado_admin());
        viewAdministradores.jtf_nomusuario.setText(modelAdministradores.getNom_usuario());
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
        viewAdministradores.jb_menuprincipal.addActionListener(actionListener);
    }
    
     private void setValues() {
        String id_ad = Integer.toString(modelAdministradores.getId_admin());
        viewAdministradores.jtf_idadmin.setText(id_ad);
        
        viewAdministradores.jtf_rfc.setText(modelAdministradores.getRfc_admin());
        viewAdministradores.jtf_nombre.setText(modelAdministradores.getNombre_admin());
        viewAdministradores.jtf_apellidopat.setText(modelAdministradores.getApellido_pat_admin());
        viewAdministradores.jtf_apellidomate.setText(modelAdministradores.getApellido_mat_admin());
        
         //fecha de ingreso y fecha de nacimiento...
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_nac = modelAdministradores.getFecha_nac_admin();
        String fecha_nac_cad = fecha.format(fecha_nac); 
        String [] afecha1 = fecha_nac_cad.split("-"); 
        String anio_nac = afecha1[0];
        String mes_nac = afecha1[1];
        String dia_nac = afecha1[2];
        viewAdministradores.jcb_dia.setSelectedItem(dia_nac);
        viewAdministradores.jcb_mes.setSelectedItem(mes_nac);
        viewAdministradores.jtf_anio.setText(anio_nac);
        
        
         Date fecha_in = modelAdministradores.getFecha_ingreso_admin();
        String fecha_in_cad = fecha.format(fecha_in); 
        String [] afecha2 = fecha_in_cad.split("-"); 
        String anio_in = afecha2[0];
        String mes_in = afecha2[1];
        String dia_in  = afecha2[2];
        viewAdministradores.jcb_diain.setSelectedItem(dia_in);
        viewAdministradores.jcb_mesin.setSelectedItem(mes_in);
        viewAdministradores.jtf_anioin.setText(anio_in);
        
        
         viewAdministradores.jtf_telefono.setText(modelAdministradores.getTelefono_admin());
         viewAdministradores.jtf_correoelectronico.setText(modelAdministradores.getCorreo_admin());
         viewAdministradores.jtf_calle.setText(modelAdministradores.getCalle_numero_admin());
         viewAdministradores.jtf_colonia.setText(modelAdministradores.getColonia_admin());
         viewAdministradores.jtf_codigopostal.setText(modelAdministradores.getCod_postal_admin());
         viewAdministradores.jtf_ciudad.setText(modelAdministradores.getCiudad_admin());
         viewAdministradores.jtf_estado.setText(modelAdministradores.getEstado_admin());
         viewAdministradores.jtf_nomusuario.setText(modelAdministradores.getNom_usuario());
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
        viewAdministradores.jtf_anio.setText("");
       //fecha ingreso
        viewAdministradores.jcb_diain.setSelectedIndex(0);
        viewAdministradores.jcb_mesin.setSelectedIndex(0);
        viewAdministradores.jtf_anioin.setText("");
       
        viewAdministradores.jtf_correoelectronico.setText("");
        viewAdministradores.jtf_telefono.setText("");
        viewAdministradores.jtf_calle.setText("");
        viewAdministradores.jtf_colonia.setText("");
        viewAdministradores.jtf_codigopostal.setText("");
        viewAdministradores.jtf_ciudad.setText("");
        viewAdministradores.jtf_estado.setText("");
        viewAdministradores.jtf_nomusuario.setText("");
        viewAdministradores.jpf_passwd.setText("");
    }
    
     private void jb_insertar_actionPerformed() {
         modelAdministradores.setRfc_admin(viewAdministradores.jtf_rfc.getText());
        modelAdministradores.setNombre_admin(viewAdministradores.jtf_nombre.getText());
         modelAdministradores.setApellido_pat_admin(viewAdministradores.jtf_apellidopat.getText());
         modelAdministradores.setApellido_mat_admin(viewAdministradores.jtf_apellidomate.getText());
        
    
        String anio_n = viewAdministradores.jtf_anio.getText();
        String mes_n = (String) viewAdministradores.jcb_mes.getSelectedItem();
        String dia_n = (String) viewAdministradores.jcb_dia.getSelectedItem();
        String nacimiento = anio_n + "-" + mes_n + "-" + dia_n;
        modelAdministradores.setCad_fecha_nac(nacimiento);

        String anio_i = viewAdministradores.jtf_anioin.getText();
        String mes_i = (String) viewAdministradores.jcb_mesin.getSelectedItem();
        String dia_i = (String) viewAdministradores.jcb_diain.getSelectedItem();
        String ingreso = anio_i + "-" + mes_i + "-" + dia_i;
        modelAdministradores.setCad_fecha_ing(ingreso);
         
        modelAdministradores.setCorreo_admin(viewAdministradores.jtf_correoelectronico.getText());
        modelAdministradores.setTelefono_admin(viewAdministradores.jtf_telefono.getText());
        modelAdministradores.setCalle_numero_admin(viewAdministradores.jtf_calle.getText());
        modelAdministradores.setColonia_admin(viewAdministradores.jtf_colonia.getText());
        modelAdministradores.setCod_postal_admin(viewAdministradores.jtf_codigopostal.getText());
        modelAdministradores.setCiudad_admin(viewAdministradores.jtf_ciudad.getText());
        modelAdministradores.setEstado_admin(viewAdministradores.jtf_estado.getText());
        modelAdministradores.setNom_usuario(viewAdministradores.jtf_nomusuario.getText());
        modelAdministradores.setContrasena_admin(viewAdministradores.jpf_passwd.getText());
        
        
        modelAdministradores.insertarRegistro(); 
    } 
     
     
     private void jb_modificar_actionPerformed() {
       modelAdministradores.setRfc_admin(viewAdministradores.jtf_rfc.getText());
       modelAdministradores.setNombre_admin(viewAdministradores.jtf_nombre.getText());
        modelAdministradores.setApellido_pat_admin(viewAdministradores.jtf_apellidopat.getText());
        modelAdministradores.setApellido_mat_admin(viewAdministradores.jtf_apellidomate.getText());
 
         //fechas nacimiento e ingreso del empleado
        String anio_n = viewAdministradores.jtf_anio.getText();
        String mes_n = (String) viewAdministradores.jcb_mes.getSelectedItem();
        String dia_n = (String) viewAdministradores.jcb_dia.getSelectedItem();
        String nacimiento = anio_n + "-" + mes_n + "-" + dia_n;
        modelAdministradores.setCad_fecha_nac(nacimiento);

        String anio_i = viewAdministradores.jtf_anioin.getText();
        String mes_i = (String) viewAdministradores.jcb_mesin.getSelectedItem();
        String dia_i = (String) viewAdministradores.jcb_diain.getSelectedItem();
        String ingreso = anio_i + "-" + mes_i + "-" + dia_i;
        modelAdministradores.setCad_fecha_ing(ingreso);
        
        
        modelAdministradores.setCorreo_admin(viewAdministradores.jtf_correoelectronico.getText());
        modelAdministradores.setTelefono_admin(viewAdministradores.jtf_telefono.getText());
        modelAdministradores.setCalle_numero_admin(viewAdministradores.jtf_calle.getText());
        modelAdministradores.setColonia_admin(viewAdministradores.jtf_colonia.getText());
        modelAdministradores.setCod_postal_admin(viewAdministradores.jtf_codigopostal.getText());
        modelAdministradores.setCiudad_admin(viewAdministradores.jtf_ciudad.getText());
        modelAdministradores.setEstado_admin(viewAdministradores.jtf_estado.getText());
        modelAdministradores.setNom_usuario(viewAdministradores.jtf_nomusuario.getText());
        modelAdministradores.setContrasena_admin(viewAdministradores.jpf_passwd.getText());
        
        modelAdministradores.modificarRegistro(); 
    }
    
    
    private void jb_menuprincipal_actionPerformed() {
        ModelMain modelMain = new ModelMain();
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(modelMain, viewMain);
        viewAdministradores.setVisible(false);
    }
    
}
