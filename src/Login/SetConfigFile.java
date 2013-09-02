/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class SetConfigFile {

  private static final String CONFIG = "config.properties";
  private Properties properties = new Properties();

  public SetConfigFile() {
    removerYAbrirNuevoLog();
  }

  public SetConfigFile(String url, String database, String user, String password) {
    mostrarCamposExistentes(url, database, user, password);
  }

  private void removerYAbrirNuevoLog() {
    try {
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
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Setear archivo de configuración", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void mostrarCamposExistentes(String url, String database, String user, String password) {
    try {
      properties.setProperty("url", url);
      properties.setProperty("database", database);
      properties.setProperty("dbuser", user);
      properties.setProperty("dbpassword", password);
      properties.store(new FileOutputStream(CONFIG), null);
    } catch (IOException e) {
      JOptionPane.showMessageDialog(null, e.getMessage(), "Setear desde JTextField", JOptionPane.ERROR_MESSAGE);
    }

  }
}
