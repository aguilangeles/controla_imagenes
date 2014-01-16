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
  private int setEstado;
  private String captura;
  private String digitalizador;

  public UpdateEstadoLote(Conexion conexion, int idtraza, boolean estado,
          JTextArea mensaje, String captura, String digitalizador) {
    this.conexion = conexion;
    this.idtraza = idtraza;
    this.mensaje = mensaje;
    this.setEstado = (!estado) ? 0 : 1;
    this.captura = captura;
    this.digitalizador = digitalizador;
    updateEstado();
  }

  private void updateEstado() {
    String observaciones = mensaje.getText();
    String update2 = "UPDATE `qualitys`.`traza` "
            + "SET `estadoLote` = " + setEstado
            + ", `observaciones` = '" + observaciones + "'"
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

  private String filtroNull(String astring, JTable tabla) {
    if (astring.isEmpty())
      {
      MensajeJoptionPane msg = new MensajeJoptionPane(tabla, JOptionPane.ERROR_MESSAGE);
      msg.getMessage("Completar linea de captura y digitalizador", UpdateEstadoLote.class.getName());
      }
    return astring;
  }
}
