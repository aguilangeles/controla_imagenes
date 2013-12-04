/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import BasedeDatos.ControlesporVerificacionList;
import BasedeDatos.ArchivosPorTrazaList;
import BasedeDatos.Conexion;
import Entidades.TrazaDao;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class LlenarTrazaDao {

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
    switch (extension) {
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

  public String encoder(String aString) {
    String ret = "";
    try {
      ret = URLEncoder.encode(aString, "UTF-8");
    } catch (UnsupportedEncodingException ex) {
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
