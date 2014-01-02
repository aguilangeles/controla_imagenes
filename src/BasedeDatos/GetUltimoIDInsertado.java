/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * Obtiene el ultimo id según la base requerida.
 *
 * @author MUTNPROD003
 */
public class GetUltimoIDInsertado {

  private static final String className = ControlesporVerificacionList.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
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
      msg.getMessage(ex.getMessage(), className);
      }
    return ret;
  }
}
