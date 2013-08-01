/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import com.sun.media.jai.codec.ByteArraySeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.SeekableStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.imageio.ImageIO;
import javax.media.jai.PlanarImage;
import javax.swing.*;

public final class ImageComponent extends JComponent {

   final BufferedImage img;
  private Dimension dim;

  public ImageComponent() {
    img = null;
  }

  public ImageComponent(Image image) {
    img = (BufferedImage) image;
  }

  public ImageComponent(String location, double zoom, JScrollPane scrollPane, boolean pdf) throws Exception  {
//    img = (BufferedImage) leerImagen(location);
    img= (BufferedImage) ImageIO.read(new File(location));
    setZoom(zoom, scrollPane);

  }

  static Image load(byte[] data) throws Exception {
    Image image;
    SeekableStream stream = new ByteArraySeekableStream(data);
    String[] names = ImageCodec.getDecoderNames(stream);
    ImageDecoder dec =
            ImageCodec.createImageDecoder(names[0], stream, null);
    RenderedImage im = dec.decodeAsRenderedImage();
    image = PlanarImage.wrapRenderedImage(im).getAsBufferedImage();
    image.flush();
    System.gc();
    return image;
  }

  public Image leerImagen(String location) throws Exception {
     ByteBuffer buffer;
     try (FileInputStream in = new FileInputStream(location)) {
       FileChannel channel = in.getChannel();
       buffer = ByteBuffer.allocate((int) channel.size());
       buffer.clear();
       channel.read(buffer);
     }
    return load(buffer.array());
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    dim = getPreferredSize();
//aca trae el problema
    g.drawImage(img, 0, 0, dim.width, dim.height, this);

    g.dispose();
  }

    public void setZoom(double zoom,  JScrollPane sp) {
    int w = (int) (zoom * img.getWidth());
    int h = (int) (zoom * img.getHeight());
    setPreferredSize(new Dimension(w, h));
    revalidate();
    repaint();
    sp.getViewport().revalidate();
  }

}


