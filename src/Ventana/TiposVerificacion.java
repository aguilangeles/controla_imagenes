/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Ventana;

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
    private List<TiposControlVf> listaControles;

    public TiposVerificacion(int id, String nombre, String descripcion, int estado, List<TiposControlVf> listaControles) {
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

    public List<TiposControlVf> getListaControles() {
        return listaControles;
    }

    public void setListaControles(List<TiposControlVf> listaControles) {
        this.listaControles = listaControles;
    }


    public static class TiposControlVf {

        private int control;
        private String descripcion;

        public TiposControlVf(int control, String descripcion) {
            this.control = control;
            this.descripcion = descripcion;
        }

        @Override
        public String toString() {
            return descripcion;
        }
    }
}
