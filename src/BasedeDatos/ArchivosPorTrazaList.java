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

  private static int documentos;
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

      documentos = consultarTamanioDocumento(conexion, idTraza);
      String query = "SELECT"
              + " a.id"
              + ", subl.ruta "
              + ", a.ruta_archivo "
            //  + " , concat_ws('',subl.ruta,'\\\\',a.ruta_archivo) "
              + " , a.pagina_pdf"
              + " , asub.idsublote"
              + ", subl.total_img "
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
        String rutasub = conexion.resulset.getString(2);
        String rutaImagen = conexion.resulset.getString(3);
        int pagina = conexion.resulset.getInt(4);
        int idSublote = conexion.resulset.getInt(5);
        int cant_img = conexion.resulset.getInt(6);
        /*int id, String ruta_archivo, String parent, int pagina, boolean isDocumento, int idSublote, String rutaSub, int cant_img*/
          System.out.println("<<<<"+ rutasub+", "+ rutaImagen);
        archivoConNumeroDePagina(id, rutaImagen, parent, pagina, true, idSublote, rutasub, cant_img);
        }
      } catch (SQLException ex)
      {
      Logger.getLogger(ArchivosPorTrazaList.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public static int getDocumentos() {
    return documentos;
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
        archivoConNumeroDePagina(id, ruta_archivo, parent, pagina, false, 0, null, 0);
        }
      } catch (SQLException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Error en la consulta de ruta archivo", JOptionPane.ERROR_MESSAGE);
      }
    gar.gc();
  }

  private void archivoConNumeroDePagina(int id, String ruta_archivo, String parent, int pagina, boolean isDocumento, int idSublote, String rutaSub, int cant_img) {
    Imagen imagen;
    if (!isDocumento)
      {
      imagen = new Imagen(id, ruta_archivo, parent, pagina);
      imagenProcesadaList.add(imagen);
      } else
      {
      imagen = new Imagen(id, rutaSub, pagina, idSublote, parent, ruta_archivo, cant_img, 0);
      imagenProcesadaList.add(imagen);
      }
  }

  public List<Imagen> getImagenesList() {
    return imagenProcesadaList;
  }

  private int consultarTamanioDocumento(Conexion conexion, int idTraza) {
    int ret = 0;
    try
      {
      String query = "SELECT count(*) FROM qualitys.sublotes where idtraza =" + idTraza + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        ret = conexion.resulset.getInt(1);
        }
      } catch (SQLException ex)
      {
      Logger.getLogger(ArchivosPorTrazaList.class.getName()).log(Level.SEVERE, null, ex);
      }
    return ret;
  }
}
