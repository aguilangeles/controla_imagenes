/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package archivoConfiguracion;

import Helpers.MensajeJoptionPane;
import Login.IngresoBaseDeDatos;
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

  private String className = SetConfigFile.class.getName();
  private static final String CONFIG = "config.properties";
  private Properties properties = new Properties();
  private MensajeJoptionPane mensaje = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);

  public SetConfigFile() {
    removerCamposYAbrirNuevoLog();
  }

  public SetConfigFile(String url, String database, String user, String password) {
    mostrarCamposExistentes(url, database, user, password);
  }

  private void removerCamposYAbrirNuevoLog() {
    /*si el usuario es admininstrador, permite el ingreso de nuevos campos*/
    try
      {
      properties.setProperty("url", "");
      properties.setProperty("database", "");
      properties.setProperty("dbuser", "");
      properties.setProperty("dbpassword", "");
      properties.store(new FileOutputStream(CONFIG), null);
      java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
          new IngresoBaseDeDatos().setVisible(true);
        }
      });
      } catch (IOException e)
      {
      mensaje.getMessage(e.getMessage(), className);
      }
  }

  private void mostrarCamposExistentes(String url, String database, String user, String password) {
    /*si el usuario es carga, muestra la base que se ha establecido como principal*/
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