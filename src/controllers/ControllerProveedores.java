
package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelProveedores;
import views.ViewProveedores;

/**
 *
 * @author ERKA Software
 */
public class ControllerProveedores {

    ModelProveedores modelProveedores;
    ViewProveedores viewProveedores;
    
    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewProveedores.jb_primero) {
                jb_primero_actionPerformed();
            }
            else if (e.getSource() == viewProveedores.jb_anterior) {
                jb_anterior_actionPerformed();
            }
            else if (e.getSource() == viewProveedores.jb_siguiente) {
                jb_siguiente_actionPerformed();
            }
            else if (e.getSource() == viewProveedores.jb_ultimo) {
                jb_ultimo_actionPerformed();
            }
            else if (e.getSource() == viewProveedores.jb_nuevo) {
                jb_nuevo_actionPerformed();
            }
            else if (e.getSource() == viewProveedores.jb_insertar) {
                jb_insertar_actionPerformed();
            }
            else if (e.getSource() == viewProveedores.jb_modificar) {
                jb_modificar_actionPerformed();
            }
            else if (e.getSource() == viewProveedores.jb_eliminar) {
//                jb_eliminar_actionPerformed();
            }
        }
    };
    
    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelProveedores
     * @param viewProveedores 
     */
    public ControllerProveedores(ModelProveedores modelProveedores, ViewProveedores viewProveedores) {
        this.modelProveedores = modelProveedores;
        this.viewProveedores = viewProveedores;
        setActionListener();
        initDB();
        initComponents();
    }
    
    /**
     * Método que llama al método conectarBD del modelo y muestra los datos
     * del primer registro en las cajas de texto de ViewProveedores.
     */
    private void initDB() {
        modelProveedores.conectarDB();
        String id_p = Integer.toString(modelProveedores.getId_proveedor());
        viewProveedores.jtf_idproveedor.setText(id_p);
        
        viewProveedores.jtf_rfc.setText(modelProveedores.getRfc());
        viewProveedores.jtf_nombre.setText(modelProveedores.getNombre());
        viewProveedores.jtf_telefono.setText(modelProveedores.getTelefono());
        viewProveedores.jtf_correoelectronico.setText(modelProveedores.getCorreo());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia());
        viewProveedores.jtf_codigopostal.setText(modelProveedores.getCod_postal());
        viewProveedores.jtf_ciudad.setText(modelProveedores.getCiudad());
        viewProveedores.jtf_estado.setText(modelProveedores.getEstado());
        
        viewProveedores.jtf_nombrerepresentante.setText(modelProveedores.getNom_representante());
        viewProveedores.jtf_apellidopat.setText(modelProveedores.getAp_pat_representante());
        viewProveedores.jtf_apellidomat.setText(modelProveedores.getAp_mat_representante());
        viewProveedores.jtf_telefonorepresentante.setText(modelProveedores.getTelefono_representante());
    }
    
    /**
     * Metodo para inicializar la ViewProveedores
     */
    public void initComponents() {
        viewProveedores.setLocationRelativeTo(null);
        viewProveedores.setTitle("Proveedores ACME");
        viewProveedores.setVisible(true);
    }
    
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    private void setActionListener() {
        viewProveedores.jb_primero.addActionListener(actionListener);
        viewProveedores.jb_anterior.addActionListener(actionListener);
        viewProveedores.jb_siguiente.addActionListener(actionListener);
        viewProveedores.jb_ultimo.addActionListener(actionListener);
        
        viewProveedores.jb_nuevo.addActionListener(actionListener);
        viewProveedores.jb_insertar.addActionListener(actionListener);
        viewProveedores.jb_modificar.addActionListener(actionListener);
        viewProveedores.jb_eliminar.addActionListener(actionListener);
    }
    
    
    /**
     * Muestra los valores de las variables almacenados en el modelClientes en la viewProveedores.
     */
    private void setValues() {
        String id_p = Integer.toString(modelProveedores.getId_proveedor());
        viewProveedores.jtf_idproveedor.setText(id_p);
        
        viewProveedores.jtf_rfc.setText(modelProveedores.getRfc());
        viewProveedores.jtf_nombre.setText(modelProveedores.getNombre());
        viewProveedores.jtf_telefono.setText(modelProveedores.getTelefono());
        viewProveedores.jtf_correoelectronico.setText(modelProveedores.getCorreo());
        viewProveedores.jtf_calle.setText(modelProveedores.getCalle());
        viewProveedores.jtf_colonia.setText(modelProveedores.getColonia());
        viewProveedores.jtf_codigopostal.setText(modelProveedores.getCod_postal());
        viewProveedores.jtf_ciudad.setText(modelProveedores.getCiudad());
        viewProveedores.jtf_estado.setText(modelProveedores.getEstado());
        
        viewProveedores.jtf_nombrerepresentante.setText(modelProveedores.getNom_representante());
        viewProveedores.jtf_apellidopat.setText(modelProveedores.getAp_pat_representante());
        viewProveedores.jtf_apellidomat.setText(modelProveedores.getAp_mat_representante());
        viewProveedores.jtf_telefonorepresentante.setText(modelProveedores.getTelefono_representante());
    }
    
    
    /**
     * Método para ver el primer registro de la tabla clientes
     */
    private void jb_primero_actionPerformed() {
        modelProveedores.moverPrimerRegistro();
        setValues();
    }
    
    /**
     * Método para ver el registro anterior de la tabla clientes.
     */
    private void jb_anterior_actionPerformed() {
        modelProveedores.moverAnteriorRegistro();
        setValues();
    }

    /**
     * Método para ver el siguiente registro de la tabla clientes.
     */
    private void jb_siguiente_actionPerformed() {
        modelProveedores.moverSiguienteRegistro();
        setValues();
    }
    
    /**
     * Método para ver el último registro de la tabla clientes.
     */
    private void jb_ultimo_actionPerformed() {
        modelProveedores.moverUltimoRegistro();
        setValues();
    }
    
    
    /**
     * Método para preparar los campos de texto para un nuevo registro.
     */
    private void jb_nuevo_actionPerformed() {
        viewProveedores.jtf_rfc.setText(""); // Limpia los campos de texto de la vista. (14)
        viewProveedores.jtf_nombre.setText("");
        viewProveedores.jtf_telefono.setText("");
        viewProveedores.jtf_correoelectronico.setText("");
        viewProveedores.jtf_calle.setText("");
        viewProveedores.jtf_colonia.setText("");
        viewProveedores.jtf_codigopostal.setText("");
        viewProveedores.jtf_ciudad.setText("");
        viewProveedores.jtf_estado.setText("");
        viewProveedores.jtf_nombrerepresentante.setText("");
        viewProveedores.jtf_apellidopat.setText("");
        viewProveedores.jtf_apellidomat.setText("");
        viewProveedores.jtf_telefonorepresentante.setText("");
    }
    
    /**
     * Método para insertar (guardar) un registro nuevo en la tabla proveedores.
     */
    private void jb_insertar_actionPerformed() {
        modelProveedores.setRfc(viewProveedores.jtf_rfc.getText());  // Asigna los valores introducidos en la vista a las variables del modelo. (13)
        modelProveedores.setNombre(viewProveedores.jtf_nombre.getText());
        modelProveedores.setTelefono(viewProveedores.jtf_telefono.getText());
        modelProveedores.setCorreo(viewProveedores.jtf_correoelectronico.getText());
        modelProveedores.setCalle(viewProveedores.jtf_calle.getText());
        modelProveedores.setColonia(viewProveedores.jtf_colonia.getText());
        modelProveedores.setCod_postal(viewProveedores.jtf_codigopostal.getText());
        modelProveedores.setCiudad(viewProveedores.jtf_ciudad.getText());
        modelProveedores.setEstado(viewProveedores.jtf_estado.getText());
        modelProveedores.setNom_representante(viewProveedores.jtf_nombrerepresentante.getText());
        modelProveedores.setAp_pat_representante(viewProveedores.jtf_apellidopat.getText());
        modelProveedores.setAp_mat_representante(viewProveedores.jtf_apellidomat.getText());
        modelProveedores.setTelefono_representante(viewProveedores.jtf_telefonorepresentante.getText());
        
        modelProveedores.insertarRegistro(); // Invoca al método para Guardar o Insertar un nuevo registro en la tabla proveedores.
    }
    
    /**
     * Método para modificar (actualizar) un registro de la tabla proveedores.
     */
    private void jb_modificar_actionPerformed() {
        modelProveedores.setRfc(viewProveedores.jtf_rfc.getText());  // Asigna los valores introducidos en la vista a las variables del modelo. (13)
        modelProveedores.setNombre(viewProveedores.jtf_nombre.getText());
        modelProveedores.setTelefono(viewProveedores.jtf_telefono.getText());
        modelProveedores.setCorreo(viewProveedores.jtf_correoelectronico.getText());
        modelProveedores.setCalle(viewProveedores.jtf_calle.getText());
        modelProveedores.setColonia(viewProveedores.jtf_colonia.getText());
        modelProveedores.setCod_postal(viewProveedores.jtf_codigopostal.getText());
        modelProveedores.setCiudad(viewProveedores.jtf_ciudad.getText());
        modelProveedores.setEstado(viewProveedores.jtf_estado.getText());
        modelProveedores.setNom_representante(viewProveedores.jtf_nombrerepresentante.getText());
        modelProveedores.setAp_pat_representante(viewProveedores.jtf_apellidopat.getText());
        modelProveedores.setAp_mat_representante(viewProveedores.jtf_apellidomat.getText());
        modelProveedores.setTelefono_representante(viewProveedores.jtf_telefonorepresentante.getText());
        
        modelProveedores.modificarRegistro(); // Invoca al método para Modificar (actualizar) un registro.
    }
    
//    /**
//     * Método para eliminar un registro de la tabla contactos.
//     */
//    private void jbtn_eliminar_actionPerformed() {
//        modelAgenda.eliminarRegistro(); // Invoca al método para Eliminar un registro.
//    }
    
    
    
} // Cierre de la clase ControllerProveedores
