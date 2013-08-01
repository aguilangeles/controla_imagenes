/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class ExtensionTemporal {
    private String rutaTemporal;
    private String parent;

    public ExtensionTemporal(String nombre, String parent, int numero) {
        try {
            this.parent = URLDecoder.decode(parent, "UTF-8");
            String ret = nombre.substring(this.parent.length(), nombre.length() - 4) + "_" + numero;
            this.rutaTemporal =  ret.replace("\\", "_");
//            this.rutaTemporal = "temp\\" + ret.replace("\\", "_");
        } catch (UnsupportedEncodingException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Extension Temporal: encoding", JOptionPane.ERROR_MESSAGE);

//            Logger.getLogger(ExtensionTemporal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getRutaTemporal() {
        return rutaTemporal;
    }
}
