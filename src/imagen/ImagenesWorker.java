/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

import database.Conexion;
import entidad.LogQualitys;
import helper.ExtensionTemporal;
import helper.MensajeJoptionPane;
import java.io.File;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;
import org.im4java.core.Info;
import org.im4java.core.InfoException;
import org.im4java.process.ProcessStarter;

/**
 * Convierte el pdf en un jpg gracias al image magick
 *
 * @author MUTNPROD003
 */
public class ImagenesWorker extends SwingWorker<Object, String> {

  private static final String className = ImagenesWorker.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private String IM4JAVA_TOOLPATH;
//  private static final String IM4JAVA_TOOLPATH = "C:\\Program Files (x86)\\ImageMagick-6.8.6-Q16";
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
    File outputTemp = null;
    try
    {
      String rutaEnTemporal = new ExtensionTemporal(ruta_archivo, parent, pagina).getRutaTemporal() + "_t_";
      outputTemp = File.createTempFile(rutaEnTemporal, ".png", new File("temp"));
      try
      {
	String myPath = "C:\\ImageMagick-6.8.6-Q16";
	ProcessStarter.setGlobalSearchPath(myPath);

	IMOperation operation = new IMOperation();
	operation.density(200);
	operation.quality(80D);
	operation.depth(16);
	operation.addImage();
	operation.addImage();
	ConvertCmd convert = new ConvertCmd();
	convert.setSearchPath(IM4JAVA_TOOLPATH);
	convert.run(operation, new Object[]
	{
	  input.getAbsolutePath(), outputTemp.getAbsolutePath()
	});
	operation.closeOperation();

      } catch (IOException | InterruptedException | IM4JavaException ex)
      {
	msg.getMessage(ex.getMessage(), className);
	System.out.println(ex.getMessage());
	System.exit(0);
      }
    } catch (IOException ex)
    {
      msg.getMessage(ex.getMessage(), className);
    }
    outputTemp.deleteOnExit();
    return outputTemp.getAbsolutePath();
  }

  private void getInfoOriginalImage(File input) throws InfoException {
    Info imageInfo = new Info(input.getAbsolutePath(), true);
    System.out.println("Format: " + imageInfo.getImageFormat());
    System.out.println("Page Geometry: " + imageInfo.getPageGeometry());
    System.out.println("Width: " + imageInfo.getImageWidth());
    System.out.println("Height: " + imageInfo.getImageHeight());
    System.out.println("Geometry: " + imageInfo.getImageGeometry());
    System.out.println("Depth: " + imageInfo.getImageDepth());
    System.out.println("Class: " + imageInfo.getImageClass());
  }
}
