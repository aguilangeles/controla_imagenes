/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package files;

import helper.GetExtensionNoDeseada;
import helper.GetIdandExtensionImg;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class SearchImagesFromFiles {

    private JLabel infoLabel;
    private List<Object> imageList = new ArrayList<>();

    public SearchImagesFromFiles(JLabel infoLabel, File file) {
        this.infoLabel = infoLabel;
        buscarExtensiones(file);
    }

    private void buscarExtensiones(File aFile) {
        File[] files = aFile.listFiles();
        for (int x = 0; x < files.length; x++) {
            String name = files[x].getName();
            infoLabel.setText("Analizando..." + name);
            if (files[x].isDirectory()) {
                buscarExtensiones(files[x]);
            }
            extraerExtensionImagen(files[x]);
        }
    }

    private void extraerExtensionImagen(File file) {
        String fin = file.getName();
        System.out.println("Final " + fin);
        if (fin.contains(".")) {
            String[] spl = fin.split("\\.");
            String exts = spl[1];
            if (!GetExtensionNoDeseada.noDeseadosList().contains(exts)) {
                GetIdandExtensionImg extensionIdImagen = new GetIdandExtensionImg(exts);
                imageList.add(file.getAbsolutePath());
                Collections.shuffle(imageList);
            }
        }
    }

    public List<Object> getImageList() {
        return imageList;
    }
}
