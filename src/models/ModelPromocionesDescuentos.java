
package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ERKA Software
 */
public class ModelPromocionesDescuentos {
    
    private Connection conexion;
    private Statement st;
    private ResultSet rs;
    
   
    
    //variables para Promociones
    private int id_promocion;
    private int id_producto;
    private String tipo_promocion;
    private int descuento_promocion;
    
    private Date fecha_inicio_promo;
    private Date fecha_limite_promo;
    
    private int id_sucursal;
    
 

   
    

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

    public String[] getRegistro_promo() {
        return registro_promo;
    }

    public void setRegistro_promo(String[] registro_promo) {
        this.registro_promo = registro_promo;
    }

    public int getId_promocion() {
        return id_promocion;
    }

    public void setId_promocion(int id_promocion) {
        this.id_promocion = id_promocion;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getTipo_promocion() {
        return tipo_promocion;
    }

    public void setTipo_promocion(String tipo_promocion) {
        this.tipo_promocion = tipo_promocion;
    }

    public int getDescuento_promocion() {
        return descuento_promocion;
    }

    public void setDescuento_promocion(int descuento_promocion) {
        this.descuento_promocion = descuento_promocion;
    }

    public Date getFecha_inicio_promo() {
        return fecha_inicio_promo;
    }

    public void setFecha_inicio_promo(Date fecha_inicio_promo) {
        this.fecha_inicio_promo = fecha_inicio_promo;
    }

    public Date getFecha_limite_promo() {
        return fecha_limite_promo;
    }

    public void setFecha_limite_promo(Date fecha_limite_promo) {
        this.fecha_limite_promo = fecha_limite_promo;
    }

    public int getId_sucursal() {
        return id_sucursal;
    }

    public void setId_sucursal(int id_sucursal) {
        this.id_sucursal = id_sucursal;
    }
    //Productos y sucursales
    private ArrayList productos;
    private ArrayList sucursales;

    public ArrayList getSucursales() {
        return sucursales;
    }

    public void setSucursales(ArrayList sucursales) {
        this.sucursales = sucursales;
    }

    public ResultSet getPromo() {
        return promo;
    }

    public void setPromo(ResultSet promo) {
        this.promo = promo;
    }
    public ArrayList getProductos() {
        return productos;
    }

    public void setProductos(ArrayList productos) {
        this.productos = productos;
    }
    
    //nombre_producto y nombre_sucursal
    
     private String nom_producto;
     private String nom_sucursal;

    public String getNom_sucursal() {
        return nom_sucursal;
    }

    public void setNom_sucursal(String nom_sucursal) {
        this.nom_sucursal = nom_sucursal;
    }
    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
        
    }
    
