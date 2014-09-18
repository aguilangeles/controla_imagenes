/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package archivoConfiguracion;

import helper.MensajeJoptionPane;
import log.IngresoBaseDeDatos;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Setea el archivo de configuracion en funcion del tipo de usuario.
 *
 * @author MUTNPROD003
 */
public class SetConfigFile {

  private static final String CONFIG = "config.properties";
  private Properties properties = new ReadProperties().readProperties(CONFIG);
  private String className = SetConfigFile.class.getName();
  private MensajeJoptionPane mensaje = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);

  public SetConfigFile() {
    /*si el usuario es admininstrador, permite el ingreso de nuevos campos*/
    setProperties("", "", "", "");
    newLogin();
  }

  public SetConfigFile(String url, String database, String user, String password) {
    /*si el usuario es carga, muestra la base que se ha establecido como principal*/
    setProperties(url, database, user, password);
  }

  private void newLogin() {
    java.awt.EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
	new IngresoBaseDeDatos().setVisible(true);
      }
    });
  }

  private void setProperties(String url, String database, String user, String password) {
    try
    {
      properties.setProperty("url", url);
      properties.setProperty("database", database);
      properties.setProperty("dbuser", user);
      properties.setProperty("dbpassword", password);
      properties.store(new FileOutputStream(CONFIG), null);
    } catch (IOException e)
    {
      mensaje.getMessage(e.getMessage(), className);
    }
  }
}
