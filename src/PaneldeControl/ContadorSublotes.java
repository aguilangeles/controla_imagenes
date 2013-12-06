/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PaneldeControl;

import java.io.File;
import java.io.FileFilter;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ContadorSublotes {

  private int length1;
  private int length2;
  private FileFilter filefilter;

  public ContadorSublotes(File file) {
    this.filefilter = new FileFilter() {
      @Override
      public boolean accept(File pathname) {

        return pathname.getName().endsWith(".pdf");
      }
    };
    getCantidadSublotes(file);
  }

  private void getCantidadSublotes(File file) {
    int contador = 0;
    File[] files = file.listFiles();
    for (int i = 0; i < files.length; i++)
      {
      File file1 = files[i];
      boolean ispdf = (file1.getName().endsWith(".pdf")) ? true : false;
      if (files[i].isDirectory())
        {
        getCantidadSublotes(files[i]);
        }
      
      if (ispdf)
        {
        contador++;
        System.out.println(file1.getAbsolutePath());
        }
      }
  }

  public int getLength1() {
    return length1;
  }
}
