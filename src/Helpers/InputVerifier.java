/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 * No permite perder el foco si no se ha escrito nada en los JTextField
 *
 * @author MUTNPROD003
 */
public class InputVerifier {

  public InputVerifier() {
  }

  public javax.swing.InputVerifier inputVerifierT() {
    javax.swing.InputVerifier inputVerifier = new javax.swing.InputVerifier() {
      @Override
      public boolean verify(JComponent input) {
        JTextField text = (JTextField) input;
        String cadena = text.getText();
        if (cadena.equals(""))
          {
          return false;
          } else

          {
          return true;
          }
      }
    };
    return inputVerifier;
  }
}
