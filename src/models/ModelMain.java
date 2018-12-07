package models;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

import java.util.Properties; // Probando ... +3
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author ERKA Software
 */
public class ModelMain {

    private Connection conexion;
    private Statement st;
    private ResultSet rs;

    /**
     * Método que realiza las siguietnes acciones: 1- Conecta con la base de
     * datos ferreteria_acme.
     */
    public void conectarDB() {
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3307/ferreteria_acme", "root", "");
            st = conexion.createStatement();
//            String sql = "SELECT * FROM administradores;"; // Probando... (3)
//            rs = st.executeQuery(sql);
//            rs.next();
        } catch (SQLException err) {
            JOptionPane.showMessageDialog(null, "Error ModelMain 001: " + err.getMessage());
        }
    }
    
    
    

    private static final String USERNAME = "pi";
    private static final String HOST = "proxy19.rt3.io";
    private static final int PORT = 31499;
    private static final String PASSWORD = "raspberry";
     /**
     *
     */
    public void generarRespaldo() {
        try {
            SSHConnector sshConnector = new SSHConnector();
             sshConnector.connect(USERNAME, PASSWORD, HOST, PORT);
            String result = sshConnector.executeCommand("mysqldump -u tic41 -ptic41 ferreteria_acme > /home/pi/Documents/ERKASoftwareBD/bd-backup_fe-acme.sql");
            sshConnector.disconnect();
             System.out.println(result);
            JOptionPane.showMessageDialog(null, "Respaldo generado correctamente.");
         } catch (JSchException ex) {
            ex.printStackTrace();
             System.out.println(ex.getMessage());
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
             System.out.println(ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace();
             System.out.println(ex.getMessage());
        }
 //            JOptionPane.showMessageDialog(null, "Archivo de respaldo generado.");
//        } catch (Exception ex) {
//            JOptionPane.showMessageDialog(null, "Error al generar respaldo de la BD: " + ex.getMessage());
//        }
    }
     
    
    

    /**
     * Clase encargada de establecer conexión y ejecutar comandos SSH.
     */
    public class SSHConnector {
         /**
         * Constante que representa un enter.
         */
        private static final String ENTER_KEY = "n";
        /**
         * Sesión SSH establecida.
         */
        private Session session;
         /**
         * Establece una conexión SSH.
         *
         * @param username Nombre de usuario.
         * @param password Contraseña.
         * @param host Host a conectar.
         * @param port Puerto del Host.
         *
         * @throws JSchException Cualquier error al establecer conexión SSH.
         * @throws IllegalAccessException Indica que ya existe una conexión SSH
         * establecida.
         */
        public void connect(String username, String password, String host, int port)
                throws JSchException, IllegalAccessException {
            if (this.session == null || !this.session.isConnected()) {
                JSch jsch = new JSch();
                 this.session = jsch.getSession(username, host, port);
                this.session.setPassword(password);
                 // Parametro para no validar key de conexion.
                this.session.setConfig("StrictHostKeyChecking", "no");
                 this.session.connect();
            } else {
                throw new IllegalAccessException("Sesion SSH ya iniciada.");
            }
        }
         /**
         * Ejecuta un comando SSH.
         *
         * @param command Comando SSH a ejecutar.
         *
         * @return
         *
         * @throws IllegalAccessException Excepción lanzada cuando no hay
         * conexión establecida.
         * @throws JSchException Excepción lanzada por algún error en la
         * ejecución del comando SSH.
         * @throws IOException Excepción al leer el texto arrojado luego de la
         * ejecución del comando SSH.
         */
        public final String executeCommand(String command)
                throws IllegalAccessException, JSchException, IOException {
            if (this.session != null && this.session.isConnected()) {
                 // Abrimos un canal SSH. Es como abrir una consola.
                ChannelExec channelExec = (ChannelExec) this.session.
                        openChannel("exec");
                 InputStream in = channelExec.getInputStream();
                 // Ejecutamos el comando.
                channelExec.setCommand(command);
                channelExec.connect();
                 // Obtenemos el texto impreso en la consola.
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                StringBuilder builder = new StringBuilder();
                String linea;
                 while ((linea = reader.readLine()) != null) {
                    builder.append(linea);
                    builder.append(ENTER_KEY);
                }
                 // Cerramos el canal SSH.
                channelExec.disconnect();
                 // Retornamos el texto impreso en la consola.
                return builder.toString();
            } else {
                throw new IllegalAccessException("No existe sesion SSH iniciada.");
            }
        }
         /**
         * Cierra la sesión SSH.
         */
        public final void disconnect() {
            this.session.disconnect();
        }
    }
    
    

} // Cierre de la clase ModelMain
