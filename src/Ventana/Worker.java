/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Entidades.Conexion;
import Entidades.LlenarTrazaDao;
import Entidades.Pdf_NombreMasNumero;
import Helpers.Archivo;
import Helpers.LastID;
import Helpers.PasarGarbageCollector;
import Helpers.Traza;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import tratamientoruta.CrearElRamdom;

/**
 *
 * @author MUTNPROD003
 */
public class Worker extends SwingWorker<Object, Object> {

  private Conexion conexion = new Entidades.Conexion();
  //
  private JFrame controles;// lo necesito para mostrar el conteo
  private JLabel infoLabel;
  private List<Integer> idControl;//lo necesito para crear la tabla de checkbox
  private List<Object> lista;
  private String parent, extension, ultimaCarpeta;
  private int idUsuario, idDocumento, idVerificacion, muestra, tamanioLote;
  private int idRango, contador;
  private int idTraza;

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
  }

  @Override
  protected String doInBackground() {

    if (conexion.isConexion()) {
      idTraza = new LastID(conexion, "traza").lastId();
      switch (extension) {
        case ".tif":
        case ".png":
        case ".jpg":
          Traza traza = new Traza(conexion, idUsuario, idDocumento, idVerificacion, lista.size(), parent, ultimaCarpeta, muestra, idRango);
          CrearElRamdom crearRamdom = new CrearElRamdom(lista, muestra);
          List<Object> ramdomList = crearRamdom.getSeleccion();
          for (Object obj : ramdomList) {
            String aImagen = (String) obj;
            int parentlength = parent.length() + 1;
            String adaptarFile = aImagen.substring(parentlength);
            String filename = adaptarFile.replace("\\", "\\\\");
            Archivo archivo = new Archivo(conexion, idTraza, filename, 0, infoLabel);
            imagenyControl();
          }
          break;
        case ".pdf":
          Traza trazaPdf = new Traza(conexion, idUsuario, idDocumento, idVerificacion, tamanioLote, parent, ultimaCarpeta, muestra, idRango);
          CrearElRamdom ramdomListPdf = new CrearElRamdom(lista, muestra);
          List<Object> ramdomPdf = ramdomListPdf.getSeleccion();
          for (Object o : ramdomPdf) {
            contador++;
            Pdf_NombreMasNumero pagina = (Pdf_NombreMasNumero) o;
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
      int lasid = new LastID(conexion, "archivo").lastId();
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
      new PasarGarbageCollector();
    infoLabel.setText("Preparando la ventana Principal...");
      conexion.desconectar();
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
    int trazaID = 0;
    Conexion con = new Conexion();
    if (con.isConexion()) {
      int resultado = new LastID(con, "traza").lastId();
      trazaID = (resultado == 0) ? 1 : resultado;
      LlenarTrazaDao trazaDao = new LlenarTrazaDao(trazaID, parent, con, getExtension(), infoLabel);
      new necesitoUnMilagro.Ventana11(trazaDao.getTraza()).setVisible(true);
      con.desconectar();
    }
    controles.dispose();
  }
}
