/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import javax.swing.JComponent;
import javax.swing.JTextField;

/**
 *
 * @author MUTNPROD003
 */
public class InputVerifier {

    public InputVerifier() {
       // inputVerifierT();
    }
       public javax.swing.InputVerifier inputVerifierT() {
        javax.swing.InputVerifier inputV = new javax.swing.InputVerifier() {
            @Override
            public boolean verify(JComponent input) {
                JTextField text = (JTextField) input;
                String cadena = text.getText();
                if (cadena.equals("")) {
                    return false;
                } else {
                    return true;
                }
            }
        };
        return inputV;

    }
}
