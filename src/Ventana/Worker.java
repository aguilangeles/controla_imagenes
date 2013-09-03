/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.Conexion;
import Entidades.LlenarTrazaDao;
import Daos.NombrePaginaDelPDF;
import Helpers.Archivo;
import Helpers.UltimoIDInsertado;
import Helpers.PasarGarbageCollector;
import Helpers.Traza;
import PanelesABM.OnlyPdf;
import PanelesABM.Tif_Png_Jpg;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import necesitoUnMilagro.Ventana;
import tratamientoruta.CrearElRamdom;

/**
 *
 * @author MUTNPROD003
 */
public class Worker extends SwingWorker<Object, Object> {

  private Conexion conexion = new Conexion();
  private JFrame controles;// lo necesito para mostrar el conteo
  private JLabel infoLabel;
  private List<Integer> idControl;//lo necesito para crear la tabla de checkbox
  private List<Object> lista;
  private String parent, extension, ultimaCarpeta;
  private int idUsuario, idDocumento, idVerificacion, muestra, tamanioLote;
  private int idRango, contador;
  private int idTraza;
  private static Traza sTraza;
  private CrearElRamdom crearRamdom;

  public Worker(JFrame controles, JLabel infoLabel, List<Integer> idControl,
          List<Object> lista, String parent, String extension, String ultimaCarpeta,
          int idUsuario, int idDocumento, int idVerificacion, int muestra, int tamanioLote, int idRango) {
    this.controles = controles;
    this.infoLabel = infoLabel;
    this.idControl = idControl;
    this.lista = lista;
    this.parent = parent;
    this.extension = extension;
    this.ultimaCarpeta = ultimaCarpeta;
    this.idUsuario = idUsuario;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.muestra = muestra;
    this.tamanioLote = tamanioLote;
    this.idRango = idRango;
    this.crearRamdom = new CrearElRamdom(lista, muestra);
  }

  @Override
  protected String doInBackground() {
    if (conexion.isConexion()) {
      idTraza = new UltimoIDInsertado(conexion, "traza").getUltimoID();
      switch (extension) {
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
    if (!isCancelled()) {
      conexion.isConexionClose();
      crearNuevoWorker();
    }
  }

  private void crearNuevoWorker() {
    int trazaID;
    Conexion con = new Conexion();
    if (con.isConexion()) {
      int resultado = new UltimoIDInsertado(con, "traza").getUltimoID();
      trazaID = (resultado == 0) ? 1 : resultado;
      LlenarTrazaDao trazaDao = new LlenarTrazaDao(trazaID, parent, con, getExtension());
      new Ventana(trazaDao.getTraza()).setVisible(true);
    }
    con.isConexionClose();
    controles.dispose();
  }

  private void Tif_Png_Jpg() {
    Tif_Png_Jpg tif_Png_Jpg =
            new Tif_Png_Jpg(sTraza, conexion, idUsuario, idDocumento,
            idVerificacion, idRango, muestra, lista.size(), idTraza,
            parent, ultimaCarpeta, crearRamdom, infoLabel, idControl);
  }

  private void OnlyPdf() {
    OnlyPdf onlyPdf =
            new OnlyPdf(sTraza, conexion, idUsuario, idDocumento,
            idVerificacion, tamanioLote, muestra, idRango, idTraza,
            parent, ultimaCarpeta, crearRamdom, infoLabel, idControl);
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
