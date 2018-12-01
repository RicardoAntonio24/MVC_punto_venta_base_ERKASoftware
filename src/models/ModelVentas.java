
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
public class ModelVentas {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    // Variables para la gestión de Ventas:
    private int id_venta;
    private Date fecha_venta;
    private int id_sucursal;
    private int id_empleado;
    private int id_cliente;
    private float subtotal_venta;
    private float iva_venta;
    private float total_venta;
    private int id_descuento;
    private float importe_final;
    private String forma_pago;
    private String ent_bancaria;
    private String no_cuenta;

    public int getId_venta() {
        return id_venta;
    }
    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }
    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }
    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }

    public int getId_empleado() {
        return id_empleado;
    }
    public void setId_empleado(int id_empleado) {
        this.id_empleado = id_empleado;
    }

    public int getId_cliente() {
        return id_cliente;
    }
    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public float getSubtotal_venta() {
        return subtotal_venta;
    }
    public void setSubtotal_venta(float subtotal_venta) {
        this.subtotal_venta = subtotal_venta;
    }

    public float getIva_venta() {
        return iva_venta;
    }
    public void setIva_venta(float iva_venta) {
        this.iva_venta = iva_venta;
    }

    public float getTotal_venta() {
        return total_venta;
    }
    public void setTotal_venta(float total_venta) {
        this.total_venta = total_venta;
    }

    public int getId_descuento() {
        return id_descuento;
    }
    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public float getImporte_final() {
        return importe_final;
    }
    public void setImporte_final(float importe_final) {
        this.importe_final = importe_final;
    }

    public String getForma_pago() {
        return forma_pago;
    }
    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getEnt_bancaria() {
        return ent_bancaria;
    }
    public void setEnt_bancaria(String ent_bancaria) {
        this.ent_bancaria = ent_bancaria;
    }

    public String getNo_cuenta() {
        return no_cuenta;
    }
    public void setNo_cuenta(String no_cuenta) {
        this.no_cuenta = no_cuenta;
    }
    
    
    private ArrayList sucursales;
    private ArrayList empleados;
    private ArrayList clientes;

    public ArrayList getSucursales() {
        return sucursales;
    }
    public void setSucursales(ArrayList sucursales) {
        this.sucursales = sucursales;
    }

    public ArrayList getEmpleados() {
        return empleados;
    }
    public void setEmpleados(ArrayList empleados) {
        this.empleados = empleados;
    }

    public ArrayList getClientes() {
        return clientes;
    }
    public void setClientes(ArrayList clientes) {
        this.clientes = clientes;
    }
    
    private String nom_sucursal;
    private String nom_empleado;
    private String nom_cliente;

    public String getNom_sucursal() {
        return nom_sucursal;
    }
    public void setNom_sucursal(String nom_sucursal) {
        this.nom_sucursal = nom_sucursal;
    }

    public String getNom_empleado() {
        return nom_empleado;
    }
    public void setNom_empleado(String nom_empleado) {
        this.nom_empleado = nom_empleado;
    }

    public String getNom_cliente() {
        return nom_cliente;
    }
    public void setNom_cliente(String nom_cliente) {
        this.nom_cliente = nom_cliente;
    }
    
