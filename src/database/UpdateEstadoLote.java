/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import javax.swing.JTextArea;
import helper.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author MUTNPROD003
 */
public class UpdateEstadoLote {

  private Conexion conexion;
  private int idtraza;
  private JTextArea mensaje;
  private String captura;
  private String digitalizador;

  public UpdateEstadoLote(Conexion conexion, int idtraza, JTextArea mensaje, String captura, String digitalizador) {
    this.conexion = conexion;
    this.idtraza = idtraza;
    this.mensaje = mensaje;
    this.captura = captura;
    this.digitalizador = digitalizador;
    updateEstado();
  }

  private void updateEstado() {
    String observaciones = mensaje.getText();
    String update2 = "UPDATE `qualitys`.`traza` "
            + "SET "
            + "`observaciones` = '" + observaciones + "'"
            + ", `linea_captura` = '" + captura
            + "', `digitalizador` ='" + digitalizador + "'"
            + "WHERE id =" + idtraza + ";";
    try
      {
      conexion.executeUpdate(update2);
      } catch (SQLException ex)
      {
      MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(ex.getMessage(), UpdateEstadoLote.class.getName());
      }
  }
}
