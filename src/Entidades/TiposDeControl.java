/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class TiposDeControl extends Control {

  public TiposDeControl(int id, String nombre, boolean check, String texto, String imagen) {
    super(id, nombre, check, texto, imagen);
  }

  public TiposDeControl(int id, String texto) {
    super(id, texto);
  }


public String newToString(){
  return getId()+"-"+getTexto();
}

  @Override
  public String toString() {
    return getTexto();
  }
}