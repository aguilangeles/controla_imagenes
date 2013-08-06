/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class TiposConCheck {

  private int id;
  private String nombre;
  private boolean check;
  private String texto;
  private String imagen;

  public TiposConCheck(int id, String nombre, boolean check) {
    this.id = id;
    this.nombre = nombre;
    this.check = check;
  }

  public TiposConCheck(int id, String nombre, boolean check, String texto, String imagen) {
    this.id = id;
    this.nombre = nombre;
    this.check = check;
    this.texto = texto;
    this.imagen = imagen;
  }

  public boolean isCheck() {
    return check;
  }

  public void setCheck(boolean check) {
    this.check = check;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getTexto() {
    return texto;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  @Override
  public String toString() {
    return "Tipos{" + "id=" + id + ", nombre=" + nombre + ", check=" + check + ", texto=" + texto + ", imagen=" + imagen + '}';
  }
}