 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

import helper.MensajeJoptionPane;
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
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Santinelli dixit. unica manera de que no levante memoria, se mantenga el zoom
 * entre imagenes y el scroll sea agil.
 *
 * @author aguilangeles@gmail.com
 */
public class ImageDrawingComponent extends JPanel {

  private static final String className = ImageDrawingComponent.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  MensajeJoptionPane msg = new MensajeJoptionPane(this, type);
  int opIndex;
  ReadImageTif tif = new ReadImageTif();
  private BufferedImage bi;
  private Dimension dimensionPanel = new Dimension();
  private ImageSize image;

  public ImageDrawingComponent() {
  }

  public ImageDrawingComponent(String imagen, final JPanel panel, int idImg, final JComboBox comboBox) {
    loadImage(imagen, idImg);
    comboBox.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setOpIndex(comboBox.getSelectedIndex());
        dimensionPanel.setSize(panel.getSize());
      }
    });
  }

  public void cargarImage(String path, final JComboBox combo, final JPanel panelscroll, JButton button, JButton entera, int idImg) {
    loadImage(path, idImg);
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
        setOpIndex(6);
        dimensionPanel.setSize(panelscroll.getSize());
      }
    });
    entera.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        setOpIndex(7);
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
        int ww = (int) ((bi.getWidth()));
        int hh = (int) ((bi.getHeight()));
        //mostrar a ciento cincuenta
        setValues(g2, image.getDimensionDefault());
        break;
      case 1:
        //mostrar a 125 porciento
        setValuesForNewDimension(g2, image.getDimensionFor125());
        // setCientoVeintiCinco(g2);
        break;
      case 2:
        setValues(g2, image.getDimforhalf());
        break;
      case 3:
        setValuesForNewDimension(g2, image.getDimensionFor75());
        break;
      case 4:
        setValuesForNewDimension(g2, image.getDimensionFor50());
        break;
      case 5:
        setValuesForNewDimension(g2, image.getDimensionFor25());
        break;
      case 6:
        setValues(g2, image.getDimforhalf());
        break;
      case 7:
        setValuesForNewDimension(g2, image.getDimforPanel());
        break;
      }

  }

  public Dimension getDimensionPanel() {
    return dimensionPanel;
  }

  private void loadImage(String path, int idImag) {
//    int idImagen = GetExtensionIdImagen.getIdImagen();
    switch (idImag)
      {
      case 1:
      case 3:
        try
          {
          File arch = new File(path);
          bi = ImageIO.read(arch);
          } catch (MalformedURLException mue)
          {
          msg.getMessage(mue.getMessage(), className);
          } catch (IOException ioe)
          {
          msg.getMessage(ioe.getMessage(), className);
          }
        break;
      case 2:
        try
          {
          bi = (BufferedImage) this.tif.getImagen(path);
          } catch (FileNotFoundException ex)
          {
          msg.getMessage(ex.getMessage(), className);
          } catch (IOException ex)
          {
          msg.getMessage(ex.getMessage(), className);
          }
        break;
      }
  }

  private void setValuesForNewDimension(Graphics2D g2, Dimension newdimension) {
    Dimension dim = newdimension;
    setPreferredSize(dim);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,
            RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.setBackground(Color.gray);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, (int) dim.getWidth(), (int) dim.getHeight(),
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();
  }

  private void setValues(Graphics2D g2, Dimension dimension) {
    // la diferencia es  que no uso la nueva dimension, para hacer el drawimage.
    Dimension dim = new Dimension(dimension);
    setPreferredSize(dim);
    g2.setBackground(Color.gray);
    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
    g2.clearRect(0, 0, getWidth(), getHeight());
    g2.drawImage(bi,
            0, 0, getWidth(), getHeight(), /* src area of image */
            null);
    scrollRectToVisible(new Rectangle(getPreferredSize()));
    revalidate();
    repaint();
  }
}
