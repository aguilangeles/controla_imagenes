/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Entidades.Imagen;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Genera una lista de los archivos insertados en la base de datos según el
 * idtraza.
 *
 * @author MUTNPROD003
 */
public class ArchivosPorTrazaList {

  private List<Imagen> imagenProcesadaList = new ArrayList<>();

  public ArchivosPorTrazaList(Conexion conexion, int idTraza, String parent, boolean isPdf) {
    getImagen_y_pagina_desde_Archivo(conexion, idTraza, parent);
  }

  public ArchivosPorTrazaList(Conexion conexion, int idTraza, String parent) {
    getImagenPaginaSublote(conexion, idTraza, parent);
  }

  private void getImagenPaginaSublote(Conexion conexion, int idTraza, String parent) {
    try
      {
      Imagen imagen;
      String query = "SELECT"
              + " a.id"
              + " , concat_ws('',subl.ruta,'\\\\',a.ruta_archivo) "
              + " , a.pagina_pdf"
              + " , asub.idsublote"
              + " FROM qualitys.archivo a"
              + " join archivo_sublote asub"
              + " on a.id= asub.idarchivo"
              + " join sublotes subl"
              + " on subl.id=asub.idsublote"
              + " where a.idtraza  =" + idTraza + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        int id = conexion.resulset.getInt(1);
        String ruta = conexion.resulset.getString(2);
        int pagina = conexion.resulset.getInt(3);
        int idSublote = conexion.resulset.getInt(4);
        archivoConNumeroDePagina(id, ruta, parent, pagina, true, idSublote);
        }
      } catch (SQLException ex)
      {
      Logger.getLogger(ArchivosPorTrazaList.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  private void getImagen_y_pagina_desde_Archivo(Conexion conexion, int idTraza, String parent) {
    Runtime gar = Runtime.getRuntime();
    Imagen imagen;
    try
      {
      String query = "SELECT id "
              + ", ruta_archivo "
              + ", pagina_pdf "
              + "FROM qualitys.archivo "
              + "where idtraza = " + idTraza + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        int id = conexion.resulset.getInt(1);
        String ruta_archivo = conexion.resulset.getString(2);
        int pagina = conexion.resulset.getInt(3);
        archivoConNumeroDePagina(id, ruta_archivo, parent, pagina, false, 0);
        }
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Error en la consulta de ruta archivo", JOptionPane.ERROR_MESSAGE);
      }
    gar.gc();
  }

  private void archivoConNumeroDePagina(int id, String ruta_archivo, String parent, int pagina, boolean isDocumento, int idSublote) {
    Imagen imagen;
    if (!isDocumento)
      {
      imagen = new Imagen(id, ruta_archivo, parent, pagina);
      imagenProcesadaList.add(imagen);
      } else
      {
      imagen = new Imagen(id, ruta_archivo, pagina, idSublote, parent);
      imagenProcesadaList.add(imagen);
      }
  }

  public List<Imagen> getImagenesList() {
    return imagenProcesadaList;
  }
}
