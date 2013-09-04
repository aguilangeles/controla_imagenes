/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

import ArchivoConfig.SetConfigFile;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import BasedeDatos.Conexion;
import Daos.LogQualitys;

/**
 *
 * @author MUTNPROD003
 */
public class TestBaseDeDatos {

  private static final String STRING_VALIDO = "El campo no puede estar vac�o";
  private static final String CONEXION_EXITOSA = "La conexi�n ha sido exitosa.\nEl programa se cerrar�\nPara ingresar al panel de "
          + "control deber� ingresar\n su usuario y password validado en la DB";

  public TestBaseDeDatos(JTextField url, JTextField database, JTextField usuario,
          JTextField password, Conexion conexion, JButton aceptar, boolean isTest, JFrame validarUsuario) {
    try {
      String thisUrl = validarString(url.getText());
      String thisDatabase = validarString(database.getText());
      String thisUsuario = validarString(usuario.getText());
      String thisPassw = validarString(password.getText());
      LogQualitys userQualitys = new LogQualitys(thisUrl, thisDatabase, thisUsuario, thisPassw);
      testConexion(userQualitys, conexion, aceptar, isTest, validarUsuario);
    } catch (RuntimeException aRuntimeExc) {
      JOptionPane.showMessageDialog(null, aRuntimeExc.getMessage(), "Campo sin valor", JOptionPane.ERROR_MESSAGE);
    }
  }

  private void testConexion(LogQualitys aUsuario, Conexion conexion, JButton aceptar, boolean test, JFrame validarUsuario) {
    SetConfigFile setProperties = new SetConfigFile(aUsuario.getUrl(), aUsuario.getBase(), aUsuario.getUsuario(), aUsuario.getPassword());
    if (conexion.isConexion()) {
      aceptar.setBackground(Color.GREEN);
      aceptar.setText("OK");
      if (!test) {
        JOptionPane.showMessageDialog(validarUsuario, CONEXION_EXITOSA,
                "Configuraci�n inicial", JOptionPane.INFORMATION_MESSAGE);
        conexion.isConexionClose();
        System.exit(0);
      } else {
        aceptar.setText("Test OK");
        JOptionPane.showMessageDialog(validarUsuario, "Conexi�n exitosa",
                "Test de Conexi�n", JOptionPane.INFORMATION_MESSAGE);
        conexion.isConexionClose();
        validarUsuario.dispose();
      }
    } else {
      aceptar.setBackground(Color.RED);
      aceptar.setText("Error");
      JOptionPane.showMessageDialog(validarUsuario,
              "\nLa conexi�n ha fallado .\n\nEl programa se cerrar�\n"
              + "Intentelo nuevamente", "Falla en la config. inicial",
              JOptionPane.ERROR_MESSAGE);
      System.exit(0);
    }
  }

  private String validarString(String aString) {
    if (aString.trim().isEmpty()) {
      throw new RuntimeException(STRING_VALIDO);
    }
    return aString;
  }
}
