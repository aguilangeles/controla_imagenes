/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import helper.MensajeJoptionPane;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *setea a 1 el estado del documento rechazado
 * @author aguilangeles@gmail.com
 */
public class SetEstadoDocumentoInSublote {

  private List<Integer> idSubloteRechazado;

  public SetEstadoDocumentoInSublote(List<Integer> idSubloteRechazado) {
    this.idSubloteRechazado = idSubloteRechazado;
    iterar();
  }

  private void iterar() {
    for (Integer in : idSubloteRechazado)
      {
      setearEstadoDocumento(in);
      }
  }

  private void setearEstadoDocumento(int idSublote) {
    Conexion conexion = new Conexion();
    if (conexion.isConexion())
      {
      try
        {
        String update = "UPDATE `qualitys`.`sublotes`"
                + " SET"
                + "`estado` = 1"
                + " WHERE id= " + idSublote + ";";
        conexion.executeUpdate(update);
        conexion.isConexionClose();
        } catch (SQLException ex)
        {
        MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
        msg.getMessage(ex.getMessage(), SetEstadoDocumentoInSublote.class.getName());
        }
      }
  }
}
