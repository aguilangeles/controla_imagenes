/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteLote;

import javax.swing.JTextArea;
import BasedeDatos.Conexion;
import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JButton;
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
          JTextArea mensaje, JTable tabla, JButton finalizar, boolean isdocumento) {
    this.conexion = conexion;
    this.idtraza = idtraza;
    this.mensaje = mensaje;
    this.setEstado = (!estado) ? 0 : 1;
    this.captura = (String) tabla.getValueAt(8, 1);
    this.digitalizador = (String) tabla.getValueAt(9, 1);
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
}
