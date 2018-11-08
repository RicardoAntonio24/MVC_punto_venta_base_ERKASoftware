
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
public class ModelProductos {
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
    private int id_producto;
    private String nombre_producto;
    private String tipo_producto;
    private String marca;
    private String precio_unitario;
    private String precio_mayoreo;
    private String inicio_mayoreo;
    private String descripcion;

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

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public String getTipo_producto() {
        return tipo_producto;
    }

    public void setTipo_producto(String tipo_producto) {
        this.tipo_producto = tipo_producto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPrecio_unitario() {
        return precio_unitario;
    }

    public void setPrecio_unitario(String precio_unitario) {
        this.precio_unitario = precio_unitario;
    }

    public String getPrecio_mayoreo() {
        return precio_mayoreo;
    }

    public void setPrecio_mayoreo(String precio_mayoreo) {
        this.precio_mayoreo = precio_mayoreo;
    }

    public String getInicio_mayoreo() {
        return inicio_mayoreo;
    }

    public void setInicio_mayoreo(String inicio_mayoreo) {
        this.inicio_mayoreo = inicio_mayoreo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
  
     /**
     * Método que realiza las siguietnes acciones: 1- Conecta con la base de
     * datos ferreteria_acme, 2- Consulta todo los registros de la tabla
     * productos, 3- Obtiene todos los datos almacenados y los guarda en las
     * variables globales correspondientes.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
            String sql = "SELECT * FROM productos;";
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelProductos 001: " + err.getMessage());
        }
    }
     /**
     * Lee los valores del registro seleccionado y los asigna a las variables
     * miembro correspondientes.
     */
    public void setValues() {
        try {
            id_producto = rs.getInt("id_producto");
            nombre_producto = rs.getString("nombre_producto");
            tipo_producto = rs.getString("tipo_producto");
            marca = rs.getString("marca_producto");
            precio_unitario = rs.getString("precio_unitario");
            precio_mayoreo = rs.getString("precio_mayoreo");
            inicio_mayoreo = rs.getString("inicio_mayoreo");
            descripcion = rs.getString("descripcion");
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error modelProductos 102: " + err.getMessage());
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

                id_producto = rs.getInt("id_producto");
                nombre_producto = rs.getString("nombre_producto");
                tipo_producto = rs.getString("tipo_producto");
                marca = rs.getString("marca_producto");
                precio_unitario = rs.getString("precio_unitario");
                precio_mayoreo = rs.getString("precio_mayoreo");
                inicio_mayoreo = rs.getString("inicio_mayoreo");
                descripcion = rs.getString("descripcion");   
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
                
                id_producto = rs.getInt("id_producto");
                nombre_producto = rs.getString("nombre_producto");
                tipo_producto = rs.getString("tipo_producto");
                marca = rs.getString("marca_producto");
                precio_unitario = rs.getString("precio_unitario");
                precio_mayoreo = rs.getString("precio_mayoreo");
                inicio_mayoreo = rs.getString("inicio_mayoreo");
                descripcion = rs.getString("descripcion");   
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
                id_producto = rs.getInt("id_producto");
                nombre_producto = rs.getString("nombre_producto");
                tipo_producto = rs.getString("tipo_producto");
                marca = rs.getString("marca_producto");
                precio_unitario = rs.getString("precio_unitario");
                precio_mayoreo = rs.getString("precio_mayoreo");
                inicio_mayoreo = rs.getString("inicio_mayoreo");
                descripcion = rs.getString("descripcion");   
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
                id_producto = rs.getInt("id_producto");
                nombre_producto = rs.getString("nombre_producto");
                tipo_producto = rs.getString("tipo_producto");
                marca = rs.getString("marca_producto");
                precio_unitario = rs.getString("precio_unitario");
                precio_mayoreo = rs.getString("precio_mayoreo");
                inicio_mayoreo = rs.getString("inicio_mayoreo");
                descripcion = rs.getString("descripcion");   
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
            tipo_producto = this.getTipo_producto(); // Obtiene los valores actuales de las variables. (16)
            nombre_producto = this.getNombre_producto();
            marca = this.getMarca();
            precio_unitario = this.getPrecio_unitario();
            precio_mayoreo = this.getPrecio_mayoreo();
            inicio_mayoreo = this.getInicio_mayoreo();
            descripcion = this.getDescripcion();
            
            
            st.executeUpdate("INSERT INTO productos (tipo_producto, nombre_producto, marca_producto, precio_unitario, precio_mayoreo, inicio_mayoreo, descripcion)"
                    + " VALUES ('" + tipo_producto + "', '" + nombre_producto + "', '" + marca + "', " + precio_unitario + ", " + precio_mayoreo + ", " + inicio_mayoreo + ", '" + descripcion + "'); ");
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
            id_producto = rs.getInt("id_producto"); // Obtiene el id del registro seleccionado.
            tipo_producto = this.getTipo_producto(); // Obtiene los valores actuales de las variables. (16)
            nombre_producto = this.getNombre_producto();
            marca = this.getMarca();
            precio_unitario = this.getPrecio_unitario();
            precio_mayoreo= this.getPrecio_mayoreo();
            inicio_mayoreo = this.getInicio_mayoreo();
            descripcion = this.getDescripcion();
            
            
            st.executeUpdate("UPDATE productos SET tipo_producto = '"+ tipo_producto +"', nombre_producto = '"+ nombre_producto +"', "
                    + "marca_producto = '"+ marca +"', precio_unitario = "+ precio_unitario +", "
                        + "precio_mayoreo = "+ precio_mayoreo +", inicio_mayoreo = "+ inicio_mayoreo +", "
                            + "descripcion = '"+ descripcion +"' WHERE id_producto = "+ id_producto +"; ");
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
//                id = rs.getInt("id_producto");
//                st.executeUpdate("DELETE FROM productos WHERE id_producto = "+ id +"; ");
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
   
}// Cierre de la clase ModelClientes.
