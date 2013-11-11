/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

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
  static String mm;

  public RutaMouseListener() {
    System.out.println("entro en la llamada de mouselistenr");
  }

  public static void veradyacente(GetImagenesAdyacentes im) {
    img = im;
  }

  public static GetImagenesAdyacentes getImg() {
    return img;
  }

  public static String getMm() {
    return mm;
  }

  @Override
  public void mouseClicked(MouseEvent e) {
     new PanelVisual(img.getImagenAnterior(), img.getImagenPosterior(), img.getNombreA(), img.getNombreP()).setVisible(true);
//    System.out.println(getMm());
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
