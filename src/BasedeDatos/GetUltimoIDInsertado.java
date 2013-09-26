/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Obtiene el ultimo id según la base requerida.
 *
 * @author MUTNPROD003
 */
public class GetUltimoIDInsertado {

  private Conexion conexion;
  private String tabla;

  public GetUltimoIDInsertado(Conexion conexion, String tabla) {
    this.conexion = conexion;
    this.tabla = tabla;
  }

  public int getUltimoID() {
    int ret = 0;
    try
      {
      conexion.executeQuery("SELECT max(id) FROM " + tabla + ";");
      while (conexion.resulset.next())
        {
        ret = conexion.resulset.getInt(1);
        }
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Obtener Ultimo ID", JOptionPane.ERROR_MESSAGE);
      }

    return ret;
  }
}
