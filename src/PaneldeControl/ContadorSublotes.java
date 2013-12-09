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
 *
 * @author aguilangeles@gmail.com
 */
public class ContadorSublotes {

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
        boolean isImagen = ignore(file1, "Imagenes");
        boolean isBorrada = ignore(file1, "Borradas");
        if (!isImagen && !isBorrada)
          {
          encontrarSublote(file1);
          }
        }
      boolean ispdf = ignore(file1, ".pdf");
      if (ispdf)
        {
        listaIDc.add(file1.getAbsolutePath());
        Collections.shuffle(listaIDc);
        }
      }
  }

  private boolean ignore(File file, String name) {
    return file.getAbsolutePath().endsWith(name);
  }

  private void encontrarSublote(File file) {
    String name = file.getAbsolutePath();
    if (name.contains("SL"))
      {
      listaIDc.add(name);
      Collections.shuffle(listaIDc);
      } else if (name.contains("#"))
      {
      listaIDc.add(name);
      Collections.shuffle(listaIDc);
      }
  }

  public List<Object> getListaIDc() {
    return listaIDc;
  }

  public String getParent() {
    File file = new File((String) listaIDc.get(0));
    return file.getParent();
  }
}
