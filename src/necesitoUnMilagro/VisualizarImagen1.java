/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

//import additems.ImageComponent;
import Ventana.ImagePanel;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author MUTNPROD003
 */
public class VisualizarImagen1 {

  private ImagePanel imagePanel;
  private JScrollPane scrollPane;

  public VisualizarImagen1(JScrollPane scroll) {
    this.scrollPane = scroll;
    System.gc();
  }

  public void visualizarImagen(String imagen, boolean pdf, boolean tif, final JSpinner spinner1, SpinnerNumberModel modelo, double zoomDouble) {
    imagePanel = new ImagePanel((float) zoomDouble, Color.gray);
    imagePanel.CargarImg(imagen, pdf, tif);
    spinner1.setModel(modelo);
    spinner1.setPreferredSize(new Dimension(45, spinner1.getPreferredSize().height));
    spinner1.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        float scale = ((Double) spinner1.getValue()).floatValue();
        imagePanel.setScale(scale);
      }
    });
    scrollPane.getViewport().add(imagePanel);
    scrollPane.revalidate();
  }
  public void visualizarImagen(String imagen, boolean pdf, boolean tif, final JSpinner spinner1, SpinnerNumberModel modelo, double zoomDouble,Color color) {
    imagePanel = new ImagePanel((float) zoomDouble, color);
    imagePanel.CargarImg(imagen, pdf, tif);
    spinner1.setModel(modelo);
    spinner1.setPreferredSize(new Dimension(45, spinner1.getPreferredSize().height));
    spinner1.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        float scale = ((Double) spinner1.getValue()).floatValue();
        imagePanel.setScale(scale);
      }
    });
    scrollPane.getViewport().add(imagePanel);
    scrollPane.revalidate();
  }
  public void visualizarConZoom(){
    
  }

}
