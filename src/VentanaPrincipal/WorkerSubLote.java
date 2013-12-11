/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import BasedeDatos.Conexion;
import BasedeDatos.GetUltimoIDInsertado;
import BasedeDatos.InsertarNuevaTraza;
import PaneldeControl.ContadorSublotes;
import TratarFile.GetImagenesList;
import TratarFile.OnlyPdf;
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
  private static InsertarNuevaTraza sTraza;

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
//    System.out.println(parent+" - "+ultimaCarpeta);
  }

  @Override
  protected String doInBackground() {
    System.out.println("do in background worker");
    /*DEBERIA INSERTAR ACA EL CONTENIDO DE SUBLOTES*/
    if (conexion.isConexion())
      {
      idTraza = new GetUltimoIDInsertado(conexion, "traza").getUltimoID();
      GetImagenesList imagenesList = new GetImagenesList(listaImagenes, conexion, idTraza);

      switch (extension)
        {
        case ".tif":
        case ".png":
        case ".jpg":
          Tif_Png_Jpg();
          break;
        case ".pdf":
          OnlyPdf();
          break;
        }
      }
    return null;
  }

  @Override
  protected void done() {
    if (!isCancelled())
      {
      System.out.println("done worker");
//      conexion.isConexionClose();
//      crearNuevoWorker();
      }
  }

  private void crearNuevoWorker() {
    int trazaID;
    Conexion con = new Conexion();
    if (con.isConexion())
      {
      int resultado = new GetUltimoIDInsertado(con, "traza").getUltimoID();

      trazaID = (resultado == 0) ? 1 : resultado;
      LlenarTrazaDao trazaDao = new LlenarTrazaDao(trazaID, parent, con, getExtension());
      new Ventana(trazaDao.getTraza()).setVisible(true);
      }
    con.isConexionClose();
    cargaLote.dispose();
  }

  private void Tif_Png_Jpg() {
    Tif_Png_Jpg tif_Png_Jpg =
            new Tif_Png_Jpg(sTraza, conexion, idUsuario, idDocumento,
            idVerificacion, idRango, muestra, tamanioLote, idTraza,
            parent, ultimaCarpeta, infoLabel, idControl, listaImagenes);
  }

  private void OnlyPdf() {
    OnlyPdf onlyPdf =
            new OnlyPdf(sTraza, conexion, idUsuario, idDocumento,
            idVerificacion, tamanioLote, muestra, idRango, idTraza,
            parent, ultimaCarpeta, listaImagenes, infoLabel, idControl);
  }

  public int getIdTraza() {
    return idTraza;
  }

  public String getExtension() {
    return extension;
  }

  public String getParent() {
    return parent;
  }
}
