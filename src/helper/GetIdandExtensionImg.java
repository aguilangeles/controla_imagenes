/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetIdandExtensionImg {

  private static int idImagen;
  private static String extension;

  
  public GetIdandExtensionImg(String extension) {
    identificarExtension(extension);
  }

  private static List<String> listaExtensiones() {
    List<String> listaExtensiones = new ArrayList<>();
    String tif = "tif";
    String pdf = "pdf";
    String tiff = "tiff";
    String jpg = "jpg";
    String jpeg = "jpeg";
    String png = "png";
    listaExtensiones.add(tif);
    listaExtensiones.add(pdf);
    listaExtensiones.add(tiff);
    listaExtensiones.add(jpg);
    listaExtensiones.add(jpeg);
    listaExtensiones.add(png);
    return listaExtensiones;
  }

  private void identificarExtension(String exts) {
    for (String string : listaExtensiones())
      {
      if (exts.equalsIgnoreCase(string))
        {
        extension = string;
        switch (string)
          {
          case "pdf":
            idImagen = 1;
            break;
          case "tif":
          case "tiff":
            idImagen = 2;
            break;
          case "png":
          case "jpg":
          case "jpeg":
            idImagen = 3;
            break;
          }
        }
      }
  }

  public static int getIdImagen() {
    return idImagen;
  }

//  public static String getExtension() {
//    return extension;
//  }

}
