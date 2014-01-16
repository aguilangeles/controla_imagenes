/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import javax.swing.JOptionPane;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Encoder {

  public static String encoder(String aString, String clase) {
    String ret = "";
    try
      {
      ret = URLEncoder.encode(aString, "UTF-8");
      } catch (UnsupportedEncodingException ex)
      {
      new MensajeJoptionPane(null, JOptionPane.ERROR_MESSAGE).getMessage(aString, clase);
      }
    return ret;
  }
}
