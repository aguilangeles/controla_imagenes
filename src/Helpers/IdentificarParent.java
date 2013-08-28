/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.File;


/**
 *busca la Ruta Completa del Lote
 * 
 * @author MUTNPROD003
 */
public final class IdentificarParent {
    private String parent;
    public IdentificarParent(File[] files) {
        this.parent= encontrarParent2(files);
    }

  private String encontrarParent2(File[] files) {
    String ret = (files[0].getParent());
    for (int x = 0; x < files.length; x++) {
      if (files[x].isDirectory()) {
      }
    }
    return ret;
  }

    public String getParent() {
        return parent;
    }


}
