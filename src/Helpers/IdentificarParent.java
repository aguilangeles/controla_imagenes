/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Helpers;

import java.io.File;


/**
 *
 * @author MUTNPROD003
 */
public final class IdentificarParent {
    private String parent;
    
    public IdentificarParent(File file) {
        this.parent= encontrarParent(file);
    }

    private String encontrarParent(File file) {
        File[] files = file.listFiles();
        String ret = (files[0].getParent());
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
            }
        }
        return ret;
    }

    public String getParent() {
        return parent;
    }

}
