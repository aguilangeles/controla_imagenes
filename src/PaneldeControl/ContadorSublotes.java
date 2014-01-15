/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import helper.GetUltimaCarpeta;
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

  private static String parent;
  private static String extension;
  private List<Object> documentoList = new ArrayList<>();

  public ContadorSublotes(File file) {
    parent = (file.getAbsolutePath());
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
      String extString = splits[1];
      if (!extString.equalsIgnoreCase("txt") && !extString.equalsIgnoreCase("xml"))
        {
        extension = extString;
        if (file.getName().endsWith(extString))
          {
          if (getExtension().equalsIgnoreCase("pdf"))
            {
            documentoList.add(file.getAbsolutePath());
            Collections.shuffle(documentoList);
            } else if (!documentoList.contains(file.getParent()))
            {
            documentoList.add(file.getParent());
            Collections.shuffle(documentoList);
            }
          }
        }
      }
  }

  public static String getExtension() {
    return extension;
  }

  public static String getParent() {
    return parent;
  }

  public static String getUltimaCarpeta() {
    return GetUltimaCarpeta.getLastFolder(parent);
  }

  public List<Object> getDocumentoList() {
    return documentoList;
  }
}
