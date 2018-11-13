package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ERKA Software
 */
public class ModelCompras {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    // Variables para la gestión de Compras:
    private int id_compra;
    private Date fecha;
    private int id_sucursal;
    private int id_admin;
    private int id_proveedor;
    private float subtotal;
    private float iva;
    private float imp_total;

    public int getId_compra() {
        return id_compra;
    }

    public void setId_compra(int id_compra) {
        this.id_compra = id_compra;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public float getIva() {
        return iva;
    }

    public void setIva(float iva) {
        this.iva = iva;
    }

    public float getImp_total() {
        return imp_total;
    }

    public void setImp_total(float imp_total) {
        this.imp_total = imp_total;
    }

    private ArrayList sucursales;
    private ArrayList admins;
    private ArrayList proveedores;

    public ArrayList getSucursales() {
        return sucursales;
    }

    public void setSucursales(ArrayList sucursales) {
        this.sucursales = sucursales;
    }

    public ArrayList getAdmins() {
        return admins;
    }

    public void setAdmins(ArrayList admins) {
        this.admins = admins;
    }

    public ArrayList getProveedores() {
        return proveedores;
    }

    public void setProveedores(ArrayList proveedores) {
        this.proveedores = proveedores;
    }

    private String nom_sucursal;
    private String nom_admin;
    private String nom_proveedor;

    public String getNom_sucursal() {
        return nom_sucursal;
    }

    public void setNom_sucursal(String nom_sucursal) {
        this.nom_sucursal = nom_sucursal;
    }

    public String getNom_admin() {
        return nom_admin;
    }

    public void setNom_admin(String nom_admin) {
        this.nom_admin = nom_admin;
    }

    public String getNom_proveedor() {
        return nom_proveedor;
    }

    public void setNom_proveedor(String nom_proveedor) {
        this.nom_proveedor = nom_proveedor;
    }

    private String cad_fecha_com; // Variable adicional para la correcta inserción de la fecha de compra en un registro.

    public String getCad_fecha_com() {
        return cad_fecha_com;
    }

    public void setCad_fecha_com(String cad_fecha_com) {
        this.cad_fecha_com = cad_fecha_com;
    }

    // Variables para la gestión de detalles de Compras:
    private int id_det_compra;
    private int id_compra_2;
    private int id_producto;
    private int cantidad;
    private float precio_compra;
    private float total_prod;

    public int getId_det_compra() {
        return id_det_compra;
    }

    public void setId_det_compra(int id_det_compra) {
        this.id_det_compra = id_det_compra;
    }

    public int getId_compra_2() {
        return id_compra_2;
    }

    public void setId_compra_2(int id_compra_2) {
        this.id_compra_2 = id_compra_2;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getPrecio_compra() {
        return precio_compra;
    }

    public void setPrecio_compra(float precio_compra) {
        this.precio_compra = precio_compra;
    }

    public float getTotal_prod() {
        return total_prod;
    }

    public void setTotal_prod(float total_prod) {
        this.total_prod = total_prod;
    }

    private ArrayList productos;

    public ArrayList getProductos() {
        return productos;
    }

    public void setProductos(ArrayList productos) {
        this.productos = productos;
    }

    private String nom_producto;

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    /**
     * Método que realiza las siguietnes acciones: 1- Conecta con la base de
     * datos ferreteria_acme, 2- Consulta todo los registros de la tabla
     * compras, 3- Obtiene todos los datos almacenados y los guarda en las
     * variables globales correspondientes.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
            String sql = "SELECT * FROM compras;";
            rs = st.executeQuery(sql);
            rs.next();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelClientes 001: " + err.getMessage());
        }
    }

    /**
     * Método para asignar los valores disponibles de la BD a los ComboBox.
     */
    public void llenarComboBox() {
        // ComboBox con nombres de sucursales, administradores y proveedores
        try { // Nombres de Sucursales
            rs = st.executeQuery("SELECT * FROM sucursales;");
            ArrayList suc = new ArrayList(); // Lista para los valores a almacenar en el ComboBox
            while (rs.next()) {
                String elemento_suc = rs.getString("nombre_sucursal");
                suc.add(elemento_suc);
            }
            this.setSucursales(suc); // Transfiere los datos al arreglo para ControllerCompras

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try { // Nombres de Administradores
            rs = st.executeQuery("SELECT * FROM administradores;");
            ArrayList adm = new ArrayList(); // Lista para los valores a almacenar en el ComboBox
            while (rs.next()) {
                String elemento_adm = rs.getString("nombre_admin");
                adm.add(elemento_adm);
            }
            this.setAdmins(adm); // Transfiere los datos al arreglo para ControllerCompras

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try { // Nombres de Proveedores
            rs = st.executeQuery("SELECT * FROM proveedores;");
            ArrayList prov = new ArrayList(); // Lista para los valores a almacenar en el ComboBox
            while (rs.next()) {
                String elemento_prov = rs.getString("nombre_proveedor");
                prov.add(elemento_prov);
            }
            this.setProveedores(prov); // Transfiere los datos al arreglo para ControllerCompras

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        // ComboBox con nombres de productos disponibles
        try { // Nombres de Productos
            rs = st.executeQuery("SELECT * FROM productos;");
            ArrayList prod = new ArrayList(); // Lista para los valores a almacenar en el ComboBox
            while (rs.next()) {
                String elem_producto = rs.getString("nombre_producto");
                prod.add(elem_producto);
            }
            this.setProductos(prod); // Transfiere los datos al arreglo para ControllerCompras

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    /**
     * Lee los valores del registro seleccionado y los asigna a las variables
     * miembro correspondientes.
     */
    public void setValues() {
        try {
            id_compra = rs.getInt("id_compra");
            fecha = rs.getDate("fecha_compra");
            subtotal = rs.getFloat("subtotal_compra");
            iva = rs.getFloat("iva_compra");
            imp_total = rs.getFloat("importe_total_compra");

            id_sucursal = rs.getInt("id_sucursal");
            id_admin = rs.getInt("id_admin");
            id_proveedor = rs.getInt("id_proveedor");
            // Obtiene los nombres requeridos (sucursal, administrador, proveedor) para asginarlos a los ComboBox...
            String cons_suc = "SELECT nombre_sucursal FROM sucursales WHERE id_sucursal = " + id_sucursal + "; ";
            rs = st.executeQuery(cons_suc);
            if (rs.next()) {
                nom_sucursal = rs.getString(1);
            }
            String cons_adm = "SELECT nombre_admin FROM administradores WHERE id_admin = " + id_admin + "; ";
            rs = st.executeQuery(cons_adm);
            if (rs.next()) {
                nom_admin = rs.getString(1);
            }
            String cons_prv = "SELECT nombre_proveedor FROM proveedores WHERE id_proveedor = " + id_proveedor + "; ";
            rs = st.executeQuery(cons_prv);
            if (rs.next()) {
                nom_proveedor = rs.getString(1);
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());
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
            String sql = "SELECT * FROM compras;";
            rs = st.executeQuery(sql);
            if (rs.next()) { // Comprueba si la consulta devolvió registros.
                rs.first(); //Primer registro
                setValues();
                cursor = 1;
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
            String sql = "SELECT * FROM compras;";
            rs = st.executeQuery(sql);
            if (rs.next()) { // Comprueba si la consulta devolvió registros.
                if (cursor > 1) {
                    cursor--;
                    rs.absolute(cursor); // Mueve el cursor de ResultSet a un número específico de registro.
                    setValues();
                }
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
            ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM compras;");
            if (cons_num.next()) {
                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'compras'.
                String sql = "SELECT * FROM compras;";
                rs = st.executeQuery(sql);
                if (rs.next()) { // Comprueba si la consulta devolvió registros.
                    if (cursor < num_registros) {
                        cursor++;
                        rs.absolute(cursor); // Mueve el cursor de ResultSet a un número específico de registro.
                        setValues();
                    }
                }
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
            String sql = "SELECT * FROM compras;";
            rs = st.executeQuery(sql);
            if (rs.next()) { // Comprueba si la consulta devolvió registros.
                if (rs.isLast() == false) {
                    rs.last(); //Último registro
                    setValues();
                    ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM compras;");
                    if (cons_num.next()) {
                        int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'compras'.
                        cursor = num_registros;
                    }
                }
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
            cad_fecha_com = this.getCad_fecha_com(); // Obtienen los valores actuales de las variables. (7)
            // Segmento de código para obtener los id´s en base a los nombres existentes en los ComboBox...
            String cons = "SELECT * FROM sucursales WHERE nombre_sucursal = '" + this.getNom_sucursal() + "'; ";
            rs = st.executeQuery(cons);
            if (rs.next()) {
                id_sucursal = rs.getInt("id_sucursal");
            }
            cons = "SELECT * FROM administradores WHERE nombre_admin = '" + this.getNom_admin() + "'; ";
            rs = st.executeQuery(cons);
            if (rs.next()) {
                id_admin = rs.getInt("id_admin");
            }
            cons = "SELECT * FROM proveedores WHERE nombre_proveedor = '" + this.getNom_proveedor() + "'; ";
            rs = st.executeQuery(cons);
            if (rs.next()) {
                id_proveedor = rs.getInt("id_proveedor");
            }

            subtotal = this.getSubtotal();
            iva = this.getIva();
            imp_total = this.getImp_total();

            st.executeUpdate("INSERT INTO compras (fecha_compra, id_sucursal, id_admin, id_proveedor, subtotal_compra, iva_compra, importe_total_compra)"
                    + " VALUES ('" + cad_fecha_com + "'," + id_sucursal + ", " + id_admin + ", " + id_proveedor + ", " + subtotal + ", " + iva + ", " + imp_total + "); ");
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
            id_compra = this.getId_compra(); // Obtiene el id del registro seleccionado.
            
            cad_fecha_com = this.getCad_fecha_com(); // Obtienen los valores actuales de las variables. (7)
            // Segmento de código para obtener los id´s en base a los nombres existentes en los ComboBox...
            String cons = "SELECT * FROM sucursales WHERE nombre_sucursal = '" + this.getNom_sucursal() + "'; ";
            rs = st.executeQuery(cons);
            if (rs.next()) {
                id_sucursal = rs.getInt("id_sucursal");
            }
            cons = "SELECT * FROM administradores WHERE nombre_admin = '" + this.getNom_admin() + "'; ";
            rs = st.executeQuery(cons);
            if (rs.next()) {
                id_admin = rs.getInt("id_admin");
            }
            cons = "SELECT * FROM proveedores WHERE nombre_proveedor = '" + this.getNom_proveedor() + "'; ";
            rs = st.executeQuery(cons);
            if (rs.next()) {
                id_proveedor = rs.getInt("id_proveedor");
            }

            subtotal = this.getSubtotal();
            iva = this.getIva();
            imp_total = this.getImp_total();
            
            st.executeUpdate("UPDATE compras SET fecha_compra = '"+ cad_fecha_com +"', id_sucursal = "+ id_sucursal +", "
                    + "id_admin = "+ id_admin +", id_proveedor = "+ id_proveedor +", "
                        + "subtotal_compra = "+ subtotal +", iva_compra = "+ iva +", "
                            + "importe_total_compra = "+ imp_total +" WHERE id_compra = "+ id_compra +"; ");
            JOptionPane.showMessageDialog(null, "Se ha modificado el registro.");
            this.conectarDB();
            this.moverUltimoRegistro();
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
    
    
// Código para la sección de 'detalle de Compra' de la interfaz.
    private DefaultTableModel tabla_detalle = new DefaultTableModel();
    private String[] registro_det = new String[5];
    private String temp_idcompra;
    private String temp_nomproducto;
    private String temp_precio;
    private String temp_cantidad;

    public DefaultTableModel getTabla_detalle() {
        return tabla_detalle;
    }

    public void setTabla_detalle(DefaultTableModel tabla_detalle) {
        this.tabla_detalle = tabla_detalle;
    }

    public String[] getRegistro_det() {
        return registro_det;
    }

    public void setRegistro_det(String[] registro_det) {
        this.registro_det = registro_det;
    }

    public String getTemp_idcompra() {
        return temp_idcompra;
    }

    public void setTemp_idcompra(String temp_idcompra) {
        this.temp_idcompra = temp_idcompra;
    }

    public String getTemp_nomproducto() {
        return temp_nomproducto;
    }

    public void setTemp_nomproducto(String temp_nomproducto) {
        this.temp_nomproducto = temp_nomproducto;
    }

    public String getTemp_precio() {
        return temp_precio;
    }

    public void setTemp_precio(String temp_precio) {
        this.temp_precio = temp_precio;
    }

    public String getTemp_cantidad() {
        return temp_cantidad;
    }

    public void setTemp_cantidad(String temp_cantidad) {
        this.temp_cantidad = temp_cantidad;
    }

    /**
     * Método para configurar el modelo (columnas) de la tabla 'detalle de compra'.
     */
    public void llenarTabla() {
        try {
            tabla_detalle.addColumn("ID Compra");
            tabla_detalle.addColumn("Nombre del Producto");
            tabla_detalle.addColumn("Precio compra");
            tabla_detalle.addColumn("Cantidad");
            tabla_detalle.addColumn("Total");
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
        }
    }

    /**
     * Método para agregar los datos de un producto a comprar a la tabla 'detalle de compra'.
     */
    public void agregarProducto() {
        try {
            registro_det[0] = temp_idcompra;
            registro_det[1] = temp_nomproducto;
            registro_det[2] = temp_precio;
            registro_det[3] = temp_cantidad;
            float price = Float.parseFloat(temp_precio);
            float pieces = Float.parseFloat(temp_cantidad);
            float tot_prod = price * pieces; // Variable que almacena el importe total por la compra de un producto.
            registro_det[4] = Float.toString(tot_prod);

            tabla_detalle.addRow(registro_det);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null,"Error al agregar producto. "+err.getMessage());
        }
    }

    /**
     *
     */
    public void terminarCompra() {
        try {

        } catch (Exception err) {
            JOptionPane.showMessageDialog(null,"Error al finalizar Compra. "+err.getMessage());
        }
    }

    
} // Cierre de la clase ModelCompras
