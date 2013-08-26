 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ImageDrawingComponent extends JPanel {

  int opIndex;
  int izq = 0;
  int arr = 0;
  private BufferedImage bi;
  private int w, h;



  private BufferedImage bufferedImage(String imageSrc) {
    BufferedImage bim = null;
    int w1, h1;
    try {
      File file = new File(imageSrc);
      bim = ImageIO.read(file);
      w1 = bim.getWidth(null);
      h1 = bim.getHeight(null);
      if (bim.getType() != BufferedImage.TYPE_INT_RGB) {
        BufferedImage bi2 =
                new BufferedImage(w1, h1, BufferedImage.TYPE_INT_RGB);
        Graphics big = bi2.getGraphics();
        big.drawImage(bim, 0, 0, null);
        bim = bi2;
      }
    } catch (IOException e) {
      System.out.println("Image could not be read");
    }
    return bim;
  }

  public ImageDrawingComponent(String image) {
    bi = bufferedImage(image);
    this.w = bi.getWidth(null);
    this.h = bi.getHeight(null);

  }

  public ImageDrawingComponent() {
  }


  public void setMargen(int x, int y) {
    izq = -x;
    arr = -y;
  }

  public void setOpIndex(int i) {
    opIndex = i;
  }


  @Override
  public void paint(Graphics g) {
    Graphics2D g2 = (Graphics2D) g;
    switch (opIndex) {
      case 0:
        int w_125 = (int) ((bi.getWidth() /2 )*1.25);
        int y_125 = (int) ((bi.getHeight() /2) *1.25);
        setPreferredSize(new Dimension(w_125, y_125));
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.clearRect(0, 0, getWidth(), getHeight());
        g2.drawImage(bi,
                0, 0, w_125, y_125, /* src area of image */
                null);
        scrollRectToVisible(new Rectangle(getPreferredSize()));
        revalidate();
        repaint();
        break;

      case 1:
        int w_100 = (int) (bi.getWidth() /2);
        int y_100 = (int) (bi.getHeight() /2);
        setPreferredSize(new Dimension(w_100, y_100));
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.clearRect(0, 0, getWidth(), getHeight());
        g2.drawImage(bi,
                0, 0, w_100, y_100, /* src area of image */
                null);
        scrollRectToVisible(new Rectangle(getPreferredSize()));
        revalidate();
        repaint();
        break;

      case 2: //setentaycinco
        int w_75 = (int) ((bi.getWidth() /2)/1.3);
        int y_75 = (int) ((bi.getHeight() /2)/1.3);
        setPreferredSize(new Dimension(w_75, y_75));
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.clearRect(0, 0, getWidth(), getHeight());
        g2.drawImage(bi,
                0, 0, w_75, y_75, /* src area of image */
                null);
        scrollRectToVisible(new Rectangle(getPreferredSize()));
        revalidate();
        repaint();
        break;
      case 3: /* cincuenta */
        int w_50 = (int) ((bi.getWidth()/2) / 2);
        int y_50 = (int) ((bi.getHeight() / 2)/2);
        setPreferredSize(new Dimension(w_50, y_50));
        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);

        g2.clearRect(0, 0, getWidth(), getHeight());
        g2.drawImage(bi,

                0, 0, w_50, y_50, /* src area of image */
                null);
        scrollRectToVisible(new Rectangle(getPreferredSize()));
        revalidate();
        repaint();

        break;
         }
  }
}
