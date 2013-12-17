/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Helpers.GetImagenesAdyacentes;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
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
  private int idSublote, docum;
  private String rutaSublote;
  int totalSublote;

  public Imagen(int id, String ruta_archivo, String parent, int pagina) {
    this.id = id;
    this.parent = parent;
    this.pagina = pagina;
    this.rutaInsertadaEnDB = decodear(ruta_archivo);
    this.rutaParaConversion = decodear(parent + ruta_archivo);
  }

  public Imagen(int id, String ruta_archivo, int pagina, int idsublote, String parent, String rutasub, int cant_img, int docum) {
    this.id = id;
    this.pagina = pagina;
    this.rutaInsertadaEnDB = ruta_archivo.substring(parent.length());
    this.rutaParaConversion = (ruta_archivo);
    this.idSublote = idsublote;
    this.rutaSublote = rutasub.substring(parent.length());
    this.totalSublote = cant_img;
    this.docum = docum;
  }

  public int getDocum() {
    return docum;
  }

  public void setDocum(int docum) {
    this.docum = docum;
  }

  public String getRutaSublote() {
    return rutaSublote;
  }

  public int getTotalSublote() {
    return totalSublote;
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

  public String encoder(String aString) {
    String ret = "";
    try
      {
      ret = URLEncoder.encode(aString, "UTF-8");
      } catch (UnsupportedEncodingException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Llenar Traza : encoding", JOptionPane.ERROR_MESSAGE);
      }
    return ret;
  }

  public GetImagenesAdyacentes adyacentes() {
//    String ad = decodear(getRutaParaConversion());
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
    return "Imagen{" + "id=" + id + ", pagina=" + pagina + ", rutaInsertadaEnDb " + rutaInsertadaEnDB + ", rutaParaConversion=" + rutaParaConversion + ", idSublote=" + idSublote + '}';
  }
}
