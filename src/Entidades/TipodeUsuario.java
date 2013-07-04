/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import Helpers.Time;

/**
 *
 * @author MUTNPROD003
 */
public class TipodeUsuario {
    private int id;
    private String nombre;
    private String passw;
    private int tipoUsuario;
    private boolean admin;
    private int estado;
    private boolean activo;
    private String fechaUltimoIngreso;

    public TipodeUsuario(int id, String nombre, String passw, int tipoUsuario, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.passw = passw;
        this.tipoUsuario = tipoUsuario;
        this.admin=(tipoUsuario==1)?true:false;
        this.estado = estado;
        this.activo = (estado==1)?true:false;
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
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
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

    @Override
    public String toString() {
        return "TipodeUsuario{" + "id=" + id + ", nombre=" + nombre + ", passw=" + passw + ", admin=" + admin + ", activo=" + activo + ", fechaUltimoIngreso=" + getFechaUltimoIngreso() + '}';
    }



}
