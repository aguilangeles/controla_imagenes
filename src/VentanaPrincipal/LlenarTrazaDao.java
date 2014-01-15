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
import Helpers.GetIdandExtensionImg;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public final class LlenarTrazaDao {

  private Conexion conexion;
  private int idTraza;
  private String parent;
  //
  private TrazaDao traza;
  private int idImg = GetIdandExtensionImg.getIdImagen();

  public LlenarTrazaDao(Conexion con, int trazaID, String parent) {
    this.idTraza = trazaID;
    this.parent = Encoder.encoder(parent + "\\", LlenarTrazaDao.class.getName());
    this.conexion = con;
    llenarTrazaVolumen();
  }

  public LlenarTrazaDao(Conexion con, int trazaID, String parent, boolean issublote) {
    this.idTraza=trazaID;
    this.parent= Encoder.encoder(parent + "\\", LlenarTrazaDao.class.getName());;
    this.conexion=con;
    llenartrazaDocumento();
  }

  private TrazaDao llenarTrazaVolumen() {
    List<Object> imagenesList = new ArchivosPorTrazaList(conexion, idTraza, parent, true).getImagenesList();
    List<TiposDeControl> tiposList = new ControlesporVerificacionList(conexion, idTraza).getTiposDeControlList();
    this.traza = new TrazaDao(idTraza, idImg, tiposList, imagenesList);
    return traza;
  }
  private TrazaDao llenartrazaDocumento() {
    List<Object> imagenesList = new SubLotePorTrazaList(conexion, idTraza, parent).getImagenesList();
    List<TiposDeControl> tiposList = new ControlesporVerificacionList(conexion, idTraza).getTiposDeControlList();
    this.traza = new TrazaDao(idTraza, idImg, tiposList, imagenesList, true);
    return traza;
  }

  public TrazaDao getTraza() {
    return traza;
  }
}
