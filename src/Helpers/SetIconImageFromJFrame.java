/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author maria
 */
public class SetIconImageFromJFrame extends JFrame {
  
  

  public void set() {
    String rutaImagen = "Logos/nuevo logo sin letras UTN.png";
    ImageIcon im = new ImageIcon(rutaImagen);
    setIconImage(im.getImage());
  }
}
