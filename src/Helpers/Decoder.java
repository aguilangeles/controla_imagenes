/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Decoder extends URLDecoder {

  public Decoder() {
  }

  public static String decoder(String aString, String clase) {
    String ret = "";
    try
      {
      ret = URLDecoder.decode(aString, "UTF-8");
      } catch (UnsupportedEncodingException ex)
      {
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              clase,JOptionPane.ERROR_MESSAGE);
      }
    return ret;
  }
}
