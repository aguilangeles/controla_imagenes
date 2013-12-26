/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.swing.JOptionPane;

/**
 * Genera una ruta para la imagen temporal del pdf convertido en png
 *
 * @author MUTNPROD003
 */
public class ExtensionTemporal {

  private String rutaTemporal;
  private String aParent;

  public ExtensionTemporal(String nombre, String parent, int numero) {
    this.aParent = decoder(parent);
    String ret = nombre.substring(aParent.length(), nombre.length() - 4) + "_" + numero;
    this.rutaTemporal = ret.replace("\\", "_");
  }

  private String decoder(String sString) {
    String ret = "";
    try
      {
      ret = URLDecoder.decode(sString, "UTF-8");
      } catch (UnsupportedEncodingException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              "Extension Temporal: encoding", JOptionPane.ERROR_MESSAGE);
      }
    return ret;
  }

  public String getRutaTemporal() {
    return rutaTemporal;
  }
}
