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

  private PanelVisual panelVisual;
  private JLabel label;
  private static boolean pdf, tiff;
  private MouseListener mouseListener;

  public RutaMouseListener() {
  }
  private static String filenotfound = "AyudaImagenes/imagen-no-encontrada.jpg";
  private static GetImagenesAdyacentes img;

  private static String getWorkerForPreviusPage(GetImagenesAdyacentes adyacente, String pareng, Imagen imagen) {
    String i = "";
    ImagenAdyacente nuevaImg = null;
    ImagenAdyacente imgAdyPrevia = setimagenanterior(adyacente);

    if (!imgAdyPrevia.getName().equals(filenotfound))
      {
      ImagenesWorker iworker1 = new ImagenesWorker(imgAdyPrevia.getName(), pareng, imgAdyPrevia.getPage());
      i = iworker1.doInBackground();
      nuevaImg = new ImagenAdyacente(imagen.getRutaInsertadaEnDB(), imagen.getPagina(), imagen.getParent());
      } else
      {
      i = imgAdyPrevia.getName();
      nuevaImg = imgAdyPrevia;
      }
    System.out.println("Nueva imagen "+nuevaImg);
    return i;
  }
//  private static String getWorkerForPreviusPage(GetImagenesAdyacentes adyacente, String pareng) {
//    String i = "";
//    ImagenAdyacente imgAdyPrevia = setimagenanterior(adyacente);
//    System.out.println(imgAdyPrevia);
//    if (!imgAdyPrevia.getName().equals(filenotfound))
//      {
//      ImagenesWorker iworker1 = new ImagenesWorker(imgAdyPrevia.getName(), pareng, imgAdyPrevia.getPage());
//      i = iworker1.doInBackground();
//
//      } else
//      {
//      i = imgAdyPrevia.getName();
//      }
//    return i;
//  }

  private static String getWorkerForNextPAge(GetImagenesAdyacentes ady, String pareng) {
    ImagenAdyacente imgP = setimagenposterior(ady);
    System.out.println("imp " + imgP.getName());
    ImagenesWorker iworker2 = new ImagenesWorker(imgP.getName(), pareng, imgP.getPage());
    String b = (iworker2.doInBackground());
    return b;
  }

  public static void getAdyacentes(boolean pdf, Imagen imagen) {
    if (pdf)
      {
      RutaMouseListener.pdf = true;
      String pareng = imagen.getParent();
      GetImagenesAdyacentes ady = new GetImagenesAdyacentes(imagen.getRutaParaConversion(), imagen.getPagina());

      String i = getWorkerForPreviusPage(ady, pareng, imagen);
      String b = getWorkerForNextPAge(ady, pareng);
      GetImagenesAdyacentes nadd = new GetImagenesAdyacentes();
      nadd.setImagenAnterior(i);
      nadd.setImagenPosterior(b);
      nadd.setNombreA(imagen.getRutaInsertadaEnDB());
      nadd.setNombreP(imagen.getRutaInsertadaEnDB());
      img = nadd;
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
    ImagenAdyacente ant = null;
    if (ady.getAnt() == null)
      {
      ant = new ImagenAdyacente(filenotfound, 0, "Sin Imagen Anterior");
      } else
      {
      ant = ady.getAnt();
      }
    return ant;
  }

  private static ImagenAdyacente setimagenposterior(GetImagenesAdyacentes ady) {
    ImagenAdyacente pst = null;
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
