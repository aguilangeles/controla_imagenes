/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import Entidades.ImagenInsertada;
import Entidades.Sublote;
import BasedeDatos.Conexion;
import Helpers.MensajeJoptionPane;
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
  // private int idTraza;

  public InsertarEnSublotes(Conexion conexion, List<Sublote> sublotes, int idtraza) {
    int idTraza = idtraza + 1;
    llenarSublote(conexion, sublotes, idTraza);
  }

  private void llenarSublote(Conexion conexion, List<Sublote> sl, int idtraza) {
    for (Sublote sub : sl)
      {
      insertarSublote(conexion, sub, idtraza);
      }
  }

  private boolean insertarSublote(Conexion conexion, Sublote sl, int idtraza) {
    //idtraza = sl.getIdtraza();
    ;
    int estado = 0;
    //un elemento que llame a este
    // agregar que inserte idsublote cero
    String insertar = "INSERT INTO qualitys.sublotes "
            + "( idtraza "
            + ", ruta "
            + ", total_img "
            + ", estado ) "
            + "VALUES "
            + "( " + idtraza
            + ", '" + sl.getNombre()
            + "', " + sl.getTamanio()
            + ", " + estado
            + ");";
    try
      {
      conexion.executeUpdate(insertar);
      } catch (SQLException ex)
      {
      MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(ex.getMessage(), InsertarEnSublotes.class.getName());
      }
    return false;
  }
}
