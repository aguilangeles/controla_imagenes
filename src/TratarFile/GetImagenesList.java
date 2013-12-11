/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import Entidades.NombrePaginaDelPDF;
import Helpers.GetExtensionIdImagen;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetImagenesList {

  private static String parent;
  int contador = 0;
  int idtraza = 2;

  public GetImagenesList(List<Object> lista) {
    int id = GetExtensionIdImagen.getIdImagen();
    System.out.println("extension " + GetExtensionIdImagen.getImgExt());
    System.out.println("id " + GetExtensionIdImagen.getIdImagen());
    getImagenes(lista, id);
  }

  private void getImagenes(List<Object> list, int id) {
    Sublote sublote = null;
    for (Iterator<Object> it = list.iterator(); it.hasNext();)
      {
      String object = (String) it.next();
      System.out.println(object);
      if (id == 1)
        {
        getPagesPDF(object);
        } else
        {
        contador++;
        System.out.println(contador);
        List<ImagenInsertada> lista = iterarFilesList(new File(object), contador);
        sublote = new Sublote(contador, idtraza, object, 0, lista, lista.size());
        System.out.println(sublote);
//        iterarFiles(new File(object));
        }
      }
  }

//  private void iterarFiles(File file) {
//    File[] files = file.listFiles();
//    for (int i = 0; i < files.length; i++)
//      {
//      File file1 = files[i];
//
////      System.out.println(file1.getAbsolutePath());
//      }
//  }
  private List<ImagenInsertada> iterarFilesList(File file, int idsubolote) {
    List<ImagenInsertada> lista = new ArrayList<>();
    ImagenInsertada imagenes = null;
    File[] files = file.listFiles();
    for (int i = 0; i < files.length; i++)
      {
      File file1 = files[i];
      imagenes = new ImagenInsertada(i, idsubolote, file1.getName(), 0, 0);
      lista.add(imagenes);
      }
    return lista;
  }

  private void getPagesPDF(String astring) {
    try
      {
      String ruta = astring;
      File file = new File(ruta);
      parent = file.getParent();
      PDDocument pddDocument = PDDocument.load(file.getAbsolutePath());
      int pagina = pddDocument.getDocumentCatalog().getAllPages().size();
      for (int i = 0; i < pagina; i++)
        {
        NombrePaginaDelPDF page = new NombrePaginaDelPDF(ruta, i);
        System.out.println(page);
//          listaPaginas.add(page);
//          Collections.shuffle(listaPaginas);
//          infoLabel.setText("<html>" + page.toString() + "</html>");
        }
      pddDocument.close();
      } catch (IOException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Encontrar Paginas PDF", JOptionPane.ERROR_MESSAGE);
      }
  }

  public static String getParent() {
    return parent;
  }
}
