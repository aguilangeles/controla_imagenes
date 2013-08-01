/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Helpers.ExtensionTemporal;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

/**
 *
 * @author MUTNPROD003
 */
public class ImagenesWorker extends SwingWorker<Object, String> {

  private static final String IM4JAVA_TOOLPATH = "C:\\Program Files (x86)\\ImageMagick-6.8.6-Q16";
  private String rutaConPagina;
  private String ruta_archivo;
  private String parent;
  private int pagina;


  public ImagenesWorker(String ruta_archivo, String parent, int pagina) {
    this.rutaConPagina = ruta_archivo + "[" + pagina + "]";
    this.ruta_archivo = ruta_archivo;
    this.parent = parent;
    this.pagina = pagina;
  }

  @Override
  public String doInBackground() {
    File input = new File(rutaConPagina);
    File outputemp = null;
    try {
      String rutaEnTemporal = new ExtensionTemporal(ruta_archivo, parent, pagina).getRutaTemporal() + "_t_";
      outputemp = File.createTempFile(rutaEnTemporal, ".jpg", new File("temp"));
      try {
        IMOperation operation = new IMOperation();
        operation.density(300);
        operation.quality(100D);
        operation.depth(8);
        operation.addImage();
        operation.addImage();
        ConvertCmd convert = new ConvertCmd();
        convert.setSearchPath(IM4JAVA_TOOLPATH);
        convert.run(operation, new Object[]{input.getAbsolutePath(), outputemp.getAbsolutePath()});
        operation.closeOperation();
      } catch (IOException | InterruptedException | IM4JavaException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage(), "Construcción de imagenes desde PDF", JOptionPane.ERROR_MESSAGE);

//        Logger.getLogger(ImagenesWorker.class.getName()).log(Level.SEVERE, null, ex);
      }
    } catch (IOException ex) {
              JOptionPane.showMessageDialog(null, ex.getMessage(), "Construcción de imagenes desde PDF", JOptionPane.ERROR_MESSAGE);
//      Logger.getLogger(ImagenesWorker.class.getName()).log(Level.SEVERE, null, ex);
    }
    outputemp.deleteOnExit();
    return outputemp.getAbsolutePath();
  }



}
