
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
public class ModelClientes {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private int id_cliente;
    private String tipo_cliente;
    private String rfc;
    private String nombre;
    private String apellido_pat;
    private String apellido_mat;
    private String telefono;
    private String correo;
    private String calle;
    private String colonia;
    private String cod_postal;
    private String ciudad;
    private String estado;
    private String nom_representante;
    private String ap_pat_representante;
    private String ap_mat_representante;
    private String telefono_representante;

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido_pat() {
        return apellido_pat;
    }

    public void setApellido_pat(String apellido_pat) {
        this.apellido_pat = apellido_pat;
    }

    public String getApellido_mat() {
        return apellido_mat;
    }

    public void setApellido_mat(String apellido_mat) {
        this.apellido_mat = apellido_mat;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNom_representante() {
        return nom_representante;
    }

    public void setNom_representante(String nom_representante) {
        this.nom_representante = nom_representante;
    }

    public String getAp_pat_representante() {
        return ap_pat_representante;
    }

    public void setAp_pat_representante(String ap_pat_representante) {
        this.ap_pat_representante = ap_pat_representante;
    }

    public String getAp_mat_representante() {
        return ap_mat_representante;
    }

    public void setAp_mat_representante(String ap_mat_representante) {
        this.ap_mat_representante = ap_mat_representante;
    }

    public String getTelefono_representante() {
        return telefono_representante;
    }

    public void setTelefono_representante(String telefono_representante) {
        this.telefono_representante = telefono_representante;
    }

    /**
     * Método que realiza las siguietnes acciones: 1- Conecta con la base de
     * datos ferreteria_acme, 2- Consulta todo los registros de la tabla
     * clientes, 3- Obtiene todos los datos almacenados y los guarda en las
     * variables globales correspondientes.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
            String sql = "SELECT * FROM clientes;";
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 001: " + err.getMessage());
        }
    }

    /**
     * Lee los valores del registro seleccionado y los asigna a las variables
     * miembro correspondientes.
     */
    public void setValues() {
        try {
            id_cliente = rs.getInt("id_cliente");
            tipo_cliente = rs.getString("tipo_cliente");
            rfc = rs.getString("rfc_cliente");
            nombre = rs.getString("nombre_cliente");
            apellido_pat = rs.getString("apellido_pat_cliente");
            apellido_mat = rs.getString("apellido_mat_cliente");
            telefono = rs.getString("telefono_cliente");
            correo = rs.getString("correo_cliente");
            calle = rs.getString("calle_numero_cliente");
            colonia = rs.getString("colonia_cliente");
            cod_postal = rs.getString("cod_postal_cliente");
            ciudad = rs.getString("ciudad_cliente");
            estado = rs.getString("estado_cliente");

            nom_representante = rs.getString("nombre_representante");
            ap_pat_representante = rs.getString("apellido_pat_representante");
            ap_mat_representante = rs.getString("apellido_mat_representante");
            telefono_representante = rs.getString("telefono_representante");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al primer registro
     * 2.- obtener los valores de los campos de rs y guardarlos en las variables
     * definidas...
     */
    public void moverPrimerRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.first(); //Primer registro

                id_cliente = rs.getInt("id_cliente");
                tipo_cliente = rs.getString("tipo_cliente");
                rfc = rs.getString("rfc_cliente");
                nombre = rs.getString("nombre_cliente");
                apellido_pat = rs.getString("apellido_pat_cliente");
                apellido_mat = rs.getString("apellido_mat_cliente");
                telefono = rs.getString("telefono_cliente");
                correo = rs.getString("correo_cliente");
                calle = rs.getString("calle_numero_cliente");
                colonia = rs.getString("colonia_cliente");
                cod_postal = rs.getString("cod_postal_cliente");
                ciudad = rs.getString("ciudad_cliente");
                estado = rs.getString("estado_cliente");

                nom_representante = rs.getString("nombre_representante");
                ap_pat_representante = rs.getString("apellido_pat_representante");
                ap_mat_representante = rs.getString("apellido_mat_representante");
                telefono_representante = rs.getString("telefono_representante");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al anterior
     * registro 2.- obtener los valores de los campos de rs y guardarlos en las
     * variables definidas...
     */
    public void moverAnteriorRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.previous(); //Registro anterior

                id_cliente = rs.getInt("id_cliente");
                tipo_cliente = rs.getString("tipo_cliente");
                rfc = rs.getString("rfc_cliente");
                nombre = rs.getString("nombre_cliente");
                apellido_pat = rs.getString("apellido_pat_cliente");
                apellido_mat = rs.getString("apellido_mat_cliente");
                telefono = rs.getString("telefono_cliente");
                correo = rs.getString("correo_cliente");
                calle = rs.getString("calle_numero_cliente");
                colonia = rs.getString("colonia_cliente");
                cod_postal = rs.getString("cod_postal_cliente");
                ciudad = rs.getString("ciudad_cliente");
                estado = rs.getString("estado_cliente");

                nom_representante = rs.getString("nombre_representante");
                ap_pat_representante = rs.getString("apellido_pat_representante");
                ap_mat_representante = rs.getString("apellido_mat_representante");
                telefono_representante = rs.getString("telefono_representante");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al siguiente
     * registro 2.- obtener los valores de los campos de rs y guardarlos en las
     * variables definidas...
     */
    public void moverSiguienteRegistro() {
        try {
            if (rs.isLast() == false) {
                rs.next(); // Siguiente registro 

                id_cliente = rs.getInt("id_cliente");
                tipo_cliente = rs.getString("tipo_cliente");
                rfc = rs.getString("rfc_cliente");
                nombre = rs.getString("nombre_cliente");
                apellido_pat = rs.getString("apellido_pat_cliente");
                apellido_mat = rs.getString("apellido_mat_cliente");
                telefono = rs.getString("telefono_cliente");
                correo = rs.getString("correo_cliente");
                calle = rs.getString("calle_numero_cliente");
                colonia = rs.getString("colonia_cliente");
                cod_postal = rs.getString("cod_postal_cliente");
                ciudad = rs.getString("ciudad_cliente");
                estado = rs.getString("estado_cliente");

                nom_representante = rs.getString("nombre_representante");
                ap_pat_representante = rs.getString("apellido_pat_representante");
                ap_mat_representante = rs.getString("apellido_mat_representante");
                telefono_representante = rs.getString("telefono_representante");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al ultimo registro
     * 2.- obtener los valores de los campos de rs y guardarlos en las variables
     * definidas...
     */
    public void moverUltimoRegistro() {
        try {
            if (rs.isLast() == false) {
                rs.last(); //Último registro

                id_cliente = rs.getInt("id_cliente");
                tipo_cliente = rs.getString("tipo_cliente");
                rfc = rs.getString("rfc_cliente");
                nombre = rs.getString("nombre_cliente");
                apellido_pat = rs.getString("apellido_pat_cliente");
                apellido_mat = rs.getString("apellido_mat_cliente");
                telefono = rs.getString("telefono_cliente");
                correo = rs.getString("correo_cliente");
                calle = rs.getString("calle_numero_cliente");
                colonia = rs.getString("colonia_cliente");
                cod_postal = rs.getString("cod_postal_cliente");
                ciudad = rs.getString("ciudad_cliente");
                estado = rs.getString("estado_cliente");

                nom_representante = rs.getString("nombre_representante");
                ap_pat_representante = rs.getString("apellido_pat_representante");
                ap_mat_representante = rs.getString("apellido_mat_representante");
                telefono_representante = rs.getString("telefono_representante");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    
    /**
     * Método que realiza las siguiente acciones: - Crea un nuevo registro y lo
     * almacena en la base de datos.
     */
    public void insertarRegistro() {
        try {
            tipo_cliente = this.getTipo_cliente(); // Obtiene los valores actuales de las variables. (16)
            rfc = this.getRfc();
            nombre = this.getNombre();
            apellido_pat = this.getApellido_pat();
            apellido_mat = this.getApellido_mat();
            telefono = this.getTelefono();
            correo = this.getCorreo();
            calle = this.getCalle();
            colonia = this.getColonia();
            cod_postal = this.getCod_postal();
            ciudad = this.getCiudad();
            estado = this.getEstado();
            nom_representante = this.getNom_representante();
            ap_pat_representante = this.getAp_pat_representante();
            ap_mat_representante = this.getAp_mat_representante();
            telefono_representante = this.getTelefono_representante();
            
            st.executeUpdate("INSERT INTO clientes (tipo_cliente, rfc_cliente, nombre_cliente, apellido_pat_cliente, apellido_mat_cliente, telefono_cliente, correo_cliente, calle_numero_cliente, colonia_cliente, cod_postal_cliente, ciudad_cliente, estado_cliente, nombre_representante, apellido_pat_representante, apellido_mat_representante, telefono_representante)"
                    + " VALUES ('" + tipo_cliente + "','" + rfc + "', '" + nombre + "', '" + apellido_pat + "', '" + apellido_mat + "', '" + telefono + "', '" + correo + "', '" + calle + "', '" + colonia + "', '" + cod_postal + "', '" + ciudad + "', '" + estado + "', '" + nom_representante + "', '" + ap_pat_representante + "', '" + ap_mat_representante + "', '" + telefono_representante + "'); ");
            JOptionPane.showMessageDialog(null, "Registro guardado.");
            this.conectarDB();
            this.moverUltimoRegistro();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones:
     *  - Guarda (actualiza) los cambios realizados a un registro seleccionado.
     */
    public void modificarRegistro() {
        try {
            id_cliente = rs.getInt("id_cliente"); // Obtiene el id del registro seleccionado.
            tipo_cliente = this.getTipo_cliente(); // Obtiene los valores actuales de las variables. (16)
            rfc = this.getRfc();
            nombre = this.getNombre();
            apellido_pat = this.getApellido_pat();
            apellido_mat = this.getApellido_mat();
            telefono = this.getTelefono();
            correo = this.getCorreo();
            calle = this.getCalle();
            colonia = this.getColonia();
            cod_postal = this.getCod_postal();
            ciudad = this.getCiudad();
            estado = this.getEstado();
            nom_representante = this.getNom_representante();
            ap_pat_representante = this.getAp_pat_representante();
            ap_mat_representante = this.getAp_mat_representante();
            telefono_representante = this.getTelefono_representante();
            
            st.executeUpdate("UPDATE clientes SET tipo_cliente = '"+ tipo_cliente +"', rfc_cliente = '"+ rfc +"', "
                    + "nombre_cliente = '"+ nombre +"', apellido_pat_cliente = '"+ apellido_pat +"', "
                        + "apellido_mat_cliente = '"+ apellido_mat +"', telefono_cliente = '"+ telefono +"', "
                            + "correo_cliente = '"+ correo +"', calle_numero_cliente = '"+ calle +"', "
                                + "colonia_cliente = '"+ colonia +"', cod_postal_cliente = '"+ cod_postal +"', "
                                    + "ciudad_cliente = '"+ ciudad +"', estado_cliente = '"+ estado +"', "
                                        + "nombre_representante = '"+ nom_representante +"', "
                                            + "apellido_pat_representante = '"+ ap_pat_representante +"', "
                                                + "apellido_mat_representante = '"+ ap_mat_representante +"', "
                                                    + "telefono_representante = '"+ telefono_representante +"' "
                                                        + "WHERE id_cliente = "+ id_cliente +"; ");
            JOptionPane.showMessageDialog(null, "Se ha modificado el registro.");
            this.conectarDB();
            this.moverUltimoRegistro();
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
    
//    /**
//     * Método que realiza las siguiente acciones:
//     *  - Muestra un mensaje preguntando si el usuario desea borrar el registro. S
//     *  - Si hace clic en si, se elimina el registro, en caso de hacer clic en no, no se elimina el registro.
//     */
//    public void eliminarRegistro() {
//        try {
//            int respuesta = JOptionPane.showConfirmDialog(null, "¿Eliminar este registro?", "Borrar", JOptionPane.YES_NO_OPTION);
//            if (respuesta == JOptionPane.YES_OPTION) {
//                id = rs.getInt("id_contacto");
//                st.executeUpdate("DELETE FROM contactos WHERE id_contacto = "+ id +"; ");
//                
//                this.conectarDB();
//                this.moverUltimoRegistro();
//            }
//            else {
//                this.conectarDB();
//                this.moverUltimoRegistro();
//            }
//        }
//        catch(SQLException err) { 
//            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
//        }
//    }
    
} // Cierre de la clase ModelClientes.
