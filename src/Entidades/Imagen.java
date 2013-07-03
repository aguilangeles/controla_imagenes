/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author MUTNPROD003
 */
public class Imagen {

    private int id;
    private String ruta_archivo;
    private String parent;
    private int pagina;
    private String rutaTemp;
    private String rutaDb;
    private int estado;

    public Imagen(int id, String ruta_archivo, String parent, int pagina) {
        try {
            this.id = id;
            this.parent = parent;
            this.pagina = pagina;
            this.rutaDb = URLDecoder.decode(ruta_archivo, "UTF-8");
            this.ruta_archivo = URLDecoder.decode(parent + ruta_archivo, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Imagen(int id, String ruta_archivo, String parent) {
        try {
            this.id = id;
            this.parent = parent;
            this.rutaDb=URLDecoder.decode(ruta_archivo, "UTF-8");
            this.ruta_archivo = URLDecoder.decode(parent + ruta_archivo, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Imagen.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String getRutaDb() {
        return rutaDb;
    }

    public void setRutaDb(String rutaDb) {
        this.rutaDb = rutaDb;
    }

    public String getRutaTemp() {
        return rutaTemp;
    }
    public void setRutaTemp(String rutaTemp) {
        this.rutaTemp = rutaTemp;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getRuta_archivo() {
        return ruta_archivo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Imagen{" + "id=" + id + ", nombre=" + ruta_archivo + ", parent="
                + parent + ", numero=" + pagina + ", rutaTemp=" + rutaTemp + ", estado=" + estado + '}';
    }
}
