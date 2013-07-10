/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Entidades.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class InsertarEnArchivos {

  private int id = 1;

  public InsertarEnArchivos(Conexion conexion, int id, String ruta, int page) {
    this.id += id;
    int estado = 0;
    String ret = "Insert into qualitys.archivo (idTraza, ruta_archivo, pagina_pdf, estado)"
            + " VALUES (" + this.id + ", '" + ruta + "' ," + page + " ," + estado + ");";
    conexion.executeUpdate(ret);
  }
}
