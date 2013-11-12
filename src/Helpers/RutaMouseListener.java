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
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class RutaMouseListener implements MouseListener {

  private static GetImagenesAdyacentes img;
  private PanelVisual panelVisual;
  private JLabel label;
  private static boolean pdf, tiff;
  private MouseListener mouseListener;

  public RutaMouseListener() {
  }

  public static void getAdyacentes(GetImagenesAdyacentes im, boolean pdf, Imagen imagen) {
    if (pdf)
      {
      RutaMouseListener.pdf = true;

      int newPage = imagen.getPagina() - 1;
      int newPage2 = imagen.getPagina() + 1;
      String pareng = imagen.getParent();

      GetImagenesAdyacentes imagenesAdyacentes = new GetImagenesAdyacentes(imagen.getRutaParaConversion(), imagen.getPagina());
      if(imagenesAdyacentes.getImagenAnterior()==null){

      JOptionPane.showMessageDialog(null, "hubo un error");
      System.exit(0);
      }
      else{
        System.out.println(imagenesAdyacentes.toString());
      }
//      ImagenesWorker iworker1 = new ImagenesWorker(imagenesAdyacentes.getImagenAnterior(), pareng, imagenesAdyacentes.getPrevPage());
//      String i = iworker1.doInBackground();
//      System.out.println("producto worker " + i);
//
//      ImagenesWorker iworker2 = new ImagenesWorker(imagenesAdyacentes.getImagenPosterior(), pareng, imagenesAdyacentes.getNextPage());
//      String b = (iworker2.doInBackground());
//      System.out.println("producto 2 worker " + b);
//
//      imagenesAdyacentes.setImagenAnterior(i);
//      imagenesAdyacentes.setImagenPosterior(b);
//      imagenesAdyacentes.setNombreA(imagen.getRutaInsertadaEnDB() + "_" + imagenesAdyacentes.getPrevPage());
//      imagenesAdyacentes.setNombreP(imagen.getRutaInsertadaEnDB() + "_" + imagenesAdyacentes.getNextPage());
////
//
//      //  System.out.println(imagenesAdyacentes);
//      img = imagenesAdyacentes;
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
}
