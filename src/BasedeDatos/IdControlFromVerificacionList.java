/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * Trae la lista de los id de control contenidos en la verificación. Según la
 * seleccion del Combobox.
 *
 * @author aguilangeles@gmail.com
 */
public class IdControlFromVerificacionList {

  private static final String className = IdControlFromVerificacionList.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private static int idVerificacion;

  public IdControlFromVerificacionList() {
  }

  public List<Integer> idControlesByVerificacion(JComboBox tipoVerificacionBox,
          Conexion con, List<Integer> idTipoControl) {
    idVerificacion = getIdFromComboBox(tipoVerificacionBox);
    String query = "SELECT idControl "
            + " FROM qualitys.controles_verificacion "
            + " where idVerificacion =" + idVerificacion + ";";
    if (con.isConexion())
      {
      try
        {
        con.executeQuery(query);
        while (con.resulset.next())
          {
          idTipoControl.add(con.resulset.getInt(1));
          }
        } catch (SQLException ex)
        {
        msg.getMessage(ex.getMessage(), className);
        }
      }
    return idTipoControl;
  }

  private int getIdFromComboBox(JComboBox tipoVerificacionBox) {
    String combo = (String) tipoVerificacionBox.getSelectedItem();
    String[] dos = combo.split("-");
    int id = Integer.parseInt(dos[0]);
    return id;
  }

  public static int getIdVerificacion() {
    return idVerificacion;
  }
}
