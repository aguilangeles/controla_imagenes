/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Helpers.GetImagenesAdyacentes;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.swing.JOptionPane;

/**
 * @author MUTNPROD003
 *
 */
public class Imagen {

  private int id;
  private int pagina;
  private String parent;
  private String rutaParaConversion;
  private String rutaCarpetaTemp;
  private String rutaInsertadaEnDB;
  private int estado;
  private int idcategoria;
  private int idSublote;

  public Imagen(int id, String ruta_archivo, String parent, int pagina) {
    this.id = id;
    this.parent = parent;
    this.pagina = pagina;
    this.rutaInsertadaEnDB = decodear(ruta_archivo);
    this.rutaParaConversion = decodear(parent + ruta_archivo);
  }

  public Imagen(int id, String ruta_archivo, int pagina, int idsublote) {
    this.id = id;
    this.pagina = pagina;
    this.rutaParaConversion = decodear(ruta_archivo);
    this.idSublote = idsublote;
  }

  private static String decodear(String aString) {
    String ret = "";
    try
      {
      ret = URLDecoder.decode(aString, "UTF-8");
      } catch (UnsupportedEncodingException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Problemas en Encoding", JOptionPane.ERROR_MESSAGE);
      }
    return ret;
  }

  public GetImagenesAdyacentes adyacentes() {
    GetImagenesAdyacentes imagenesAdyacentes = new GetImagenesAdyacentes(getRutaParaConversion());
    return imagenesAdyacentes;
  }

  public void traerImagenAdyacente(boolean tiff) {
  }

  public String getRutaInsertadaEnDB() {
    return rutaInsertadaEnDB;
  }

  public void setRutaInsertadaEnDB(String rutaDb) {
    this.rutaInsertadaEnDB = rutaDb;
  }

  public String getRutaCarpetaTemp() {
    return rutaCarpetaTemp;
  }

  public void setRutaCarpetaTemp(String rutaTemp) {
    this.rutaCarpetaTemp = rutaTemp;
  }

  public int getPagina() {
    return pagina;
  }

  public void setPagina(int pagina) {
    this.pagina = pagina;
  }

  public String getParent() {
    return parent;
  }

  public void setParent(String parent) {
    this.parent = parent;
  }

  public String getRutaParaConversion() {
    return rutaParaConversion;
  }

  public int getId() {
    return id;
  }

  public int getIdSublote() {
    return idSublote;
  }

  public void setIdSublote(int idSublote) {
    this.idSublote = idSublote;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  //  @Override
  //  public String toString() {
  //    return "id=" + id
  //            + ", " + rutaInsertadaEnDB
  //            + ", pagina=" + pagina;
  //  }
  @Override
  public String toString() {
    return "Imagen{" + "id=" + id + ", pagina=" + pagina + ", rutaParaConversion=" + rutaParaConversion + ", idSublote=" + idSublote + '}';
  }


}
