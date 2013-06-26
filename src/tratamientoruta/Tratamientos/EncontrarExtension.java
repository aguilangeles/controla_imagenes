/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta.Tratamientos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tratamientoruta.StringImage;


/**
 *
 * @author MUTNPROD003
 */
public final class EncontrarExtension {

    private static String extension;
    private static List<Object> lista = new ArrayList<>();

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
                lista.add(files[x].getAbsolutePath());
            }
        }
    }


    public static String getExtension() {
        return extension;
    }

    public static List<Object> getLista() {
        return lista;
    }

    public static void setLista(List<Object> lista) {
        EncontrarExtension.lista = lista;
    }


}
