/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Entidades.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class UpdateChecs {

  private int estado;
  private boolean end = false;
  private int idtrazaArchivo;
  private Conexion conexion ;

  public UpdateChecs(int estado, int idtrazaArchivo, Conexion conexion) {
    this.estado = estado;
    this.idtrazaArchivo = idtrazaArchivo;
    this.conexion=conexion;
  }

  public void update() {
      String update = "UPDATE traza_archivo_controles SET estado = " + estado + " WHERE id= " + idtrazaArchivo + ";";
//      System.out.println(update);
    try {
      conexion.executeUpdate(update);
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Setear estado archivo controles", JOptionPane.ERROR_MESSAGE);

//      Logger.getLogger(UpdateChecs.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void updateEstadoArchivo(int id) {

      String update = "UPDATE archivo SET estado =  1 WHERE id = " + id + ";";
    try {
      conexion.executeUpdate(update);
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Setear estado archivo", JOptionPane.ERROR_MESSAGE);

//      Logger.getLogger(UpdateChecs.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
