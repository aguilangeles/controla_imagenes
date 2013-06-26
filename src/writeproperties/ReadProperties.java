/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package writeproperties;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MUTNPROD003
 */
public class ReadProperties {


    public Usuario getUser() {
        Usuario user = null;
        try {
            Properties p = new Properties();
            FileInputStream in = new FileInputStream("config.properties");
            p.load(in);
            String url = p.getProperty("url");
            String base = p.getProperty("database");
            String usuario = p.getProperty("dbuser");
            String password = p.getProperty("dbpassword");
            user = new Usuario(url, base, usuario, password);
            in.close();

        } catch (IOException ex) {
            Logger.getLogger(ReadProperties.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

}
