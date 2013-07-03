/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.io.File;

/**
 *
 * @author MUTNPROD003
 */
public class BorrarJPG {

    public BorrarJPG() {
    }

    public static void borrarDirectorio(File directorio) {
        File[] files = directorio.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.println("primero\t"+files[i].getName());
                files[i].delete();
            }
        }
    }
}
