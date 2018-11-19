
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
                jb_insertar1_actionPerformed();
            }
            else if (e.getSource() == viewPromocionesDescuentos.jb_modificar) {
                //jb_modificar_actionPerformed();
            }
            
        }
    };
    
    
    
    
    
    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelPromocionesDescuentos
     * @param viewPromocionesDescuentos 
     */
    public ControllerPromocionesDescuentos(ModelPromocionesDescuentos modelPromocionesDescuentos, ViewPromocionesDescuentos viewPromocionesDescuentos) {
        
        this.modelPromocionesDescuentos = modelPromocionesDescuentos;
        this.viewPromocionesDescuentos = viewPromocionesDescuentos;
        setActionListener();
        initDB();
        modelPromocionesDescuentos.llenarComboBox();  
        for (int pr = 0; pr < modelPromocionesDescuentos.getProductos().size(); pr++) {
            viewPromocionesDescuentos.jcb_producto.addItem((String) modelPromocionesDescuentos.getProductos().get(pr));
        }
         for (int s = 0; s < modelPromocionesDescuentos.getSucursales().size(); s++) {
            viewPromocionesDescuentos.jcb_sucursal.addItem((String) modelPromocionesDescuentos.getSucursales().get(s));
        }
        
        
        
        
        
        modelPromocionesDescuentos.llenarTabla();
        viewPromocionesDescuentos.table_promo.setModel(modelPromocionesDescuentos.getTable_promo());
      
        initComponents();
        
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
        String fecha_limite = fecha.format(fecha_lim); // Convierte la fecha correspondiente a String
        String [] afecha2 = fecha_limite.split("-"); // Separa los componentes de la fecha (año-mes-día)
        String anio_li = afecha2[0];
        String mes_li = afecha2[1];
        String dia_li  = afecha2[2];
        viewPromocionesDescuentos.jcb_dia4.setSelectedItem(dia_li);
        viewPromocionesDescuentos.jcb_mes2.setSelectedItem(mes_li);
        viewPromocionesDescuentos.jtf_anio2.setText(anio_li);
        
        
        
        
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
    
     private void setValuesPromocion() {
        viewPromocionesDescuentos.table_promo.setModel(modelPromocionesDescuentos.getTable_promo());
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
      
        
        int nrows = modelPromocionesDescuentos.getTable_promo().getRowCount(); 
        for (int i = (nrows-1); i >= 0; i--) {
            modelPromocionesDescuentos.getTable_promo().removeRow(i);
        }
        viewPromocionesDescuentos.table_promo.setModel(modelPromocionesDescuentos.getTable_promo());
    }

       private void jb_insertar1_actionPerformed() {
        modelPromocionesDescuentos.setTemp_idpromo(viewPromocionesDescuentos.jtf_idpromocion.getText());
        modelPromocionesDescuentos.setTemp_nomproducto((String)viewPromocionesDescuentos.jcb_producto.getSelectedItem());
        modelPromocionesDescuentos.setTemp_tipopromo((String)viewPromocionesDescuentos.jcb_tipo.getSelectedItem());
         modelPromocionesDescuentos.setTemp_descpromo(viewPromocionesDescuentos.jtf_descuento.getText());
        
         
         //fecha inicio 
        modelPromocionesDescuentos.setTemp_iniciopromo((String)viewPromocionesDescuentos.jcb_dia3.getSelectedItem());
        modelPromocionesDescuentos.setTemp_iniciopromo((String)viewPromocionesDescuentos.jcb_mes3.getSelectedItem());
        modelPromocionesDescuentos.setTemp_iniciopromo(viewPromocionesDescuentos.jtf_anio1.getText());
        
        //y fecha limite
        modelPromocionesDescuentos.setTemp_limitepromo((String)viewPromocionesDescuentos.jcb_dia4.getSelectedItem());
        modelPromocionesDescuentos.setTemp_limitepromo((String)viewPromocionesDescuentos.jcb_mes2.getSelectedItem());
        modelPromocionesDescuentos.setTemp_limitepromo(viewPromocionesDescuentos.jtf_anio2.getText());
        
  
        modelPromocionesDescuentos.setTem_idsucursal((String)viewPromocionesDescuentos.jcb_sucursal.getSelectedItem());
        modelPromocionesDescuentos.agregarPromocion();
    }

   
       
}

