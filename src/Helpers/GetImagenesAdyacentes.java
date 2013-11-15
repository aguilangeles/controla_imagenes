/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Entidades.NombrePaginaDelPDF;
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

  public GetImagenesAdyacentes(String ruta) {
    System.out.println("aca no deberia entrar si esta leyendo pdf");
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
    iterarFilePdf(ruta);
    int anterior = (existPreviusPage(pagina1)) ? (pagina1 - 1) : -1;
    int post = pagina1 + 1;
    int posterior = (existNextPage((post), mapa.size())) ? post : -1;
    System.out.println("pagina " + pagina1);
    System.out.println("anterior es " + anterior);
    System.out.println("posterior es " + posterior);
    if (anterior != -1)
      {
      exitsPrevAndNext = true;
      ant = new ImagenAdyacenteParaPdf(mapa.get(anterior).getNombre(),
              mapa.get(anterior).getNumeroPagina(), "Imagen Anterior");
      prevPage = mapa.get(anterior).getNumeroPagina() ;
      } else
      {

      ant = null;
      }
    if (posterior != -1)
      {
      pst = new ImagenAdyacenteParaPdf(mapa.get(posterior).getNombre(),
              mapa.get(posterior).getNumeroPagina(), "Imagen Posterior");
      nextPage = mapa.get(posterior).getNumeroPagina() ;
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
}
