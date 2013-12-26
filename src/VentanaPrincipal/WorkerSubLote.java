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
  private static int idTraza;
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
    int idImagen = GetExtensionIdImagen.getIdImagen();
    if (conexion.isConexion())
      {
      String parents = ContadorSublotes.getParent();
      String ultima = ContadorSublotes.getUltimaCarpeta();
      InsertarNuevaTraza insertarNuevaTraza = new InsertarNuevaTraza(conexion, idUsuario, idDocumento, idVerificacion,
              tamanioLote, parents, ultima, muestra, idRango);
      idTraza = new GetUltimoIDInsertado(conexion, "traza").getUltimoID();
      GetImagenesList imagenesList = new GetImagenesList(listaImagenes, conexion);
      sublotes = imagenesList.getSubloteList();
      switch (idImagen)
        {
        case 1:
          OnlyPdf();
          break;
        case 2:
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
      LlenarTrazaDao trazaDao = new LlenarTrazaDao(idTraza, parent, con, getExtension(), true);

    //  new VentanaDocumentos(trazaDao.getTraza(), sublotes).setVisible(true);
      }
    con.isConexionClose();
    cargaLote.dispose();
  }

  private void Tif_Png_Jpg() {

    Tif_Png_Jpg varios = new Tif_Png_Jpg(conexion, idUsuario, idDocumento, idVerificacion, idRango, muestra, tamanioLote, idTraza, infoLabel, idControl, sublotes);
  }

  private void OnlyPdf() {
    OnlyPdf onlyPdf =
            new OnlyPdf(conexion, idUsuario, idDocumento,
            idVerificacion, tamanioLote, muestra, idRango, idTraza,
            listaImagenes, infoLabel, idControl, sublotes);
  }

  public String getExtension() {
    return extension;
  }

  public String getParent() {
    return parent;
  }

  public static int getIdTraza() {
    return idTraza;
  }
}
