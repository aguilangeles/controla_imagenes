/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.GetMuestrafromRango;
import java.io.File;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingWorker;

/**
 *
 * @author MUTNPROD003
 */
public class IdentificarExtensionSublote extends SwingWorker<Void, Object> {
// acabo de silenciar parent y ultima carpeta, creo que los puedo convocar
  // en un a instancia mas adelante.

  private static final String INCOMPATIBLE_TAMANIO_CON_RANGO = "<html>El tamanio del "
          + "lote es inferior al rango asignado para ese volumen. Edite tabla 'Rangos'.</html>";
  private List<Integer> controlesList;
  private File file;
  private JFrame frame;
  private JLabel infoLabel;
//  private String parent, ultimaCarpeta;
  private int idUsuario, idDocumento, idVerificacion;
  private JFrame panelControl;
  private int tamanio, muestra, idRango;
  private static String extension;
  private static List<Object> listaExtension;
  private List<Object> listaIDC;
  private static List<Object> listaResultado;

  public IdentificarExtensionSublote(JFrame frame, JLabel infoLabel,
          List<Integer> controlesList, File file, int idUsuario, int idDocumento, int idVerificacion, List<Object> listaIdc) {
    this.controlesList = controlesList;
    this.file = file;
    this.frame = frame;
    this.infoLabel = infoLabel;
//    this.parent = parent;
//    this.ultimaCarpeta = ultimaCarpeta;
    this.idUsuario = idUsuario;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.listaIDC = listaIdc;
    this.tamanio = listaIDC.size();

  }

  @Override
  protected Void doInBackground() {
    GetMuestrafromRango muestrafromRango = new GetMuestrafromRango(tamanio);
    muestra = GetMuestrafromRango.getMuestra();
    idRango = GetMuestrafromRango.getIdRango();
    System.out.println("muestra " + muestra + ", tamanio " + tamanio + ", rango " + idRango);
    CrearElRamdom newRamdom = new CrearElRamdom(getListaIDC(), getMuestra());
    List<Object> ramdomIDC = newRamdom.getStack();
    for (Object object : ramdomIDC)
      {
      System.out.println(object);
      }
//    GetImagenesList imagenesList = new GetImagenesList(ramdomIDC);

    //    listaResultado = newRamdom.getStack();
    return null;
  }

  @Override
  protected void done() {
    if (!isCancelled())
      {
      System.out.println("entro en done ");
//      java.awt.EventQueue.invokeLater(new Runnable() {
//        @Override
//        public void run() {
//          WorkerSubLote worker = new WorkerSubLote(frame, infoLabel, controlesList, listaResultado, parent,
//                  extension, ultimaCarpeta, idUsuario, idDocumento, idVerificacion, muestra, tamanio, idRango);
//          worker.execute();
//        }
//      });
      }
  }

  private boolean isTamanioCompatibleConRango(int aTamanio, int aRango) {
    boolean ret = (aTamanio > aRango) ? true : false;
    return ret;
  }

  public int getTamanio() {
    return tamanio;
  }

  public int getMuestra() {
    return muestra;
  }

  public List<Object> getListaIDC() {
    return listaIDC;
  }

  public int getIdRango() {
    return idRango;
  }
}
