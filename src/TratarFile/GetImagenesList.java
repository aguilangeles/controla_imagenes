/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetImagenesList {

  public GetImagenesList(List<Object> lista) {
    getImagenes(lista);
  }

  private void getImagenes(List<Object> list) {
    for (Iterator<Object> it = list.iterator(); it.hasNext();)
      {
      String object = (String) it.next();
//      identificarPdf(object);
      iterarFiles(new File(object));
      }
  }

  private void iterarFiles(File file) {
    if (file.getName().endsWith(".pdf"))
      {
      System.out.println("es pdf " + file);

      } else
      {

      File[] files = file.listFiles();
      for (int i = 0; i < files.length; i++)
        {
        File file1 = files[i];
          System.out.println(file1.getName());
        boolean isImage = isimage(file1.getName());
        if (file1.isDirectory())
          {
          iterarFiles(file1);
          }
        if (isImage)
          {
          System.out.println("no pdf " + file1);
          }
        }
      }
  }

  private boolean isimage(String image) {
    boolean isimg;
    if (image.endsWith(".tif")
            || image.endsWith(".TIF")
            || image.endsWith(".TIFF")
            || image.endsWith(".tiff")
            || image.endsWith(".jpg")
            || image.endsWith(".png"))
      {
      isimg = true;
      } else
      {
      isimg = false;
      }
    return isimg;
  }
}
