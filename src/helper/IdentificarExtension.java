/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tratamientoruta.TipoDeImagen;



/**
 *
 * @author MUTNPROD003
 */
public final class IdentificarExtension {
    private static String extension;
    private static List<Object> listaExtension = new ArrayList<>();

    public IdentificarExtension(String ruta) {
        File file = new File(ruta);
        buscarExtensiones(file);
    }

    public IdentificarExtension(File aFile) {
        buscarExtensiones(aFile);
    }

    private static void buscarExtensiones(File aFile) {
        File[] files = aFile.listFiles();
        for (int x = 0; x < files.length; x++) {
            String name = files[x].getName();
            boolean ext = (name.endsWith(".tif")
                    || name.endsWith(".pdf")
                    || name.endsWith(".jpg")
                    || name.endsWith(".png")) ? true : false;
            if (files[x].isDirectory()) {
                buscarExtensiones(files[x]);
            }
            if (ext) {
                TipoDeImagen stringImage = new TipoDeImagen(name);
                extension = (stringImage.getExtension());
                listaExtension.add(files[x].getAbsolutePath());
            }
        }
    }

    public static String getExtension() {
        return extension;
    }
    public static List<Object> getLista() {
        return listaExtension;
    }
    public static void setLista(List<Object> lista) {
        IdentificarExtension.listaExtension = lista;
    }
}
