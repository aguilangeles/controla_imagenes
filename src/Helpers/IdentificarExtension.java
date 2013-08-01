/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Ventana.MuestraRango;
import Ventana.Worker;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.SwingWorker;
import tratamientoruta.BuscarPaginasPdf;
import tratamientoruta.TipoDeImagen;

/**
 *
 * @author MUTNPROD003
 */
public class IdentificarExtension extends SwingWorker<Void, Object> {

  private static final String INCOMPATIBLE_TAMANIO_CON_RANGO = "<html>El tamanio del "
          + "lote es inferior al rango asignado para ese volumen. Edite tabla 'Rangos'.</html>";
      private int tamanio, muestra, idRango;
  private String extension;
  private List<Object> listaExtension = new ArrayList<>();
  private List<Object> listaResultado;
  private List<Integer> controlesList;
  private File file;
  private JFrame frame;
  private JLabel infoLabel;
  private String parent, ultimaCarpeta;
  private int idUsuario, idDocumento, idVerificacion;

  public IdentificarExtension(JFrame frame, JLabel infoLabel,  List<Integer> controlesList, File file, String parent, String ultimaCarpeta, int idUsuario, int idDocumento, int idVerificacion) {
    this.controlesList = controlesList;
    this.file = file;
    this.frame = frame;
    this.infoLabel = infoLabel;
    this.parent = parent;
    this.ultimaCarpeta = ultimaCarpeta;
    this.idUsuario = idUsuario;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
  }

  public IdentificarExtension(File aFile) {
    this.file = aFile;
  }

  private void buscarExtensiones(File aFile) {
    File[] files = aFile.listFiles();
    for (int x = 0; x < files.length; x++) {
      String name = files[x].getName();
      infoLabel.setText("Analizando..." + name);
      boolean ext = (name.endsWith(".tif")//
              || name.endsWith(".pdf")
              || name.endsWith(".jpg")
              || name.endsWith(".png")) ? true : false;
      if (files[x].isDirectory()) {
        buscarExtensiones(files[x]);
      }
      if (ext) {
        TipoDeImagen stringImage = new TipoDeImagen(name);
        extension = (stringImage.getExtension());
        listaExtension.add(files[x].getAbsolutePath());
      }
    }

  }

  public String getExtension() {
    return extension;
  }

  public List<Object> getLista() {
    return listaExtension;
  }

  public void setLista(List<Object> lista) {
    listaExtension = lista;
  }

  @Override
    protected Void doInBackground() throws Exception {
    buscarExtensiones(file);
    infoLabel.setText("Espere mientras se construye la ventana principal...");
    listaResultado = switchExtension(extension, listaExtension, infoLabel);
    tamanio = listaResultado.size();
    MuestraRango muestraRango = new MuestraRango(tamanio);
    muestra = muestraRango.getMuestra();
    idRango = muestraRango.getIdRango();
    return null;
  }

  public int getTamanio() {
    return tamanio;
  }

  public int getMuestra() {
    return muestra;
  }

  public int getIdRango() {
    return idRango;
  }

  @Override
  protected void done() {
    if (!isCancelled()) {
      if (isTamanioCompatibleConRango(getTamanio(), getIdRango())) {
        java.awt.EventQueue.invokeLater(new Runnable() {
          @Override
          public void run() {
            Worker worker = new Worker(frame, infoLabel, controlesList, listaResultado, parent,
                    extension, ultimaCarpeta, idUsuario, idDocumento, idVerificacion, getMuestra(), getTamanio(),
                    getIdRango());
            worker.execute();
          }
        });
      } else {
        JOptionPane.showMessageDialog(infoLabel, INCOMPATIBLE_TAMANIO_CON_RANGO,
                getTamanio() + ">" + getMuestra(), JOptionPane.ERROR_MESSAGE);
        System.exit(0);
      }
    }
  }

  private List<Object> switchExtension(String extension, List<Object> lista, JLabel infoLabel) {
    switch (extension) {
      case ".tif":
      case ".png":
      case ".jpg":
        lista = lista;
        break;
      case ".pdf":
        BuscarPaginasPdf pagePdf = new BuscarPaginasPdf(lista, infoLabel);
        lista = pagePdf.getLista();
        break;
    }
    return lista;
  }

  public List<Object> getListaResultado() {
    return listaResultado;
  }

  private boolean isTamanioCompatibleConRango(int aTamanio, int aRango) {
    boolean ret = (aTamanio > aRango) ? true : false;
    return ret;
  }
}
