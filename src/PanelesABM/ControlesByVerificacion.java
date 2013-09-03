/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Entidades.Conexion;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

/**
 * trae la lista de los controles contenidos en la verificación
 *
 * @author aguilangeles@gmail.com
 */
public class ControlesByVerificacion {

  private int idVerificacion;

  public ControlesByVerificacion() {
  }

  public List<Integer> idControlesByVerificacion(JComboBox tipoVerificacionBox,
          Conexion con, List<Integer> idTipoControl) {
    String result = (String) tipoVerificacionBox.getSelectedItem();
    String[] dos = result.split("-");
    int id = Integer.parseInt(dos[0]);
    idVerificacion = id;
    String selec = "SELECT idControl FROM qualitys.controles_verificacion where"
            + " idVerificacion =" + id + ";";
    if (con.isConexion()) {
      try {
        con.executeQuery(selec);
        while (con.resulset.next()) {
          idTipoControl.add(con.resulset.getInt(1));
        }
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(tipoVerificacionBox, ex.getMessage(),
                CargarLote.class.getName(), JOptionPane.ERROR_MESSAGE);
      }
    }
    return idTipoControl;
  }
  public int getIdVerificacion() {
    return idVerificacion;
  }
}
