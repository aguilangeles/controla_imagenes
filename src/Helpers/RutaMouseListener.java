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

  private static GetImagenesAdyacentes img;
  private PanelVisual panelVisual;
  private JLabel label;
  private MouseListener mouseListener;

  public RutaMouseListener() {
  }

  public static void getAdyacentes(GetImagenesAdyacentes im, boolean pdf, Imagen imagen) {
    if (pdf)
      {
      int newPage = imagen.getPagina() - 1;
      int newPage2 = imagen.getPagina() + 1;
      GetImagenesAdyacentes imagenesAdyacentes = new GetImagenesAdyacentes(imagen.getRutaParaConversion(), imagen.getPagina());

      ImagenesWorker iworker1 = new ImagenesWorker(imagenesAdyacentes.getImagenAnterior(), imagen.getParent(), imagenesAdyacentes.getPrevPage());
      ImagenesWorker iworker2 = new ImagenesWorker(imagenesAdyacentes.getImagenPosterior(), imagen.getParent(), imagenesAdyacentes.getNextPage());
      System.out.println(iworker2.doInBackground());

//
//      imagenesAdyacentes.setNombreA(imagen.getRutaInsertadaEnDB() + "--" + newPage);
//      imagenesAdyacentes.setNombreP(imagen.getRutaInsertadaEnDB() + "-- " + newPage2);

      //  System.out.println(imagenesAdyacentes);
      } else
      {
      img = imagen.adyacentes();
      }
  }

  public static GetImagenesAdyacentes getImg() {
    return img;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    new PanelVisual(img.getImagenAnterior(), img.getImagenPosterior(),
            img.getNombreA(), img.getNombreP()).setVisible(true);
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
