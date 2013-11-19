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
  private List<Object> listaIdc = new ArrayList<>();
  private static boolean tif, pdf;

  public ListaRecursivaSublote(JLabel infoLabel, File file) {
    this.infoLabel = infoLabel;
    buscarSublotes(file);
  }

  private void buscarSublotes(File aFile) {
    File[] files = aFile.listFiles();
    for (int x = 0; x < files.length; x++)
      {
      String name = files[x].getName();
      infoLabel.setText("Analizando..." + name);
      boolean ext = (name.endsWith(".pdf")) ? true : false;
      boolean numeral = (name.contains("#")) ? true : false;
      if (files[x].isDirectory())
        {
        buscarSublotes(files[x]);
        }
      if (numeral)
        {
        pdf = false;
        tif = true;
        listaIdc.add(files[x].getAbsolutePath());
        Collections.shuffle(listaIdc);
        } else if (ext)
        {
        pdf = true;
        tif = false;
        listaIdc.add(files[x].getAbsolutePath());
        Collections.shuffle(listaIdc);
        }
      }
  }

  public List<Object> getListaIdc() {
    return listaIdc;
  }

  public static boolean isTif() {
    return tif;
  }

  public static boolean isPdf() {
    return pdf;
  }
  
}