// Variables para la gestión de detalles de Compras:
    private int id_det_venta;
    private int id_venta_2;
    private int id_producto;
    private int cantidad;
    private float precio_venta;
    private float total_producto;
    private int id_promocion;
    private float total_final;
    
    public int getCursor() {
        return cursor;
    }
    public void setCursor(int cursor) {
        this.cursor = cursor;
    }

    public int getId_det_venta() {
        return id_det_venta;
    }
    public void setId_det_venta(int id_det_venta) {
        this.id_det_venta = id_det_venta;
    }

    public int getId_venta_2() {
        return id_venta_2;
    }
    public void setId_venta_2(int id_venta_2) {
        this.id_venta_2 = id_venta_2;
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

    public float getPrecio_venta() {
        return precio_venta;
    }
    public void setPrecio_venta(float precio_venta) {
        this.precio_venta = precio_venta;
    }

    public float getTotal_producto() {
        return total_producto;
    }
    public void setTotal_producto(float total_producto) {
        this.total_producto = total_producto;
    }

    public int getId_promocion() {
        return id_promocion;
    }
    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    public float getTotal_final() {
        return total_final;
    }
    public void setTotal_final(float total_final) {
        this.total_final = total_final;
    }
    
    private ArrayList productos;
    private String nom_producto;

    public ArrayList getProductos() {
        return productos;
    }
    public void setProductos(ArrayList productos) {
        this.productos = productos;
    }
    
    public String getNom_producto() {
        return nom_producto;
    }
    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }
    
    
    
    /**
     * Método que realiza las siguietnes acciones: 
     * 1- Conecta con la base de datos ferreteria_acme 
     * 2- Consulta todo los registros de la tabla ventas
     * 3- Obtiene todos los datos almacenados y los guarda en las variables globales correspondientes.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
            String sql = "SELECT * FROM ventas;";
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
        // ComboBox con nombres de sucursales, empleados y clientes
        ResultSet cons_combo;
        try { // Nombres de Sucursales
            cons_combo = st.executeQuery("SELECT * FROM sucursales;");
            ArrayList suc = new ArrayList(); // Lista para los valores a almacenar en el ComboBox
            while (cons_combo.next()) {
//                String id = Integer.toString(cons_combo.getInt("id_sucursal"));
                String nom = cons_combo.getString("nombre_sucursal");
                String elemento_suc = nom;
                suc.add(elemento_suc);
            }
            this.setSucursales(suc); // Transfiere los datos al arreglo para ControllerVentas

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try { // Nombres de Empleados Ventas
            cons_combo = st.executeQuery("SELECT * FROM empleados_ventas;");
            ArrayList empv = new ArrayList(); // Lista para los valores a almacenar en el ComboBox
            while (cons_combo.next()) {
//                String id = Integer.toString(cons_combo.getInt("id_empleado"));
                String nom = cons_combo.getString("nombre_empleado");
                String ap1 = cons_combo.getString("apellido_pat_empleado");
                String ap2 = cons_combo.getString("apellido_mat_empleado");
                String elemento_empv = nom + " " + ap1 + " " + ap2;
                empv.add(elemento_empv);
            }
            this.setEmpleados(empv); // Transfiere los datos al arreglo para ControllerVentas

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        try { // Nombres de Clientes
            cons_combo = st.executeQuery("SELECT * FROM clientes;");
            ArrayList cli = new ArrayList(); // Lista para los valores a almacenar en el ComboBox
            while (cons_combo.next()) {
//                String id = Integer.toString(cons_combo.getInt("id_cliente"));
                String nom = cons_combo.getString("nombre_cliente");
                String ap1 = cons_combo.getString("apellido_pat_cliente");
                String ap2 = cons_combo.getString("apellido_mat_cliente");
                String elemento_cli = nom + " " + ap1 + " " + ap2;
                cli.add(elemento_cli);
            }
            this.setClientes(cli); // Transfiere los datos al arreglo para ControllerVentas

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        // ComboBox con nombres de productos disponibles
        try { // Nombres de Productos
            cons_combo = st.executeQuery("SELECT * FROM productos;");
            ArrayList prod = new ArrayList(); // Lista para los valores a almacenar en el ComboBox
            while (cons_combo.next()) {
                String elem_producto = cons_combo.getString("nombre_producto");
                prod.add(elem_producto);
            }
            this.setProductos(prod); // Transfiere los datos al arreglo para ControllerVentas

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    /**
     * Lee los valores del registro seleccionado y los asigna a las variables miembro correspondientes.
     */
    public void setValues() {
        try {
            id_venta = rs.getInt("id_venta");
            fecha_venta = rs.getDate("fecha_venta");
            subtotal_venta = rs.getFloat("subtotal_venta");
            iva_venta = rs.getFloat("iva_venta");
            total_venta = rs.getFloat("total_venta");
            id_descuento = rs.getInt("id_descuento");
            importe_final = rs.getFloat("importe_final");;
            forma_pago = rs.getString("forma_pago");
            ent_bancaria = rs.getString("entidad_bancaria");
            no_cuenta = rs.getString("no_cuenta");
            
            id_sucursal = rs.getInt("id_sucursal");
            id_empleado = rs.getInt("id_empleado");
            id_cliente = rs.getInt("id_cliente");
            // Obtiene los nombres requeridos (sucursal, empleados y clientes) para asginarlos a los ComboBox...
            ResultSet cons_suc = st.executeQuery("SELECT nombre_sucursal FROM sucursales WHERE id_sucursal = " + id_sucursal + "; ");
            if (cons_suc.next()) {
                nom_sucursal = cons_suc.getString(1);
            }
            ResultSet cons_empv = st.executeQuery("SELECT nombre_empleado, apellido_pat_empleado, apellido_mat_empleado FROM empleados_ventas WHERE id_empleado = " + id_empleado + "; ");
            if (cons_empv.next()) {
                String nombre = cons_empv.getString(1);
                String ape1 = cons_empv.getString(2);
                String ape2 = cons_empv.getString(3);
                nom_empleado = nombre + " " + ape1 + " " + ape2;
            }
            ResultSet cons_cli = st.executeQuery("SELECT nombre_cliente, apellido_pat_cliente, apellido_mat_cliente FROM clientes WHERE id_cliente = " + id_cliente + "; ");
            if (cons_cli.next()) {
                String nombre = cons_cli.getString(1);
                String ape1 = cons_cli.getString(2);
                String ape2 = cons_cli.getString(3);
                nom_cliente = nombre + " " + ape1 + " " + ape2;
            }

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());
        }
    }
    
    private ResultSet cons_detalle; // Variable para mover el cursor de ResultSet entre los registros de detalle_venta.
    
    /**
     * Lee los valores del registro seleccionado y los asigna a las variables miembro correspondientes.
     */
    public void setValuesDetalleVenta() {
        try {
            id_venta_2 = id_venta;
            precio_venta = cons_detalle.getFloat("precio_venta");
            cantidad = cons_detalle.getInt("cantidad");
            total_producto = cons_detalle.getFloat("total_producto");
            id_producto = cons_detalle.getInt("id_producto");            
            id_promocion = cons_detalle.getInt("id_promocion");
            total_final = cons_detalle.getFloat("total_con_descuento");
            // Obtiene los nombres de productos existentes en la BD, para asginarlos al ComboBox...
            ResultSet cons_prod = st.executeQuery("SELECT nombre_producto FROM productos WHERE id_producto = " + id_producto + "; ");
            if (cons_prod.next()) {
                nom_producto = cons_prod.getString(1);
            }
            
            registro_det[0] = Integer.toString(id_venta_2);
            registro_det[1] = nom_producto;
            registro_det[2] = Float.toString(precio_venta);
            registro_det[3] = Integer.toString(cantidad);
            registro_det[4] = Float.toString(total_producto);
            registro_det[5] = Integer.toString(id_promocion);
            registro_det[6] = Float.toString(total_final);
            tabla_detalle.addRow(registro_det);

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 103: " + err.getMessage());
        }
    }
    
    
    private int cursor = 1; // Variable para alamacenar la posición actual del cursor de rs.

    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al primer registro
     * 2.- obtener los valores de los campos de rs y guardarlos en las variables definidas...
     */
    public void moverPrimerRegistro() {
        try {
            String sql = "SELECT * FROM ventas;";
            rs = st.executeQuery(sql);
            if (rs.next()) { // Comprueba si la consulta devolvió registros.
                rs.first(); //Primer registro
                setValues();
                cursor = 1;
            }
            // Movimiento de registros de 'detalle_venta'...
            ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM detalle_venta WHERE id_venta = "+ id_venta +"; ");
            if (cons_num.next()) {
                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'detalle_venta'.
                for (int r = 1; r <= num_registros; r++) {
                    cons_detalle = st.executeQuery("SELECT * FROM detalle_venta WHERE id_venta = "+ id_venta +"; ");
                    if (cons_detalle.next()) {
                        cons_detalle.absolute(r); // Mueve el cursor del ResultSet a el registro número r...
                        setValuesDetalleVenta();
                    }
                }
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al anterior registro 
     * 2.- obtener los valores de los campos de rs y guardarlos en las variables definidas...
     */
    public void moverAnteriorRegistro() {
        try {
            String sql = "SELECT * FROM ventas;";
            rs = st.executeQuery(sql);
            if (rs.next()) { // Comprueba si la consulta devolvió registros.
                if (cursor > 1) {
                    cursor--;
                    rs.absolute(cursor); // Mueve el cursor de ResultSet a un número específico de registro.
                    setValues();
                }
            }
            // Movimiento de registros de 'detalle_venta'...
            ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM detalle_venta WHERE id_venta = "+ id_venta +"; ");
            if (cons_num.next()) {
                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'detalle_venta'.
                for (int r = 1; r <= num_registros; r++) {
                    cons_detalle = st.executeQuery("SELECT * FROM detalle_venta WHERE id_venta = "+ id_venta +"; ");
                    if (cons_detalle.next()) {
                        cons_detalle.absolute(r); // Mueve el cursor del ResultSet a el registro número r...
                        setValuesDetalleVenta();
                    }
                }
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones: 
     * 1.- Moverse al siguienteregistro 
     * 2.- obtener los valores de los campos de rs y guardarlos en las variables definidas...
     */
    public void moverSiguienteRegistro() {
        try {
            ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM ventas;");
            if (cons_num.next()) {
                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'ventas'.
                String sql = "SELECT * FROM ventas;";
                rs = st.executeQuery(sql);
                if (rs.next()) { // Comprueba si la consulta devolvió registros.
                    if (cursor < num_registros) {
                        cursor++;
                        rs.absolute(cursor); // Mueve el cursor de ResultSet a un número específico de registro.
                        setValues();
                    }
                }
            }
            // Movimiento de registros de 'detalle_venta'...
            cons_num = st.executeQuery("SELECT COUNT(*) FROM detalle_venta WHERE id_venta = "+ id_venta +"; ");
            if (cons_num.next()) {
                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'detalle_venta'.
                for (int r = 1; r <= num_registros; r++) {
                    cons_detalle = st.executeQuery("SELECT * FROM detalle_venta WHERE id_venta = "+ id_venta +"; ");
                    if (cons_detalle.next()) {
                        cons_detalle.absolute(r); // Mueve el cursor del ResultSet a el registro número r...
                        setValuesDetalleVenta();
                    }
                }
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }

    /**
     * Método que realiza las siguiente acciones:
     * 1.- Moverse al ultimo registro
     * 2.- obtener los valores de los campos de rs y guardarlos en las variables definidas...
     */
    public void moverUltimoRegistro() {
        try {
            String sql = "SELECT * FROM ventas;";
            rs = st.executeQuery(sql);
            if (rs.next()) { // Comprueba si la consulta devolvió registros.
                if (rs.isLast() == false) {
                    rs.last(); //Último registro
                    setValues();
                    ResultSet cons_no = st.executeQuery("SELECT COUNT(*) FROM ventas;");
                    if (cons_no.next()) {
                        int num_registros = cons_no.getInt(1); // Obtiene el número de registros existentes en la tabla 'ventas'.
                        cursor = num_registros;
                    }
                }
            }
            // Movimiento de registros de 'detalle_venta'...
            ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM detalle_venta WHERE id_venta = "+ id_venta +"; ");
            if (cons_num.next()) {
                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'detalle_venta'.
                for (int r = 1; r <= num_registros; r++) {
                    cons_detalle = st.executeQuery("SELECT * FROM detalle_venta WHERE id_venta = "+ id_venta +"; ");
                    if (cons_detalle.next()) {
                        cons_detalle.absolute(r); // Mueve el cursor del ResultSet a el registro número r...
                        setValuesDetalleVenta();
                    }
                }
            }
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null, "Error " + err.getMessage());
        }
    }
    
    /**
     * Método que realiza las siguiente acciones: 
     * - Crea un nuevo registro y lo almacena en la base de datos.
     */
    public void insertarRegistro() {
        try {
            // Segmento de código para obtener los id´s en base a los nombres existentes en los ComboBox...
            ResultSet cons = st.executeQuery("SELECT * FROM sucursales WHERE nombre_sucursal = '" + this.getNom_sucursal() + "'; ");
            if (cons.next()) {
                id_sucursal = cons.getInt("id_sucursal");
            }
            String concat_nomempv = nom_empleado.replace(" ", "");
            cons = st.executeQuery("SELECT * FROM empleados_ventas WHERE CONCAT(nombre_empleado, apellido_pat_empleado, apellido_mat_empleado) = '"+ concat_nomempv +"'; ");
            if (cons.next()) {
                id_empleado = cons.getInt("id_empleado");
            }
            String concat_nomcli = nom_cliente.replace(" ", "");
            cons = st.executeQuery("SELECT * FROM clientes WHERE CONCAT(nombre_cliente, apellido_pat_cliente, apellido_mat_cliente) = '"+ concat_nomcli +"'; ");
            if (cons.next()) {
                id_cliente = cons.getInt("id_cliente");
            }
            
            id_venta = this.getId_venta(); // Obtienen los valores actuales de las variables. (9)
            subtotal_venta = this.getSubtotal_venta();
            iva_venta = this.getIva_venta();
            total_venta = this.getTotal_venta();
            id_descuento = this.getId_descuento();
            importe_final = this.getImporte_final();
            forma_pago = this.getForma_pago();
            ent_bancaria = this.getEnt_bancaria();
            no_cuenta = this.getNo_cuenta();
            
            st.executeUpdate("INSERT INTO ventas (id_sucursal, id_empleado, id_cliente, subtotal_venta, iva_venta, total_venta, id_descuento, importe_final, forma_pago, entidad_bancaria, no_cuenta)"
                    + " VALUES (" + id_sucursal + "," + id_empleado + ", " + id_cliente + ", " + subtotal_venta + ", " + iva_venta + ", " + total_venta + ", " + id_descuento + ", " + importe_final + ", '" + forma_pago + "', '" + ent_bancaria + "', '" + no_cuenta + "'); ");
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
            id_venta = this.getId_venta(); // Obtiene el id del registro seleccionado.
            // Segmento de código para obtener los id´s en base a los nombres existentes en los ComboBox...
            ResultSet cons = st.executeQuery("SELECT * FROM sucursales WHERE nombre_sucursal = '" + this.getNom_sucursal() + "'; ");
            if (cons.next()) {
                id_sucursal = cons.getInt("id_sucursal");
            }
            String concat_nomempv = nom_empleado.replace(" ", "");
            cons = st.executeQuery("SELECT * FROM empleados_ventas WHERE CONCAT(nombre_empleado, apellido_pat_empleado, apellido_mat_empleado) = '"+ concat_nomempv +"'; ");
            if (cons.next()) {
                id_empleado = cons.getInt("id_empleado");
            }
            String concat_nomcli = nom_cliente.replace(" ", "");
            cons = st.executeQuery("SELECT * FROM clientes WHERE CONCAT(nombre_cliente, apellido_pat_cliente, apellido_mat_cliente) = '"+ concat_nomcli +"'; ");
            if (cons.next()) {
                id_cliente = cons.getInt("id_cliente");
            }
            
            id_venta = this.getId_venta(); // Obtienen los valores actuales de las variables. (9)
            subtotal_venta = this.getSubtotal_venta();
            iva_venta = this.getIva_venta();
            total_venta = this.getTotal_venta();
            id_descuento = this.getId_descuento();
            importe_final = this.getImporte_final();
            forma_pago = this.getForma_pago();
            ent_bancaria = this.getEnt_bancaria();
            no_cuenta = this.getNo_cuenta();
            
            st.executeUpdate("UPDATE ventas SET id_sucursal = "+ id_sucursal +", id_empleado = "+ id_empleado +", id_cliente = "+ id_cliente +", "
                + "subtotal_venta = "+ subtotal_venta +", iva_venta = "+ iva_venta +", total_venta = "+ total_venta +", id_descuento = "+ id_descuento +", "
                    + "importe_final = "+ importe_final +", forma_pago = '"+ forma_pago +"', entidad_bancaria = '"+ ent_bancaria +"', "
                       + "no_cuenta = '"+ no_cuenta +"' WHERE id_venta = "+ id_venta +"; ");
            JOptionPane.showMessageDialog(null, "Se ha modificado el registro.");
            this.conectarDB();
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
    
// Código para la sección de 'detalle de Compra' de la interfaz.
    private DefaultTableModel tabla_detalle = new DefaultTableModel();
    private String[] registro_det = new String[7];
    private String temp_idventa;
    private String temp_nomproducto;
    private String temp_precio;
    private String temp_cantidad;
    private String temp_idpromocion;

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

    public String getTemp_idventa() {
        return temp_idventa;
    }

    public void setTemp_idventa(String temp_idventa) {
        this.temp_idventa = temp_idventa;
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

    public String getTemp_idpromocion() {
        return temp_idpromocion;
    }

    public void setTemp_idpromocion(String temp_idpromocion) {
        this.temp_idpromocion = temp_idpromocion;
    }
    
    
    /**
     * Método para configurar el modelo (columnas) de la tabla 'detalle de compra'.
     */
    public void llenarTabla() {
        try {
            tabla_detalle.addColumn("No. Venta");
            tabla_detalle.addColumn("Nombre del Producto");
            tabla_detalle.addColumn("Precio venta");
            tabla_detalle.addColumn("Cantidad");
            tabla_detalle.addColumn("Total (parcial)");
            tabla_detalle.addColumn("ID Promo");
            tabla_detalle.addColumn("Total Final");
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
        }
    }

    /**
     * Método para agregar los datos de un producto a comprar a la tabla 'detalle de compra'.
     */
    public void agregarProducto() {
        try {
            registro_det[0] = temp_idventa;
            registro_det[1] = temp_nomproducto;
            
            registro_det[3] = temp_cantidad;
            // Obtiene automáticamente el precio del producto de la tabla Productos
            float costop = 0.0f;
            ResultSet precio_cantidad = st.executeQuery(" SELECT precio_unitario, precio_mayoreo, inicio_mayoreo FROM productos WHERE nombre_producto = '"+ temp_nomproducto +"'; ");
            if (precio_cantidad.next()) {
                float precio_unitario = precio_cantidad.getFloat("precio_unitario");
                float precio_mayoreo = precio_cantidad.getFloat("precio_mayoreo");
                int inicio_mayoreo = precio_cantidad.getInt("inicio_mayoreo");
                if (Integer.parseInt(temp_cantidad) >= inicio_mayoreo) {
                    costop = precio_mayoreo;
                }
                else {
                    costop = precio_unitario;
                }
            }
            temp_precio = Float.toString(costop);
            registro_det[2] = temp_precio;
            
            float price = Float.parseFloat(temp_precio);
            float pieces = Float.parseFloat(temp_cantidad);
            float tot_prod = price * pieces; // Variable que almacena el importe total por la compra de un producto.
            registro_det[4] = Float.toString(tot_prod);
// ...
            // Código para obtener el id de la BD del producto seleccionado...
            ResultSet cons = st.executeQuery("SELECT * FROM productos WHERE nombre_producto = '" + temp_nomproducto + "'; ");
            if (cons.next()) {
                id_producto = cons.getInt("id_producto");
            }
            ResultSet cons_promo = st.executeQuery("SELECT * FROM promociones WHERE id_producto = "+ id_producto +" AND id_sucursal = "+ id_sucursal +"; ");
            if (cons_promo.next()) {
                registro_det[5] = Integer.toString(cons_promo.getInt("id_promocion"));
                int descuento_prod = cons_promo.getInt("descuento_promocion");
                float total_final = tot_prod - (tot_prod * descuento_prod / 100);
                registro_det[6] = Float.toString(total_final);
            }
            else {
                registro_det[5] = Integer.toString(0);
                registro_det[6] = Float.toString(tot_prod);
            }

            tabla_detalle.addRow(registro_det);
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null,"Error al agregar producto. "+err.getMessage());
        }
    }
    
    
    private ArrayList nums_stock = new ArrayList();
    public ArrayList getNums_stock() {
        return nums_stock;
    }
    public void setNums_stock(ArrayList nums_stock) {
        this.nums_stock = nums_stock;
    }
    
    /**
     * Método para obtener las existencias del producto seleccionado, según la sucursal que realiza la Venta
     */
    public void llenarCajaExistencias() {
        try {
            nums_stock.clear(); // Limpia la lista de opciones de stock antes de configurarla nuevamente
            // Código para obtener el id del producto seleccionado...
            ResultSet cons = st.executeQuery("SELECT * FROM productos WHERE nombre_producto = '" + temp_nomproducto + "'; ");
            if (cons.next()) {
                id_producto = cons.getInt("id_producto");
            }
            
            ResultSet constock1 = st.executeQuery("SELECT * FROM productos_por_sucursal WHERE id_producto = "+ id_producto +" AND id_sucursal = "+ id_sucursal +"; ");
            if (constock1.next()) {
                int stock_prod = constock1.getInt("existencia");
                for (int n = 1; n <= stock_prod; n++) {
                    nums_stock.add(n);
                }
            }
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null,"Error al llenar Combo Stock. "+err.getMessage());
        }
    }
    
    
    private float total_actual; // Variable para el valor del jtf_totalactual.
    public float getTotal_actual() {
        return total_actual;
    }
    public void setTotal_actual(float total_actual) {
        this.total_actual = total_actual;
    }
    
    
    /**
     * Método para finalizar el proceso completo de VENTA (ventas y detalle_venta) !.
     */
    public void terminarVenta() {
        try {
            int rows = tabla_detalle.getRowCount();
            float acum_total = 0.0f; // Variable para acumular el monto total de compra.
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < 7;) {
                    id_venta_2 = Integer.parseInt((String) tabla_detalle.getValueAt(r, c));
                    c ++; // 1
                    String nom_prod = (String) tabla_detalle.getValueAt(r, c);
                    ResultSet consulta = st.executeQuery("SELECT id_producto FROM productos WHERE nombre_producto = '"+ nom_prod +"'; ");
                    if (consulta.next()) {
                        id_producto = consulta.getInt(1); // Obtiene el id del producto para la tabla 'detalle_compra'.
                    }
                    c ++; // 2
                    precio_venta = Float.parseFloat((String) tabla_detalle.getValueAt(r, c));
                    c ++; // 3
                    cantidad = Integer.parseInt((String) tabla_detalle.getValueAt(r, c));
                    c ++;// 4
                    total_producto = Float.parseFloat((String) tabla_detalle.getValueAt(r, c));
                    c ++; // 5
                    
                    id_promocion = Integer.parseInt((String) tabla_detalle.getValueAt(r, c));
                    c ++; // 6
                    total_final = Float.parseFloat((String) tabla_detalle.getValueAt(r, c));
                    c ++; // 7
                    
                    acum_total = acum_total + total_final;
                }
                st.executeUpdate("INSERT INTO detalle_venta (id_venta, id_producto, cantidad, precio_venta, total_producto, id_promocion, total_con_descuento)"
                    + " VALUES (" + id_venta_2 + ", " + id_producto + ", " + cantidad + ", " + precio_venta + ", " + total_producto + ", "+ id_promocion +", "+ total_final +"); ");
                
                // Segmento para actualizar las existencias (stock) de los productos vendidos.
                ResultSet constock2 = st.executeQuery("SELECT existencia FROM productos_por_sucursal WHERE id_producto = "+ id_producto +" AND id_sucursal = "+ id_sucursal +"; ");
                if (constock2.next()) {
                    int nuevo_stock = constock2.getInt(1) - cantidad;
                    st.executeUpdate("UPDATE productos_por_sucursal SET existencia = "+ nuevo_stock +" WHERE id_producto = "+ id_producto +" AND id_sucursal = "+ id_sucursal +"; ");
                }
            }
            float calc_iva = acum_total * 16 / 100;
            float calc_subtotal = acum_total - calc_iva;
            st.executeUpdate("UPDATE ventas SET subtotal_venta = "+ calc_subtotal +", iva_venta = "+ calc_iva +", total_venta = "+ acum_total +" WHERE id_venta = "+ id_venta_2 +"; ");
            
            // Código para verificar si el monto total de compra tenrá o no un descuento adicional...
            ResultSet cfecha_venta = st.executeQuery("SELECT fecha_venta FROM ventas WHERE id_venta = "+ id_venta_2 +"; ");
            if (cfecha_venta.next()) {
                Date fechav = cfecha_venta.getDate(1);
                
                ResultSet cons_desc = st.executeQuery("SELECT * FROM descuentos WHERE monto_minimo <= "+ acum_total +" AND monto_limite > "+ acum_total +" AND fecha_inicio <= '"+ fechav +"' AND fecha_limite >= '"+ fechav +"'; ");
                
                float impf = acum_total; // Variable para calcular el importe total menos el posible descuento.
                if (cons_desc.next()) {
                    int id_desc = cons_desc.getInt("id_descuento");
                    int porcentaje = cons_desc.getInt("porcentaje_descuento");
                    impf = impf - (impf * porcentaje / 100);
                    st.executeUpdate("UPDATE ventas SET id_descuento = "+ id_desc +", importe_final = "+ impf +" WHERE id_venta = "+ id_venta_2 +"; ");
                }
                else {
                    st.executeUpdate("UPDATE ventas SET id_descuento = 0, importe_final = "+ impf +" WHERE id_venta = "+ id_venta_2 +"; ");
                }
            }
            
            JOptionPane.showMessageDialog(null, "Venta realizada con éxito.");
            this.conectarDB();
//            this.moverUltimoRegistro();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null,"Error al finalizar Venta. "+err.getMessage());
        }
    }

    
    
} // Cierre de la clase ModelVentas
