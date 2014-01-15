/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import entidad.ImagenInsertada;
import entidad.Sublote;
import BasedeDatos.Conexion;
import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Completa la tabla qualitys.sublotes.
 * @author aguilangeles@gmail.com
 */
public class InsertarEnSublotes {

  private Conexion conexion;
  private List<ImagenInsertada> listaImagens;

  public InsertarEnSublotes(Conexion conexion, List<Sublote> sublotes, int idtraza) {
    int idTraza = idtraza + 1;
    insertar(conexion, sublotes, idTraza);
  }

  private void insertar(Conexion conexion, List<Sublote> sl, int idtraza) {
    for (Sublote sub : sl)
      {
      insertarSublote(conexion, sub, idtraza);
      }
  }

  private boolean insertarSublote(Conexion conexion, Sublote sl, int idtraza) {
    int estado = 0;
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
