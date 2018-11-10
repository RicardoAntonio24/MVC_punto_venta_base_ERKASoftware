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
public class ModelSucursales {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    private int id_sucursal;
    private String nombre;
    private String telefono;
    private String calle;
    private String colonia;
    private String cod_postal;
    private String ciudad;
    private String estado;

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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

    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
            String sql = "SELECT * FROM sucursales;";
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 001: " + err.getMessage());
        }

    }

    public void setValues() {
        try {
            id_sucursal = rs.getInt("id_sucursal");
            nombre = rs.getString("nombre_sucursal");
            telefono = rs.getString("telefono_sucursal");
            calle = rs.getString("calle_numero_sucursal");
            colonia = rs.getString("colonia_sucursal");
            cod_postal = rs.getString("cod_postal_sucursal");
            ciudad = rs.getString("ciudad_sucursal");
            estado = rs.getString("estado_sucursal");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());
        }
    }

    public void moverPrimerRegistro() {
        try {
            if (rs.isFirst() == false) {
                rs.first(); //Primer registro

                id_sucursal = rs.getInt("id_sucursal");
                
                nombre = rs.getString("nombre_sucursal");
                telefono = rs.getString("telefono_sucursal");
                calle = rs.getString("calle_numero_sucursal");
                colonia = rs.getString("colonia_sucursal");
                cod_postal = rs.getString("cod_postal_sucursal");
                ciudad = rs.getString("ciudad_sucursal");
                estado = rs.getString("estado_sucursal");

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

                id_sucursal = rs.getInt("id_sucursal");

                nombre = rs.getString("nombre_sucursal");
                telefono = rs.getString("telefono_sucursal");
                calle = rs.getString("calle_numero_sucursal");
                colonia = rs.getString("colonia_sucursal");
                cod_postal = rs.getString("cod_postal_sucursal");
                ciudad = rs.getString("ciudad_sucursal");
                estado = rs.getString("estado_sucursal");
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

                id_sucursal = rs.getInt("id_sucursal");

                nombre = rs.getString("nombre_sucursal");
                telefono = rs.getString("telefono_sucursal");
                calle = rs.getString("calle_numero_sucursal");
                colonia = rs.getString("colonia_sucursal");
                cod_postal = rs.getString("cod_postal_sucursal");
                ciudad = rs.getString("ciudad_sucursal");
                estado = rs.getString("estado_sucursal");
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

                id_sucursal = rs.getInt("id_sucursal");

                nombre = rs.getString("nombre_sucursal");
                telefono = rs.getString("telefono_sucursal");
                calle = rs.getString("calle_numero_sucursal");
                colonia = rs.getString("colonia_sucursal");
                cod_postal = rs.getString("cod_postal_sucursal");
                ciudad = rs.getString("ciudad_sucursal");
                estado = rs.getString("estado_sucursal");
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

//    /**
//     * Método que realiza las siguiente acciones: - Crea un nuevo registro y lo
//     * almacena en la base de datos.
//     */
//    public void insertarRegistro() {
//        try {
//            tipo_cliente = this.getTipo_cliente(); // Obtiene los valores actuales de las variables. (16)
//            id_sucursal = rs.getInt("id_sucursal");
//
//                nombre = rs.getString("nombre_sucursal");
//                telefono = rs.getString("telefono_sucursal");
//                calle = rs.getString("calle_numero_sucursal");
//                colonia = rs.getString("colonia_sucursal");
//                cod_postal = rs.getString("cod_postal_sucursal");
//                ciudad = rs.getString("ciudad_sucursal");
//                estado = rs.getString("estado_sucursal");
//            
//            st.executeUpdate("INSERT INTO sucursales (tipo_sucursal, nombre_sucursal, telefono_sucursal, calle_numero_sucursal, colonia_sucursal, cod_postal_sucursal, ciudad_sucursal, estado_sucursal)"
//                    + " VALUES ('" + tipo_sucursal + "','""', '" + nombre + "', '" + "', '" + "', '" + telefono + "', '"+ "', '" + calle + "', '" + colonia + "', '" + cod_postal + "', '" + ciudad + "', '" + estado); ");
//            JOptionPane.showMessageDialog(null, "Registro guardado.");
//            this.conectarDB();
//            this.moverUltimoRegistro();
//        } catch (SQLException err) {
//            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
//        }
//    }
//
//    /**
//     * Método que realiza las siguiente acciones:
//     *  - Guarda (actualiza) los cambios realizados a un registro seleccionado.
//     */
//    public void modificarRegistro() {
//        try {
//            id_sucursal = rs.getInt("id_sucursal");
//
//                nombre = rs.getString("nombre_sucursal");
//                telefono = rs.getString("telefono_sucursal"); 
//                calle = rs.getString("calle_numero_sucursal");
//                colonia = rs.getString("colonia_sucursal");
//                cod_postal = rs.getString("cod_postal_sucursal");
//                ciudad = rs.getString("ciudad_sucursal");
//                estado = rs.getString("estado_sucursal");
//            
//            st.executeUpdate("UPDATE clientes SET tipo_cliente = '"+ tipo_sucursal +"', rfc_cliente = '"+ rfc +"', "
//                    + "nombre_sucursal = '"+ nombre +"', apellido_pat_cliente = '"+ apellido_pat +"', "
//                        
//                            
//                                + "colonia_sucursal = '"+ colonia +"', cod_postal_sucursal = '"+ cod_postal +"', "
//                                    + "ciudad_sucursal = '"+ ciudad +"', estado_sucursal = '"+ estado +"', "
//                                        + "nombre_sucursal = '"+ nom_sucursal +"', "
//                                            
//                                                
//                                                    + "telefono_sucursal = '"+ telefono_sucursal +"' "
//                                                        + "WHERE id_sucursal = "+ id_sucursal +"; ");
//            JOptionPane.showMessageDialog(null, "Se ha modificado el registro.");
//            this.conectarDB();
//            this.moverUltimoRegistro();
//        }
//        catch(SQLException err) { 
//            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
//        }
//    }
//  

    

}