/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package documents;

import entidad.ImagenInsertada;
import entidad.Sublote;
import database.Conexion;
import database.SelectLastID;
import helper.GetIdandExtensionImg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * busca las imagenes que contiene el documento.
 * @author aguilangeles@gmail.com
 */
public class GetListOfImagesForDoc {

  private Conexion conexion;
  private int idSublote = 0;
  private List<Sublote> subloteList = new ArrayList<>();
  private SwitchImagesForDocument imagesList = new SwitchImagesForDocument();

  public GetListOfImagesForDoc(Conexion conexion, List<Object> objectList, int idtraza) {
    int idImagen = GetIdandExtensionImg.getIdImagen();
    this.conexion = conexion;
    getImagenes(objectList, idtraza, idImagen);
  }

  private void getImagenes(List<Object> objectList, int idTraza, int idImagen) {
    Sublote sublote = null;
    idSublote = new SelectLastID(conexion, "sublotes").getUltimoID();
    for (Iterator<Object> it = objectList.iterator(); it.hasNext();)
      {
      String path = (String) it.next();
      if (idImagen == 1)
        {
        getPagesOfDocument(path, idTraza);
        } else
        {
        getImagesOfDocument(path, idTraza);
        }
      }
  }//fin

  private void getPagesOfDocument(String path, int idtraza) {
    Sublote sublote;
    idSublote++;
    List<ImagenInsertada> lista = imagesList.getPagesPDF(path, idSublote);
    sublote = new Sublote(idSublote, idtraza, path, 0, lista, lista.size());
    subloteList.add(sublote);
  }

  private void getImagesOfDocument(String path, int idTraza) {
    Sublote sublote;
    idSublote++;
    List<ImagenInsertada> lista = imagesList.getImages(path, idSublote);//iterarFilesList(path, idSublote);
    sublote = new Sublote(idSublote, idTraza, path, 0, lista, lista.size());
    subloteList.add(sublote);
  }
  public List<Sublote> getSubloteList() {
    return subloteList;
  }
}
