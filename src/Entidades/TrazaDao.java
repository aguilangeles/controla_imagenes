/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Iterator;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class TrazaDao {

  private int id;
  private List<TiposDeControl> tiposList;
  private List<Imagen> imagenList;
  private int estado;
  private int idImagen;

  public TrazaDao(int id, List<Imagen> imagenList, List<TiposDeControl> tiposList, int idImagen) {
    this.id = id;
    this.imagenList = imagenList;
    this.tiposList = tiposList;
    this.idImagen=idImagen;

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

  public List<Imagen> getImagenList() {
    return imagenList;
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
    for (Iterator<Imagen> it = imagenList.iterator(); it.hasNext();)
      {
      Imagen temp = it.next();
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
