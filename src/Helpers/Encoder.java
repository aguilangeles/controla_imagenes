/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
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
      JOptionPane.showMessageDialog(null, ex.getMessage(),
              clase, JOptionPane.ERROR_MESSAGE);
      }
    return ret;
  }
}
