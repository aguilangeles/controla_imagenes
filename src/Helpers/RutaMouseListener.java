/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Entidades.Imagen;
import Imagenes.ImagenesWorker;
import Imagenes.PanelVisual;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class RutaMouseListener implements MouseListener {

  private static String filenotfound = "AyudaImagenes/imagen-no-encontrada.jpg";
  private static GetImagenesAdyacentes img;
  private PanelVisual panelVisual;
  private JLabel label;
  private static boolean pdf, tiff;
  private MouseListener mouseListener;
  private static ImagenAdyacente ant, pst;

  public RutaMouseListener() {
  }

  public static void getAdyacentes(GetImagenesAdyacentes im, boolean pdf, Imagen imagen) {
    if (pdf)
      {
      RutaMouseListener.pdf = true;

      int newPage = imagen.getPagina() - 1;
      int newPage2 = imagen.getPagina() + 1;
      String pareng = imagen.getParent();
      GetImagenesAdyacentes ady = new GetImagenesAdyacentes(imagen.getRutaParaConversion(), imagen.getPagina());
      ImagenAdyacente imgA = setimagenanterior(ady);

      ImagenesWorker iworker1 = new ImagenesWorker(imgA.getName(), pareng, imgA.getPage());
      String i = iworker1.doInBackground();
      ImagenAdyacente imgP = setimagenposterior(ady);


      //   System.out.println("producto worker " + i);

      ImagenesWorker iworker2 = new ImagenesWorker(imgP.getName(), pareng, imgP.getPage());
      String b = (iworker2.doInBackground());
      //  System.out.println("producto 2 worker " + b);

      ady.setImagenAnterior(i);
      ady.setImagenPosterior(b);
      ady.setNombreA(imagen.getRutaInsertadaEnDB() + "_" + ady.getPrevPage());
      ady.setNombreP(imagen.getRutaInsertadaEnDB() + "_" + ady.getNextPage());
      img = ady;
      } else
      {
      tiff = true;
      img = imagen.adyacentes();
      }
  }

  public static GetImagenesAdyacentes getImg() {
    return img;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    new PanelVisual(img.getImagenAnterior(), img.getImagenPosterior(),
            img.getNombreA(), img.getNombreP(), pdf, tiff).setVisible(true);
  }

  @Override
  public void mousePressed(MouseEvent e) {
  }

  @Override
  public void mouseReleased(MouseEvent e) {
  }

  @Override
  public void mouseEntered(MouseEvent e) {
  }

  @Override
  public void mouseExited(MouseEvent e) {
  }

  private static ImagenAdyacente setimagenanterior(GetImagenesAdyacentes ady) {
    if (ady.getAnt() == null)
      {
      ant = new ImagenAdyacente(filenotfound, 0, "sin imagen anterior");
      } else
      {
      ant = ady.getAnt();
      }
    return ant;
  }

  private static ImagenAdyacente setimagenposterior(GetImagenesAdyacentes ady) {
    if (ady.getPst() == null)
      {
      pst = new ImagenAdyacente(filenotfound, 0, "sin imagen posterior");
      } else
      {
      pst = ady.getPst();
      }
    return pst;
  }
}
