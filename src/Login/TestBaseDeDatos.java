/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import archivoConfiguracion.SetConfigFile;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import database.Conexion;
import entidad.LogQualitys;
import Helpers.MensajeJoptionPane;
import Helpers.VersionEImageIcon;
import javax.swing.ImageIcon;

/**
 *
 * @author MUTNPROD003
 */
public class TestBaseDeDatos {

  private static final String className = TestBaseDeDatos.class.getName();
  private MensajeJoptionPane msg;
  private static final String STRING_VALIDO = "El campo no puede estar vacío";
  private static final String CONEXION_EXITOSA = "La conexión ha sido exitosa.\nEl programa se cerrará\nPara ingresar al panel de "
          + "control deberá ingresar\n su usuario y password validado en la DB";

  public TestBaseDeDatos(JTextField url, JTextField database, JTextField usuario,
          JTextField password, Conexion conexion, JButton aceptar, boolean isTest, JFrame validarUsuario) {
    try
      {
      String thisUrl = validarString(url.getText());
      String thisDatabase = validarString(database.getText());
      String thisUsuario = validarString(usuario.getText());
      String thisPassw = validarString(password.getText());
      LogQualitys userQualitys = new LogQualitys(thisUrl, thisDatabase, thisUsuario, thisPassw);
      testConexion(userQualitys, conexion, aceptar, isTest, validarUsuario);
      } catch (RuntimeException aRuntimeExc)
      {
      msg=new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(aRuntimeExc.getMessage(), className);
//      JOptionPane.showMessageDialog(null, aRuntimeExc.getMessage(), "Campo sin valor", JOptionPane.ERROR_MESSAGE);
      }
  }

  private void testConexion(LogQualitys aUsuario, Conexion conexion, JButton aceptar, boolean test, JFrame validarUsuario) {
    ImageIcon icon = new ImageIcon(VersionEImageIcon.getIcon());
    SetConfigFile setProperties = new SetConfigFile(aUsuario.getUrl(), aUsuario.getBase(), aUsuario.getUsuario(), aUsuario.getPassword());
    if (conexion.isConexion())
      {
      aceptar.setBackground(Color.GREEN);
      aceptar.setText("OK");
      if (!test)
        {

        JOptionPane.showMessageDialog(validarUsuario, CONEXION_EXITOSA,
                "Configuración inicial", JOptionPane.INFORMATION_MESSAGE,icon);
        conexion.isConexionClose();
        System.exit(0);
        } else
        {
        aceptar.setText("Test OK");
        JOptionPane.showMessageDialog(validarUsuario, "Conexión exitosa",
                "Test de Conexión", JOptionPane.INFORMATION_MESSAGE, icon);
        conexion.isConexionClose();
        validarUsuario.dispose();
        }
      } else
      {
      aceptar.setBackground(Color.RED);
      aceptar.setText("Error");
      JOptionPane.showMessageDialog(validarUsuario,
              "\nLa conexión ha fallado .\n\nEl programa se cerrará\n"
              + "Intentelo nuevamente", "Falla en la config. inicial",
              JOptionPane.ERROR_MESSAGE);
      System.exit(0);
      }
  }

  private String validarString(String aString) {
    if (aString.trim().isEmpty())
      {
      throw new RuntimeException(STRING_VALIDO);
      }
    return aString;
  }
}
