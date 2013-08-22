/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Zoom extends JPanel {

  private BufferedImage originalImage;
  private float xScaleFactor = 1;
  private float yScaleFactor = 1;
  private int Izq = 70;
  private Dimension dimension1;

  public Zoom(BufferedImage originalImage) {
    this.originalImage = originalImage;
  }

  public Zoom(String ruta) {
    try {
      this.originalImage = ImageIO.read(new File(ruta));
      this.xScaleFactor = 1;
      this.yScaleFactor = 1;
    } catch (IOException ex) {
      Logger.getLogger(Zoom.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public Zoom(String ruta, Dimension dimension) {
    try {
      this.originalImage = ImageIO.read(new File(ruta));
      setPreferredSize(dimension);
    } catch (IOException ex) {
      Logger.getLogger(Zoom.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public void increaseZoom() {
    xScaleFactor += 0.1;
    yScaleFactor += 0.1;
    Izq += 20;
    repaint();
  }

  public void decreaseZoom() {
    xScaleFactor -= 0.2;
    yScaleFactor -= 0.2;
    Izq -= 20;
    repaint();
  }

//  @Override
//  public void paintComponent(Graphics g) {
//    Graphics2D g2 = (Graphics2D) g;
//    int w = getWidth();
//    int h = getHeight();
//    Dimension dim = getPreferredSize();//tengo que setear la dimension
//    //y mantenerla
//    int w1 = (int) dim.getWidth();
//    int h1 = (int) dim.getHeight();
//    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//    g2.clearRect(0, 0, w, h);
//    g2.drawImage(originalImage, Izq, 0, w1, h1, null);
//    repaint();
//  }
  @Override
  public void paintComponent(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    int newW = (int) (originalImage.getWidth() * xScaleFactor);
    int newH = (int) (originalImage.getHeight() * yScaleFactor);
    Dimension dim = new Dimension(newW, newH);
    setPreferredSize(dim);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.clearRect(0, 0, getWidth(), getHeight());
    Dimension dim2 = getPreferredSize();
    int ww = (int) dim2.getWidth()/2;
    int hh = (int) dim.getHeight()/2;
    g2.drawImage(originalImage, Izq, 0, ww, hh, null);
    scrollRectToVisible(new Rectangle(dim));
    revalidate();
    repaint();
  }
//  @Override
//  public void paintComponent(Graphics g) {
//    Graphics2D g2 = (Graphics2D) g;
//    int newW = (int) (originalImage.getWidth() * xScaleFactor);
//    int newH = (int) (originalImage.getHeight() * yScaleFactor);
//    Dimension dim = new Dimension(newW, newH);
//    setPreferredSize(dim);
//    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
//    g2.clearRect(0, 0, getWidth(), getHeight());
//    g2.drawImage(originalImage, Izq, 0, getWidth() / 3, getHeight() / 3, null);
//    scrollRectToVisible(new Rectangle(dim));
//    revalidate();
//    repaint();
//  }

  public Dimension getDimension() {
    return getPreferredSize();
  }
}
