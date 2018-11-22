
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ERKA Software
 */
public class ModelInicioSesion {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    
    private String nom_usuario;
    private String contrasena;
    private String rol;
    private boolean ingreso; // Variable bandera para permitir o negar el acceso al sistema.
    
    public String getNom_usuario() {
        return nom_usuario;
    }
    public void setNom_usuario(String nom_usuario) {
        this.nom_usuario = nom_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }
    public void setRol(String rol) {
        this.rol = rol;
    }
    
    public boolean isIngreso() {
        return ingreso;
    }
    public void setIngreso(boolean ingreso) {
        this.ingreso = ingreso;
    }
    
    

    /**
     * Método que realiza las siguietnes acciones: 
     * 1- Conecta con la base de datos ferreteria_acme.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
//            String sql = "SELECT * FROM administradores;"; // Probando... (3)
//            rs = st.executeQuery(sql);
//            rs.next();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 001: " + err.getMessage());
        }
    }

    /**
     * Método para verificar si las credenciales introducidas por el usuario son válidas o no.
     * Realiza la verificación con la Base de Datos.
     */
    public void iniciarSesion() {
        try {
            conectarDB();
            
            nom_usuario = this.getNom_usuario();
            contrasena = this.getContrasena();
            rol = this.getRol();
              System.out.println("    Valores: " + nom_usuario + ", " + contrasena + ", " + rol);
            
            if ("Administrador".equals(rol)) {
                String validacion = "SELECT * FROM administradores WHERE nom_usuario = '"+ nom_usuario +"' AND contrasena_admin = '"+ contrasena +"'; ";
                rs = st.executeQuery(validacion);
                if (rs.next()) {
                    ingreso = true;
                      System.out.println("  Ingreso exitoso !! " + rol);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario, Contraseña o Rol inválidos", "", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if ("Ventas".equals(rol)) {
                String validacion = "SELECT * FROM empleados_ventas WHERE nom_usuario = '"+ nom_usuario +"' AND contrasena_empleado = '"+ contrasena +"'; ";    
                rs = st.executeQuery(validacion);
                if (rs.next()) {
                    ingreso = true;
                      System.out.println("  Ingreso exitoso !! " + rol);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Nombre de usuario, Contraseña o Rol inválidos", "", JOptionPane.ERROR_MESSAGE);
                }
            }
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error 01 "+err.getMessage()); 
        }
    }

    
    
} // Cierre de la clase ModelInicioSesion.
