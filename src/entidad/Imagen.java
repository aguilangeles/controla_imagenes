/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import helper.Decoder;
import helper.GetIdandExtensionImg;
import helper.GetImagenesAdyacentes;
import java.io.File;

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
  private int idSublote;
  private String rutaSublote;
  private int cantImagenes;

  public Imagen(int id, String ruta_archivo, String parent, int pagina) {
    this.id = id;
    this.parent = parent;
    this.pagina = pagina;
    this.rutaInsertadaEnDB = Decoder.decoder(ruta_archivo, Imagen.class.getName());
    this.rutaParaConversion = Decoder.decoder(parent + ruta_archivo, Imagen.class.getName());
  }

  public Imagen(int id, String rutaImagen, int pagina, String parent, Sublote sublote) {
    this.id = id;
    int idImagen = GetIdandExtensionImg.getIdImagen();
    this.pagina = pagina;
    this.rutaInsertadaEnDB = rutaImagen;
    this.parent = parent;
    this.rutaParaConversion = (idImagen == 2) ? (sublote.getNombre() + File.separator + rutaImagen) : sublote.getNombre();
    this.idSublote = sublote.getId();
    this.rutaSublote = sublote.getNombre();
    this.cantImagenes = sublote.getTamanio();
  }

  public GetImagenesAdyacentes adyacentes() {
//    String ad = decodear(getRutaParaConversion());
    GetImagenesAdyacentes imagenesAdyacentes = new GetImagenesAdyacentes(getRutaParaConversion());
    return imagenesAdyacentes;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  public void setRutaParaConversion(String rutaParaConversion) {
    this.rutaParaConversion = rutaParaConversion;
  }

  public String getRutaCarpetaTemp() {
    return rutaCarpetaTemp;
  }

  public void setRutaCarpetaTemp(String rutaCarpetaTemp) {
    this.rutaCarpetaTemp = rutaCarpetaTemp;
  }

  public String getRutaInsertadaEnDB() {
    return rutaInsertadaEnDB;
  }

  public void setRutaInsertadaEnDB(String rutaInsertadaEnDB) {
    this.rutaInsertadaEnDB = rutaInsertadaEnDB;
  }

  public int getIdSublote() {
    return idSublote;
  }

  public void setIdSublote(int idSublote) {
    this.idSublote = idSublote;
  }

  public String getRutaSublote() {
    return rutaSublote;
  }

  public void setRutaSublote(String rutaSublote) {
    this.rutaSublote = rutaSublote;
  }

  public int getCantImagenes() {
    return cantImagenes;
  }

  public void setCantImagenes(int cantImagenes) {
    this.cantImagenes = cantImagenes;
  }

  @Override
  public String toString() {
    return "Imagen{" + "id=" + id + ", pagina=" + pagina + ", parent=" + parent
            + ", rutaParaConversion=" + rutaParaConversion + ", rutaCarpetaTemp="
            + rutaCarpetaTemp + ", rutaInsertadaEnDB=" + rutaInsertadaEnDB
            + ", idSublote=" + idSublote + ", rutaSublote="
            + rutaSublote + ", cantImagenes=" + cantImagenes + '}';
  }
}
