
package controllers;

import models.ModelVentas;
import views.ViewVentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ERKA Software
 */
public class ControllerVentas {

    ModelVentas modelVentas;
    ViewVentas viewVentas;
    
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewVentas.jb_primero) {
                jb_primero_actionPerformed();
            }
            else if (e.getSource() == viewVentas.jb_anterior1) {
                jb_anterior_actionPerformed();
            }
            else if (e.getSource() == viewVentas.jb_siguiente) {
                jb_siguiente_actionPerformed();
            }
            else if (e.getSource() == viewVentas.jb_ultimo) {
                jb_ultimo_actionPerformed();
            }
            else if (e.getSource() == viewVentas.jb_nuevo) {
                jb_nuevo_actionPerformed();
            }
            else if (e.getSource() == viewVentas.jb_insertar) {
                jb_insertar_actionPerformed();
            }
            else if (e.getSource() == viewVentas.jb_modificar) {
                jb_modificar_actionPerformed();
            }
            // Botones para panel de detalle de Compra.
            else if (e.getSource() == viewVentas.jb_agregarproducto) {
//                jb_agregarproducto_actionPerformed();
            }
            else if (e.getSource() == viewVentas.jb_eliminarproducto) {
//                jb_eliminarproducto_actionPerformed();
            }
            else if (e.getSource() == viewVentas.jb_finventa) {
//                jb_fincompra_actionPerformed();
            }
