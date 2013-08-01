/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;
import Entidades.Pdf_NombreMasNumero;
import tratamientoruta.Sublote;
import Entidades.VolumenPDF;
import javax.swing.JOptionPane;


/**
 *
 * @author MUTNPROD003
 */
public class PDF_listarDirectorio {
    private List<VolumenPDF> lista;
    private List<Pdf_NombreMasNumero> listaFiles=new ArrayList<>();
    private String parent;

    public void listarDirectorio(File f) {
        lista = new ArrayList<>();
        int contador = 0;
        File[] files = f.listFiles();
        parent = files[1].getParent();
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
                contador++;
                String absolutePath = files[x].getAbsolutePath();
                VolumenPDF directorio = new VolumenPDF(contador, absolutePath, null);
                lista.add(directorio);
            }
        }
    }

    public void listarDeep() {
        for (VolumenPDF volumen : getLista()) {
            File f = new File(volumen.getAbsolutePath());
            volumen.setSublotes(listarDirectorio_1(f));
        }
    }
        public List<Sublote> listarDirectorio_1(File f) {
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
                    int pagina = doc.getDocumentCatalog().getAllPages().size();
                    sublote = new Sublote(contador, absolutePath, getParent(), fileName, pagina);
                  //  System.out.println("sublote  \t"+ sublote);
                    listSub.add(sublote);
                    doc.close();
                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Listar Directorios", JOptionPane.ERROR_MESSAGE);

//                    Logger.getLogger(Worker.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }//fin for
        return listSub;
    }
    public int iterarLista() {
        int contador = 0;
        for (VolumenPDF v : getLista()) {
            for (Sublote sub : v.getSublotes()) {
                for (Pdf_NombreMasNumero pdf : sub.getPdfpagina()) {
                    contador++;
                    listaFiles.add(pdf);
                }
            }
        }
        return contador;

    }
    public List<VolumenPDF> getLista() {
        return lista;
    }

    public void setLista(List<VolumenPDF> lista) {
        this.lista = lista;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public List<Pdf_NombreMasNumero> getListaFiles() {
        return listaFiles;
    }

    public void setListaFiles(List<Pdf_NombreMasNumero> listaFiles) {
        this.listaFiles = listaFiles;
    }

}
