/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class ColumnaTamanio {

  private int columna;
  private int tamanio;

  public ColumnaTamanio(int columna, int tamanio) {
    this.columna = columna;
    this.tamanio = tamanio;
  }

  public int getColumna() {
    return columna;
  }

  public int getTamanio() {
    return tamanio;
  }

  public void setColumna(int columna) {
    this.columna = columna;
  }

  public void setTamanio(int tamanio) {
    this.tamanio = tamanio;
  }
}
