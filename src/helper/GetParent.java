/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;

/**
 * busca la Ruta Completa del Lote
 *
 * @author MUTNPROD003
 */
public final class GetParent {

  private static String parent;

  public GetParent(File[] files) {
    parent = searchParent(files);
  }

  private static String searchParent(File[] files) {
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
