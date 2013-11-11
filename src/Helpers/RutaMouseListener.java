/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Imagenes.PanelVisual;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class RutaMouseListener implements MouseListener {

  private GetImagenesAdyacentes img;
  private PanelVisual panelVisual;

  public RutaMouseListener(final GetImagenesAdyacentes img) {
    this.img = img;
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        panelVisual = new PanelVisual(img.getImagenAnterior(), img.getImagenPosterior(), img.getNombreA(), img.getNombreP());
      }
    });
  }

  @Override
  public void mouseClicked(MouseEvent e) {

    panelVisual.setVisible(true);

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
