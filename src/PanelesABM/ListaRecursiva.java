/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import tratamientoruta.TipoDeImagen;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ListaRecursiva {

  private JLabel infoLabel;
  private File file;
  private static String extension;
  private static List<Object> listaExtension =new ArrayList<>();

  public ListaRecursiva(JLabel infoLabel,File file) {
    this.infoLabel = infoLabel;
    buscarExtensiones(file);
  }
  
  private void buscarExtensiones(File aFile) {
    File[] files = aFile.listFiles();
    for (int x = 0; x < files.length; x++) {
      String name = files[x].getName();
      infoLabel.setText("Analizando..." + name);
      boolean ext = (name.endsWith(".tif")//
              || name.endsWith(".pdf")
              || name.endsWith(".jpg")
              || name.endsWith(".png")) ? true : false;
      if (files[x].isDirectory()) {
        buscarExtensiones(files[x]);
      }
      if (ext) {
        TipoDeImagen stringImage = new TipoDeImagen(name);
        extension = (stringImage.getExtension());
        listaExtension.add(files[x].getAbsolutePath());
      }
    }
  }

  public String getExtension() {
    return extension;
  }

  public List<Object> getListaExtension() {
    return listaExtension;
  }

}
