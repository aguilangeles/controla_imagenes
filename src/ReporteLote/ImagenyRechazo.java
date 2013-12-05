/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ReporteLote;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aguilangeles@gmail.com
 */
public class ImagenyRechazo {

  private int id;
  private String imagen;
  private int pagina;
  private List<String> controles = new ArrayList<>();

  public ImagenyRechazo(int id, String imagen, int pagina) {
    this.id = id;
    this.imagen = imagen;
    this.pagina = pagina;
  }

  public int getId() {
    return id;
  }

  public String getImagen() {
    return imagen;
  }

  public void setImagen(String imagen) {
    this.imagen = imagen;
  }

  public int getPagina() {
    return pagina;
  }

  public void setPagina(int pagina) {
    this.pagina = pagina;
  }

  public List<String> getControles() {
    return controles;
  }

  public void setControles(List<String> controles) {
    this.controles = controles;
  }

  @Override
  public String toString() {
    return imagen + ", pagina=" + pagina
            + "\ncontroles=" + controles;
  }
}
