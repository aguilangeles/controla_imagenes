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

  private static double wipanel = (int) Ventana.getPanelDimension().getWidth();
  private static double hepanel = (int) Ventana.getPanelDimension().getHeight();
  private Dimension imgSize;
  private Dimension dimforPanel;
  private Dimension dimforhalf;

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
      double wight = (hepanel * imgSize.getWidth() / imgSize.getHeight()) - 15;
      double height = (wight * imgSize.getHeight() / imgSize.getWidth());
      w = (int) (wight);
      h = (int) (height);
      } else
      {
      double height = (hepanel * imgSize.getHeight() / imgSize.getWidth());
      double wight = (height * imgSize.getWidth() / imgSize.getHeight());
      w = (int) (wight);
      h = (int) (height);
      }
    dimforPanel = new Dimension(w, h);
  }

  public Dimension getDimforPanel() {
    return dimforPanel;
  }

  private void alinearalHeight() {
    int ww = (int) wipanel - 15;
    int hh = (int) (ww * imgSize.getHeight() / imgSize.getWidth());
    dimforhalf = new Dimension(ww, hh);
  }

  public Dimension getDimforhalf() {
    return dimforhalf;
  }
}
