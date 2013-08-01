/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import PanelesABM.RangosDao;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entidades.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class LastID {

  private Conexion conexion;
  private String tabla;

  public LastID(Conexion conexion, String tabla) {
    this.conexion = conexion;
    this.tabla = tabla;
  }

  public int lastId() {
    int ret = 0;
    try {
      conexion.ExecuteSql("SELECT max(id) FROM " + tabla + ";");
      while (conexion.resulset.next()) {
        ret = conexion.resulset.getInt(1);
      }
    } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Obtener Ultimo ID", JOptionPane.ERROR_MESSAGE);

//      Logger.getLogger(RangosDao.class.getName()).log(Level.SEVERE, null, ex);
    }

    return ret;
  }
//SELECT maximo FROM qualitys.rangos_qs where id =1;

}
