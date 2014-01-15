/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import helper.MensajeJoptionPane;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 * completa la tabla qualitys.archivo_sublote
 *
 * @author aguilangeles@gmail.com
 */
public class InsertarArchivoSublote {

  public InsertarArchivoSublote(Conexion conexion, int idtraza, int idarchivo, int idsublote) {
    insertar(conexion, idtraza, idarchivo, idsublote);
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
      msg.getMessage(ex.getMessage(), InsertarArchivoSublote.class.getName());
      }
  }
}
