
package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
    
    int cursor = 1; // Variable para alamacenar la posición actual del cursor de rs.
    
    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al primer registro
     * 2.- obtener los valores de los campos de rs y guardarlos en las variables
     * definidas...
     */
    public void moverPrimerRegistro() {
        try {
            String sql = "SELECT * FROM productos;";
            rs = st.executeQuery(sql);
            if (rs.next()) { // Comprueba si la consulta devolvió registros.
                rs.first(); //Primer registro
                setValues();
                cursor = 1;
            }
            
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error prim* " + err.getMessage());
        }
    }

     /**
     * Método que realiza las siguiente acciones: 1.- Moverse al anterior
     * registro 2.- obtener los valores de los campos de rs y guardarlos en las
     * variables definidas...
     */
    public void moverAnteriorRegistro() {
        try {
            String sql = "SELECT * FROM productos;";
            rs = st.executeQuery(sql);
            if (rs.next()) { // Comprueba si la consulta devolvió registros.
                if (cursor > 1) {
                    cursor--;
                    rs.absolute(cursor); // Mueve el cursor de ResultSet a un número específico de registro (Registro anterior).
                    setValues();
                }
            }
            
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error ant* " + err.getMessage());
        }          
    }
    /**
     * Método que realiza las siguiente acciones: 1.- Moverse al siguiente
     * registro 2.- obtener los valores de los campos de rs y guardarlos en las
     * variables definidas...
     */
    public void moverSiguienteRegistro() {
        try {
            ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM productos;");
            if (cons_num.next()) {
                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'productos'.
                String sql = "SELECT * FROM productos;";
                rs = st.executeQuery(sql);
                if (rs.next()) { // Comprueba si la consulta devolvió registros.
                    if (cursor < num_registros) {
                        cursor++;
                        rs.absolute(cursor); // Mueve el cursor de ResultSet a un número específico de registro (Siguiente registro).
                        setValues();
                    }
                }
            }
            
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error sig* " + err.getMessage());
        } 
    }
     /**
     * Método que realiza las siguiente acciones: 1.- Moverse al ultimo registro
     * 2.- obtener los valores de los campos de rs y guardarlos en las variables
     * definidas...
     */
    public void moverUltimoRegistro() {
        try {
            String sql = "SELECT * FROM productos;";
            rs = st.executeQuery(sql);
            if (rs.next()) { // Comprueba si la consulta devolvió registros.
                if (rs.isLast() == false) {
                    rs.last(); //Último registro
                    setValues();
                    ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM productos;");
                    if (cons_num.next()) {
                        int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'productos'.
                        cursor = num_registros;
                    }
                }
            }
            
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error ult* " + err.getMessage());
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
            id_producto = this.getId_producto(); // Obtiene el id del registro seleccionado.
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
            JOptionPane.showMessageDialog(null,"Error upd* "+err.getMessage()); 
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
    
    private int id_sucursal;
    private int existencias;
    
    public int getId_sucursal() {
        return id_sucursal;
    }
    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getExistencias() {
        return existencias;
    }
    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }
    
    private ArrayList sucursales;
    
    public ArrayList getSucursales() {
        return sucursales;
    }
    public void setSucursales(ArrayList sucursales) {
        this.sucursales = sucursales;
    }
    
    /**
     * Método para asignar los valores disponibles de la BD al ComboBox.
     */
    public void llenarComboBox() {
        // ComboBox con nombres de sucursales.
        try { // Nombres de Sucursales
            ResultSet cons = st.executeQuery("SELECT * FROM sucursales;");
//            if (cons.next()) {
                ArrayList suc = new ArrayList(); // Lista para los valores a almacenar en el ComboBox
                while (cons.next()) {
                    String num_suc = Integer.toString(cons.getInt("id_sucursal"));
                    String elemento_suc = cons.getString("nombre_sucursal");
                    String elem = num_suc + " - " + elemento_suc;
                    suc.add(elem);
                }
                this.setSucursales(suc); // Transfiere los datos al arreglo para ControllerCompras
//            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * 
     */
    public void mostrarRegistroStock() {
        try {
            id_producto = this.getId_producto();
            id_sucursal = this.getId_sucursal();
            ResultSet cons2 = st.executeQuery("SELECT * FROM productos_por_sucursal WHERE "
                    + "id_producto = "+ id_producto +" AND id_sucursal = "+ id_sucursal +"; ");
            if (cons2.next()) {
                existencias = cons2.getInt("existencia");
            }
            else {
                existencias = 0;
            }
        }
        catch (SQLException err) {
            JOptionPane.showMessageDialog(null,"Error al mostrar Stock " + err.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones: - Crea un nuevo registro y lo
     * almacena en la BD, tabla productos_por_sucursal.
     */
    public void insertarStock() {
        try {
            id_producto = this.getId_producto();
            id_sucursal = this.getId_sucursal();
            existencias = this.getExistencias();
            
            st.executeUpdate("INSERT INTO productos_por_sucursal (id_producto, id_sucursal, existencia)"
                    + " VALUES (" + id_producto + ", " + id_sucursal + ", " + existencias + "); ");
            JOptionPane.showMessageDialog(null, "Stock guardado.");
            this.conectarDB();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error s1 " + err.getMessage());
        }
    }
     /**
     * Método que realiza las siguiente acciones:
     *  - Guarda (actualiza) los cambios realizados a un registro seleccionado, tabla productos_por_sucursal.
     */
    public void modificarStock() {
        try {
            id_producto = this.getId_producto();
            id_sucursal = this.getId_sucursal();
            existencias = this.getExistencias();
            ResultSet cons_id = st.executeQuery("SELECT id_prod_por_sucursal FROM productos_por_sucursal WHERE id_producto = "+ id_producto +" AND id_sucursal = "+ id_sucursal +"; ");
            if(cons_id.next()) {
                int id_stock_prod = cons_id.getInt("id_prod_por_sucursal");
                
                st.executeUpdate("UPDATE productos_por_sucursal SET existencia = "+ existencias +" "
                        + "WHERE id_prod_por_sucursal = "+ id_stock_prod +"; ");
            }
            JOptionPane.showMessageDialog(null, "Stock modificado !.");
            this.conectarDB();
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error s2 "+err.getMessage()); 
        }
    }
    
    
    
}// Cierre de la clase ModelClientes.
