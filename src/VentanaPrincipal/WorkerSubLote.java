/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import BasedeDatos.Conexion;
import BasedeDatos.GetUltimoIDInsertado;
import BasedeDatos.InsertarNuevaTraza;
import Helpers.GetExtensionIdImagen;
import PaneldeControl.ContadorSublotes;
import TratarFile.GetImagenesList;
import TratarFile.OnlyPdf;
import TratarFile.Sublote;
import TratarFile.Tif_Png_Jpg;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author MUTNPROD003
 */
public class WorkerSubLote extends SwingWorker<Object, Object> {

  private Conexion conexion = new Conexion();
  private JFrame cargaLote;// lo necesito para mostrar el conteo
  private JLabel infoLabel;
  private List<Integer> idControl;//lo necesito para crear la tabla de checkbox
  private List<Object> listaImagenes;
  private String parent, extension, ultimaCarpeta;
  private int idUsuario, idDocumento, idVerificacion, muestra, tamanioLote;
  private int idRango, contador;
  private int idTraza;
  private List<Sublote> sublotes;

  public WorkerSubLote(JFrame controles, JLabel infoLabel, List<Integer> idControl, List<Object> listaImagenes, int idUsuario, int idDocumento, int idVerificacion, int muestra, int tamanioLote, int idRango) {
    this.cargaLote = controles;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    this.listaImagenes = listaImagenes;
    this.extension = ContadorSublotes.getExtension();
    this.idUsuario = idUsuario;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.muestra = muestra;
    this.tamanioLote = tamanioLote;
    this.idRango = idRango;
    this.parent = ContadorSublotes.getParent();
    this.ultimaCarpeta = ContadorSublotes.getUltimaCarpeta();
  }

  @Override
  protected String doInBackground() {
    if (conexion.isConexion())
      {
      int idImagen = GetExtensionIdImagen.getIdImagen();
      idTraza = new GetUltimoIDInsertado(conexion, "traza").getUltimoID();
      InsertarNuevaTraza insertarNuevaTraza =
              new InsertarNuevaTraza(conexion, idDocumento, idVerificacion,
              tamanioLote, parent, ultimaCarpeta, muestra, idRango);
      GetImagenesList imagenesList = new GetImagenesList(listaImagenes, conexion, idTraza);
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
      LlenarTrazaDao trazaDao = new LlenarTrazaDao(trazaID, parent, con, true);
      new VentanaDocumentos(trazaDao.getTraza(), sublotes).setVisible(true);
      }
    con.isConexionClose();
    cargaLote.dispose();
  }

  private void Tif_Png_Jpg() {
    Tif_Png_Jpg varios = new Tif_Png_Jpg(conexion, muestra, idTraza, infoLabel, idControl, sublotes);
  }

  private void OnlyPdf() {
    OnlyPdf onlyPdf =
            new OnlyPdf(conexion, muestra, idTraza,
            listaImagenes, infoLabel, idControl, sublotes);
  }

  public String getExtension() {
    return extension;
  }

  public String getParent() {
    return parent;
  }
}
