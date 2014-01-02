package Imagenes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Dimension;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ImageSize {

  private double wipanel;
  private double hepanel;
  private Dimension imgSize;
  private Dimension dimforPanel;
  private Dimension dimforhalf;

  public ImageSize(Dimension imgSize, Dimension dimPanel) {
    this.imgSize = imgSize;
    this.wipanel = dimPanel.getWidth();
    this.hepanel = dimPanel.getHeight();
    // verPaginaEnAncho();
    // verPaginaEntera();
  }

  public boolean isMasAnchoqueAlto() {
    if (imgSize.getWidth() <= imgSize.getHeight())
      {
      return true;
      }
    return false;
  }

  public Dimension getDimensionDefault() {
    Dimension dimension = new Dimension();
    if (isMasAnchoqueAlto())
      {
      double wight = 1000 * imgSize.getWidth() / imgSize.getHeight();
      double height = wight * imgSize.getHeight() / imgSize.getWidth();
      int w = (int) ((int) (wight) * 1.50);
      int h = (int) ((int) (height) * 1.50);
      dimension.setSize(w, h);
      } else
      {
      double height = ((1000) * imgSize.getHeight() / imgSize.getWidth());
      double wight = (height * imgSize.getWidth() / imgSize.getHeight());
      int w = (int) ((int) (wight) * 1.50);
      int h = (int) ((int) (height) * 1.50);
      dimension.setSize(w, h);
      }
    return dimension;
  }

  public Dimension getDimensionFor50() {
    int ww = (int) (wipanel) / 2;
    int hh = (int) (ww * imgSize.getHeight() / imgSize.getWidth());
    Dimension dimension = new Dimension(ww, hh);
    return dimension;
  }

  public Dimension getDimensionFor125() {
    int ww = (int) ((int) (wipanel) * 1.25);
    int hh = (int) (ww * imgSize.getHeight() / imgSize.getWidth());
    Dimension dimension = new Dimension(ww, hh);
    return dimension;
  }

  public Dimension getDimensionFor75() {
    int ww = (int) ((int) (wipanel) / 1.3);
    int hh = (int) (ww * imgSize.getHeight() / imgSize.getWidth());
    Dimension dimension = new Dimension(ww, hh);
    return dimension;
  }

  public Dimension getDimensionFor25() {
    int ww = (int) ((int) (wipanel) / 3);
    int hh = (int) (ww * imgSize.getHeight() / imgSize.getWidth());
    Dimension dimension = new Dimension(ww, hh);
    return dimension;
  }

  public Dimension getDimforPanel() {
//    System.out.println("dim for panel");
    int w = 0;
    int h = 0;
    if (isMasAnchoqueAlto())
      {
//      System.out.println("mas ancho" + imgSize.getWidth() + " " + imgSize.getHeight());
      double wight = hepanel * imgSize.getWidth() / imgSize.getHeight()-20;
      double height = wight * imgSize.getHeight() / imgSize.getWidth();
      w = (int) (wight);
      h = (int) (height);
      } else
      {
//      System.out.println("mas alto " + imgSize.getWidth() + " " + imgSize.getHeight());
      double height = ((wipanel) * imgSize.getHeight() / imgSize.getWidth() )/1.8;
      double wight = (height * imgSize.getWidth() / imgSize.getHeight());
      w = (int) (wight);
      h = (int) (height);
      }
    dimforPanel = new Dimension(w, h);
    return dimforPanel;
  }

  public Dimension getDimforhalf() {
    int ww = (int) wipanel - 80;
    int hh = (int) (ww * imgSize.getHeight() / imgSize.getWidth());
    dimforhalf = new Dimension(ww, hh);
    return dimforhalf;
  }
}
