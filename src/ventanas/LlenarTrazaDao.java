/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ventanas;

import database.SelectControlesporVerificacionList;
import database.SelectArchivobyTrazaList;
import database.SelectSubloteporTrazaList;
import database.Conexion;
import entidad.TiposDeControl;
import entidad.TrazaDao;
import helper.Encoder;
import helper.GetIdandExtensionImg;
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
    List<Object> imagenesList = new SelectArchivobyTrazaList(conexion, idTraza, parent, true).getImagenesList();
    List<TiposDeControl> tiposList = new SelectControlesporVerificacionList(conexion, idTraza).getTiposDeControlList();
    this.traza = new TrazaDao(idTraza, idImg, tiposList, imagenesList);
    return traza;
  }
  private TrazaDao llenartrazaDocumento() {
    List<Object> imagenesList = new SelectSubloteporTrazaList(conexion, idTraza, parent).getImagenesList();
    List<TiposDeControl> tiposList = new SelectControlesporVerificacionList(conexion, idTraza).getTiposDeControlList();
    this.traza = new TrazaDao(idTraza, idImg, tiposList, imagenesList, true);
    return traza;
  }

  public TrazaDao getTraza() {
    return traza;
  }
}
