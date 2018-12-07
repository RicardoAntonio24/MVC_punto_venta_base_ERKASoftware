
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import models.ModelPromocionesDescuentos;
import views.ViewPromocionesDescuentos;

/**
 *
 * @author ERKA Software
 */
public class ControllerPromocionesDescuentos {
     
    ModelPromocionesDescuentos modelPromocionesDescuentos;
    ViewPromocionesDescuentos viewPromocionesDescuentos;
    
    
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            
            if (e.getSource() == viewPromocionesDescuentos.jb_nuevo3) {
                jb_nuevo3_actionPerformed();
                
            }
            else if (e.getSource() == viewPromocionesDescuentos.jb_insertar1) {
                try {
                    jb_insertar1_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerPromocionesDescuentos.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
            else if (e.getSource() == viewPromocionesDescuentos.jb_modificar1) {
                try {
                    jb_modificar1_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerPromocionesDescuentos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
             else if (e.getSource() == viewPromocionesDescuentos.jb_nuevo2) {
                jb_nuevo2_actionPerformed();
             }
             else if (e.getSource() == viewPromocionesDescuentos.jb_insertar){
                try {
                    jb_insertar_actionPerformed();
                } catch (SQLException ex) {
                    Logger.getLogger(ControllerPromocionesDescuentos.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
        }
    };
    
    
    
    
    
    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelPromocionesDescuentos
     * @param viewPromocionesDescuentos 
     */
    public ControllerPromocionesDescuentos(ModelPromocionesDescuentos modelPromocionesDescuentos, ViewPromocionesDescuentos viewPromocionesDescuentos) throws SQLException  {
        
        this.modelPromocionesDescuentos = modelPromocionesDescuentos;
        this.viewPromocionesDescuentos = viewPromocionesDescuentos;

        setActionListener();
        initDB();
        modelPromocionesDescuentos.llenarComboBox(); 
        initComponents();
        for (int pr = 0; pr < modelPromocionesDescuentos.getProductos().size(); pr++) {
            viewPromocionesDescuentos.jcb_producto.addItem((String) modelPromocionesDescuentos.getProductos().get(pr));
        }
         for (int s = 0; s < modelPromocionesDescuentos.getSucursales().size(); s++) {
            viewPromocionesDescuentos.jcb_sucursal.addItem((String) modelPromocionesDescuentos.getSucursales().get(s));
        }
        modelPromocionesDescuentos.llenarTabla();
        viewPromocionesDescuentos.table_promo.setModel(modelPromocionesDescuentos.getTable_promo());
      
       
     
        
        //descuentos
          initDB2();
         modelPromocionesDescuentos.mostrar2();
       viewPromocionesDescuentos.table_descuento.setModel(modelPromocionesDescuentos.getTable_descuento());
      
    }
    
    
    
    
    private void initDB() {
        
        modelPromocionesDescuentos.conectarDB();
        String id_prom = Integer.toString(modelPromocionesDescuentos.getId_promocion());
        viewPromocionesDescuentos.jtf_idpromocion.setText(id_prom);
        
        viewPromocionesDescuentos.jcb_producto.setSelectedItem(modelPromocionesDescuentos.getNom_producto());
        viewPromocionesDescuentos.jcb_tipo.setSelectedItem(modelPromocionesDescuentos.getTipo_promocion());
        String desc_promo = Integer.toString(modelPromocionesDescuentos.getDescuento_promocion());
        viewPromocionesDescuentos.jtf_descuento.setText(desc_promo);
        viewPromocionesDescuentos.jcb_sucursal.setSelectedItem(modelPromocionesDescuentos.getId_sucursal());
        
        //fecha inicio
        
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_in = modelPromocionesDescuentos.getFecha_inicio_promo();
        String fecha_inicio= fecha.format(fecha_in); 
        String [] afecha1 = fecha_inicio.split("-"); 
        
        String anio_ini = afecha1[0];
        String mes_ini = afecha1[1];
        String dia_ini = afecha1[2];
        
        
        viewPromocionesDescuentos.jcb_dia3.setSelectedItem(dia_ini);
        viewPromocionesDescuentos.jcb_mes3.setSelectedItem(mes_ini);
        viewPromocionesDescuentos.jtf_anio1.setText(anio_ini);
        
      
        //fecha limite
        
        Date fecha_lim = modelPromocionesDescuentos.getFecha_limite_promo();
        String fecha_limite = fecha.format(fecha_lim); 
        String [] afecha2 = fecha_limite.split("-"); 
        String anio_li = afecha2[0];
        String mes_li = afecha2[1];
        String dia_li  = afecha2[2];
        viewPromocionesDescuentos.jcb_dia4.setSelectedItem(dia_li);
        viewPromocionesDescuentos.jcb_mes2.setSelectedItem(mes_li);
        viewPromocionesDescuentos.jtf_anio2.setText(anio_li);
        
        
      
        
    }
    
    
    
    
     private void initDB2() {
         
          modelPromocionesDescuentos.conectarDB2();
          DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
          String id_desc = Integer.toString(modelPromocionesDescuentos.getId_descuento());
        viewPromocionesDescuentos.jtf_iddescuento.setText(id_desc);

        
        String monto_mini = Float.toString(modelPromocionesDescuentos.getMonto_minimo());
        viewPromocionesDescuentos.jtf_montominimo.setText(monto_mini);
        
         String monto_limi = Float.toString(modelPromocionesDescuentos.getMonto_limite());
        viewPromocionesDescuentos.jtf_montolimite.setText(monto_limi);
        
          String porcentaje_desc = Integer.toString(modelPromocionesDescuentos.getPorcentaje_descuento());
        viewPromocionesDescuentos.jtf_des.setText(porcentaje_desc);

        //fecha inicio

        Date fecha_ini2 = modelPromocionesDescuentos.getFecha_inicio2();
        String fecha_inicio2= fecha.format(fecha_ini2); 
        String [] fechaa2 = fecha_inicio2.split("-"); 
        
        String anio_ini2 = fechaa2[0];
        String mes_ini2 = fechaa2[1];
        String dia_ini2 = fechaa2[2];
        
        
        viewPromocionesDescuentos.jcb_dia1.setSelectedItem(dia_ini2);
        viewPromocionesDescuentos.jcb_mes1.setSelectedItem(mes_ini2);
        viewPromocionesDescuentos.jtf_anio3.setText(anio_ini2);
        
      
        //fecha limite
        
        Date fecha_limí2 = modelPromocionesDescuentos.getFecha_limite2();
        String fecha_limite2 = fecha.format(fecha_limí2); 
        String [] fechaa3 = fecha_limite2.split("-"); 
  
        String anio_li2 = fechaa3[0];
        String mes_li2 = fechaa3[1];
        String dia_li2  = fechaa3[2];
        viewPromocionesDescuentos.jcb_dia2.setSelectedItem(dia_li2);
        viewPromocionesDescuentos.jcb_mes.setSelectedItem(mes_li2);
        viewPromocionesDescuentos.jtf_anio4.setText(anio_li2);  
        
        
        
     }
    
     
     public void initComponents() {
        viewPromocionesDescuentos.setLocationRelativeTo(null);
        viewPromocionesDescuentos.setTitle("Descuentos y Promociones ACME");
        viewPromocionesDescuentos.setVisible(true);
        
    }
     
     private void setActionListener() {
       
        viewPromocionesDescuentos.jb_nuevo3.addActionListener(actionListener);
        viewPromocionesDescuentos.jb_insertar1.addActionListener(actionListener);
        viewPromocionesDescuentos.jb_modificar1.addActionListener(actionListener);
        
         viewPromocionesDescuentos.jb_nuevo2.addActionListener(actionListener);
        viewPromocionesDescuentos.jb_insertar.addActionListener(actionListener);
        viewPromocionesDescuentos.jb_modificar.addActionListener(actionListener);
       
    }

     private void setValues() {
        modelPromocionesDescuentos.conectarDB();
        
        String id_prom = Integer.toString(modelPromocionesDescuentos.getId_promocion());
        viewPromocionesDescuentos.jtf_idpromocion.setText(id_prom);
        
        viewPromocionesDescuentos.jcb_producto.setSelectedItem(modelPromocionesDescuentos.getNom_producto());
        viewPromocionesDescuentos.jcb_tipo.setSelectedItem(modelPromocionesDescuentos.getTipo_promocion());
        
        String desc_promo = Integer.toString(modelPromocionesDescuentos.getDescuento_promocion());
        viewPromocionesDescuentos.jtf_descuento.setText(desc_promo);
        viewPromocionesDescuentos.jcb_sucursal.setSelectedItem(modelPromocionesDescuentos.getId_sucursal());
        
         
       DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
       Date fecha_in = modelPromocionesDescuentos.getFecha_inicio_promo();
       String fecha_inicio= fecha.format(fecha_in); 
       String [] afecha1 = fecha_inicio.split("-"); 
       String anio_ini = afecha1[0];
       String mes_ini = afecha1[1];
       String dia_ini = afecha1[2];
        
        
        viewPromocionesDescuentos.jcb_dia3.setSelectedItem(dia_ini);
        viewPromocionesDescuentos.jcb_mes3.setSelectedItem(mes_ini);
        viewPromocionesDescuentos.jtf_anio1.setText(anio_ini);
        
      
        
        
        Date fecha_lim = modelPromocionesDescuentos.getFecha_limite_promo();
        String fecha_limite = fecha.format(fecha_lim); 
        String [] afecha2 = fecha_limite.split("-"); 
        String anio_li = afecha2[0];
        String mes_li = afecha2[1];
        String dia_li  = afecha2[2];
        viewPromocionesDescuentos.jcb_dia4.setSelectedItem(dia_li);
        viewPromocionesDescuentos.jcb_mes2.setSelectedItem(mes_li);
        viewPromocionesDescuentos.jtf_anio2.setText(anio_li);
       
      
    }
     
     
     private void setValues2(){
       // descuentos

         modelPromocionesDescuentos.conectarDB2();
        String id_desc = Integer.toString(modelPromocionesDescuentos.getId_descuento());
        viewPromocionesDescuentos.jtf_iddescuento.setText(id_desc);

        
        String monto_mini = Float.toString(modelPromocionesDescuentos.getMonto_minimo());
        viewPromocionesDescuentos.jtf_montominimo.setText(monto_mini);
        
         String monto_limi = Float.toString(modelPromocionesDescuentos.getMonto_limite());
        viewPromocionesDescuentos.jtf_montolimite.setText(monto_limi);
        
          String porcentaje_desc = Integer.toString(modelPromocionesDescuentos.getPorcentaje_descuento());
        viewPromocionesDescuentos.jtf_des.setText(porcentaje_desc);
        
        
        viewPromocionesDescuentos.jcb_sucursal.setSelectedItem(modelPromocionesDescuentos.getId_sucursal());
        
        //fecha inicio
        
   
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_ini2 = modelPromocionesDescuentos.getFecha_inicio2();
        String fecha_inicio2= fecha.format(fecha_ini2); 
        String [] fechaa2 = fecha_inicio2.split("-"); 
        
        String anio_ini2 = fechaa2[0];
        String mes_ini2 = fechaa2[1];
        String dia_ini2 = fechaa2[2];
        
        
        viewPromocionesDescuentos.jcb_dia1.setSelectedItem(dia_ini2);
        viewPromocionesDescuentos.jcb_mes1.setSelectedItem(mes_ini2);
        viewPromocionesDescuentos.jtf_anio3.setText(anio_ini2);
        
      
        //fecha limite
        
        Date fecha_limí2 = modelPromocionesDescuentos.getFecha_limite2();
        String fecha_limite2 = fecha.format(fecha_limí2); 
        String [] fechaa3 = fecha_limite2.split("-"); 
  
        String anio_li2 = fechaa3[0];
        String mes_li2 = fechaa3[1];
        String dia_li2  = fechaa3[2];
        viewPromocionesDescuentos.jcb_dia2.setSelectedItem(dia_li2);
        viewPromocionesDescuentos.jcb_mes.setSelectedItem(mes_li2);
        viewPromocionesDescuentos.jtf_anio4.setText(anio_li2);
       
     }
      
     private void setValuesPromocion(){
        viewPromocionesDescuentos.table_promo.setModel(modelPromocionesDescuentos.getTable_promo());
        
      
    }
     
  
    private void setValuesDescuento(){
         viewPromocionesDescuentos.table_descuento.setModel(modelPromocionesDescuentos.getTable_descuento());
     } 
      private void jb_nuevo3_actionPerformed() {
         viewPromocionesDescuentos.jtf_idpromocion.setText("0"); 
        viewPromocionesDescuentos.jcb_producto.setSelectedIndex(0); 
        viewPromocionesDescuentos.jcb_tipo.setSelectedIndex(0);
        viewPromocionesDescuentos.jtf_descuento.setText("");
        
        viewPromocionesDescuentos.jcb_dia3.setSelectedIndex(0); 
        viewPromocionesDescuentos.jcb_mes3.setSelectedIndex(0);
        viewPromocionesDescuentos.jtf_anio1.setText("");
        
        viewPromocionesDescuentos.jcb_dia4.setSelectedIndex(0);
        viewPromocionesDescuentos.jcb_mes2.setSelectedIndex(0);
        viewPromocionesDescuentos.jtf_anio2.setText("");
         viewPromocionesDescuentos.jcb_sucursal.setSelectedIndex(0);
      
        
        
        viewPromocionesDescuentos.table_promo.setModel(modelPromocionesDescuentos.getTable_promo());
    }

       private void jb_insertar1_actionPerformed() throws SQLException {
       modelPromocionesDescuentos.setTemp_idpromo(viewPromocionesDescuentos.jtf_idpromocion.getText());
        modelPromocionesDescuentos.setTemp_nomproducto((String)viewPromocionesDescuentos.jcb_producto.getSelectedItem());
        modelPromocionesDescuentos.setTemp_tipopromo((String)viewPromocionesDescuentos.jcb_tipo.getSelectedItem());
         modelPromocionesDescuentos.setTemp_descpromo(viewPromocionesDescuentos.jtf_descuento.getText());
        
         
         //fecha inicio 
        modelPromocionesDescuentos.setDia((String)viewPromocionesDescuentos.jcb_dia3.getSelectedItem());
        modelPromocionesDescuentos.setMes((String)viewPromocionesDescuentos.jcb_mes3.getSelectedItem());
        modelPromocionesDescuentos.setAnio(viewPromocionesDescuentos.jtf_anio1.getText());
        
        //y fecha limite
        modelPromocionesDescuentos.setDia2((String)viewPromocionesDescuentos.jcb_dia4.getSelectedItem());
        modelPromocionesDescuentos.setMes2((String)viewPromocionesDescuentos.jcb_mes2.getSelectedItem());
        modelPromocionesDescuentos.setAnio2(viewPromocionesDescuentos.jtf_anio2.getText());
        
  
        modelPromocionesDescuentos.setTem_idsucursal((String)viewPromocionesDescuentos.jcb_sucursal.getSelectedItem());
   
        modelPromocionesDescuentos.agregarPromocion();
      
         viewPromocionesDescuentos.table_promo.setModel(modelPromocionesDescuentos.getTable_promo());
    
    }
       
       
       
       private void jb_modificar1_actionPerformed() throws SQLException{
            modelPromocionesDescuentos.setTemp_idpromo(viewPromocionesDescuentos.jtf_idpromocion.getText());
        modelPromocionesDescuentos.setTemp_nomproducto((String)viewPromocionesDescuentos.jcb_producto.getSelectedItem());
        modelPromocionesDescuentos.setTemp_tipopromo((String)viewPromocionesDescuentos.jcb_tipo.getSelectedItem());
         modelPromocionesDescuentos.setTemp_descpromo(viewPromocionesDescuentos.jtf_descuento.getText());
        
         
         //fecha inicio 
        modelPromocionesDescuentos.setDia((String)viewPromocionesDescuentos.jcb_dia3.getSelectedItem());
        modelPromocionesDescuentos.setMes((String)viewPromocionesDescuentos.jcb_mes3.getSelectedItem());
        modelPromocionesDescuentos.setAnio(viewPromocionesDescuentos.jtf_anio1.getText());
        
        //y fecha limite
        modelPromocionesDescuentos.setDia2((String)viewPromocionesDescuentos.jcb_dia4.getSelectedItem());
        modelPromocionesDescuentos.setMes2((String)viewPromocionesDescuentos.jcb_mes2.getSelectedItem());
        modelPromocionesDescuentos.setAnio2(viewPromocionesDescuentos.jtf_anio2.getText());
        
  
        modelPromocionesDescuentos.setTem_idsucursal((String)viewPromocionesDescuentos.jcb_sucursal.getSelectedItem());
        modelPromocionesDescuentos.modificarPromocion();
      
         viewPromocionesDescuentos.table_promo.setModel(modelPromocionesDescuentos.getTable_promo());
        
        for (int i =0; i < viewPromocionesDescuentos.table_promo.getRowCount(); i++) {
            modelPromocionesDescuentos.getTable_promo().removeRow(i);
            i -= 1;
        }
    
       
         
       }
       
       //descuentos
       private void jb_nuevo2_actionPerformed(){
             viewPromocionesDescuentos.jtf_iddescuento.setText("");
            viewPromocionesDescuentos.jtf_montominimo.setText("");  
            viewPromocionesDescuentos.jtf_montolimite.setText("");
            viewPromocionesDescuentos.jtf_des.setText("");
        
            viewPromocionesDescuentos.jcb_dia1.setSelectedIndex(0); 
            viewPromocionesDescuentos.jcb_mes1.setSelectedIndex(0);
            viewPromocionesDescuentos.jtf_anio3.setText("");
        
            viewPromocionesDescuentos.jcb_dia2.setSelectedIndex(0);
            viewPromocionesDescuentos.jcb_mes.setSelectedIndex(0);
            viewPromocionesDescuentos.jtf_anio4.setText("");
          
       }
     
       private void jb_insertar_actionPerformed() throws SQLException {
           
       modelPromocionesDescuentos.setTemp_iddescuento(viewPromocionesDescuentos.jtf_iddescuento.getText());
       modelPromocionesDescuentos.setTemp_montomini(viewPromocionesDescuentos.jtf_montominimo.getText());
       modelPromocionesDescuentos.setTemp_montolimi(viewPromocionesDescuentos.jtf_montolimite.getText()); 
        modelPromocionesDescuentos.setTemp_porcentaje(viewPromocionesDescuentos.jtf_des.getText());
    
         //fecha inicio 
        modelPromocionesDescuentos.setDiaDesc1((String)viewPromocionesDescuentos.jcb_dia1.getSelectedItem());
        modelPromocionesDescuentos.setMesDesc1((String)viewPromocionesDescuentos.jcb_mes1.getSelectedItem());
        modelPromocionesDescuentos.setAnioDesc1(viewPromocionesDescuentos.jtf_anio3.getText());
        
        //y fecha limite
        modelPromocionesDescuentos.setDiaDesc2((String)viewPromocionesDescuentos.jcb_dia2.getSelectedItem());
        modelPromocionesDescuentos.setMesDesc2((String)viewPromocionesDescuentos.jcb_mes.getSelectedItem());
        modelPromocionesDescuentos.setAnioDesc2(viewPromocionesDescuentos.jtf_anio4.getText());
        
  
     
     
        
    
        modelPromocionesDescuentos.agregarDescuento();
      
         viewPromocionesDescuentos.table_descuento.setModel(modelPromocionesDescuentos.getTable_descuento());
    
    }
}

   

