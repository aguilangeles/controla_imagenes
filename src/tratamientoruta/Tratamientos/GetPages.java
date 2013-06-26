/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta.Tratamientos;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import tratamientoruta.PaginaPdf;

/**
 *
 * @author MUTNPROD003
 */
public class GetPages {
    private List<Object> listaPaginas = new ArrayList<>();
    public GetPages() {


        getPagesPdf();
    }


    private void getPagesPdf() {
        for (Iterator<Object> it = EncontrarExtension.getLista().iterator(); it.hasNext();) {
            Object o = it.next();
            try {
                String ruta = (String) o;
                File file = new File(ruta);
                PDDocument pddDocument = PDDocument.load(file.getAbsolutePath());
                int pagina = pddDocument.getDocumentCatalog().getAllPages().size();
                for (int i = 0; i < pagina; i++) {
                   PaginaPdf  page = new PaginaPdf(ruta, i);
                    listaPaginas.add(page);
                }
                pddDocument.close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public List<Object> getLista() {
        return listaPaginas;
    }

    public void setLista(List<Object> lista) {
        this.listaPaginas = lista;
    }

}
