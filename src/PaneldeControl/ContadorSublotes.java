/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * identificar la cantidad de idc o sublotes para lograr un rango y un ramdom
 *
 * @author aguilangeles@gmail.com
 */
public class ContadorSublotes {

  private String extension;
  private int idImagen;
  private List<Object> listaIDc = new ArrayList<>();

  public ContadorSublotes(File file) {
    getCantidadSublotes(file);
  }

  private void getCantidadSublotes(File file) {
    File[] files = file.listFiles();
    for (int i = 0; i < files.length; i++)
      {
      File file1 = files[i];
      if (files[i].isDirectory())
        {
        getCantidadSublotes(file1);
        }
      extraerExtensionImagen(file1);
      }
  }

  private void extraerExtensionImagen(File file) {
    String ends = file.getName();
    if (ends.contains("."))
      {
      String[] splits = ends.split("\\.");
      String string = splits[1];
      if (!string.equalsIgnoreCase("txt") && !string.equalsIgnoreCase("xml"))
        {
        extension = string;
        if (file.getName().endsWith(string))
          {
          if (getExtension().equalsIgnoreCase("pdf"))
            {
            listaIDc.add(file.getAbsolutePath());
            Collections.shuffle(listaIDc);
            } else if (!listaIDc.contains(file.getParent()))
            {
            listaIDc.add(file.getParent());
            Collections.shuffle(listaIDc);
            }
          }
        }
      }
  }

  public String getExtension() {
    return extension;
  }

  public List<Object> getListaIDc() {
    return listaIDc;
  }

  public String getParent() {
    File file = new File((String) listaIDc.get(0));
    return file.getAbsolutePath();
  }
}
