
package controllers;

import models.ModelEmpleadosVentas;
import views.ViewEmpleadosVentas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date; // Para manipular las fechas utilizadas en la interfaz. (3)
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.ModelMain;
import views.ViewMain;

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
                try {
                    jb_insertar1_actionPerformed();
                } catch (ParseException ex) { // Lanza una excepción de conversión de tipos de Datos.
                    Logger.getLogger(ControllerEmpleadosVentas.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else if (e.getSource() == viewEmpleadosVentas.jb_modificar1) {
                jb_modificar1_actionPerformed();
            }
            else if (e.getSource() == viewEmpleadosVentas.jb_menuprincipal) {
                jb_menuprincipal_actionPerformed();
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
        String id_em = Integer.toString(modelEmpleadosVentas.getId_empleado());
        viewEmpleadosVentas.jtf_idempleados.setText(id_em);
        
        viewEmpleadosVentas.jtf_rfc1.setText(modelEmpleadosVentas.getRfc_empleado());
        viewEmpleadosVentas.jtf_nombre1.setText(modelEmpleadosVentas.getNombre_empleado());
        viewEmpleadosVentas.jtf_apellidopat1.setText(modelEmpleadosVentas.getApellido_pat_empleado());
        viewEmpleadosVentas.jtf_apellidomate1.setText(modelEmpleadosVentas.getApellido_mat_empleado());
        
        //fecha de ingreso y fecha de nacimiento...
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_nac = modelEmpleadosVentas.getFecha_nac_empleado();
        String fecha_nac_cad = fecha.format(fecha_nac); // Convierte la fecha correspondiente a String
        String [] afecha1 = fecha_nac_cad.split("-"); // Separa los componentes de la fecha (año-mes-día)
        String anio_nac = afecha1[0];
        String mes_nac = afecha1[1];
        String dia_nac = afecha1[2];
        viewEmpleadosVentas.jcb_dia1.setSelectedItem(dia_nac);
        viewEmpleadosVentas.jcb_mes1.setSelectedItem(mes_nac);
        viewEmpleadosVentas.jtf_anio1.setText(anio_nac);
        
        Date fecha_in = modelEmpleadosVentas.getFecha_ingreso_empleado();
        String fecha_in_cad = fecha.format(fecha_in); // Convierte la fecha correspondiente a String
        String [] afecha2 = fecha_in_cad.split("-"); // Separa los componentes de la fecha (año-mes-día)
        String anio_in = afecha2[0];
        String mes_in = afecha2[1];
        String dia_in  = afecha2[2];
        viewEmpleadosVentas.jcb_diain1.setSelectedItem(dia_in);
        viewEmpleadosVentas.jcb_mesin1.setSelectedItem(mes_in);
        viewEmpleadosVentas.jtf_anioin1.setText(anio_in);
        
        viewEmpleadosVentas.jtf_telefono1.setText(modelEmpleadosVentas.getTelefono_empleado());
        viewEmpleadosVentas.jtf_calle1.setText(modelEmpleadosVentas.getCalle_numero_empleado());
        viewEmpleadosVentas.jtf_colonia1.setText(modelEmpleadosVentas.getColonia_empleado());
        viewEmpleadosVentas.jtf_codigopostal1.setText(modelEmpleadosVentas.getCod_postal_empleado());
        viewEmpleadosVentas.jtf_ciudad1.setText(modelEmpleadosVentas.getCiudad_empleado());
        viewEmpleadosVentas.jtf_estado1.setText(modelEmpleadosVentas.getEstado_empleado());
        viewEmpleadosVentas.jtf_nomusuario.setText(modelEmpleadosVentas.getNom_usuario());
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
        viewEmpleadosVentas.jb_menuprincipal.addActionListener(actionListener);
    }

     private void setValues() {
        String id_em = Integer.toString(modelEmpleadosVentas.getId_empleado());
        viewEmpleadosVentas.jtf_idempleados.setText(id_em);
        
        viewEmpleadosVentas.jtf_rfc1.setText(modelEmpleadosVentas.getRfc_empleado());
        viewEmpleadosVentas.jtf_nombre1.setText(modelEmpleadosVentas.getNombre_empleado());
        viewEmpleadosVentas.jtf_apellidopat1.setText(modelEmpleadosVentas.getApellido_pat_empleado());
        viewEmpleadosVentas.jtf_apellidomate1.setText(modelEmpleadosVentas.getApellido_mat_empleado());
        
        //fecha de ingreso y fecha de nacimiento...
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_nac = modelEmpleadosVentas.getFecha_nac_empleado();
        String fecha_nac_cad = fecha.format(fecha_nac); // Convierte la fecha correspondiente a String
        String [] afecha1 = fecha_nac_cad.split("-"); // Separa los componentes de la fecha (año-mes-día)
        String anio_nac = afecha1[0];
        String mes_nac = afecha1[1];
        String dia_nac = afecha1[2];
        viewEmpleadosVentas.jcb_dia1.setSelectedItem(dia_nac);
        viewEmpleadosVentas.jcb_mes1.setSelectedItem(mes_nac);
        viewEmpleadosVentas.jtf_anio1.setText(anio_nac);
        
        Date fecha_in = modelEmpleadosVentas.getFecha_ingreso_empleado();
        String fecha_in_cad = fecha.format(fecha_in); // Convierte la fecha correspondiente a String
        String [] afecha2 = fecha_in_cad.split("-"); // Separa los componentes de la fecha (año-mes-día)
        String anio_in = afecha2[0];
        String mes_in = afecha2[1];
        String dia_in  = afecha2[2];
        viewEmpleadosVentas.jcb_diain1.setSelectedItem(dia_in);
        viewEmpleadosVentas.jcb_mesin1.setSelectedItem(mes_in);
        viewEmpleadosVentas.jtf_anioin1.setText(anio_in);
        
        viewEmpleadosVentas.jtf_telefono1.setText(modelEmpleadosVentas.getTelefono_empleado());
        viewEmpleadosVentas.jtf_calle1.setText(modelEmpleadosVentas.getCalle_numero_empleado());
        viewEmpleadosVentas.jtf_colonia1.setText(modelEmpleadosVentas.getColonia_empleado());
        viewEmpleadosVentas.jtf_codigopostal1.setText(modelEmpleadosVentas.getCod_postal_empleado());
        viewEmpleadosVentas.jtf_ciudad1.setText(modelEmpleadosVentas.getCiudad_empleado());
        viewEmpleadosVentas.jtf_estado1.setText(modelEmpleadosVentas.getEstado_empleado());
        viewEmpleadosVentas.jtf_nomusuario.setText(modelEmpleadosVentas.getNom_usuario());
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
        viewEmpleadosVentas.jtf_anio1.setText("");
       //fecha ingreso
        viewEmpleadosVentas.jcb_diain1.setSelectedIndex(0);
        viewEmpleadosVentas.jcb_mesin1.setSelectedIndex(0);
        viewEmpleadosVentas.jtf_anioin1.setText("");
        
        viewEmpleadosVentas.jtf_telefono1.setText("");
        viewEmpleadosVentas.jtf_calle1.setText("");
        viewEmpleadosVentas.jtf_colonia1.setText("");
        viewEmpleadosVentas.jtf_codigopostal1.setText("");
        viewEmpleadosVentas.jtf_ciudad1.setText("");
        viewEmpleadosVentas.jtf_estado1.setText("");
        viewEmpleadosVentas.jtf_nomusuario.setText("");
        viewEmpleadosVentas.jpf_passwd1.setText("");
        
    }
     
    private void jb_insertar1_actionPerformed() throws ParseException {
        modelEmpleadosVentas.setRfc_empleado(viewEmpleadosVentas.jtf_rfc1.getText());
        modelEmpleadosVentas.setNombre_empleado(viewEmpleadosVentas.jtf_nombre1.getText());
        modelEmpleadosVentas.setApellido_pat_empleado(viewEmpleadosVentas.jtf_apellidopat1.getText());
        modelEmpleadosVentas.setApellido_mat_empleado(viewEmpleadosVentas.jtf_apellidomate1.getText());
        //fechas nacimiento e ingreso del empleado
        String anio_n = viewEmpleadosVentas.jtf_anio1.getText();
        String mes_n = (String) viewEmpleadosVentas.jcb_mes1.getSelectedItem();
        String dia_n = (String) viewEmpleadosVentas.jcb_dia1.getSelectedItem();
        String nacimiento = anio_n + "-" + mes_n + "-" + dia_n;
        modelEmpleadosVentas.setCad_fecha_nac(nacimiento);

        String anio_i = viewEmpleadosVentas.jtf_anioin1.getText();
        String mes_i = (String) viewEmpleadosVentas.jcb_mesin1.getSelectedItem();
        String dia_i = (String) viewEmpleadosVentas.jcb_diain1.getSelectedItem();
        String ingreso = anio_i + "-" + mes_i + "-" + dia_i;
        modelEmpleadosVentas.setCad_fecha_ing(ingreso);
        
        modelEmpleadosVentas.setTelefono_empleado(viewEmpleadosVentas.jtf_telefono1.getText());
        modelEmpleadosVentas.setCalle_numero_empleado(viewEmpleadosVentas.jtf_calle1.getText());
        modelEmpleadosVentas.setColonia_empleado(viewEmpleadosVentas.jtf_colonia1.getText());
        modelEmpleadosVentas.setCod_postal_empleado(viewEmpleadosVentas.jtf_codigopostal1.getText());
        modelEmpleadosVentas.setCiudad_empleado(viewEmpleadosVentas.jtf_ciudad1.getText());
        modelEmpleadosVentas.setEstado_empleado(viewEmpleadosVentas.jtf_estado1.getText());
        modelEmpleadosVentas.setNom_usuario(viewEmpleadosVentas.jtf_nomusuario.getText());
        modelEmpleadosVentas.setContrasena_empleado(viewEmpleadosVentas.jpf_passwd1.getText());
        
        modelEmpleadosVentas.insertarRegistro(); 
    } 
    
    private void jb_modificar1_actionPerformed() {
        modelEmpleadosVentas.setRfc_empleado(viewEmpleadosVentas.jtf_rfc1.getText());
        modelEmpleadosVentas.setNombre_empleado(viewEmpleadosVentas.jtf_nombre1.getText());
        modelEmpleadosVentas.setApellido_pat_empleado(viewEmpleadosVentas.jtf_apellidopat1.getText());
        modelEmpleadosVentas.setApellido_mat_empleado(viewEmpleadosVentas.jtf_apellidomate1.getText());
        //fechas nacimiento e ingreso del empleado
        String anio_n = viewEmpleadosVentas.jtf_anio1.getText();
        String mes_n = (String) viewEmpleadosVentas.jcb_mes1.getSelectedItem();
        String dia_n = (String) viewEmpleadosVentas.jcb_dia1.getSelectedItem();
        String nacimiento = anio_n + "-" + mes_n + "-" + dia_n;
        modelEmpleadosVentas.setCad_fecha_nac(nacimiento);

        String anio_i = viewEmpleadosVentas.jtf_anioin1.getText();
        String mes_i = (String) viewEmpleadosVentas.jcb_mesin1.getSelectedItem();
        String dia_i = (String) viewEmpleadosVentas.jcb_diain1.getSelectedItem();
        String ingreso = anio_i + "-" + mes_i + "-" + dia_i;
        modelEmpleadosVentas.setCad_fecha_ing(ingreso);
     
        modelEmpleadosVentas.setTelefono_empleado(viewEmpleadosVentas.jtf_telefono1.getText());
        modelEmpleadosVentas.setCalle_numero_empleado(viewEmpleadosVentas.jtf_calle1.getText());
        modelEmpleadosVentas.setColonia_empleado(viewEmpleadosVentas.jtf_colonia1.getText());
        modelEmpleadosVentas.setCod_postal_empleado(viewEmpleadosVentas.jtf_codigopostal1.getText());
        modelEmpleadosVentas.setCiudad_empleado(viewEmpleadosVentas.jtf_ciudad1.getText());
        modelEmpleadosVentas.setEstado_empleado(viewEmpleadosVentas.jtf_estado1.getText());
        modelEmpleadosVentas.setNom_usuario(viewEmpleadosVentas.jtf_nomusuario.getText());
        modelEmpleadosVentas.setContrasena_empleado(viewEmpleadosVentas.jpf_passwd1.getText());
        
        modelEmpleadosVentas.modificarRegistro(); 
    }
    
    
    private void jb_menuprincipal_actionPerformed() {
        ModelMain modelMain = new ModelMain();
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(modelMain, viewMain);
        viewEmpleadosVentas.setVisible(false);
    }
     
     
}
