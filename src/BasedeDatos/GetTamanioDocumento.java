/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetTamanioDocumento {

  private static int sizeDocumento;

  public GetTamanioDocumento() {
  }

  public static int consultarTamanioDocumento(Conexion conexion, int idTraza) {
    int ret = 0;
    try
      {
      String query = "SELECT count(*) FROM qualitys.sublotes where idtraza =" + idTraza + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        ret = conexion.resulset.getInt(1);
        }
      } catch (SQLException ex)
      {
      MensajeJoptionPane mensaje = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
      mensaje.getMessage(ex.getMessage(), GetTamanioDocumento.class.getName());
      }
    return ret;
  }

  public static int getSizeDocumento() {
    return sizeDocumento;
  }
}
