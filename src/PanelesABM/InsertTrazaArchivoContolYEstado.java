/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import Entidades.Conexion;
import Helpers.UltimoIDInsertado;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class InsertTrazaArchivoContolYEstado {

  public InsertTrazaArchivoContolYEstado(int idTraza, List<Integer> idControl, Conexion conexion) {

    insert(idTraza, idControl, conexion);
  }

  private void insert(int idTraza, List<Integer> idControl, Conexion conexion) {
    int id = idTraza + 1;
    for (Integer idarchivo : idControl) {
      int lasid = new UltimoIDInsertado(conexion, "archivo").getUltimoID();
      String ret = "Insert into qualitys.traza_archivo_controles "
              + "(idtraza, idarchivo, idcontrol, estado) VALUES "
              + "(" + id + ", " + lasid + ", " + idarchivo + ", " + 0 + ");";
      try {
        conexion.executeUpdate(ret);
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Imagen y control", JOptionPane.ERROR_MESSAGE);
      }
    }
  }
}
