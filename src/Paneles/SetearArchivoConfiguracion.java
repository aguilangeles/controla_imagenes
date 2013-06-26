/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Paneles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author MUTNPROD003
 */
public class SetearArchivoConfiguracion {
    
    private String url;
    private String database;
    private String user;
    private String password;
    private static final String CONFIG = "config.properties";
    private Properties properties = new Properties();

    public SetearArchivoConfiguracion() {
        setearArchivoConfiguracion();
    }

    public SetearArchivoConfiguracion(String url, String database, String user, String password) {
        this.url = url;
        this.database = database;
        this.user = user;
        this.password = password;
        setearDesdeTextField();
    }



    private void setearArchivoConfiguracion() {
        try {
            properties.setProperty("url", "");
            properties.setProperty("database", "");
            properties.setProperty("dbuser", "");
            properties.setProperty("dbpassword", "");
            properties.store(new FileOutputStream(CONFIG), null);
            java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    new ValidarUsuario().setVisible(true);
                }
            });
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    private void setearDesdeTextField() {
        try {
            properties.setProperty("url", url);
            properties.setProperty("database", database);
            properties.setProperty("dbuser", user);
            properties.setProperty("dbpassword", password);
            properties.store(new FileOutputStream(CONFIG), null);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
