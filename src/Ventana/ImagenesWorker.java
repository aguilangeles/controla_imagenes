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
import javax.swing.SwingWorker;
import org.im4java.core.ConvertCmd;
import org.im4java.core.IM4JavaException;
import org.im4java.core.IMOperation;

/**
 *
 * @author MUTNPROD003
 */
public class ImagenesWorker extends SwingWorker<Object, Object> {

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
        String rutaEnTemporal = new ExtensionTemporal(ruta_archivo, parent, pagina).getRutaTemporal() + ".jpg";
        File input = new File(rutaConPagina);
        File output = new File(rutaEnTemporal);
        try {
            IMOperation operation = new IMOperation();
            operation.density(300);
            operation.quality(100D);
            operation.depth(8);
            operation.addImage();
            operation.addImage();
            ConvertCmd convert = new ConvertCmd();
            convert.setSearchPath(IM4JAVA_TOOLPATH);
            convert.run(operation, new Object[]{input.getAbsolutePath(), output.getAbsolutePath()});
        } catch (IOException ex) {
            Logger.getLogger(ImagenesWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InterruptedException ex) {
            Logger.getLogger(ImagenesWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IM4JavaException ex) {
            Logger.getLogger(ImagenesWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output.getAbsolutePath();
    }
}
