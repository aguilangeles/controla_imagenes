/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

import Daos.TiposDeControl;
import Daos.Imagen;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class TrazaDao {

  private int id;
  private List<TiposDeControl> listaTipos;
  private List<Imagen> listaTif;
  private int estado;
  private String extension;

  public TrazaDao(int id, List<Imagen> listaTif, String extension, List<TiposDeControl> listaTipos) {
    this.id = id;
    this.listaTif = listaTif;
    this.extension = extension;
    this.listaTipos = listaTipos;
  }

  public String getExtension() {
    return extension;
  }

  public void setExtension(String extension) {
    this.extension = extension;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public List<Imagen> getListaTif() {
    return listaTif;
  }

  public void setListaTif(List<Imagen> listaTif) {
    this.listaTif = listaTif;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public List<TiposDeControl> getListaTipos() {
    return listaTipos;
  }

  public Imagen getTifByName(String nombre) {
    Imagen tif = null;
    for (Imagen temp : this.listaTif) {
      if (temp.getRutaInsertadaEnDB().equalsIgnoreCase(nombre)) {
        tif = temp;
      }
    }
    return tif;
  }

  public Imagen getTifByNameAndPage(String nombre, int page) {
    Imagen tif = null;
    for (Imagen temp : this.listaTif) {
      if (temp.getRutaInsertadaEnDB().equalsIgnoreCase(nombre) && temp.getPagina() == page) {
        tif = temp;
      }
    }
    return tif;
  }

  public String toString() {
    return "TrazaDao{" + "id=" + id + ", listaTipos=" + listaTipos + ", "
            + "listaTif=" + listaTif + ", estado=" + estado + '}';
  }
}