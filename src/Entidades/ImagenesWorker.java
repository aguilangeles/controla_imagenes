/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import helper.ExtensionTemporal;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.SwingWorker;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
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
    private String rutaEnTemporal;

    public ImagenesWorker(String ruta_archivo, String parent, int pagina) {
        this.rutaConPagina = ruta_archivo + "[" + pagina + "]";
        this.rutaEnTemporal = new ExtensionTemporal(ruta_archivo, parent, pagina).getRutaTemporal();

    }

    @Override
    public String doInBackground() {
        File input = new File(rutaConPagina);
        File output = new File(rutaEnTemporal);
        try {
            IMOperation operation = new IMOperation();
            operation.density(300);
            operation.addImage();
            operation.addImage();
            ConvertCmd convert = new ConvertCmd();
            convert.setSearchPath(IM4JAVA_TOOLPATH);
            try {
                convert.run(operation, new Object[]{input.getAbsolutePath(), output.getAbsolutePath()});
            } catch (IOException | InterruptedException ex) {
                Logger.getLogger(ImagenesWorker.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IM4JavaException e) {
            System.out.println("im4java exception");
            System.out.println(e.getMessage());
        }
        System.out.println(output.getAbsolutePath());
        System.out.println(rutaEnTemporal);
        return output.getAbsolutePath();
    }
}
