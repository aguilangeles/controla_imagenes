 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Ventana.ImagePanel;
import Ventana.ImageTif;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
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
 * @author aguilangeles@gmail.com
 */
public class ImageDrawingComponent extends JPanel {

  int opIndex;
  ImageTif img = new ImageTif();
  private BufferedImage bi;

  public ImageDrawingComponent() {
  }

  public void cargarImage(String path, boolean pdf, boolean tif, int opcion) {
    loadImage(path, pdf, tif);
    setOpIndex(opcion);
  }

  private void setOpIndex(int i) {
    opIndex = i;
  }

  @Override
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    switch (opIndex) {
      case 0:
        setCientoVeintiCinco(g2);
        break;
      case 1:
        setCien(g2);
        break;
      case 2:
        setSetentaYCinco(g2);
        break;
      default:
        setCincuenta(g2);
        break;
    }
  }

  private void loadImage(String path, boolean pdf, boolean tif) {
    if (pdf || !tif) {
      try {
        File arch = new File(path);
        bi = ImageIO.read(arch);
      } catch (MalformedURLException mue) {
        System.out.println("URL trouble: " + mue.getMessage());
      } catch (IOException ioe) {
        System.out.println("read trouble: " + ioe.getMessage());
      }
    } else {
      try {
        bi = (BufferedImage) img.lecturaImagen(path);
      } catch (FileNotFoundException ex) {
        Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
        Logger.getLogger(ImagePanel.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }

  private void setCincuenta(Graphics2D g2) {
    /* cincuenta */
    int w_50 = (int) ((bi.getWidth() / 2) / 2);
    int y_50 = (int) ((bi.getHeight() / 2) / 2);
    setPreferredSize(new Dimension(w_50, y_50));
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, w_50, y_50,
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();
  }

  private void setSetentaYCinco(Graphics2D g2) {
    //setentaycinco
    int w_75 = (int) ((bi.getWidth() / 2) / 1.3);
    int y_75 = (int) ((bi.getHeight() / 2) / 1.3);
    setPreferredSize(new Dimension(w_75, y_75));
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, w_75, y_75, /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();
  }

  private void setCien(Graphics2D g2) {
    /*cien*/
    int w_100 = (int) (bi.getWidth() / 2);
    int y_100 = (int) (bi.getHeight() / 2);
    setPreferredSize(new Dimension(w_100, y_100));
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, w_100, y_100, /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();
  }

  private void setCientoVeintiCinco(Graphics2D g2) {
    /*veinticinco*/
    int w_125 = (int) ((bi.getWidth() / 2) * 1.25);
    int y_125 = (int) ((bi.getHeight() / 2) * 1.25);
    setPreferredSize(new Dimension(w_125, y_125));
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, w_125, y_125, /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();
  }
}
