/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import Entidades.NombrePaginaDelPDF;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.swing.JLabel;
import org.apache.pdfbox.pdmodel.PDDocument;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class BuscarPaginasPdf {

  private List<Object> listaPaginas = new ArrayList<>();

  public BuscarPaginasPdf(List<Object> listaD, JLabel infoLabel) {
    encontrarPaginas(listaD, infoLabel);
  }

  private void encontrarPaginas(List<Object> listaD, JLabel infoLabel) {
    for (Iterator<Object> it = listaD.iterator(); it.hasNext();)
      {
      Object object = it.next();
      try
        {
        String ruta = (String) object;
        File file = new File(ruta);
        PDDocument pddDocument = PDDocument.load(file.getAbsolutePath());
        int pagina = pddDocument.getDocumentCatalog().getAllPages().size();
        for (int i = 0; i < pagina; i++)
          {
          NombrePaginaDelPDF page = new NombrePaginaDelPDF(ruta, i);
          listaPaginas.add(page);
          Collections.shuffle(listaPaginas);
          infoLabel.setText("<html>" + page.toString() + "</html>");
          }
        pddDocument.close();
        } catch (IOException ex)
        {
        JOptionPane.showMessageDialog(null, ex.getMessage(),
                "Encontrar Paginas PDF", JOptionPane.ERROR_MESSAGE);
        }
      }
  }

  public List<Object> getListaPaginas() {
    return listaPaginas;
  }

  public void setLista(List<Object> lista) {
    this.listaPaginas = lista;
  }
}
