/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.GetMuestrafromRango;
import VentanaPrincipal.Worker;
import java.io.File;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 *
 * @author MUTNPROD003
 */
public class IdentificarExtension extends SwingWorker<Void, Object> {

  private static final String INCOMPATIBLE_TAMANIO_CON_RANGO = "<html>El tamanio del "
          + "lote es inferior al rango asignado para ese volumen. Edite tabla 'Rangos'.</html>";
  private List<Integer> controlesList;
  private File file;
  private JFrame frame;
  private JLabel infoLabel;
  private String parent, ultimaCarpeta;
  private int idUsuario, idDocumento, idVerificacion;
  private JFrame panelControl ;
  //
  private  int tamanio, muestra, idRango;
  private static String extension;
  private static List<Object> listaExtension;
  private static List<Object> listaResultado;

  public IdentificarExtension(JFrame frame, JLabel infoLabel,
          List<Integer> controlesList, File file, String parent, String ultimaCarpeta, int idUsuario, int idDocumento, int idVerificacion) {
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
  protected Void doInBackground()  {

    ListaRecursiva extensionImagen = new ListaRecursiva(infoLabel,file);

    listaExtension = extensionImagen.getListaExtensionImagen();

    extension = extensionImagen.getExtension();

    listaResultado = new SwitchListaExtension(extension, listaExtension, infoLabel).switchExtension();
    tamanio = listaResultado.size();
    GetMuestrafromRango muestrafromRango = new GetMuestrafromRango(tamanio);
    muestra =GetMuestrafromRango.getMuestra();
    idRango = GetMuestrafromRango.getIdRango();
    return null;
  }

  @Override
  protected void done() {
    if (!isCancelled())
      {
      if (isTamanioCompatibleConRango(getTamanio(), getMuestra()))
        {
        java.awt.EventQueue.invokeLater(new Runnable() {
          @Override
          public void run() {
            Worker worker = new Worker(frame, infoLabel, controlesList, listaResultado, parent,
                    extension, ultimaCarpeta, idUsuario, idDocumento, idVerificacion, muestra, tamanio, idRango);
            worker.execute();
          }
        });
        } else
        {
        JOptionPane.showMessageDialog(infoLabel, INCOMPATIBLE_TAMANIO_CON_RANGO,
                getTamanio() + ">" + getMuestra(), JOptionPane.ERROR_MESSAGE);
        System.exit(0);
        }
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

  public int getIdRango() {
    return idRango;
  }
}
