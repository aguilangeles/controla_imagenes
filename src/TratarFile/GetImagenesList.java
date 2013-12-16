/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import BasedeDatos.Conexion;
import BasedeDatos.GetUltimoIDInsertado;
import Entidades.NombrePaginaDelPDF;
import Helpers.GetExtensionIdImagen;
import VentanaPrincipal.WorkerSubLote;
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
  private List<Sublote> subloteList = new ArrayList<>();
  private Conexion conexion;

  public GetImagenesList(List<Object> lista, Conexion conexion) {
    int idImagen = GetExtensionIdImagen.getIdImagen();
    int traza = WorkerSubLote.getIdTraza();
    this.conexion = conexion;
    getImagenes(lista, idImagen, traza);
  }

  private void getImagenes(List<Object> list, int id, int idTraza) {
    Sublote sublote = null;
    contador = new GetUltimoIDInsertado(conexion, "sublotes").getUltimoID();
    for (Iterator<Object> it = list.iterator(); it.hasNext();)
      {
      String path = (String) it.next();
      if (id == 1)
        {
        getPagesOfDocument(path, idTraza);
        } else
        {
        getImagesOfDocument(path, idTraza);
        }
      }
  }//fin

  public List<Sublote> getSubloteList() {
    return subloteList;
  }

  private List<ImagenInsertada> iterarFilesList(String ruta, int idsubolote) {
    List<ImagenInsertada> lista = new ArrayList<>();
    ImagenInsertada imagenes = null;
    File file = new File(ruta);
    File[] files = file.listFiles();
    for (int i = 0; i < files.length; i++)
      {
      File file1 = files[i];
      imagenes = new ImagenInsertada(idsubolote, file1.getName(), 0);
      lista.add(imagenes);
      }
    return lista;
  }

  private List<ImagenInsertada> getPagesPDF(String astring, int contador) {
    List<ImagenInsertada> lista = new ArrayList<>();
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
        lista.add(imagenes);
        }
      pddDocument.close();
      } catch (IOException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Encontrar Paginas PDF", JOptionPane.ERROR_MESSAGE);
      }
    return lista;
  }

  public static String getParent() {
    return parent;
  }

  private void getPagesOfDocument(String path, int idtraza) {
    Sublote sublote;
    contador++;
    List<ImagenInsertada> lista = getPagesPDF(path, contador);
    sublote = new Sublote(contador, idtraza, path, 0, lista, lista.size());
    subloteList.add(sublote);
  }

  private void getImagesOfDocument(String path, int idTraza) {
    Sublote sublote;
    contador++;
    List<ImagenInsertada> lista = iterarFilesList(path, contador);
    sublote = new Sublote(contador, idTraza, path, 0, lista, lista.size());
    subloteList.add(sublote);
  }
}
