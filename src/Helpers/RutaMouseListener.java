/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Imagenes.AyudaVisual;
import Imagenes.PanelVisual;
import VentanaPrincipal.GetRutaDeImagen;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class RutaMouseListener implements MouseListener {

  private GetImagenesAdyacentes img;

  public RutaMouseListener(String ruta) {
    System.out.println("recibi ruta " + ruta);
    img = new GetImagenesAdyacentes(ruta);
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    //    System.out.println(GetRutaDeImagen.getRetmin());
    //    new AyudaVisual(GetRutaDeImagen.getRetmin()).setVisible(true);
    //pruebo en tif, y despues en png
    System.out.println("ima anterior  " + img.getImagenAnterior());
    System.out.println("ima posterior  " + img.getImagenPosterior());
    System.out.println("ima nombre  an " + img.getNombreA());
    System.out.println("ima nombre po " + img.getNombreP());
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new PanelVisual(img.getImagenAnterior(), img.getImagenPosterior(), img.getNombreA(), img.getNombreP()).setVisible(true);
      }
    });

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
