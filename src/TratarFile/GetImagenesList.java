/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import Helpers.GetExtensionIdImagen;
import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetImagenesList {

  public GetImagenesList(List<Object> lista) {
    System.out.println("idimagen " + GetExtensionIdImagen.getIdImagen());
    System.out.println("extension " + GetExtensionIdImagen.getImgExt());
    getImagenes(lista);
  }

  private void getImagenes(List<Object> list) {
    for (Iterator<Object> it = list.iterator(); it.hasNext();)
      {
      String object = (String) it.next();
      iterarFiles(new File(object));
      }
  }

  private void iterarFiles(File file) {
    File[] files = file.listFiles();
    for (int i = 0; i < files.length; i++)
      {
      File file1 = files[i];
      System.out.println(file1.getName());
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
