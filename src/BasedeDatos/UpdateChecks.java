/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import BasedeDatos.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class UpdateChecks {

  private int estado;
  private boolean end = false;
  private int idtrazaArchivo;
  private Conexion conexion;

  public UpdateChecks(int estado, int idtrazaArchivo, Conexion conexion) {
    this.estado = estado;
    this.idtrazaArchivo = idtrazaArchivo;
    this.conexion = conexion;
  }

  public void updateEstadoTraza() {
    String update = "UPDATE traza_archivo_controles SET estado = "
            + estado + " WHERE id= " + idtrazaArchivo + ";";
    try {
      conexion.executeUpdate(update);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Setear estado archivo controles", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void updateEstadoArchivo(int id) {

    String update = "UPDATE archivo SET estado =  1 WHERE id = " + id + ";";
    try {
      conexion.executeUpdate(update);
    } catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Setear estado archivo", JOptionPane.ERROR_MESSAGE);
    }
  }
}
