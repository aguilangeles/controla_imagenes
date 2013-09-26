/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package VentanaPrincipal;

import Entidades.Control;
import Entidades.TiposDeControl;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class TiposVerificacion extends Control {
  private int estado;
  private List<TiposDeControl> listaControles;

  public TiposVerificacion(int id, String nombre, String descripcion, int estado, List<TiposDeControl> listaControles) {
    super(id, nombre, descripcion);
    this.estado = estado;
    this.listaControles = listaControles;
  }

  @Override
  public int getId() {
    return id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String getNombre() {
    return nombre;
  }

  @Override
  public void setNombre(String nombre) {
    this.nombre = nombre;
    }

    public String getDescripcion() {
        return texto;
    }

    public void setDescripcion(String descripcion) {
        this.texto = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<TiposDeControl> getListaControles() {
        return listaControles;
    }

    public void setListaControles(List<TiposDeControl> listaControles) {
        this.listaControles = listaControles;
    }
}
