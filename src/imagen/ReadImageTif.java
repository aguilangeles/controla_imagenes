/* permite la apertura de imagenes Tif
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imagen;

import com.sun.media.jai.codec.ByteArraySeekableStream;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.SeekableStream;
import helper.MensajeJoptionPane;
import java.awt.*;
import java.awt.image.RenderedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.jai.PlanarImage;
import javax.swing.*;

public final class ReadImageTif extends JComponent {

  private static final String className = ReadImageTif.class.getName();
  private static int type = JOptionPane.ERROR_MESSAGE;
  static MensajeJoptionPane msg = new MensajeJoptionPane(null, type);

  public ReadImageTif() {
  }

  static Image imageTif(byte[] data) throws ArrayIndexOutOfBoundsException{
    SeekableStream stream = null;
    Image image = null;
    try
      {
      stream = new ByteArraySeekableStream(data);
      String[] names = ImageCodec.getDecoderNames(stream);
      
      ImageDecoder dec =
              ImageCodec.createImageDecoder(names[0], stream, null);
      RenderedImage im = dec.decodeAsRenderedImage();
      image = PlanarImage.wrapRenderedImage(im).getAsBufferedImage();
      image.flush();
      } catch (IOException ex)
      {
      msg.getMessage(ex.getMessage(), className);
      Logger.getLogger(ReadImageTif.class.getName()).log(Level.SEVERE, null, ex);
      } finally
      {
      try
        {
        stream.close();
        } catch (IOException ex)
        {
        msg.getMessage(ex.getMessage(), className);
        }
      }
    return image;
  }

  public Image getImagen(String location) throws FileNotFoundException, IOException, ArrayIndexOutOfBoundsException {
    ByteBuffer buffer;
   
      
    FileInputStream in = new FileInputStream(location);
    System.out.println("location"+ location);
    FileChannel channel = in.getChannel();
    buffer = ByteBuffer.allocate((int) channel.size());
    buffer.clear();
    channel.read(buffer);
   
    return imageTif(buffer.array());
  }
}
