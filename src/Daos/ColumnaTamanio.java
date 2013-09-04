/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Daos;

/**
 *
 * @author MUTNPROD003
 */
public class ColumnaTamanio {

    private int columna;
    private int size;

    public ColumnaTamanio(int columna, int size) {
        this.columna = columna;
        this.size = size;
    }

    public int getColumna() {
        return columna;
    }

    public int getSize() {
        return size;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
