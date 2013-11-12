/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Entidades.NombrePaginaDelPDF;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetImagenesAdyacentes {

  private String imagenAnterior;
  private String imagenPosterior;
  private String prex;
  private String nombreA, nombreP;
  private int prevPage, nextPage;

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

  public GetImagenesAdyacentes(String ruta, int pagina1) {
    this.prevPage = pagina1 - 1;
    this.nextPage = pagina1 + 1;
    try
      {
      File file = new File(ruta);
      PDDocument pddDocument = PDDocument.load(file.getAbsolutePath());
      int pagina = pddDocument.getDocumentCatalog().getAllPages().size();
      for (int i = 0; i < pagina; i++)
        {
        NombrePaginaDelPDF page = new NombrePaginaDelPDF(ruta, i);
        if (page.getNumeroPagina() == prevPage)
          {
          this.imagenAnterior = page.getNombre();
          System.out.println(" img ant "+imagenAnterior);
          this.nombreA = file.getName();
          } else if (page.getNumeroPagina() == nextPage)
          {
          this.imagenPosterior = page.getNombre();
          this.nombreP = file.getName();
          }

        }
      pddDocument.close();
      } catch (IOException ex)
      {
      Logger.getLogger(GetImagenesAdyacentes.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  public String getNombreA() {
    return nombreA;
  }

  public String getNombreP() {
    return nombreP;
  }

  public void setImagenAnterior(String imagenAnterior) {
    this.imagenAnterior = imagenAnterior;
  }

  public void setImagenPosterior(String imagenPosterior) {
    this.imagenPosterior = imagenPosterior;
  }


  public String getImagenAnterior() {
    return imagenAnterior;
  }

  public String getImagenPosterior() {
    return imagenPosterior;
  }

  public void setNombreA(String nombreA) {
    this.nombreA = nombreA;
  }

  public void setNombreP(String nombreP) {
    this.nombreP = nombreP;
  }

  public int getPrevPage() {

    return prevPage;
  }

  public int getNextPage() {
    return nextPage;
  }

//  @Override
//  public String toString() {
//    return "GetImagenesAdyacentes{" + "nombreA=" + nombreA + ", nombreP=" + nombreP + '}';
//  }
  @Override
  public String toString() {
    return "GetImagenesAdyacentes{" + "imagenAnterior=" + imagenAnterior + ", imagenPosterior=" + imagenPosterior + ", nombreA=" + nombreA + ", nombreP=" + nombreP + '}';
  }
}
