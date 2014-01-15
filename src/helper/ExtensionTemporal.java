/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.swing.JOptionPane;

/**
 * Genera una ruta para la imagen temporal del pdf convertido en png
 *
 * @author MUTNPROD003
 */
public class ExtensionTemporal {

  private static final String className = ExtensionTemporal.class.getName();
  private int type = JOptionPane.ERROR_MESSAGE;
  private MensajeJoptionPane msg = new MensajeJoptionPane(null, type);
  private String rutaTemporal;
  private String aParent;

  public ExtensionTemporal(String nombre, String parent, int numero) {
    this.aParent = Decoder.decoder(parent, className);
    String ret = nombre.substring(aParent.length(), nombre.length() - 4) + "_" + numero;
    this.rutaTemporal = ret.replace("\\", "_");

  }

  public String getRutaTemporal() {
    return rutaTemporal;
  }
}
