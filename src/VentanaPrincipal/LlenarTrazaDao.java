/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import BasedeDatos.ControlesporVerificacionList;
import BasedeDatos.ArchivosPorTrazaList;
import BasedeDatos.Conexion;
import Entidades.Imagen;
import Entidades.TrazaDao;
import Helpers.GetExtensionIdImagen;
import PaneldeControl.ContadorSublotes;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public final class LlenarTrazaDao {

  private int id;
  private Conexion conexion;
  private TrazaDao traza;
  private String parent;
  private String extension;
  private boolean pdfFile;

  public LlenarTrazaDao(int trazaID, String parent, Conexion con, String extension) {
    this.id = trazaID;
    this.parent = encoder(parent + "\\");
    this.conexion = con;
    this.extension = extension;
    switch (extension)
      {
      case ".tif":
      case ".tiff":
      case ".TIF":
      case ".TIFF":
      case ".png":
      case ".jpg":
        this.pdfFile = false;
        llenartraza();
        break;
      case ".pdf":
        this.pdfFile = true;
        llenartraza();
        break;
      }
  }

  public LlenarTrazaDao(int trazaID, String parent, Conexion con, String extension, boolean issublote) {

    this.id = trazaID;
    this.parent = (parent + "\\");
    this.conexion = con;
    this.extension = "." + extension;
    int idImagen = GetExtensionIdImagen.getIdImagen();
    switch (idImagen)
      {
      case 1:
        this.pdfFile = false;
        System.out.println("case 1");
        llenartrazaDocumento();
        break;
      case 2:
      case 3:
        System.out.println("case 2-3");
        this.pdfFile = true;
        llenartrazaDocumento();
        break;
      }
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

  private TrazaDao llenartraza() {
    traza = new TrazaDao(id, new ArchivosPorTrazaList(conexion, id, parent, isPdfFile()).getImagenesList(),
            extension, new ControlesporVerificacionList(conexion, id).getlTiposDeControlList());
    return traza;
  }

  private TrazaDao llenartrazaDocumento() {
    List<Imagen> imagenesList = new ArchivosPorTrazaList(conexion, id, parent).getImagenesList();
//    System.out.println("lista de imagenes ");
    for (Imagen im : imagenesList)
      {
      System.out.println(im.getRutaParaConversion() );
      }
    traza = new TrazaDao(id, imagenesList,
            extension, new ControlesporVerificacionList(conexion, id).getlTiposDeControlList());
    return traza;
  }

  public TrazaDao getTraza() {
    return traza;
  }

  public boolean isPdfFile() {
    return pdfFile;
  }

  public void setPdfFile(boolean pdfFile) {
    this.pdfFile = pdfFile;
  }

  @Override
  public String toString() {
    return "LlenarTrazaDao{" + "id=" + id + ", traza=" + traza + '}';
  }
}
