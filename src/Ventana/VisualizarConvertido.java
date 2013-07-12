/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JScrollPane;

/**
 *
 * @author MUTNPROD003
 */
public final class VisualizarConvertido extends JComponent{


   private final BufferedImage img;

//    public ImageComponent(URL url) throws IOException {
//        img = ImageIO.read(url);
//        setZoom(1);
//    }
    public VisualizarConvertido(String location, double zoom, JScrollPane scrollPane) throws IOException {
        img = ImageIO.read(new File(location));
        setZoom(zoom, scrollPane);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dim = getPreferredSize();
        g.drawImage(img, 0, 0, dim.width, dim.height, this);
    }

    public void setZoom(double zoom , JScrollPane sp) {
        int w = (int) (zoom * img.getWidth());
        int h = (int) (zoom * img.getHeight());
        setPreferredSize(new Dimension(w, h));
        revalidate();
        repaint();
        sp.getViewport().revalidate();
    }


}
