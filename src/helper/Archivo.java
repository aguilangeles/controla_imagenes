/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import writeproperties.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class Archivo {
    private Conexion conexion;
    private int id = 1;
    private String ruta;
    private int page;

    public Archivo(writeproperties.Conexion conexion, int id, String ruta, int page) {
        this.conexion = conexion;
        this.id += id;
        this.ruta = ruta;
        this.page=page;
        archivo_Insertar();
    }

    private void archivo_Insertar() {
        String ret = "";
        int estado = 0;
        ret = "Insert into qualitys.archivo (idTraza, ruta_archivo, pagina_pdf, estado)"
                + " VALUES (" + id + ", '" + ruta + "' ," +page+ " ," + estado + ");";
        conexion.executeUpdate(ret);
    }
}
