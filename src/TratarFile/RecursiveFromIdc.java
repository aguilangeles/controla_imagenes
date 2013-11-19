/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import Entidades.NombrePaginaDelPDF;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class RecursiveFromIdc {

  private List<Object> lista;

  public RecursiveFromIdc(List<Object> lista, boolean ispdf, boolean istif) {
    this.lista = lista;
    for (Object obj : lista)
      {
      File file1 = new File((String) obj);
      if (istif)
        {
        iterarIdcTif(file1);

        }
      if (ispdf)
        {
        iterarSubLotePdf(file1);
        }
      /*aca el booleano */
      }
  }

  private void iterarIdcTif(File file) {
    File[] listOfFiles = file.listFiles();
    for (int i = 0; i < listOfFiles.length; i++)
      {
      File file1 = listOfFiles[i];
      boolean istif = (file1.getName().endsWith(".tif"))
              || (file1.getName().endsWith(".jpg"))
              || (file1.getName().endsWith(".png")) ? true : false;
      if (file1.isDirectory())
        {
        iterarIdcTif(file1);
        }
      if (istif)
        {
        System.out.println(file1.getAbsolutePath());
        }
      }
  }

  private void iterarSubLotePdf(File file) {
    try
      {
      PDDocument pddDocument = PDDocument.load(file.getAbsolutePath());
      int pagina = pddDocument.getDocumentCatalog().getAllPages().size();
      for (int i = 0; i < pagina; i++)
        {
        NombrePaginaDelPDF page = new NombrePaginaDelPDF(file.getName(), i);
        System.out.println("page pdf " + page);
        }
      } catch (IOException ex)
      {
      Logger.getLogger(RecursiveFromIdc.class.getName()).log(Level.SEVERE, null, ex);
      }
  }
}
