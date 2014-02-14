/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documents;

import entidad.ImagenInsertada;
import entidad.NombrePaginaDelPDF;
import helper.MensajeJoptionPane;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author aguilangeles@gmail.com
 */
class SwitchImagesForDocument {

    public SwitchImagesForDocument() {
    }

    public List<ImagenInsertada> getPagesPDF(String astring, int contador) {
        List<ImagenInsertada> listaImagenesInsertadas = new ArrayList<>();
        ImagenInsertada imagenes;
        try {
            String ruta = astring;
            File file = new File(ruta);
            System.out.println("ruta " + file.getAbsolutePath());
            PDDocument pddDocument = PDDocument.load(file.getAbsolutePath());
            int pagina = pddDocument.getDocumentCatalog().getAllPages().size();
            for (int i = 0; i < pagina; i++) {
                NombrePaginaDelPDF page = new NombrePaginaDelPDF(file.getName(), i);
                imagenes = new ImagenInsertada(contador, file.getName(), i);
                listaImagenesInsertadas.add(imagenes);
            }
            pddDocument.close();
        } catch (IOException ex) {
            MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
            msg.getMessage(ex.getMessage(), SwitchImagesForDocument.class.getName());
        }
        return listaImagenesInsertadas;
    }

    public List<ImagenInsertada> getImages(String ruta, int idsubolote) {
        List<ImagenInsertada> imagenList = new ArrayList<>();
        ImagenInsertada imagenes = null;
        File file = new File(ruta);
        System.out.println("ruta " + file.getAbsolutePath());
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            imagenes = new ImagenInsertada(idsubolote, file1.getName(), 0);
            imagenList.add(imagenes);
        }
        return imagenList;
    }
}
