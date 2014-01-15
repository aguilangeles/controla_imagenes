/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import BasedeDatos.Conexion;
import BasedeDatos.SelectTamanioMuestra;
import BasedeDatos.GetUltimoIDInsertado;
import BasedeDatos.InsertarNuevaTraza;
import Helpers.GetIdandExtensionImg;
import Helpers.GetUltimaCarpeta;
import Helpers.GetParent;
import files.OnlyPdf;
import files.Tif_Png_Jpg;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author MUTNPROD003
 */
public class WorkerImage extends SwingWorker<Object, Object> {

  private Conexion conexion = new Conexion();
  private JFrame cargaLote;// lo necesito para mostrar el conteo
  private JLabel infoLabel;
  private List<Integer> idControl;//lo necesito para crear la tabla de checkbox
  private List<Object> listaImagenes;
  private String parent, ultimaCarpeta;
  private int idTraza, idDocumento, idVerificacion, muestra, tamanioLote, idRango;

  public WorkerImage(JFrame controles, JLabel infoLabel, List<Integer> idControl, List<Object> listaImagenes, int idDocumento, int idVerificacion, int muestra, int idRango) {
    this.cargaLote = controles;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    this.listaImagenes = listaImagenes;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.tamanioLote = listaImagenes.size();
    this.parent = GetParent.getParent();
    this.ultimaCarpeta = GetUltimaCarpeta.getLastFolder(parent);
    this.muestra = muestra;
    this.idRango = idRango;
  }

  @Override
  protected String doInBackground() {
    if (conexion.isConexion())
      {
      idTraza = new GetUltimoIDInsertado(conexion, "traza").getUltimoID();
      InsertarNuevaTraza insertarNuevaTraza =
              new InsertarNuevaTraza(conexion, idDocumento, idVerificacion,
              tamanioLote, parent, ultimaCarpeta, muestra, idRango);
      int idImagen = GetIdandExtensionImg.getIdImagen();
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
      LlenarTrazaDao trazaDao = new LlenarTrazaDao(con, trazaID, parent);
      new Ventana(trazaDao.getTraza()).setVisible(true);
      }
    con.isConexionClose();
    cargaLote.dispose();
  }

  private void Tif_Png_Jpg() {
    Tif_Png_Jpg insertarFormatos_tifPngJpg =
            new Tif_Png_Jpg(infoLabel, conexion, muestra, idTraza,
            parent, idControl, listaImagenes);
  }

  private void OnlyPdf() {
    OnlyPdf onlyPdf =
            new OnlyPdf(infoLabel, conexion, muestra, idTraza,
            parent, idControl, listaImagenes);
  }
}
