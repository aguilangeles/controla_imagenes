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
public class ListaRecursiva {

  private JLabel infoLabel;
  private File file;
  private String extension;
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
      controlFinal(files[x].getAbsolutePath(), name);
      }
  }

  public String getExtension() {
    return extension;
  }

  public List<Object> getListaExtensionImagen() {
    return listaExtension;
  }

  private List<String> endwith() {
    List<String> end = new ArrayList<>();
    end.add(".tif");
    end.add(".TIF");
    end.add(".tiff");
    end.add(".TIFF");
    end.add(".png");
    end.add(".PNG");
    end.add(".jpg");
    end.add(".JPG");
    end.add(".jpeg");
    end.add(".JPEG");
    end.add(".pdf");
    end.add(".PDF");
    return end;
  }

  private void controlFinal(Object o, String filename) {
    for (String astring : endwith())
      {
      if (filename.endsWith(astring))
        {
        extension = (astring);
        listaExtension.add(o);
        Collections.shuffle(listaExtension);
        }
      }
  }
}
