
package main;
import models.ModelMain;
import views.ViewMain;
import controllers.ControllerMain;

import models.ModelAdministradores;
import views.ViewAdministradores;
import controllers.ControllerAdministradores;

import models.ModelClientes;
import views.ViewClientes;
import controllers.ControllerClientes;

import models.ModelCompras;
import views.ViewCompras;
import controllers.ControllerCompras;

import models.ModelConsultas;
import views.ViewConsultas;
import controllers.ControllerConsultas;

import models.ModelCotizaciones;
import views.ViewCotizaciones;
import controllers.ControllerCotizaciones;

import models.ModelEmpleadosVentas;
import views.ViewEmpleadosVentas;
import controllers.ControllerEmpleadosVentas;

import models.ModelFacturacion;
import views.ViewFacturacion;
import controllers.ControllerFacturacion;

import models.ModelInicioSesion;
import views.ViewInicioSesion;
import controllers.ControllerInicioSesion;

import models.ModelProductos;
import views.ViewProductos;
import controllers.ControllerProductos;

import models.ModelProductosDefectuosos;
import views.ViewProductosDefectuosos;
import controllers.ControllerProductosDefectuosos;

import models.ModelPromocionesDescuentos;
import views.ViewPromocionesDescuentos;
import controllers.ControllerPromocionesDescuentos;

import models.ModelProveedores;
import views.ViewProveedores;
import controllers.ControllerProveedores;

import models.ModelReportes;
import views.ViewReportes;
import controllers.ControllerReportes;

import models.ModelSucursales;
import views.ViewSucursales;
import controllers.ControllerSucursales;

import models.ModelVentas;
import views.ViewVentas;
import controllers.ControllerVentas;

/**
 *
 * @author ERKA Software
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ModelAdministradores modelAdministradores = new ModelAdministradores();
        ViewAdministradores viewAdministradores = new ViewAdministradores();
        ControllerAdministradores controllerAdministradores = new ControllerAdministradores(modelAdministradores, viewAdministradores);
        
        ModelClientes modelClientes = new ModelClientes();
        ViewClientes viewClientes = new ViewClientes();
        ControllerClientes controllerClientes = new ControllerClientes(modelClientes, viewClientes);
        
        ModelCompras modelCompras = new ModelCompras();
        ViewCompras viewCompras = new ViewCompras();
        ControllerCompras controllerCompras = new ControllerCompras(modelCompras, viewCompras);
        
        ModelConsultas modelConsultas = new ModelConsultas();
        ViewConsultas viewConsultas = new ViewConsultas();
        ControllerConsultas controllerConsultas = new ControllerConsultas(modelConsultas, viewConsultas);
        
        ModelCotizaciones modelCotizaciones = new ModelCotizaciones();
        ViewCotizaciones viewCotizaciones = new ViewCotizaciones();
        ControllerCotizaciones controllerCotizaciones = new ControllerCotizaciones(modelCotizaciones, viewCotizaciones);
        
        ModelEmpleadosVentas modelEmpleadosVentas = new ModelEmpleadosVentas();
        ViewEmpleadosVentas viewEmpleadosVentas = new ViewEmpleadosVentas();
        ControllerEmpleadosVentas controllerEmpleadosVentas = new ControllerEmpleadosVentas(modelEmpleadosVentas, viewEmpleadosVentas);
        
        ModelFacturacion modelFacturacion = new ModelFacturacion();
        ViewFacturacion viewFacturacion = new ViewFacturacion();
        ControllerFacturacion controllerFacturacion = new ControllerFacturacion(modelFacturacion, viewFacturacion);
        
        ModelInicioSesion modelInicioSesion = new ModelInicioSesion();
        ViewInicioSesion viewInicioSesion = new ViewInicioSesion();
        ControllerInicioSesion controllerInicioSesion = new ControllerInicioSesion(modelInicioSesion, viewInicioSesion);
        
        ModelProductos modelProductos = new ModelProductos();
        ViewProductos viewProductos = new ViewProductos();
        ControllerProductos controllerProductos = new ControllerProductos(modelProductos, viewProductos);
        
        ModelProductosDefectuosos modelProductosDefectuosos = new ModelProductosDefectuosos();
        ViewProductosDefectuosos viewProductosDefectuosos = new ViewProductosDefectuosos();
        ControllerProductosDefectuosos controllerProductosDefectuosos = new ControllerProductosDefectuosos(modelProductosDefectuosos, viewProductosDefectuosos);
        
        ModelPromocionesDescuentos modelPromocionesDescuentos = new ModelPromocionesDescuentos();
        ViewPromocionesDescuentos viewPromocionesDescuentos = new ViewPromocionesDescuentos();
        ControllerPromocionesDescuentos controllerPromocionesDescuentos = new ControllerPromocionesDescuentos(modelPromocionesDescuentos, viewPromocionesDescuentos);
        
        ModelProveedores modelProveedores = new ModelProveedores();
        ViewProveedores viewProveedores = new ViewProveedores();
        ControllerProveedores controllerProveedores = new ControllerProveedores(modelProveedores, viewProveedores);
        
        ModelReportes modelReportes = new ModelReportes();
        ViewReportes viewReportes = new ViewReportes();
        ControllerReportes controllerReportes = new ControllerReportes(modelReportes, viewReportes);
        
        ModelSucursales modelSucursales = new ModelSucursales();
        ViewSucursales viewSucursales = new ViewSucursales();
        ControllerSucursales controllerSucursales = new ControllerSucursales(modelSucursales, viewSucursales);
        
        ModelVentas modelVentas = new ModelVentas();
        ViewVentas viewVentas = new ViewVentas();
        ControllerVentas controllerVentas = new ControllerVentas(modelVentas, viewVentas);
        
        
        Object[] controllers = new Object[14];
        controllers[0] = controllerAdministradores;
        controllers[1] = controllerClientes;
        controllers[2] = controllerCompras;
        controllers[3] = controllerConsultas;
        controllers[4] = controllerCotizaciones;
        controllers[5] = controllerEmpleadosVentas;
        controllers[6] = controllerFacturacion;
        controllers[7] = controllerInicioSesion;
        controllers[8] = controllerProductos;
        controllers[9] = controllerProductosDefectuosos;
        controllers[10] = controllerPromocionesDescuentos;
        controllers[11] = controllerProveedores;
        controllers[12] = controllerReportes;
        controllers[13] = controllerSucursales;
        controllers[14] = controllerVentas;
        
        ModelMain modelMain = new ModelMain();
        ViewMain viewMain = new ViewMain();
        ControllerMain controllerMain = new ControllerMain(modelMain, viewMain, controllers);
        
    } // Cierre del método main.
    
} // Cierre de la clase Main.
