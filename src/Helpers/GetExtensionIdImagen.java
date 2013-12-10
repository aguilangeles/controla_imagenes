/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetExtensionIdImagen {

  private static int idImagen;
  private static String imgExt;

  public GetExtensionIdImagen(String extension) {
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

  private void identificarExtension(String extension) {
    String nombre = extension;
    for (String string : listaExtensiones())
      {
      if (nombre.equalsIgnoreCase(string))
        {
        imgExt = string;
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

  public static String getImgExt() {
    return imgExt;
  }
  
}
