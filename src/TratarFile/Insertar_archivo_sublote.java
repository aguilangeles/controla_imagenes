/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.Conexion;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Insertar_archivo_sublote {

  public Insertar_archivo_sublote(Conexion conexion, int idtraza, int idarchivo, int idsublote) {
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
      //System.out.println(insert);
      conexion.executeUpdate(insert);
      } catch (SQLException ex)
      {
      System.out.println(Insertar_archivo_sublote.class.getName());
      System.out.println(ex.getMessage());
      }
  }
}
