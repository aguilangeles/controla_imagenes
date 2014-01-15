/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import entidad.NombrePaginaDelPDF;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.pdfbox.pdmodel.PDDocument;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class GetImagenesAdyacentes {

  private static String filenotfound = "AyudaImagenes/imagen-no-encontrada.jpg";
  ImagenAdyacenteParaPdf ant = null;
  ImagenAdyacenteParaPdf pst = null;
  private Map<Integer, NombrePaginaDelPDF> mapa = new HashMap<>();
  private boolean exitsPrevius, exitsNext;
  private int uno = 1;
  private String imagenAnterior;
  private String imagenPosterior;
  private String prex;
  private String nombreA, nombreP;
  private int prevPage, nextPage;
  private boolean exitsPrevAndNext;

  public GetImagenesAdyacentes(String pathname) {

    File file = new File(pathname);
    File dir = new File(file.getParent());
    File[] files = dir.listFiles();

    for (int i = 0; i < files.length; i++)
      {
      File aFile = files[i];

      if (aFile.equals(file))
        {
        try
          {
          int imin = i - 1;
          int imas = i + 1;

          getPrevisFile(files, imin);
          getNextFile(files, imas);
          } catch (ArrayIndexOutOfBoundsException e)
          {
          System.out.println("exception !!!!");
          }
        }
      }
  }

  public GetImagenesAdyacentes(String ruta, int pagina1) {
    iterarFilePdf(ruta);
    int anterior = (existPreviusPage(pagina1)) ? (pagina1 - 1) : -1;
    int post = pagina1 + 1;
    int posterior = (existNextPage((post), mapa.size())) ? post : -1;
    if (anterior != -1)
      {
      exitsPrevAndNext = true;
      ant = new ImagenAdyacenteParaPdf(mapa.get(anterior).getNombre(),
              mapa.get(anterior).getNumeroPagina(), "Imagen Anterior");
      prevPage = mapa.get(anterior).getNumeroPagina();
      } else
      {

      ant = null;
      }
    if (posterior != -1)
      {
      pst = new ImagenAdyacenteParaPdf(mapa.get(posterior).getNombre(),
              mapa.get(posterior).getNumeroPagina(), "Imagen Posterior");
      nextPage = mapa.get(posterior).getNumeroPagina();
      } else
      {
      pst = null;
      }
  }

  public GetImagenesAdyacentes() {
  }

  public ImagenAdyacenteParaPdf getAnt() {
    return ant;
  }

  public ImagenAdyacenteParaPdf getPst() {
    return pst;
  }

  public boolean isExitsPrevAndNext() {
    return exitsPrevAndNext;
  }

  private void iterarFilePdf(String ruta) {
    int contador = 0;
    try
      {
      File file = new File(ruta);
      PDDocument pddDocument = PDDocument.load(file.getAbsolutePath());
      int pagina = pddDocument.getDocumentCatalog().getAllPages().size();
      for (int i = 0; i < pagina; i++)
        {
        NombrePaginaDelPDF page = new NombrePaginaDelPDF(ruta, i);
        mapa.put(i, page);
        }
      pddDocument.close();
      } catch (IOException ex)
      {
      System.out.println("io exception");
      Logger.getLogger(GetImagenesAdyacentes.class.getName()).log(Level.SEVERE, null, ex);
      }
  }

  private boolean existPreviusPage(int page) {
    boolean previusexist = (page == 0) ? false : true;
    return previusexist;
  }

  private boolean existNextPage(int aint, int page) {
    boolean existenext = (aint >= page) ? false : true;
    return existenext;
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

  private void getPrevisFile(File[] files, int imin) {
    try
      {
      this.imagenAnterior = (files[imin]).toString();
      //System.out.println("imagen anterior " + imagenAnterior);
      this.nombreA = files[imin].getName();
      } catch (ArrayIndexOutOfBoundsException e)
      {
      this.imagenAnterior = filenotfound;
      this.nombreA = "Sin imagen anterior";
      System.out.println("exception Anterior !!!!");
      }

  }

  private void getNextFile(File[] files, int imas) {

    try
      {
      this.imagenPosterior = files[imas].toString();
      this.nombreP = files[imas].getName();

      } catch (ArrayIndexOutOfBoundsException ee)
      {
      System.out.println("exception posterior");
      this.imagenPosterior = filenotfound;
      this.nombreP = "Sin Imagen Posterior";
      }
  }
}
