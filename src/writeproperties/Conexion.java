/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package writeproperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Conexion {

    private JButton boton;
    private final String driver = "com.mysql.jdbc.Driver";
    private Connection conexion;
    public Statement statement = null;
    public ResultSet resulset = null;
    private PreparedStatement prepareStatement;

    public Conexion() {
    }

    public boolean isConexion() {
        try {
            Properties prop = new Properties();
            FileInputStream in = null;
            in = new FileInputStream("config.properties");
            prop.load(in);
            String url = prop.getProperty("url");
            String base = prop.getProperty("database");
            String sUrl = "jdbc:mysql://" + url + "/" + base;
            String user = prop.getProperty("dbuser");
            String passw = prop.getProperty("dbpassword");
            Class.forName(driver);
            conexion = DriverManager.getConnection(sUrl, user, passw);
            if (conexion != null) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
            return false;
    }
 public boolean desconectar() {
        try {
            conexion.close();
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return false;
        }
    }
//para consultar
    public void ExecuteSql(String sql) {
        try {
            statement = (Statement) conexion.createStatement();
            resulset = statement.executeQuery(sql);

        } catch (SQLException sqle) {
//envia mensajes si la consulta tuvo un error
            do {

                System.out.println("SQL STATE: " + sqle.getSQLState());
                System.out.println("ERROR CODE: " + sqle.getErrorCode());
                System.out.println("MESSAGE: " + sqle.getMessage());
                System.out.println();
                sqle = sqle.getNextException();
            } while (sqle != null);
        }
    }
//para insertar y setear
    public void executeUpdate(String sql) {
        try {
            prepareStatement = conexion.prepareStatement(sql);
            int filasAfectadas = prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
    }
}
