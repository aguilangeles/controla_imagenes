/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package archivoConfiguracion;

import entidad.LogQualitys;
import helper.MensajeJoptionPane;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * Lee el archivo de configuracion. donde se conservan los datos de conexion a
 * la base de datos.
 *
 * @author MUTNPROD003
 */
public class ReadProperties {

  private final String className = ReadProperties.class.getName();
  private final int messageType = JOptionPane.ERROR_MESSAGE;
  private final MensajeJoptionPane mensaje = new MensajeJoptionPane(null, messageType);

  public ReadProperties() {
  }

  private Properties readProperties(String path) {
    FileInputStream in = null;
    Properties p = null;
    try
    {
      p = new Properties();
      in = new FileInputStream(path);
      p.load(in);
    } catch (IOException ex)
    {
      mensaje.getMessage(ex.getMessage(), className);
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
    return p;
  }

  public LogQualitys getUser() {
    LogQualitys user = null;
    Properties p = readProperties("config.properties");
    String url = p.getProperty("url");
    String base = p.getProperty("database");
    String usuario = p.getProperty("dbuser");
    String password = p.getProperty("dbpassword");
    user = new LogQualitys(url, base, usuario, password);
    return user;
  }

}
