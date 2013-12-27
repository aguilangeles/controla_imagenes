/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import Helpers.GetExtensionIdImagen;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ListaRecursiva {

  private JLabel infoLabel;
  private List<Object> listaExtension = new ArrayList<>();

  public ListaRecursiva(JLabel infoLabel, File file) {
    this.infoLabel = infoLabel;
    buscarExtensiones(file);
  }

  private void buscarExtensiones(File aFile) {
    File[] files = aFile.listFiles();
    for (int x = 0; x < files.length; x++)
      {
      String name = files[x].getName();
      infoLabel.setText("Analizando..." + name);
      if (files[x].isDirectory())
        {
        buscarExtensiones(files[x]);
        }
      extraerExtensionImagen(files[x]);
      }
  }

  private void extraerExtensionImagen(File file) {
    String fin = file.getName();
    if (fin.contains("."))
      {
      String[] spl = fin.split("\\.");
      String exts = spl[1];
      if (!exts.equalsIgnoreCase("txt") && !exts.equalsIgnoreCase("xml"))
        {
        GetExtensionIdImagen extensionIdImagen = new GetExtensionIdImagen(exts);
        listaExtension.add(file.getAbsolutePath());
        Collections.shuffle(listaExtension);
        }
      }
  }

  public List<Object> getListaExtensionImagen() {
    return listaExtension;
  }
}
