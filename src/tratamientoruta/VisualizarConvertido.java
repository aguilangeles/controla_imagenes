/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author MUTNPROD003
 */
public class VisualizarConvertido {

    static class ImageComponent extends JComponent {

    final BufferedImage img;

    public ImageComponent(URL url) throws IOException {
        img = ImageIO.read(url);
        setZoom(1);
    }
    public ImageComponent(String location) throws IOException {
        img = ImageIO.read(new File(location));
        setZoom(1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dim = getPreferredSize();
        g.drawImage(img, 0, 0, dim.width, dim.height, this);
    }

    public void setZoom(double zoom) {
        int w = (int) (zoom * img.getWidth());
        int h = (int) (zoom * img.getHeight());
        setPreferredSize(new Dimension(w, h));
        revalidate();
        repaint();
    }
}

}
