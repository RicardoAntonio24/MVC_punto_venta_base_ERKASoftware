
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
//        // ComboBox con nombres de productos disponibles
//        try { // Nombres de Productos
//            cons_combo = st.executeQuery("SELECT * FROM productos;");
//            ArrayList prod = new ArrayList(); // Lista para los valores a almacenar en el ComboBox
//            while (cons_combo.next()) {
//                String elem_producto = cons_combo.getString("nombre_producto");
//                prod.add(elem_producto);
//            }
//            this.setProductos(prod); // Transfiere los datos al arreglo para ControllerVentas
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex);
//        }
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
    
//    private ResultSet cons_detalle; // Variable para mover el cursor de ResultSet entre los registros de detalle_compra.
//    
//    /**
//     * Lee los valores del registro seleccionado y los asigna a las variables miembro correspondientes.
//     */
//    public void setValuesDetalleCompra() {
//        try {
//            id_compra_2 = id_compra;
//            precio_compra = cons_detalle.getFloat("precio_compra");
//            cantidad = cons_detalle.getInt("cantidad");
//            total_prod = cons_detalle.getFloat("total_producto");
//            id_producto = cons_detalle.getInt("id_producto");
//            // Obtiene los nombres de productos existentes en la BD, para asginarlos al ComboBox...
//            String cons_prod = "SELECT nombre_producto FROM productos WHERE id_producto = " + id_producto + "; ";
//            rs = st.executeQuery(cons_prod);
//            if (rs.next()) {
//                nom_producto = rs.getString(1);
//            }
//            
//            registro_det[0] = Integer.toString(id_compra_2);
//            registro_det[1] = nom_producto;
//            registro_det[2] = Float.toString(precio_compra);
//            registro_det[3] = Integer.toString(cantidad);
//            registro_det[4] = Float.toString(total_prod);
//            tabla_detalle.addRow(registro_det);
//
//        } catch (SQLException err) {
//            JOptionPane.showMessageDialog(null, "Error model 103: " + err.getMessage());
//        }
//    }
    
    int cursor = 1; // Variable para alamacenar la posición actual del cursor de rs.

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
//            // Movimiento de registros de 'detalle_venta'...
//            ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM detalle_compra WHERE id_compra = "+ id_compra +"; ");
//            if (cons_num.next()) {
//                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'detalle_compra'.
//                for (int r = 1; r <= num_registros; r++) {
//                    cons_detalle = st.executeQuery("SELECT * FROM detalle_compra WHERE id_compra = "+ id_compra +"; ");
//                    if (cons_detalle.next()) {
//                        cons_detalle.absolute(r); // Mueve el cursor del ResultSet a el registro número r...
//                        setValuesDetalleCompra();
//                    }
//                }
//            }
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
//            // Movimiento de registros de 'detalle_venta'...
//            ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM detalle_compra WHERE id_compra = "+ id_compra +"; ");
//            if (cons_num.next()) {
//                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'detalle_compra'.
//                for (int r = 1; r <= num_registros; r++) {
//                    cons_detalle = st.executeQuery("SELECT * FROM detalle_compra WHERE id_compra = "+ id_compra +"; ");
//                    if (cons_detalle.next()) {
//                        cons_detalle.absolute(r); // Mueve el cursor del ResultSet a el registro número r...
//                        setValuesDetalleCompra();
//                    }
//                }
//            }
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
//            // Movimiento de registros de 'detalle_venta'...
//            cons_num = st.executeQuery("SELECT COUNT(*) FROM detalle_compra WHERE id_compra = "+ id_compra +"; ");
//            if (cons_num.next()) {
//                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'detalle_compra'.
//                for (int r = 1; r <= num_registros; r++) {
//                    cons_detalle = st.executeQuery("SELECT * FROM detalle_compra WHERE id_compra = "+ id_compra +"; ");
//                    if (cons_detalle.next()) {
//                        cons_detalle.absolute(r); // Mueve el cursor del ResultSet a el registro número r...
//                        setValuesDetalleCompra();
//                    }
//                }
//            }
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
                    ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM ventas;");
                    if (cons_num.next()) {
                        int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'ventas'.
                        cursor = num_registros;
                    }
                }
            }
//            // Movimiento de registros de 'detalle_venta'...
//            ResultSet cons_num = st.executeQuery("SELECT COUNT(*) FROM detalle_compra WHERE id_compra = "+ id_compra +"; ");
//            if (cons_num.next()) {
//                int num_registros = cons_num.getInt(1); // Obtiene el número de registros existentes en la tabla 'detalle_compra'.
//                for (int r = 1; r <= num_registros; r++) {
//                    cons_detalle = st.executeQuery("SELECT * FROM detalle_compra WHERE id_compra = "+ id_compra +"; ");
//                    if (cons_detalle.next()) {
//                        cons_detalle.absolute(r); // Mueve el cursor del ResultSet a el registro número r...
//                        setValuesDetalleCompra();
//                    }
//                }
//            }
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
            this.moverUltimoRegistro();
            
        }
        catch(SQLException err) { 
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
        }
    }
    
    
    
    
    
} // Cierre de la clase ModelVentas
