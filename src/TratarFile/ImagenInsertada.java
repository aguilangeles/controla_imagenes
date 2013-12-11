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

  private int idsubolote;
  private String nombre;
  private int pagina;

  public ImagenInsertada(int idsubolote, String nombre, int pagina) {
    this.idsubolote = idsubolote;
    this.nombre = nombre;
    this.pagina = pagina;
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

  @Override
  public String toString() {
    return "\n idsubolote=" + idsubolote
            + "\n nombre=" + nombre
            + "\n  pagina=" + pagina
            + "\n ";
  }
}
