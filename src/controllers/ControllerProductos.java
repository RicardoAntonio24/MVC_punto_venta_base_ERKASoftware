
package controllers;

import models.ModelProductos;
import views.ViewProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ERKA Software
 */
public class ControllerProductos {    
    ModelProductos modelProductos;
    ViewProductos viewProductos;
     /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProductos.jb_primero) {
                jb_primero_actionPerformed();
            }
            else if (e.getSource() == viewProductos.jb_anterior) {
                jb_anterior_actionPerformed();
            }
            else if (e.getSource() == viewProductos.jb_siguiente) {
                jb_siguiente_actionPerformed();
            }
            else if (e.getSource() == viewProductos.jb_ultimo) {
                jb_ultimo_actionPerformed();
            }
            else if (e.getSource() == viewProductos.jb_nuevo) {
                jb_nuevo_actionPerformed();
            }
            else if (e.getSource() == viewProductos.jb_insertar) {
                jb_insertar_actionPerformed();
            }
            else if (e.getSource() == viewProductos.jb_modificar) {
                jb_modificar_actionPerformed();
            }
            else if (e.getSource() == viewProductos.jb_eliminar) {
//                jb_eliminar_actionPerformed();
            }
        }
    };
    
    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelProductos
     * @param viewProductos 
     */
    public ControllerProductos(ModelProductos modelProductos, ViewProductos viewProductos) {
        this.modelProductos = modelProductos;
        this.viewProductos = viewProductos;
        setActionListener();
        initDB();
        initComponents();
    }
    /**
     * Método que llama al método conectarBD del modelo y muestra los datos
     * del primer registro en las cajas de texto de ViewClientes.
     */
    private void initDB() {
        modelProductos.conectarDB();
        String id_p = Integer.toString(modelProductos.getId_producto());
        viewProductos.jtf_idproducto.setText(id_p);
        
        viewProductos.jcb_tipoproducto.setSelectedItem(modelProductos.getTipo_producto());
        viewProductos.jtf_nombre.setText(modelProductos.getNombre_producto());
        viewProductos.jtf_marca.setText(modelProductos.getMarca());
        viewProductos.jtf_preciouni.setText(modelProductos.getPrecio_unitario());
        viewProductos.jtf_preciomay.setText(modelProductos.getPrecio_mayoreo());
        viewProductos.jtf_iniciomay.setText(modelProductos.getInicio_mayoreo());
        viewProductos.jtf_descripcion.setText(modelProductos.getDescripcion());
    }
    /**
     * Metodo para inicializar la ViewProductos
     */
    public void initComponents() {
        viewProductos.setLocationRelativeTo(null);
        viewProductos.setTitle("Productos ACME");
        viewProductos.setVisible(true);
    }
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    private void setActionListener() {
        viewProductos.jb_primero.addActionListener(actionListener);
        viewProductos.jb_anterior.addActionListener(actionListener);
        viewProductos.jb_siguiente.addActionListener(actionListener);
        viewProductos.jb_ultimo.addActionListener(actionListener);
        
        viewProductos.jb_nuevo.addActionListener(actionListener);
        viewProductos.jb_insertar.addActionListener(actionListener);
        viewProductos.jb_modificar.addActionListener(actionListener);
        viewProductos.jb_eliminar.addActionListener(actionListener);
    }
     /**
     * Muestra los valores de las variables almacenados en el modelProductos en la viewProductos.
     */
    private void setValues() {
        String id_p = Integer.toString(modelProductos.getId_producto());
        viewProductos.jtf_idproducto.setText(id_p);
        
        viewProductos.jcb_tipoproducto.setSelectedItem(modelProductos.getTipo_producto());
        viewProductos.jtf_nombre.setText(modelProductos.getNombre_producto());
        viewProductos.jtf_marca.setText(modelProductos.getMarca());
        viewProductos.jtf_preciouni.setText(modelProductos.getPrecio_unitario());
        viewProductos.jtf_preciomay.setText(modelProductos.getPrecio_mayoreo());
        viewProductos.jtf_iniciomay.setText(modelProductos.getInicio_mayoreo());
        viewProductos.jtf_descripcion.setText(modelProductos.getDescripcion()); 
    }
     /**
     * Método para ver el primer registro de la tabla productos
     */
    private void jb_primero_actionPerformed() {
        modelProductos.moverPrimerRegistro();
        setValues();
    }
    /**
     * Método para ver el registro anterior de la tabla productos.
     */
    private void jb_anterior_actionPerformed() {
        modelProductos.moverAnteriorRegistro();
        setValues();
    }

    /**
     * Método para ver el siguiente registro de la tabla productos.
     */
    private void jb_siguiente_actionPerformed() {
        modelProductos.moverSiguienteRegistro();
        setValues();
    }
    
    /**
     * Método para ver el último registro de la tabla productos.
     */
    private void jb_ultimo_actionPerformed() {
        modelProductos.moverUltimoRegistro();
        setValues();
    }
    /**
     * Método para preparar los campos de texto para un nuevo registro.
     */
    private void jb_nuevo_actionPerformed() {
        viewProductos.jcb_tipoproducto.setSelectedIndex(0);
        viewProductos.jtf_nombre.setText(""); // Limpia los campos de texto de la vista. (15)
        viewProductos.jtf_marca.setText("");
        viewProductos.jtf_preciouni.setText("");
        viewProductos.jtf_preciomay.setText("");
        viewProductos.jtf_iniciomay.setText("");
        viewProductos.jtf_descripcion.setText("");
        
    }
    
    /**
     * Método para insertar (guardar) un registro nuevo en la tabla productos.
     */
    private void jb_insertar_actionPerformed() {
        modelProductos.setTipo_producto((String) viewProductos.jcb_tipoproducto.getSelectedItem()); // Asigna los valores introducidos en la vista a las variables del modelo. (16)
        modelProductos.setNombre_producto(viewProductos.jtf_nombre.getText());
        modelProductos.setMarca(viewProductos.jtf_marca.getText());
        modelProductos.setPrecio_unitario(viewProductos.jtf_preciouni.getText());
        modelProductos.setPrecio_mayoreo(viewProductos.jtf_preciomay.getText());
        modelProductos.setInicio_mayoreo(viewProductos.jtf_iniciomay.getText());
        modelProductos.setDescripcion(viewProductos.jtf_descripcion.getText());
        
        
        modelProductos.insertarRegistro(); // Invoca al método para Guardar o Insertar un nuevo registro en la tabla productos.
    }
    
    /**
     * Método para modificar (actualizar) un registro de la tabla productos.
     */
    private void jb_modificar_actionPerformed() {
        modelProductos.setTipo_producto((String) viewProductos.jcb_tipoproducto.getSelectedItem()); // Asigna los nuevos valores introducidos en la vista a las variables del modelo. (16)
        modelProductos.setNombre_producto(viewProductos.jtf_nombre.getText());
        modelProductos.setMarca(viewProductos.jtf_marca.getText());
        modelProductos.setPrecio_unitario(viewProductos.jtf_preciouni.getText());
        modelProductos.setPrecio_mayoreo(viewProductos.jtf_preciomay.getText());
        modelProductos.setInicio_mayoreo(viewProductos.jtf_iniciomay.getText());
        modelProductos.setDescripcion(viewProductos.jtf_descripcion.getText());
        
        modelProductos.modificarRegistro(); // Invoca al método para Modificar (actualizar) un registro.
    }
    
//    /**
//     * Método para eliminar un registro de la tabla productos.
//     */
//    private void jbtn_eliminar_actionPerformed() {
//        modelProductos.eliminarRegistro(); // Invoca al método para Eliminar un registro.
//    }
    
    
} // Cierre de la clase ControllerProductos.

