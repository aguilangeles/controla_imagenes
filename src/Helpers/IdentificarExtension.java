/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import PanelesABM.ListaRecursiva;
import Ventana.MuestraRango;
import Ventana.Worker;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
//  private List<Object> listaExtension = new ArrayList<>();
  private List<Object> listaExtension;
  private List<Object> listaResultado;
  private List<Integer> controlesList;
  private File file;
  private JFrame frame;
  private JLabel infoLabel;
  private String parent, ultimaCarpeta;
  private int idUsuario, idDocumento, idVerificacion;

  public IdentificarExtension(JFrame frame, JLabel infoLabel, List<Integer> controlesList, File file, String parent, String ultimaCarpeta, int idUsuario, int idDocumento, int idVerificacion) {
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

  @Override
  protected Void doInBackground() throws Exception {
    ListaRecursiva extensionImagen = new ListaRecursiva(infoLabel,file);
    listaExtension = extensionImagen.getListaExtension();
    extension = extensionImagen.getExtension();
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
      if (isTamanioCompatibleConRango(getTamanio(), getMuestra())) {
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

  public List<Object> getLista() {
    return listaExtension;
  }

  public void setLista(List<Object> lista) {
    listaExtension = lista;
  }
}
