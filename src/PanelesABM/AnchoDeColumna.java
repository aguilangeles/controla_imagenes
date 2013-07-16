/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PanelesABM;

/**
 *
 * @author MUTNPROD003
 */
public class AnchoDeColumna {

    private int columna;
    private int size;

    public AnchoDeColumna(int columna, int size) {
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
