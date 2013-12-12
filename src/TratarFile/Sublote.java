/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

import java.util.List;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class Sublote {

  private int id;
  private int idtraza;
  private String nombre;
  private int estado;
  private List<ImagenInsertada> imagenes;
  private int tamanio;

  public Sublote(int id, int idtraza, String nombre, int estado, List<ImagenInsertada> imagenes, int tamanio) {
    this.id = id;
    this.idtraza = idtraza;
    this.nombre = nombre;
    this.estado = estado;
    this.imagenes = imagenes;
    this.tamanio = tamanio;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdtraza() {
    return idtraza;
  }

  public void setIdtraza(int idtraza) {
    this.idtraza = idtraza;
  }

  public String getNombre() {
    String replace = nombre.replace("\\", "\\\\");
    return replace;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public List<ImagenInsertada> getImagenes() {
    return imagenes;
  }

  public void setImagenes(List<ImagenInsertada> imagenes) {
    this.imagenes = imagenes;
  }

  public int getTamanio() {
    return tamanio;
  }

  public void setTamanio(int tamanio) {
    this.tamanio = tamanio;
  }

  @Override
  public String toString() {
    return "Sublote{"
            + "id=" + id
            + "\n idtraza=" + idtraza
            + "\n nombre=" + nombre
            + "\n estado=" + estado
            + "\n\t imagenes=" + imagenes
            + "\n tamanio=" + tamanio
            + '}';
  }
}
