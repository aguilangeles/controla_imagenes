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
    alineacion();
    adjustWidth();
  }

  private boolean isWithanHe() {
    if (imgSize.getWidth() <= imgSize.getHeight())
      {
      return true;
      }
    return false;
  }

  private void alineacion() {
    int w = 0;
    int h = 0;
    if (isWithanHe())
      {
      double wight = hepanel * imgSize.getWidth() / imgSize.getHeight();
      double height = wight * imgSize.getHeight() / imgSize.getWidth();
      w = (int) (wight);
      h = (int) (height) - 20;
      } else
      {
      double height = ((wipanel) * imgSize.getHeight() / imgSize.getWidth());
      double wight = (height * imgSize.getWidth() / imgSize.getHeight());
      w = (int) (wight-20);
      h = (int) (height)-30;
      }
    dimforPanel = new Dimension(w, h);
  }

  public Dimension getDimforPanel() {
    return dimforPanel;
  }

  private void adjustWidth() {
    int ww = (int) wipanel - 80;
    int hh = (int) (ww * imgSize.getHeight() / imgSize.getWidth());
    dimforhalf = new Dimension(ww, hh);
  }

  public Dimension getDimforhalf() {
    return dimforhalf;
  }
}
