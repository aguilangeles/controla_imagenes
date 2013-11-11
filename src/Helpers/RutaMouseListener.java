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

  public RutaMouseListener() {
  }

  public static void getAdyacentes(GetImagenesAdyacentes im) {
    img = im;
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
