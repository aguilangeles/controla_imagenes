/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Control {

  protected boolean check;
  protected int id;
  protected String imagen;
  protected String nombre;
  protected String texto;

  public Control(int id, String nombre, boolean check, String texto, String imagen) {
    this.id = id;
    this.nombre = nombre;
    this.check = check;
    this.texto = texto;
    this.imagen = imagen;
  }

  public Control(int id, String nombre, boolean check) {

    this.id = id;
    this.nombre = nombre;
    this.check = check;
  }

  public Control(int id, String nombre, String texto) {
    this.id = id;
    this.nombre = nombre;
    this.texto = texto;
  }

  public Control(int id, String texto) {
    this.id = id;
    this.texto = texto;
  }

  public int getId() {
    return id;
  }

  public String getImagen() {
    return imagen;
  }

  public String getNombre() {
    return nombre;
  }

  public String getTexto() {
    return texto;
  }

  public boolean isCheck() {
    return check;
  }

  public void setCheck(boolean check) {
    this.check = check;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public void setTexto(String texto) {
    this.texto = texto;
  }

  @Override
  public String toString() {
    return "Tipos{" + "id=" + id + ", nombre=" + nombre + ", check=" + check + ", texto=" + texto + ", imagen=" + imagen + '}';
  }
}
