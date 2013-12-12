/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.Conexion;
import BasedeDatos.GetUltimoIDInsertado;
import java.awt.HeadlessException;
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

  private void insertarimagenes(Sublote sub) {
    int estado = 0;
    for (ImagenInsertada img : listaimagens)
      {
      try
        {
        String insertar = "Insert into qualitys.archivo "
                + "(idTraza"
                + ", ruta_archivo "
                + ", estado"
                + ", pagina_pdf "
                + ", idsublote "
                + ")"
                + " VALUES ("
                + sub.getIdtraza()
                + ", '" + img.getNombre()
                + "', " + estado
                + ", " + img.getPagina()
                + ", " + img.getIdsubolote()
                + ");";

        System.out.println(insertar);
        conexion.executeUpdate(insertar);
        } catch (SQLException ex)
        {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Archivo Insertar", JOptionPane.ERROR_MESSAGE);
        }
      }
  }
}
