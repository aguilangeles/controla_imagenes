/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

//import additems.ImageComponent;
import Ventana.ImageComponent;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author MUTNPROD003
 */
public class VisualizarImagen1 {
    private JScrollPane scrollPane;
    private JSlider slider;
    private int zoom;

    public VisualizarImagen1(JScrollPane scroll, JSlider slider) {
        this.scrollPane = scroll;
        this.slider = slider;
        System.gc();
    }
  public void visualizarImagen(String imagen, boolean pdf, int zoom) {
    this.zoom=zoom;
    try {
      final ImageComponent imageCmp = new ImageComponent(imagen, 2. * getZoom() / slider.getMaximum(), scrollPane, pdf);
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
    } catch (Exception ex) {
      //TODO
      System.out.println("visualizar imagen");
      System.out.println(ex.getMessage());
    }
  }

    public int getZoom() {
        return zoom;
    }

    public void setZoom(int zoom) {
        this.zoom = zoom;
    }


}
