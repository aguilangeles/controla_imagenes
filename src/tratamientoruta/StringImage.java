/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package tratamientoruta;

/**
 *
 * @author MUTNPROD003
 */
public class StringImage {

    private String extension;

    public StringImage(String extension) {
        this.extension = extension;
    }

    public String getExtension() {
        String ret = "";
        if (extension.endsWith(".tif")) {
            ret = ".tif";
        } else if (extension.endsWith(".pdf")) {
            ret = ".pdf";
        } else if (extension.endsWith(".jpg")) {
            ret = ".jpg";
        } else if (extension.endsWith(".png")) {
            ret = ".png";
        }
        return ret;
    }

    @Override
    public String toString() {
        return extension ;
    }

}
