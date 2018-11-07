
package controllers;

import models.ModelClientes;
import views.ViewClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author ERKA Software
 */
public class ControllerClientes {

    ModelClientes modelClientes;
    ViewClientes viewClientes;

    /**
     * Objeto de tipo ActionListener para atrapar los eventos actionPerformed y
     * llamar a los metodos para ver los registros almacenados en la bd.
     */
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewClientes.jb_primero) {
                jb_primero_actionPerformed();
            }
            else if (e.getSource() == viewClientes.jb_anterior) {
                jb_anterior_actionPerformed();
            }
            else if (e.getSource() == viewClientes.jb_siguiente) {
                jb_siguiente_actionPerformed();
            }
            else if (e.getSource() == viewClientes.jb_ultimo) {
                jb_ultimo_actionPerformed();
            }
            else if (e.getSource() == viewClientes.jb_nuevo) {
//                jb_nuevo_actionPerformed();
            }
            else if (e.getSource() == viewClientes.jb_insertar) {
//                jb_insertar_actionPerformed();
            }
            else if (e.getSource() == viewClientes.jb_modificar) {
//                jb_modificar_actionPerformed();
            }
            else if (e.getSource() == viewClientes.jb_eliminar) {
//                jb_eliminar_actionPerformed();
            }
        }
    };
    
    /**
     * Constructor para unir los componentes del sistema (MVC).
     * @param modelClientes objeto de tipo ModelAgenda
     * @param viewClientes objeto de tipo ViewAgenda
     */
    public ControllerClientes(ModelClientes modelClientes, ViewClientes viewClientes) {
        this.modelClientes = modelClientes;
        this.viewClientes = viewClientes;
        setActionListener();
        initDB();
        initComponents();
    }
    
    /**
     * Método que llama al método conectarBD del modelo y muestra los datos
     * del primer registro en las cajas de texto de ViewClientes.
     */
    private void initDB() {
        modelClientes.conectarDB();
        String id_c = Integer.toString(modelClientes.getId_cliente());
        viewClientes.jtf_idcliente.setText(id_c);
        
        viewClientes.jcb_tipocliente.setSelectedItem(modelClientes.getTipo_cliente());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
        viewClientes.jtf_nombre.setText(modelClientes.getNombre());
        viewClientes.jtf_apellidopaterno.setText(modelClientes.getApellido_pat());
        viewClientes.jtf_apellidomaterno.setText(modelClientes.getApellido_mat());
        viewClientes.jtf_telefono.setText(modelClientes.getTelefono());
        viewClientes.jtf_correoelectronico.setText(modelClientes.getCorreo());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_codigopostal.setText(modelClientes.getCod_postal());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());
        
        viewClientes.jtf_nombrerepresentante.setText(modelClientes.getNom_representante());
        viewClientes.jtf_apellidopatrepresentante.setText(modelClientes.getAp_pat_representante());
        viewClientes.jtf_apellidomatrepresentante.setText(modelClientes.getAp_mat_representante());
        viewClientes.jtf_telefonorepresentante.setText(modelClientes.getTelefono_representante());
    }
    
    /**
     * Metodo para inicializar la ViewClientes
     */
    public void initComponents() {
        viewClientes.setLocationRelativeTo(null);
        viewClientes.setTitle("Clientes ACME");
        viewClientes.setVisible(true);
    }
    
    /**
     * Método para agregar el actionListener a cada boton de la vista
     */
    private void setActionListener() {
        viewClientes.jb_primero.addActionListener(actionListener);
        viewClientes.jb_anterior.addActionListener(actionListener);
        viewClientes.jb_siguiente.addActionListener(actionListener);
        viewClientes.jb_ultimo.addActionListener(actionListener);
        
        viewClientes.jb_nuevo.addActionListener(actionListener);
        viewClientes.jb_insertar.addActionListener(actionListener);
        viewClientes.jb_modificar.addActionListener(actionListener);
        viewClientes.jb_eliminar.addActionListener(actionListener);
    }
    
    
    /**
     * Muestra los valores de las variables almacenados en el modelClientes en la viewClientes.
     */
    private void setValues() {
        String id_c = Integer.toString(modelClientes.getId_cliente());
        viewClientes.jtf_idcliente.setText(id_c);
        
        viewClientes.jcb_tipocliente.setSelectedItem(modelClientes.getTipo_cliente());
        viewClientes.jtf_rfc.setText(modelClientes.getRfc());
        viewClientes.jtf_nombre.setText(modelClientes.getNombre());
        viewClientes.jtf_apellidopaterno.setText(modelClientes.getApellido_pat());
        viewClientes.jtf_apellidomaterno.setText(modelClientes.getApellido_mat());
        viewClientes.jtf_telefono.setText(modelClientes.getTelefono());
        viewClientes.jtf_correoelectronico.setText(modelClientes.getCorreo());
        viewClientes.jtf_calle.setText(modelClientes.getCalle());
        viewClientes.jtf_colonia.setText(modelClientes.getColonia());
        viewClientes.jtf_codigopostal.setText(modelClientes.getCod_postal());
        viewClientes.jtf_ciudad.setText(modelClientes.getCiudad());
        viewClientes.jtf_estado.setText(modelClientes.getEstado());
        
        viewClientes.jtf_nombrerepresentante.setText(modelClientes.getNom_representante());
        viewClientes.jtf_apellidopatrepresentante.setText(modelClientes.getAp_pat_representante());
        viewClientes.jtf_apellidomatrepresentante.setText(modelClientes.getAp_mat_representante());
        viewClientes.jtf_telefonorepresentante.setText(modelClientes.getTelefono_representante());
    }
    
    
    /**
     * Método para ver el primer registro de la tabla clientes
     */
    private void jb_primero_actionPerformed() {
        modelClientes.moverPrimerRegistro();
        setValues();
    }
    
    /**
     * Método para ver el registro anterior de la tabla clientes.
     */
    private void jb_anterior_actionPerformed() {
        modelClientes.moverAnteriorRegistro();
        setValues();
    }

    /**
     * Método para ver el siguiente registro de la tabla clientes.
     */
    private void jb_siguiente_actionPerformed() {
        modelClientes.moverSiguienteRegistro();
        setValues();
    }
    
    /**
     * Método para ver el último registro de la tabla clientes.
     */
    private void jb_ultimo_actionPerformed() {
        modelClientes.moverUltimoRegistro();
        setValues();
    }
    
    
