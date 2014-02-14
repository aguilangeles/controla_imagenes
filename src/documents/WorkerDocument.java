/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documents;

import database.Conexion;
import database.SelectLastID;
import database.InsertarNuevaTraza;
import helper.GetIdandExtensionImg;
import panelContol.ContadorSublotes;
import files.OnlyPdf;
import entidad.Sublote;
import ventanas.LlenarTrazaDao;
import files.Tif_Png_Jpg;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author MUTNPROD003
 */
public class WorkerDocument extends SwingWorker<Object, Object> {

  private Conexion conexion = new Conexion();
  //
  private JFrame cargaLote;// lo necesito para mostrar el conteo
  private JLabel infoLabel;
  private String parent, extension, ultimaCarpeta;
  private int idDocumento, idVerificacion, muestra, tamanioLote, idRango, contador, idTraza;
  private List<Integer> idControlList;//lo necesito para crear la tabla de checkbox
  private List<Object> listaImagenes;
  private List<Sublote> sublotes;

  public WorkerDocument(JFrame cargarLote, JLabel infoLabel, int idDocumento, int idVerificacion, int muestra, int idRango, int tamanioLote, List<Object> listaImagenes, List<Integer> idControl) {
    this.cargaLote = cargarLote;
    this.infoLabel = infoLabel;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.muestra = muestra;
    this.idRango = idRango;
    this.tamanioLote = tamanioLote;//
    this.idControlList = idControl;
    this.listaImagenes = listaImagenes;//
    this.parent = ContadorSublotes.getParent();
    this.extension = ContadorSublotes.getExtension();//la uso_
    this.ultimaCarpeta = ContadorSublotes.getUltimaCarpeta();
  }

  @Override
  protected String doInBackground() {
    if (conexion.isConexion())
      {
      int idImagen = GetIdandExtensionImg.getIdImagen();
      idTraza = new SelectLastID(conexion, "traza").getUltimoID();
      InsertarNuevaTraza insertarNuevaTraza =
              new InsertarNuevaTraza(conexion, idDocumento, idVerificacion,
              tamanioLote, parent, ultimaCarpeta, muestra, idRango);
      GetListOfImagesForDoc imagenesList = new GetListOfImagesForDoc(conexion, listaImagenes, idTraza);
      sublotes = imagenesList.getSubloteList();
      switch (idImagen)
        {
        case 1:
          OnlyPdf();
          break;
        case 2:
        case 3:
          Tif_Png_Jpg();
          break;
        }
      }
    return null;
  }

  @Override
  protected void done() {
    if (!isCancelled())
      {
      conexion.isConexionClose();
      crearNuevoWorker();
      }
  }

  private void crearNuevoWorker() {
    int trazaID;
    Conexion con = new Conexion();
    if (con.isConexion())
      {
      int resultado = idTraza + 1;
      trazaID = (resultado == 0) ? 1 : resultado;
      LlenarTrazaDao trazaDao = new LlenarTrazaDao(con, trazaID, parent, true);
      
      new VentanaDocumentos(trazaDao.getTraza()).setVisible(true);
      }
    con.isConexionClose();
    cargaLote.dispose();
  }

  private void Tif_Png_Jpg() {
    Tif_Png_Jpg varios = new Tif_Png_Jpg(conexion, muestra, idTraza, infoLabel, idControlList, sublotes);
  }

  private void OnlyPdf() {
    OnlyPdf onlyPdf =
            new OnlyPdf(conexion, muestra, idTraza,
            listaImagenes, infoLabel, idControlList, sublotes);
  }
}
