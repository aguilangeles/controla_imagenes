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

  private static final String INCOMPATIBLE_TAMANIO_CON_RANGO = "<html>El tamanio del "
          + "lote es inferior al rango asignado para ese volumen. Edite tabla 'Rangos'.</html>";
  private List<Integer> controlesList;
  private File file;
  private JFrame frame;
  private JLabel infoLabel;
  private String parent, ultimaCarpeta;
  private int idUsuario, idDocumento, idVerificacion;
  private JFrame panelControl;
  private int tamanio, muestra, idRango;
  private static String extension;
  private static List<Object> listaExtension;
  private List<Object> listaIDC;
  private static List<Object> listaResultado;

  public IdentificarExtensionSublote(JFrame frame, JLabel infoLabel,
          List<Integer> controlesList, File file, String parent,
          String ultimaCarpeta, int idUsuario, int idDocumento, int idVerificacion) {
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
  protected Void doInBackground() {
    ListaRecursivaSublote lrs = new ListaRecursivaSublote(infoLabel, file);
    listaIDC = lrs.getListaIdc();// trae la lista de los idc
    tamanio = listaIDC.size(); ///hasta aca, se puede usar
    GetMuestrafromRango muestrafromRango = new GetMuestrafromRango(tamanio);
    muestra = GetMuestrafromRango.getMuestra();
    idRango = GetMuestrafromRango.getIdRango();
    return null;
  }

  @Override
  protected void done() {
    CrearElRamdom newRamdom = new CrearElRamdom(listaIDC, muestra);
    List<Object> ramdomList = newRamdom.getStack();
    RecursiveFromIdc rec = new RecursiveFromIdc(ramdomList, ListaRecursivaSublote.isPdf(), ListaRecursivaSublote.isTif());
////      File file1 = new File((String) obj);
//      if (file1.isDirectory())
//        {
//        File[] listfiles = file1.listFiles();
//        for (int i = 0; i < listfiles.length; i++)
//          {
//          Object object = listfiles[i];
//          if (object.toString().endsWith("Imagenes"))
//            {
//            File file2 = new File(object.toString());
//            File[] listfiles2 = file2.listFiles();
//            for (int j = 0; j < listfiles2.length; j++)
//              {
//              File file3 = listfiles2[j];
//              System.out.println(file3);
//              }
//
//
//
//            }
////          System.out.println(object);
//
//          }
//        }
//      }


//    java.awt.EventQueue.invokeLater(new Runnable() {
//      @Override
//      public void run() {
//        WorkerSubLote worker = new WorkerSubLote(frame, infoLabel, controlesList, listaResultado, parent,
//                extension, ultimaCarpeta, idUsuario, idDocumento, idVerificacion, muestra, tamanio, idRango);
//        worker.execute();
//      }
//    });
    System.exit(0);
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
