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
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import javax.media.jai.PlanarImage;
import javax.swing.*;

public final class ImageComponent extends JComponent {

  private final BufferedImage img;
  private Dimension dim;

  public ImageComponent() {
    img = null;
  }

  public ImageComponent(Image image) {
    img = (BufferedImage) image;
  }

  public ImageComponent(String location, double zoom, JScrollPane scrollPane) throws IOException, Exception {
    img = (BufferedImage) leerImagen(location);
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
    return image;
  }

  public Image leerImagen(String location) throws Exception {
    FileInputStream in = new FileInputStream(location);
    FileChannel channel = in.getChannel();
    ByteBuffer buffer = ByteBuffer.allocate((int) channel.size());
    channel.read(buffer);
    return load(buffer.array());
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    dim = getPreferredSize();
    g.drawImage(img, 0, 0, dim.width, dim.height, this);
  }

  public void setZoom(double zoom, JScrollPane sp) {
    int w = (int) (zoom * img.getWidth());
    int h = (int) (zoom * img.getHeight());
    setPreferredSize(new Dimension(w, h));
    revalidate();
    repaint();
    sp.getViewport().revalidate();
  }
}


