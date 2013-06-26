package helper;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
/**
 * @web http://jc-mouse.blogspot.com/
 * @author Mouse
 */
public class convertir {

    public convertir(){
    }

    /* Convierte el documento PDF a imagen con un tamaño grande*/
//    public void Convertir_1(String path){
    public void Convertir_1(String path, String pdf){
    try {
        PDDocument document = null;
        //se carga el documento
        document = PDDocument.load(new File(path + pdf));
        //se obtiene el numero de paginas del PDF
        int numero_paginas = document.getNumberOfPages();
        System.out.println("texto: " + document.getNumberOfPages());
        //Se capturan todas las paginas
        List pages = document.getDocumentCatalog().getAllPages();
        //un ciclo repetitivo para crear todas las imagenes
        for(int i=0; i<=numero_paginas-1;i++){
            System.out.println( "creando imagen - " + i);
            //se obtiene la pagina "i" de n paginas
            PDPage page = (PDPage)pages.get( i );
            //se convierte la hoja pdf a imagen y se coloca en memoria
            BufferedImage image = page.convertToImage();
            // se escribe a imagen en disco
            ImageIO.write(image, "jpg", new File( "ImagenesTemp" + "tmp_" + i + ".jpg"));
            System.out.println( "imagen [" + i + "] creada");
        }
        document.close();//cerramos el pdf
    } catch (IOException ex) {
        System.out.println(ex.getMessage());
//        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /* Convierte el documento PDF a Imagen, escalando el archivo al
      tamaño de las hojas del PDF*/
//    public void Convertir_2(String path, String pdf){
//    try {
//        PDDocument document = null;
//        //se carga el documento
//        document = PDDocument.load(new File(path + pdf));
//        //se obtiene el numero de paginas del PDF
//        int numero_paginas = document.getNumberOfPages();
//        System.out.println("texto: " + document.getNumberOfPages());
//        //Se capturan todas las paginas
//        List pages = document.getDocumentCatalog().getAllPages();
//        //un ciclo repetitivo para crear todas las imagenes
//        for(int i=0; i<=numero_paginas-1;i++){
//            System.out.println( "creando imagen - " + i);
//            //se obtiene la pagina "i" de n paginas
//            PDPage page = (PDPage)pages.get( i );
//            //se convierte la hoja pdf a imagen y se coloca en memoria
//            BufferedImage image = page.convertToImage();
//            //ancho y alto de la pagina pdf
//            int w = (int) document.getPageFormat(i).getWidth();
//            int h = (int) document.getPageFormat(i).getHeight();
//            //se crea una nueva imagen en memoria con el tamaño de la hoja pdf
//            BufferedImage escala = new BufferedImage(w,h, BufferedImage.TYPE_INT_RGB);
//            Graphics2D graphics2D = escala.createGraphics();
//            graphics2D.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//            //se añade la imagen
//            graphics2D.drawImage(image, 0, 0, w, h, null);
//            // se escribe a imagen en disco
//            ImageIO.write(escala, "jpg", new File( path + "tmp_e" + i + ".jpg"));
//            System.out.println( "imagen [" + i + "] creada");
//        }
//        document.close();//cerramos el pdf
//    } catch (IOException ex) {
//        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//    }
//    }
}
