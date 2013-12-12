/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.Conexion;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
class InsertarEnSublotes {

  private Conexion conexion;
  private List<ImagenInsertada> listaimagens;

  public InsertarEnSublotes(Conexion conexion, List<Sublote> sublotes) {
    System.out.println("entro en sublotes ");
    llenarSublote(conexion, sublotes);
  }

  private void llenarSublote(Conexion conexion, List<Sublote> sl) {
    for (Sublote sub : sl)
      {
      insertarSublote(conexion, sub);
      }
  }

  private boolean insertarSublote(Conexion conexion, Sublote sl) {
    int estado = 0;
    //un elemento que llame a este
    // agregar que inserte idsublote cero
    String insertar = "INSERT INTO qualitys.sublotes "
            + "( idtraza "
            + ", ruta "
            + ", total_img "
            + ", estado ) "
            + "VALUES "
            + "( " + sl.getIdtraza()
            + ", '" + sl.getNombre()
            + "', " + sl.getTamanio()
            + ", " + estado
            + ");";
    try
      {
      System.out.println("insertar sublote " + insertar);
      conexion.executeUpdate(insertar);
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              InsertarEnSublotes.class.getName(), JOptionPane.ERROR_MESSAGE);
      }
    return false;
  }
}
