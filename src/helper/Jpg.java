/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

/**
 *
 * @author MUTNPROD003
 */
public class Jpg {

    private String nombre;
    private String parent;
    private int numero;

    public Jpg(String nombre, String parent, int numero) {
        this.nombre = nombre;
        this.parent = parent;
        this.numero = numero;
    }

    public String jpgFile() {
        String ret = nombre.substring(parent.length(), nombre.length() - 4) + "_" + numero;
        String ruta_file_jpg = ret.replace("\\", "_");
        return ruta_file_jpg;
    }
}
