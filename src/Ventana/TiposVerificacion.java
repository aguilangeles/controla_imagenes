/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

import Daos.TiposDeControl;
import java.util.List;

/**
 *
 * @author MUTNPROD003
 */
public class TiposVerificacion {
    private int id;
    private String nombre;
    private String descripcion;
    private int estado;
    private List<TiposDeControl> listaControles;

    public TiposVerificacion(int id, String nombre, String descripcion, int estado, List<TiposDeControl> listaControles) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.estado = estado;
        this.listaControles = listaControles;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
