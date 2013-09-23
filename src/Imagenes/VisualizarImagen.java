/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

//import additems.ImageComponent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author MUTNPROD003
 */
public class VisualizarImagen {

  private JScrollPane scrollPane;
  private JSlider slider;
  private int zoom;

  public VisualizarImagen(JScrollPane scroll, JSlider slider) {
    this.scrollPane = scroll;
    this.slider = slider;
    System.gc();
  }

  public void visualizarImagen(String imagen, int zoom) {
    this.zoom = zoom;

    final ImageComponent imageCmp = new ImageComponent(imagen, 2. * getZoom() / slider.getMaximum(), scrollPane);
    scrollPane.getViewport().removeAll();//buscar metodo remove
    scrollPane.getViewport().add(imageCmp);//buscar metodo remove
    slider.setValue(zoom);
    slider.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        setZoom(slider.getValue());
        imageCmp.setZoom(2. * getZoom() / slider.getMaximum(), scrollPane);
      }
    });

  }

  public int getZoom() {
    return zoom;
  }

  public void setZoom(int zoom) {
    this.zoom = zoom;
  }
}