//            else if (e.getSource() == viewVentas.jb_cotizacion) {
//                jb_cotizacion_actionPerformed();
//            }
        }
    };
    
    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelVentas
     * @param viewVentas 
     */
    public ControllerVentas(ModelVentas modelVentas, ViewVentas viewVentas) {
        this.modelVentas = modelVentas;
        this.viewVentas = viewVentas;
        setActionListener();
        initDB();
        modelVentas.llenarComboBox(); // Llama al método para llenar los ComboBox (registros existentes).
        // Configuración de ComboBox para nombres de sucursales, empleados y clientes
        for (int s = 0; s < modelVentas.getSucursales().size(); s++) {
            viewVentas.jcb_sucursal.addItem((String) modelVentas.getSucursales().get(s));
        }
        for (int v = 0; v < modelVentas.getEmpleados().size(); v++) {
            viewVentas.jcb_vendedor.addItem((String) modelVentas.getEmpleados().get(v));
        }
        for (int c = 0; c < modelVentas.getClientes().size(); c++) {
            viewVentas.jcb_cliente.addItem((String) modelVentas.getClientes().get(c));
        }
//        for (int pr = 0; pr < modelVentas.getProductos().size(); pr++) {
//            viewVentas.jcb_producto.addItem((String) modelVentas.getProductos().get(pr));
//        }
        initDB();
//        // Código para inhabilitar el panel de 'detalle de compra'...
//        for (Component component : viewCompras.jPanel_detallecompra.getComponents()) {
//            component.setEnabled(false);
//        }
//        modelVentas.llenarTabla();
//        viewVentas.jtab_detalle_compra.setModel(modelVentas.getTabla_detalle());
//        this.jb_primero_actionPerformed(); // Llama al metodo para mostrar en la tabla los detalles del primer registro de Venta.
        initComponents();
    }
    
    /**
     * Método que llama al método conectarBD del modelo y muestra los datos
     * del primer registro en las cajas de texto de ViewVentas.
     */
    private void initDB() {
        modelVentas.conectarDB();
        String id_vta = Integer.toString(modelVentas.getId_venta());
        viewVentas.jtf_nventa.setText(id_vta);
//        // Fecha de la compra...
//        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
//        Date fecha_com = modelCompras.getFecha();
//        String fecha_com_cad = fecha.format(fecha_com); // Convierte la fecha correspondiente a String
//        String [] afecha1 = fecha_com_cad.split("-"); // Separa los componentes de la fecha (año-mes-día)
//        String anio_nac = afecha1[0];
//        String mes_nac = afecha1[1];
//        String dia_nac = afecha1[2];
//        viewCompras.jcb_dia.setSelectedItem(dia_nac);
//        viewCompras.jcb_mes.setSelectedItem(mes_nac);
//        viewCompras.jtf_anio.setText(anio_nac);
        
        DateFormat df = new SimpleDateFormat("yyyy-M-d");
        Date fecha_vta = modelVentas.getFecha_venta();
        String fechaSQL = df.format(fecha_vta); // Convierte la fecha correspondiente a String
        viewVentas.jtf_fechaventa.setText(fechaSQL); // Fecha de venta (timestamp en la BD).
        
        viewVentas.jcb_sucursal.setSelectedItem(modelVentas.getNom_sucursal());
        viewVentas.jcb_vendedor.setSelectedItem(modelVentas.getNom_empleado());
        viewVentas.jcb_cliente.setSelectedItem(modelVentas.getNom_cliente());
        viewVentas.jtf_descuento.setText(Integer.toString(modelVentas.getId_descuento()));
        viewVentas.jtf_subtotal.setText(Float.toString(modelVentas.getSubtotal_venta()));
        viewVentas.jtf_iva.setText(Float.toString(modelVentas.getIva_venta()));
        viewVentas.jtf_total.setText(Float.toString(modelVentas.getTotal_venta()));
        viewVentas.jtf_importefinal.setText(Float.toString(modelVentas.getImporte_final()));
        viewVentas.jcb_formapago.setSelectedItem(modelVentas.getForma_pago());
        viewVentas.jcb_banco.setSelectedItem(modelVentas.getEnt_bancaria());
        viewVentas.jtf_nocuenta.setText(modelVentas.getNo_cuenta());
    }
    
    /**
     * Metodo para inicializar la ViewVentas
     */
    public void initComponents() {
        viewVentas.setLocationRelativeTo(null);
        viewVentas.setTitle("Ventas ACME");
        viewVentas.setVisible(true);
    }
    
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    private void setActionListener() {
        viewVentas.jb_primero.addActionListener(actionListener);
        viewVentas.jb_anterior1.addActionListener(actionListener);
        viewVentas.jb_siguiente.addActionListener(actionListener);
        viewVentas.jb_ultimo.addActionListener(actionListener);
        
        viewVentas.jb_nuevo.addActionListener(actionListener);
        viewVentas.jb_insertar.addActionListener(actionListener);
        viewVentas.jb_modificar.addActionListener(actionListener);
        viewVentas.jb_cotizacion.addActionListener(actionListener);
        
        viewVentas.jb_agregarproducto.addActionListener(actionListener);
        viewVentas.jb_eliminarproducto.addActionListener(actionListener);
        viewVentas.jb_finventa.addActionListener(actionListener);
    }
    
    /**
     * Muestra los valores de las variables almacenados en el modelVentas en la viewVentas.
     */
    private void setValues() {
        String id_vta = Integer.toString(modelVentas.getId_venta());
        viewVentas.jtf_nventa.setText(id_vta);
//        // Fecha de la compra...
//        DateFormat fecha = new SimpleDateFormat("yyyy-MM-dd");
//        Date fecha_com = modelCompras.getFecha();
//        String fecha_com_cad = fecha.format(fecha_com); // Convierte la fecha correspondiente a String
//        String [] afecha1 = fecha_com_cad.split("-"); // Separa los componentes de la fecha (año-mes-día)
//        String anio_nac = afecha1[0];
//        String mes_nac = afecha1[1];
//        String dia_nac = afecha1[2];
//        viewCompras.jcb_dia.setSelectedItem(dia_nac);
//        viewCompras.jcb_mes.setSelectedItem(mes_nac);
//        viewCompras.jtf_anio.setText(anio_nac);
        
        DateFormat df = new SimpleDateFormat("yyyy-M-d");
        Date fecha_vta = modelVentas.getFecha_venta();
        String fechaSQL = df.format(fecha_vta); // Convierte la fecha correspondiente a String
        viewVentas.jtf_fechaventa.setText(fechaSQL); // Fecha de venta (timestamp en la BD).
        
        viewVentas.jcb_sucursal.setSelectedItem(modelVentas.getNom_sucursal());
        viewVentas.jcb_vendedor.setSelectedItem(modelVentas.getNom_empleado());
        viewVentas.jcb_cliente.setSelectedItem(modelVentas.getNom_cliente());
        viewVentas.jtf_descuento.setText(Integer.toString(modelVentas.getId_descuento()));
        viewVentas.jtf_subtotal.setText(Float.toString(modelVentas.getSubtotal_venta()));
        viewVentas.jtf_iva.setText(Float.toString(modelVentas.getIva_venta()));
        viewVentas.jtf_total.setText(Float.toString(modelVentas.getTotal_venta()));
        viewVentas.jtf_importefinal.setText(Float.toString(modelVentas.getImporte_final()));
        viewVentas.jcb_formapago.setSelectedItem(modelVentas.getForma_pago());
        viewVentas.jcb_banco.setSelectedItem(modelVentas.getEnt_bancaria());
        viewVentas.jtf_nocuenta.setText(modelVentas.getNo_cuenta());
    }
    
