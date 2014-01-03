/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.Conexion;
import Helpers.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Insertar_archivo_sublote {

  public Insertar_archivo_sublote(Conexion conexion, int idtraza, int idarchivo, int idsublote) {
    int idTraza = (idtraza == 0) ? 1 : idtraza;
    insertar(conexion, idTraza, idarchivo, idsublote);
  }

  private void insertar(Conexion conexion, int idtraza, int idarchivo, int idsublote) {
    try
      {
      String insert = "INSERT INTO qualitys.archivo_sublote"
              + " ( idcategoria"
              + ", idtraza"
              + ", idarchivo"
              + ", idsublote)"
              + "VALUES"
              + "("
              + " 2 "
              + ", " + idtraza
              + ", " + idarchivo
              + ", " + idsublote
              + ");";
      conexion.executeUpdate(insert);
      } catch (SQLException ex)
      {
      MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(ex.getMessage(), Insertar_archivo_sublote.class.getName());
      }
  }
}
