/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Entidades.Imagen;
import Helpers.MensajeJoptionPane;
import Login.SetFechaDeIngreso;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Genera una lista de los archivos insertados en la base de datos seg�n el
 * idtraza.
 *
 * @author MUTNPROD003
 */
public class ArchivosPorTrazaList {

  private String className = ArchivosPorTrazaList.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  private static int documentos;
  private List<Imagen> imagenProcesadaList = new ArrayList<>();
  MensajeJoptionPane mensaje = new MensajeJoptionPane(null, type);

  public ArchivosPorTrazaList(Conexion conexion, int idTraza, String parent, boolean isVolume) {
    //constructor para volumenes
    getImagenNombrePagina(conexion, idTraza, parent);
  }

  public ArchivosPorTrazaList(Conexion conexion, int idTraza, String parent) {
    //constructor para Documentos
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
        archivoConNumeroDePagina(id, rutaImagen, parent, pagina, true, idSublote, rutasub, cant_img);
        }
      } catch (SQLException ex)
      {
      mensaje.getMessage(ex.getMessage(), className);
      }
  }

  private void getImagenNombrePagina(Conexion conexion, int idTraza, String parent) {
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
      mensaje.getMessage(ex.getMessage(), className);
      }
  }

  private void archivoConNumeroDePagina(int id, String rutaImagen, String parent, int pagina, boolean isDocumento, int idSublote, String rutaSublote, int cant_img) {
    Imagen imagen;
    if (!isDocumento)
      {
      imagen = new Imagen(id, rutaImagen, parent, pagina);
      imagenProcesadaList.add(imagen);
      } else
      {
      imagen = new Imagen(id, rutaSublote, pagina, idSublote, parent, rutaImagen, cant_img);
      imagenProcesadaList.add(imagen);
      }
  }

  public static int getDocumentos() {
    return documentos;
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
      mensaje.getMessage(ex.getMessage(), className);
      }
    return ret;
  }
}
