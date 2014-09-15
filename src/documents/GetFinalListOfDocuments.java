/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documents;

import database.SelectTamanioMuestra;
import files.CreateRamdom;
import java.io.File;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * crea una lista final de documentos surgidos del rango.
 * @author MUTNPROD003
 */
public class GetFinalListOfDocuments extends SwingWorker<Void, Object> {

  private static final String INCOMPATIBLE_TAMANIO_CON_RANGO = "<html>El tamanio del "
          + "lote es inferior al rango asignado para ese volumen. Edite tabla 'Rangos'.</html>";
  //
  private JFrame frame;
  private JLabel infoLabel;
  private File file;
  private int idDocumento, idVerificacion, tamanio, muestra, idRango;
  private static List<Object> listaExtension;
  private List<Integer> controlesList;
  private List<Object> documentList;
  private static List<Object> finalDocumentList;

  public GetFinalListOfDocuments(JFrame frame, JLabel infoLabel, File file, int idDocumento, int idVerificacion, List<Integer> controlesList, List<Object> listaIdc) {
    this.frame = frame;
    this.infoLabel = infoLabel;
//    this.file = file;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.controlesList = controlesList;
    this.documentList = listaIdc;
    this.tamanio = documentList.size();

  }
  public GetFinalListOfDocuments(JFrame frame, JLabel infoLabel,  int idDocumento, int idVerificacion, List<Integer> controlesList, List<Object> listaIdc) {
    this.frame = frame;
    this.infoLabel = infoLabel;
//    this.file = file;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
    this.controlesList = controlesList;
    this.documentList = listaIdc;
    this.tamanio = documentList.size();

  }

  @Override
  protected Void doInBackground() {
    SelectTamanioMuestra muestrafromRango = new SelectTamanioMuestra(tamanio);
    muestra = SelectTamanioMuestra.getMuestra();
    idRango = SelectTamanioMuestra.getIdRango();
    infoLabel.setText("Tamanio " + tamanio + ", muestra " + muestra + ", rango id " + idRango);
    CreateRamdom newRamdom = new CreateRamdom(documentList, getMuestra());
    finalDocumentList = newRamdom.getStack();
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
            WorkerDocument worker = new WorkerDocument(frame, infoLabel, idDocumento, idVerificacion, muestra, idRango, tamanio, finalDocumentList, controlesList);
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
