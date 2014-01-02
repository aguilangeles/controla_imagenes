/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

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
  private String mensaje;
  private String titulo;
  private int mensajeType;
  private ImageIcon imgIcon;

  public MensajeJoptionPane(Component comp, String mensaje, String titulo, int mensajeType) {
    this.component = comp;
    this.mensaje = mensaje;
    this.titulo = titulo;
    this.mensajeType = mensajeType;
    UIManager UI = new UIManager();
    UIManager.put("OptionPane.background", new ColorUIResource(230, 252, 238));
    UIManager.put("Panel.background", new ColorUIResource(230, 252, 238));
    this.imgIcon = new ImageIcon("Logos\\test_50.png");
  }

  public void getMessage() {
    JOptionPane.showMessageDialog(component, mensaje, titulo, mensajeType, imgIcon);
  }
}
