/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Conexion {

  private static final String DRIVER = "com.mysql.jdbc.Driver";
  private Connection conexion;
  public Statement statement = null;
  public ResultSet resulset = null;
  private PreparedStatement prepareStatement;
  private int filasAfectadas;

  public Conexion() {
  }

  public boolean isConexion() {
    FileInputStream in = null;
    try {
      Properties prop = new Properties();
      in = new FileInputStream("config.properties");
      prop.load(in);
      String url = prop.getProperty("url");
      String base = prop.getProperty("database");
      String sUrl = "jdbc:mysql://" + url + "/" + base;
      String user = prop.getProperty("dbuser");
      String passw = prop.getProperty("dbpassword");
      Class.forName(DRIVER);
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
    } finally {
      try {
        in.close();
        finalize();
      } catch (IOException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
      } catch (Throwable ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return false;
  }

  public boolean isConexionClose() {
    if (resulset != null) {
      try {

        resulset.close();
      } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    if (conexion != null) {
      try {
        if (!conexion.isClosed()) {
          try {
            conexion.close();

            return true;
          } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "error en base de datos", JOptionPane.ERROR_MESSAGE);
            return false;
          }
        }
      } catch (SQLException ex) {
        Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
    return false;
  }
//para consultar

  public void executeQuery(String sql) {
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

  public void executeUpdate(String sql) throws SQLException {
    prepareStatement = conexion.prepareStatement(sql);
    filasAfectadas = prepareStatement.executeUpdate();
  }
}
