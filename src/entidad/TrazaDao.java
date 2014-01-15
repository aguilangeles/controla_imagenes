/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class TrazaDao {

  private int id;
  private List<TiposDeControl> tiposList;
  private List<Object> imagenList;
  private List<Object> ObjetoList;
  private int estado;
  private int idImagen;

  public TrazaDao(int id, int idImagen, List<TiposDeControl> tiposList, List<Object> imagenList) {
    this.id = id;
    this.imagenList = imagenList;
    this.tiposList = tiposList;
    this.idImagen = idImagen;

  }

  public TrazaDao(int id, int idImagen, List<TiposDeControl> tiposList, List<Object> objList, boolean isdocumento) {
    this.id = id;
    this.ObjetoList = objList;
    this.imagenList = new ArrayList<>();
    for (Object object : objList)
      {
      Sublote sub = (Sublote) object;
      List<Object> ob = sub.objectList();
      for (int i = 0; i < ob.size(); i++)
        {
        Object object1 = ob.get(i);
        imagenList.add(object1);
        }
      }
    this.tiposList = tiposList;
    this.idImagen = idImagen;
  }

  public int getIdImagen() {
    return idImagen;
  }

  public void setIdImagen(int idImagen) {
    this.idImagen = idImagen;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Object> getImagenList() {
    return imagenList;
  }

  public List<Object> getObjetoList() {
    return ObjetoList;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public List<TiposDeControl> getTiposList() {
    return tiposList;
  }

  public Imagen getImageByNameAndPage(String nombre, int page) {
    /*va a iterar en la lista hasta encontrar coincidencias*/
    Imagen tif = null;
    for (Iterator<Object> it = imagenList.iterator(); it.hasNext();)
      {
      Imagen temp = (Imagen) it.next();
      if (temp.getRutaInsertadaEnDB().equalsIgnoreCase(nombre) && temp.getPagina() == page)
        {
        tif = temp;
        }
      }
    return tif;
  }

  @Override
  public String toString() {
    return "TrazaDao{" + "id=" + id + ", listaTipos=" + tiposList + ", "
            + "listaTif=" + imagenList + ", estado=" + estado + '}';
  }
}
