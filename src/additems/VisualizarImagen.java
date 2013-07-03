/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package additems;

import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author MUTNPROD003
 */
public class VisualizarImagen {
    private String ruta;
    private JScrollPane scrollPane;
    private JSlider slider;
    private int zoom;

    public VisualizarImagen(String ruta, JScrollPane scroll, JSlider slider, int zoom) {
        this.ruta = ruta;
        this.scrollPane = scroll;
        this.slider = slider;
        this.zoom = zoom;
        visualizarImagen();
    }
        private void visualizarImagen() {

        try {
            final ImageComponent imageCmp = new ImageComponent(ruta, 2. * getZoom() / slider.getMaximum(), scrollPane);
            scrollPane.getViewport().add(imageCmp);
            slider.setValue(zoom);
            slider.addChangeListener(new ChangeListener() {
                @Override
                public void stateChanged(ChangeEvent e) {
                    setZoom(slider.getValue());
                    imageCmp.setZoom(2. * getZoom() / slider.getMaximum(), scrollPane);
                }
            });
        } catch (Exception ex) {
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
