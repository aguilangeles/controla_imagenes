/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TratarFile;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ImagenInsertada {

  private int id;
  private int idsubolote;
  private String nombre;
  private int pagina;
  private int estado;

  public ImagenInsertada(int id, int idsubolote, String nombre, int pagina, int estado) {
    this.id = id;
    this.idsubolote = idsubolote;
    this.nombre = nombre;
    this.pagina = pagina;
    this.estado = estado;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getIdsubolote() {
    return idsubolote;
  }

  public void setIdsubolote(int idsubolote) {
    this.idsubolote = idsubolote;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public int getPagina() {
    return pagina;
  }

  public void setPagina(int pagina) {
    this.pagina = pagina;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  @Override
  public String toString() {
    return "\nid=" + id
            + "\n idsubolote=" + idsubolote
            + "\n nombre=" + nombre
            + "\n  pagina=" + pagina
            + "\n  estado=" + estado
            + "\n ";
  }
}
