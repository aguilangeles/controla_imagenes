/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Inserta en la traza_archivo_controles el id archivo y su control asociado,
 * con estado cero
 *
 * @author aguilangeles@gmail.com
 */
public class InsertTrazaArchivoContolYEstado {

  private int idtraza;

  public InsertTrazaArchivoContolYEstado(int idtr, List<Integer> idControl, Conexion conexion) {
    this.idtraza = idtr + 1;
    insert(idControl, conexion);
  }

  public InsertTrazaArchivoContolYEstado(int idtrz, List<Integer> idControl, Conexion conexion, boolean isdoc) {
    this.idtraza = idtrz;
    insert(idControl, conexion);
  }

  private void insert(List<Integer> idControl, Conexion conexion) {
    int id = idtraza;
    for (Integer idarchivo : idControl)
      {
      int lasid = new GetUltimoIDInsertado(conexion, "archivo").getUltimoID();
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
        System.out.println(insertar);
        conexion.executeUpdate(insertar);
        } catch (SQLException ex)
        {
        JOptionPane.showMessageDialog(null, ex.getMessage(),
                "Imagen y control", JOptionPane.ERROR_MESSAGE);
        }
      }
  }
}
