/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package archivoConfiguracion;

import entidad.LogQualitys;
import Helpers.MensajeJoptionPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Lee el archivo de configuracion.
 *
 * @author MUTNPROD003
 */
public class ReadProperties {

  private String className = ReadProperties.class.getName();
  private int messageType = JOptionPane.ERROR_MESSAGE;
  private MensajeJoptionPane mensaje = new MensajeJoptionPane(null, messageType);

  public LogQualitys getUser() {
    LogQualitys user = null;
    FileInputStream in = null;
    try
      {
      Properties p = new Properties();
      in = new FileInputStream("config.properties");
      p.load(in);
      String url = p.getProperty("url");
      String base = p.getProperty("database");
      String usuario = p.getProperty("dbuser");
      String password = p.getProperty("dbpassword");
      user = new LogQualitys(url, base, usuario, password);
      } catch (IOException ex)
      {
      mensaje.getMessage(ex.getMessage(), className);
//      JOptionPane.showMessageDialog(null, ex.getMessage(), "Read Properties", JOptionPane.ERROR_MESSAGE);
      } finally
      {
      if (in != null)
        {
        try
          {
          in.close();
          } catch (IOException ex)
          {
          mensaje.getMessage(ex.getMessage(), className);
          } catch (Throwable ex)
          {
          mensaje.getMessage(ex.getMessage(), className);
          }
        }
      }
    return user;
  }
}
