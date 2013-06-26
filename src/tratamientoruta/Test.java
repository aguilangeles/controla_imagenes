/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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
public class Test {
       private static String path="C:\\Angeles\\reducido\\";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        String nombre ="C:\\Angeles\\reducido\\FRP_20130507_002\\FRP_0001_2013-05-07_11-00-58.pdf";
        ListaRutas rutas = new ListaRutas();
        List<ListaRutas.Pagina> ruta = rutas.cargarLista();
        String name="";
        for (ListaRutas.Pagina p : ruta) {
            name = p.getNombre();
//            System.out.println(p.getNombre());
            int numero = p.getNumero()-1;
//            convertir(name, numero);
        }
    }
    public static String temporal(String nombre, int numero){
        String ret = nombre.substring(path.length(), nombre.length()-4)+"_"+numero;
        String dosRet = ret.replace("\\", "_");

        return dosRet;
    }

    private static void convertir(String nombre, int numero) {
        try {
            PDDocument document = null;
            document = PDDocument.load(new File(nombre));//try
            PDPage page = ((PDPage) document.getDocumentCatalog().getAllPages().get(numero));
            BufferedImage image = page.convertToImage();
            ImageIO.write(image, "jpg", new File("temp\\" +temporal(nombre, numero)+ ".jpg"));
            System.out.println("temp\\" +temporal(nombre, numero)+ ".jpg");
            document.close();
            //                System.out.println(nombre + "-" + numero);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
