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
public final class FindParent {

    private File f;

    public FindParent(File f) {
        this.f = f;
    }

    public String findParent() {
        File[] files = f.listFiles();
        String ret = (files[0].getParent());
        for (int x = 0; x < files.length; x++) {
            if (files[x].isDirectory()) {
            }
        }
        return ret;
    }
}
