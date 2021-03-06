/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import archivoConfiguracion.ReadProperties;
import helper.MensajeJoptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
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
  private int messageType = JOptionPane.ERROR_MESSAGE;
  private String className = Conexion.class.getName();
  MensajeJoptionPane mensaje = new MensajeJoptionPane(null, messageType);

  public Conexion() {
  }

  public boolean isConexion() {
    Properties prop = new ReadProperties().readProperties("config.properties");
    String url = prop.getProperty("url");
    String base = prop.getProperty("database");
    String urlExtendida = "jdbc:mysql://" + url + "/" + base;
    String user = prop.getProperty("dbuser");
    String passw = prop.getProperty("dbpassword");
    try
    {
      Class.forName(DRIVER);
      conexion = DriverManager.getConnection(urlExtendida, user, passw);
    } catch (SQLException ex)
    {
      mensaje.getMessage(ex.getMessage(), className);

    } catch (ClassNotFoundException e)
    {
      mensaje.getMessage(e.getMessage(), className);
    }
    return conexion != null;
  }
  
 
  public boolean isConexionClose() {
    if (resulset != null)
      {
      try
        {
        resulset.close();
        } catch (SQLException ex)
        {
        mensaje.getMessage(ex.getMessage(), className);
        }
      }
    if (statement != null)
      {
      try
        {
        statement.close();
        } catch (SQLException ex)
        {
        mensaje.getMessage(ex.getMessage(), className);
        }
      }
    if (conexion != null)
      {
      try
        {
        if (!conexion.isClosed())
          {
          try
            {
            conexion.close();

            return true;
            } catch (SQLException ex)
            {
            mensaje.getMessage(ex.getMessage(), className);
            return false;
            }
          }
        } catch (SQLException ex)
        {
        mensaje.getMessage(ex.getMessage(), className);
        }
      }
    return false;
  }
//para consultar

  public void executeQuery(String sql) {
    try
      {
      statement = (Statement) conexion.createStatement();
      resulset = statement.executeQuery(sql);

      } catch (SQLException sqle)
      {
//envia mensajes si la consulta tuvo un error
      do
        {
        System.out.println("SQL STATE: " + sqle.getSQLState());
        System.out.println("ERROR CODE: " + sqle.getErrorCode());
        System.out.println("MESSAGE: " + sqle.getMessage());
        System.out.println();
        sqle = sqle.getNextException();
        } while (sqle != null);
      }
  }

  public void executeUpdate(String sql) throws SQLException {
    prepareStatement = conexion.prepareStatement(sql);
    filasAfectadas = prepareStatement.executeUpdate();
  }
  
}
