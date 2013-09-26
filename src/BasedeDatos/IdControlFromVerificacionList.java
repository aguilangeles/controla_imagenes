/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import PaneldeControl.CargarLote;
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

  private int idVerificacion;

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
        JOptionPane.showMessageDialog(tipoVerificacionBox, ex.getMessage(),
                CargarLote.class.getName(), JOptionPane.ERROR_MESSAGE);
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

  public int getIdVerificacion() {
    return idVerificacion;
  }
}
