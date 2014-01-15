/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import Entidades.ImagenInsertada;
import Entidades.NombrePaginaDelPDF;
import Helpers.MensajeJoptionPane;
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
class GetPagesPDFList {
  private String parent;

  public GetPagesPDFList(String parent) {
    this.parent = parent;
  }


  public List<ImagenInsertada> getPagesPDF(String astring, int contador) {
    List<ImagenInsertada> listaImagenesInsertadas = new ArrayList<>();
    ImagenInsertada imagenes;
    try
      {
      String ruta = astring;
      File file = new File(ruta);
      parent = file.getParent();
      PDDocument pddDocument = PDDocument.load(file.getAbsolutePath());
      int pagina = pddDocument.getDocumentCatalog().getAllPages().size();
      for (int i = 0; i < pagina; i++)
        {
        NombrePaginaDelPDF page = new NombrePaginaDelPDF(file.getName(), i);
        imagenes = new ImagenInsertada(contador, file.getName(), i);
        listaImagenesInsertadas.add(imagenes);
        }
      pddDocument.close();
      } catch (IOException ex)
      {
      MensajeJoptionPane msg = new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE);
      msg.getMessage(ex.getMessage(), GetPagesPDFList.class.getName());
      }
    return listaImagenesInsertadas;
  }

  public String getParent() {
    return parent;
  }

}
