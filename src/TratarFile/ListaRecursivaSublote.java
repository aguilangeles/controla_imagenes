/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ListaRecursivaSublote {

  private JLabel infoLabel;
  private File file;
  private String extension;
  private List<Object> listaExtension = new ArrayList<>();

  public ListaRecursivaSublote(JLabel infoLabel, File file) {
    this.infoLabel = infoLabel;
    buscarExtensiones(file);
  }

  private void buscarExtensiones(File aFile) {
    File[] files = aFile.listFiles();
    for (int x = 0; x < files.length; x++)
      {
      String name = files[x].getName();
      infoLabel.setText("Analizando..." + name);

      boolean ext = (name.endsWith(".tif")//
              || name.endsWith(".pdf")
              || name.endsWith(".jpg")
              || name.endsWith(".png")) ? true : false;
      if (files[x].isDirectory())
        {
          System.out.println("files x "+files[x]);
        buscarExtensiones(files[x]);
        }
      if (ext)
        {
        ExtensionImagen stringImage = new ExtensionImagen(name);
        extension = (stringImage.getExtension());
        listaExtension.add(files[x].getAbsolutePath());
        Collections.shuffle(listaExtension);
        }
      }
  }

  public String getExtension() {
    return extension;
  }

  public List<Object> getListaExtensionImagen() {
    return listaExtension;
  }
}
