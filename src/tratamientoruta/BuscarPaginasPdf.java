/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import Entidades.Pdf_NombreMasNumero;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.pdfbox.pdmodel.PDDocument;
import Helpers.IdentificarExtension;

/**
 *
 * @author MUTNPROD003
 */
public class BuscarPaginasPdf {
    private List<Object> listaPaginas = new ArrayList<>();

    public BuscarPaginasPdf() {
        encontrarPaginas();
    }


    private void encontrarPaginas() {
        for (Iterator<Object> it = IdentificarExtension.getLista().iterator(); it.hasNext();) {
            Object object = it.next();
            try {
                String ruta = (String) object;
                File file = new File(ruta);
                PDDocument pddDocument = PDDocument.load(file.getAbsolutePath());
                int pagina = pddDocument.getDocumentCatalog().getAllPages().size();
                for (int i = 0; i < pagina; i++) {
                   Pdf_NombreMasNumero  page = new Pdf_NombreMasNumero(ruta, i);
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
