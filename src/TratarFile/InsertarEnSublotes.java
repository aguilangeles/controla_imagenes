/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.Conexion;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
class InsertarEnSublotes {

  public InsertarEnSublotes(Conexion conexion, Sublote sublote) {
    insertar(conexion , sublote);
  }

  private boolean insertar(Conexion conexion, Sublote sl) {
    int estado = 0;
    //un elemento que llame a este
    // agregar que inserte idsublote cero
    String insertar = "INSERT INTO qualitys.sublotes "
            + "( idtraza "
            + ", ruta "
            + ", total_img ) "
            + "VALUES "
            + "( "+sl.getIdtraza()
            + ", '"+sl.getNombre()
            + "', "+sl.getTamanio()
            + ");";
    try
      {
      conexion.executeUpdate(insertar);
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Archivo Insertar", JOptionPane.ERROR_MESSAGE);
      }
    return false;
  }
}

