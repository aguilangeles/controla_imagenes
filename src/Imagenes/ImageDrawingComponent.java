 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

/**
 * Santinelli dixit. unica manera de que no levante memoria, se mantenga el zoom
 * entre imagenes y el scroll sea agil.
 *
 * @author aguilangeles@gmail.com
 */
public class ImageDrawingComponent extends JPanel {

  int opIndex;
  ReadImageTif tif = new ReadImageTif();
  private BufferedImage bi;
  private Dimension dimensionPanel = new Dimension();

  public ImageDrawingComponent() {
  }

  public void cargarImage(String path, boolean pdf, boolean tif,
          final JComboBox combo, final JPanel panelscroll, JButton button, JButton entera) {
    loadImage(path, pdf, tif);
    combo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setOpIndex(combo.getSelectedIndex());
        dimensionPanel.setSize(panelscroll.getSize());
      }
    });
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setOpIndex(5);
        dimensionPanel.setSize(panelscroll.getSize());
      }
    });
    entera.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setOpIndex(6);
        dimensionPanel.setSize(panelscroll.getSize());
      }
    });
  }

  private void setOpIndex(int i) {
    opIndex = i;
  }

  @Override
  public void paint(Graphics g) {
    ImageSize image = new ImageSize(new Dimension(bi.getWidth(), bi.getHeight()), getDimensionPanel());
    Graphics2D g2 = (Graphics2D) g;
    switch (opIndex)
      {
      case 0:
        setCientoCincuenta(g2);
        break;
      case 1:
        setValuesForNewDimension(g2, image.getDimensionFor125());
        // setCientoVeintiCinco(g2);
        break;
      case 2:
        setValuesForNewDimension(g2, image.getDimforhalf());
        break;
      case 3:
        setValuesForNewDimension(g2, image.getDimensionFor75());
        break;
      case 4:
        setValuesForNewDimension(g2, image.getDimensionFor50());
        break;
      case 5:
        //ajustar al ancho

        setValuesForNewDimension(g2, image.getDimforhalf());
        //adjustAncho(g2);
        break;
      case 6:
        //  setValues(g2, image.getDimforPanel());
        adjustPage(g2);
        break;
      default:
        break;
      }

  }

  public Dimension getDimensionPanel() {
    return dimensionPanel;
  }

  private void loadImage(String path, boolean pdf, boolean tif) {
    if (pdf || !tif)
      {
      try
        {
        File arch = new File(path);
        bi = ImageIO.read(arch);
        } catch (MalformedURLException mue)
        {
        System.out.println("URL trouble: " + mue.getMessage());
        } catch (IOException ioe)
        {
        System.out.println("read trouble: " + ioe.getMessage());
        }
      } else
      {
      try
        {
        bi = (BufferedImage) this.tif.getImagen(path);
        } catch (FileNotFoundException ex)
        {
        Logger.getLogger(ImageDrawingComponent.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex)
        {
        Logger.getLogger(ImageDrawingComponent.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
  }

  private void setValuesForNewDimension(Graphics2D g2, Dimension newdimension) {
    Dimension dim = newdimension;
    setPreferredSize(dim);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.setBackground(Color.green);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, (int) dim.getWidth(), (int) dim.getHeight(),
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();
  }

  private void adjustAncho(Graphics2D g2) {
    ImageSize imageSize = new ImageSize(new Dimension(bi.getWidth(), bi.getHeight()), getDimensionPanel());
    setPreferredSize(imageSize.getDimforhalf());
    g2.setBackground(Color.red);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, getWidth(), getHeight(), /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();
  }

  private void serValues(Graphics2D g2, Dimension dimension) {
    Dimension dim = new Dimension(dimension);
//    ImageSize imageSize = new ImageSize(new Dimension(bi.getWidth(), bi.getHeight()), getDimensionPanel());
    setPreferredSize(dim);
    g2.setBackground(Color.red);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, getWidth(), getHeight(), /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();
  }

  private void setCientoCincuenta(Graphics2D g2) {
    /*veinticinco*/
    int w_150 = (int) ((bi.getWidth() / 2.7) * 1.50);
    int y_150 = (int) ((bi.getHeight() / 2.7) * 1.50);
    setPreferredSize(new Dimension(w_150, y_150));
    g2.setBackground(Color.gray);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, w_150, y_150, /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();
  }

  private void adjustPage(Graphics2D g2) {
    ImageSize imageSize = new ImageSize(new Dimension(bi.getWidth(), bi.getHeight()), getDimensionPanel());
    Dimension dim = imageSize.getDimforPanel();
    setPreferredSize(dim);
    g2.setBackground(Color.cyan);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, (int) dim.getWidth(), (int) dim.getHeight(), /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();

  }
}
