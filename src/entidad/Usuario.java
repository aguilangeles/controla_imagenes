/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad;

import Helpers.Time;

/**
 *define el tipo de usuario que ingreso al sistema.
 * @author MUTNPROD003
 */
public class Usuario {

  private int id;
  private String nombre;
  private String password;
  private int categoria;
  private String fechaUltimoIngreso;
  private int estado;
  private boolean administrador;
  private boolean activo;

  public Usuario(int id, String nombre, String password, int categoria, int estado) {
    this.id = id;
    this.nombre = nombre;
    this.password = password;
    this.categoria = categoria;
    this.estado = estado;
    administrador = (categoria == 1) ? true : false;
    activo = (estado == 1) ? true : false;
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

  public String getPassw() {
    return password;
  }

  public void setPassw(String passw) {
    this.password = passw;
  }

  public int getTipoUsuario() {
    return categoria;
  }

  public void setTipoUsuario(int tipoUsuario) {
    this.categoria = tipoUsuario;
  }

  public boolean isAdmin() {
    return administrador;
  }

  public final void setAdmin(boolean admin) {
    administrador = admin;
  }

  public int getEstado() {
    return estado;
  }

  public void setEstado(int estado) {
    this.estado = estado;
  }

  public boolean isActivo() {
    return activo;
  }

  public void setActivo(boolean activo) {
    this.activo = activo;
  }

  public String getFechaUltimoIngreso() {
    Time time = new Time();
    return time.getDatetime();
  }
  public void setFechaUltimoIngreso(String fechaUltimoIngreso) {
    this.fechaUltimoIngreso = fechaUltimoIngreso;
  }
}
