/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import java.io.File;

/**
 * busca la Ruta Completa del Lote
 *
 * @author MUTNPROD003
 */
public final class GetParentName {

  private static String parent;

  public GetParentName(File[] files) {
    parent = encontrarParent2(files);
  }

  private static String encontrarParent2(File[] files) {
    String ret = (files[0].getParent());
    for (int x = 0; x < files.length; x++)
      {
      if (files[x].isDirectory())
        {
        }
      }
    return ret;
  }

  public static String getParent() {
    return parent;
  }
}
