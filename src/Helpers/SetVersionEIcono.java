/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author maria
 */
public final class SetVersionEIcono extends JFrame {

    public static final String VERSION = "Qualitys 1.0.01";

    public SetVersionEIcono() {

    }

    public SetVersionEIcono(JFrame frame) {
        setImagenIcon(frame);
        frame.setTitle(VERSION);
    }


    public SetVersionEIcono(JFrame frame, String mensaje) {
        setImagenIcon(frame);
        frame.setTitle(mensaje+" "+VERSION);
    }



    public void setImagenIcon(JFrame frame) {
        String rutaImagen = "Logos\\nuevo logo sin letras UTN.png";
        ImageIcon im = new ImageIcon(rutaImagen);
        setIconImage(im.getImage());
        frame.setIconImage(im.getImage());
    }
}
