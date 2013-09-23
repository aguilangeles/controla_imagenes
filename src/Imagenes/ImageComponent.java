/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

public final class ImageComponent extends JPanel {

  final BufferedImage img;
  private Dimension dim;

  public ImageComponent(String location, double zoom, JScrollPane scrollPane)  {

    img = image(location);
    setZoom(zoom, scrollPane);
  }
  private BufferedImage image(String path) {
    BufferedImage buffimg = null;
    try
      {
      File file = new File(path);
      buffimg = ImageIO.read(file);
      } catch (IOException ex)
      {
      try
        {
        buffimg = ImageIO.read(new File("AyudaImagenes/imagen-no-encontrada.jpg"));
        } catch (IOException ex1)
        {
        JOptionPane.showMessageDialog(this, ex1, "Imagen de Error no encontrada", JOptionPane.ERROR_MESSAGE);
        }
      }
    return buffimg;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    dim = getPreferredSize();
//aca trae el problema
    g.drawImage(img, 0, 0, dim.width, dim.height, this);
    g.dispose();
  }

  public void setZoom(double zoom, JScrollPane sp) {
    int w = (int) (zoom * img.getWidth());
    int h = (int) (zoom * img.getHeight());
    setPreferredSize(new Dimension(w, h));
    revalidate();
    repaint();
    sp.getViewport().revalidate();
    img.flush();
  }
}
