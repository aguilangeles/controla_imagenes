/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import java.io.File;
import java.util.List;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class RecursiveFromIdc {

  private List<Object> lista;

  public RecursiveFromIdc(List<Object> lista, boolean ispdf, boolean istif) {
    this.lista = lista;
    for (Object obj : lista)
      {
      File file1 = new File((String) obj);
      /*aca el booleano */
      iterarIdcTif(file1);
      }
  }

  private void iterarIdcTif(File file) {
    File[] listOfFiles = file.listFiles();
    for (int i = 0; i < listOfFiles.length; i++)
      {
      File file1 = listOfFiles[i];
      boolean istif = (file1.getName().endsWith(".tif")) ? true : false;
      if (file1.isDirectory())
        {
        iterarIdcTif(file1);
        }
      if (istif)
        {
        System.out.println(file1.getAbsolutePath());
        }
      }

  }
}
