/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import entidad.NombrePaginaDelPDF;
import helper.MensajeJoptionPane;
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

  public BuscarPaginasPdf(List<Object> objectList, JLabel infoLabel) {
    encontrarPaginas(objectList, infoLabel);
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
        MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
        msg.getMessage(ex.getMessage(), BuscarPaginasPdf.class.getName());
        }
      }
  }

  public List<Object> getListaPaginas() {
    return listaPaginas;
  }

 }
