/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public final class VersionEImageIcon extends JFrame {
//tiene boton de ampliar en ancho y mostrar pagina entera.

  public static final String VERSION = "Qualitys 2.0.0";
  private Color color;

  public VersionEImageIcon() {
  }

  public VersionEImageIcon(JFrame frame) {
    // cambia la version y la imagen
    setImagenIcon(frame);
    frame.setTitle(VERSION);
  }

  public VersionEImageIcon(JFrame frame, String mensaje) {
    //cambia la version y permite un mensaje, y la vimagen
    setImagenIcon(frame);
    frame.setTitle(mensaje + " " + VERSION);
  }

  public void setImagenIcon(JFrame frame) {
    String rutaImagen = "Logos\\nuevo logo sin letras UTN.png";
    ImageIcon im = new ImageIcon(rutaImagen);
    setIconImage(im.getImage());
    frame.setIconImage(im.getImage());
  }

  public void newColorFromPanel(JPanel panel) {
//     color = new Color(255, 252, 238);
    color = new Color(230, 252, 238);
    panel.setBackground(color);
//    return color;
  }

  public Color getColor() {
    return color;
  }
  public static String getIcon(){
    return "Logos\\test_50.png";
  }
}
