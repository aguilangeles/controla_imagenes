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

  public Dimension getDimforPanel() {
    return dimforPanel;
  }

  public Dimension getDimforhalf() {
    return dimforhalf;
  }
}
