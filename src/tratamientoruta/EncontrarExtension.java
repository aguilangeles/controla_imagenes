/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

import java.io.File;


/**
 *
 * @author MUTNPROD003
 */
public final class EncontrarExtension {

    private static String extension;

    public EncontrarExtension(String ruta) {
        File f = new File(ruta);
        findExtension(f);
    }

    public EncontrarExtension(File f) {
        findExtension(f);
    }


    private static void findExtension(File f) {
        File[] files = f.listFiles();
        for (int x = 0; x < files.length; x++) {
            String name = files[x].getName();
            boolean fin = (name.endsWith(".tif")
                    || name.endsWith(".pdf")
                    || name.endsWith(".jpg")
                    || name.endsWith(".png")) ? true : false;
            if (files[x].isDirectory()) {
                findExtension(files[x]);
            }
            if (fin) {
                StringImage stringImage = new StringImage(name);
                extension = (stringImage.getExtension());
            }
        }
    }

    public static String getExtension() {
        return extension;
    }


}
