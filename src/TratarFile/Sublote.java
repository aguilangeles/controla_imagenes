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
  private List<Object> imagenList;

  public Sublote(int id, int idtraza, String nombre, int estado, List<ImagenInsertada> imagenes, int tamanio) {
    this.id = id;
    this.idtraza = idtraza;
    this.nombre = nombre;
    this.estado = estado;
    this.imagenes = imagenes;
    this.tamanio = tamanio;
  }

  public Sublote(int id, int idtraza, String nombre, int estado, int tamanio, List<Object> imagenList) {
    this.id = id;
    this.idtraza = idtraza;
    this.nombre = nombre;
    this.estado = estado;
    this.tamanio = tamanio;
    this.imagenList = imagenList;
  }

  public List<Object> getImagenList() {
    return imagenList;
  }

  public void setImagenList(List<Object> imagenList) {
    this.imagenList = imagenList;
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

  public Sublote getSubloteByName(String name) {
    return null;
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
    return "Sublote{" + "id=" + id + ", idtraza=" + idtraza + ", nombre=" + nombre + ", estado=" + estado + ", imagenes=" + imagenes + ", tamanio=" + tamanio + ", imagenList=" + imagenList + '}';
  }

 
}
