/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author MUTNPROD003
 */
public class ImagePanel extends JPanel {

  BufferedImage image;
  double scale;

  public ImagePanel() {
    scale = 0.42;
    setBackground(Color.black);
  }

  public ImagePanel(float scala) {
    this.scale = scala;
    setBackground(Color.black);
  }

  public void CargarImg(String path, boolean pdf, boolean tif) { //aca va el scala de spinner
    loadImage(path, pdf, tif);
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D) g;
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BICUBIC);
    int w = getWidth();
    int h = getHeight();
    int imageWidth = image.getWidth();
    int imageHeight = image.getHeight();
    double x = (w - scale * imageWidth) / 2;
    double y = (h - scale * imageHeight) / 2;
    AffineTransform at = AffineTransform.getTranslateInstance(x, y);
    at.scale(scale, scale);
    g2.drawRenderedImage(image, at);
  }

  /**
   * For the scroll pane.
   */
  @Override
  public Dimension getPreferredSize() {
    int w = (int) (scale * image.getWidth());
    int h = (int) (scale * image.getHeight());
    return new Dimension(w, h);
  }

  public void setScale(double s) {
    scale = s;
    revalidate();      // update the scroll pane
    repaint();
  }

  private void loadImage(String path, boolean pdf, boolean tif) {
    if (pdf || !tif) {
      System.out.println("leyendo png");
      try {
        File arch = new File(path);
        image = ImageIO.read(arch);
      } catch (MalformedURLException mue) {
        System.out.println("URL trouble: " + mue.getMessage());
      } catch (IOException ioe) {
        System.out.println("read trouble: " + ioe.getMessage());
      }
    } else {
      try {
        ImageTif img = new ImageTif();
        image = (BufferedImage) img.leerImagen(path);
      } catch (FileNotFoundException ex) {
        Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
      }

    }
  }
}
