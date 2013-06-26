/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import com.sun.pdfview.PDFFile;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;


/**
 *
 * @author MUTNPROD003
 */
public final class NewClass {
    private static PDFFile pdfFile;
    private  List<VolumenPDF> lista ;
    private String parent;
    public NewClass(String ruta){
        File f = new File(ruta);
        listarDirectorio(f);
        listarDeep();
    }


    public void listarDirectorio(File f) {
        lista = new ArrayList<>();
        int contador = 0;
        File[] files = f.listFiles();
        parent =files[1].getParent();
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
                contador++;
                String absolutePath =files[x].getAbsolutePath();

                VolumenPDF directorio = new VolumenPDF(contador,absolutePath, null);
                 directorio = new VolumenPDF(contador,absolutePath, null);
                lista.add(directorio);
            }
        }//fin for
    }
    public  List<Sublote> listarDirectorio_1(File f) {
        Sublote sublote;
        List<Sublote> listSub = new ArrayList<>();
        boolean pdf;
        int contador = 0;
        File[] files = f.listFiles();
        for (int x = 0; x < files.length; x++) {
            pdf = (files[x].getName().endsWith(".pdf")) ? true : false;
            if (pdf) {
                try {
                    contador++;
                    String absolutePath = (files[x].getAbsolutePath());
                    String fileName = (files[x].getName());
                    PDDocument doc = PDDocument.load(absolutePath);
                    int pagina =doc.getDocumentCatalog().getAllPages().size();
                    sublote = new Sublote(contador, absolutePath, getParent(), fileName, pagina);
                    listSub.add(sublote);
                    doc.close();
                } catch (IOException ex) {
                    Logger.getLogger(NewClass.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }//fin for
        return listSub;
    }

    public String getParent() {
        return parent;
    }



    private void listarDeep() {
        for (VolumenPDF p : lista) {
            File f = new File(p.getAbsolutePath());
            p.setSublotes(listarDirectorio_1(f));
        }
    }

    public  List<VolumenPDF> getLista() {
        return lista;
    }



}
