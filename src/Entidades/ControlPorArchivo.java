/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author MUTNPROD003
 */
public class ControlPorArchivo {
    private int idImagen;
    private int idTrazaArchivoControl;
    private int idControl;
    private String descripcion;
    private boolean check;
    private int estado;

    public ControlPorArchivo(int idImagen,int idTrazaArchivoControl,int idControl, String descripcion, boolean check) {
        this.idImagen=idImagen;
        this.idTrazaArchivoControl = idTrazaArchivoControl;
        this.idControl=idControl;
        this.descripcion = descripcion;
        this.check = check;
    }

    public int getIdTif() {
        return idImagen;
    }

    public void setIdTif(int idTif) {
        this.idImagen = idTif;
    }


    public int getIdControl() {
        return idControl;
    }

    public void setIdControl(int idControl) {
        this.idControl = idControl;
    }

    public int getIdTrazaArchivoControl() {
        return idTrazaArchivoControl;
    }

    public void setIdTrazaArchivoControl(int idTrazaArchivoControl) {
        this.idTrazaArchivoControl = idTrazaArchivoControl;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public int getEstado() {
        int ret =(isCheck())?1:0;
        return ret;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Control{" + "idTrazaArchivoControl=" + idTrazaArchivoControl
                + ", idControl=" + idControl + ", descripcion=" + descripcion
                + ", check=" + check + ", estado=" + getEstado() + '}';
    }











}
