/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

/**
 *
 * @author MUTNPROD003
 */
public class PdfBox {
private List<String> rutas = new ArrayList<>();
    public void Convertir(String path, String pdf){
        try {
            PDDocument document = null;
            document = PDDocument.load(new File(path+pdf));
            int num_pages = document.getNumberOfPages();
            List pages = document.getDocumentCatalog().getAllPages();
            for(int i = 0; i<num_pages-1;i++){
                PDPage page =(PDPage) pages.get(i);
                BufferedImage image =page.convertToImage();
                ImageIO.write(image, "jpg", new File(path+"tmp_"+i+".jpg"));
                String ruta =(path+"tmp_"+i+".jpg");
                System.out.println(ruta);
//                rutas.add(ruta);

            }
            document.close();
        } catch (IOException ex) {
            Logger.getLogger(PdfBox.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public List<String> getRutas() {
        return rutas;
    }

}
