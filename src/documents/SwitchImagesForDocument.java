/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documents;

import entidad.ImagenInsertada;
import entidad.NombrePaginaDelPDF;
import helper.GetExtensionNoDeseada;
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
        File[] files = file.listFiles();
        for (int i = 0; i < files.length; i++) {
            File file1 = files[i];
            String[] fin = file1.getName().split("\\.");
            String exts = fin[1];
            if (!GetExtensionNoDeseada.noDeseadosList().contains(exts)) {
                File neoFile = file1;
                imagenes = new ImagenInsertada(idsubolote, neoFile.getName(), 0);
                imagenList.add(imagenes);
            }
        }
        return imagenList;
    }
}
