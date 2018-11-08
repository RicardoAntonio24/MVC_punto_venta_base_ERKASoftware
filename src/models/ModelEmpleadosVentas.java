
package models;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;


public class ModelEmpleadosVentas {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private int id_empleado;
    private String rfc_empleado;
    private String nombre_empleado;
    private String apellido_pat_empleado;
    private String apellido_mat_empleado;
    private Date fecha_nac_empleado;
    private Date fecha_ingreso_empleado;
    private String telefono_empleado;
    private String calle_numero_empleado;
    private String colonia_empleado;
    private String cod_postal_empleado;
    private String ciudad_empleado;
    private String estado_empleado;
    private String contrasena_empleado;
   

    public String getCiudad_empleado() {
        return ciudad_empleado;
    }

    public void setCiudad_empleado(String ciudad_empleado) {
        this.ciudad_empleado = ciudad_empleado;
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

    public int getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getRfc_empleado() {
        return rfc_empleado;
    }

    public void setRfc_empleado(String rfc_empleado) {
        this.rfc_empleado = rfc_empleado;
    }

    public String getNombre_empleado() {
        return nombre_empleado;
    }

    public void setNombre_empleado(String nombre_empleado) {
        this.nombre_empleado = nombre_empleado;
    }

    public String getApellido_pat_empleado() {
        return apellido_pat_empleado;
    }

    public void setApellido_pat_empleado(String apellido_pat_empleado) {
        this.apellido_pat_empleado = apellido_pat_empleado;
    }

    public String getApellido_mat_empleado() {
        return apellido_mat_empleado;
    }

    public void setApellido_mat_empleado(String apellido_mat_empleado) {
        this.apellido_mat_empleado = apellido_mat_empleado;
    }

    public Date getFecha_nac_empleado() {
        return fecha_nac_empleado;
    }

    public void setFecha_nac_empleado(Date fecha_nac_empleado) {
        this.fecha_nac_empleado = fecha_nac_empleado;
    }

    public Date getFecha_ingreso_empleado() {
        return fecha_ingreso_empleado;
    }

    public void setFecha_ingreso_empleado(Date fecha_ingreso_empleado) {
        this.fecha_ingreso_empleado = fecha_ingreso_empleado;
    }

    public String getTelefono_empleado() {
        return telefono_empleado;
    }

    public void setTelefono_empleado(String telefono_empleado) {
        this.telefono_empleado = telefono_empleado;
    }

    public String getCalle_numero_empleado() {
        return calle_numero_empleado;
    }

    public void setCalle_numero_empleado(String calle_numero_empleado) {
        this.calle_numero_empleado = calle_numero_empleado;
    }

    public String getColonia_empleado() {
        return colonia_empleado;
    }

    public void setColonia_empleado(String colonia_empleado) {
        this.colonia_empleado = colonia_empleado;
    }

    public String getCod_postal_empleado() {
        return cod_postal_empleado;
    }

    public void setCod_postal_empleado(String cod_postal_empleado) {
        this.cod_postal_empleado = cod_postal_empleado;
    }

    public String getEstado_empleado() {
        return estado_empleado;
    }

    public void setEstado_empleado(String estado_empleado) {
        this.estado_empleado = estado_empleado;
    }

    public String getContrasena_empleado() {
        return contrasena_empleado;
    }

    public void setContrasena_empleado(String contrasena_empleado) {
        this.contrasena_empleado = contrasena_empleado;
    }

    

   
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
            String sql = "SELECT * FROM empleados_ventas;";
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelEmpleadosVentas 001: " + err.getMessage());
        }
    }
    
    public void setValues() {
        try {
            id_empleado = rs.getInt("id_empleado");
            rfc_empleado = rs.getString("rfc_empleado");
            nombre_empleado = rs.getString("nombre_empleado");
            apellido_pat_empleado = rs.getString("apellido_pat_empleado");
            apellido_mat_empleado = rs.getString("apellido_mat_empleado");
            
            fecha_nac_empleado = rs.getDate("fecha_nac_empleado");
            fecha_ingreso_empleado = rs.getDate("fecha_ingreso_empleado");
            
            telefono_empleado = rs.getString("telefono_empleado");
            calle_numero_empleado = rs.getString("calle_numero_empleado");
            colonia_empleado = rs.getString("colonia_empleado");
            cod_postal_empleado = rs.getString("cod_postal_empleado");
            ciudad_empleado = rs.getString("ciudad_empleado");
            estado_empleado = rs.getString("estado_empleado");
            contrasena_empleado = rs.getString("contrasena_empleado");
            
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());
        }
    }
    
    public void moverPrimerRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.first(); //Primer registro

                id_empleado = rs.getInt("id_empleado");
                rfc_empleado = rs.getString("rfc_empleado");
                nombre_empleado = rs.getString("nombre_empleado");
                apellido_pat_empleado = rs.getString("apellido_pat_empleado");
                apellido_mat_empleado = rs.getString("apellido_mat_empleado");
                
                fecha_nac_empleado = rs.getDate("fecha_nac_empleado");
                fecha_ingreso_empleado = rs.getDate("fecha_ingreso_empleado");
                
                telefono_empleado = rs.getString("telefono_empleado");
                calle_numero_empleado = rs.getString("calle_numero_empleado");
                colonia_empleado = rs.getString("colonia_empleado");
                cod_postal_empleado = rs.getString("cod_postal_empleado");
                ciudad_empleado = rs.getString("ciudad_empleado");
                estado_empleado = rs.getString("estado_empleado");
                contrasena_empleado = rs.getString("contrasena_empleado");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    
    public void moverAnteriorRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.previous(); //Registro anterior

                id_empleado = rs.getInt("id_empleado");
                rfc_empleado = rs.getString("rfc_empleado");
                nombre_empleado = rs.getString("nombre_empleado");
                apellido_pat_empleado = rs.getString("apellido_pat_empleado");
                apellido_mat_empleado = rs.getString("apellido_mat_empleado");
                
                fecha_nac_empleado = rs.getDate("fecha_nac_empleado");
                fecha_ingreso_empleado = rs.getDate("fecha_ingreso_empleado");
                
                telefono_empleado = rs.getString("telefono_empleado");
                calle_numero_empleado = rs.getString("calle_numero_empleado");
                colonia_empleado = rs.getString("colonia_empleado");
                cod_postal_empleado = rs.getString("cod_postal_empleado");
                ciudad_empleado = rs.getString("ciudad_empleado");
                estado_empleado = rs.getString("estado_empleado");
                contrasena_empleado = rs.getString("contrasena_empleado");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
 
     public void moverSiguienteRegistro() {
        try {
            if (rs.isLast() == false) {
                rs.next(); // Siguiente registro 
                
                id_empleado = rs.getInt("id_empleado");
                rfc_empleado = rs.getString("rfc_empleado");
                nombre_empleado = rs.getString("nombre_empleado");
                apellido_pat_empleado = rs.getString("apellido_pat_empleado");
                apellido_mat_empleado = rs.getString("apellido_mat_empleado");
                
                fecha_nac_empleado = rs.getDate("fecha_nac_empleado");
                fecha_ingreso_empleado = rs.getDate("fecha_ingreso_empleado");
                
                telefono_empleado = rs.getString("telefono_empleado");
                calle_numero_empleado = rs.getString("calle_numero_empleado");
                colonia_empleado = rs.getString("colonia_empleado");
                cod_postal_empleado = rs.getString("cod_postal_empleado");
                ciudad_empleado = rs.getString("ciudad_empleado");
                estado_empleado = rs.getString("estado_empleado");
                contrasena_empleado = rs.getString("contrasena_empleado");
                }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    
    public void moverUltimoRegistro() {
        try {
            if (rs.isLast() == false) {
                rs.last(); //Último registro

                id_empleado = rs.getInt("id_empleado");
                rfc_empleado = rs.getString("rfc_empleado");
                nombre_empleado = rs.getString("nombre_empleado");
                apellido_pat_empleado = rs.getString("apellido_pat_empleado");
                apellido_mat_empleado = rs.getString("apellido_mat_empleado");
                
                fecha_nac_empleado = rs.getDate("fecha_nac_empleado");
                fecha_ingreso_empleado = rs.getDate("fecha_ingreso_empleado");
                
                telefono_empleado = rs.getString("telefono_empleado");
                calle_numero_empleado = rs.getString("calle_numero_empleado");
                colonia_empleado = rs.getString("colonia_empleado");
                cod_postal_empleado = rs.getString("cod_postal_empleado");
                ciudad_empleado = rs.getString("ciudad_empleado");
                estado_empleado = rs.getString("estado_empleado");
                contrasena_empleado = rs.getString("contrasena_empleado");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    
    
    public void insertarRegistro() {
        try {
            rfc_empleado = this.getRfc_empleado(); 
            nombre_empleado = this.getNombre_empleado();
            apellido_pat_empleado = this.getApellido_pat_empleado();
            apellido_mat_empleado = this.getApellido_mat_empleado();
            fecha_nac_empleado = this.getFecha_nac_empleado();
            fecha_ingreso_empleado = this.getFecha_ingreso_empleado();
            
            telefono_empleado = this.getTelefono_empleado();
            
            calle_numero_empleado = this.getCalle_numero_empleado();
            colonia_empleado  = this.getColonia_empleado();
            cod_postal_empleado = this.getCod_postal_empleado();
            ciudad_empleado = this.getCiudad_empleado();
            estado_empleado = this.getEstado_empleado(); 
            contrasena_empleado= this.getContrasena_empleado();
            
            st.executeUpdate("INSERT INTO empleados_ventas (rfc_empleado,nombre_empleado,apellido_pat_empleado, apellido_mat_empleado, fecha_nac_empleado, fecha_ingreso_empleado, telefono_empleado, calle_numero_empleado , colonia_empleado, cod_postal_empleado, ciudad_empleado, estado_empleado, contrasena_empleado)"
                    + " VALUES ('" + rfc_empleado + "','" + nombre_empleado  + "', '" + apellido_pat_empleado  + "', '" +  apellido_mat_empleado + "', '" +  fecha_nac_empleado  + "', '" + fecha_ingreso_empleado + "', '" + telefono_empleado + "', '" +  calle_numero_empleado + "', '" + colonia_empleado + "', '" + cod_postal_empleado + "', '" + ciudad_empleado + "', '" + estado_empleado + "',  '" + contrasena_empleado + "'); ");
            JOptionPane.showMessageDialog(null, "Registro guardado.");
            this.conectarDB();
            this.moverUltimoRegistro();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    
    public void modificarRegistro() {
        try {
            id_empleado = rs.getInt("id_empleado"); 
            rfc_empleado = this.getRfc_empleado(); 
            nombre_empleado = this.getNombre_empleado();
            apellido_pat_empleado = this.getApellido_pat_empleado();
            apellido_mat_empleado = this.getApellido_mat_empleado();
            fecha_nac_empleado = this.getFecha_nac_empleado();
            fecha_ingreso_empleado = this.getFecha_ingreso_empleado();
            telefono_empleado = this.getTelefono_empleado();
            calle_numero_empleado = this.getCalle_numero_empleado();
            colonia_empleado  = this.getColonia_empleado();
            cod_postal_empleado = this.getCod_postal_empleado();
            ciudad_empleado = this.getCiudad_empleado();
            estado_empleado = this.getEstado_empleado(); 
            contrasena_empleado= this.getContrasena_empleado();

            
            st.executeUpdate("UPDATE empleados_ventas SET rfc_empleado = '"+ rfc_empleado +"', nombre_empleado = '"+ nombre_empleado +"', "
                    + "apellido_pat_empleado = '"+ apellido_pat_empleado +"', apellido_mat_empleado = '"+ apellido_mat_empleado +"', "
                        + "fecha_nac_empleado = '"+ fecha_nac_empleado +"', fecha_ingreso_empleado  = '"+ fecha_ingreso_empleado  +"', "
                            + "telefono_empleado  = '"+ telefono_empleado +"', calle_numero_empleado  = '"+ calle_numero_empleado +"', "
                                + "colonia_empleado = '"+ colonia_empleado+"', cod_postal_empleado = '"+ cod_postal_empleado +"', "
                                    + "ciudad_empleado= '"+ ciudad_empleado +"', estado_empleado  = '"+ estado_empleado  +"', "
                                        + "contrasena_empleado = '"+ contrasena_empleado+"', "
                                            + "WHERE id_empleado = "+ id_empleado +"; ");
            
            JOptionPane.showMessageDialog(null, "Se ha modificado el registro.");
            this.conectarDB();
            this.moverUltimoRegistro();
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
    
    
    
    
    
}
