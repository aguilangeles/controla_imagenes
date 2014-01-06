/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteLote;

import javax.swing.JTextArea;
import BasedeDatos.Conexion;
import Helpers.EscribeInforme;
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

  public UpdateEstadoLote(Conexion conexion, int idtraza, boolean estado,
          JTextArea mensaje, JTable tabla, JButton finalizar) {
    this.conexion = conexion;
    this.idtraza = idtraza;
    this.mensaje = mensaje;
    this.setEstado = (!estado) ? 0 : 1;
    update();
    EscribeInforme escribeInforme = new EscribeInforme(tabla, estado, mensaje.getText(), finalizar, idtraza);
  }

  public UpdateEstadoLote(Conexion conexion, int idtraza, boolean estado,
          JTextArea mensaje, JTable tabla, JButton finalizar, boolean isdocumento) {
    this.conexion = conexion;
    this.idtraza = idtraza;
    this.mensaje = mensaje;
    this.setEstado = (!estado) ? 0 : 1;
    update();
  }

  private void update() {
    String observaciones = mensaje.getText();
    String update = "UPDATE `qualitys`.`traza` "
            + "SET `estadoLote` = " + setEstado + ", `observaciones` = '" + observaciones + "' "
            + "WHERE id =" + idtraza + ";";
    try
      {
      conexion.executeUpdate(update);
      } catch (SQLException ex)
      {
      MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(ex.getMessage(), UpdateEstadoLote.class.getName());
      }
  }
}
