/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.Conexion;
import Entidades.LlenarTrazaDao;
import Daos.NombrePaginaDelPDF;
import Daos.TrazaDao;
import Helpers.Archivo;
import Helpers.UltimoIDInsertado;
import Helpers.PasarGarbageCollector;
import Helpers.Traza;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
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
          sTraza = new Traza(conexion, idUsuario, idDocumento, idVerificacion,
                  lista.size(), parent, ultimaCarpeta, muestra, idRango);
          List<Object> ramdomList = crearRamdom.getSeleccion();
          for (Object obj : ramdomList) {
            String aImagen = (String) obj;
            int parentlength = parent.length() + 1;
            String adaptarFile = aImagen.substring(parentlength);
            String filename = adaptarFile.replace("\\", "\\\\");
            Archivo archivo = new Archivo(conexion, idTraza, filename, 0, infoLabel);
            imagenyControl();
            Runtime gar = Runtime.getRuntime();
            gar.gc();
          }
          break;
        case ".pdf":
          sTraza = new Traza(conexion, idUsuario, idDocumento, idVerificacion,
                  tamanioLote, parent, ultimaCarpeta, muestra, idRango);
          List<Object> ramdomPdf = crearRamdom.getSeleccion();
          for (Object o : ramdomPdf) {
            contador++;
            NombrePaginaDelPDF pagina = (NombrePaginaDelPDF) o;
            int parentlength = parent.length() + 1;
            String adaptarFile = pagina.getNombre().substring(parentlength);
            String filename = adaptarFile.replace("\\", "\\\\");
            int page = pagina.getNumeroPagina();
            Archivo archivo = new Archivo(conexion, idTraza, filename, page, infoLabel);
            imagenyControl();
            Runtime gar = Runtime.getRuntime();
            gar.gc();
          }
          break;
      }
    }
    return null;
  }

  private void imagenyControl() {
    int id = getIdTraza() + 1;
    for (Integer idarchivo : idControl) {
      int lasid = new UltimoIDInsertado(conexion, "archivo").getUltimoID();
      String ret = "Insert into qualitys.traza_archivo_controles "
              + "(idtraza, idarchivo, idcontrol, estado) VALUES "
              + "(" + id + ", " + lasid + ", " + idarchivo + ", " + 0 + ");";
      try {
        conexion.executeUpdate(ret);
      } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, ex.getMessage(), "Imagen y control", JOptionPane.ERROR_MESSAGE);

//        Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  public String getExtension() {
    return extension;
  }

  @Override
  protected void done() {
    if (!isCancelled()) {
      PasarGarbageCollector pasarGarbageCollector = new PasarGarbageCollector();
      conexion.isConexionClose();
      crearNuevoWorker();
    }
  }

  public int getIdTraza() {
    return idTraza;
  }

  public String getParent() {
    return parent;
  }

  private void crearNuevoWorker() {
    int trazaID;
    Conexion con = new Conexion();
    if (con.isConexion()) {
      int resultado = new UltimoIDInsertado(con, "traza").getUltimoID();
      trazaID = (resultado == 0) ? 1 : resultado;
      LlenarTrazaDao trazaDao = new LlenarTrazaDao(trazaID, parent, con, getExtension());
      new necesitoUnMilagro.Ventana11(trazaDao.getTraza()).setVisible(true);

    }
    con.isConexionClose();
    controles.dispose();
  }
}
