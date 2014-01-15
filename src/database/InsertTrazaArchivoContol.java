/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Inserta en la traza_archivo_controles el id archivo y su control asociado,
 * con estado cero
 *
 * @author aguilangeles@gmail.com
 */
public class InsertTrazaArchivoContol {

  private static final String className = InsertTrazaArchivoContol.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private int idtraza;

  public InsertTrazaArchivoContol(int idtr, List<Integer> idControl, Conexion conexion) {
    this.idtraza = idtr + 1;
    insert(idControl, conexion);
  }

  private void insert(List<Integer> idControl, Conexion conexion) {
    int id = idtraza;
    for (Integer idarchivo : idControl)
      {
      int lasid = new SelectLastID(conexion, "archivo").getUltimoID();
      String insertar = "Insert into qualitys.traza_archivo_controles "
              + "(idtraza"
              + ", idarchivo "
              + ", idcontrol "
              + ", estado) VALUES "
              + "(" + id
              + ", " + lasid
              + ", " + idarchivo
              + ", " + 0
              + ");";
      try
        {
        conexion.executeUpdate(insertar);
        } catch (SQLException ex)
        {
        msg.getMessage(ex.getMessage(), className);
        }
      }
  }
}
