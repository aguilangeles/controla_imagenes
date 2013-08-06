/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class Imagen {
  private int id;
  private String rutaParaConversion;
  private String parent;
  private int pagina;
  private String rutaTemp;
  private String rutaInsertadaEnDB;
  private int estado;

  public Imagen(int id, String ruta_archivo, String parent, int pagina) {
    this.id = id;
    this.parent = parent;
    this.pagina = pagina;
    this.rutaInsertadaEnDB = decodear(ruta_archivo);
    this.rutaParaConversion = decodear(parent + ruta_archivo);
  }

  public Imagen(int id, String ruta_archivo, String parent) {
    this.id = id;
    this.parent = parent;
    this.rutaInsertadaEnDB = decodear(ruta_archivo);
    this.rutaParaConversion = decodear(parent + ruta_archivo);

  }

  private static String decodear(String aString) {
    String ret = "";
    try {
      ret = URLDecoder.decode(aString, "UTF-8");
    } catch (UnsupportedEncodingException ex) {
      JOptionPane.showMessageDialog(null, ex.getMessage(), "Problemas en Encoding", JOptionPane.ERROR_MESSAGE);
    }
    return ret;
  }
  public String getRutaDb() {
    return rutaInsertadaEnDB;
  }

  public void setRutaDb(String rutaDb) {
    this.rutaInsertadaEnDB = rutaDb;
  }

  public String getRutaTemp() {
    return rutaTemp;
  }

  public void setRutaTemp(String rutaTemp) {
    this.rutaTemp = rutaTemp;
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

  public String getRuta_archivo() {
    return rutaParaConversion;
  }

  public int getId() {
    return id;
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
}
