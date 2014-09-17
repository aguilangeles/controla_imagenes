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
  private String aTexto;
  private String aImage;

  public TiposDeControl(int id, String nombre, boolean check) {
    super(id, nombre, check);
    this.aId = getId();
    this.aName = getNombre();
    this.aCheck = isCheck();
  }

  public TiposDeControl(int id, String nombre, String texto, String imageName) {
    super(id, nombre, texto, imageName);
    this.aId = getId();
    this.nombre = getNombre();
    this.aTexto = getTexto();
    this.imagen = getImagen();
  }

  public TiposDeControl(int id, String texto) {
    
    super(id, texto);
    this.aId= id;
    this.aTexto=texto;
//    System.out.println(texto);
  }

  public String newToString() {
    return getId() + "-" + getTexto();
  }
  @Override
  public String toString() {
    return  aTexto ;
  }
  

}
