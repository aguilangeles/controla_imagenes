/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class MensajeJoptionPane {

  private Component component;
  private int mensajeType;
  private ImageIcon imgIcon;

  public MensajeJoptionPane(Component comp, int mensajeType) {
    this.component = comp;
    this.mensajeType = mensajeType;
    UIManager UI = new UIManager();
    UIManager.put("OptionPane.background", new ColorUIResource(230, 252, 238));
    UIManager.put("Panel.background", new ColorUIResource(230, 252, 238));
    this.imgIcon = new ImageIcon("Logos\\test_50.png");
  }

  public void getMessage(String mensaje, String titulo) {
    JOptionPane.showMessageDialog(component, mensaje, titulo, mensajeType, imgIcon);
  }
}
