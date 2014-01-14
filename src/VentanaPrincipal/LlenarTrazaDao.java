/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import BasedeDatos.ControlesporVerificacionList;
import BasedeDatos.ArchivosPorTrazaList;
import BasedeDatos.SubLotePorTrazaList;
import BasedeDatos.Conexion;
import Entidades.TiposDeControl;
import Entidades.TrazaDao;
import Helpers.Encoder;
import Helpers.GetExtensionIdImagen;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public final class LlenarTrazaDao {

  private TrazaDao traza;
  private int idImg = GetExtensionIdImagen.getIdImagen();

  public LlenarTrazaDao(int trazaID, String parent, Conexion con) {
    String parent1 = Encoder.encoder(parent + "\\", LlenarTrazaDao.class.getName());
    llenarTrazaVolumen(con, trazaID, parent1);
  }

  public LlenarTrazaDao(int trazaID, String parent, Conexion con, boolean issublote) {
    String parent1 = Encoder.encoder(parent + "\\", LlenarTrazaDao.class.getName());
    llenartrazaDocumento(parent1, con, trazaID);
  }

  private TrazaDao llenarTrazaVolumen(Conexion conexion, int idTraza, String parent) {
    List<Object> imagenesList = new ArchivosPorTrazaList(conexion, idTraza, parent, true).getImagenesList();
    List<TiposDeControl> tiposList = new ControlesporVerificacionList(conexion, idTraza).getTiposDeControlList();
    traza = new TrazaDao(idTraza, idImg, tiposList, imagenesList);
    return traza;
  }

  private TrazaDao llenartrazaDocumento(String parent, Conexion conexion, int idTraza) {
    List<Object> imagenesList = new SubLotePorTrazaList(conexion, idTraza, parent).getImagenesList();
    List<TiposDeControl> tiposList = new ControlesporVerificacionList(conexion, idTraza).getTiposDeControlList();
    traza = new TrazaDao(idTraza, idImg, tiposList, imagenesList, true);
    return traza;
  }

  public TrazaDao getTraza() {
    return traza;
  }
}
