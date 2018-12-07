package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import models.ModelAdministradores;
import models.ModelClientes;
import models.ModelCompras;
import models.ModelEmpleadosVentas;
import models.ModelInicioSesion;
import models.ModelMain;
import models.ModelProductos;
import models.ModelProductosDefectuosos;
import models.ModelProveedores;
import models.ModelSucursales;
import models.ModelVentas;
import views.ViewAdministradores;
import views.ViewClientes;
import views.ViewCompras;
import views.ViewEmpleadosVentas;
import views.ViewInicioSesion;
import views.ViewMain;
import views.ViewProductos;
import views.ViewProductosDefectuosos;
import views.ViewProveedores;
import views.ViewSucursales;
import views.ViewVentas;

/**
 *
 * @author ERKA Software
 */
public class ControllerMain {

    ModelMain modelMain;
    ViewMain viewMain;

    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == viewMain.jb_respaldo) {
                jb_respaldo_actionPerformed();
            } else if (e.getSource() == viewMain.jb_admin) {
                jb_admin_actionPerformed();
            } else if (e.getSource() == viewMain.jb_clientes) {
                jb_clientes_actionPerformed();
            } else if (e.getSource() == viewMain.jb_compras) {
                jb_compras_actionPerformed();
            } else if (e.getSource() == viewMain.jb_empleadosventas) {
                jb_empleadosventas_actionPerformed();
            } else if (e.getSource() == viewMain.jb_productos) {
                jb_productos_actionPerformed();
            } else if (e.getSource() == viewMain.jb_productosdefectuosos) {
                jb_productosdefectuosos_actionPerformed();
            } else if (e.getSource() == viewMain.jb_promo) {
                jb_promo_actionPerformed();
            } else if (e.getSource() == viewMain.jb_proveedores) {
                jb_proveedores_actionPerformed();
            } else if (e.getSource() == viewMain.jb_sucursales) {
                jb_sucursales_actionPerformed();
            } else if (e.getSource() == viewMain.jb_ventas) {
                jb_ventas_actionPerformed();
            } else if (e.getSource() == viewMain.jb_cerrar) {
                jb_cerrar_actionPerformed();
            }
        }
    };

    /**
     * Constructor para unir los componentes del sistema (MVC).
     *
     * @param modelMain
     * @param viewMain
     */
    public ControllerMain(ModelMain modelMain, ViewMain viewMain) {
        this.modelMain = modelMain;
        this.viewMain = viewMain;
        setActionListener();
        initDB();
        initComponents();
    }

    private void initDB() {

    }

    public void initComponents() {
        viewMain.setLocationRelativeTo(null);
        viewMain.setTitle("Menú Principal");
        viewMain.setVisible(true);
    }

    private void setActionListener() {
        viewMain.jb_respaldo.addActionListener(actionListener);
        
        viewMain.jb_admin.addActionListener(actionListener);
        viewMain.jb_clientes.addActionListener(actionListener);
        viewMain.jb_compras.addActionListener(actionListener);
        viewMain.jb_empleadosventas.addActionListener(actionListener);
        viewMain.jb_productos.addActionListener(actionListener);
        viewMain.jb_productosdefectuosos.addActionListener(actionListener);
        viewMain.jb_promo.addActionListener(actionListener);
        viewMain.jb_proveedores.addActionListener(actionListener);
        viewMain.jb_sucursales.addActionListener(actionListener);
        viewMain.jb_ventas.addActionListener(actionListener);
        
        viewMain.jb_cerrar.addActionListener(actionListener);
    }

    private void setValues() {

    }

    /**
     * Método para generar el respaldo manual de la base de datos del sistema en el servidor de BD's
     */
    private void jb_respaldo_actionPerformed() {
        modelMain.generarRespaldo(); // Llama al método para generar el respaldo (backup) de la BD.
    }
    
    /**
     * Método para el cambio de interfaz, de la interfaz principal a Administradores.
     */
    private void jb_admin_actionPerformed() {
        ModelAdministradores modelAdministradores = new ModelAdministradores();
        ViewAdministradores viewAdministradores = new ViewAdministradores();
        ControllerAdministradores controllerAdministradores = new ControllerAdministradores(modelAdministradores, viewAdministradores);
        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    /**
     * Método para el cambio de interfaz, de la interfaz principal a Clientes.
     */
    private void jb_clientes_actionPerformed() {
        ModelClientes modelClientes = new ModelClientes();
        ViewClientes viewClientes = new ViewClientes();
        ControllerClientes controllerClientes = new ControllerClientes(modelClientes, viewClientes);
        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    /**
     * Método para el cambio de interfaz, de la interfaz principal a Compras.
     */
    private void jb_compras_actionPerformed() {
        ModelCompras modelCompras = new ModelCompras();
        ViewCompras viewCompras = new ViewCompras();
        ControllerCompras controllerCompras = new ControllerCompras(modelCompras, viewCompras);
        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    /**
     * Método para el cambio de interfaz, de la interfaz principal a Empleados Ventas.
     */
    private void jb_empleadosventas_actionPerformed() {
        ModelEmpleadosVentas modelEmpleadosVentas = new ModelEmpleadosVentas();
        ViewEmpleadosVentas viewEmpleadosVentas = new ViewEmpleadosVentas();
        ControllerEmpleadosVentas controllerEmpleadosVentas = new ControllerEmpleadosVentas(modelEmpleadosVentas, viewEmpleadosVentas);
        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    /**
     * Método para el cambio de interfaz, de la interfaz principal a Productos.
     */
    private void jb_productos_actionPerformed() {
        ModelProductos modelProductos = new ModelProductos();
        ViewProductos viewProductos = new ViewProductos();
        ControllerProductos controllerProductos = new ControllerProductos(modelProductos, viewProductos);
        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    /**
     * Método para el cambio de interfaz, de la interfaz principal a Productos Defectuosos.
     */
    private void jb_productosdefectuosos_actionPerformed() {
        ModelProductosDefectuosos modelProductosDefectuosos = new ModelProductosDefectuosos();
        ViewProductosDefectuosos viewProductosDefectuosos = new ViewProductosDefectuosos();
        ControllerProductosDefectuosos controllerProductosDefectuosos = new ControllerProductosDefectuosos(modelProductosDefectuosos, viewProductosDefectuosos);
        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    /**
     * Método para el cambio de interfaz, de la interfaz principal a Promociones y Descuentos.
     */
    private void jb_promo_actionPerformed() {
        // Pendiente  ...
//        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    /**
     * Método para el cambio de interfaz, de la interfaz principal a Proveedores.
     */
    private void jb_proveedores_actionPerformed() {
        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        ControllerProveedores controllerProveedores = new ControllerProveedores(modelProveedores, viewProveedores);
        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    /**
     * Método para el cambio de interfaz, de la interfaz principal a Sucursales.
     */
    private void jb_sucursales_actionPerformed() {
        ModelSucursales modelSucursales = new ModelSucursales();
        ViewSucursales viewSucursales = new ViewSucursales();
        ControllerSucursales controllerSucursales = new ControllerSucursales(modelSucursales, viewSucursales);
        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    /**
     * Método para el cambio de interfaz, de la interfaz principal a Ventas.
     */
    private void jb_ventas_actionPerformed() {
        ModelVentas modelVentas = new ModelVentas();
        ViewVentas viewVentas = new ViewVentas();
        ControllerVentas controllerVentas = new ControllerVentas(modelVentas, viewVentas);
        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    /**
     * Método para salir de la interfaz principal (sesión actual), dirigiendose a la interfaz de Inicio de Sesión.
     */
    private void jb_cerrar_actionPerformed() {
        ModelInicioSesion modelInicioSesion = new ModelInicioSesion();
        ViewInicioSesion viewInicioSesion = new ViewInicioSesion();
        ControllerInicioSesion controllerInicioSesion = new ControllerInicioSesion(modelInicioSesion, viewInicioSesion);
        viewMain.setVisible(false); // Vuelve "invisible" la interfaz principal para el cambio de interfaz.
    }
    
    
    
} // Cierre de la clase ControllerMain
