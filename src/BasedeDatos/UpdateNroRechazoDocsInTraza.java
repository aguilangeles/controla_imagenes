/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class UpdateNroRechazoDocsInTraza {

  private Conexion conexion;
  private int idTraza;
  private int rechazos;

  public UpdateNroRechazoDocsInTraza(Conexion conexion, int idTraza, int rechazos) {
    this.conexion = conexion;
    this.idTraza = idTraza;
    this.rechazos = rechazos;
    updateTrazaNroRechazo();
  }

  private void updateTrazaNroRechazo() {
    try
      {
      String update = "UPDATE `qualitys`.`traza` "
              + "SET `nro_rechazo` = " + rechazos
              + " WHERE id = " + idTraza + ";";
      conexion.executeUpdate(update);
      } catch (SQLException ex)
      {
      MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR);
      Logger.getLogger(UpdateNroRechazoDocsInTraza.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
