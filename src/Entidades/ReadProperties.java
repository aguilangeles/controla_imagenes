/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author MUTNPROD003
 */
public class ReadProperties {


    public Usuario getUser() {
        Usuario user = null;
        FileInputStream in=null;
        try {
            Properties p = new Properties();
             in = new FileInputStream("config.properties");
            p.load(in);
            String url = p.getProperty("url");
            String base = p.getProperty("database");
            String usuario = p.getProperty("dbuser");
            String password = p.getProperty("dbpassword");
            user = new Usuario(url, base, usuario, password);


        } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Read Properties", JOptionPane.ERROR_MESSAGE);

//            Logger.getLogger(ReadProperties.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if(in!=null){
                try {
                    in.close();
                    super.finalize();
                } catch (IOException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Read Properties finally", JOptionPane.ERROR_MESSAGE);

//                    Logger.getLogger(ReadProperties.class.getName()).log(Level.SEVERE, null, ex);
                } catch (Throwable ex) {
                    Logger.getLogger(ReadProperties.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        return user;
    }

}
