/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import database.SelectTamanioMuestra;
import ventanas.WorkerImage;
import java.io.File;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import panelContol.TryFilechooser;

/**
 *
 * @author MUTNPROD003
 */
public class GetFinalListOfImages extends SwingWorker<Void, Object> {

  private static final String INCOMPATIBLE_TAMANIO_CON_RANGO = "<html>El tamanio del "
          + "lote es inferior al rango asignado para ese volumen. Edite tabla 'Rangos'.</html>";
  private List<Integer> controlesList;
  private File file;
  private JFrame frame;
  private JLabel infoLabel;
  private int idDocumento, idVerificacion;
  private JFrame panelControl;
  //
  private int tamanio, muestra, idRango;
  private static String extension;
  private static List<Object> imageList;
  private static List<Object> finalImageList;
//  private File[] listoffiles ;
  private SearchImagesFromFiles searchImages;
  
  public GetFinalListOfImages(JFrame frame, JLabel infoLabel, List<Integer> controlesList, File file, int idDocumento, int idVerificacion) {
    this.controlesList = controlesList;
    this.file = file;
    this.frame = frame;
    this.infoLabel = infoLabel;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
     searchImages = new SearchImagesFromFiles(infoLabel, file);

  }
  public GetFinalListOfImages(JFrame frame, JLabel infoLabel, List<Integer> controlesList, int idDocumento, int idVerificacion, TryFilechooser chooser) {
    this.controlesList = controlesList;
//    this.listoffiles = files;
    this.frame = frame;
    this.infoLabel = infoLabel;
    this.idDocumento = idDocumento;
    this.idVerificacion = idVerificacion;
     searchImages = new SearchImagesFromFiles(infoLabel, chooser);

  }

  @Override
  protected Void doInBackground() {

    imageList = searchImages.getImageList();
    finalImageList = new SwitchImageList(infoLabel).switchExtension(imageList);
    tamanio = finalImageList.size();
    System.out.println(tamanio);
    
    SelectTamanioMuestra muestrafromRango = new SelectTamanioMuestra(tamanio);
    muestra = SelectTamanioMuestra.getMuestra();
    idRango = SelectTamanioMuestra.getIdRango();
    infoLabel.setText("Tamanio " + tamanio + ", muestra " + muestra + ", rango id " + idRango);
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

            WorkerImage worker = new WorkerImage(frame, infoLabel, controlesList, finalImageList, idDocumento, idVerificacion, getMuestra(), getIdRango());
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
