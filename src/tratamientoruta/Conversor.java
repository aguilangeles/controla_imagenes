/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import com.sun.pdfview.PDFFile;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public final class Conversor {
    private static PDFFile pdfFile;

    private  List<VolumenPDF> lista ;
    private  List<String> listaString ;
    private PdfBox boxConvertir;


    public Conversor(String ruta){
        File f = new File(ruta);
        listarDirectorio(f);
        listarDeep();
    }


    public void listarDirectorio(File f) {
        lista = new ArrayList<>();
        boolean pdf;
        PdfList listaPD = null;
        int contador = 0;
        File[] files = f.listFiles();
        String parent =files[1].getParent();
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
                contador++;
                String path =files[x].getPath();
                String absolutePath =files[x].getAbsolutePath();
                String sinParent = path.substring(parent.length());
                VolumenPDF directorio = new VolumenPDF(contador,  absolutePath, null);
                lista.add(directorio);
            }
        }//fin for
    }
    public  List<Sublote> listarDirectorio_1(File f) {
        Sublote sublote;
        List<Sublote> listSub = new ArrayList<>();
        boolean pdf;
        PdfList listaPD = null;
        int contador = 0;
        File[] files = f.listFiles();
        for (int x = 0; x < files.length; x++) {
            pdf = (files[x].getName().endsWith(".pdf")) ? true : false;
            if (pdf) {
                contador++;
                String ret = (files[x].getAbsolutePath());
                String fin = ret.substring(0, ret.length() - 3);
                String pdff = "pdf";
                boxConvertir = new PdfBox();
                boxConvertir.Convertir(fin, "pdf");
                   // String name = (files[x].getName());
                    //PDDocument doc = PDDocument.load(ret);
                    //int pagina =doc.getDocumentCatalog().getAllPages().size();
                    //sublote = new Sublote(contador, name, pagina);
                    //listSub.add(sublote);
                    //doc.close();


            }
        }//fin for
        return listSub;
    }

    public List<String> getListaString() {
        return boxConvertir.getRutas();
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



    private static class PdfList {
        private int id;
        private String nombre;
        private int paginas;

        public PdfList(int id, String nombre, int paginas) {
            this.id = id;
            this.nombre = nombre;
            this.paginas = paginas;
        }

        @Override
        public String toString() {
            return "PdfList{" + "id=" + id + ", nombre=" + nombre + ", paginas=" + paginas + '}';
        }


    }
}
