/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import helper.Jpg;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.SwingWorker;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author MUTNPROD003
 */
public class ImagenesWorker extends SwingWorker<Object, Object> {
       private static final String FORMATO =".jpg";
    private String parent;
    private String absolutaPdf;
    private int pagina;
    private String ruta_archivo;



   public ImagenesWorker(String ruta_archivo, String parent, int pagina) {
            this.parent=parent;
            this.pagina=pagina;
            this.ruta_archivo = ruta_archivo;

    }
    @Override
    public String doInBackground() throws Exception {
        PDDocument document = PDDocument.load(new File(ruta_archivo)); //try
        PDPage page = (PDPage) document.getDocumentCatalog().getAllPages().get(pagina);
        BufferedImage image = page.convertToImage(BufferedImage.SCALE_SMOOTH,200);
        ImageIO.write(image, "png", new File("temp\\" + new Jpg(ruta_archivo, parent, pagina).jpgFile() + FORMATO));
        String ruta ="temp\\" + new Jpg(ruta_archivo, parent, pagina).jpgFile() + FORMATO;
        document.close();
        return ruta;
    }
}
