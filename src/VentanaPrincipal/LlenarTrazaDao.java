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
import Helpers.Encoder;
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
  private int idImg = GetExtensionIdImagen.getIdImagen();

  public LlenarTrazaDao(int trazaID, String parent, Conexion con) {
    String parent1 = Encoder.encoder(parent + "\\", LlenarTrazaDao.class.getName());
//    String parent1 = encoder(parent + "\\");  //  }

    llenartraza(con, trazaID, parent1);
  }

  public LlenarTrazaDao(int trazaID, String parent, Conexion con, boolean issublote) {
    //eliminar el switch
    this.idTraza = trazaID;
    String parent1 = Encoder.encoder(parent + "\\", LlenarTrazaDao.class.getName());
    this.conexion = con;
    int idImagen = GetExtensionIdImagen.getIdImagen();
    switch (idImagen)
      {
      case 1:
        llenartrazaDocumento(parent1);
        break;
      case 2:
      case 3:
        llenartrazaDocumento(parent1);
        break;
      }
  }


  private TrazaDao llenartraza(Conexion conexion, int idTraza, String parent) {
    List<Imagen> imagenesList = new ArchivosPorTrazaList(conexion, idTraza, parent, true).getImagenesList();
    List<TiposDeControl> tiposList = new ControlesporVerificacionList(conexion, idTraza).getTiposDeControlList();
    traza = new TrazaDao(idTraza, idImg, tiposList, imagenesList);
    return traza;
  }

  private TrazaDao llenartrazaDocumento(String parent) {
    List<Imagen> imagenesList = new ArchivosPorTrazaList(conexion, idTraza, parent).getImagenesList();
    List<TiposDeControl> tiposList = new ControlesporVerificacionList(conexion, idTraza).getTiposDeControlList();
    traza = new TrazaDao(idTraza, idImg, tiposList, imagenesList);
    return traza;
  }

  public TrazaDao getTraza() {
    return traza;
  }
}
