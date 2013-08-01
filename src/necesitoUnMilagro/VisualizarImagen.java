/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

//import additems.ImageComponent;
import Ventana.ImageComponent;
import Ventana.ImagePanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author MUTNPROD003
 */
public class VisualizarImagen {

  private ImagePanel imagePanel;
  private JScrollPane scrollPane;
  private int zoom;

  public VisualizarImagen(JScrollPane scroll) {
    this.scrollPane = scroll;
    System.gc();
  }

  public void visualizarImagen(String imagen, boolean pdf) {
    imagePanel = new ImagePanel();
    imagePanel.CargarImg(imagen);
    SpinnerNumberModel model = new SpinnerNumberModel(1.0, 0.1, 1.4, .01);
    final JSpinner spinner = new JSpinner(model);
    spinner.setPreferredSize(new Dimension(45, spinner.getPreferredSize().height));
    spinner.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        float scale = ((Double) spinner.getValue()).floatValue();
        imagePanel.setScale(scale);
      }
    });
    imagePanel.add(new JLabel("scale"));
    imagePanel.add(spinner);
    scrollPane.getViewport().add(imagePanel);
    scrollPane.revalidate();
  }
//  public void visualizarImagen(String imagen, boolean pdf, int zoom) {
//    this.zoom = zoom;
//    try {
//      final ImageComponent imageCmp = new ImageComponent(imagen, 2. * getZoom() / slider.getMaximum(), scrollPane, pdf);
//      scrollPane.getViewport().removeAll();//buscar metodo remove
//      scrollPane.getViewport().add(imageCmp);//buscar metodo remove
//      slider.setValue(zoom);
//      slider.addChangeListener(new ChangeListener() {
//        @Override
//        public void stateChanged(ChangeEvent e) {
//          setZoom(slider.getValue());
//          imageCmp.setZoom(2. * getZoom() / slider.getMaximum(), scrollPane);
//        }
//      });
//    } catch (Exception ex) {
//      //TODO
//      System.out.println("visualizar imagen");
//      System.out.println(ex.getMessage());
//    }
//  }

  public int getZoom() {
    return zoom;
  }

  public void setZoom(int zoom) {
    this.zoom = zoom;
  }
}
