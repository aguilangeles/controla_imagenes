/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import Entidades.Imagen;
//import Entidades.Sublote;
import Helpers.MensajeJoptionPane;
import TratarFile.Sublote;

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

  private String className = ArchivosPorTrazaList.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  private static int documentos;
  private List<Object> imagenProcesadaList = new ArrayList<>();
  private List<Sublote> subloteList = new ArrayList<>();
  MensajeJoptionPane mensaje = new MensajeJoptionPane(null, type);

  public ArchivosPorTrazaList(Conexion conexion, int idTraza, String parent, boolean isVolume) {
    //constructor para volumenes
    getImagenNombrePagina(conexion, idTraza, parent);
  }

  public ArchivosPorTrazaList(Conexion conexion, int idTraza, String parent) {
    getImagenPaginaSublote(conexion, idTraza, parent);
    iterarSublote(conexion, idTraza, parent);
  }

  private void getImagenPaginaSublote(Conexion conexion, int idTraza, String parent) {
    try
      {
      Imagen imagen;
      Sublote sublote;
      documentos = consultarTamanioDocumento(conexion, idTraza);
      String query = "SELECt id "
              + ",ruta "
              + ",total_img "
              + "FROM  qualitys.sublotes  "
              + "where idtraza=" + idTraza + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        int id = conexion.resulset.getInt(1);
        String rutasub = conexion.resulset.getString(2);
        int cant_img = conexion.resulset.getInt(3);
        sublote = new Sublote(id, idTraza, rutasub, 0, cant_img, null);
        subloteList.add(sublote);
        }
      } catch (SQLException ex)
      {
      mensaje.getMessage(ex.getMessage(), className);
      }
  }

  private void iterarSublote(Conexion conexion, int idtraza, String parent) {
    Sublote sublote;
    for (Sublote ss : subloteList)
      {
      sublote = new Sublote(ss.getId(), ss.getIdtraza(), ss.getNombre(), 0, ss.getTamanio(), llenarListadeImagenes(conexion, parent, ss.getIdtraza(), ss.getId(), ss.getNombre(), ss.getId(), ss.getTamanio()));
      imagenProcesadaList.add(sublote);
      }
  }

  private List<Object> llenarListadeImagenes(Conexion conexion, String parent, int idtraza, int idsublote, String rutaSublote, int idSublote, int cantimagen) {
    List<Object> listaImagen = new ArrayList<>();
    try
      {
      Imagen imagen;

      String query = "SELECT "
              + "a.id "
              + ", a.ruta_archivo "
              + ", a.pagina_pdf "
              + " FROM qualitys.archivo a "
              + " join archivo_sublote asub "
              + " on a.id= asub.idarchivo "
              + " join sublotes subl "
              + " on subl.id=asub.idsublote "
              + " where a.idtraza  =" + idtraza
              + " and subl.id =" + idsublote + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        int id = conexion.resulset.getInt(1);
        String ruta = conexion.resulset.getString(2);
        int pagina = conexion.resulset.getInt(3);
        imagen = new Imagen(id, rutaSublote, pagina, idSublote, parent, ruta, cantimagen);
//        imagen = new Imagen(id, ruta, parent, pagina);
        listaImagen.add(imagen);
        }
      } catch (SQLException ex)
      {
      Logger.getLogger(ArchivosPorTrazaList.class.getName()).log(Level.SEVERE, null, ex);
      }
    return listaImagen;
  }
//  private void getImagenPaginaSublote(Conexion conexion, int idTraza, String parent) {
//    try
//      {
//      Imagen imagen;
//      documentos = consultarTamanioDocumento(conexion, idTraza);
//      String query = "SELECT"
//              + " a.id"
//              + ", subl.ruta "
//              + ", a.ruta_archivo "
//              + " , a.pagina_pdf"
//              + " , asub.idsublote"
//              + ", subl.total_img "
//              + " FROM qualitys.archivo a"
//              + " join archivo_sublote asub"
//              + " on a.id= asub.idarchivo"
//              + " join sublotes subl"
//              + " on subl.id=asub.idsublote"
//              + " where a.idtraza  =" + idTraza + ";";
//      conexion.executeQuery(query);
//      while (conexion.resulset.next())
//        {
//        int id = conexion.resulset.getInt(1);
//        String rutasub = conexion.resulset.getString(2);
//        String rutaImagen = conexion.resulset.getString(3);
//        int pagina = conexion.resulset.getInt(4);
//        int idSublote = conexion.resulset.getInt(5);
//        int cant_img = conexion.resulset.getInt(6);
//        archivoConNumeroDePagina(id, rutaImagen, parent, pagina, true, idSublote, rutasub, cant_img);
//        }
//      } catch (SQLException ex)
//      {
//      mensaje.getMessage(ex.getMessage(), className);
//      }
//  }

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

  public List<Sublote> getSubloteList() {
    return subloteList;
  }

  public void setSubloteList(List<Sublote> subloteList) {
    this.subloteList = subloteList;
  }

  public static int getDocumentos() {
    return documentos;
  }

  public List<Object> getImagenesList() {
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
