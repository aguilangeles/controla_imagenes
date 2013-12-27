/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import BasedeDatos.ControlesporVerificacionList;
import BasedeDatos.ArchivosPorTrazaList;
import BasedeDatos.Conexion;
import Entidades.Imagen;
import Entidades.TiposDeControl;
import Entidades.TrazaDao;
import Helpers.GetExtensionIdImagen;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public final class LlenarTrazaDao {

  private int idTraza;
  private Conexion conexion;
  private TrazaDao traza;
  private String parent;
  private boolean pdfFile;
  private int idImg = GetExtensionIdImagen.getIdImagen();

  public LlenarTrazaDao(int trazaID, String parent, Conexion con) {
    this.parent = encoder(parent + "\\");
    llenartraza(con, trazaID, this.parent);
  }

  public LlenarTrazaDao(int trazaID, String parent, Conexion con, String extension, boolean issublote) {
    this.idTraza = trazaID;
    this.parent = (parent + "\\");
    this.conexion = con;
//    this.extension = "." + extension;
    int idImagen = GetExtensionIdImagen.getIdImagen();
    switch (idImagen)
      {
      case 1:
        llenartrazaDocumento();
        break;
      case 2:
      case 3:
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

  private TrazaDao llenartraza(Conexion conexion, int idTraza, String parent) {
    List<Imagen> imagenesList = new ArchivosPorTrazaList(conexion, idTraza, parent, true).getImagenesList();
    List<TiposDeControl> tiposList = new ControlesporVerificacionList(conexion, idTraza).getlTiposDeControlList();
    traza = new TrazaDao(idTraza, idImg, tiposList, imagenesList);
    return traza;
  }

  private TrazaDao llenartrazaDocumento() {
    List<Imagen> imagenesList = new ArchivosPorTrazaList(conexion, idTraza, parent).getImagenesList();
    List<TiposDeControl> tiposList = new ControlesporVerificacionList(conexion, idTraza).getlTiposDeControlList();
    traza = new TrazaDao(idTraza, idImg, tiposList, imagenesList);
    return traza;
  }

  public TrazaDao getTraza() {
    return traza;
  }
}
