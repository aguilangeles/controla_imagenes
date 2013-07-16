/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package necesitoUnMilagro;

import Entidades.Conexion;

/**
 *
 * @author MUTNPROD003
 */
public class UpdateChecs {
    private int estado;
    private boolean end = false;
    private int idtrazaArchivo;

    public UpdateChecs(int estado, int idtrazaArchivo) {
        this.estado = estado;
        this.idtrazaArchivo = idtrazaArchivo;
    }

    public void update() {

        Conexion conexion = new Conexion();
        if (conexion.isConexion()) {
            String update = "UPDATE traza_archivo_controles SET estado = " + estado + " WHERE id= " + idtrazaArchivo + ";";
            conexion.executeUpdate(update);
            conexion.desconectar();

        }
    }

    public void updateEstadoArchivo(int id) {
        //ersto lo hace bien
        Conexion conexion = new Conexion();
        if (conexion.isConexion()) {
            String update = "UPDATE archivo SET estado =  1 WHERE id = " + id + ";";
            conexion.executeUpdate(update);
            conexion.desconectar();
        }
    }
}