//    /**
//     * Método para preparar los campos de texto para un nuevo registro.
//     */
//    private void jbtn_nuevo_actionPerformed() {
//        viewAgenda.jtf_nombre.setText(""); // Limpia los campos de texto de la vista. (3)
//        viewAgenda.jtf_email.setText("");
//        viewAgenda.jtf_telefono.setText("");
//    }
//    
//    /**
//     * Método para insertar (guardar) un registro nuevo en la tabla contactos.
//     */
//    private void jbtn_insertar_actionPerformed() {
//        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText()); // Asigna el valor de "Nombre" de la vista a la variable.
//        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); // Asigna el valor de "e-mail" de la vista a la variable.
//        modelAgenda.setTelefono(viewAgenda.jtf_telefono.getText()); // Asigna el valor de "telefono" de la vista a la variable.
//        modelAgenda.insertarRegistro(); // Invoca al método para Guardar o Insertar un nuevo registro.
//    }
//    
//    /**
//     * Método para modificar (actualizar) un registro de la tabla contactos.
//     */
//    private void jbtn_modificar_actionPerformed() {
//        modelAgenda.setNombre(viewAgenda.jtf_nombre.getText()); // Asigna el nuevo valor de "Nombre" de la vista a la variable.
//        modelAgenda.setEmail(viewAgenda.jtf_email.getText()); // Asigna el nuevo valor de "e-mail" de la vista a la variable.
//        modelAgenda.setTelefono(viewAgenda.jtf_telefono.getText()); // Asigna el valor de "telefono" de la vista a la variable.
//        modelAgenda.modificarRegistro(); // Invoca al método para Modificar (actualizar) un registro.
//    }
//    
//    /**
//     * Método para eliminar un registro de la tabla contactos.
//     */
//    private void jbtn_eliminar_actionPerformed() {
//        modelAgenda.eliminarRegistro(); // Invoca al método para Eliminar un registro.
//    }
    
    
} // Cierre de la clase ControllerClientes.
