
package controllers;

import models.ModelCompras;
import views.ViewCompras;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Component;

/**
 *
 * @author ERKA Software
 */
public class ControllerCompras {
    
    ModelCompras modelCompras;
    ViewCompras viewCompras;
    
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewCompras.jb_primero) {
                jb_primero_actionPerformed();
            }
            else if (e.getSource() == viewCompras.jb_anterior) {
                jb_anterior_actionPerformed();
            }
            else if (e.getSource() == viewCompras.jb_siguiente) {
                jb_siguiente_actionPerformed();
            }
            else if (e.getSource() == viewCompras.jb_ultimo) {
                jb_ultimo_actionPerformed();
            }
            else if (e.getSource() == viewCompras.jb_nuevo) {
                jb_nuevo_actionPerformed();
            }
            else if (e.getSource() == viewCompras.jb_insertar) {
                jb_insertar_actionPerformed();
            }
            else if (e.getSource() == viewCompras.jb_modificar) {
                jb_modificar_actionPerformed();
            }
            // Botones para panel de detalle de Compra.
            else if (e.getSource() == viewCompras.jb_agregarproducto) {
                jb_agregarproducto_actionPerformed();
            }
            else if (e.getSource() == viewCompras.jb_fincompra) {
                jb_fincompra_actionPerformed();
            }
        }
    };

    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelCompras
     * @param viewCompras 
     */
    public ControllerCompras(ModelCompras modelCompras, ViewCompras viewCompras) {
        this.modelCompras = modelCompras;
        this.viewCompras = viewCompras;
        setActionListener();
        initDB();
        modelCompras.llenarComboBox(); // Llama al método para llenar los ComboBox (registros existentes).
        // Configuración de ComboBox para nombres de sucursales, administradores y proveedores
        for (int s = 0; s < modelCompras.getSucursales().size(); s++) {
            viewCompras.jcb_nombresucursal.addItem((String) modelCompras.getSucursales().get(s));
        }
        for (int a = 0; a < modelCompras.getAdmins().size(); a++) {
            viewCompras.jcb_nombreadmin.addItem((String) modelCompras.getAdmins().get(a));
        }
        for (int p = 0; p < modelCompras.getProveedores().size(); p++) {
            viewCompras.jcb_nombreproveedor.addItem((String) modelCompras.getProveedores().get(p));
        }
        for (int pr = 0; pr < modelCompras.getProductos().size(); pr++) {
            viewCompras.jcb_nombreproducto.addItem((String) modelCompras.getProductos().get(pr));
        }
        initDB();
        // Código para inhabilitar el panel de 'detalle de compra'...
        for (Component component : viewCompras.jPanel_detallecompra.getComponents()) {
            component.setEnabled(false);
        }
        viewCompras.jb_primero.setEnabled(true);
        viewCompras.jb_anterior.setEnabled(true);
        viewCompras.jb_siguiente.setEnabled(true);
        viewCompras.jb_ultimo.setEnabled(true);
        
        modelCompras.llenarTabla();
        viewCompras.jtab_detalle_compra.setModel(modelCompras.getTabla_detalle());
        
        initComponents();
    }
    
    /**
     * Método que llama al método conectarBD del modelo y muestra los datos
     * del primer registro en las cajas de texto de ViewCompras.
     */
    private void initDB() {
        modelCompras.conectarDB();
        String id_com = Integer.toString(modelCompras.getId_compra());
        viewCompras.jtf_idcompra.setText(id_com);
        // Fecha de la compra...
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_com = modelCompras.getFecha();
        String fecha_com_cad = fecha.format(fecha_com); // Convierte la fecha correspondiente a String
        String [] afecha1 = fecha_com_cad.split("-"); // Separa los componentes de la fecha (año-mes-día)
        String anio_nac = afecha1[0];
        String mes_nac = afecha1[1];
        String dia_nac = afecha1[2];
        viewCompras.jcb_dia.setSelectedItem(dia_nac);
        viewCompras.jcb_mes.setSelectedItem(mes_nac);
        viewCompras.jtf_anio.setText(anio_nac);
        
        viewCompras.jcb_nombresucursal.setSelectedItem(modelCompras.getNom_sucursal());
        viewCompras.jcb_nombreadmin.setSelectedItem(modelCompras.getNom_admin());
        viewCompras.jcb_nombreproveedor.setSelectedItem(modelCompras.getNom_proveedor());
        
        viewCompras.jtf_subtotal.setText(Float.toString(modelCompras.getSubtotal()));
        viewCompras.jtf_iva.setText(Float.toString(modelCompras.getIva()));
        viewCompras.jtf_totalcompra.setText(Float.toString(modelCompras.getImp_total()));
        
    }
    
    /**
     * Metodo para inicializar la ViewCompras
     */
    public void initComponents() {
        viewCompras.setLocationRelativeTo(null);
        viewCompras.setTitle("Compras ACME");
        viewCompras.setVisible(true);
    }
    
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    private void setActionListener() {
        viewCompras.jb_primero.addActionListener(actionListener);
        viewCompras.jb_anterior.addActionListener(actionListener);
        viewCompras.jb_siguiente.addActionListener(actionListener);
        viewCompras.jb_ultimo.addActionListener(actionListener);
        
        viewCompras.jb_nuevo.addActionListener(actionListener);
        viewCompras.jb_insertar.addActionListener(actionListener);
        viewCompras.jb_modificar.addActionListener(actionListener);
        
        viewCompras.jb_agregarproducto.addActionListener(actionListener);
        viewCompras.jb_fincompra.addActionListener(actionListener);
    }
    
    
    /**
     * Muestra los valores de las variables almacenados en el modelCompras en la viewCompras.
     */
    private void setValues() {
        String id_com = Integer.toString(modelCompras.getId_compra());
        viewCompras.jtf_idcompra.setText(id_com);
        // Fecha de la compra...
        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
        Date fecha_com = modelCompras.getFecha();
        String fecha_com_cad = fecha.format(fecha_com); // Convierte la fecha correspondiente a String
        String [] afecha1 = fecha_com_cad.split("-"); // Separa los componentes de la fecha (año-mes-día)
        String anio_nac = afecha1[0];
        String mes_nac = afecha1[1];
        String dia_nac = afecha1[2];
        viewCompras.jcb_dia.setSelectedItem(dia_nac);
        viewCompras.jcb_mes.setSelectedItem(mes_nac);
        viewCompras.jtf_anio.setText(anio_nac);
        
        viewCompras.jcb_nombresucursal.setSelectedItem(modelCompras.getNom_sucursal());
        viewCompras.jcb_nombreadmin.setSelectedItem(modelCompras.getNom_admin());
        viewCompras.jcb_nombreproveedor.setSelectedItem(modelCompras.getNom_proveedor());
        
        viewCompras.jtf_subtotal.setText(Float.toString(modelCompras.getSubtotal()));
        viewCompras.jtf_iva.setText(Float.toString(modelCompras.getIva()));
        viewCompras.jtf_totalcompra.setText(Float.toString(modelCompras.getImp_total()));
        
    }
    
    
    /**
     * Método para ver el primer registro de la tabla compras.
     */
    private void jb_primero_actionPerformed() {
        modelCompras.moverPrimerRegistro();
        setValues();
    }
    
    /**
     * Método para ver el registro anterior de la tabla compras.
     */
    private void jb_anterior_actionPerformed() {
        modelCompras.moverAnteriorRegistro();
        setValues();
    }

    /**
     * Método para ver el siguiente registro de la tabla compras.
     */
    private void jb_siguiente_actionPerformed() {
        modelCompras.moverSiguienteRegistro();
        setValues();
    }
    
    /**
     * Método para ver el último registro de la tabla compras.
     */
    private void jb_ultimo_actionPerformed() {
        modelCompras.moverUltimoRegistro();
        setValues();
    }
    
    
    /**
     * Método para preparar los campos de texto para un nuevo registro.
     */
    private void jb_nuevo_actionPerformed() {
        viewCompras.jtf_idcompra.setText("0");
        viewCompras.jcb_dia.setSelectedIndex(0); // Limpia los campos de texto de la vista. (7)
        viewCompras.jcb_mes.setSelectedIndex(0);
        viewCompras.jtf_anio.setText("");
        viewCompras.jcb_nombresucursal.setSelectedIndex(0);
        viewCompras.jcb_nombreadmin.setSelectedIndex(0);
        viewCompras.jcb_nombreproveedor.setSelectedIndex(0);
        viewCompras.jtf_subtotal.setText("0.0");
        viewCompras.jtf_iva.setText("0.0");
        viewCompras.jtf_totalcompra.setText("0.0");
    }
    
    /**
     * Método para insertar (guardar) un registro nuevo en la tabla clientes.
     */
    private void jb_insertar_actionPerformed() {
        // Obtiene fecha de la compra...
        String anio_c = viewCompras.jtf_anio.getText();
        String mes_c = (String) viewCompras.jcb_mes.getSelectedItem();
        String dia_c = (String) viewCompras.jcb_dia.getSelectedItem();
        String fecha_c = anio_c + "-" + mes_c + "-" + dia_c;
        modelCompras.setCad_fecha_com(fecha_c);
        // 
        modelCompras.setNom_sucursal((String) viewCompras.jcb_nombresucursal.getSelectedItem());
        modelCompras.setNom_admin((String) viewCompras.jcb_nombreadmin.getSelectedItem());
        modelCompras.setNom_proveedor((String) viewCompras.jcb_nombreproveedor.getSelectedItem());
        
        modelCompras.setSubtotal(Float.parseFloat(viewCompras.jtf_subtotal.getText()));
        modelCompras.setIva(Float.parseFloat(viewCompras.jtf_iva.getText()));
        modelCompras.setImp_total(Float.parseFloat(viewCompras.jtf_totalcompra.getText()));
        
        modelCompras.insertarRegistro(); // Invoca al método para Guardar o Insertar un nuevo registro en la tabla Compras.
        
        jb_ultimo_actionPerformed(); // Llama al método para mostrar el registro insertado (último).
        viewCompras.jtf_idcompra_det.setText(viewCompras.jtf_idcompra.getText()); // Asigna el valor del registro de compra insertado como referencia para el detalle de compra.
        // Código para habilitar el panel de 'detalle de compra'...
        for (Component component : viewCompras.jPanel_detallecompra.getComponents()) {
            component.setEnabled(true);
        }
        viewCompras.jtf_idcompra_det.setEnabled(false);
    }
    
    /**
     * Método para modificar (actualizar) un registro de la tabla clientes.
     */
    private void jb_modificar_actionPerformed() {
        modelCompras.setId_compra(Integer.parseInt(viewCompras.jtf_idcompra.getText()));
        // Obtiene fecha de la compra...
        String anio_c = viewCompras.jtf_anio.getText();
        String mes_c = (String) viewCompras.jcb_mes.getSelectedItem();
        String dia_c = (String) viewCompras.jcb_dia.getSelectedItem();
        String fecha_c = anio_c + "-" + mes_c + "-" + dia_c;
        modelCompras.setCad_fecha_com(fecha_c);
        //
        modelCompras.setNom_sucursal((String) viewCompras.jcb_nombresucursal.getSelectedItem());
        modelCompras.setNom_admin((String) viewCompras.jcb_nombreadmin.getSelectedItem());
        modelCompras.setNom_proveedor((String) viewCompras.jcb_nombreproveedor.getSelectedItem());
        
        modelCompras.setSubtotal(Float.parseFloat(viewCompras.jtf_subtotal.getText()));
        modelCompras.setIva(Float.parseFloat(viewCompras.jtf_iva.getText()));
        modelCompras.setImp_total(Float.parseFloat(viewCompras.jtf_totalcompra.getText()));
        
        modelCompras.modificarRegistro(); // Invoca al método para modificar un registro en la tabla Compras.
        
    }
    
    
    /**
     * Método para añadir un producto a la tabla de 'detalle de Compra'.
     */
    private void jb_agregarproducto_actionPerformed() {
        modelCompras.setTemp_idcompra(viewCompras.jtf_idcompra_det.getText());
        modelCompras.setTemp_nomproducto((String)viewCompras.jcb_nombreproducto.getSelectedItem());
        modelCompras.setTemp_precio(viewCompras.jtf_precio.getText());
        modelCompras.setTemp_cantidad(viewCompras.jtf_cantidad.getText());
        modelCompras.agregarProducto();
    }
    
    /**
     * Método para finalizar el proceso de registro de Compra.
     */
    private void jb_fincompra_actionPerformed() {
        
    }
    
    
} // Cierre de la clase controllerCompras
