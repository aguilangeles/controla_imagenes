/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Helpers.Decoder;
import Helpers.GetExtensionIdImagen;
import Helpers.GetImagenesAdyacentes;
import TratarFile.Sublote;

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
  private String rutaSublote;
  int cantImagenes;

  public Imagen(int id, String ruta_archivo, String parent, int pagina) {
    this.id = id;
    this.parent = parent;
    this.pagina = pagina;
    this.rutaInsertadaEnDB = Decoder.decoder(ruta_archivo, Imagen.class.getName());
    this.rutaParaConversion = Decoder.decoder(parent + ruta_archivo, Imagen.class.getName());
  }

  public Imagen(int id, String rutaImagen, int pagina, String parent, Sublote sublote) {
    this.id = id;
    int idImagen = GetExtensionIdImagen.getIdImagen();
    this.pagina = pagina;
    this.rutaInsertadaEnDB = rutaImagen;
    this.parent = parent;
    this.rutaParaConversion = (idImagen == 2) ? (sublote.getNombre() + "\\" + rutaImagen) : sublote.getNombre();
    this.idSublote = sublote.getId();
    this.rutaSublote = sublote.getNombre();
    this.cantImagenes = sublote.getTamanio();
  }

  public String getRutaSublote() {
    return rutaSublote;
  }

  public int getTotalSublote() {
    return cantImagenes;
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

  @Override
  public String toString() {
    return "Imagen{" + "id=" + id + ", pagina=" + pagina
            + ", rutaInsertadaEnDb " + rutaInsertadaEnDB + ", rutaParaConversion=" + rutaParaConversion + ", idSublote=" + idSublote + '}';
  }
}