    //FECHAS INICIO Y LIMITE
    private String fecha_inicio; 
    private String fecha_limite;

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }
    

     private String dia;
    private String mes;
    private String anio;
    
    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }
    
    private String dia2;
    private String mes2;
    private String anio2;
    
    public String getDia2() {
        return dia2;
    }

    public void setDia2(String dia2) {
        this.dia2 = dia2;
    }

    public String getMes2() {
        return mes2;
    }

    public void setMes2(String mes2) {
        this.mes2 = mes2;
    }

    public String getAnio2() {
        return anio2;
    }

    public void setAnio2(String anio2) {
        this.anio2 = anio2;
    }
    
    
    
    
    
    
    
    
    
    
     public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
            String sql = "SELECT * FROM promociones";
            
            rs = st.executeQuery(sql);
            
            rs.first();
            setValues();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelPromocionesDescuentos 001: " + err.getMessage());
        }
    }
     
     
     public void mostrar() throws SQLException{
        st = conexion.createStatement();  
        
        String sql = "select id_promocion, id_producto, tipo_promocion, descuento_promocion, fecha_inicio_promo, fecha_limite_promo, id_sucursal from promociones";
        rs = st.executeQuery(sql);
        
       
             try{
                 while(rs.next()){
                     
                     
                     table_promo.addRow(new Object[]{
                         rs.getString("id_promocion"),
                         rs.getString("id_producto"),
                         rs.getString("tipo_promocion"),
                         rs.getString("descuento_promocion"),
                         rs.getString("fecha_inicio_promo"),
                         rs.getString("fecha_limite_promo"),
                        
                         
                         
                          rs.getString("id_sucursal")});
                    
                     }
                             
                 } catch(Exception e){
                     
                     System.out.println(e);
                 
             } 
     }
      public void llenarComboBox() {
     
          try { 
            rs = st.executeQuery("SELECT * FROM productos;");
            ArrayList prod = new ArrayList(); 
            while (rs.next()) {
                String elem_producto = rs.getString("nombre_producto");
                prod.add(elem_producto);
            }
            this.setProductos(prod); 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
          try { 
            rs = st.executeQuery("SELECT * FROM sucursales;");
            ArrayList suc = new ArrayList(); 
            while (rs.next()) {
                String elemento_suc = rs.getString("nombre_sucursal");
                suc.add(elemento_suc);
            }
            this.setSucursales(suc); 

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
         
     }
     
     
     
     
     
     public void setValues() {
        try {
            id_promocion = rs.getInt("id_promocion");
            id_producto = rs.getInt("id_producto");
            
            tipo_promocion = rs.getString("tipo_promocion");
            
            fecha_inicio_promo = rs.getDate("fecha_inicio_promo");
            fecha_limite_promo = rs.getDate("fecha_limite_promo");
            
            descuento_promocion = rs.getInt("descuento_promocion");
            
            id_sucursal = rs.getInt("id_sucursal");
         
            String cons_pro = "SELECT nombre_producto FROM productos WHERE id_producto = " + id_producto + "; ";
            rs = st.executeQuery(cons_pro);
            if (rs.next()) {
                nom_producto = rs.getString(1);
            }
             String cons_sucu = "SELECT nombre_sucursal FROM sucursales WHERE id_sucursal= " + id_sucursal + "; ";
            rs = st.executeQuery(cons_sucu);
            if (rs.next()) {
               nom_sucursal = rs.getString(1);
            }
            
            //descuentos
          /**id_descuento = rs.getInt("id_descuento");
            monto_minimo = rs.getFloat("monto_minimo");
            monto_limite = rs.getFloat("monto_limite");
            
            porcentaje_descuento = rs.getInt("porcentaje_descuento");
            fecha_inicio2 = rs.getDate("fecha_inicio2");
            fecha_limite2 = rs.getDate("fecha_limite2");**/

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 102: " + err.getMessage());
        }
    }
    
   
    
    private ResultSet promo;
    public void setValuesPromocion() {
        try {
            id_promocion = promo.getInt("id_promocion");
            tipo_promocion = promo.getString("tipo_promocion");
            descuento_promocion = promo.getInt("descuento_promocion");
          
            id_producto = promo.getInt("id_producto");
           
            String cons_prod = "SELECT nombre_producto FROM productos WHERE id_producto = " + id_producto + "; ";
            rs = st.executeQuery(cons_prod);
            if (rs.next()) {
                nom_producto = rs.getString(1);
            }
            
            registro_promo[0] = Integer.toString(id_promocion);
            registro_promo[1] = nom_producto;
            registro_promo[2] = tipo_promocion;
            registro_promo[3] = Integer.toString(descuento_promocion);
            
//            // fechas
//            fecha_inicio = anio + "-" + mes + "-" + dia;
//              System.out.println("  Fecha 1: " + fecha_inicio);
//            fecha_limite = anio + "-" + mes + "-" + dia;
//              System.out.println("  Fecha 2: " + fecha_limite);
            
            registro_promo[4] = fecha_inicio;
            registro_promo[5] = fecha_limite;
            
            
            registro_promo[6] = Integer.toString(id_sucursal);
            table_promo.addRow(registro_promo);

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 103: " + err.getMessage());
        }} 
     
      int cursor = 1;
     
     
     
     
     
     public DefaultTableModel table_promo = new DefaultTableModel();
     
    private String[] registro_promo = new String[7];
    private String temp_idpromo;
    private String temp_nomproducto;
    private String temp_descpromo;
    private String temp_tipopromo;
    private String temp_iniciopromo;
    private String temp_limitepromo;
    private String tem_idsucursal;
    private String temp_idproducto;

    public String getTemp_idproducto() {
        return temp_idproducto;
    }

    public void setTemp_idproducto(String temp_idproducto) {
        this.temp_idproducto = temp_idproducto;
    }

    public DefaultTableModel getTable_promo() {
        return table_promo;
    }

    public void setTable_promo(DefaultTableModel table_promo) {
        this.table_promo = table_promo;
    }

    public String getTemp_idpromo() {
        return temp_idpromo;
    }

    public void setTemp_idpromo(String temp_idpromo) {
        this.temp_idpromo = temp_idpromo;
    }

    public String getTemp_nomproducto() {
        return temp_nomproducto;
    }

    public void setTemp_nomproducto(String temp_nomproducto) {
        this.temp_nomproducto = temp_nomproducto;
    }

    

    public String getTemp_descpromo() {
        return temp_descpromo;
    }

    public void setTemp_descpromo(String temp_descpromo) {
        this.temp_descpromo = temp_descpromo;
    }

    public String getTemp_tipopromo() {
        return temp_tipopromo;
    }

    public void setTemp_tipopromo(String temp_tipopromo) {
        this.temp_tipopromo = temp_tipopromo;
    }

    public String getTemp_iniciopromo() {
        return temp_iniciopromo;
    }

    public void setTemp_iniciopromo(String temp_iniciopromo) {
        this.temp_iniciopromo = temp_iniciopromo;
    }

    public String getTemp_limitepromo() {
        return temp_limitepromo;
    }

    public void setTemp_limitepromo(String temp_limitepromo) {
        this.temp_limitepromo = temp_limitepromo;
    }

    public String getTem_idsucursal() {
        return tem_idsucursal;
    }

    public void setTem_idsucursal(String tem_idsucursal) {
        this.tem_idsucursal = tem_idsucursal;
    }
    
    
     
    
     
     
    public void llenarTabla() {
        try {
            table_promo.addColumn("ID Promocion");
            table_promo.addColumn("Nombre del Producto");
            table_promo.addColumn("Tipo Promocion");
            table_promo.addColumn("Descuento");
            table_promo.addColumn("Fecha Inicio");
            table_promo.addColumn("Fecha Limite");
            table_promo.addColumn("Sucursal");
           mostrar();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
        }
    }
    
    
    
    
    public void agregarPromocion() {
        try {
            registro_promo[0] = temp_idpromo;
            registro_promo[1] = temp_nomproducto;
           
            registro_promo[2] = temp_tipopromo;
            registro_promo[3] = temp_descpromo;
            
            // fechas
            temp_iniciopromo = anio + "-" + mes + "-" + dia;
              System.out.println("  Fecha 1: " + temp_iniciopromo);
            temp_limitepromo = anio + "-" + mes + "-" + dia;
              System.out.println("  Fecha 2: " + temp_limitepromo);
              
            registro_promo[4] = temp_iniciopromo;
            registro_promo[5] = temp_limitepromo;
            
            registro_promo[6] = tem_idsucursal;
            
             

            table_promo.addRow(registro_promo);
            
            
            id_promocion = this.getId_promocion();
            nom_producto = this.getNom_producto();
            tipo_promocion = this.getTipo_promocion();
            descuento_promocion = this.getDescuento_promocion();
            fecha_inicio_promo = this.getFecha_inicio_promo();
             fecha_limite_promo = this.getFecha_limite_promo();
             nom_sucursal = this.getNom_sucursal();
            
            int id_suc = 0;
            
             int id_prod = 0;
            
            ResultSet consulta = st.executeQuery("SELECT id_sucursal FROM sucursales WHERE nombre_sucursal = '"+ tem_idsucursal +"'; ");
            if(consulta.next()){
                id_suc = consulta.getInt(1);
            }
            
            ResultSet consulta2 = st.executeQuery("SELECT id_producto FROM productos WHERE nombre_producto = '"+ temp_nomproducto +"'; ");
            if(consulta2.next()){
                id_prod = consulta2.getInt(1);
            }
            
                    st.executeUpdate("INSERT INTO promociones (id_producto, tipo_promocion, descuento_promocion, fecha_inicio_promo,fecha_limite_promo, id_sucursal)"
                    + " VALUES (" + id_prod + ", '" + temp_tipopromo + "', "+ temp_descpromo +", '"+ temp_iniciopromo + "','" + temp_limitepromo + "'," + id_suc+ "); ");
                    JOptionPane.showMessageDialog(null,"Guardado con Exito");
             this.conectarDB();       
             
             //si quito mostrar me pone el id de producto 35 y si no lo quito me repite los mismos registros pero con el id correspondiente
            mostrar();
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"No se puede guardar");
        }
 
    }
    
        public void modificarPromocion(){
            try{
                
            registro_promo[0] = temp_idpromo;
            registro_promo[1] = temp_nomproducto;
           
            registro_promo[2] = temp_tipopromo;
            registro_promo[3] = temp_descpromo;
            
            // fechas
            temp_iniciopromo = anio + "-" + mes + "-" + dia;
              System.out.println("  Fecha 1: " + temp_iniciopromo);
            temp_limitepromo = anio + "-" + mes + "-" + dia;
              System.out.println("  Fecha 2: " + temp_limitepromo);
              
            registro_promo[4] = temp_iniciopromo;
            registro_promo[5] = temp_limitepromo;
            
            registro_promo[6] = tem_idsucursal;
                   
                
                
                table_promo.addRow(registro_promo);
                
       
        id_promocion = this.getId_promocion();
       
        id_producto = this.getId_producto();
        tipo_promocion = this.getTipo_promocion();
        descuento_promocion = this.getDescuento_promocion();
        fecha_inicio_promo = this.getFecha_inicio_promo();
        fecha_limite_promo = this.getFecha_limite_promo();
        id_sucursal = this.getId_sucursal();
             
        
                
        st.executeUpdate("UPDATE promociones SET id_producto = "+ id_producto +", tipo_promocion = '"+ temp_tipopromo +"', "
                    + "descuento_promocion = '"+ temp_descpromo +"', fecha_inicio_promo= '"+ temp_iniciopromo +"', "
                       + "fecha_limite_promo = '"+temp_limitepromo +"' "
                                            + "WHERE id_promocion = "+ temp_idpromo +"; ");
         JOptionPane.showMessageDialog(null,"Modificado con exito");   
           this.conectarDB();  
           
    } catch(SQLException err){
        JOptionPane.showMessageDialog(null,"Error "+err.getMessage()); 
    }
        
    
    }

        
        
        
        
        //variables DESCUENTOS
        
    
        private int id_descuento;
        private float monto_minimo;
        private float monto_limite;
        private int porcentaje_descuento;
        private Date  fecha_inicio2;
        private Date fecha_limite2;
        
        private String fecha_ini; 
        private String fecha_lim;
        
        
        private String diaDesc1;
        private String mesDesc1;
        private String anioDesc1;
        
        
         private String diaDesc2;
        private String mesDesc2;
        private String anioDesc2;
        
    public int getId_descuento() {
        return id_descuento;
    }

    public void setId_descuento(int id_descuento) {
        this.id_descuento = id_descuento;
    }

    public float getMonto_minimo() {
        return monto_minimo;
    }

    public void setMonto_minimo(float monto_minimo) {
        this.monto_minimo = monto_minimo;
    }

    public float getMonto_limite() {
        return monto_limite;
    }

    public void setMonto_limite(float monto_limite) {
        this.monto_limite = monto_limite;
    }

    public int getPorcentaje_descuento() {
        return porcentaje_descuento;
    }

    public void setPorcentaje_descuento(int porcentaje_descuento) {
        this.porcentaje_descuento = porcentaje_descuento;
    }

    public Date getFecha_inicio2() {
        return fecha_inicio2;
    }

    public void setFecha_inicio2(Date fecha_inicio2) {
        this.fecha_inicio2 = fecha_inicio2;
    }

    public Date getFecha_limite2() {
        return fecha_limite2;
    }

    public void setFecha_limite2(Date fecha_limite2) {
        this.fecha_limite2 = fecha_limite2;
    }
    
    

    public String getFecha_ini() {
        return fecha_ini;
    }

    public void setFecha_ini(String fecha_ini) {
        this.fecha_ini = fecha_ini;
    }

    public String getFecha_lim() {
        return fecha_lim;
    }

    public void setFecha_lim(String fecha_lim) {
        this.fecha_lim = fecha_lim;
    }

    public String getDiaDesc1() {
        return diaDesc1;
    }

    public void setDiaDesc1(String diaDesc1) {
        this.diaDesc1 = diaDesc1;
    }

    public String getMesDesc1() {
        return mesDesc1;
    }

    public void setMesDesc1(String mesDesc1) {
        this.mesDesc1 = mesDesc1;
    }

    public String getAnioDesc1() {
        return anioDesc1;
    }

    public void setAnioDesc1(String anioDesc1) {
        this.anioDesc1 = anioDesc1;
    }

    public String getDiaDesc2() {
        return diaDesc2;
    }

    public void setDiaDesc2(String diaDesc2) {
        this.diaDesc2 = diaDesc2;
    }

    public String getMesDesc2() {
        return mesDesc2;
    }

    public void setMesDesc2(String mesDesc2) {
        this.mesDesc2 = mesDesc2;
    }

    public String getAnioDesc2() {
        return anioDesc2;
    }

    public void setAnioDesc2(String anioDesc2) {
        this.anioDesc2 = anioDesc2;
    }
    
    
        
        
         
        

     public void llenarTabla2() {
        try {
            table_descuento.addColumn("Id Descuento");
            table_descuento.addColumn("Monto Minimo");
            table_descuento.addColumn("Monto maximo");
            table_descuento.addColumn("Descuento");
            table_descuento.addColumn("Fecha Inicio");
            table_descuento.addColumn("Fecha Limite");
           
           mostrar2();
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null,"Error "+err.getMessage());
        }
    }    
    
     

            public DefaultTableModel table_descuento = new DefaultTableModel();
     
                  private String[] registro_descuento = new String[6];
                  private String temp_iddescuento;
                  private String temp_montomini;
                  private String temp_montolimi;
                  private String temp_porcentaje;
                  private String temp_fechaini;
                  private String temp_fechalimi;

    public DefaultTableModel getTable_descuento() {
        return table_descuento;
    }

    public void setTable_descuento(DefaultTableModel table_descuento) {
        this.table_descuento = table_descuento;
    }

    public String[] getRegistro_descuento() {
        return registro_descuento;
    }

    public void setRegistro_descuento(String[] registro_descuento) {
        this.registro_descuento = registro_descuento;
    }

    public String getTemp_iddescuento() {
        return temp_iddescuento;
    }

    public void setTemp_iddescuento(String temp_iddescuento) {
        this.temp_iddescuento = temp_iddescuento;
    }

    public String getTemp_montomini() {
        return temp_montomini;
    }

    public void setTemp_montomini(String temp_montomini) {
        this.temp_montomini = temp_montomini;
    }

    public String getTemp_montolimi() {
        return temp_montolimi;
    }

    public void setTemp_montolimi(String temp_montolimi) {
        this.temp_montolimi = temp_montolimi;
    }

    public String getTemp_porcentaje() {
        return temp_porcentaje;
    }

    public void setTemp_porcentaje(String temp_porcentaje) {
        this.temp_porcentaje = temp_porcentaje;
    }

    public String getTemp_fechaini() {
        return temp_fechaini;
    }

    public void setTemp_fechaini(String temp_fechaini) {
        this.temp_fechaini = temp_fechaini;
    }

    public String getTemp_fechalimi() {
        return temp_fechalimi;
    }

    public void setTemp_fechalimi(String temp_fechalimi) {
        this.temp_fechalimi = temp_fechalimi;
    }
    
    public void conectarDB2() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
            String sql2 = "SELECT * FROM descuentos";
            
            rs = st.executeQuery(sql2);
            
            rs.first();
            setValues2();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelPromocionesDescuentos 001: " + err.getMessage());
        }
    }
     public void setValues2() {
        try {
            
            
            //descuentos
            id_descuento = rs.getInt("id_descuento");
            monto_minimo = rs.getFloat("monto_minimo");
            monto_limite = rs.getFloat("monto_limite");
            
            porcentaje_descuento = rs.getInt("porcentaje_descuento");
            fecha_inicio2 = rs.getDate("fecha_inicio");
            fecha_limite2 = rs.getDate("fecha_limite");

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 105: " + err.getMessage());
        }
    }
    
    
    
    
     private ResultSet descuen;
    public void setValuesDescuento() {
        try {
            id_descuento = descuen.getInt("id_descuento");
            monto_minimo = descuen.getFloat("monto_minimo");
            monto_limite = descuen.getFloat("monto_limite");
            
            porcentaje_descuento = descuen.getInt("porcentaje_descuento");
         
            
            registro_descuento[0] = Integer.toString(id_descuento);
            registro_descuento[1] = Float.toString(monto_minimo);
            registro_descuento[2] = Float.toString(monto_limite);
            registro_descuento[3] = Integer.toString(porcentaje_descuento);
            
//            // fechas
//            fecha_inicio = anio + "-" + mes + "-" + dia;
//              System.out.println("  Fecha 1: " + fecha_inicio);
//            fecha_limite = anio + "-" + mes + "-" + dia;
//              System.out.println("  Fecha 2: " + fecha_limite);
            
            registro_descuento[4] = fecha_ini;
            registro_descuento[5] = fecha_lim;
            
            
            
            table_descuento.addRow(registro_descuento);

        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error model 103: " + err.getMessage());
        }} 
    
    
    public void mostrar2() throws SQLException{
        st = conexion.createStatement();  
        
        String sql2 = "select id_descuento, monto_minimo, monto_limite, porcentaje_descuento, fecha_inicio, fecha_limite from descuentos";
        rs = st.executeQuery(sql2);
        
       
             try{
                 while(rs.next()){
                     
                     
                     table_promo.addRow(new Object[]{
                         rs.getString("id_descuento"),
                         rs.getString("monto_minimo"),
                         rs.getString("monto_limite"),
                         rs.getString("porcentaje_descuento"),
                         rs.getString("fecha_inicio"),
                        
                          rs.getString("fecha_limite")});
                    
                     }
                             
                 } catch(Exception e){
                     
                     System.out.println(e);
                 
             } 
     }
    
    
   public void agregarDescuento() {
        try {
            registro_descuento[0] = temp_iddescuento;
            registro_descuento[1] = temp_montomini;
           
            registro_descuento[2] = temp_montolimi;
            registro_descuento[3] = temp_porcentaje;
            
            
            // fechas
            temp_fechaini = anioDesc1 + "-" + mesDesc1 + "-" + diaDesc1;
              System.out.println("  Fecha 1: " + temp_fechaini);
            temp_fechalimi = anioDesc2 + "-" + mesDesc2 + "-" + diaDesc2;
              System.out.println("  Fecha 2: " + temp_fechalimi);
              
            registro_descuento[4] = temp_fechaini;
            registro_descuento[5] = temp_fechalimi;
 
            table_descuento.addRow(registro_descuento);
            
            
          id_descuento= this.getId_descuento();
            monto_minimo = this.getMonto_minimo();
            monto_limite = this.getMonto_limite();
            porcentaje_descuento = this.getPorcentaje_descuento();
            fecha_inicio2 = this.getFecha_inicio2();
            fecha_limite2 = this.getFecha_limite2();
        
            
            
                    st.executeUpdate("INSERT INTO descuentos ( monto_minimo, monto_limite, porcentaje_descuento, fecha_inicio, fecha_limite)"
                    + " VALUES ( " + temp_montomini+ ", " + temp_montolimi + ","+ temp_porcentaje+ ",'" + temp_fechaini + "','" + temp_fechalimi + "'); ");
                    JOptionPane.showMessageDialog(null,"Guardado con Exito");
             
             this.conectarDB2();
             
           mostrar2();
        }catch(Exception err){
            JOptionPane.showMessageDialog(null,"No se puede guardar");
        }
 
      }
}

     


             
 