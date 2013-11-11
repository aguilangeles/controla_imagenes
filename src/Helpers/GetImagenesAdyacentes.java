/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.File;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetImagenesAdyacentes {

  private String imagenAnterior;
  private String imagenPosterior;
  private String prex;
  private String nombreA, nombreP;

  public GetImagenesAdyacentes(String ruta) {
    File file = new File(ruta);
    File dir = new File(file.getParent());
    File[] files = dir.listFiles();
    for (int i = 0; i < files.length; i++)
      {
      File file1 = files[i];
      if (file1.equals(file))
        {
        int imin = i - 1;
        int imas = i + 1;
        this.imagenAnterior = (files[imin]).toString();
        this.imagenPosterior = (files[imas]).toString();
        this.nombreA = files[imin].getName().toString();
        this.nombreP = files[imas].getName().toString();
        }
      }
  }

  public String getNombreA() {
    return nombreA;
  }

  public String getNombreP() {
    return nombreP;
  }


  public String getImagenAnterior() {
    return imagenAnterior;
  }

  public String getImagenPosterior() {
    return imagenPosterior;
  }

  @Override
  public String toString() {
    return "GetImagenesAdyacentes{" + "nombreA=" + nombreA + ", nombreP=" + nombreP + '}';
  }

}
