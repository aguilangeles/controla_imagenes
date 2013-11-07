/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import Imagenes.AyudaVisual;
import VentanaPrincipal.GetRutaDeImagen;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class RutaMouseListener implements MouseListener {

  private JLabel ruta;

  public RutaMouseListener(JLabel ruta) {
    this.ruta = ruta;
  }

  @Override
  public void mouseClicked(MouseEvent e) {

    System.out.println(GetRutaDeImagen.getRetmin());
    new AyudaVisual(GetRutaDeImagen.getRetmin()).setVisible(true);
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
