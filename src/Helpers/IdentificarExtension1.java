/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import tratamientoruta.TipoDeImagen;

/**
 *
 * @author MUTNPROD003
 */
public  class IdentificarExtension1 {
    private  String extension;
    private  List<Object> listaExtension = new ArrayList<>();

    public IdentificarExtension1(String ruta) {
        File file = new File(ruta);
        buscarExtensiones(file);
    }

    public IdentificarExtension1(File aFile) {
        buscarExtensiones(aFile);
    }

    private  void buscarExtensiones(File aFile) {
        File[] files = aFile.listFiles();
        for (int x = 0; x < files.length; x++) {
            String name = files[x].getName();
            boolean ext = (name.endsWith(".tif")//
                    || name.endsWith(".pdf")
                    || name.endsWith(".jpg")
                    || name.endsWith(".png")) ? true : false;
            if (files[x].isDirectory()) {
                buscarExtensiones(files[x]);
            }
            if (ext) {
                TipoDeImagen stringImage = new TipoDeImagen(name);
                extension = (stringImage.getExtension());
                System.out.println(files[x].getAbsolutePath());
                listaExtension.add(files[x].getAbsolutePath());

            }
        }
    }

    public  String getExtension() {
        return extension;
    }
    public  List<Object> getLista() {
        return listaExtension;
    }
    public  void setLista(List<Object> lista) {
        listaExtension = lista;
    }
}