//    /**
//     * Muestra los valores de las variables almacenados en el modelVentas en la viewVentas (Sección de detalle de Venta).
//     */
//    private void setValuesDetalleCompra() {
//        viewVentas.jtab_detalle_compra.setModel(modelVentas.getTabla_detalle());
//    }
    
    
    /**
     * Método para ver el primer registro de la tabla compras.
     */
    private void jb_primero_actionPerformed() {
//        int nrows = modelCompras.getTabla_detalle().getRowCount(); // Limpia la tabla de detalle de compra v. (5)
//        for (int i = (nrows-1); i >= 0; i--) {
//            modelCompras.getTabla_detalle().removeRow(i);
//        }
//        viewCompras.jtab_detalle_compra.setModel(modelCompras.getTabla_detalle());
        
        modelVentas.moverPrimerRegistro();
        setValues();
//        setValuesDetalleCompra();
    }
    
    /**
     * Método para ver el registro anterior de la tabla compras.
     */
    private void jb_anterior_actionPerformed() {
//        int nrows = modelCompras.getTabla_detalle().getRowCount(); // Limpia la tabla de detalle de compra v. (5)
//        for (int i = (nrows-1); i >= 0; i--) {
//            modelCompras.getTabla_detalle().removeRow(i);
//        }
//        viewCompras.jtab_detalle_compra.setModel(modelCompras.getTabla_detalle());
        
        modelVentas.moverAnteriorRegistro();
        setValues();
//        setValuesDetalleCompra();
    }

    /**
     * Método para ver el siguiente registro de la tabla compras.
     */
    private void jb_siguiente_actionPerformed() {
//        int nrows = modelCompras.getTabla_detalle().getRowCount(); // Limpia la tabla de detalle de compra v. (5)
//        for (int i = (nrows-1); i >= 0; i--) {
//            modelCompras.getTabla_detalle().removeRow(i);
//        }
//        viewCompras.jtab_detalle_compra.setModel(modelCompras.getTabla_detalle());
        
        modelVentas.moverSiguienteRegistro();
        setValues();
//        setValuesDetalleCompra();
    }
    
    /**
     * Método para ver el último registro de la tabla compras.
     */
    private void jb_ultimo_actionPerformed() {
//        int nrows = modelCompras.getTabla_detalle().getRowCount(); // Limpia la tabla de detalle de compra v. (5)
//        for (int i = (nrows-1); i >= 0; i--) {
//            modelCompras.getTabla_detalle().removeRow(i);
//        }
//        viewCompras.jtab_detalle_compra.setModel(modelCompras.getTabla_detalle());
        
        modelVentas.moverUltimoRegistro();
        setValues();
//        setValuesDetalleCompra();
    }
    
    
    /**
     * Método para preparar los campos de texto para un nuevo registro.
     */
    private void jb_nuevo_actionPerformed() {
        viewVentas.jtf_nventa.setText("0"); // Limpia los campos de texto de la vista. (13)
        viewVentas.jtf_fechaventa.setText("");
        viewVentas.jcb_sucursal.setSelectedIndex(0);
        viewVentas.jcb_vendedor.setSelectedIndex(0);
        viewVentas.jcb_cliente.setSelectedIndex(0);
        viewVentas.jtf_descuento.setText("1"); // Modificar posteriorment...
        viewVentas.jtf_subtotal.setText("0.0");
        viewVentas.jtf_iva.setText("0.0");
        viewVentas.jtf_total.setText("0.0");
        viewVentas.jtf_importefinal.setText("0.0");
        viewVentas.jcb_formapago.setSelectedIndex(0);
        viewVentas.jcb_banco.setSelectedIndex(0);
        viewVentas.jtf_nocuenta.setText("");
        
//        int nrows = modelCompras.getTabla_detalle().getRowCount(); // Limpia la tabla de detalle de compra v. (5)
//        for (int i = (nrows-1); i >= 0; i--) {
//            modelCompras.getTabla_detalle().removeRow(i);
//        }
//        viewCompras.jtab_detalle_compra.setModel(modelCompras.getTabla_detalle());
    }
    
    
    /**
     * Método para insertar (guardar) un registro nuevo en la tabla ventas.
     */
    private void jb_insertar_actionPerformed() {
        modelVentas.setNom_sucursal((String) viewVentas.jcb_sucursal.getSelectedItem());
        modelVentas.setNom_empleado((String) viewVentas.jcb_vendedor.getSelectedItem());
        modelVentas.setNom_cliente((String) viewVentas.jcb_cliente.getSelectedItem());
        
        modelVentas.setSubtotal_venta(Float.parseFloat(viewVentas.jtf_subtotal.getText()));
        modelVentas.setIva_venta(Float.parseFloat(viewVentas.jtf_iva.getText()));
        modelVentas.setTotal_venta(Float.parseFloat(viewVentas.jtf_total.getText()));
        modelVentas.setId_descuento(Integer.parseInt(viewVentas.jtf_descuento.getText()));
        modelVentas.setImporte_final(Float.parseFloat(viewVentas.jtf_importefinal.getText()));
        
        modelVentas.setForma_pago((String) viewVentas.jcb_formapago.getSelectedItem());
        modelVentas.setEnt_bancaria((String) viewVentas.jcb_banco.getSelectedItem());
        modelVentas.setNo_cuenta(viewVentas.jtf_nocuenta.getText());
        
        modelVentas.insertarRegistro(); // Invoca al método para Guardar o Insertar un nuevo registro en la tabla Ventas.
        
//        jb_ultimo_actionPerformed(); // Llama al método para mostrar el registro insertado (último).
//        viewVentas.jtf_nventa1.setText(viewVentas.jtf_nventa.getText()); // Asigna el valor del registro de venta insertado como referencia para el detalle de venta.
//        
//        viewVentas.jb_primero.setEnabled(false); // Deshablita botones de movimiento entre registros. (4)
//        viewVentas.jb_anterior1.setEnabled(false);
//        viewVentas.jb_siguiente.setEnabled(false);
//        viewVentas.jb_ultimo.setEnabled(false);
//        viewVentas.jcb_producto.setEditable(true); // Vuelve editables las áreas de datos para el detalle de venta. (3)
//        viewVentas.jtf_precio.setEditable(true);
//        viewVentas.jtf_cantidad.setEditable(true);
    }
    
    /**
     * Método para modificar (actualizar) un registro de la tabla ventas.
     */
    private void jb_modificar_actionPerformed() {
        modelVentas.setId_venta(Integer.parseInt(viewVentas.jtf_nventa.getText()));
        // ...
        modelVentas.setNom_sucursal((String) viewVentas.jcb_sucursal.getSelectedItem());
        modelVentas.setNom_empleado((String) viewVentas.jcb_vendedor.getSelectedItem());
        modelVentas.setNom_cliente((String) viewVentas.jcb_cliente.getSelectedItem());
        
        modelVentas.setSubtotal_venta(Float.parseFloat(viewVentas.jtf_subtotal.getText()));
        modelVentas.setIva_venta(Float.parseFloat(viewVentas.jtf_iva.getText()));
        modelVentas.setTotal_venta(Float.parseFloat(viewVentas.jtf_total.getText()));
        modelVentas.setId_descuento(Integer.parseInt(viewVentas.jtf_descuento.getText()));
        modelVentas.setImporte_final(Float.parseFloat(viewVentas.jtf_importefinal.getText()));
        
        modelVentas.setForma_pago((String) viewVentas.jcb_formapago.getSelectedItem());
        modelVentas.setEnt_bancaria((String) viewVentas.jcb_banco.getSelectedItem());
        modelVentas.setNo_cuenta(viewVentas.jtf_nocuenta.getText());
        
        modelVentas.modificarRegistro(); // Invoca al método para modificar un registro en la tabla Ventas.
    }
    
    
    
    
} // Cierre de la clase ControllerVentas
