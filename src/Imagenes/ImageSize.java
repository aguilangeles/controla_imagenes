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
    verPaginaEnAncho();
    verPaginaEntera();
  }

  private boolean isMasAnchoqueAlto() {
    if (imgSize.getWidth() <= imgSize.getHeight())
      {
      return true;
      }
    return false;
  }

  private void verPaginaEntera() {
    int w = 0;
    int h = 0;
    if (isMasAnchoqueAlto())
      {
      double wight = hepanel * imgSize.getWidth() / imgSize.getHeight();
      double height = wight * imgSize.getHeight() / imgSize.getWidth();
      w = (int) (wight);
      h = (int) (height) - 20;
      } else
      {
      double height = ((wipanel) * imgSize.getHeight() / imgSize.getWidth() - 100);
      double wight = (height * imgSize.getWidth() / imgSize.getHeight());
      w = (int) (wight - 20);
      h = (int) (height) - 30;
      }
    dimforPanel = new Dimension(w, h);
  }

  private void verPaginaEnAncho() {
    int ww = (int) wipanel - 80;
    int hh = (int) (ww * imgSize.getHeight() / imgSize.getWidth());
    dimforhalf = new Dimension(ww, hh);
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
    return dimforPanel;
  }

  public Dimension getDimforhalf() {
    return dimforhalf;
  }
}
