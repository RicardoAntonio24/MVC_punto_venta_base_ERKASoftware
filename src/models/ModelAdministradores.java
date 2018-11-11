
package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author ERKA Software
 */
public class ModelAdministradores {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private int id_admin;
    private String rfc_admin;
    private String nombre_admin;
    private String apellido_pat_admin;
    private String apellido_mat_admin;
    private Date fecha_nac_admin;
    private Date fecha_ingreso_admin;
    private String telefono_admin;
    private String correo_admin;
    private String calle_numero_admin;
    private String colonia_admin;
    private String cod_postal_admin;
    private String ciudad_admin;
    private String estado_admin;
    private String contrasena_admin;


    public String getCorreo_admin() {
        return correo_admin;
    }

    public void setCorreo_admin(String correo_admin) {
        this.correo_admin = correo_admin;
    }
    
    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public ResultSet getRs() {
        return rs;
    }

    public void setRs(ResultSet rs) {
        this.rs = rs;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getRfc_admin() {
        return rfc_admin;
    }

    public void setRfc_admin(String rfc_admin) {
        this.rfc_admin = rfc_admin;
    }

    public String getNombre_admin() {
        return nombre_admin;
    }

    public void setNombre_admin(String nombre_admin) {
        this.nombre_admin = nombre_admin;
    }

    public String getApellido_pat_admin() {
        return apellido_pat_admin;
    }

    public void setApellido_pat_admin(String apellido_pat_admin) {
        this.apellido_pat_admin = apellido_pat_admin;
    }

    public String getApellido_mat_admin() {
        return apellido_mat_admin;
    }

    public void setApellido_mat_admin(String apellido_mat_admin) {
        this.apellido_mat_admin = apellido_mat_admin;
    }

    public Date getFecha_nac_admin() {
        return fecha_nac_admin;
    }

    public void setFecha_nac_admin(Date fecha_nac_admin) {
        this.fecha_nac_admin = fecha_nac_admin;
    }

    public Date getFecha_ingreso_admin() {
        return fecha_ingreso_admin;
    }

    public void setFecha_ingreso_admin(Date fecha_ingreso_admin) {
        this.fecha_ingreso_admin = fecha_ingreso_admin;
    }

    public String getTelefono_admin() {
        return telefono_admin;
    }

    public void setTelefono_admin(String telefono_admin) {
        this.telefono_admin = telefono_admin;
    }

    public String getCalle_numero_admin() {
        return calle_numero_admin;
    }

    public void setCalle_numero_admin(String calle_numero_admin) {
        this.calle_numero_admin = calle_numero_admin;
    }

    public String getColonia_admin() {
        return colonia_admin;
    }

    public void setColonia_admin(String colonia_admin) {
        this.colonia_admin = colonia_admin;
    }

    public String getCod_postal_admin() {
        return cod_postal_admin;
    }

    public void setCod_postal_admin(String cod_postal_admin) {
        this.cod_postal_admin = cod_postal_admin;
    }

    public String getCiudad_admin() {
        return ciudad_admin;
    }

    public void setCiudad_admin(String ciudad_admin) {
        this.ciudad_admin = ciudad_admin;
    }

    public String getEstado_admin() {
        return estado_admin;
    }

    public void setEstado_admin(String estado_admin) {
        this.estado_admin = estado_admin;
    }

    public String getContrasena_admin() {
        return contrasena_admin;
    }

    public void setContrasena_admin(String contrasena_admin) {
        this.contrasena_admin = contrasena_admin;
    }
    
    
    private String cad_fecha_nac; 
    private String cad_fecha_ing;

    public String getCad_fecha_nac() {
        return cad_fecha_nac;
    }

    public void setCad_fecha_nac(String cad_fecha_nac) {
        this.cad_fecha_nac = cad_fecha_nac;
    }

    public String getCad_fecha_ing() {
        return cad_fecha_ing;
    }

    public void setCad_fecha_ing(String cad_fecha_ing) {
        this.cad_fecha_ing = cad_fecha_ing;
    }
    
    
    
    
    
     public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
            String sql = "SELECT * FROM administradores;";
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelAdministradores 001: " + err.getMessage());
        }
    }
    
    public void setValues() {
        try {
            id_admin = rs.getInt("id_admin");
            rfc_admin = rs.getString("rfc_admin");
            nombre_admin = rs.getString("nombre_admin");
            apellido_pat_admin = rs.getString("apellido_pat_admin");
            apellido_mat_admin = rs.getString("apellido_mat_admin");
            
            fecha_nac_admin = rs.getDate("fecha_nac_admin");
            fecha_ingreso_admin = rs.getDate("fecha_ingreso_admin");
            
            correo_admin = rs.getString("correo_admin");
            telefono_admin = rs.getString("telefono_admin");
            calle_numero_admin = rs.getString("calle_numero_admin");
            colonia_admin = rs.getString("colonia_admin");
            cod_postal_admin = rs.getString("cod_postal_admin");
            ciudad_admin = rs.getString("ciudad_admin");
            estado_admin = rs.getString("estado_admin");
            contrasena_admin = rs.getString("contrasena_admin");
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());
        }
    }
    
     public void moverPrimerRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.first(); //Primer registro

                id_admin = rs.getInt("id_admin");
                rfc_admin = rs.getString("rfc_admin");
                nombre_admin = rs.getString("nombre_admin");
                apellido_pat_admin = rs.getString("apellido_pat_admin");
                apellido_mat_admin = rs.getString("apellido_mat_admin");
            
                fecha_nac_admin = rs.getDate("fecha_nac_admin");
                fecha_ingreso_admin = rs.getDate("fecha_ingreso_admin");
                correo_admin = rs.getString("correo_admin");
                telefono_admin = rs.getString("telefono_admin");
                calle_numero_admin = rs.getString("calle_numero_admin");
                colonia_admin = rs.getString("colonia_admin");
                cod_postal_admin = rs.getString("cod_postal_admin");
                ciudad_admin = rs.getString("ciudad_admin");
                estado_admin = rs.getString("estado_admin");
                contrasena_admin = rs.getString("contrasena_admin");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    
    public void moverAnteriorRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.previous(); //Registro anterior

               id_admin = rs.getInt("id_admin");
                rfc_admin = rs.getString("rfc_admin");
                nombre_admin = rs.getString("nombre_admin");
                apellido_pat_admin = rs.getString("apellido_pat_admin");
                apellido_mat_admin = rs.getString("apellido_mat_admin");
            
                fecha_nac_admin = rs.getDate("fecha_nac_admin");
                fecha_ingreso_admin = rs.getDate("fecha_ingreso_admin");
                correo_admin = rs.getString("correo_admin");
                telefono_admin = rs.getString("telefono_admin");
                calle_numero_admin = rs.getString("calle_numero_admin");
                colonia_admin = rs.getString("colonia_admin");
                cod_postal_admin = rs.getString("cod_postal_admin");
                ciudad_admin = rs.getString("ciudad_admin");
                estado_admin = rs.getString("estado_admin");
                contrasena_admin = rs.getString("contrasena_admin");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    
    
     public void moverSiguienteRegistro() {
        try {
            if (rs.isLast() == false) {
                rs.next(); // Siguiente registro 
                
                id_admin = rs.getInt("id_admin");
                rfc_admin = rs.getString("rfc_admin");
                nombre_admin = rs.getString("nombre_admin");
                apellido_pat_admin = rs.getString("apellido_pat_admin");
                apellido_mat_admin = rs.getString("apellido_mat_admin");
            
                fecha_nac_admin = rs.getDate("fecha_nac_admin");
                fecha_ingreso_admin = rs.getDate("fecha_ingreso_admin");
                correo_admin = rs.getString("correo_admin");
                telefono_admin = rs.getString("telefono_admin");
                calle_numero_admin = rs.getString("calle_numero_admin");
                colonia_admin = rs.getString("colonia_admin");
                cod_postal_admin = rs.getString("cod_postal_admin");
                ciudad_admin = rs.getString("ciudad_admin");
                estado_admin = rs.getString("estado_admin");
                contrasena_admin = rs.getString("contrasena_admin");
                }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
     
     public void moverUltimoRegistro() {
        try {
            if (rs.isLast() == false) {
                rs.last(); //Último registro

                 id_admin = rs.getInt("id_admin");
                rfc_admin = rs.getString("rfc_admin");
                nombre_admin = rs.getString("nombre_admin");
                apellido_pat_admin = rs.getString("apellido_pat_admin");
                apellido_mat_admin = rs.getString("apellido_mat_admin");
            
                fecha_nac_admin = rs.getDate("fecha_nac_admin");
                fecha_ingreso_admin = rs.getDate("fecha_ingreso_admin");
                correo_admin = rs.getString("correo_admin");
                telefono_admin = rs.getString("telefono_admin");
                calle_numero_admin = rs.getString("calle_numero_admin");
                colonia_admin = rs.getString("colonia_admin");
                cod_postal_admin = rs.getString("cod_postal_admin");
                ciudad_admin = rs.getString("ciudad_admin");
                estado_admin = rs.getString("estado_admin");
                contrasena_admin = rs.getString("contrasena_admin");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    
     
     public void insertarRegistro() {
        try {
            rfc_admin = this.getRfc_admin(); 
            nombre_admin = this.getNombre_admin();
            apellido_pat_admin = this.getApellido_pat_admin();
            apellido_mat_admin = this.getApellido_mat_admin();
          
            cad_fecha_nac = this.getCad_fecha_nac(); // Cambio de uso de variables de Date a String para insertar registros. (2)
            cad_fecha_ing = this.getCad_fecha_ing();
            
            
            telefono_admin = this.getTelefono_admin();
            correo_admin = this.getCorreo_admin();
            calle_numero_admin = this.getCalle_numero_admin();
            colonia_admin  = this.getColonia_admin();
            cod_postal_admin = this.getCod_postal_admin();
            ciudad_admin = this.getCiudad_admin();
            estado_admin = this.getEstado_admin(); 
            contrasena_admin= this.getContrasena_admin();
            
            st.executeUpdate("INSERT INTO administradores (rfc_admin,nombre_admin,apellido_pat_admin, apellido_mat_admin, fecha_nac_admin, fecha_ingreso_admin, telefono_admin, correo_admin, calle_numero_admin , colonia_admin, cod_postal_admin, ciudad_admin, estado_admin, contrasena_admin)"
                    + " VALUES ('" + rfc_admin + "','" + nombre_admin  + "', '" + apellido_pat_admin  + "', '" +  apellido_mat_admin + "', '" +  cad_fecha_nac  + "', '" + cad_fecha_ing + "', '" + telefono_admin + "', '" + correo_admin + "', '" +  calle_numero_admin + "', '" + colonia_admin + "', '" + cod_postal_admin + "', '" + ciudad_admin + "', '" + estado_admin + "',  '" + contrasena_admin + "'); ");
            JOptionPane.showMessageDialog(null, "Registro guardado.");
            this.conectarDB();
            this.moverUltimoRegistro();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
     
     
     public void modificarRegistro() {
        try {
            rfc_admin = this.getRfc_admin(); 
            nombre_admin = this.getNombre_admin();
            apellido_pat_admin = this.getApellido_pat_admin();
            apellido_mat_admin = this.getApellido_mat_admin();
            
            cad_fecha_nac = this.getCad_fecha_nac(); 
            cad_fecha_ing = this.getCad_fecha_ing();
            
            telefono_admin = this.getTelefono_admin();
            correo_admin = this.getCorreo_admin();
            calle_numero_admin = this.getCalle_numero_admin();
            colonia_admin  = this.getColonia_admin();
            cod_postal_admin = this.getCod_postal_admin();
            ciudad_admin = this.getCiudad_admin();
            estado_admin = this.getEstado_admin(); 
            contrasena_admin= this.getContrasena_admin();

            
            st.executeUpdate("UPDATE administradores SET rfc_admin = '"+ rfc_admin +"', nombre_admin = '"+ nombre_admin +"', "
                    + "apellido_pat_admin = '"+ apellido_pat_admin +"', apellido_mat_admin = '"+ apellido_mat_admin +"', "
                        + "fecha_nac_admin = '"+ cad_fecha_nac +"', fecha_ingreso_admin  = '"+ cad_fecha_ing  +"', "
                            + "telefono_admin  = '"+ telefono_admin +"',  correo_admin  = '"+ correo_admin +"',"
                              + " calle_numero_admin  = '"+ calle_numero_admin +"', "
                                + "colonia_admin = '"+ colonia_admin +"', cod_postal_admin = '"+ cod_postal_admin +"', "
                                    + "ciudad_admin= '"+ ciudad_admin +"', estado_admin  = '"+ estado_admin  +"', "
                                        + "contrasena_admin = '"+ contrasena_admin +"' "
                                            + "WHERE id_admin = "+ id_admin +"; ");
            
            JOptionPane.showMessageDialog(null, "Se ha modificado el registro.");
            this.conectarDB();
            this.moverUltimoRegistro();
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
     
     
     
}
