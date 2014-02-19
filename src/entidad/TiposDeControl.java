/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

/**
 *
 * @author MUTNPROD003
 */
public class TiposDeControl extends Control {

  private int aId;
  private String aName;
  private boolean aCheck;

  public TiposDeControl(int id, String nombre, boolean check) {
    super(id, nombre, check);
    this.aId = getId();
    this.aName = getNombre();
    this.aCheck = isCheck();
  }

  public TiposDeControl(int id, String texto) {
    super(id, texto);
  }

  public String newToString() {
    return getId() + "-" + getTexto();
  }

  @Override
  public String toString() {
    return "TiposDeControl{" + "aId=" + aId + ", aName=" + aName + ", aCheck=" + aCheck + '}';
  }

}
