/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BasedeDatos;

import entidad.Imagen;
import Helpers.MensajeJoptionPane;
import entidad.Sublote;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Genera una lista de los archivos insertados en la base de datos según el
 * idtraza.
 *
 * @author MUTNPROD003
 */
public class SubLotePorTrazaList {

  private String className = SubLotePorTrazaList.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  private static int documentos;
  private List<Object> imagenProcesadaList = new ArrayList<>();
  private List<Sublote> subloteList;
  MensajeJoptionPane mensaje = new MensajeJoptionPane(null, type);
  private Conexion conexion;
  private int idTraza;
  private String parent;

  public SubLotePorTrazaList(Conexion conexion, int idTraza, String parent) {
    this.conexion = conexion;
    this.idTraza = idTraza;
    this.parent = parent;
    this.subloteList = getSubloteList();
    iterarSubloteLlenarImagen();
  }

  private List<Sublote> getSubloteList() {
    List<Sublote> subList = new ArrayList<>();
    Imagen imagen;
    Sublote sublote;
    try
      {
      documentos = GetTamanioDocumento.consultarTamanioDocumento(conexion, idTraza);
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
        subList.add(sublote);
        }
      } catch (SQLException ex)
      {
      mensaje.getMessage(ex.getMessage(), className);
      }
    return subList;
  }

  private void iterarSubloteLlenarImagen() {
    Sublote sublote;
    for (Sublote ss : subloteList)
      {
      List<Object> imgList = llenarListadeImagenes(ss);
      sublote = new Sublote(ss.getId(), ss.getIdtraza(), ss.getNombre(), 0, ss.getTamanio(), imgList);
      imagenProcesadaList.add(sublote);
      }
  }

  private List<Object> llenarListadeImagenes(Sublote sublote) {
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
              + " where a.idtraza  =" + idTraza
              + " and subl.id =" + sublote.getId() + ";";
      conexion.executeQuery(query);
      while (conexion.resulset.next())
        {
        int idImagen = conexion.resulset.getInt(1);
        String ruta = conexion.resulset.getString(2);
        int pagina = conexion.resulset.getInt(3);
        imagen = new Imagen(idImagen, ruta, pagina, parent, sublote);
        listaImagen.add(imagen);
        }
      } catch (SQLException ex)
      {
      mensaje.getMessage(ex.getMessage(), className);
      }
    return listaImagen;
  }

  public List<Object> getImagenesList() {
    return imagenProcesadaList;
  }
}
