/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author MUTNPROD003
 */
public class NombrePaginaDelPDF {

  private String nombre;//nombre
  private int pagina;

  public NombrePaginaDelPDF(String nombre, int pagina) {
    this.nombre = nombre;
    this.pagina = pagina;
  }

  public int getNumeroPagina() {
    return pagina;
  }

  public String getNombre() {
    return nombre;
  }

  @Override
  public String toString() {
    return nombre + ": " + pagina;
  }
}
